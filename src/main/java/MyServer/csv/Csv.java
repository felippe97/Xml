package MyServer.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import MyServer.book.Book;
import com.opencsv.bean.CsvToBeanBuilder;

public class Csv {

	

	public static void main(String[] args) {
		String csvFile = "books.csv";
		
		String del = ",";
		String line = " ";
		HashMap<String, String> books = new HashMap<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile))) {
			bufferedReader.readLine();

			boolean first = true;
			String[] header = null;
			while ((line = bufferedReader.readLine()) != null) {
				if (first) {
					header = line.split(del);
//
//					for (String stlpce : riadok) {
//
//						return stlpce;
//					}

					first = false;
				} else {

					String[] data = line.split(del);
					for (int i = 0; i < header.length; i++) {
						System.out.println("<" + header[i] + ">" + data[i] + "</" + header[i] + ">");
					}

				}
//				while (data != null) {
//					books.put(stlpce, data);
//				}
			}
//			id = books.get(stlpce);
//			name = books.get(name);
//			gender = books.get(gender);
//			price = books.get(price);

		} catch (IOException e) {
			e.printStackTrace();
		}
		//return id + name + gender + price;

	}


}