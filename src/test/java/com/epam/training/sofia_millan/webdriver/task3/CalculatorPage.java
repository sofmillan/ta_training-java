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
    private String label = "//label[contains(@class, 'zT2df') and @for='%s']";
    private WebDriverWait wait;
    private By numberInstancesInput = By.cssSelector(".qdOxv-fmcmS-wGMbrd-sM5MNb input[type='number']");


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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Compute Engine']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(numberInstancesInput)).clear();
        driver.findElement(numberInstancesInput).sendKeys("4");

        findItemFromDropDown("Operating System").click();
        findItemInList("free-debian-centos-coreos-ubuntu-or-byol-bring-your-own-license").click();

        findLabel("regular").click();

        findItemFromDropDown("Machine Family").click();
        findItemInList("general-purpose").click();

        findItemFromDropDown("Series").click();
        findItemInList("n1").click();

        findItemFromDropDown("Machine type").click();
        findItemInList("n1-standard-8").click();

        //Add gpus
        driver.findElement(By.xpath("//button[@aria-label='Add GPUs']")).click();
        Thread.sleep(2000);

        findItemFromDropDown("GPU Model").click();
        findItemInList("nvidia-tesla-v100").click();

        findItemFromDropDown("Number of GPUs").click();
        findItemInList("1").click();

        findItemFromDropDown("Local SSD").click();
        driver.findElements(By.xpath("//li[@data-value='2']")).get(1).click();

        findItemFromDropDown("Region").click();
        findItemInList("europe-west4").click();

        findLabel("1-year").click();
    }

    public void share(){
        driver.findElement(By.xpath("//span[contains(@class, 'FOBRw-RLmnJb')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class, 'rP2xkc')]"))).click();
    }

    public String getPrice(){
        return driver.findElement(By.xpath("//span[contains(@class, 'MyvX5d')]")).getText();
    }

    private WebElement findItemFromDropDown(String title){
        String locator = String.format(baseDropDown, title);
        return driver.findElement(By.xpath(locator));
    }
    private WebElement findLabel(String title){
        String locator = String.format(label, title);
        return driver.findElement(By.xpath(locator));
    }

    private WebElement findItemInList(String value){
        String locator = String.format(list, value);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
}
