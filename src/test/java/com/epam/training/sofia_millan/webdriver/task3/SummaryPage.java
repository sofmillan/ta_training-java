package com.epam.training.sofia_millan.webdriver.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class SummaryPage {
    private WebDriver driver;
    private WebDriverWait wait;


    public SummaryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void a(){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(@class, 'n8xu5')]")));

        System.out.println(text);
        System.out.println(text.getText() +" !!!");
        System.out.println(text.getTagName());
        System.out.println(driver.getTitle());
    }
}
