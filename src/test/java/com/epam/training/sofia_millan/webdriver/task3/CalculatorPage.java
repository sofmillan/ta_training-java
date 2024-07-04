package com.epam.training.sofia_millan.webdriver.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage {
    private final static String URL = "https://cloud.google.com/products/calculator?hl=es";
    private WebDriver driver;
    private WebDriverWait wait;
    private By numberInstancesInput = By.xpath("//span[@class='qdOxv-fmcmS-wGMbrd-sM5MNb']//input[@type='number']");
    private By product = By.xpath("//h2[text()='Compute Engine']");
    private By addGPUButton = By.xpath("//button[@aria-label='Add GPUs']");
    private By shareButton = By.xpath("//span[contains(@class, 'FOBRw-RLmnJb')]");
    private By openEstimateButton = By.xpath("//a[contains(@class, 'rP2xkc')]");
    private By estimatedCost = By.xpath("//span[contains(@class, 'MyvX5d')]");
    private By addToEstimateButton = By.cssSelector(".jirROd button");
    private By updateMessage = By.xpath("//div[contains(@class,'Z7Qi9d') and contains(@class, ' HY0Uh')]");
    private String baseDropDown = "//div[contains(@class, 'VfPpkd-TkwUic') and .//span[contains(@class, 'VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe') and contains(text(), '%s')]]";
    private String baseListItem = "//li[@data-value='%s']";
    private String baseLabel = "//label[contains(@class, 'zT2df') and @for='%s']";


    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public CalculatorPage openPage(){
        driver.get(URL);
        driver.manage().window().maximize();
        return this;
    }

    public CalculatorPage fillForm(){
        addProductToEstimate(product);

        wait.until(ExpectedConditions.visibilityOfElementLocated(numberInstancesInput)).clear();
        driver.findElement(numberInstancesInput).sendKeys("4");

        findDropDown("Operating System").click();
        findItemInList("free-debian-centos-coreos-ubuntu-or-byol-bring-your-own-license").click();

        findLabel("regular").click();

        findDropDown("Machine Family").click();
        findItemInList("general-purpose").click();

        findDropDown("Series").click();
        findItemInList("n1").click();

        findDropDown("Machine type").click();
        findItemInList("n1-standard-8").click();

        driver.findElement(addGPUButton).click();

        findDropDown("GPU Model").click();
        findItemInList("nvidia-tesla-v100").click();

        findDropDown("Number of GPUs").click();
        findItemInList("1").click();

        findDropDown("Local SSD").click();
        driver.findElements(By.xpath("//li[@data-value='2']")).get(1).click();

        findDropDown("Region").click();
        findItemInList("europe-west4").click();

        findLabel("1-year").click();
        return this;
    }

    public SummaryPage shareEstimate(){
        driver.findElement(shareButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(openEstimateButton)).click();
        return new SummaryPage(driver);
    }

    public Double getEstimate(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(updateMessage));
        String estimate = driver.findElement(estimatedCost).getText();
        return Utils.convertStringToDouble(estimate);
    }

    private WebElement findDropDown(String title){
        String locator = String.format(baseDropDown, title);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
    private WebElement findLabel(String title){
        String locator = String.format(baseLabel, title);
        return driver.findElement(By.xpath(locator));
    }

    private WebElement findItemInList(String value){
        String locator = String.format(baseListItem, value);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    private void addProductToEstimate(By productLocator){
        driver.findElement(addToEstimateButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator)).click();
    }
}
