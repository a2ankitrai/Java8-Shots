package com.ank.java8.z_arbit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FortranForFormatter {

    private static String AMPERSAND = "&"; 
    private static int validStatmentLength = 65;
    private static String whiteSpace5 = new String("     ");
    private static String whiteSpace1 = new String(" ");

    public static void readFile(String fileName, String outputfileName) {

	try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

	    List<String> formattedStringList = stream

		    .map(line -> line.replace("&", ""))

		    .map(line -> line.trim())

		    .map(line -> {
			if (line.length() < validStatmentLength) {
			    return new String[] { whiteSpace5 + whiteSpace1 + line };
			} else {
			    return splitString(line);
			}
		    }).flatMap(Arrays::stream)

		    .collect(Collectors.toList());

	    PrintWriter writer = getWriter(outputfileName);
	    formattedStringList.stream().forEach(writer::println);
	    writer.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public static String[] splitString(String str) {

	String[] splitStringList = new String[2];
	for (int i = str.length() - 1; i >= 0; i--) {

	    if (str.charAt(i) == ',' && str.substring(0, i).length() < 65) {

		splitStringList[0] = whiteSpace5 + whiteSpace1 + str.substring(0, i + 1);
		splitStringList[1] = whiteSpace5 + AMPERSAND + whiteSpace1 + str.substring(i + 1);

		break;
	    }
	}

	return splitStringList;
    }

    public static PrintWriter getWriter(String outputfileName) {

	PrintWriter writer = null;
	
	// Change the file path here..
	String outputFilePathAndName = "/Users/ankirai/Downloads/Fortran_output.for";
	
	try { 
//	    writer = new PrintWriter(outputFilePathAndName);
	    writer = new PrintWriter(outputfileName);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	return writer;
    }

    public static void main(String[] args) {

	readFile(args[0], args[1]);
    }

}
