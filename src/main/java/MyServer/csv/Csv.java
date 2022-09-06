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

	public static void main(String[] args) throws IOException {
		List<Book> books = redBookCsv("books.csv");
		for (Book b : books) {
			System.out.println(b);
		}

	}

	private static List<Book> redBookCsv(String fileName) throws IOException {

		List<Book> books = new ArrayList<>();

		Path path = Paths.get(fileName);
		try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
			String line = bufferedReader.readLine();
			while (line != null) {
				String[] atributes = line.split(",");
				Book book = createBook(atributes);
				books.add(book);
				line = bufferedReader.readLine();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return books;
	}

	private static Book createBook(String[] metadata) {
		String id = metadata[0];
		String name = metadata[1];
		String gender = metadata[2];
		int price = Integer.parseInt(metadata[3]);

		// TODO Auto-generated method stub
		return new Book(id, name, gender, price);
	}

}
