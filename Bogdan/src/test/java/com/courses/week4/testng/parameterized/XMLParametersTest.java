package com.courses.week4.testng.parameterized;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class XMLParametersTest {

    private SoftAssert softAssert = new SoftAssert();

    @Test
    @Parameters({"browser", "url", "timeout", "optional"})
    public void testParameters(String browser, String url, int timeout, @Optional String optional) {
        softAssert.assertEquals(browser, "chrome");
        softAssert.assertEquals(url, "http://site.com");
        softAssert.assertEquals(timeout, 6);
        softAssert.assertAll();
    }
}
