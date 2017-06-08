package com.courses.hotline;

import com.courses.hotline.utils.ReadPropertiesUtil;
import com.courses.hotline.utils.RegistrationUtil;

/**
 * Created by apple on 6/8/17.
 */
public class Test {

    public static void main(String[] args) {

        System.out.println(ReadPropertiesUtil.getProperty("registration_successful_message", ""));
    }
}
