package com.epam.training.sofia_millan.webdriver.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SummaryPage {
    private WebDriver driver;
    private WebDriverWait wait;


    public SummaryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void a(){
        System.out.println("aaa "+driver.findElement(By.tagName("h4")).getText());
        ;
    }
}
