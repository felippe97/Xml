package MyServer.Xml;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import MyServer.book.Book;
import MyServer.csv.Csv;

public class Xml {

	private static String gender;
	private static String id;
	private static String name;
	private static String price;
	private static Logger log = LoggerFactory.getLogger(Xml.class);

	public static void main(String[] args) throws TransformerFactoryConfigurationError, TransformerException,
			ParserConfigurationException, FileNotFoundException, IOException {
		Csv csv = new Csv();
		Book book = new Book(id, name, gender, price);
		
		/*
		 * String gender = book.getGende(); String id = book.getId(); String name =
		 * book.getName(); String price = book.getPrice();
		 */

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		log.info(id);

		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();

		try {

			documentBuilder = builderFactory.newDocumentBuilder();

			Document document = documentBuilder.newDocument();
			Element docElement = document.createElement("books");
			document.appendChild(docElement);
			docElement.appendChild(getBook(document, "1", "Kniha", "g1", "25"));
			
			docElement.appendChild(getBook(document, csv.getId(), csv.getName(), csv.getGender(), csv.getPrice()));
		

			log.info(id);
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(document);
			StreamResult console = new StreamResult(System.out);
			transformer.transform(source, console);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();

		}

	}

	private static Node getBook(Document document, String id, String name, String gender, String price) {
		Element book = document.createElement("Books");
		Book books = new Book(id, name, gender, price);
		id=books.getId();
		name = books.getName();
		log.info("getBook  " + id + " " + name + " " + gender + " " + price);
		book.setAttribute("id", id);
		book.appendChild(getfyBookElements(document, book, "Name", name));
		book.appendChild(getfyBookElements(document, book, "Gender", gender));
		book.appendChild(getfyBookElements(document, book, "Price", price));
		return book;

	}


	private static Node getfyBookElements(Document document, Element element, String name, String string) {
		log.info("getfyBookElements  " + name);
		Element node = document.createElement(name);
		node.appendChild(document.createTextNode(string));
		return node;
	
	}

}
