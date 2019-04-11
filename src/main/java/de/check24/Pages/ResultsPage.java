package de.check24.Pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import de.check24.framework.BasePage;
import de.check24.framework.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultsPage extends BasePage {

    public ExtentTest test = BaseTest.test;
    private static final String HOTEL_BLOCK_XPATH = "//li[contains(@class, 'list-cnt')]";

    @FindBy(xpath = HOTEL_BLOCK_XPATH)
    private List<WebElement> hotelsBlocks;

    public int getNumberOfResults1stPage() {
        int num = hotelsBlocks.size();
        test.log(LogStatus.INFO, "Number of results on the 1st page is " + num);
        return num;
    }
}
