package demo;

/**
 * http://howtodoinjava.com/2012/10/16/writing-a-deadlock-and-resolving-in-java/
 * 
 * Resolving the deadlock situation:
 * 
 * The pattern of accessing A and B is the main issue here. So to solve it, we will simply re-order
 * the statements where code is accessing the shared resources.
 *
 */
public class ResolveDeadLockTest2 {
	 
    public static void main(String[] args) {
        ResolveDeadLockTest2 test = new ResolveDeadLockTest2();
 
//        final A a = test.new A();
//        final B b = test.new B();
 
        // Thread-1
        Runnable block1 = new Runnable() {
            public void run() {
                synchronized (B.class) {
                    try {
                        // Adding delay so that both threads can start trying to
                        // lock resources
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // Thread-1 have A but need B also
                    synchronized (A.class) {
                        System.out.println("In block 1");
                    }
                }
            }
        };
 
        // Thread-2
        Runnable block2 = new Runnable() {
            public void run() {
                synchronized (B.class) {
                    // Thread-2 have B but need A also
                    synchronized (A.class) {
                        System.out.println("In block 2");
                    }
                }
            }
        };
 
        new Thread(block1).start();
        new Thread(block2).start();
    }
 
    // Resource A
    private class A {
    	
    }
 
    // Resource B
    private class B {
    	
    }
}



