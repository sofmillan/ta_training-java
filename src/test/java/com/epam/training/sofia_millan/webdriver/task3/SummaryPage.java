package com.epam.training.sofia_millan.webdriver.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SummaryPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By estimatedCostTitle = By.xpath("//h4[contains(@class, 'n8xu5')]");


    public SummaryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public double getEstimate(){
        BrowserUtils.changeTab(driver,1);
        String estimate = wait.until(ExpectedConditions
                .visibilityOfElementLocated(estimatedCostTitle)).getText();
        return Utils.convertStringToDouble(estimate);
    }

}
