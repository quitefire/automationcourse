package com.courses.week4.hamcrest;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ZeroCheck extends TypeSafeMatcher<Integer> {

    //Shows the value when exception occurs.
    @Override
    public void describeTo(Description desc) {
        desc.appendText("0");
    }

    //Business logic of matcher is included.
    @Override
    protected boolean matchesSafely(Integer integer) {
        return integer == 0;
    }

    //developers will call this Matcher class using a "isZero" signature.
    @Factory
    public static <T> Matcher<Integer> isZero() {
        return new ZeroCheck();
    }
}