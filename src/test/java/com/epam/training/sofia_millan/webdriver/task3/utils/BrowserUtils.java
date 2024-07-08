package com.epam.training.sofia_millan.webdriver.task3.utils;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

/**
 * Utility class providing browser-related functions.
 * @author Sofía Millán
 */
public class BrowserUtils {

    /**
     * Changes the browser tab to the specified index.
     *
     * @param driver the WebDriver instance
     * @param index  the index of the tab to switch to
     */
    public static void changeTab(WebDriver driver, int index){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }
}
