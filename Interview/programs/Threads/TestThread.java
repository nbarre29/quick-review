package demo;

class RunnableDemo implements Runnable {
	private String threadName;
	
	public RunnableDemo(String threadName) {
		this.threadName = threadName;
			}

	@Override
	public void run() {
		System.out.println("Running " + threadName);
		try {
			for (int i = 1; i <= 10; i++) {
				System.out.println("Thread: " + threadName + ", " + i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {

		}
		System.out.println("Thread " + threadName + " exiting.");
	}

}

	public class TestThread {
	   public static void main(String args[]) {	
		   
		   new Thread(new RunnableDemo("Thread-0")).start();	   	   
		   new Thread(new RunnableDemo("Thread-1")).start();		   
		   new Thread(new RunnableDemo("Thread-2")).start();
		   new Thread(new RunnableDemo("Thread-3")).start();
		   new Thread(new RunnableDemo("Thread-4")).start();
		   new Thread(new RunnableDemo("Thread-5")).start();		
		 
	   }   
	}
