package com.epam.training.sofia_millan.webdriver.task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class PastebinTest {
    WebDriver driver;

    @BeforeEach
    void beforeEach(){
        driver = new ChromeDriver();
    }

    @Test
    void savePaste(){
        String code = "Hello from WebDriver";
        String expirationTime = "10 Minutes";
        String title = "helloweb";

        String expectedConfirmationText = "Your guest paste has been posted";

        String actualConfirmationText = new HomePage(driver)
                .openPage()
                .fillForm(code, expirationTime, title)
                .getConfirmationText();

        assertTrue(actualConfirmationText.contains(expectedConfirmationText));
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
        driver = null;
    }
}
