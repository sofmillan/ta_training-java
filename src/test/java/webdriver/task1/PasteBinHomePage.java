package webdriver.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasteBinHomePage {
    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    private WebDriver driver;
    private By codeInput = By.id("postform-text");
    private By expirationArrow = By.cssSelector(".field-postform-expiration .select2-selection__arrow");
    private By titleInput = By.id("postform-name");
    private By submitButton = By.cssSelector(".form-btn-container button.btn");
    private String expirationItems = "//li[text()='%s' and @class='select2-results__option']";

    public PasteBinHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public PasteBinHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        driver.manage().window().maximize();
        return this;
    }

    public ConfirmationPage fillForm(String code,  String expirationTime, String title){
        driver.findElement(codeInput).sendKeys(code);
        driver.findElement(expirationArrow).click();
        driver.findElement(getDynamicBy(expirationItems, expirationTime)).click();
        driver.findElement(titleInput).sendKeys(title);
        driver.findElement(submitButton).click();

        return new ConfirmationPage(driver);
    }

    public By getDynamicBy(String baseXpath, String dynamicText) {
        String dynamicXPath = String.format(baseXpath, dynamicText);
        return By.xpath(dynamicXPath);
    }

}
