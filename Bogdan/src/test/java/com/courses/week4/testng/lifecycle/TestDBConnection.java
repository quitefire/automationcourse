package com.courses.week4.testng.lifecycle;

import org.testng.annotations.Test;

public class TestDBConnection {

	@Test
    public void runOtherTest1() {
		System.out.println("@Test - runOtherTest1");
	}

	@Test
	public void runOtherTest2() {
		System.out.println("@Test - runOtherTest2");
	}

}