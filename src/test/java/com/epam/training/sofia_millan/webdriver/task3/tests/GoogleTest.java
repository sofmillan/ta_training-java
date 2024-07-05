package com.epam.training.sofia_millan.webdriver.task3.tests;

import com.epam.training.sofia_millan.webdriver.task3.pages.CalculatorPage;
import com.epam.training.sofia_millan.webdriver.task3.pages.SummaryPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTest {
    static WebDriver driver;
    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
    }
    @Test
    void calculateEstimate(){
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.openPage();
        calculatorPage.fillForm();
        double calculatorEstimate = calculatorPage.getEstimate();
        calculatorPage.shareEstimate();

        SummaryPage summaryPage = new SummaryPage(driver);
        double summaryEstimate = summaryPage.getEstimate();

        assertEquals(calculatorEstimate, summaryEstimate);
    }
    @AfterAll
    static void tearDown(){
        driver.quit();
    }
}
