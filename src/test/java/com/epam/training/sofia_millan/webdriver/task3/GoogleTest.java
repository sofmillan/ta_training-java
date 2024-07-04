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
    void calculateEstimate(){
        CalculatorPage calculatorPage = new CalculatorPage(driver);

        double calculatorEstimate = calculatorPage
                .openPage()
                .fillForm()
                .getEstimate();

        double summaryEstimate = calculatorPage
                .shareEstimate()
                .getEstimate();

        assertEquals(calculatorEstimate, summaryEstimate);
    }
    @AfterEach
    void tearDown(){
        driver.quit();
        driver = null;
    }
}
