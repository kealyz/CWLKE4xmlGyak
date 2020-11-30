package hu.domparse.cwlke4;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import java.io.File;
import java.io.IOException;

public class DOMReadCWLKE4 {

	public static void main(String args[]) throws ParserConfigurationException, IOException, SAXException, TransformerException {
		try {
			File inputFile = new File("XMLCwlke4.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Gyökér elem :" + doc.getDocumentElement().getNodeName());
			System.out.println("----------------------------");
			
			NodeList nList = doc.getElementsByTagName("gyogyszertar");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				System.out.println("\nEntitás: " + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("Gyógyszertár id: " + eElement.getAttribute("id"));
					System.out.println("Gyógyszertár neve: " + eElement.getElementsByTagName("nev").item(0).getTextContent());
					System.out.println("Település: " + eElement.getElementsByTagName("telepules").item(0).getTextContent());
					System.out.println("Irányítószám: " + eElement.getElementsByTagName("iranyitoszam").item(0).getTextContent());
					System.out.println("Utca: " + eElement.getElementsByTagName("utca").item(0).getTextContent());
				}
			}
			
			nList = doc.getElementsByTagName("gyogyszer");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				System.out.println("\nEntitás: " + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("Gyógyszer id: " + eElement.getAttribute("id"));
					System.out.println("Gyógyszer kód: " + eElement.getAttribute("kod"));
					System.out.println("Gyógyszer neve: " + eElement.getElementsByTagName("nev").item(0).getTextContent());
				}
			}
			
			nList = doc.getElementsByTagName("gyogyszeresz");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				System.out.println("\nEntitás: " + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("Gyógyszerész id: " + eElement.getAttribute("id"));
					System.out.println("Gyógyszerész neve: " + eElement.getAttribute("nev"));
					System.out.println("Elérhetőség: " + eElement.getAttribute("elerhetoseg"));	
				}
			}

			nList = doc.getElementsByTagName("beszallito");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				System.out.println("\nEntitás: " + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("Beszállító Id : " + eElement.getAttribute("id"));
					System.out.println("Beszállító neve: " + eElement.getElementsByTagName("nev").item(0).getTextContent());
					System.out.println("Elérhetőség: " + eElement.getElementsByTagName("elerhetoseg").item(0).getTextContent());
					System.out.println("Cím: " + eElement.getElementsByTagName("cim").item(0).getTextContent());			
				}
			}
			
			nList = doc.getElementsByTagName("beszallit");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				System.out.println("\nEntitás:" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("Beszállító id : " + eElement.getAttribute("bszid"));
					System.out.println("Gyógyszertár id : " + eElement.getAttribute("gysztid"));
					System.out.println("Darabszám: " + eElement.getElementsByTagName("darab").item(0).getTextContent());
					System.out.println("Gyógyszerkód: " + eElement.getElementsByTagName("gyogyszerkod").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
