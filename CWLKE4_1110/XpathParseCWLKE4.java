package hu.meiit.xpathparsecwlke4;

public class XpathParseCWLKE4 
{
	public static void main(String[] args)
	{
		try
		{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			Document doc = dBuilder.parse("studentCWLKE4.xml");
			
			doc.getDocumentElement().normalize();
			
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByeTagName("student");
			System.out.println("-----------------");
			
			for (int temp = 0; temp < nList.getLength();temp++)
			{
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element: " + nNode.getNodeName());
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element eElement = (Element) nNode;
					System.out.println("Student roll no: " + eElement.getAttribute("rollno"));
					
					System.out.println("First Name: "
						+ eElement
						.getElementsByeTagName("firstname")
						.item(0)
						.getTextContent());
					System.out.println("Last Name: "
						+ eElement
						.getElementsByeTagName("lastname")
						.item(0)
						.getTextContent());
					System.out.println("Nick Name: "
						+ eElement
						.getElementsByeTagName("nickname")
						.item(0)
						.getTextContent());
					System.out.println("Marks: "
						+ eElement
						.getElementsByeTagName("marks")
						.item(0)
						.getTextContent());
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}