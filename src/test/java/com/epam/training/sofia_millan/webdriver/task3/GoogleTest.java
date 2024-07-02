package com.epam.training.sofia_millan.webdriver.task3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleTest {
    WebDriver driver;
    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
    }
    @Test
    void calculator() throws Exception{
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.openPage();

        calculatorPage.fillForm();


        String price = driver.findElement(By.xpath("//span[contains(@class, 'MyvX5d')]")).getText();

        driver.findElement(By.xpath("//span[contains(@class, 'FOBRw-RLmnJb')]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[contains(@class, 'rP2xkc')]")).click();
        System.out.println(price);

/*
        String ex =driver.findElement(By.xpath("//h6[contains(@class, 'SeJRAd')]")).getText();
*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
/*
        String ex = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h4"))).getText();
*/
        Thread.sleep(30000);
        WebElement element = (WebElement) ((JavascriptExecutor) driver)
                .executeScript("return document.querySelector('h4');");
        System.out.println(element.getText());
        Thread.sleep(2000);

       /* System.out.println(ex);*/

    }
/*    @AfterEach
    void tearDown(){
        driver.quit();
        driver = null;
    }*/
}
