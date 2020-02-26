package testPack;

import java.io.File;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class XmlControl {

	
	public XmlControl() {}
	public void doStuff() 
	{
	    try
	    {
	        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	        Document doc = docBuilder.newDocument();
	        // students root element
	        Element rootElement = doc.createElement("students");
	        doc.appendChild(rootElement);
	        
	        // student elements
	        for(int i=1; i<=3; i++)
	        {
	            Element student = doc.createElement("student");
	            
	            Element studentName = doc.createElement("name");
	            studentName.setTextContent("Hussein " + i);
	            
	            student.setAttribute("id", String.valueOf(i));
	            student.appendChild(studentName);
	            
	            rootElement.appendChild(student);
	        }
	        
	        // Write the content into XML file
	        DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult(new File("students-new.xml"));
	        
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        // Beautify the format of the resulted XML
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
	        transformer.transform(source, result);
	    }
	    catch(Exception ex)
	    {
	        ex.printStackTrace();
	    }
	}
	

}
