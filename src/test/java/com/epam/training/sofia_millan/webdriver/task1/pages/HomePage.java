package com.epam.training.sofia_millan.webdriver.task1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    private WebDriver driver;
    private By codeInput = By.id("postform-text");
    private By expirationContainer = By.id("select2-postform-expiration-container");
    private By titleInput = By.id("postform-name");
    private By submitButton = By.cssSelector(".form-btn-container button.btn");
    private String expirationItems = "//li[text()='%s' and @class='select2-results__option']";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(){
        driver.get(HOMEPAGE_URL);
        driver.manage().window().maximize();
    }

    public void fillAndSubmitForm(String code, String expirationTime, String title){
        driver.findElement(codeInput).sendKeys(code);
        driver.findElement(expirationContainer).click();
        driver.findElement(getDynamicBy(expirationItems, expirationTime)).click();
        driver.findElement(titleInput).sendKeys(title);
        driver.findElement(submitButton).click();
    }

    public By getDynamicBy(String baseXpath, String dynamicText) {
        String dynamicXPath = String.format(baseXpath, dynamicText);
        return By.xpath(dynamicXPath);
    }

}
