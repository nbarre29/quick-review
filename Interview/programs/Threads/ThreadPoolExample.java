package demo;

/*
http://javarevisited.blogspot.in/2013/07/how-to-create-thread-pools-in-java-executors-framework-example-tutorial.html
How to create Thread Pools using Java 1.5 Executor Framework - Example Tutorial 


Java 1.5 introduced Thread pool in Java in form of Executor framework, which allows Java programmer to decouple submission of task to execution of task. If you are doing server side programming in Java than Thread pool is an important concept to maintain scalability, robustness and stability of system. For those, who are not familiar with thread pool in Java or concept of thread pool here is one liner, Thread pool in Java is pool of worker threads, which is ready to perform any task given to them. 

Java 5 introduced a full feature built-in Thread Pool framework commonly known as Executor framework. Core of this thread pool framework is Executor interface which defines abstraction of task execution with method execute(Runnable task) and ExecutorService which extends Executor to add various life-cycle and thread pool management facilities like shutting down thread pool. Executor framework also provides an static utility class called Executors ( similar to Collections) which provides several static factory method to create various type of Thread Pool implementation in Java e.g. fixed size thread pool, cached thread pool and scheduled thread pool.

Below is an example of Thread pool in Java, which uses Executor framework of Java 5 to create a fixed thread pool with number of worker threads as 10. It will then create task and submit that to Thread pool for execution.

 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {

	public static void main(String args[]) {

		ExecutorService service = Executors.newFixedThreadPool(10);

		for (int i = 0; i <= 100; i++) {
			service.submit(new Task(i));
		}
		service.shutdown();

	}

}

final class Task implements Runnable {

	private int taskId;

	public Task(int id) {
		this.taskId = id;

	}

	@Override
	public void run() {
		System.out.println("Task ID : " + this.taskId + " performed by "
				+ Thread.currentThread().getName());

	}

}
