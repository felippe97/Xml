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

	String del = ",";
	String line = " ";

	String csvFile = "books.csv";
	String id;
	String name;
	String gender;
	String price;
	String stlpce;
	String data;

	public String csv() {

		HashMap<String, String> books = new HashMap<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile))) {
			bufferedReader.readLine();
			
			boolean first = true;
			while ((line = bufferedReader.readLine()) != null) {
				if (first) {
					String[] riadok = line.split(del);

					for(String stlpce: riadok) {
						
						return stlpce;
					}

					first = false;
				} else {

					String[] second = line.split(del);
					for(String data: second) {
						
					}

				}

			}
			id = books.get(id);
			name = books.get(name);
			gender = books.get(gender);
			price = books.get(price);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return id + name + gender + price;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}