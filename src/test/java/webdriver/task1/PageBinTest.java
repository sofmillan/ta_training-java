package webdriver.task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageBinTest {
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

        String actualConfirmationText = new PasteBinHomePage(driver)
                .openPage()
                .fillForm(code, expirationTime, title)
                .getConfirmationText();

        String expectedConfirmationText = "Your guest paste has been posted";

        assertTrue(actualConfirmationText.contains(expectedConfirmationText));
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
        driver = null;
    }
}
