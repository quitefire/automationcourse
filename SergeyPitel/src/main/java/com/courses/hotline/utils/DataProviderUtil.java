package com.courses.hotline.utils;


import static com.courses.hotline.enums.PropertiesKeys.*;
import static com.courses.hotline.utils.ProjectConstants.TEST_DATA_PROPERTIES_PATH;
import static com.courses.hotline.utils.ReadPropertiesUtil.getProperty;
import static com.courses.hotline.utils.RegistrationUtil.*;

public class DataProviderUtil {

//
//    // Try to register existing user
//    {
//        existingUser.getEmail(),                // email
//                existingUser.getNickname(),             // nickname
//                existingUser.getPassword(),             // password
//                expectedEmailAlreadyTakenMessage,       // email field error message
//                expectedNicknameAlreadyTakenMessage,    // nickname field error message
//                ""                                      // password field error message
//    }

    public static Object[][] getInvalidUserParameters() {

        User existingUser = getExistingUser();

        String expectedEmptyFieldMessage = getProperty(REGISTRATION_EMPTY_FIELD_MESSAGE_KEY.getKey(),
                TEST_DATA_PROPERTIES_PATH);

        String expectedInvalidFormatMessage = getProperty(REGISTRATION_INVALID_FORMAT_MESSAGE_KEY.getKey(),
                TEST_DATA_PROPERTIES_PATH);

        String expectedEmailAlreadyTakenMessage = getProperty(REGISTRATION_ALREADY_TAKEN_EMAIL_MESSAGE_KEY.getKey(),
                TEST_DATA_PROPERTIES_PATH);

        String expectedNicknameAlreadyTakenMessage = getProperty(REGISTRATION_ALREADY_TAKEN_NICKNAME_MESSAGE_KEY.getKey(),
                TEST_DATA_PROPERTIES_PATH);

        String validPassword = "1234567";

        return new Object[][]{
                // Try to register with empty email, nickname, password fields
                {
                        "",                          // email
                        "",                          // nickname
                        "",                          // password
                        expectedEmptyFieldMessage,   // email field error message
                        expectedEmptyFieldMessage,   // nickname field error message
                        expectedEmptyFieldMessage    // password field error message
                },

                // Try to register with valid email but empty nickname, password fields
                {
                        generateEmail(),            // email
                        "",                         // nickname
                        "",                         // password
                        "",                         // email field error message
                        expectedEmptyFieldMessage,  // nickname field error message
                        expectedEmptyFieldMessage   // password field error message
                },

                // Try to register with valid nickname but empty email, password fields
                {
                        "",                         // email
                        generateNickname(),         // nickname
                        "",                         // password
                        expectedEmptyFieldMessage,  // email field error message
                        "",                         // nickname field error message
                        expectedEmptyFieldMessage   // password field error message
                },

                // Try to register with valid password  but empty nickname, email fields
                {
                        "",                         // email
                        "",                         // nickname
                        validPassword,              // password
                        expectedEmptyFieldMessage,  // email field error message
                        expectedEmptyFieldMessage,  // nickname field error message
                        ""                          // password field error message
                },

                // Try to register with valid email and nickname but with empty password
                {
                        generateEmail(),            // email
                        generateNickname(),         // nickname
                        "",                         // password
                        "",                         // email field error message
                        "",                         // nickname field error message
                        expectedEmptyFieldMessage   // password field error message
                },

                // Try to register with valid nickname and password but with empty email
                {
                        "",                         // email
                        generateNickname(),         // nickname
                        validPassword,              // password
                        expectedEmptyFieldMessage,  // email field error message
                        "",                         // nickname field error message
                        ""                          // password field error message
                },

                // Try to register with valid email and password but with empty nickname
                {
                        generateEmail(),             // email
                        "",                          // nickname
                        validPassword,               // password
                        "",                          // email field error message
                        expectedEmptyFieldMessage,   // nickname field error message
                        ""                           // password field error message
                }

        };
    }
}
