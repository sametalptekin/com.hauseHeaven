package tests.sevval;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

import static utilities.Driver.driver;

public class US_036 {

    @Test
    public void TC_001() {
        WebDriver driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("toAdminUrl"));
    }

    @Test
    public void TC_002() {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='emailGroup']//input")));

        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='passwordGroup']//input")));

        emailInput.sendKeys(ConfigReader.getProperty("admin"));
        passwordInput.sendKeys(ConfigReader.getProperty("admin_pass"));

        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@class='btn btn-block login-button']")));
        signInButton.click();

        wait.until(ExpectedConditions.urlContains("dashboard"));
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @Test
    public void TC_003() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));


        WebElement realEstateMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='cms-plugins-real-estate']")));
        realEstateMenu.click();

        Thread.sleep(1000);


        Driver.getDriver().quit();

    }
    @Test
    public void TC_004() throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("url"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));


        WebElement realEstateMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='cms-plugins-real-estate']")));
        realEstateMenu.click();

        Thread.sleep(1000);


        Driver.getDriver().quit();


    }
    @Test
    public void TC_005() throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("url"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));


        WebElement realEstateMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='cms-plugins-real-estate']")));
        realEstateMenu.click();

        Thread.sleep(1000);


        Driver.getDriver().quit();

    }
}


