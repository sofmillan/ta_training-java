package webdriver.task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageBinTest {
    WebDriver driver;

    @BeforeEach
    void beforeEach(){
        driver = new ChromeDriver();
    }

    @Test
    void savePaste() throws Exception{

        String confirmationText = new PasteBinHomePage(driver)
                .openPage()
                .fillForm("Hello from webdriver", "helloweb", "10 minutes")
                .getConfirmationText();
        ;
       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://pastebin.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("postform-text")).sendKeys("Hello from WebDriver");
        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(By.cssSelector(".field-postform-expiration .select2-selection__arrow")));

        driver.findElement(By.cssSelector(".field-postform-expiration .select2-selection__arrow")).click();
        Thread.sleep(1000);
        //---------------------------------------------
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("select2-results__option")));
        //id li select2-postform-expiration-result-dkfq-10M class select2-results__option
        List<WebElement> a = driver.findElements(By.cssSelector(".select2-results__option"));
        Thread.sleep(1000);
*//*
        WebElement h = driver.findElement(By.cssSelector("li#select2-postform-expiration-result-2wuk-10M"));
*//*
*//*
        WebElement h = driver.findElement(By.cssSelector("li#select2-postform-expiration-result-tets-10M"));
*//*
*//*
        System.out.println(h.getText());
*//*

      *//*  a.stream().filter(e->e.getDomAttribute("id").contains("10M")).findFirst().get().click();*//*
        a.stream()
                .filter(e->e.getDomAttribute("id").contains("10M"))
                .findFirst()
                .ifPresent(WebElement::click);
*//*
        a.get(2).click();
*//*
Thread.sleep(3000);

//---------------------------------------------
        driver.findElement(By.id("postform-name")).sendKeys("helloweb");

        Thread.sleep(3000);*/
/*
driver.findElement(By.cssSelector(".form-btn-container button.btn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".notice.-success.-post-view")));

        assertTrue(driver.findElement(By.cssSelector(".notice.-success.-post-view")).getText().contains("Your guest paste has been posted"));
*/
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
        driver = null;
    }
}
