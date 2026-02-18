package demo;

import java.util.concurrent.Callable;

/**
 * Lambda Initialization
 *
 */
public class LambdaInitialization {
  public static void main(String args[]) throws Exception{
    Callable<String>[] animals = new Callable[]{()->"Lion", ()->"Crocodile"};
     
    System.out.println(animals[0].call());
  }
}
