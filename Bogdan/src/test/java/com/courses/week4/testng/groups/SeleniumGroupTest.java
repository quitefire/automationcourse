package com.courses.week4.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "selenium-test")
public class SeleniumGroupTest {

    public void runSelenium() {
        System.out.println(getClass() + " runSelenium()");
    }

    public void runSelenium1() {
        System.out.println(getClass() + " runSelenium1()");
    }

}