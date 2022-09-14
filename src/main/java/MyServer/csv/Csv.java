package MyServer.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


import MyServer.book.Book;

public class Csv {

	
	String del = ",";
	String line = " ";
	String csvFile = "books.csv";
	

	

	public String csv(String id,String name, String gender, String price) {

		Book book = new Book();

		HashMap<String, String> books = new HashMap<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile))) {
			while ((line = bufferedReader.readLine()) != null) {

				String[] csv = line.split(del);
				id = books.put(csv[0], csv[1]);
				name = books.put(csv[1], csv[3]);
				gender = books.put(csv[2], csv[3]);
				price = books.put(csv[3], csv[0]);
				return id + name + gender + price;
			}
			
			book.setId(id);
			book.setName(name);
			book.setGende(gender);
			book.setPrice(price);
			

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
