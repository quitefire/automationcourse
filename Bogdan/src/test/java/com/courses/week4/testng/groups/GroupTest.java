package com.courses.week4.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/*
        runSelenium() and runSelenium1() are belong to group selenium-test.
		testConnectOracle() and testConnectMsSQL() are belong to group database.
		runFinal() will be executed if groups selenium-test and database are passed.*/
public class GroupTest {

    @BeforeGroups("database")
    public void setupDB() {
        System.out.println("setupDB()");
    }

    @AfterGroups("database")
    public void cleanDB() {
        System.out.println("cleanDB()");
    }

    @Test(groups = "selenium-test")
    public void runSelenium() {
        System.out.println(getClass() + " runSelenium()");
    }

    @Test(groups = "selenium-test")
    public void runSelenium1() {
        System.out.println(getClass() + " runSelenium1()");
    }

    @Test(groups = "database")
    public void testConnectOracle() {
        System.out.println("testConnectOracle()");
    }

    @Test(groups = "database")
    public void testConnectMsSQL() {
        System.out.println("testConnectMsSQL");
    }


    // dependsOnGroups = database, selenium-test. Will be ignored if any of tests included in these groups fails
    @Test(dependsOnGroups = {"database", "selenium-test"})
    public void runFinal() {
        System.out.println("runFinal");
    }

}