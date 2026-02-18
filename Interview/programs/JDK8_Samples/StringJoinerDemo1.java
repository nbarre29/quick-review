package demo;

import java.util.StringJoiner;

/**
 * http://docs.oracle.com/javase/8/docs/api/java/util/StringJoiner.html
 * 
 * See below blog from Stephen Colebourne which talks about the flaws in StringJoiner
 * http://blog.joda.org/2014/08/stringjoiner-in-java-se-8.html
 *
 */
public class StringJoinerDemo1 {

	public static void main(String[] args) {
		StringJoiner sj = new StringJoiner(":", "[", "]");
		sj.add("George").add("Sally").add("Fred");
		String desiredString = sj.toString();

		System.out.println(desiredString);
	}

}
