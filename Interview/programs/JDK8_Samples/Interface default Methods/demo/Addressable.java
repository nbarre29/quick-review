package demo;

public interface Addressable {
	String getStreet();

	String getCity();

	default String getFullAddress() {
		return getStreet() + ", " + getCity();
	}
}