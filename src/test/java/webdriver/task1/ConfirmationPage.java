package webdriver.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationPage {
    private WebDriver driver;

    private By successMessage = By.cssSelector(".notice.-success.-post-view");

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }


    public void waitForAlertBanner(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
    }

    public String getConfirmationText(){
        waitForAlertBanner();
        return driver.findElement(successMessage).getText();
    }


}
