package com.epam.training.sofia_millan.webdriver.task2.tests;

import com.epam.training.sofia_millan.webdriver.task2.pages.ConfirmationPage;
import com.epam.training.sofia_millan.webdriver.task2.pages.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.assertEquals;
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
    static void beforeEach(){
        driver = new ChromeDriver();
    }

    @Test
    void savePaste(){
        String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force\n";
        String expirationTime = "10 Minutes";
        String title = "how to gain dominance among developers";
        String syntax = "Bash";

        // 1. Opens the Pastebin page, fills and submit the form on the Home Page
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.fillAndSubmitForm(code, expirationTime, syntax, title);

        // 2. Retrieves the code, syntax and page title from the Confirmation Page
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        String actualCode = confirmationPage.getCode(syntax);
        String actualPageTitle = confirmationPage.getWindowTitle();
        String actualSyntax = confirmationPage.getSyntax();

        // 3. Compares initial values with actual values
        assertTrue(actualCode.contains(code));
        assertTrue(actualPageTitle.contains(title));
        assertEquals(syntax, actualSyntax);
    }

    /**
     * Closes all driver windows after all test methods have been executed.
     */
    @AfterAll
    static void afterEach() {
        driver.quit();
    }
}
