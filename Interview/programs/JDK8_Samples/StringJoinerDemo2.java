package demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * http://docs.oracle.com/javase/8/docs/api/java/util/StringJoiner.html
 *
 */
public class StringJoinerDemo2 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		String commaSeparatedNumbers = numbers.stream().map(i -> i.toString())
				.collect(Collectors.joining(", "));

		System.out.println(commaSeparatedNumbers);

	}

}
