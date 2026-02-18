package com.cakes;
/*

The ThreadExample class creates a RunnableJob object. It creates 4 threads named "T1", "T2", "T3", and "T4" with the RunnableJob object. It calls start() and then join() on each thread, in order. This blocks the execution of the current (main) thread from proceeding until the thread has completed. This means that the main thread will block for 1 second at each join(), since the RunnableJob sleeps for 1 second. Following this, ThreadExample creates 4 more threads, "T5", "T6", "T7", and "T8". This time, no joins are called on these threads, so the main thread will not block.


*/
public class ThreadExample {

	public static void main(String[] args) throws InterruptedException {

		RunnableJob runnableJob = new RunnableJob();

		Thread thread1 = new Thread(runnableJob, "T1");
		Thread thread2 = new Thread(runnableJob, "T2");
		Thread thread3 = new Thread(runnableJob, "T3");
		Thread thread4 = new Thread(runnableJob, "T4");

		thread1.start();
		thread1.join();
		thread2.start();
		thread2.join();
		thread3.start();
		thread3.join();
		thread4.start();
		thread4.join();

		Thread thread5 = new Thread(runnableJob, "T5");
		Thread thread6 = new Thread(runnableJob, "T6");
		Thread thread7 = new Thread(runnableJob, "T7");
		Thread thread8 = new Thread(runnableJob, "T8");

		thread5.start();
		thread6.start();
		thread7.start();
		thread8.start();

	}

}

/*
OUTPUT:::

RunnableJob is being run by T1 at Sun Aug 25 23:24:00 IST 2013
RunnableJob is being run by T2 at Sun Aug 25 23:24:01 IST 2013
RunnableJob is being run by T3 at Sun Aug 25 23:24:02 IST 2013
RunnableJob is being run by T4 at Sun Aug 25 23:24:03 IST 2013
RunnableJob is being run by T5 at Sun Aug 25 23:24:04 IST 2013
RunnableJob is being run by T7 at Sun Aug 25 23:24:04 IST 2013
RunnableJob is being run by T6 at Sun Aug 25 23:24:04 IST 2013
RunnableJob is being run by T8 at Sun Aug 25 23:24:04 IST 2013
------------------------------------------------------------
The console output of the execution of ThreadExample is shown here. Notice from the times displayed that we indeed see that T1, T2, T3, and T4 are all separated by 1 second delays. Also, notice that there are no delays for T5, T6, T7, and T8. Also, notice that T7 executes RunnableJob's run() method before T6. This occurred since there is no guarantee as to the order that T5, T6, T7, and T8 will execute the job code.

*/
