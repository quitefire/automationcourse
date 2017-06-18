package com.courses.week4.testng.listeners;

import com.courses.week3.conciseapi.wrappers.WebDriverProvider;
import org.testng.*;

public class BeforeMethodWebDriverProvider implements IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriverProvider.setupDriver();
        }
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriverProvider.cleanUp();
        }
    }
}