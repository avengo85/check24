package de.check24.Pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import de.check24.framework.BasePage;
import de.check24.framework.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalDataPage extends BasePage {

    public ExtentTest test = BaseTest.test;

    private static final String ACCOUNT_DELETE_LINK_XPATH = "//a[@id='account_delete']";
    private static final String CONFIRM_BUTTON_XPATH = "//button[@class='button-right button-ok']";
    private static final String LABEL_ACCEPT_XPATH = "//label[@class='label c24-form-checkbox-label']";

    @FindBy(xpath = ACCOUNT_DELETE_LINK_XPATH)
    private WebElement accountDeleteLink;

    @FindBy(xpath = CONFIRM_BUTTON_XPATH)
    private WebElement confirmButton;

    @FindBy(xpath = LABEL_ACCEPT_XPATH)
    private WebElement acceptTickbox;


    public DeletedAccountPage deleteCurrentAccount() {
        test.log(LogStatus.INFO, "Deleting current account...");
        accountDeleteLink.click();
        acceptTickbox.click();
        confirmButton.click();
        return initPage(DeletedAccountPage.class);
    }
}
