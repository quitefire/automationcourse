package com.courses.hotline.utils;


import static com.courses.hotline.enums.PropertiesKeys.*;
import static com.courses.hotline.utils.ProjectConstants.TEST_DATA_PROPERTIES_PATH;
import static com.courses.hotline.utils.ReadPropertiesUtil.getProperty;
import static com.courses.hotline.utils.RegistrationUtil.*;

public class DataProviderUtil {

    public static Object[][] getInvalidUserData() {


        String expectedEmptyFieldErrorMessage = getProperty(REG_EMPTY_FIELD_ERROR_MESSAGE_KEY.getKey(),
                TEST_DATA_PROPERTIES_PATH);

        String expectedInvalidFormatErrorMessage = getProperty(REG_INVALID_FORMAT_ERROR_MESSAGE_KEY.getKey(),
                TEST_DATA_PROPERTIES_PATH);

        String expectedShortPasswordErrorMessage = getProperty(REG_SHORT_PASSWORD_ERROR_MESSAGE_KEY.getKey(),
                TEST_DATA_PROPERTIES_PATH);

        String expectedEmailAlreadyTakenErrorMessage = getProperty(REG_ALREADY_TAKEN_EMAIL_ERROR_MESSAGE_KEY.getKey(),
                TEST_DATA_PROPERTIES_PATH);

        String expectedNicknameAlreadyTakenErrorMessage = getProperty(REG_ALREADY_TAKEN_NICKNAME_ERROR_MESSAGE_KEY.getKey(),
                TEST_DATA_PROPERTIES_PATH);

        User existingUser = getExistingUser();
        String empty = "";
        String noErrorMessage = "";
        String validPassword = "1234567";
        String invalidEmail = "sample$gmail.com";
        String invalidPassword = "pass^%^";
        String invalidNickname="#43";
        String shortPassword = "123";

        return new Object[][]{
                //#001 Try to register user with empty email, nickname, password fields
                {
                        empty,                            // email
                        empty,                            // nickname
                        empty,                            // password
                        expectedEmptyFieldErrorMessage,   // email field error message
                        expectedEmptyFieldErrorMessage,   // nickname field error message
                        expectedEmptyFieldErrorMessage    // password field error message
                },

                //#002 Try to register user with valid email but empty nickname, password fields
                {
                        generateEmail(),                // email
                        empty,                          // nickname
                        empty,                          // password
                        noErrorMessage,                 // email field error message
                        expectedEmptyFieldErrorMessage, // nickname field error message
                        expectedEmptyFieldErrorMessage  // password field error message
                },

                //#003 Try to register user with valid nickname but empty email, password fields
                {
                        empty,                          // email
                        generateNickname(),             // nickname
                        empty,                          // password
                        expectedEmptyFieldErrorMessage, // email field error message
                        noErrorMessage,                 // nickname field error message
                        expectedEmptyFieldErrorMessage  // password field error message
                },

                //#004 Try to register user with valid password  but empty nickname, email fields
                {
                        empty,                          // email
                        empty,                          // nickname
                        validPassword,                  // password
                        expectedEmptyFieldErrorMessage, // email field error message
                        expectedEmptyFieldErrorMessage, // nickname field error message
                        noErrorMessage                  // password field error message
                },

                //#005 Try to register user with valid email and nickname but with empty password
                {
                        generateEmail(),                // email
                        generateNickname(),             // nickname
                        empty,                          // password
                        noErrorMessage,                 // email field error message
                        noErrorMessage,                 // nickname field error message
                        expectedEmptyFieldErrorMessage  // password field error message
                },

                //#006 Try to register user with valid nickname and password but with empty email
                {
                        empty,                          // email
                        generateNickname(),             // nickname
                        validPassword,                  // password
                        expectedEmptyFieldErrorMessage, // email field error message
                        noErrorMessage,                 // nickname field error message
                        noErrorMessage                  // password field error message
                },

                //#007 Try to register user with valid email and password but with empty nickname
                {
                        generateEmail(),                // email
                        empty,                          // nickname
                        validPassword,                  // password
                        noErrorMessage,                 // email field error message
                        expectedEmptyFieldErrorMessage, // nickname field error message
                        noErrorMessage                  // password field error message
                },

                //#008 Try to register user with invalid format email,nickname and password
                {
                        invalidEmail,                     // email
                        invalidNickname,                  // nickname
                        invalidPassword,                  // password
                        expectedInvalidFormatErrorMessage,// email field error message
                        expectedInvalidFormatErrorMessage,// nickname field error message
                        expectedInvalidFormatErrorMessage // password field error message
                },

                //#009 Try to register user with short password
                {
                        generateEmail(),                  // email
                        generateNickname(),               // nickname
                        shortPassword,                    // password
                        noErrorMessage,                   // email field error message
                        noErrorMessage,                   // nickname field error message
                        expectedShortPasswordErrorMessage // password field error message
                },

                //#010 Try to register existing user
                {
                        existingUser.getEmail(),                 // email
                        existingUser.getNickname(),              // nickname
                        existingUser.getPassword(),              // password
                        expectedEmailAlreadyTakenErrorMessage,   // email field error message
                        expectedNicknameAlreadyTakenErrorMessage,// nickname field error message
                        noErrorMessage                           // password field error message
                }

        };
    }
}
