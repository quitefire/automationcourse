package com.courses.week4.testng.retry.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RetryCountIfFailed {

    // Specify how many times you want to
    // retry the test if failed.
    // Default value of retry count is 0
    int value() default 0;
}