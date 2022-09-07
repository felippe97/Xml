package MyServer.Xml;

import com.opencsv.exceptions.CsvException;
import MyServer.csv.Csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


		
		
		
		
		
		
		Csv csvFile = new Csv();
		
		
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

		DocumentBuilder documentBuilder;
		try {
			documentBuilder = builderFactory.newDocumentBuilder();

			Document document = documentBuilder.newDocument();
			Element docElement = document.createElement("Book");
			document.appendChild(docElement);
		
				
			
			
			
			  docElement.appendChild((Node) getBook(document, "1", "Kniha", "g1", "25"));
			  docElement.appendChild((Node) getBook(document, "2", "Kniha2", "g2", "40"));
			  docElement.appendChild((Node) getBook(document, "3", "Kniha3", "g3", "15"));
			  docElement.appendChild((Node) getBook(document, "4", "Kniha4", "g4", "10"));
			 
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource source = new DOMSource(document);
			StreamResult console = new StreamResult(System.out);
			transformer.transform(source, console);

		} catch (TransformerException | ParserConfigurationException e) {
			e.printStackTrace();
			
		}
	}



	
	  private static Object getBook(Document document, String id, String name,
	  String gender, String price) { Element book = document.createElement("Book");
	  book.setAttribute("id", id); book.appendChild(getfyBookElements(document,
	  book, "Name", name)); book.appendChild(getfyBookElements(document, book,
	  "Gender", gender)); book.appendChild(getfyBookElements(document, book,
	  "Price", price)); return book; }
	 

	
	  private static Node getfyBookElements(Document document, Element element,
	  String name, String value) { Element node = document.createElement(name);
	  node.appendChild(document.createTextNode(value)); return node; }
	 
}

	
