package demo;

import java.time.LocalDate;
import java.time.Month;

/**
 * http://docs.oracle.com/javase/tutorial/datetime/overview/design.html
 * 
 * Most of the classes in the Date-Time API create objects that are immutable,
 * meaning that, after the object is created, it cannot be modified. To alter
 * the value of an immutable object, a new object must be constructed as a
 * modified copy of the original. This also means that the Date-Time API is, by
 * definition, thread-safe. This affects the API in that most of the methods
 * used to create date or time objects are prefixed with of, from, or with,
 * rather than constructors, and there are no set methods.
 *
 */
public class DateTime1 {

	public static void main(String[] args) {
		LocalDate dateOfBirth = LocalDate.of(2012, Month.MAY, 14);
		LocalDate firstBirthday = dateOfBirth.plusYears(1);
		System.out.println(firstBirthday);

	}

}
