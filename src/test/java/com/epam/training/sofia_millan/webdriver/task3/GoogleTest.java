package com.epam.training.sofia_millan.webdriver.task3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


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
        Thread.sleep(2000);
        String price = calculatorPage.getPrice();

        calculatorPage.share();


        System.out.println(price);

/*
        String ex =driver.findElement(By.xpath("//h6[contains(@class, 'SeJRAd')]")).getText();
*/

/*
        String ex = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h4"))).getText();
*/
        Thread.sleep(3000);
/*        WebElement element = (WebElement) ((JavascriptExecutor) driver)
                .executeScript("return document.querySelector('h4');");
        System.out.println(element.getText());*/

       /* System.out.println(ex);*/

    }
/*    @AfterEach
    void tearDown(){
        driver.quit();
        driver = null;
    }*/
}
