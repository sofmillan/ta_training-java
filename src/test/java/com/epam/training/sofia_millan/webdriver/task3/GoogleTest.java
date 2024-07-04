package com.epam.training.sofia_millan.webdriver.task3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GoogleTest {
    WebDriver driver;
    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
    }
    @Test
    void calculator(){
        CalculatorPage calculatorPage = new CalculatorPage(driver);

        Double estimateCalculator = new CalculatorPage(driver)
                .openPage()
                .fillForm()
                .getEstimate();

        Double estimateResult = calculatorPage
                .share()
                .getEstimate();

        assertEquals(estimateResult, estimateCalculator);
    }
    @AfterEach
    void tearDown(){
        driver.quit();
        driver = null;
    }
}
