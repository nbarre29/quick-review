package demo;
 
public class NumberGenerator extends Thread {
 
    private NumberUtility numberUtility;
    private int maxNumber;
    private boolean isEvenNumber;
     
 
    public NumberGenerator(NumberUtility numberUtility, int maxNumber, boolean isEvenNumber) {
        this.numberUtility = numberUtility;
        this.maxNumber = maxNumber;
        this.isEvenNumber = isEvenNumber;
    }
 
    public void run() {
        int i = isEvenNumber == true ? 2 : 1;
        while (i <= maxNumber) {
            if(isEvenNumber == true) {
                numberUtility.printEven(i);
            }
            else {
                numberUtility.printOdd(i);    
            }
             
            i = i + 2;
        }
    }
     
     
    public static void main(String[] args) {
        NumberUtility numUtility = new NumberUtility(); //single instance shared by oddGen and evenGen threads
        final int MAX_NUM = 10; 
 
        //create 2 threads, one to generate odd numbers and the other to generate even numbers
        NumberGenerator oddGen = new NumberGenerator(numUtility, MAX_NUM, false);
        NumberGenerator evenGen = new NumberGenerator(numUtility, MAX_NUM, true);
         
        oddGen.start();  //start the thread - invokes the run() method on NumberGenerator
        evenGen.start(); //start the thread - invokes the run() method on NumberGenerator
         
    }
 
}

/*
OUTPUT:
printOdd() 1
printEven() 2
printOdd() 3
printEven() 4
printOdd() 5
printEven() 6
printOdd() 7
printEven() 8
printOdd() 9
printEven() 10
*/
