package com.courses.week4.junit;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/*
        1. To ignore a test, why not just comment the test methods or @Test annotation?
        A : The test runner will not report the test.
        In IDE, the test runner will display the ignored tests with different icon or color, and highlight it, so that you know what tests are ignored.

        2. Why make a test that doesn’t test?
        A : For large project, many developers are handling different modules, the failed test may caused by other teams,
        you can add @Ignore on the test method to avoid the test to break the entire build process.

        A : Or you want someone to help to create the test, like @Ignore ("help for this method!"), the optional parameter(String) will be displayed in the test runner.

*/
public class _3IgnoredTest {

    @Test
    public void testMath1() {
        assertThat(1 + 1, is(2));
    }

    @Ignore
    @Test
    public void testMath2() {
        assertThat(1 + 2, is(5));
    }

    @Ignore("some one please create a test for Math3!")
    @Test
    public void testMath3() {
        //...
    }

    //  @Test
    public void testMath4() {
        assertThat(1 + 2, is(5));
    }
}