package com.epam.training.sofia_millan.webdriver.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationPage {
    private WebDriver driver;
    private By syntax = By.cssSelector(".highlighted-code a.btn.h_800");
    private String code = ".%s";

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getWindowTitle(){
        return driver.getTitle();
    }

    public String getCode(String syntax){
        waitForCode(syntax);
        return driver.findElement(getDynamicBy(code, syntax.toLowerCase())).getText();
    }

    public String getSyntax(){
        return driver.findElement(syntax).getText();
    }

    private void waitForCode(String syntax){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(getDynamicBy(code, syntax.toLowerCase())));
    }

    private By getDynamicBy(String base, String dynamicText){
        String dynamicPath = String.format(base, dynamicText);
        return By.cssSelector(dynamicPath);
    }

}
