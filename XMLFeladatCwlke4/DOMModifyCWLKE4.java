package hu.domparse.cwlke4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMModifyCWLKE4 {
	public static void main(String args[]) throws ParserConfigurationException, IOException, SAXException, TransformerException {
	
		String filePath = "XMLCwlke4.xml";
		File xmlFile = new File(filePath);
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.parse(xmlFile);
			
			doc.getDocumentElement().normalize();
			
			gyogyszertarNevmodositas(doc);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Beolvassa az ID-t
	public static String ReadId() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Gyogyszertar Id: ");
		String id = sc.nextLine();
		return id;
	}
	
	//Kiírja az update-t
	public static void xmlFileIras(Document doc) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("src/hu/domparse/CWLKE4/XMLCwlke4.updated.xml"));
        transformer.transform(source, result);
	}
	
	//Beolvassuk az gyógyszeretár id-jét majd az ahhoz tartozó új értéket és meghívja az írás metódust
	public static void gyogyszertarNevmodositas(Document doc) throws TransformerException {
		
		System.out.println("Melyik gyógyszertár nevét írjuk át?");
		String idread = ReadId();

		Scanner sc = new Scanner(System.in);
		System.out.print("Új név: ");
		String gysztnev = sc.nextLine();

		NodeList nList = doc.getElementsByTagName("gyogyszertar");
		for (int i = 0; i < nList.getLength(); i++) {

			Node nNode = nList.item(i);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element element = (Element) nNode;

				String gysztid = element.getAttribute("id");

				if (gysztid.equals(idread)) {

					Node node1 = element.getElementsByTagName("nev").item(0);
					node1.setTextContent(gysztnev);

					System.out.println("Sikeres Modosítas");
					xmlFileIras(doc);
				}
			}
		}
	}
}
