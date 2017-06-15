package com.courses.week4.testng.retry;

import com.courses.week4.testng.retry.annotations.RetryCountIfFailed;
import com.courses.week4.testng.retry.listeners.RetryTransformer;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(RetryTransformer.class)
public class RetryTest {

    @Test
    @RetryCountIfFailed(3)
    public void shouldBeRetried() {
        Assert.fail();
    }

    @Test
    public void shouldNotBeRetried() {
        Assert.fail();
    }
}