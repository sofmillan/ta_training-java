package com.epam.training.sofia_millan.webdriver.task1.tests;

import com.epam.training.sofia_millan.webdriver.task1.pages.ConfirmationPage;
import com.epam.training.sofia_millan.webdriver.task1.pages.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class PastebinTest {
    static WebDriver driver;

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

        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.fillAndSubmitForm(code, expirationTime, title);

        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        String actualConfirmationText = confirmationPage.getConfirmationText();

        assertTrue(actualConfirmationText.contains(expectedConfirmationText));
    }

    @AfterAll
    static void afterEach() {
        driver.quit();
    }
}
