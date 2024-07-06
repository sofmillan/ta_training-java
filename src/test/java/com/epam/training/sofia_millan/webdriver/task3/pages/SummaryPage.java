package com.epam.training.sofia_millan.webdriver.task3.pages;

import com.epam.training.sofia_millan.webdriver.task3.utils.BrowserUtils;
import com.epam.training.sofia_millan.webdriver.task3.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SummaryPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//h4[contains(@class, 'n8xu5')]")
    private WebElement estimatedCostTitle;

    public SummaryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public double getEstimate(){
        BrowserUtils.changeTab(driver,1);
        String estimate = wait.until(ExpectedConditions
                .visibilityOf(estimatedCostTitle)).getText();
        return Utils.convertStringToDouble(estimate);
    }

}
