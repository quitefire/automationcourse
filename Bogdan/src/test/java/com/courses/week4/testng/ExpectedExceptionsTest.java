package com.courses.week4.testng;

import org.testng.annotations.Test;

public class ExpectedExceptionsTest {

	@Test(expectedExceptions = ArithmeticException.class,expectedExceptionsMessageRegExp = "/ by zero")
    public void divisionWithException() {
		int i = 1 / 0;
	}


}