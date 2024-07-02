package com.epam.training.sofia_millan.webdriver.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage {
    private WebDriver driver;
    private final static String URL = "https://cloud.google.com/products/calculator";
    private String baseDropDown = "//div[contains(@class, 'VfPpkd-TkwUic') and .//span[contains(@class, 'VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe') and contains(text(), '%s')]]";
    private String list = "//li[@data-value='%s']";
    private WebDriverWait wait;


    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openPage(){
        driver.get(URL);
        driver.manage().window().maximize();
    }

    public void fillForm() throws InterruptedException {

        driver.findElement(By.cssSelector(".jirROd button")).click(); // Add to estimate
        Thread.sleep(1000);
        driver.findElement(By.xpath("//h2[text()='Compute Engine']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".qdOxv-fmcmS-wGMbrd-sM5MNb input")).clear();
        driver.findElement(By.cssSelector(".qdOxv-fmcmS-wGMbrd-sM5MNb input")).sendKeys("4"); //N instances
        Thread.sleep(1000);

        //Operating system
        findItemFromDropDown("Operating System").click();
        Thread.sleep(1000);
        findItemInList("free-debian-centos-coreos-ubuntu-or-byol-bring-your-own-license").click();
        Thread.sleep(3000);

        //Provisioning model
        driver.findElement(By.xpath("//label[contains(@class, 'zT2df') and @for='regular']")).click();

        //Machine family

        driver.findElement(By.xpath("//div[contains(@class, 'VfPpkd-TkwUic') and .//span[contains(@class, 'VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe') and contains(text(), 'Machine Family')]]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[@data-value='general-purpose']")).click();
        Thread.sleep(1000);

        //Series
        driver.findElement(By.xpath("//div[contains(@class, 'VfPpkd-TkwUic') and .//span[contains(@class, 'VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe') and contains(text(), 'Series')]]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[@data-value='n1']")).click();
        Thread.sleep(1000);


        //Machine type

        findItemFromDropDown("Machine type").click();
        findItemInList("n1-standard-8").click();
        Thread.sleep(3000);


        //Add gpus
        driver.findElement(By.xpath("//button[@aria-label='Add GPUs']")).click();
        Thread.sleep(2000);


        //GPU Model
        driver.findElement(By.xpath("//div[contains(@class, 'VfPpkd-TkwUic') and .//span[contains(@class, 'VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe') and contains(text(), 'GPU Model')]]")).click();

        driver.findElement(By.xpath("//li[@data-value='nvidia-tesla-v100']")).click();


        //Number of GPUs
        driver.findElement(By.xpath("//div[contains(@class, 'VfPpkd-TkwUic') and .//span[contains(@class, 'VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe') and contains(text(), 'Number of')]]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@data-value='1']")).click();
        Thread.sleep(2000);

        //Local SSD
        driver.findElement(By.xpath("//div[contains(@class, 'VfPpkd-TkwUic') and .//span[contains(@class, 'VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe') and contains(text(), 'Local SSD')]]")).click();
        Thread.sleep(3000);
        driver.findElements(By.xpath("//li[@data-value='2']")).get(1).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//label[contains(@class, 'zT2df') and @for='1-year']")).click();

        //GPU Model
        driver.findElement(By.xpath("//div[contains(@class, 'VfPpkd-TkwUic') and .//span[contains(@class, 'VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe') and contains(text(), 'Region')]]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[@data-value='europe-west4']")).click();
        Thread.sleep(1000);
    }

    private WebElement findItemFromDropDown(String title){
        String locator = String.format(baseDropDown, title);
        return driver.findElement(By.xpath(locator));
    }

    private WebElement findItemInList(String value){
        String locator = String.format(list, value);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

/*
        return driver.findElement(By.xpath(locator));
*/
    }
}
