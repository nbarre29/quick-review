package demo;

public class DemoRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Inside run()...	");

	}

	public static void main(String[] args) {
//		new DemoRunnable().run();
		
//		new Thread(new DemoRunnable()).start();
		
		Thread threadInstance = new Thread(new DemoRunnable());
		threadInstance.start();

	}

}
