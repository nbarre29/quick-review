package demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Print the number of lines that contain the string password in it.
 * We are using data.txt as the input file.
 *
 */
public class ReadLines2 {

	public static void main(String[] args) throws IOException {
		readStreamOfLinesUsingFiles();

	}
	
private static void readStreamOfLinesUsingFiles() throws IOException 
 {
		Stream<String> lines = Files.lines(Paths.get("F:\\delete", "data.txt"));
		long hasPassword = lines.filter(s -> s.contains("password")).count();
	    System.out.println("There are "+ hasPassword + " lines containg the word password in it.");
		// Close the stream and it's underlying file as well
		lines.close();
	}

}