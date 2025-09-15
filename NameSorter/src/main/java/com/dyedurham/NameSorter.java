package com.dyedurham;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class NameSorter {

	public static void main(String[] args) {
		
		String inputFile = args[0];
		String outputFile = "sorted-names-list.txt";
		try {
			//read all name strings from input file
    		List<String> names = Files.readAllLines(Paths.get(inputFile));  
			
			List<String> sortedName = names
			    .stream()
			    .map(nameStr->NameParser.parseNameFromString(nameStr))     //convert each name string to Name object
			    .filter(name->name!=null)                                  //filter out invalid name string
			    .sorted(new NameComparator())                              //sorting
			    .map(name->{
			    	String nameStr = name.toString();                      //convert Name object back to name string
			    	System.out.println(nameStr);                           //print name string to screen
			    	return nameStr;
			    })       
			    .collect(Collectors.toList());
			
			// Write sorted names to output file
            Files.write(Paths.get(outputFile), sortedName);
            
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
