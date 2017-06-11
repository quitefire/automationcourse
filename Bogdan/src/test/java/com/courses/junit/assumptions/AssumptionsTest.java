package com.courses.junit.assumptions;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assume.assumeThat;

public class AssumptionsTest {

    @Test
    public void testA() {
        int x = 7;
        assumeThat(x, is(7));
        System.out.println("assumption is true!");
    }

    //The default JUnit runner treats tests with failing assumptions as ignored. Custom runners may behave differently.
    @Test
    public void testAssumptionFailed() {
        int x = 10;
        assumeThat(x, is(7));
        System.out.println("assumption failed!");
    }


}

