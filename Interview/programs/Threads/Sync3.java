package demo;

public class Sync3 extends Thread {
    static int n = 1;

    static Object critsect = new Object();

    public void run()
    {
        for (int i = 1; i <= 10; i++) {
            synchronized (critsect) {
                System.out.println(n);
                n++;
            }
        }
    }

    public static void main(String args[])
    {
        Thread thr1 = new Sync3();
        Thread thr2 = new Sync3();

        thr1.start();
        thr2.start();
    }
}


/*

public class SynchronizationDemo extends Thread {
	static int n = 1;
    
    public void run()
    {       
			synchronized (SynchronizationDemo.class) {
				for (int i = 1; i <= 10; i++) {
					System.out.println(n);
					n++;
				}
			}
	
    }


    public static void main(String args[])
    {
        Thread thr1 = new SynchronizationDemo();
        Thread thr2 = new SynchronizationDemo();

        thr1.start();
        thr2.start();
    }
}
*/

