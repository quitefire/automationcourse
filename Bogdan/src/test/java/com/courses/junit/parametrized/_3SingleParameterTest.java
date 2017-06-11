package com.courses.junit.parametrized;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class _3SingleParameterTest {

    //default value = 0
    @Parameterized.Parameter
    public String domainName;

    //Single parameter, use Object[]
/*    @Parameters(name = "{index}: testDomain - {0}")
    public static Object[] data() {
        return new Object[]{
                "google.com",
                "mkyong.com",
                "twitter.com"
        };
    }*/

    @Parameters
    public static Iterable<?> data() {
        return Arrays.asList("google.com", "mkyong.com", "twitter.com");
    }

    @Test
    public void test_valid_domain() {
        Assert.assertThat(DomainUtils.isValid(domainName), is(true));
    }
}

class DomainUtils {

    private static final String DOMAIN_NAME_PATTERN = "^((?!-)[A-Za-z0-9-]{1,63}(?<!-)\\.)+[A-Za-z]{2,6}$";
    private static Pattern pDomainName = Pattern.compile(DOMAIN_NAME_PATTERN);

    public static boolean isValid(String domainName) {
        return pDomainName.matcher(domainName).find();
    }
}