package com.epam.training.sofia_millan.webdriver.task2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class represents the home page of the PasteBin website and provides methods
 * to interact with its elements.
 * @author Sofía Millán
 */
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


    /**
     * Constructor for HomePage.
     * Initializes the WebDriver and sets up PageFactory.
     * @param driver the WebDriver instance.
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the Pastebin page in the web browser.
     * Maximizes the browser window.
     */
    public void openPage(){
        driver.get(HOMEPAGE_URL);
        driver.manage().window().maximize();
    }

    /**
     * Fills the Pastebin form with the provided code, expiration time, syntax and title and submits the form.
     * @param code the code to be pasted.
     * @param expirationTime the desired expiration time.
     * @param syntax the syntax of the code.
     * @param title the title for the paste.
     */
    public void fillAndSubmitForm(String code, String expirationTime, String syntax, String title){
        codeInput.sendKeys(code);
        syntaxContainer.click();
        driver.findElement(getDynamicBy(syntaxItems, syntax)).click();
        expirationContainer.click();
        driver.findElement(getDynamicBy(expirationItems, expirationTime)).click();
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
