package MyServer.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import MyServer.book.Book;

public class Csv {
//private String fileName = "books.csv";
	/*
	 * public static void main(String[] args) { List<Book> books =
	 * readBook("books.csv"); for(Book b : books) { System.out.println(b); } }
	 * 
	 * private static List<Book> readBook(String fileName) { List<Book> books = new
	 * ArrayList<>(); Path pathToFile = Paths.get(fileName);
	 * 
	 * try (BufferedReader br = Files.newBufferedReader(pathToFile)){ String line =
	 * br.readLine(); while (line != null) { String[] attributes = line.split(",");
	 * Book book = createBook(attributes); books.add(book); line = br.readLine(); }
	 * }catch (IOException ioe) { ioe.printStackTrace(); } return books;
	 * 
	 * 
	 * }
	 * 
	 * private static Book createBook(String[] metadata) { String id = metadata[0];
	 * String name = metadata[1]; String gender = metadata[2]; int price =
	 * Integer.parseInt(metadata[3]);
	 * 
	 * 
	 * return new Book(id, name, gender, price);
	 * 
	 * }
	 */

	
	
		
	  public static void main(String[] args) {
	       String file = "books.csv";
	       String delimiter = ",";
	       String line;
	       List<Book> lines = new ArrayList<Book>();
	        try (BufferedReader br =
	                     new BufferedReader(new FileReader(file))) {
	            while((line = br.readLine()) != null){
	                List<String> values = Arrays.asList(line.split(delimiter));
	                lines.add(values);
	            }
	            lines.forEach(l -> System.out.println(l));
	        } catch (Exception e){
	            System.out.println(e);
	        }
	        }
		 

	}


