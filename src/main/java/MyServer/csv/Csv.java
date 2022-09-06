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

	private static List<Book> redBookCsv(String fileName) throws IOException {
		fileName = "books.txt";
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
		String name = metadata[0];
		String gender = metadata[1];
		int price = Integer.parseInt(metadata[2]);

		return new Book(name, gender, price);
	}

}
