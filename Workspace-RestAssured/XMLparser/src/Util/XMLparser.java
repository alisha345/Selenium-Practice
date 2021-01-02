package Util;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;  
import java.io.File; 

import org.w3c.dom.Document;


public class XMLparser {

	public static void main(String[] args) {

		try {
			DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
			DocumentBuilder db = factory.newDocumentBuilder();
			
	
			Document doc =  db.parse("NewFile.xml");
			doc.getDocumentElement().normalize();  
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
			NodeList nodeList = doc.getElementsByTagName("student");  
			// nodeList is not iterable, so we are using for loop  
			for (int itr = 0; itr < nodeList.getLength(); itr++)   
			{  
			Node node = nodeList.item(itr);  
			System.out.println("Node Name :" + node.getNodeName());  
			if (node.getNodeType() == Node.ELEMENT_NODE)   
			{  
			Element eElement = (Element) node;  
			System.out.println("Student id: "+ eElement.getElementsByTagName("id").item(0).getTextContent());  
			System.out.println("First Name: "+ eElement.getElementsByTagName("firstname").item(0).getTextContent());  
			System.out.println("Last Name: "+ eElement.getElementsByTagName("lastname").item(0).getTextContent());  
			System.out.println("Subject: "+ eElement.getElementsByTagName("subject").item(0).getTextContent());  
			System.out.println("Marks: "+ eElement.getElementsByTagName("marks").item(0).getTextContent());  
			System.out.println();
			}  
			}  
			  
				
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}


}
