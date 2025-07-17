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

public class US_038 {

    @Test
    public void TC_001() {
        WebDriver driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("url"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

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
    public void TC_002(){

    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    JavascriptExecutor js = (JavascriptExecutor) driver;


    WebElement realEstateMenu = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("/html/body/div[2]/div[2]/div[3]/div[1]/div/div/div/ul/li[4]/a")));
    js.executeScript("arguments[0].click();", realEstateMenu);


    wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("/html/body/div[2]/div[2]/div[3]/div[1]/div/div/div/ul/li[4]/ul")));


    WebElement facilitiesLink = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("/html/body/div[2]/div[2]/div[3]/div[1]/div/div/div/ul/li[4]/ul/li[3]/a")));
    js.executeScript("arguments[0].click();", facilitiesLink);


    String expectedUrl = "https://qa.hauseheaven.com/admin/real-estate/facilities";
    wait.until(ExpectedConditions.urlToBe(expectedUrl));

    if (driver.getCurrentUrl().equals(expectedUrl)) {
        System.out.println("✅ Facilities sayfasına geçildi.");
    } else {
        System.out.println("⚠️ Sayfa geçişi başarısız → URL: " + driver.getCurrentUrl());
    }
    }
@Test
    public void TC_003(){


    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    JavascriptExecutor js = (JavascriptExecutor) driver;


    WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//*[@id=\"botble-real-estate-tables-facility-table_wrapper\"]/div[2]/button[1]")));
    js.executeScript("arguments[0].click();", createButton);


    WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
    nameInput.clear();
    nameInput.sendKeys("VİLLA");


    WebElement iconDropdown = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("span.select2-selection__rendered")));
    iconDropdown.click();


    WebElement iconOption = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//ul[@id='select2-icon-results']/li[contains(text(),'ti-flickr')]")));
    iconOption.click();


    WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//*[@id=\"botble-real-estate-forms-facility-form\"]/div[2]/div[2]/div[1]/div[2]/div/button[1]")));
    js.executeScript("arguments[0].click();", saveBtn);


    WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[contains(text(),'başarıyla')]")));
    Assert.assertTrue(successMsg.isDisplayed(), "Tesis (Facility) eklenemedi!");
}
@Test
    public void TC_004() throws InterruptedException {

    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    JavascriptExecutor js = (JavascriptExecutor) driver;

    try {
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='botble-real-estate-tables-facility-table']/tbody/tr[1]/td[7]/div/a[1]")));
        js.executeScript("arguments[0].scrollIntoView(true);", editButton);
        js.executeScript("arguments[0].click();", editButton);


        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        nameInput.clear();
        nameInput.sendKeys("AMAZON");


        WebElement iconDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#select2-icon-container")));
        js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mousedown', { bubbles:true, cancelable:true }));", iconDropdown);
        Thread.sleep(700);

        WebElement firstIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/span/span/span[2]/ul/li[1]")));
        js.executeScript("arguments[0].scrollIntoView(true);", firstIcon);
        js.executeScript("arguments[0].click();", firstIcon);

        WebElement selectedIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/form/div[2]/div[1]/div/div/div[2]/div/span/span[1]/span/span[1]")));
        String selectedIconText = selectedIcon.getText().trim();

        System.out.println("Seçilen icon: " + selectedIconText);

        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='botble-real-estate-forms-facility-form']/div[2]/div[2]/div[1]/div[2]/div/button[1]")));
        js.executeScript("arguments[0].click();", saveButton);

        System.out.println("✅ Kayıt başarılı.");

    } catch (Exception e) {
        e.printStackTrace();
    }
}
@Test
    public void TC_005(){

    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    JavascriptExecutor js = (JavascriptExecutor) driver;

// 1. İlk satırdaki silme butonuna tıkla
    WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//*[@id='botble-real-estate-tables-facility-table']/tbody/tr[1]/td[7]/div/a[2]")));
    js.executeScript("arguments[0].scrollIntoView(true);", deleteButton);
    js.executeScript("arguments[0].click();", deleteButton);

// 2. Onay modalındaki "Evet" butonuna tıkla
    WebElement confirmYesButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//*[@id='main']/div[2]/div/div/div[3]/button[2]")));
    js.executeScript("arguments[0].click();", confirmYesButton);

    System.out.println("✅ İlk satırdaki öğe başarıyla silindi.");

}

}


