package demo;

/**
 * The first variable r1 is an instance of a Runnable interface done the old
 * way, the second variable r2 is how you do it with lambda expressions.
 * 
 * Code to start the thread could even be simplified further as: 
 * new Thread(() -> System.out.println("New Java Way")).start();
 */
public class ThreadTest {
	  public static void main(String[] args) {
	    Runnable r1 = new Runnable() {
	      @Override
	      public void run() {
	        System.out.println("Old Java Way");
	      }
	    };

	    Runnable r2 = () -> { System.out.println("New Java Way"); };

	    new Thread(r1).start();
	    new Thread(r2).start();
//	    new Thread(() -> System.out.println("New Java Way")).start();
	  }
	}
