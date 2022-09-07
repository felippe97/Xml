package MyServer.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.thoughtworks.xstream.XStream;

public class Csv {

	public static void convert(String csvFile, String xmlFile,
			Class dataModel) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, CsvException {
		List<String[]> data = getData(csvFile);
		if(data == null || data.size()==0) 
			return;
			Class[] params = new Class[data.get(0).length];
			Arrays.fill(params, String.class);
			String xml = "";
			
			
			for(int i = 1; i < data.size(); i++) {
				Constructor constructor = dataModel.getDeclaredConstructor(params);
				Object object = constructor.newInstance((Object[])data.get(i));
				xml += convertXML(constructor);
			}
			PrintStream out = new PrintStream(new File(xmlFile));
			out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			out.println("<root>");
			out.println(xml);
			out.println("</root>");
			out.close();
		}
	private static List<String[]> getData(String csvFile) throws IOException, CsvException {
		CSVReader csvReader = new CSVReader(new FileReader(csvFile));
		List<String[]> data = csvReader.readAll();
		csvReader.close();
		return data;
	}

	private static String convertXML(Object data) {
		XStream xStream = new XStream();
		String xml = xStream.toXML(data);
		return xml;
	}

	

	/*
	 * private static List<Book> redBookCsv(String fileName) throws IOException {
	 * fileName = "books.csv"; List<Book> books = new ArrayList<>();
	 * 
	 * Path path = Paths.get(fileName); try (BufferedReader bufferedReader =
	 * Files.newBufferedReader(path)) { String line = bufferedReader.readLine();
	 * while (line != null) { String[] atributes = line.split(","); Book book =
	 * createBook(atributes); books.add(book); line = bufferedReader.readLine(); } }
	 * catch (Exception e) { // TODO: handle exception } return books; }
	 * 
	 * private static Book createBook(String[] metadata) { String id = metadata[0];
	 * String name = metadata[1]; String gender = metadata[2]; int price =
	 * Integer.parseInt(metadata[3]);
	 * 
	 * // TODO Auto-generated method stub return new Book(id, name, gender, price);
	 * }
	 */

}
