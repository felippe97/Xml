package MyServer.Xml;

import com.opencsv.exceptions.CsvException;
import MyServer.csv.Csv;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Xml {

	public static void main(String[] args)throws ClassNotFoundException, CsvException {

		
try {
			
			Csv.convert(args[0], args[1], getClassFromFile(args[2]));
			TransformerFactory tfactory = TransformerFactory.newInstance();
			Transformer xform = tfactory.newTransformer(new StreamSource(args[3]));
			xform.transform(new StreamSource(args[1]),new StreamResult(args[4]));
			
		} catch (NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| IOException | TransformerException e) {
			e.printStackTrace();
		}

	}

	public static Class getClassFromFile(String classPath) throws ClassNotFoundException, IOException {
		Path path = Paths.get(classPath);
	    URLClassLoader loader = new URLClassLoader(new URL[] {
	          path.toUri().toURL()
	    });
	    Class c = loader.loadClass("csv_to_xml.Book");
	    loader.close();
	    return c;
	}
		
		
		
		
		
		
/*		Csv csvFile = new Csv();
		
		
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
	}*/



	/*
	 * private static Object getBook(Document document, String id, String name,
	 * String gender, String price) { Element book = document.createElement("Book");
	 * book.setAttribute("id", id); book.appendChild(getfyBookElements(document,
	 * book, "Name", name)); book.appendChild(getfyBookElements(document, book,
	 * "Gender", gender)); book.appendChild(getfyBookElements(document, book,
	 * "Price", price)); return book; }
	 */

	/*
	 * private static Node getfyBookElements(Document document, Element element,
	 * String name, String value) { Element node = document.createElement(name);
	 * node.appendChild(document.createTextNode(value)); return node; }
	 */
}

	
