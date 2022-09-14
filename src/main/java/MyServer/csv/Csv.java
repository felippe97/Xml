package MyServer.csv;


import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import MyServer.book.Book;


public class Csv {
	
	
	String csvFile = "books.csv";
	String del = ",";
	String line = " ";
	String name;
	String id;
	String gender;
	String price;
	public String book() {
		
		
		Book booq = new Book(id, name, gender, price);
		
	HashMap<String, String> books = new HashMap<>();
	try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile))){
		while ((line = bufferedReader.readLine()) != null) {
			
		String[] book = line.split(del);
		 id = books.put(book[0], book[0]);
		 name = books.put(book[1], book[1]);
		 gender = books.put(book[2], book[2]);
		 price = books.put(book[3], book[3]);
		return id + name + gender + price;
				
		}
		
		booq.setId(id);
		booq.setName(name);
		booq.setGende(gender);
		booq.setPrice(price);
		
	}catch (IOException e) {
        e.printStackTrace();
    }
	return null;
	
	}


	



	
	
	
}





/*
 * public List<String[]> Books() throws IOException {
 * 
 * try (
 * 
 * CSVReader csvReader = new CSVReader(new FileReader(file))) {
 * 
 * while ((line = csvReader.readAll()) != null) {
 * 
 * //List<String> list = Arrays.asList(((String) line).split(del));
 * 
 * return books = line;
 * 
 * 
 * }
 * 
 * } catch (Exception e) {
 * 
 * } return null;
 * 
 * 
 * 
 * }
 */
