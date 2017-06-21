package automation.hotline;

import automation.hotline.pages.HomePage;
import automation.hotline.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static automation.hotline.constants.CoreConstants.errorText;

/**
 * Created by inspiron on 21.06.2017.
 */
public class RegistrationPageTest extends BaseTest {

    @DataProvider

    public static Object[][] getData() {

        return new Object[][]{{"", "Test123","asddasd",errorText,"",""},
                              {"", "","adasdad",errorText,errorText,""},
                                {"","","",errorText,errorText,errorText},
                {"adasd@i.ua","","","",errorText,errorText},
                {"sasdas@i.ua","dasdasd","","","",errorText}};

    }

    @Test (dataProvider = "getData")
    public void testUnsuccessRegistration(String email, String nick,
                                          String password, String errorMail,
                                          String errorNick, String errorPassword) {
        String[] errorTextArray = {errorMail,errorNick,errorPassword};
        HomePage hp = new HomePage(driver);
        hp.openPage();
        hp.searchRegistrationPage();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillUserEmailField(email,nick,password);
        Assert.assertEquals(errorTextArray,registrationPage.errorArray());

    }


    @Test
    public void testSuccessRegistration() {
        HomePage hp = new HomePage(driver);
        hp.openPage();
        hp.searchRegistrationPage();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillUserEmailField("dadwwds@i.ua", "ddwwdasd", "ddddddds");
        Assert.assertEquals(true, registrationPage.isRegistrationSuccess());

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
