package MyServer.book;

public class Book {
	private String id;

	private String name;
	private String gender;
	private int price;

	public Book(String id, String name, String gender, int price) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.price = price;

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

	public int getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + "gender=" + gender + "price=" + price + "]";
	}

}
