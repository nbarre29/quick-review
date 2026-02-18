package demo;

/**
 * The proper way to write the Producer / Consumer  program in Java is to use wait( ) and notify( ) to signal in both directions, 
 *
 *  A correct implementation of a producer and consumer. 
 */
class Q {
	int n;
	boolean valueSet = false;

	synchronized int get() {
		if (!valueSet)
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		System.out.println("Got: " + n);
		valueSet = false;
		notify();
		return n;
	}

	synchronized void put(int n) {
		if (valueSet)
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		this.n = n;
		valueSet = true;
		System.out.println("Put: " + n);
		notify();
	}
}


class Producer implements Runnable {
	Q q;

	Producer(Q q) {
		this.q = q;
		new Thread(this, "Producer").start();
	}

	public void run() {
		int i = 0;
		while (true) {
			q.put(i++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	Q q;

	Consumer(Q q) {
		this.q = q;
		new Thread(this, "Consumer").start();
	}

	public void run() {
		while (true) {
			q.get();
		}
	}
}

public class ProducerConsumerFixed {
	public static void main(String args[]) {
		Q q = new Q();
		System.out.println("Press Control-C to stop.");
		new Producer(q);
		new Consumer(q);
		
	}
}

/*

Inside get( ), wait( ) is called. This causes its execution to suspend until the Producer notifies you that some data is ready. When this happens, execution inside get( ) resumes. After the data has been obtained, get( ) calls notify( ). This tells Producer that it is okay to put more data in the queue. Inside put( ), wait( ) suspends execution until the Consumer has removed the item from the queue. When execution resumes, the next item of data is put in the queue, and notify( ) is called. This tells the Consumer that it should now remove it.

Here is some output from this program, which shows the clean synchronous behavior:

Put: 1 
Got: 1 
Put: 2 
Got: 2 
Put: 3 
Got: 3 
Put: 4 
Got: 4 
Put: 5 
Got: 5

This tutorial is an extract from the book "The complete Reference Java 2" by Herbert Schildt

*/
