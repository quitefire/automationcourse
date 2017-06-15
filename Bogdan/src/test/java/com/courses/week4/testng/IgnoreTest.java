package com.courses.week4.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IgnoreTest {

    @Test //default enable=true
    public void test1() {
        Assert.assertEquals(true, true);
    }

    @Test(enabled = true)
    public void test2() {
        Assert.assertEquals(true, true);
    }

    // won't be marked as ignored by IDE
    @Test(enabled = false)
    public void test3() {
        Assert.assertEquals(true, true);
    }

}