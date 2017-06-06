package com.courses.week3;

import com.courses.hotline.fixtures.BaseTest;
import com.courses.week3.customconditions.CustomConditions;
import com.courses.week3.customconditions.TitleTextEqualsCondition;
import org.junit.Assert;
import org.junit.Test;

import static com.courses.week3.hotlinev1.utils.CoreConstants.SITE_URL;

public class CustomConditionTest extends BaseTest {

    @Test
    public void testCustomCondition1() {
        driver.get(SITE_URL);
        boolean isEqual = wait.until(new TitleTextEqualsCondition("Hotline - сравнить цены в интернет-магазинах Украины"));
        Assert.assertTrue(isEqual);
    }

    @Test
    public void testCustomCondition2() {
        driver.get(SITE_URL);
        boolean isEqual = wait.until(CustomConditions.titleTextEquals("Hotline - сравнить цены в интернет-магазинах Украины"));
        Assert.assertTrue(isEqual);
    }
}
