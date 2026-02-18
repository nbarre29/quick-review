package demo;

import java.util.*;
import java.util.stream.*;

/**
 * Map Reduce:
 * 
 * In this section, we will go over the map function in Java 8. It is used to
 * implement the MapReduce type operations. Essentially we map a set of values
 * then we reduce it with a function such as average or sum into a single
 * number. Let's take a look at this sample which will do an average of numbers
 * the old and new ways.
 * 
 * 
 * 
 * Again, the old method is many lines of code and is designed to do this all
 * very sequentially. This code could not take advantage of a multi-core
 * processor. Sure, in this example it is very simple, but imagine if you have
 * millions of items you are processing and you have an 8 core machine. Seven of
 * those cores would be completely wasted and idle during this long calculation.
 * Now if we look at the simple one-line Java 8 way of doing it:
 * 
 * double average = users.parallelStream().map(u -> u.age).average().getAsDouble();
 * 
 * This uses the concept of parallelism, where it creates a parallel stream out
 * of the array, which can be processed by multiple cores and then finally
 * joined back into to map the results together. The map function will create a
 * stream containing only the values with meet the given criteria, then the
 * average function will reduce this map into a single value. Now all 8 of your
 * cores are processing this calculation so it should run much faster.
 *
 */
public class UserAverageTest {
  private static List<User> users = Arrays.asList(
      new User(1, "Steve", "Vai", 40),
      new User(4, "Joe", "Smith", 32),
      new User(3, "Steve", "Johnson", 57),
      new User(9, "Mike", "Stevens", 18),
      new User(10, "George", "Armstrong", 24),
      new User(2, "Jim", "Smith", 40),
      new User(8, "Chuck", "Schneider", 34),
      new User(5, "Jorje", "Gonzales", 22),
      new User(6, "Jane", "Michaels", 47),
      new User(7, "Kim", "Berlie", 60)
    );

  public static void main(String[] args) {
    oldJavaWay();
    newJavaWay();
  }

  private static void oldJavaWay() {
    int total = 0;

    for (User u : users) {
      total += u.age;
    }

    double average = (double)total / (double)users.size();

    System.out.println("OLDWAY Average User Age: " + average);
  }

  private static void newJavaWay() {    
	  double average = users.parallelStream().mapToDouble(u -> u.age).average().getAsDouble();
      System.out.println("NEWWAY Average User Age: " + average);
  }
}


/**
 * Normally in java we will create getters and setters and make your members
 * private, but for the sake of brevity we will just use package level scope on
 * these java fields. We have a simple constructor and a toString() method to
 * make it easier to read the values printed out.
 *
 */
class User {
	Integer id;
	String firstName;
	String lastName;
	Integer age;

	User() {
	}

	User(int id, String first, String last, int age) {
		this.id = id;
		this.firstName = first;
		this.lastName = last;
		this.age = age;
	}

	public String toString() {
		return "" + id + ", " + firstName + ", " + lastName + ", " + age;
	}
}