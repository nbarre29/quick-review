package demo;

import java.util.*;
import java.util.stream.*;

/**
 * In this example we are going to see how easy it is to filter results from a
 * Collection. This example shows the old way vs. the new way.
 *
 */
public class UserFilterTest {
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
    List<User> olderUsers = new ArrayList<User>();

    for (User u : users) {
      if (u.getAge() > 30) {
        olderUsers.add(u);
      }
    }

    printListNewWay("Old way older users", olderUsers);
  }

  //A lot less boilerplate code and we don't have to use any specific List implementation.
  private static void newJavaWay() {
    List<User> olderUsers = users.stream().filter(u -> u.getAge() > 30).collect(Collectors.toList());
    printListNewWay("New way older users", olderUsers);
  }
  
/*  //We could also make our filter more complex by checking more than one variable:
  //With this filter we check both age being over 30 and if the last name starts with an "S".
  private static void newJavaWay() {
  List<User> olderUsers = users.stream().filter(u -> u.getAge() > 30 && u.getLastName().startsWith("S")).collect(Collectors.toList());
  printListNewWay("New way older users", olderUsers);
  }*/

  private static void printListNewWay(String type, List<User> users) {
    System.out.println(type + ":");

    users.forEach(u -> System.out.println("\t" + u));

    System.out.println();
  }
}



