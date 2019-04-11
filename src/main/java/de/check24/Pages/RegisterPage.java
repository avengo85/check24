package de.check24.Pages;

import de.check24.framework.BasePage;
import de.check24.framework.BaseTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegisterPage extends BasePage {

    public ExtentTest test = BaseTest.test;


    private static final String EMAIL_BOX_XPATH = "//input[@name='email']";
    private static final String EMAIL_BOX_ERROR_XPATH = "//input[@id='email'][contains(@class,'FormErrorBorder')]";
    private static final String PASSWORD_BOX_XPATH = "//input[@id='password']";
    private static final String PASSWORD_BOX_ERROR_XPATH = "//input[@id='password'][contains(@class,'FormErrorBorder')]";
    private static final String PASSWORD_REPEAT_BOX_XPATH = "//input[@name='passwordrepetition']";
    private static final String PASSWORD_REPEAT_BOX_ERROR_XPATH = "//input[@id='passwordrepetition'][contains(@class,'FormErrorBorder')]";
    private static final String REGISTER_BUTTON_XPATH = "//button[@name='register']";
    private static final String WRONG_EMAIL = "wrong email";
    private static final String SHORT_PASSWORD = "short";
    private static final String OTHER_PASSWORD = "short2";
    private static final String WRONG_EMAIL_MESSAGE = "Bitte geben Sie eine gültige E-Mail-Adresse an.";
    private static final String WRONG_PASSWORD_MESSAGE = "Das Passwort sollte zwischen 6 und 50 Zeichen lang sein.";


    private static final String OTHER_PASSWORD_MESSAGE = "Die Passwörter stimmen nicht überein.";


    @FindBy(xpath = EMAIL_BOX_XPATH)
    private WebElement emailTextbox;

    @FindBy(xpath = EMAIL_BOX_ERROR_XPATH)
    private WebElement emailBoxError;

    @FindBy(xpath = PASSWORD_BOX_XPATH)
    private WebElement passwordTextbox;

    @FindBy(xpath = PASSWORD_BOX_ERROR_XPATH)
    private WebElement passwordBoxError;

    @FindBy(xpath = PASSWORD_REPEAT_BOX_ERROR_XPATH)
    private WebElement passwordRepeatBoxError;

    @FindBy(xpath = PASSWORD_REPEAT_BOX_XPATH)
    private WebElement passwordRepeatTextbox;

    @FindBy(xpath = REGISTER_BUTTON_XPATH)
    private WebElement registerButton;

    public AccountPage createUser(String email, String password) {
        test.log(LogStatus.INFO, "Register a new user with email=" + email + " and Password=" + password + "...");
        emailTextbox.clear();
        emailTextbox.sendKeys(email);
        passwordTextbox.clear();
        passwordTextbox.sendKeys(password);
        passwordRepeatTextbox.clear();
        passwordRepeatTextbox.sendKeys(password);
        registerButton.click();
        return initPage(AccountPage.class);
    }

    public void validationFieldsExample() {
        test.log(LogStatus.INFO, "Validating fields of Register page...");
        test.log(LogStatus.INFO, "Filling wrong email...");
        emailTextbox.sendKeys(WRONG_EMAIL);
        test.log(LogStatus.INFO, "Filling short password...");
        passwordTextbox.sendKeys(SHORT_PASSWORD);
        test.log(LogStatus.INFO, "Repeating password by wrong one...");
        passwordRepeatTextbox.sendKeys(OTHER_PASSWORD);
        registerButton.click();
        test.log(LogStatus.INFO, "Asserting red boarders for text fields and error messages at corresponding places...");
        Assert.assertTrue(emailBoxError.isDisplayed());
        Assert.assertTrue(passwordBoxError.isDisplayed());
        Assert.assertTrue(passwordRepeatBoxError.isDisplayed());
        Assert.assertTrue(driver.findElements(By.xpath(getXPATHemailError(WRONG_EMAIL_MESSAGE))).size() > 0, "No wrong email message");
        Assert.assertTrue(driver.findElements(By.xpath(getXPATHpasswordError(WRONG_PASSWORD_MESSAGE))).size() > 0, "No short password message");
        Assert.assertTrue(driver.findElements(By.xpath(getXPATHpasswordRepetitionError(OTHER_PASSWORD_MESSAGE))).size() > 0, "No wrong password repetition message");
    }

    private String getXPATHemailError(String message) {
        return "//input[@id='email'][contains(@class,'FormErrorBorder')]/following-sibling::div[contains(text(),'" + message + "')]";
    }


    private String getXPATHpasswordError(String message) {
        return "//input[@id='password'][contains(@class,'FormErrorBorder')]/following-sibling::div[contains(text(),'" + message + "')]";
    }

    private String getXPATHpasswordRepetitionError(String message) {
        return "//input[@id='passwordrepetition'][contains(@class,'FormErrorBorder')]/following-sibling::div[contains(text(),'" + message + "')]";
    }


}
