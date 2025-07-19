package tests.sevda;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class US_012 {

    @Test
    public void TC_001()
    {
        Driver.getDriver().get(ConfigReader.getProperty("tohauseheavenregister.url"));
        userPages userPages = new userPages();
        userPages.AllowCookies.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        // Alanların görünüp görünmediğini kontrol et
        Assert.assertTrue(userPages.firstNameRegister.isDisplayed());
        Assert.assertTrue(userPages.lastNameRegister.isDisplayed());
        Assert.assertTrue(userPages.userNameBox.isDisplayed());
        Assert.assertTrue(userPages.emailBox.isDisplayed());
        Assert.assertTrue(userPages.passwordKutusu.isDisplayed());
        Assert.assertTrue(userPages.comfirmBox.isDisplayed());




        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        // Zayıf şifre ile kayıt denemesi
        userPages.firstNameRegister.sendKeys("Sevda");
        userPages.lastNameRegister.sendKeys("Kanik");
        userPages.userNameBox.sendKeys("sevda123");
        userPages.emailBox.sendKeys("sevda123@test.com");
        userPages.passwordKutusu.sendKeys("1234");               // Zayıf şifre
        userPages.comfirmBox.sendKeys("1234");
        js.executeScript("arguments[0].scrollIntoView(true);", userPages.registerButton);
        ReusableMethods.bekle(1);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", userPages.registerButton);


        wait.until(ExpectedConditions.elementToBeClickable(userPages.registerButton));

        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", userPages.registerButton);


        // Zayıf şifre uyarısı geldi mi?
        // tahmini
        ReusableMethods.bekle(4);
        Assert.assertTrue(userPages.passwordWarningBox.isDisplayed(), "Zayıf şifre uyarısı gösterilmeliydi");

        Driver.quitDriver();




    }

    @Test
    public void TC_002()
    {
        Driver.getDriver().get("https://qa.hauseheaven.com/register");
        userPages userPages = new userPages();
        userPages.AllowCookies.click();
        // WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        // Geçerli ve benzersiz bilgiler girilir
        userPages.firstNameRegister.sendKeys("Sevda");
        userPages.lastNameRegister.sendKeys("Kanik");

        String randomUsername = "sevda" + Faker.instance().number().digits(5);
        String randomEmail = "sevda" + Faker.instance().number().digits(5) + "@test.com";

        userPages.userNameBox.sendKeys(randomUsername);
        userPages.emailBox.sendKeys(randomEmail);

        userPages.passwordKutusu.sendKeys("Sevda123.");
        userPages.comfirmBox.sendKeys("Sevda123.");
        userPages.registerButton.click();

        // Başarılı kayıt sonrası dashboard’a yönlendirilme kontrolü
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/account/dashboard"));

        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/account/dashboard"), "Kayıt sonrası kullanıcı dashboard'a yönlendirilmeliydi.");

        Driver.quitDriver();
    }

    @Test
    public void TC_003()
    {
        Driver.getDriver().get(ConfigReader.getProperty("tohauseheavenregister.url"));
        userPages userPages = new userPages();
        userPages.AllowCookies.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


        userPages.firstNameBox.sendKeys("Sevda");
        userPages.lastNameBox.sendKeys("Kanik");
        userPages.userNameBox.sendKeys("sevda123");
        userPages.emailBox.sendKeys("sevda123@test.com");
        userPages.passwordKutusu.sendKeys("Sevda123.");
        userPages.comfirmBox.sendKeys("Sevda123.");
        js.executeScript("arguments[0].scrollIntoView(true);", userPages.registerButton);
        ReusableMethods.bekle(1);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", userPages.registerButton);


        wait.until(ExpectedConditions.elementToBeClickable(userPages.registerButton));

        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", userPages.registerButton);

        ReusableMethods.bekle(4);


        // Aynı kullanıcı adı ya da e-posta uyarısı kontrolü

        Assert.assertTrue(userPages.duplicateWarningUsername.isDisplayed(), "Aynı username için uyarı gösterilmeliydi");

        Assert.assertTrue(userPages.duplicateWarningEmail.isDisplayed(), "Aynı email için uyarı gösterilmeliydi");
        Driver.quitDriver();



    }
    @Test
    public void TC_004()
    {


        // Login olmadan doğrudan dashboard adresine git
        Driver.getDriver().get(ConfigReader.getProperty("tohauseheavendashboard.url"));


        // URL kontrolü: login sayfasına yönlendirme bekleniyor
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/login"));

        String currentUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(" Geçerli URL: " + currentUrl);

        // Assertion: Kullanıcı login sayfasına yönlendirilmiş olmalı
        Assert.assertTrue(currentUrl.contains("/login"),
                " Giriş yapılmadan dashboard'a erişim sağlandı! Güvenlik açığı olabilir.");

        System.out.println(" Login olmadan dashboard erişimi engellendi.");


        Driver.quitDriver();
    }




}
