package demo;

/* Deadlock is resolved simply after re-ordering
 * the statements where code is accessing the shared resources.
 * 
 * The example below causes a deadlock situation by thread-1 waiting for resource2 and thread-0 waiting for resource1
 */

public class DeadlockTest1 extends Thread {
 
    public static Object resource1 = new Object();
    public static Object resource2 = new Object();
 
    public void method1() {
        synchronized (resource1) {
            delay(500);  //some operation
            System.out.println("method1: " + Thread.currentThread().getName());
            synchronized (resource2) {
                System.out.println("method1 is executing .... ");
            }
        }
    }
 
    public void method2() {
        synchronized (resource1) {
            delay(500);   //some operation
            System.out.println("method2: " + Thread.currentThread().getName());
            synchronized (resource2) {
                System.out.println("method2 is executing .... ");
            }
        }
    }
 
    @Override
    public void run() {
        method1();
        method2();
    }
 
    public static void main(String[] args) {
        DeadlockTest1 thread1 = new DeadlockTest1();
        DeadlockTest1 thread2 = new DeadlockTest1();
 
        thread1.start();
        thread2.start();
    }
 
    /**
     * The delay is to simulate some real operation happening.
     * @param timeInMillis
     */
    private void delay(long timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
}