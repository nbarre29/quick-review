package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
 
/**
 * Predicates and Lambda Expressions:
 * 
 * Predicates mixes well with the lambda expressions. We can have a generic
 * implementation and pass predicate as argument in lambda expression. Based on
 * the condition, operation is performed inside the lambda implementation.
 *
 */
public class LambdaPredicate {
   
  public static int add(List<Integer> numList, Predicate<Integer> predicate) {
      int sum = 0;
      for (int number : numList) {
          if (predicate.test(number)) {
              sum += number;
          }
      }
      return sum;
  }
   
  public static void main(String args[]){
     
    List<Integer> numList = new ArrayList<Integer>();
     
    numList.add(new Integer(10));
    numList.add(new Integer(20));
    numList.add(new Integer(30));   
    numList.add(new Integer(40));   
    numList.add(new Integer(50));
     
    System.out.println("Add Everything: "+add(numList, n -> true));
    System.out.println("Add Nothing: "+add(numList, n -> false));
    System.out.println("Add Less Than 25: "+add(numList, n -> n < 25));   
    System.out.println("Add 3 Multiples: "+add(numList, n -> n % 3 == 0));
  }
}
