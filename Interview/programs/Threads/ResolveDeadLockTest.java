package demo;

/**
 * http://howtodoinjava.com/2012/10/16/writing-a-deadlock-and-resolving-in-java/
 * 
 *  The below code will create a deadlock situation.
 *  A deadlock is a situation where minimum two threads are holding lock on some different resource, 
 *  and both are waiting for other’s resource to complete its task.
 *  In below case, Thread-1 has A but need B to complete processing and Similarly Thread-2 has resource B but need A first.
 */
public class ResolveDeadLockTest {
	 
    public static void main(String[] args) {
        ResolveDeadLockTest test = new ResolveDeadLockTest();
 
        final A a = test.new A();
        final B b = test.new B();
 
        // Thread-1
        Runnable block1 = new Runnable() {
            public void run() {
                synchronized (a) {
                    try {
                        // Adding delay so that both threads can start trying to
                        // lock resources
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // Thread-1 have A but need B also
                    synchronized (b) {
                        System.out.println("In block 1");
                    }
                }
            }
        };
 
        // Thread-2
        Runnable block2 = new Runnable() {
            public void run() {
                synchronized (b) {
                    // Thread-2 have B but need A also
                    synchronized (a) {
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
        private int i = 10;
 
        public int getI() {
            return i;
        }
 
        public void setI(int i) {
            this.i = i;
        }
    }
 
    // Resource B
    private class B {
        private int i = 20;
 
        public int getI() {
            return i;
        }
 
        public void setI(int i) {
            this.i = i;
        }
    }
}