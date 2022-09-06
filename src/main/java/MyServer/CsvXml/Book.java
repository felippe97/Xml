package MyServer.CsvXml;

import org.w3c.dom.Document ;
import org.w3c.dom.Element ;
import org.w3c.dom.Node ;
import javax.xml.parsers.DocumentBuilder ;
import javax.xml.parsers.DocumentBuilderFactory ;
import javax.xml.transform.OutputKeys ;
import javax.xml.transform.Transformer ;
import javax.xml.transform.TransformerFactory ;
import javax.xml.transform.dom.DOMSource ;
import javax.xml.transform.stream.StreamResult ;

public class Book {

	public static void main(String[] args) {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder documentBuilder;
		try {
			documentBuilder = builderFactory.newDocumentBuilder();
			
			  Document document = documentBuilder.newDocument();
			Element docElement = document.createElement("Book");
			document.appendChild(docElement);
			
			 docElement.appendChild(getBook(document, "1", "Kniha", "g1", "1000"));
			 docElement.appendChild(getBook(document, "2", "Kniha2", "g2", "2000"));
			 docElement.appendChild(getBook(document, "3", "Kniha3", "g3", "3000"));
			docElement.appendChild(getBook(document, "4", "Kniha4", "g4", "10"));
			  Transformer crunchifyTransformer = TransformerFactory.newInstance().newTransformer();
	            Transformer crunchifyTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
	            // Acts as a holder for a transformation Source tree in the form of a Document Object Model (DOM) tree.
	            DOMSource source = new DOMSource(document);
	            // Acts as an holder for a transformation result, which may be XML, plain Text, HTML, or some other form of markup.
	            StreamResult console = new StreamResult(System.out);
	            crunchifyTransformer.transform(source, console);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static Object getBook(Document document, String id, String name, String gender, String price) {
		Element fyBook = document.createElement("Book");
		fyBook.setAttribute("id", id);
		fyBook.appendChild(getCrunchifyCompanyElements(document, fyBook, "Name", name));
		fyBook.appendChild(getCrunchifyCompanyElements(document, fyBook, "Gender", gender));
		fyBook.appendChild(getCrunchifyCompanyElements(document, fyBook, "Price", price));
		return fyBook;
	}

	private static Node getCrunchifyCompanyElements(Document doc, Element element, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}
}