package MyServer.csv;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.opencsv.CSVReader;

import MyServer.book.Book;

public class Csv {

	String books;
	String del = ",";
	String line;

	String csvFile = "books.csv";

	String name;
	String id;
	String gender;
	String price;

	public String book() {

		Book booq = new Book();

		HashMap<String, String> books = new HashMap<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile))) {
			while ((line = bufferedReader.readLine()) != null) {

				String[] book = line.split(del);
				id = books.get(book[0]);
				name = books.get(book[1]);
				gender = books.get(book[2]);
				price = books.get(book[3]);
				
			}
			booq.setId(id);
			booq.setName(name);
			booq.setGende(gender);
			booq.setPrice(price);
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

}

/*
 * String file = "books.csv"; String del = ","; String line; private String
 * books;
 * 
 * 
 * public String Books() throws IOException {
 * 
 * try (
 * 
 * BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
 * 
 * while ((line = bufferedReader.readLine()) != null) {
 * 
 * List<String> list = Arrays.asList(line.split(del));
 * 
 * return books = list.toString();
 * 
 * }
 * 
 * } catch (Exception e) {
 * 
 * } return null;
 * 
 * }
 * 
 * String[] parts = books.split(","); String id = parts[0]; String name =
 * parts[1]; String gender = parts[2];
 * 
 * public String getName() { return name; } public String getId() { return id; }
 * 
 * public void setName(String name) { this.name = name; } public void
 * setId(String id) { this.id = id; }
 * 
 * public String getGende() { return gender; }
 * 
 * 
 * public void setGende(String gende) { this.gender = gende; }
 * 
 * 
 * public String getGender() { return gender; }
 * 
 * 
 * public void setGender(String gender) { this.gender = gender; }
 * }
 */
