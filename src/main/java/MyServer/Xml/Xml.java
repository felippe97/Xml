package MyServer.Xml;


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

import MyServer.csv.Csv;

public class Xml {
	public static void main(String[] args) throws TransformerFactoryConfigurationError, TransformerException, ParserConfigurationException {
Csv csv = new Csv();

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		try {
			documentBuilder = builderFactory.newDocumentBuilder();

			Document document = documentBuilder.newDocument();
			Element docElement = document.createElement("books");
			document.appendChild(docElement);

			docElement.appendChild(getBook(document, "1", "Kniha", "g1", "25"));
			docElement.appendChild(getBook(document, "2", "Kniha2", "g2", "40"));
			docElement.appendChild(getBook(document, "3", "Kniha3", "g3", "15"));
			docElement.appendChild(getBook(document, "4", "Kniha4", "g4", "10"));

			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource source = new DOMSource(document);
			StreamResult console = new StreamResult(System.out);
			transformer.transform(source, console);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();

		}

	}

	private static Node getBook(Document document, String string, String string2, String string3, String string4) {
		Element book = document.createElement("Book");
		book.setAttribute("id", string);
		book.appendChild(getfyBookElements(document, book, "Name", string2));
		book.appendChild(getfyBookElements(document, book, "Gender", string3));
		book.appendChild(getfyBookElements(document, book, "Price", string4));
		return book;
	}

	private static Node getfyBookElements(Document document, Element element, String name, String value) {
		Element node = document.createElement(name);
		node.appendChild(document.createTextNode(value));
		return node;
	}
}
