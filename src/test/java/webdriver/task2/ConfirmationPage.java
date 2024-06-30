package webdriver.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationPage {
    private WebDriver driver;
    private By successMessage = By.cssSelector(".notice.-success.-post-view");
    private By code = By.xpath("//div[@class='source']");
    private By syntax = By.cssSelector(".highlighted-code a.btn.h_800");

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    private void waitForCode(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(code));
    }

/*    public String getConfirmationText(){
        waitForSuccessMessage();
        return driver.findElement(successMessage).getText();
    }*/

    public String getWindowTitle(){
        return driver.getTitle();
    }

    public String getCode(){
        waitForCode();
        System.out.println(driver.findElement(code).getText());
        return driver.findElement(code).getText();
    }

    public String getSyntax(){
        System.out.println(driver.findElement(syntax).getText());
        return driver.findElement(syntax).getText();

    }


}
