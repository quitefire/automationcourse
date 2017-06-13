package com.courses.week4.junit;

import org.junit.Test;


//This timeout example only applies to a single test method. And the timeout value is in milliseconds.

public class _4TimeoutTest {

    //This test will always failed :)
    @Test(timeout = 1000)
    public void infinity() {
        while (true) ;
    }

    //This test can't run more than 5 seconds, else failed
    @Test(timeout = 5000)
    public void testSlowMethod() {
        //...
    }

}