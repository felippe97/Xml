package MyServer.CsvXml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.PublicKey;

import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Xml {

	public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();

		org.w3c.dom.Document document = documentBuilder.newDocument();

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource domSource = new DOMSource();
		StreamResult streamResult = new StreamResult("/file.xml");
		transformer.transform(domSource, streamResult);
	}
}