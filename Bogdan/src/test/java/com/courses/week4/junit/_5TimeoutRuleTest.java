package com.courses.week4.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

//this rule will apply to all the test methods in a class, including @Before and @After
public class _5TimeoutRuleTest {

    //global timeout rule
    @Rule
    public Timeout globalTimeout = Timeout.seconds(1);


    @Before
    public void setUp() throws Exception {
        Thread.sleep(2000);
    }

    //This test will be failed, because it will take more than 1 second to finish!
    @Test
    public void testSlowMethod1() throws Exception {
        //...
        TimeUnit.SECONDS.sleep(5000);
    }

    //passed
    @Test
    public void testSlowMethod2() {
        //...
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
    }
}