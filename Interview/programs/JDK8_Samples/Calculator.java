package demo;

/**
 * Structure of a Lambda Expression: 
 * (Argument List) Arrow Token {Body } 
 * (type argument, ....) –> { java statements; } 
 * A comma-separated list of formal parameters enclosed in parentheses.
 * 
 * 
 * 
 * ( ) Parentheses 
 * { } Braces or curly brackets 
 * < > Chevrons or angle brackets
 * The arrow token, ->
 * 
 * 
 * Example Lambda Expressions:
 * () -> { System.out.println("Hello World!");}
 * (int a, int b) -> a + b
 * () -> { return 1; }
 * (String name) -> { System.out.println("Hello "+name); }
 * n -> n % 2 != 0
 * 
 * 
 * In a lambda expression, you must enclose statements in braces ({}). However,
 * you do not have to enclose a void method invocation in braces. For example,
 * the following is a valid lambda expression:
 * email -> System.out.println(email)
 * 
 * 
 * 
 * http://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 * 
 * Note that a lambda expression looks a lot like a method declaration; you can
 * consider lambda expressions as anonymous methods - methods without a name.
 * 
 * 
 * 
 * The following example, Calculator, is an example of lambda expressions that
 * take more than one formal parameter:
 *
 * The method operateBinary performs a mathematical operation on two integer
 * operands. The operation itself is specified by an instance of IntegerMath.
 * The example defines two operations with lambda expressions, addition and
 * subtraction.
 */
public class Calculator {
	  
    interface IntegerMath {
        int operation(int a, int b);   
    }
  
    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }
 
    public static void main(String... args) {
    
        Calculator myApp = new Calculator();
		IntegerMath addition = (a,b)->{return (a+b);};
//		IntegerMath addition = (int a,int b)->{return (a+b);};
//        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        System.out.println("40 + 2 = " +
            myApp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " +
            myApp.operateBinary(20, 10, subtraction));    
    }
}