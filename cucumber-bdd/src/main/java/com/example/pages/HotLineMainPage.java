package com.example.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HotLineMainPage {

    public static void openPage() {
        open("");
    }

    public static void searchFor(String word) {
        $("#searchbox").setValue(word).pressEnter();
    }

    public static void openRegistrationForm() {
        $("#mm-0 div.login> a").click();
    }
}
