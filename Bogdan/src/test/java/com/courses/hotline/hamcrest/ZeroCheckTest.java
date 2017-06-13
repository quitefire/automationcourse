package com.courses.hotline.hamcrest;

import org.junit.Test;

import static com.courses.week4.hamcrest.ZeroCheck.isZero;
import static org.junit.Assert.assertThat;

public class ZeroCheckTest {

    @Test
    public void zerCheckT() {
        assertThat(0, isZero());
    }

    // Throws an error as actual value is non zero value.
    @Test
    public void zerCheckTest() {
        assertThat(4, isZero());
    }
}
