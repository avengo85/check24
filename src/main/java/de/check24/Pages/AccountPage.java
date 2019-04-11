package de.check24.Pages;

import de.check24.framework.BasePage;
import de.check24.framework.BaseTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AccountPage extends BasePage {

    public ExtentTest test = BaseTest.test;

    private static final String SUCCESS_MESSAGE = "Sie sind angemeldet als";
    private static final String SUCCESS_MESSAGE_XPATH = "//div[@class='page-header salutation']//p";
    private static final String URL = "https://kundenbereich.check24.de/user/account.html";

    @FindBy(xpath = SUCCESS_MESSAGE_XPATH)
    private WebElement messagePlace;

    public void assertSuccessLoginMessage(String userName) {
        test.log(LogStatus.INFO, "Asserting success message...");
        assertTrue(messagePlace.getText().contains(SUCCESS_MESSAGE), "the message is wrong or not displayed");
        test.log(LogStatus.INFO, "Asserting user name is displayed...");
        assertTrue(messagePlace.getText().contains(userName), "user name is wrong or not displayed");
            }
}

