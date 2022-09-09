package MyServer.book;

public class Book {
	private String id;

	private String name;
	private String gender;


	public Book(String id, String name, String gender) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		

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



	@Override
	public String toString() {
		return "Book [id=" + id + "name=" + name + "gender=" + gender +  "]";
	}

}
