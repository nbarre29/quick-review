package demo;

import static java.lang.System.out;

/*
 * utility class that is used for communicating between the two threads with wait() and notifyAll() 
 * methods via synchronized methods.
 * 
 * NOTE: This a typical example of splitting tasks among threads. 
 * A method calls notify/notifyAll( ) as the last thing it does (besides return).
 * Since the printOdd( ) and printEven( ) methods were void, the notifyAll( ) was the last statement.
 * If it were to return some value, the notifyAll( ) would have been placed just before the return statement.
 * 
 */
public class NumberUtility{
    boolean oddPrinted = false;
    
    public synchronized void printOdd(int number){
        while(oddPrinted == true){
            try{
                wait();  //waits until notified by even thread
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        out.println("printOdd() " + number);
        oddPrinted = true;
        notifyAll();  //notify all waiting threads
 
    }
    
    public synchronized void printEven(int number) {
        while (oddPrinted == false) {
            try {
                wait();  //waits until notified by the odd thread
 
            } catch (InterruptedException e) {
 
            }
        }
 
        oddPrinted = false;
        out.println("printEven() " + number);
        notifyAll();  //notify all waiting threads
    }
}