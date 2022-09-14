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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import MyServer.book.Book;
import MyServer.csv.Csv;

public class Xml {

	public static void main(String[] args) throws TransformerFactoryConfigurationError, TransformerException,
			ParserConfigurationException, FileNotFoundException, IOException {

		Book book = new Book();

		String gender = book.getGende();
		String id = book.getId();
		String name = book.getName();
		String price = book.getPrice();

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();

		try {

			documentBuilder = builderFactory.newDocumentBuilder();

			Document document = documentBuilder.newDocument();
			Element docElement = document.createElement("books");
			document.appendChild(docElement);

			docElement.appendChild(getBook(document, id, name, gender, price));

			/*
			 * docElement.appendChild(getBooks(document, "1", "Kniha", "g1", "25"));
			 * docElement.appendChild(getBook(document, "2", "Kniha2", "g2", "40"));
			 * docElement.appendChild(getBook(document, "3", "Kniha3", "g3", "15"));
			 * docElement.appendChild(getBook(document, "4", "Kniha4", "g4", "10"));
			 */
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

		book.setAttribute("id", id);
		book.appendChild(getfyBookElements(document, book, "Name", name));
		book.appendChild(getfyBookElements(document, book, "Gender", gender));
		book.appendChild(getfyBookElements(document, book, "Price", price));
		return book;

	}

	/*
	 * private static Node getBook(Document document, String string, String Name,
	 * String Gender, String Price) { Element book = document.createElement("Book");
	 * book.setAttribute("id", string); book.appendChild(getfyBookElements(document,
	 * book, "Name", Name)); book.appendChild(getfyBookElements(document, book,
	 * "Gender", Gender)); book.appendChild(getfyBookElements(document, book,
	 * "Price", Price)); return book; }
	 */

	private static Node getfyBookElements(Document document, Element element, String name, String string) {
		Element node = document.createElement(name);
		node.appendChild(document.createTextNode(string));
		return node;
	}

}
