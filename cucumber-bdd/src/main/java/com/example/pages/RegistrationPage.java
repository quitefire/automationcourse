package com.example.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.example.data.User;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    public static void registerAs(User user) {
        $(By.name("email")).val(user.getEmail());
        $(By.name("nick")).val(user.getNick());
        $("#passw1").val(user.getPassword());
        $("#submit-button").click();
    }

    public static List<String> getValidationMessages() {
//        return $$("[id^='error_']")
//                .stream()
//                .map(SelenideElement::text)
//                .collect(toList());

        List<String> errorMessages = new ArrayList<>();

        for (SelenideElement element : Arrays.asList($("#error_email"), $("#error_nick"), $("#error_password"))) {
            try {
                String text = element.getText();
                // trim suggested "nick" in case of the one you're using is already taken
                String substring = StringUtils.substringBeforeLast(text, ":");
                errorMessages.add(substring);
            } catch (ElementNotFound e) {
                errorMessages.add(StringUtils.EMPTY);
            }
        }
        return errorMessages;
    }
}