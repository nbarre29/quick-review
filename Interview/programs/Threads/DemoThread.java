package demo;

public class DemoThread extends Thread {

	public void run() {
		System.out.println("Inside run()...	");

	}
	
	public static void main(String[] args) {
		
//		new DemoThread().start();
		
		DemoThread threadInstance = new DemoThread();
		threadInstance.start();

	}

}
