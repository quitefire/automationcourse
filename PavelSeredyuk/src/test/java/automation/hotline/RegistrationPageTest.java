package automation.hotline;

import automation.hotline.model.RegistrationData;
import automation.hotline.pages.HomePage;
import automation.hotline.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static automation.hotline.constants.CoreConstants.errorText;

/**
 * Created by inspiron on 21.06.2017.
 */
public class RegistrationPageTest extends BaseTest {

    /**
     * todo: create a model RegistrationData store email, nick, password and pass it instead of those variables where it's needed
     * Use a list to pass errors
     */
    @DataProvider
    public static Object[][] getData() {
        return new Object[][]{

                {new RegistrationData("", "Test324234323", "asddasd"), Arrays.asList(errorText, "", "")},
                {new RegistrationData("", "", "adasdad"), Arrays.asList(errorText, errorText, "")},
                {new RegistrationData("", "", ""), Arrays.asList(errorText, errorText, errorText)},
                {new RegistrationData("adasd@i.ua", "", ""), Arrays.asList("", errorText, errorText)},
                {new RegistrationData("sasdas@i.ua", "dasdasd", ""), Arrays.asList("", "", errorText)}
        };
    }

    @Test(dataProvider = "getData")
    public void testRegistrationWithInvalidData(RegistrationData registrationData, List<String> expectedMessages) {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        RegistrationPage registrationPage = homePage.openRegistrationPage();
        registrationPage.registerAs(registrationData);
        List<String> actualMessages = registrationPage.getInputErrorMessages();
        Assert.assertEquals(expectedMessages, actualMessages);

    }


    @Test
    public void testSuccessfulRegistration() {
        RegistrationData validData = new RegistrationData("dadwwds@i.ua", "ddwwdasd", "ddddddds");
        HomePage hp = new HomePage(driver);
        hp.openPage();
        hp.openRegistrationPage();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registerAs(validData);

        //User will be redirected to another page in case of success , so create a page and check somethings at this page that identifies successful registration

      //  Assert.assertEquals(true, registrationPage.isRegistrationSuccess());

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
