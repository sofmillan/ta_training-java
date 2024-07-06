package com.epam.training.sofia_millan.webdriver.task2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    private WebDriver driver;
    @FindBy(id = "postform-text")
    private WebElement codeInput;
    @FindBy(id = "select2-postform-expiration-container")
    private WebElement expirationContainer;
    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxContainer;
    @FindBy(id = "postform-name")
    private WebElement titleInput;
    @FindBy(css = ".form-btn-container button.btn")
    private WebElement submitButton;
    private String expirationItems = "//li[text()='%s' and starts-with(@id, 'select2-postform-expiration-result-')]";
    private String syntaxItems = "//li[text()='%s' and starts-with(@id, 'select2-postform-format-result-')]";


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(){
        driver.get(HOMEPAGE_URL);
        driver.manage().window().maximize();
    }

    public void fillForm(String code, String expirationTime, String syntax, String title){
        codeInput.sendKeys(code);
        syntaxContainer.click();
        driver.findElement(getDynamicBy(syntaxItems, syntax)).click();
        expirationContainer.click();
        driver.findElement(getDynamicBy(expirationItems, expirationTime)).click();
        titleInput.sendKeys(title);
        submitButton.click();
    }

    public By getDynamicBy(String baseXpath, String dynamicText) {
        String dynamicXPath = String.format(baseXpath, dynamicText);
        return By.xpath(dynamicXPath);
    }
}
