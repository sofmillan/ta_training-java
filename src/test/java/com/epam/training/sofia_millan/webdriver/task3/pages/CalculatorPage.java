package com.epam.training.sofia_millan.webdriver.task3.pages;

import com.epam.training.sofia_millan.webdriver.task3.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class represents the calculator page of the Google Cloud Pricing Calculator,
 * which allows users to input different configurations and estimate costs.
 * @author Sofía Millán
 */
public class CalculatorPage {
    private final static String URL = "https://cloud.google.com/products/calculator?hl=es";
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath ="//span[@class='qdOxv-fmcmS-wGMbrd-sM5MNb']//input[@type='number']")
    private WebElement numberInstancesInput;
    @FindBy(xpath ="//h2[text()='Compute Engine']")
    private WebElement product;
    @FindBy(xpath ="//button[@aria-label='Add GPUs']")
    private WebElement addGPUButton;
    @FindBy(xpath ="//span[contains(@class, 'FOBRw-RLmnJb')]")
    private WebElement shareButton;
    @FindBy(xpath ="//a[contains(@class, 'rP2xkc')]")
    private WebElement openEstimateButton;
    @FindBy(xpath ="//span[contains(@class, 'MyvX5d')]")
    private WebElement estimatedCost;
    @FindBy(css =".jirROd button")
    private WebElement addToEstimateButton;
    @FindBy(xpath = "//div[contains(@class,'Z7Qi9d') and contains(@class, ' HY0Uh')]")
    private WebElement updateMessage;
    private String baseDropDown = "//div[contains(@class, 'VfPpkd-TkwUic') and .//span[contains(@class, 'VfPpkd-NLUYnc-V67aGc-OWXEXe-TATcMc-KLRBe') and contains(text(), '%s')]]";
    private String baseListItem = "//li[@data-value='%s']";
    private String baseLabel = "//label[contains(@class, 'zT2df') and @for='%s']";

    /**
     * Constructor for CalculatorPage.
     * Initializes the WebDriver and WebDriverWait, and sets up the PageFactory.
     *
     * @param driver the WebDriver instance.
     */
    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the calculator page in the web browser.
     * Maximizes the browser window.
     */
    public void openPage(){
        driver.get(URL);
        driver.manage().window().maximize();
    }

    /**
     * Fills the form with predefined values.
     */
    public void fillForm(){
        addProductToEstimate(product);

        wait.until(ExpectedConditions.visibilityOf(numberInstancesInput)).clear();
        numberInstancesInput.sendKeys("4");

        findDropDown("Operating System").click();
        findItemInList("free-debian-centos-coreos-ubuntu-or-byol-bring-your-own-license").click();

        findLabel("regular").click();

        findDropDown("Machine Family").click();
        findItemInList("general-purpose").click();

        findDropDown("Series").click();
        findItemInList("n1").click();

        findDropDown("Machine type").click();
        findItemInList("n1-standard-8").click();

        addGPUButton.click();

        findDropDown("GPU Model").click();
        findItemInList("nvidia-tesla-v100").click();

        findDropDown("Number of GPUs").click();
        findItemInList("1").click();

        findDropDown("Local SSD").click();
        driver.findElements(By.xpath("//li[@data-value='2']")).get(1).click();

        findDropDown("Region").click();
        findItemInList("europe-west4").click();

        findLabel("1-year").click();
    }

    /**
     * Shares the resulting estimate by clicking the share button.
     */
    public void shareEstimate(){
        wait.until(ExpectedConditions.invisibilityOf(updateMessage));
        shareButton.click();
        wait.until(ExpectedConditions.visibilityOf(openEstimateButton)).click();
    }

    /**
     * Waits for any update messages to disappear before retrieving the estimated cost.
     * @return the estimated cost as a double
     */
    public Double getEstimate(){
        wait.until(ExpectedConditions.invisibilityOf(updateMessage));
        String estimate = estimatedCost.getText();
        return Utils.convertStringToDouble(estimate);
    }

    /**
     * Finds a drop-down element by its title.
     * @param title the title of the drop-down
     * @return the WebElement representing the drop-down
     */
    private WebElement findDropDown(String title){
        String dropDownLocator = String.format(baseDropDown, title);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropDownLocator)));
    }

    /**
     * Finds a label element by its title.
     * @param title the title of the label
     * @return the WebElement representing the label
     */
    private WebElement findLabel(String title){
        String labelLocator = String.format(baseLabel, title);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(labelLocator)));
    }

    /**
     * Finds an item in a list by its value.
     * @param value the value of the list item
     * @return the WebElement representing the list item
     */
    private WebElement findItemInList(String value){
        String listItemLocator = String.format(baseListItem, value);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(listItemLocator)));
    }

    /**
     * Adds a product to the estimate by clicking the "Add to Estimate" button and selecting the product.
     * @param product the WebElement representing the product to add
     */
    private void addProductToEstimate(WebElement product){
        addToEstimateButton.click();
        wait.until(ExpectedConditions.visibilityOf(product)).click();
    }
}
