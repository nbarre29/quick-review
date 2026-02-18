package com.cakes;

import java.util.Date;
/*
The join() method of a Thread instance can be used to "join" the start of a thread's execution to the end of another thread's execution so that a thread will not start running until another thread has ended. If join() is called on a Thread instance, the currently running thread will block until the Thread instance has finished executing.

We can illustrate this with an example. The RunnableJob class implements Runnable. Its run() method displays the current thread's name and the time at which the run() method is executed. It then sleeps for 1 second.
*/
public class RunnableJob implements Runnable {

	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		System.out.println("RunnableJob is being run by " + thread.getName() + " at " + new Date());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

