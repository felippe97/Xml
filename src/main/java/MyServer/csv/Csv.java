package MyServer.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import MyServer.book.Book;

public class Csv {
private String fileName = "books.csv";

		private static List<Book> readBook(String fileName) { 
			List<Book> books = new ArrayList<>(); Path pathToFile = Paths.get(fileName);
			
			try (BufferedReader br = Files.newBufferedReader(pathToFile)){
				String line = br.readLine();
				 while (line != null) {
					 String[] attributes = line.split(",");
					 Book book = createBook(attributes);
					 books.add(book);
					  line = br.readLine();
				 }
			}catch (IOException ioe) {
	            ioe.printStackTrace();
			}
			return books;
			
			
		}

	private static Book createBook(String[] metadata) {
		String id = metadata[0];
		String name = metadata[1]; 
		String gender = metadata[2];
		int price = Integer.parseInt(metadata[3]); 
		

		return new Book(id, name, gender, price);
	
	}

	
	
		/*
		 * String file = "books.csv"; String delimiter = ","; String line;
		 * List<List<String>> lines = new ArrayList(); try (BufferedReader br = new
		 * BufferedReader(new FileReader(file))) { while ((line = br.readLine()) !=
		 * null) { List<String> values = Arrays.asList(line.split(delimiter));
		 * lines.add(values); } lines.forEach(l -> System.out.println(l));
		 * 
		 * 
		 * } catch (Exception e) { System.out.println(e); }
		 */

	}


