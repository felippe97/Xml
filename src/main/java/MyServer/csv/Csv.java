package MyServer.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.thoughtworks.xstream.XStream;

import MyServer.book.Book;

public class Csv {



	  public static void main(String[] args) {

	  }
	  private static List<Book> redBookCsv(String fileName) throws IOException {
	  fileName = "books.csv"; 
	  List<Book> books = new ArrayList<>();
	  
	  Path path = Paths.get(fileName); try (BufferedReader bufferedReader =Files.newBufferedReader(path)) {
		  String line = bufferedReader.readLine();
	  
			while (line != null) {
				String[] atributes = line.split(",");
				Book book =createBook(atributes); books.add(book); 
	  line = bufferedReader.readLine(); 
	  } 
	  
	  
	  }
	  catch (Exception e) { 
		  
	  } return books; }
	  
	  private static Book createBook(String[] metadata) { 
		  String id = metadata[0];
	  String name = metadata[1]; 
	  String gender = metadata[2]; int price = Integer.parseInt(metadata[3]);
	return null;
	  
	  }
	  

}
