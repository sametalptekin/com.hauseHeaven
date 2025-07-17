package tests.merve;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class US_051 {




    @Test
    public void loginTesti(){

        // 1- "https://qa.househeaven.com/" adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // 2- house heaven anasayfaya gittiğini dogrulayın

        SoftAssert softAssert = new SoftAssert();

        String expectedUrl = ConfigReader.getProperty("toUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,"url expected url'den farklı");

        // 3- sign in butonuna basın

        userPages userPages = new userPages();
        PageFactory.initElements(Driver.getDriver(), userPages);
        userPages.signinButton.click();

        ReusableMethods.bekle(2);
        // 4- username Kutusuna "username" yazın

        userPages.userNameKutusu.sendKeys(ConfigReader.getProperty("toUser"));

        ReusableMethods.bekle(2);
        // 5- password kutusuna "şifre" girin

        userPages.passwordKutusu.sendKeys(ConfigReader.getProperty("userPass"));

        ReusableMethods.bekle(2);
        //  6- login butonuna tıkla
        userPages.loginButonu.click();
        ReusableMethods.bekle(2);

        // 7- profil sayfası görünür mü kontrol edilir ve tıklanır
        softAssert.assertTrue(userPages.profilButonu.isDisplayed());
        userPages.profilButonu.click();



        softAssert.assertAll();

        Driver.quitDriver();

    }



    @Test
    public void sayfaErisimVeOdemeTesti(){
        // 1- "https://qa.househeaven.com/" adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // 2- house heaven anasayfaya gittiğini dogrulayın

        SoftAssert softAssert = new SoftAssert();

        String expectedUrl = ConfigReader.getProperty("toUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,"url expected url'den farklı");

        // 3- sign in butonuna basın

        userPages userPages = new userPages();
        PageFactory.initElements(Driver.getDriver(), userPages);
        userPages.signinButton.click();

        ReusableMethods.bekle(2);
        // 4- username Kutusuna "username" yazın

        userPages.userNameKutusu.sendKeys(ConfigReader.getProperty("toUser"));

        ReusableMethods.bekle(2);
        // 5- password kutusuna "şifre" girin

        userPages.passwordKutusu.sendKeys(ConfigReader.getProperty("userPass"));

        ReusableMethods.bekle(2);
        //  6- login butonuna tıkla
        userPages.loginButonu.click();
        ReusableMethods.bekle(2);

        // 7- profil sayfası görünür mü kontrol edilir ve tıklanır
        softAssert.assertTrue(userPages.profilButonu.isDisplayed());
        userPages.profilButonu.click();

        // 8- yeni kredi satıl alma sayfasına geçiş

        userPages.buyCreditsButtonDashboard.click();
        ReusableMethods.bekle(2);

        userPages.crediPurchaseButonu.click();
        ReusableMethods.bekle(2);

        userPages.cardNumberButonu.sendKeys(ConfigReader.getProperty("cardNumber"));
        ReusableMethods.bekle(2);

        userPages.cardSonKullanmaTarihButonu.sendKeys(ConfigReader.getProperty("cardSonKullanma"));
        ReusableMethods.bekle(2);

        userPages.cardNameButonu.sendKeys(ConfigReader.getProperty("cardName"));
        ReusableMethods.bekle(2);

        userPages.cardCvcButonu.sendKeys(ConfigReader.getProperty("cardCvc"));
        ReusableMethods.bekle(2);

        userPages.crediCardKaydetmeButonu.click();
        ReusableMethods.bekle(2);




        softAssert.assertAll();

        Driver.quitDriver();
    }

    @Test
    public void adminSayfaTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("toAdminUrl"));
        ReusableMethods.bekle(2);
        SoftAssert softAssert = new SoftAssert();

        String expectedUrl = ConfigReader.getProperty("toAdminUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,"url, expected url'den farklı");

        userPages userPages = new userPages();
        PageFactory.initElements(Driver.getDriver(), userPages);
        ReusableMethods.bekle(2);



        userPages.adminUserName.sendKeys(ConfigReader.getProperty("toAdmin"));
        ReusableMethods.bekle(2);

        userPages.adminPassword.sendKeys(ConfigReader.getProperty("adminPass"));
        ReusableMethods.bekle(2);

        userPages.adminSignInButonu.click();
        ReusableMethods.bekle(10);

        softAssert.assertAll();

        // Ekran görüntüsü alma
        try {
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            File ekranGoruntusu = ts.getScreenshotAs(OutputType.FILE);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String tarihSaat = LocalDateTime.now().format(dtf);

            String dosyaYolu = "screenShots_US051_TC005" + tarihSaat + ".png";
            FileUtils.copyFile(ekranGoruntusu, new File(dosyaYolu));

            System.out.println("Ekran görüntüsü kaydedildi: " + dosyaYolu);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Driver.quitDriver();





    }
}
