/*
Using Synchronized Statements
Suppose that you're experimenting with Java language threads,
and you write a simple program such as the following: 

*/


package demo;

public class Sync2 extends Thread {
	static int n = 1;
    
    public void run()
    {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n);
            n++;
        }
    }


    public static void main(String args[])
    {
        Thread thr1 = new Sync2();
        Thread thr2 = new Sync2();

        thr1.start();
        thr2.start();
    }
}


/*  
 

 We may get output as 

    1
    2
    3
    4
    5
    6
    7
    8
    9
    9
    10
    11
    13
    14
    15
    16
    17
    18
    19
    20


	Two instances of "9" occur, and none of "12" occur. 


	Such results are "impossible," because "n" is incremented immediately after printing its value, isn't it? How can 
	the same value be printed twice, or another value omitted altogether? 
The reason that this type of output can occur has to do with the nature of thread programming. In the following sequence: 

    System.out.println(n);
    n++;

with two threads executing, nothing says that these two statements must be executed 
atomically (that is, without any interruption between statements) within one thread, 
without the other thread gaining control. For example, a sequence such as the following: 

    System.out.println(n);
    System.out.println(n);
    n++;
    n++;
    
    
    
    To solve this problem, the example can be rewritten as follows: 

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
 


	*/





