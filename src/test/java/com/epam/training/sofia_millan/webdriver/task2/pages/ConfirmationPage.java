package com.epam.training.sofia_millan.webdriver.task2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(css = ".highlighted-code a.btn.h_800")
    private WebElement syntax;
    private String code = ".%s";

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getWindowTitle(){
        return driver.getTitle();
    }

    public String getCode(String syntax){
        By codeLocator  = getDynamicBy(code, syntax.toLowerCase());
        wait.until(ExpectedConditions.visibilityOfElementLocated(codeLocator));
        return driver.findElement(codeLocator).getText();
    }

    public String getSyntax(){
        return wait.until(ExpectedConditions.visibilityOf(syntax)).getText();
    }

    private By getDynamicBy(String base, String dynamicText){
        String dynamicPath = String.format(base, dynamicText);
        return By.cssSelector(dynamicPath);
    }

}
