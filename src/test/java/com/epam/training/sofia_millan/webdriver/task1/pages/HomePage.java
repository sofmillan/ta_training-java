package com.epam.training.sofia_millan.webdriver.task1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class represents the home page of the PasteBin website and provides methods
 * to interact with its elements.
 * @author Sofía Millán
 */
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

    /**
     * Constructor for HomePage.
     * Initializes the WebDriver and WebDriverWait, and sets up PageFactory.
     * @param driver the WebDriver instance.
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the PasteBin page in the web browser.
     * Maximizes the browser window.
     */
    public void openPage(){
        driver.get(HOMEPAGE_URL);
        driver.manage().window().maximize();
    }

    /**
     * Fills the Pastebin form with the provided code, expiration time, and title.
     * @param code the code to be pasted.
     * @param expirationTime the desired expiration time.
     * @param title the title for the paste.
     */
    public void fillAndSubmitForm(String code, String expirationTime, String title){
        codeInput.sendKeys(code);
        expirationContainer.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(getDynamicBy(expirationItems, expirationTime))).click();
        titleInput.sendKeys(title);
        submitButton.click();
    }

    /**
     * Creates a dynamic By object based on a base XPath and dynamic text.
     * @param baseXpath the base XPath string containing a placeholder `%s`.
     * @param dynamicText the text to replace the placeholder in the base XPath.
     * @return A By object representing the dynamic element.
     */
    public By getDynamicBy(String baseXpath, String dynamicText) {
        String dynamicXPath = String.format(baseXpath, dynamicText);
        return By.xpath(dynamicXPath);
    }

}
