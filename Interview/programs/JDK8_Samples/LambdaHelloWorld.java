package demo;

/**
 * This is a basic usage of lambda expression. HelloWorld is in an interface and
 * on the fly at main method, we are providing an implementation for that
 * interface. After implementation, we use that instance and invoke its single
 * method. There will be always only one method and so the lambda expression
 * need not specify the method name.
 *
 */
public class LambdaHelloWorld {
	interface HelloWorld {
		String hello(String name);
	}

	public static void main(String[] args) {
//	    HelloWorld helloWorld = (String str) -> "Hello "+ str;	
//		HelloWorld helloWorld = str -> "Hello "+ str;
		HelloWorld helloWorld = (String name) -> {
			return "Hello " + name;
		};
		
		
		System.out.println(helloWorld.hello("Joe"));
	}
}