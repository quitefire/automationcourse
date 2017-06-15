package com.courses.week4.testng;

import org.testng.annotations.Test;

public class TimeoutTest {

    @Test(timeOut = 5000) // time in milliseconds
    public void testThisShouldPass() throws InterruptedException {
        Thread.sleep(4000);
    }

    @Test(timeOut = 1000)
    public void testThisShouldFail() {
    //    while (true) ;
    }

}