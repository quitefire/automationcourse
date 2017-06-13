package com.courses.week4.junit;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

//Sorts by method name
//https://github.com/junit-team/junit4/wiki/Test-execution-order
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class _7ExecutionOrderTest {

    @Test
    public void testB() {
        assertThat(1 + 1, is(2));
    }

    @Test
    public void test1() {
        assertThat(1 + 1, is(2));
    }

    @Test
    public void testA() {
        assertThat(1 + 1, is(2));
    }

    @Test
    public void test2() {
        assertThat(1 + 1, is(2));
    }

    @Test
    public void testC() {
        assertThat(1 + 1, is(2));
    }
}