package de.check24.Pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import de.check24.framework.BasePage;
import de.check24.framework.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

public class DeletedAccountPage extends BasePage {

    public ExtentTest test = BaseTest.test;

    private static final String SUCCESS_DELETE_MESSAGE = "Ihr CHECK24 Kundenkonto wurde erfolgreich entfernt";
    private static final String SUCCESS_DELETE_MESSAGE_XPATH = "//b[contains(text(),'" + SUCCESS_DELETE_MESSAGE + "')]";


    public void assertSuccessDeleteMessage() {
        test.log(LogStatus.INFO, "Checking successful deleted account message...");
        assertTrue(driver.findElements(By.xpath(SUCCESS_DELETE_MESSAGE_XPATH)).size() > 0, "the message about successful deleted account is wrong or not displayed");
    }
}
