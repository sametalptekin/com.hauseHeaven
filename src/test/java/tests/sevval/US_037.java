package tests.sevval;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public class US_037 {


    @Test
    public void TC_001() throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("toAdminUrl"));

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
        System.out.println(" Giriş başarılı.");


    }
    @Test
    public void TC_002(){

        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;


        WebElement realEstateMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div[2]/div[3]/div[1]/div/div/div/ul/li[4]/a")));
        js.executeScript("arguments[0].click();", realEstateMenu);


        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[2]/div[2]/div[3]/div[1]/div/div/div/ul/li[4]/ul")));


        WebElement featuresLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div[2]/div[3]/div[1]/div/div/div/ul/li[4]/ul/li[2]/a")));
        js.executeScript("arguments[0].click();", featuresLink);


        String expectedUrl = "https://qa.hauseheaven.com/admin/real-estate/features";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        if (driver.getCurrentUrl().equals(expectedUrl)) {
            System.out.println(" Features sayfasına geçildi.");
        } else {
            System.out.println("Sayfa geçişi başarısız → URL: " + driver.getCurrentUrl());
        }

    }


    @Test
    public void TC_003() {

        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;


        WebElement yeniOzellikBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"botble-real-estate-tables-feature-table_wrapper\"]/div[2]/button[1]/span/span")));
        js.executeScript("arguments[0].click();", yeniOzellikBtn);


        WebElement titleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        titleInput.clear();
        titleInput.sendKeys("ARSA");


        WebElement iconDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("span.select2-selection__rendered")));
        iconDropdown.click();


        WebElement iconOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ul[@id='select2-icon-results']/li[contains(text(),'ti-flickr')]")));
        iconOption.click();


        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"botble-real-estate-forms-feature-form\"]/div[2]/div[2]/div[1]/div[2]/div/button[1]")));
        js.executeScript("arguments[0].click();", saveBtn);



    }
    @Test
    public void TC_004() throws InterruptedException {

        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;


        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='botble-real-estate-tables-feature-table']/tbody/tr[1]/td[5]/div/a[1]")));
        js.executeScript("arguments[0].scrollIntoView(true);", editButton);
        js.executeScript("arguments[0].click();", editButton);


        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        nameInput.clear();
        nameInput.sendKeys("BİNA");


        WebElement iconDropdownClosed = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='select2-icon-container']")));
        js.executeScript("arguments[0].scrollIntoView(true);", iconDropdownClosed);
        js.executeScript("arguments[0].click();", iconDropdownClosed);


        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/span/span/span[1]/input")));
        searchInput.sendKeys("ti-github");


        Thread.sleep(1000); // Bekle ki sonuç yüklensin

        List<WebElement> githubIcons = driver.findElements(
                By.xpath("//ul[@id='select2-icon-results']/li"));

        boolean found = false;
        for (WebElement icon : githubIcons) {
            if (icon.getText().contains("ti-github")) {
                js.executeScript("arguments[0].click();", icon);
                found = true;
                break;
            }
        }


        WebElement saveAndExitButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='botble-real-estate-forms-feature-form']/div[2]/div[2]/div[1]/div[2]/div/button[1]")));
        js.executeScript("arguments[0].scrollIntoView(true);", saveAndExitButton);
        js.executeScript("arguments[0].click();", saveAndExitButton);



    }
    @Test
    public void TC_005(){

        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;


        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='botble-real-estate-tables-feature-table']/tbody/tr[1]/td[5]/div/a[2]")));
        js.executeScript("arguments[0].click();", deleteButton);


        WebElement confirmDeleteButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='main']/div[2]/div/div/div[3]/button[2]")));
        js.executeScript("arguments[0].click();", confirmDeleteButton);


    }
}







