package de.check24.Pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import de.check24.framework.BasePage;
import de.check24.framework.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravelPage extends BasePage {

    public ExtentTest test = BaseTest.test;

    private static final String DESTINATION_BOX_XPATH = "//input[@name='destination']";
    private static final String FROM_BOX_XPATH = "//input[@name='airport-element']";
    private static final String SEARCH_BUTTON_XPATH = "//button[@name='searchButton']";
    private static final String START_DATE_XPATH = "//input[@name='departureDate']";
    private static final String END_DATE_XPATH = "//input[@name='returnDate']";
    private static final String TRAVEL_LINK_XPATH = "//a[@title='Reise']";
    private static final String DURATION_OPEN_LAYER_XPATH = "//div[@class='c24-travel-duration-overlay c24-travel-js-open-duration-layer']";


    @FindBy(xpath = DESTINATION_BOX_XPATH)
    private WebElement destinationTextbox;

    @FindBy(xpath = FROM_BOX_XPATH)
    private WebElement fromTextbox;

    @FindBy(xpath = DURATION_OPEN_LAYER_XPATH)
    private WebElement openDurationLayer;

    @FindBy(xpath = START_DATE_XPATH)
    private WebElement startDateCalendar;

    @FindBy(xpath = END_DATE_XPATH)
    private WebElement endDateCalendar;

    @FindBy(xpath = SEARCH_BUTTON_XPATH)
    private WebElement searchButton;

    @FindBy(xpath = TRAVEL_LINK_XPATH)
    private WebElement travelLink;

    public ResultsPage searchTravel(String destination, String fromText, String durationText, String startDateText, String endDateText) {
        test.log(LogStatus.INFO, "Filling destination " + destination + "...");
        destinationTextbox.sendKeys(destination);
        driver.findElement(By.xpath(getDestinationWrapperItemXPATH(destination))).click();
        test.log(LogStatus.INFO, "Filling aiport " + fromText + "...");
        fromTextbox.sendKeys(fromText);
        driver.findElement(By.xpath(getAirportWrapperItemXPATH(fromText))).click();
        test.log(LogStatus.INFO, "Selecting duration " + durationText + "...");
        openDurationLayer.click();
        driver.findElement(By.xpath(getDurationRadioButtonXPATHbyText(durationText))).click();
        test.log(LogStatus.INFO, "Filling Start date " + startDateText + " and End date " + endDateText + "...");
        startDateCalendar.sendKeys(startDateText);
        endDateCalendar.sendKeys(endDateText);
        test.log(LogStatus.INFO, "Clicking Search button...");
        searchButton.click();
        return initPage(ResultsPage.class);
    }

    private String getDestinationWrapperItemXPATH(String text) {
        return "//a[contains(@title,'" + text + "')][@class='ui-menu-item-wrapper']";
    }

    private String getAirportWrapperItemXPATH(String text) {
        return "//a[contains(@title,'" + text + "')]";
    }

    private String getDurationRadioButtonXPATHbyText(String text) {
        return "//label[contains(text(),'" + text + "')]";
    }
}
