package com.epam.training.sofia_millan.webdriver.task1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(id = "postform-text")
    private WebElement codeInput;
    @FindBy(id = "select2-postform-expiration-container")
    private WebElement expirationContainer;
    @FindBy(id = "postform-name")
    private WebElement titleInput;
    @FindBy(css = ".form-btn-container button.btn")
    private WebElement submitButton;

    private String expirationItems = "//li[text()='%s' and @class='select2-results__option']";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void openPage(){
        driver.get(HOMEPAGE_URL);
        driver.manage().window().maximize();
    }

    public void fillAndSubmitForm(String code, String expirationTime, String title){
        codeInput.sendKeys(code);
        expirationContainer.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(getDynamicBy(expirationItems, expirationTime))).click();
        titleInput.sendKeys(title);
        submitButton.click();
    }

    public By getDynamicBy(String baseXpath, String dynamicText) {
        String dynamicXPath = String.format(baseXpath, dynamicText);
        return By.xpath(dynamicXPath);
    }

}
