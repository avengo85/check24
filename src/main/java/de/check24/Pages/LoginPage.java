package de.check24.Pages;

import de.check24.framework.BasePage;
import de.check24.framework.BaseTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public ExtentTest test = BaseTest.test;
    private static final String EMAIL_BOX_XPATH = "//input[@id='email']";
    private static final String PASSWORD_BOX_XPATH = "//input[@id='password']";
    private static final String TRAVEL_LINK_XPATH = "//a[@title='Reise']";
    private static final String LOGIN_BUTTON_XPATH = "//button[@name='login']";


    @FindBy(xpath = EMAIL_BOX_XPATH)
    private WebElement emailTextbox;

    @FindBy(xpath = PASSWORD_BOX_XPATH)
    private WebElement passwordTextbox;

    @FindBy(xpath = LOGIN_BUTTON_XPATH)
    private WebElement loginButton;

    @FindBy(xpath = TRAVEL_LINK_XPATH)
    private WebElement travelLink;


    public AccountPage login(String email, String password) {
        test.log(LogStatus.INFO, "Logging in as the user " + email + "...");
        emailTextbox.sendKeys(email);
        passwordTextbox.sendKeys(password);
        loginButton.click();
        return initPage(AccountPage.class);
    }

    public TravelPage clickTravelLink() {
        test.log(LogStatus.INFO, "Clicking 'Travel' link...");
        travelLink.click();
        return initPage(TravelPage.class);
    }


}
