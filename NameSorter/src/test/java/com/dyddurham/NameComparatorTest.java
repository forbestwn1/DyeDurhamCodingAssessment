package com.dyddurham;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dyedurham.Name;
import com.dyedurham.NameComparator;

public class NameComparatorTest {

	NameComparator compartor;
	
	@Before
	public void setup() {
		this.compartor = new NameComparator(); 
    }	
	
	@Test
	public void testCompare_ifBothLastNameGivenNameEqual_shouldReturnEqual() {
		Name name1 = new Name("A", new String[] {"C"});
		Name name2 = new Name("A", new String[] {"C"});
		Assert.assertTrue(this.compartor.compare(name1, name2)==0); 
	}

	@Test
	public void testCompare_ifDifferentLastName_shouldIgnoreGivenName() {
		Name name1 = new Name("A", new String[] {"C"});
		Name name2 = new Name("B", new String[] {"D"});
		Assert.assertTrue(this.compartor.compare(name1, name2)<0); 
		
		Name name3 = new Name("A", new String[] {"D"});
		Name name4 = new Name("B", new String[] {"C"});
		Assert.assertTrue(this.compartor.compare(name3, name4)<0); 
	}

	@Test
	public void testCompare_ifSameLastName_shouldCompareGivenName() {
		Name name1 = new Name("A", new String[] {"C", "F"});
		Name name2 = new Name("A", new String[] {"D", "A"});
		Assert.assertTrue(this.compartor.compare(name1, name2)<0); 

		Name name3 = new Name("A", new String[] {"K", "C", "F"});
		Name name4 = new Name("A", new String[] {"K", "D", "A"});
		Assert.assertTrue(this.compartor.compare(name3, name4)<0); 
    }

	@Test
	public void testCompare_ifSameLastNameAndMoreGivenName_shouldMoreGivenNameWin() {
		Name name1 = new Name("A", new String[] {"C", "D"});
		Name name2 = new Name("A", new String[] {"C"});
		Assert.assertTrue(this.compartor.compare(name1, name2)>0); 
	}

}
