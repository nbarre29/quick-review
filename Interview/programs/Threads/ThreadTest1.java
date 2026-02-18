package demo;


class A extends Thread {

	public void run() {
		for (int i = 0; i <= 5; i++) {
			if(i == 1) yield();
			System.out.println("\t From Thread A : i = " + i);
		}
		System.out.println(" Exit from A ");
	}

}

class B extends Thread {

	public void run() {
		for (int j = 0; j <= 5; j++) {
			System.out.println("\t From Thread B : j = " + j);
			if(j == 3) stop();
		}
		System.out.println(" Exit from B ");
	}

}

class C extends Thread {

	public void run() {
		for (int k = 0; k <= 5; k++) {
			System.out.println("\t From Thread C : k = " + k);
			if(k == 1)
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		System.out.println(" Exit from C ");
	}

}

public class ThreadTest1 {

	public static void main(String[] args) {
		new A().start();
		new B().start();
		new C().start();

	}

}
