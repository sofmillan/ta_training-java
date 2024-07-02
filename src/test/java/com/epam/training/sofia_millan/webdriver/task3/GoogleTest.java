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
        Thread.sleep(1000);
        String price = calculatorPage.getPrice();

        calculatorPage.share();

        SummaryPage summaryPage = new SummaryPage(driver);
        System.out.println(price);
        Thread.sleep(10000);
        summaryPage.a();



    }
/*    @AfterEach
    void tearDown(){
        driver.quit();
        driver = null;
    }*/
}
