package demo;

public class Sync1 extends Thread {
	int n = 1;

	public void run() {
		for (int i = 1; i <= 10; i++) {
			{
				System.out.println(n);
				n++;
			}
		}
	}

	public static void main(String args[]) {
		Thread thr1 = new Sync1();
		Thread thr2 = new Sync1();

		thr1.start();
		thr2.start();
	}
}


/*
1
1
2
3
4
5
6
7
8
9
10
2
3
4
5
6
7
8
9
10 
*/
