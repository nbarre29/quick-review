package demo;

//An incorrect implementation of a producer and consumer. 
class Q {
	int n;

	synchronized int get() {
		System.out.println("Got: " + n);
		return n;
	}

	synchronized void put(int n) {
		this.n = n;
		System.out.println("Put: " + n);
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

public class ProducerConsumer {
	public static void main(String args[]) {
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
		System.out.println("Press Control-C to stop.");
	}
}


/*
The above sample program incorrectly implements a simple form of the producer/consumer problem. It consists of four classes: Q, the queue that you're trying to synchronize; Producer, the threaded object that is producing queue entries; Consumer, the threaded object that is consuming queue entries; and ProducerConsumer, the tiny class that creates the single Q, Producer, and Consumer.

Although the put( ) and get( ) methods on Q are synchronized, nothing stops the producer from overrunning the consumer, nor will anything stop the consumer from consuming the same queue value twice. Thus, you get the erroneous output shown here (the exact output will vary with processor speed and task load):

Put: 1 
Got: 1 
Got: 1 
Got: 1 
Got: 1 
Got: 1 
Put: 2 
Put: 3 
Put: 4 
Put: 5 
Put: 6 
Put: 7 
Got: 7

As you can see, after the producer put 1, the consumer started and got the same 1 five times in a row. Then, the producer resumed and produced 2 through 7 without letting the consumer have a chance to consume them.

*/
