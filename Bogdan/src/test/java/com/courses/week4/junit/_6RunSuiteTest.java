package com.courses.week4.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        _1BasicAnnotationTest.class, //test case 1
        _3IgnoredTest.class     //test case 2
})
public class _6RunSuiteTest {
    //normally, this is an empty class
}