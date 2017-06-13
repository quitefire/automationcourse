package com.courses.week4.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class _2InheritanceAnnotationTest {

    @BeforeClass
    public static void runOnceBeforeChildClass() {
        System.out.println("@BeforeClass - runOnceBeforeChildClass");
    }

    @AfterClass
    public static void runOnceAfterChildClass() {
        System.out.println("@AfterClass - runOnceAfterChildClass");
    }

    @Before
    public void runBeforeChildTestMethod() {
        System.out.println("@Before - runBeforeTestChildMethod");
    }

    @After
    public void runAfterChildTestMethod() {
        System.out.println("@After - runAfterChildTestMethod");
    }
}
