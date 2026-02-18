package demo;

/**
 * Accessing Local and Class Variables in Lambda Expression.
 * 
 * This is another basic level code showing how we can access the local and
 * class level variables in a lambda expression. Also note how we have passed
 * reference for the Runnable.
 *
 */
public class LambdaVariableAccess {
	public String wildAnimal = "Lion";

	public static void main(String[] arg) {
		new LambdaVariableAccess().lambdaExpression();
	}

	public void lambdaExpression() {
		String domesticAnimal = "Dog";

		new Thread(() -> {
			System.out.println("Class Level: " + this.wildAnimal);
			System.out.println("Method Level: " + domesticAnimal);
		}).start();
	}
}
