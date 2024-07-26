package com.epam.training.sofia_millan.webdriver.task2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class represents the confirmation page of the Pastebin website, which renders after a paste has been saved.
 * @author Sofía Millán
 */
public class ConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(css = ".highlighted-code a.btn.h_800")
    private WebElement syntax;
    private String code = ".%s";

    /**
     * Constructor for ConfirmationPage.
     * Initializes the WebDriver and WebDriverWait, and sets up PageFactory.
     * @param driver the WebDriver instance.
     */
    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Retrieves the current window title from the browser.
     * @return the window title.
     */
    public String getWindowTitle(){
        return driver.getTitle();
    }

    /**
     * Waits for the code and retrieves it.
     * @return the code text.
     */
    public String getCode(String syntax){
        By codeLocator  = getDynamicBy(code, syntax.toLowerCase());
        wait.until(ExpectedConditions.visibilityOfElementLocated(codeLocator));
        return driver.findElement(codeLocator).getText();
    }

    /**
     * Waits for the code syntax and retrieves it.
     * @return the syntax name.
     */
    public String getSyntax(){
        return wait.until(ExpectedConditions.visibilityOf(syntax)).getText();
    }

    /**
     * Creates a dynamic By object based on a base locator and dynamic text.
     * @param base the base string containing a placeholder `%s`.
     * @param dynamicText the text to replace the placeholder in the base string.
     * @return A By object representing the dynamic element.
     */
    private By getDynamicBy(String base, String dynamicText){
        String dynamicPath = String.format(base, dynamicText);
        return By.cssSelector(dynamicPath);
    }
}
