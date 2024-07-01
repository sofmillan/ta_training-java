package com.epam.training.sofia_millan.webdriver.task2;

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
    void savePaste()  {
        String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force\n";
        String expirationTime = "10 Minutes";
        String title = "how to gain dominance among developers";
        String highlighting = "Bash";

        String expectedConfirmationText = "Your guest paste has been posted";

        ConfirmationPage confirmationPage = new HomePage(driver)
                .openPage()
                .fillForm(code, expirationTime, highlighting, title);

        String actualPageTitle = confirmationPage.getWindowTitle();
        assertTrue(actualPageTitle.contains(title));

        String actualSyntax = confirmationPage.getSyntax();
        assertEquals(actualSyntax, highlighting);

        String actualCode = confirmationPage.getCode();

        assertTrue(actualCode.contains(code));


    }

    @AfterEach
    public void afterEach() {
        driver.quit();
        driver = null;
    }
}
