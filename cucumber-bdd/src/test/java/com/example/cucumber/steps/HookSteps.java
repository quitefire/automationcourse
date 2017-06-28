package com.example.cucumber.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.screenshot;

public class HookSteps {

    @Before
    public void beforeScenario() {
        clearBrowserCookies();
    }

    @After
    public void after(Scenario scenario) {

        if (!scenario.isFailed()) return;
        String path = screenshot(UUID.randomUUID().toString());
        byte[] bytes = readScreenshot(path);
        scenario.embed(bytes, "image/png");
    }

    private byte[] readScreenshot(String path) {
        try {
            return Files.readAllBytes(new File(path).toPath());
        } catch (IOException e) {
            //log exception
        }
        return new byte[]{};
    }
}
