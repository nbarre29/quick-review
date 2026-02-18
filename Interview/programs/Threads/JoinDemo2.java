package demo;

public class JoinDemo2 implements Runnable {

    @Override
   public void run() {
   
      Thread t = Thread.currentThread();
      System.out.print(t.getName());
      //checks if this thread is alive
      System.out.println(", status = " + t.isAlive());
   }

   public static void main(String args[]) throws InterruptedException {
   
      Thread t = new Thread(new JoinDemo2());
      // this will call run() function
      t.start();
      // waits for this thread to die
      t.join();
      System.out.print(t.getName());
      //checks if this thread is alive
      System.out.println(", status = " + t.isAlive());
   }
} 

/*
OUTPUT:::
Thread-0, status = true
Thread-0, status = false
*/