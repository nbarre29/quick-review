package demo;

/**
 http://javarevisited.blogspot.in/2010/10/what-is-deadlock-in-java-how-to-fix-it.html
 
 There is a good chance of deadlock because if thread 1 acquires lock on String object while executing block1 and thread 2 acquires 
 lock on Integer object while executing block2() both will be waiting for each other to release lock on Integer and String to proceed further which 
 will never happen. If you have looked above code carefully you may have figured out that real reason for deadlock is not multiple threads but
 the way they access lock , if you provide an ordered access then problem will be resolved.
      
 *
 */
public class DeadlockDemo {

	public static void main(String[] args) {
		
		
		Runnable block1 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (String.class) {		
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Acquired lock on String.class object");
					synchronized (Integer.class) {
						System.out.println("Acquired lock on Integer.class object");
						
					}
					
				}
				
			}
		};
		
		Runnable block2 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (Integer.class) {
					System.out.println("Acquired lock on Integer.class object");
					synchronized (String.class) {
						System.out.println("Acquired lock on String.class object");
						
					}
					
				}
				
			}
		};
		
		new Thread(block1).start();
		new Thread(block2).start();

	}

}
