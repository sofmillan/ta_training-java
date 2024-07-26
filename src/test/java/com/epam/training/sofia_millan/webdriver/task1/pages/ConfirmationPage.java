package com.epam.training.sofia_millan.webdriver.task1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class represents the confirmation page of the PasteBin website, which renders after a paste has been saved.
 * @author Sofía Millán
 */
public class ConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(css = ".notice.-success.-post-view")
    private WebElement successMessage;

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
     * Waits for the success message and retrieves the text from it.
     * @return The text of the success message.
     */
    public String getSuccessText(){
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.getText();
    }
}
