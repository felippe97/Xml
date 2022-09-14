package MyServer.book;

public class Book {
	private String id;
	private String name;
	private String gender;
	private String price;

	/*
	 * public Book(String id, String name, String gender, String price) { this.id =
	 * id; this.name = name; this.gender = gender; this.price = price;
	 * 
	 * }
	 */

	public Book() {
		// TODO Auto-generated constructor stub
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

	public String getGende() {
		return gender;
	}

	public void setGende(String gende) {
		this.gender = gende;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + "name=" + name + "gender=" + gender + "price=" + price + "]";
	}

}
