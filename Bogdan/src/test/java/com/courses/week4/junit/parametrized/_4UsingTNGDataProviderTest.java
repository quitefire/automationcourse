package com.courses.week4.junit.parametrized;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

// for more features follow https://github.com/TNG/junit-dataprovider/wiki/Features

@RunWith(DataProviderRunner.class)
public class _4UsingTNGDataProviderTest {

    @DataProvider
    public static Object[][] dataProviderAdd() {
        return new Object[][]{
                {0, 0, 0},
                {1, 1, 2},
        };
    }

    @Test
    @UseDataProvider("dataProviderAdd")
    public void testAdd(int a, int b, int expected) {
        int result = a + b;
        assertEquals(expected, result);
    }
}


