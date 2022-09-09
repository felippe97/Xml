package MyServer.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Csv {
//private String fileName = "books.csv";

	/*
	 * public ArrayList<String[]> CSVtoArrayList(String csvFile, String csvSplit)
	 * throws IOException { ArrayList<String[]> elements = new
	 * ArrayList<String[]>(); BufferedReader csvReader = null; String line;
	 * 
	 * try { csvReader = new BufferedReader(new FileReader(csvFile)); } catch
	 * (FileNotFoundException e) { e.printStackTrace(); }
	 * 
	 * while ((line = csvReader.readLine()) != null) { String[] nodes =
	 * line.split(csvSplit); elements.add(nodes); }
	 * 
	 * return elements; }
	 */

	public static void main(String[] args) {
		String file = "books.csv";
		String delimiter = ", ' : ;";
		String line;
		List<String> lines = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				List<String> values = Arrays.asList(line.split(delimiter));
				lines.addAll(values);
			}
			lines.forEach(l -> System.out.println(l));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
