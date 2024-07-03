package com.epam.training.sofia_millan.webdriver.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;

public class SummaryPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By estimatedCostTitle = By.xpath("//h4[contains(@class, 'n8xu5')]");


    public SummaryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public Double getEstimate(){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String estimate = wait.until(ExpectedConditions
                .visibilityOfElementLocated(estimatedCostTitle)).getText();
        return convert(estimate);
    }


    public Double convert(String amount)  {
        amount = amount.replaceAll("[^\\d,\\.]", "").replace(" ", "");

        NumberFormat format = NumberFormat.getInstance(Locale.GERMAN);

        Number number = null;
        try {
            number = format.parse(amount);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return number.doubleValue();
    }
}
