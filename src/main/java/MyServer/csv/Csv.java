package MyServer.csv;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import java.util.List;

public class Csv {

	// public static void main(String[] args) {
	String file = "books.csv";
	String del = ",";
	String line;
	private String books;

	public String Books() throws IOException {

		
		  try (
		  
		  BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
		  
		  while ((line = bufferedReader.readLine()) != null) {
		  
		  List<String> list = Arrays.asList(line.split(del));
		 
		return books = list.toString(); 
		  
		  } 
		  
		 } catch (Exception e) {
		  
		  } 
		  return null;
		 
		  
		
		/*
		 * Path path = java.nio.file.Path.of("books.csv"); String str =
		 * Files.readString(path); return str;
		 */
		 
	}
	  String[] parts = books.split("(?<=-,)");
	  String id = parts[0]; 
	  String name = parts[1];
	  String gender = parts[2];
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

		public String getGende() {
			return gender;
		}

		public void setGende(String gende) {
			this.gender = gende;
		}

}
