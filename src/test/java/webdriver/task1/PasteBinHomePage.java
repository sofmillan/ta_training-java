package webdriver.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class PasteBinHomePage {
    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    private WebDriver driver;

    private By codeInput = By.id("postform-text");
    private By arrow = By.cssSelector(".field-postform-expiration .select2-selection__arrow");
    private By listItems = By.cssSelector(".select2-results__option");
    private By titleInput = By.id("postform-name");
    private By button = By.cssSelector(".form-btn-container button.btn");

    public PasteBinHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public PasteBinHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        driver.manage().window().maximize();
        return this;
    }

    public ConfirmationPage fillForm(String code, String title, String expiration) throws InterruptedException {
        driver.findElement(codeInput).sendKeys(code);
        driver.findElement(arrow).click();

        List<WebElement> a = driver.findElements(listItems);

        a.stream()
                .filter(e->e.getDomAttribute("id").contains("10M"))
                .findFirst()
                .ifPresent(WebElement::click);

        driver.findElement(titleInput).sendKeys(title);


        /*driver.findElement(button).click();*/
        Thread.sleep(3000);

        return new ConfirmationPage(driver);
    }
}
