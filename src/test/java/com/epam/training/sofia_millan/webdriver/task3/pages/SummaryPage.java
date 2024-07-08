package com.epam.training.sofia_millan.webdriver.task3.pages;

import com.epam.training.sofia_millan.webdriver.task3.utils.BrowserUtils;
import com.epam.training.sofia_millan.webdriver.task3.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class represents the summary page of the Google Cloud Pricing Calculator,
 * which displays the estimated cost of selected services.
 * @author Sofía Millán
 */
public class SummaryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * WebElement representing the estimated cost title.
     */
    @FindBy(xpath = "//h4[contains(@class, 'n8xu5')]")
    private WebElement estimatedCostTitle;

    /**
     * Constructor for SummaryPage.
     * Initializes the WebDriver and WebDriverWait, and sets up the PageFactory.
     * @param driver the WebDriver instance
     */
    public SummaryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    /**
     * Retrieves the estimated cost.
     * @return the estimated cost as a double
     */
    public double getEstimate(){
        BrowserUtils.changeTab(driver,1);
        String estimate = wait.until(ExpectedConditions
                .visibilityOf(estimatedCostTitle)).getText();
        return Utils.convertStringToDouble(estimate);
    }

}
