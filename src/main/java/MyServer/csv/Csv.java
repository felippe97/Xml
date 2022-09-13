package MyServer.csv;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.opencsv.CSVReader;


public class Csv {
	private  String id;
	private  String name;
	private  String gender;
	private  String price;
	String csvFile = "books.csv";
	String del = ",";
	String line = "n/";
	
	public String book() {
	HashMap<String, String> books = new HashMap<>();
	try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile))){
		while ((line = bufferedReader.readLine()) != null) {
			
		String[] book = line.split(del);
		id = books.get(book[0]);
		name = books.get(book[1]);
		gender = books.get(book[2]);
		price = books.get(book[3]);
		}
		
		
		
	}catch (IOException e) {
        e.printStackTrace();
    }
	return null;
	
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
