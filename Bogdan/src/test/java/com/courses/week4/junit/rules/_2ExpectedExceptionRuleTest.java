package com.courses.week4.junit.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class _2ExpectedExceptionRuleTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldTestExceptionMessage() {
        List<String> list = new ArrayList<>();

        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index: 0, Size: 0");
        list.get(0); // execution will never get past this line
    }
}
