package com.dyedurham;

public class Name {

	private String[] givenNames;
	
	private String lastName;
	
	public Name(String lastName, String[] givenNames) {
        this.lastName = lastName;
        this.givenNames = givenNames;
	}
	
	public String[] getGivenNames() {
		return this.givenNames;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	@Override
    public String toString() {
        return String.join(" ", givenNames) + " " + lastName;
    }	
}
