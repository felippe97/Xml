package MyServer.CsvXml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Book {

	public static void main(String[] args) {
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
			// TODO: handle exception
		}
	}

	private static Object getBook(Document document, String id, String name, String gender, String price) {
		Element book = document.createElement("Book");
		book.setAttribute("id", id);
		book.appendChild(getfyBookElements(document, book, "Name", name));
		book.appendChild(getfyBookElements(document, book, "Gender", gender));
		book.appendChild(getfyBookElements(document, book, "Price", price));
		return book;
	}

	private static Node getfyBookElements(Document document, Element element, String name, String value) {
		Element node = document.createElement(name);
		node.appendChild(document.createTextNode(value));
		return node;
	}
}