package com.demo.listeners;

import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LogListener extends TestListenerAdapter {
    private ByteArrayOutputStream request = new ByteArrayOutputStream();
    private ByteArrayOutputStream response = new ByteArrayOutputStream();

    private PrintStream requestVar = new PrintStream(request, true);
    private PrintStream responseVar = new PrintStream(response, true);

    @Override
    public void onStart(ITestContext iTestContext) {
        RestAssured.filters(new ResponseLoggingFilter(LogDetail.ALL, responseVar),
                new RequestLoggingFilter(LogDetail.ALL, requestVar));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logRequest(request);
        logResponse(response);
    }

    @Attachment("request")
    private byte[] logRequest(ByteArrayOutputStream stream) {
        return attach(stream);
    }

    @Attachment("response")
    private byte[] logResponse(ByteArrayOutputStream stream) {
        return attach(stream);
    }

    private byte[] attach(ByteArrayOutputStream log) {
        byte[] array = log.toByteArray();
        log.reset();
        return array;
    }
}