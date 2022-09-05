package MyServer.CsvXml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.thoughtworks.xstream.XStream;
public class Converter {
	
	public static void convert_csv(String csvFile, String xmlFile, Class dataModel) 
			throws IOException, NoSuchMethodException, SecurityException, InstantiationException, 
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, CsvException {
		
		List<String[]> data = getData(csvFile);
		if (data == null || data.size() == 0)
			return;
		Class[] params = new Class[data.get(0).length];
		Arrays.fill(params, String.class);
		String xml = "";
		
		
		for (int i = 1; i < data.size(); i++) { 
			Constructor c = dataModel.getDeclaredConstructor(params);
			Object o = c.newInstance((Object[])data.get(i));
			xml += convertToXML(o);
		}
		
		// printing out final results
		PrintStream out = new PrintStream(new File(xmlFile));
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		out.println("<root>");
		out.println(xml);
		out.println("</root>");
		out.close();
		
	}


	public static List<String[]> getData(String csvFile) throws IOException, CsvException {
		CSVReader reader = new CSVReader(new FileReader(csvFile));
		List<String[]> data = reader.readAll();
		reader.close();
		return data;
	}

	
	public static String convertToXML(Object data) throws FileNotFoundException {
		XStream xstream = new XStream();
		String xml = xstream.toXML(data);
		return xml;
	}




}