package demo;

public class Letter implements Addressable {
	private String street;
	private String city;

	public Letter(String street, String city) {
		this.street = street;
		this.city = city;
	}

	@Override
	public String getCity() {
		return city;
	}

	@Override
	public String getStreet() {
		return street;
	}

	public static void main(String[] args) {
		// Test the Letter class.

		Letter l = new Letter("123 AnyStreet", "AnyCity");
		System.out.println(l.getFullAddress());
	}
}