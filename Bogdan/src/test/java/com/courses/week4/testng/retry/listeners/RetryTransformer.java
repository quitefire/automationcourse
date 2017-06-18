package com.courses.week4.testng.retry.listeners;

import com.courses.week4.testng.retry.annotations.RetryCountIfFailed;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        if (isAnnotatedWithRetry(testMethod)) annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }

    private boolean isAnnotatedWithRetry(Method testMethod) {
        return testMethod.getDeclaredAnnotation(RetryCountIfFailed.class) != null;
    }
}