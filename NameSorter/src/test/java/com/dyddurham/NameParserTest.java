package com.dyddurham;

import org.junit.Assert;
import org.junit.Test;

import com.dyedurham.Name;
import com.dyedurham.NameParser;

public class NameParserTest {

	@Test
	public void testParseNameFromString_ifValid_shouldReturnParsedName() {
		//with one first name
		Name name1 = NameParser.parseNameFromString("Mathew Clarke");
		Assert.assertEquals("Clarke", name1.getLastName());
		Assert.assertArrayEquals(new String[]{"Mathew"}, name1.getGivenNames());
		
		//with two first name
		Name name2 = NameParser.parseNameFromString("Uriah Mathew Clarke");
		Assert.assertEquals("Clarke", name2.getLastName());
		Assert.assertArrayEquals(new String[]{"Uriah", "Mathew"}, name2.getGivenNames());
		
		//with three first name
		Name name3 = NameParser.parseNameFromString("Hunter Uriah Mathew Clarke");
		Assert.assertEquals("Clarke", name3.getLastName());
		Assert.assertArrayEquals(new String[]{"Hunter", "Uriah", "Mathew"}, name3.getGivenNames());
		
	}

	@Test
	public void testParseNameFromString_ifInvalid_shouldReturnNull() {
		Assert.assertNull(NameParser.parseNameFromString("Mike"));
		Assert.assertNull(NameParser.parseNameFromString("Mike Hunter Uriah Mathew Clarke"));
	}

}
