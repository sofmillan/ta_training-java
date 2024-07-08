package com.epam.training.sofia_millan.webdriver.task3.tests;

import com.epam.training.sofia_millan.webdriver.task3.pages.CalculatorPage;
import com.epam.training.sofia_millan.webdriver.task3.pages.SummaryPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains automated tests for the Google Cloud Pricing Calculator.
 * @author Sofía Millán
 */
public class GoogleTest {
    static WebDriver driver;

    /**
     * Initializes the driver, using ChromeDriver, before any test methods are executed.
     */
    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
    }


    /**
     * This test method:
     * 1. Opens the Google Cloud Pricing Calculator page.
     * 2. Completes the required form fields to get an estimate.
     * 3. Obtains and stores the estimate from the calculator.
     * 4. Shares the estimate to generate a summary.
     * 5. Obtains and stores the estimate from the summary page.
     * 6. Compares the calculator's estimate with the summary's estimate to ensure they match.
     */
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

    /**
     * Closes all driver windows after all test methods have been executed.
     */
    @AfterAll
    static void tearDown(){
        driver.quit();
    }
}
