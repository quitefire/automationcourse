package com.courses.week4.testng.lifecycle;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
@BeforeSuite - For suite test, run before all tests in this suite have run.
@AfterSuite -  For suite test, run after all tests in this suite have run.

@BeforeTest - For suite test, run before any test method belonging to the classes inside the <test> tag is run.
@AfterTest - For suite test, run after all the test methods belonging to the classes inside the <test> tag have run.

@BeforeGroups: Run before the first test method that belongs to the group is invoked.
@AfterGroups: Run after the last test method that belongs to the groups is invoked.

@BeforeClass - Run before the first test method in the current class is invoked.
@AfterClass - Run after all the test methods in the current class have been run.

@BeforeMethod - Run before each test method.
@AfterMethod - Run after each test method.*/
public class TestConfiguration {

    @BeforeGroups("shopping")
    public void beforeGroups() {
        System.out.println("@BeforeGroups");
    }

    @AfterGroups("shopping")
    public void afterGroups() {
        System.out.println("@AfterGroups");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("@BeforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("@AfterMethod");
    }

    @Test(groups = "shopping")
    public void runTest1() {
        System.out.println("@Test - runTest1");
    }

    @Test
    public void runTest2() {
        System.out.println("@Test - runTest2");
    }
}