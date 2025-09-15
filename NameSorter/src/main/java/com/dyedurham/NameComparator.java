package com.dyedurham;

import java.util.Comparator;

/*
 * Comparator for Name. 
 *     first order by last name, 
 *     then by any given names the person may have
 */
public class NameComparator implements Comparator<Name>{

	@Override
	public int compare(Name name1, Name name2) {
		// First compare by last name
        int lastNameCompare = name1.getLastName().compareTo(name2.getLastName());
        if (lastNameCompare != 0) {
            return lastNameCompare;
        }
        
        // If last names are equal, compare by given names
        String[] givenNames1 = name1.getGivenNames();
        String[] givenNames2 = name2.getGivenNames();
        
        // Compare each given name in order
        int minLength = Math.min(givenNames1.length, givenNames2.length);
        for (int i = 0; i < minLength; i++) {
            int givenNameCompare = givenNames1[i].compareTo(givenNames2[i]);
            if (givenNameCompare != 0) {
                return givenNameCompare;
            }
        }
        
        // If all given names are equal up to min length, the name with more given names win 
        return Integer.compare(givenNames1.length, givenNames2.length);        
	}

}
