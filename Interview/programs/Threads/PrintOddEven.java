package demo;
/*
 * print from 1 to 100 using two threads. One thread to print odd and the other to print even
 */

public class PrintOddEven {
	
	int count =1;
	int MAX = 100;
	boolean valueSet = false;
	synchronized void printEven() {
		
		while (count < MAX) {
		if (!valueSet)
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		System.out.println("Even: " + count);
		count++;
		valueSet = false;
		notify();
		}
	}
	

	synchronized void printOdd() {
		
		 try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e1) {
	            e1.printStackTrace();
	        }
		 while (count < MAX) {
		if (valueSet)
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		
		valueSet = true;
		System.out.println("Odd: " + count);
		count++;
		notify();
		 }
	}
	
	

	public static void main(String[] args) {
		PrintOddEven poe = new PrintOddEven();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				poe.printOdd();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				poe.printEven();
				
			}
		});		
		
		t1.start();		
		t2.start();	

	}

}
