package demo;

public class User {

	private int id;
	private String firstName;
	private String lastName;
	private int age;


	User(int id, String first, String last, int age) {
		this.id = id;
		this.firstName = first;
		this.lastName = last;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "" + getId() + ", " + getFirstName() + ", " + getLastName() + ", " + getAge();
	}

}
