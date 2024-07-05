package com.epam.training.sofia_millan.webdriver.task3.utils;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class BrowserUtils {

    public static void changeTab(WebDriver driver, int index){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }
}
