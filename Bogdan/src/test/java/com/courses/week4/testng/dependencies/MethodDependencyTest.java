package com.courses.week4.testng.dependencies;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MethodDependencyTest {

    @Test
    public void method1() {
        System.out.println("This is method 1");
    //    throw new RuntimeException();
        //  Assert.fail();
    }

    //This test will be  ignored
    @Test(dependsOnMethods = {"method1"})
    public void method2() {
        System.out.println("This is method 2");
    }
}