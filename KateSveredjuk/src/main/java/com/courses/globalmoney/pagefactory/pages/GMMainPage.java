package com.courses.globalmoney.pagefactory.pages;

import com.courses.globalmoney.pagefactory.widgets.LoginForm;
import com.courses.globalmoney.utils.SiteConstants;
import org.openqa.selenium.WebDriver;

public class GMMainPage extends BasePage {


    /* breaks encapsulation but quite handy in tests itself , we don't have to duplicate methods
     another option would be to make login form private but create a getter and use it as follows in test :
     mainPage.getLoginForm().loginAs()
    */
    public final LoginForm loginForm;

    public GMMainPage(WebDriver driver) {
        super(driver);
        this.loginForm = new LoginForm(driver);
    }

    public GMMainPage open() {
        driver.get(SiteConstants.SITE_URL);
        return this;
    }

}
