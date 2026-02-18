package demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * In this example, We will read the lines as stream and fetch each line one at a time and check it for word "password".
 *
 */
public class ReadLines1 {

	public static void main(String[] args) throws IOException {
		readStreamOfLinesUsingFiles();

	}
	
private static void readStreamOfLinesUsingFiles() throws IOException 
 {
		Stream<String> lines = Files.lines(Paths.get("F:\\delete", "data.txt"));
		Optional<String> hasPassword = lines.filter(s -> s.contains("password")).findFirst();
		if (hasPassword.isPresent()) {
			System.out.println(hasPassword.get());
		}
		// Close the stream and it's underlying file as well
		lines.close();
	}

}