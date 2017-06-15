package com.courses.week4.testng.listeners;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(DisableTransformer.class)
public class DisableOnOsTest {

    @DisableOnOS("Windows")
    @Test
    public void shouldBeDisabledOnWindows() throws Exception {
        System.out.println("Disabled on Windows");
    }

    @DisableOnOS("Mac")
    @Test
    public void shouldBeDisabledOnMac() throws Exception {
        System.out.println("Disabled on Mac");
    }
}