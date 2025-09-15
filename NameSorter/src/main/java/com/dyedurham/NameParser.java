package com.dyedurham;

import java.util.Arrays;

/*
 * parse name string to generate Name object
 */
public class NameParser {

	//generate Name object from string
	//last part in nameStr is last name, other parts in nameStr are given names
	//for instance, for a string of "Beau Tristan Bentley", "Bentley" would be the last name and "Beau" and "Tristan" would be two given names  
	//nameStr must have at least 1 given name and may have up to 3 given names
	public static Name parseNameFromString(String nameStr) {
	    // Split by spaces to get part
        String[] parts = nameStr.trim().split("\\s+");
        
        //Validation according to the length of parts
        if (parts.length < 2) {
            System.err.println("Invalid name: " + nameStr + " - must have at least one given name and one last name");
            return null;
        }
        
        if (parts.length > 4) {
            System.err.println("Invalid name: " + nameStr + " - cannot have more than 3 given names");
            return null;
        }
        
        // Last name is always the last part
        String lastName = parts[parts.length - 1];
        
        // Given names are all parts except the last one
        String[] givenNames = Arrays.copyOfRange(parts, 0, parts.length - 1);
        
        return new Name(lastName, givenNames);		
	}
	
}
