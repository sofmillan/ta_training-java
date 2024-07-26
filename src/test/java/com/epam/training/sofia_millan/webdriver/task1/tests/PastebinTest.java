package com.epam.training.sofia_millan.webdriver.task1.tests;

import com.epam.training.sofia_millan.webdriver.task1.pages.ConfirmationPage;
import com.epam.training.sofia_millan.webdriver.task1.pages.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class contains automated tests for the Pastebin website.
 * @author Sofía Millán
 */
public class PastebinTest {
    static WebDriver driver;

    /**
     * Initializes the driver, using ChromeDriver, before any test methods are executed.
     */
    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    void savePaste(){
        String code = "Hello from WebDriver";
        String expirationTime = "10 Minutes";
        String title = "helloweb";
        String expectedConfirmationText = "Your guest paste has been posted";

        // 1. Opens the Pastebin page, fills and submit the form on the Home Page
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.fillAndSubmitForm(code, expirationTime, title);

        // 2. Retrieves the confirmation text from the Confirmation Page
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        String actualConfirmationText = confirmationPage.getSuccessText();

        // 3. Verifies confirmation text is present
        assertTrue(actualConfirmationText.contains(expectedConfirmationText));
    }

    /**
     * Closes all driver windows after all test methods have been executed.
     */
    @AfterAll
    static void afterEach() {
        driver.quit();
    }
}
