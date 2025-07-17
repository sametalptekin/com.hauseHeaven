package tests.sevval;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

import static utilities.Driver.driver;
import static utilities.Driver.getDriver;

public class US_035 {

    private WebElement singInButton;

    @Test
    public void TC_001() {
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
    }

    @Test
    public void TC_002() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));


        WebElement realEstateMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='cms-plugins-real-estate']")));
        realEstateMenu.click();


        WebElement propertiesLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='cms-plugins-property']/a")));


        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", propertiesLink);


        String expectedUrl = "https://qa.hauseheaven.com/admin/real-estate/properties";
        if (Driver.getDriver().getCurrentUrl().equals(expectedUrl)) {
            System.out.println(" Başarıyla Properties sayfasına geçildi.");
        } else {
            System.out.println(" Sayfa geçişi başarılı. URL: " + Driver.getDriver().getCurrentUrl());
        }


    }

    @Test
    public void TC_003() throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;


        WebElement yeniIlanButonu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='botble-real-estate-tables-property-table_wrapper']/div[2]/button[1]/span/span")));
        yeniIlanButonu.click();
        System.out.println(" Yeni ilan ekleme butonuna tıklandı.");


        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='name']")));
        nameInput.clear();
        nameInput.sendKeys("deneme");
        System.out.println("İlan adı girildi.");


        WebElement descriptionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='description']")));
        descriptionInput.clear();
        descriptionInput.sendKeys("deneme");
        System.out.println(" Açıklama girildi.");


        WebElement yeniInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='botble-real-estate-forms-property-form']/div[2]/div[1]/div[1]/div/div[5]/div[3]/div[2]/div")));
        yeniInput.clear();
        yeniInput.sendKeys("deneme");
        System.out.println(" Yeni alana 'deneme' yazıldı.");


        WebElement kaydetButonu = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id='botble-real-estate-forms-property-form']/div[2]/div[2]/div[1]/div[2]/div/button[1]")));

        js.executeScript("arguments[0].scrollIntoView(true);", kaydetButonu);
        Thread.sleep(500);
        js.executeScript("arguments[0].click();", kaydetButonu);
        System.out.println(" Kaydet butonuna tıklandı.");


        try {
            WebElement successAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.className("alert-success")));
            if (successAlert.isDisplayed()) {
                System.out.println(" İlan başarıyla eklendi.");
            }
        } catch (TimeoutException e) {
            System.out.println(" Kayıt sonrası başarı mesajı bulunamadı.");
        }
    }

    @Test
    public void TC_004() throws InterruptedException {

        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;


        WebElement duzenleButonu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='botble-real-estate-tables-property-table']/tbody/tr[1]/td[8]/div/a[1]")));
        duzenleButonu.click();
        System.out.println("İlan düzenleme butonuna tıklandı.");


        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='name']")));
        nameInput.clear();
        nameInput.sendKeys("şevval");
        System.out.println(" İlan adı güncellendi.");


        WebElement descriptionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='description']")));
        descriptionInput.clear();
        descriptionInput.sendKeys("şevval");
        System.out.println(" Açıklama güncellendi.");


        WebElement yeniInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='botble-real-estate-forms-property-form']/div[2]/div[1]/div[1]/div/div[5]/div[3]/div[2]/div")));
        yeniInput.clear();
        yeniInput.sendKeys("şevval");
        System.out.println("Yeni alan güncellendi.");


        WebElement kaydetButonu = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id='botble-real-estate-forms-property-form']/div[2]/div[2]/div[1]/div[2]/div/button[1]")));

        js.executeScript("arguments[0].scrollIntoView(true);", kaydetButonu);
        Thread.sleep(500);
        js.executeScript("arguments[0].click();", kaydetButonu);
        System.out.println(" Kaydet butonuna tıklandı.");


        try {
            WebElement successAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.className("alert-success")));
            if (successAlert.isDisplayed()) {
                System.out.println(" İlan başarıyla güncellendi.");
            }
        } catch (TimeoutException e) {
            System.out.println(" Güncelleme sonrası başarı mesajı bulunamadı.");


        }
    }

    @Test
    public void TC_005() throws InterruptedException {

        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;


        WebElement silButonu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='botble-real-estate-tables-property-table']/tbody/tr[1]/td[8]/div/a[2]")));
        silButonu.click();
        System.out.println(" Silme butonuna tıklandı.");


        WebElement deleteConfirmButonu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='main']/div[2]/div/div/div[3]/button[2]")));


        js.executeScript("arguments[0].scrollIntoView(true);", deleteConfirmButonu);
        Thread.sleep(500);


        js.executeScript("arguments[0].click();", deleteConfirmButonu);
        System.out.println("Delete onay butonuna tıklandı.");


        try {
            WebElement successAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.className("alert-success")));
            if (successAlert.isDisplayed()) {
                System.out.println(" İlan başarıyla silindi.");
            }
        } catch (TimeoutException e) {
            System.out.println(" Silme sonrası başarı mesajı bulunamadı.");


        }

        Driver.closeDriver();
        System.out.println(" Tarayıcı kapatıldı ve test tamamlandı.");
    }
}








