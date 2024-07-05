package com.epam.training.sofia_millan.webdriver.task2.tests;

import com.epam.training.sofia_millan.webdriver.task2.pages.ConfirmationPage;
import com.epam.training.sofia_millan.webdriver.task2.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PastebinTest {
    WebDriver driver;

    @BeforeEach
    void beforeEach(){
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


        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.fillForm(code, expirationTime, syntax, title);

        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        String actualCode = confirmationPage.getCode(syntax);
        String actualPageTitle = confirmationPage.getWindowTitle();
        String actualSyntax = confirmationPage.getSyntax();


        assertTrue(actualCode.contains(code));
        assertTrue(actualPageTitle.contains(title));
        assertEquals(syntax, actualSyntax);
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
        driver = null;
    }
}
