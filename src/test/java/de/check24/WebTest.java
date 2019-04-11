package de.check24;

import com.relevantcodes.extentreports.LogStatus;
import de.check24.Pages.*;
import de.check24.framework.BasePage;
import de.check24.framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;


public class WebTest extends BaseTest {
    private RegisterPage registerPage;
    private AccountPage accountPage;
    private PersonalDataPage personalDataPage;
    private DeletedAccountPage deletedAccountPage;
    private LoginPage loginPage;
    private TravelPage travelPage;
    private ResultsPage resultsPage;

    private static final String TEST_USER_EMAIL = "test@test.com";
    private static final String PASSWORD = "Test5678";
    private static final String DESTINATION = "Tallinn";
    private static final String AIRPORT_TEXT = "Berlin-S";
    private static final String TWO_WEEKS = "2 Wochen";
    private static final String START_DATE_TEXT = "14072019";
    private static final String END_DATE_TEXT = "28072019";

    @Test
    public void registerTest() {
        getURL(EndPoints.REGISTER);
        registerPage = BasePage.initPage(RegisterPage.class);
        registerPage.validationFieldsExample();
        accountPage = registerPage.createUser(TEST_USER_EMAIL, PASSWORD);
        accountPage.assertSuccessLoginMessage(TEST_USER_EMAIL);
    }


    @Test(dependsOnMethods = {"registerTest"})
    public void loginSuccessDeleteAccountTest() {
        getURL(EndPoints.LOGIN);
        loginPage = BasePage.initPage(LoginPage.class);
        AccountPage accountPage = loginPage.login(TEST_USER_EMAIL, PASSWORD);
        accountPage.assertSuccessLoginMessage(TEST_USER_EMAIL);
        getURL(EndPoints.EMAIL);
        personalDataPage = BasePage.initPage(PersonalDataPage.class);
        deletedAccountPage = personalDataPage.deleteCurrentAccount();
        deletedAccountPage.assertSuccessDeleteMessage();
    }

    @Test
    public void searchTravelTest() {
        getURL(EndPoints.LOGIN);
        loginPage = BasePage.initPage(LoginPage.class);
        travelPage = loginPage.clickTravelLink();
        resultsPage = travelPage.searchTravel(DESTINATION, AIRPORT_TEXT, TWO_WEEKS, START_DATE_TEXT, END_DATE_TEXT);
        Assert.assertTrue(resultsPage.getNumberOfResults1stPage() > 0, "No results");
    }


    private void getURL(String endpoint) {
        String url = settings.getBaseUrl() + endpoint;
        test.log(LogStatus.INFO, "Opening URL " + url + "...");
        BasePage.driver.get(settings.getBaseUrl() + endpoint);
    }

    private final class EndPoints {
        private static final String REGISTER = "register.html";
        private static final String LOGIN = "login.html";
        private static final String EMAIL = "/account/email.html";
    }
}


