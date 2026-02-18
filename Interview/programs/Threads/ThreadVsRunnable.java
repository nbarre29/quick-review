package demo;

/*
  The most common difference is::

When you extends Thread class, after that you can’t extend any other class which you required. (As you know, Java does not allow inheriting more than one class).
When you implements Runnable, you can save a space for your class to extend any other class in future or now.

However, the significant difference is::

When you extends Thread class, each of your thread creates unique object and associate with it.
When you implements Runnable, it shares the same object to multiple threads.

The following example helps us to understand more clearly.
 */
class ImplementsRunnable implements Runnable {

 private int counter = 0;

 public void run() {
 counter++;
 System.out.println("ImplementsRunnable : Counter : " + counter);
 }
 }

 class ExtendsThread extends Thread {

 private int counter = 0;

 public void run() {
 counter++;
 System.out.println("ExtendsThread : Counter : " + counter);
 }
 }

 public class ThreadVsRunnable {

 public static void main(String args[]) throws Exception {
 //Multiple threads share the same object.
 ImplementsRunnable rc = new ImplementsRunnable();
 Thread t1 = new Thread(rc);
 t1.start();
 Thread.sleep(1000); // Waiting for 1 second before starting next thread
 Thread t2 = new Thread(rc);
 t2.start();
 Thread.sleep(1000); // Waiting for 1 second before starting next thread
 Thread t3 = new Thread(rc);
 t3.start();

 //Creating new instance for every thread access.
 ExtendsThread tc1 = new ExtendsThread();
 tc1.start();
 Thread.sleep(1000); // Waiting for 1 second before starting next thread
 ExtendsThread tc2 = new ExtendsThread();
 tc2.start();
 Thread.sleep(1000); // Waiting for 1 second before starting next thread
 ExtendsThread tc3 = new ExtendsThread();
 tc3.start();
 }
 }

/*
ImplementsRunnable : Counter : 1
ImplementsRunnable : Counter : 2
ImplementsRunnable : Counter : 3
ExtendsThread : Counter : 1
ExtendsThread : Counter : 1
ExtendsThread : Counter : 1

In the Runnable interface approach, only one instance of a class is being created and it 
has been shared by different threads. So the value of counter is incremented for each and every thread access.
Whereas, Thread class approach, you must have to create separate instance for every thread access.
Hence different memory is allocated for every class instances and each has separate counter, 
the value remains same, which means no increment will happen because none of the object reference is same.

When to use Runnable?
Use Runnable interface when you want to access the same resource from the group of threads. Avoid using Thread class here, because multiple objects creation consumes more memory and it becomes a big performance overhead.
* 
 * 
 * 
 * 
 * 
 * 
 */

