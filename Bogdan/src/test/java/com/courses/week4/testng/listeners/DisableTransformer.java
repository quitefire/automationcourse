package com.courses.week4.testng.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class DisableTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        if (isDisabled(testMethod)) {
            annotation.setEnabled(false);
        }
    }

    private boolean isDisabled(Method testMethod) {
        DisableOnOS disableAnnotation = testMethod.getDeclaredAnnotation(DisableOnOS.class);
        return disableAnnotation != null && System.getProperty("os.name").startsWith(disableAnnotation.value());
    }
}

