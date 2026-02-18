package demo;
/*
Here is a simple example of joining two threads using Thread.join() method. By the way unlike Thread.sleep() method, join() is not a static method, it needs to be call on a java.lang.Thread object. Current thread, which calls join method will wait until thread on which join has called die or wait at most specified millisecond for this thread to die.

If you look at above example, first main thread is started and than it creates another thread, whose name is "Thread-0" and started it. Since Thread-0 sleep for 2 seconds, it require at least 2 seconds to complete and in between main thread called join method on Thread-0 object. Because of join method, now main thread will wait until Thread-0 completes its operation or You can say main thread will join Thread-0.

*/
public class JoinDemo1 {
    public static void main(String args[]) throws InterruptedException{
      
        System.out.println(Thread.currentThread().getName() + " is Started");
      
        Thread exampleThread = new Thread(){
            @Override
            public void run(){
                try {
                    System.out.println(Thread.currentThread().getName() + " is Started");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " is Completed");
                } catch (InterruptedException ex) {
                    
                }
            }
        };
      
        exampleThread.start();
        exampleThread.join();
      
        System.out.println(Thread.currentThread().getName() + " is Completed");
    }


    
}

/*
OUTPUT:::
main is Started
Thread-0 is Started
Thread-0 is Completed
main is Completed
*/
