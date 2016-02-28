package dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRegex {

	@Test
	public void test() {
		
		boolean flag = false;
		
		String number = "sa s s s s s s(da)";
//		float floatNumber = Float.valueOf(number);
		String regexValidator = "^[A-Za-z0-9\\s+()]{2,15}$";
		String floatRegexValidator = "^[0-9]{1,15}$";
		
		if(number.matches(regexValidator)){
			flag = true;
		}
		
		assertTrue(flag);
		
		
		
		
	}

}
