package com.courses.week4.junit.categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ClassA {

    @Category(PerformanceTests.class)
    @Test
    public void test1() {
        assertThat(1 == 1, is(true));
    }

    @Test
    public void test2() {
        assertThat(1 == 1, is(true));
    }

}