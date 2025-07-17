package tests.merve;

import com.google.errorprone.annotations.RestrictedApi;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.adminPages;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
        userPages.signInButton.click();

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
        userPages.signInButton.click();

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

        userPages.buyCreditsButonu.click();
        ReusableMethods.bekle(2);

        userPages.paketSatinAlmaButton.click();
        ReusableMethods.bekle(2);

        userPages.cardNumberButonu.sendKeys(ConfigReader.getProperty("cardNumber"));
        ReusableMethods.bekle(2);

        userPages.cardSonKullanmaTarihButonu.sendKeys(ConfigReader.getProperty("cardSonKullanma"));
        ReusableMethods.bekle(2);

        userPages.cardNameButonu.sendKeys(ConfigReader.getProperty("cardName"));
        ReusableMethods.bekle(2);

        userPages.cardCvcButonu.sendKeys(ConfigReader.getProperty("cardCvc"));
        ReusableMethods.bekle(2);

        userPages.checkoutButonu.click();
        ReusableMethods.bekle(2);

        softAssert.assertAll();

        Driver.quitDriver();
    }

    @Test
    public void adminLoginTesti() {
        Driver.getDriver().get(ConfigReader.getProperty("toAdminUrl"));
        ReusableMethods.bekle(2);

        SoftAssert softAssert = new SoftAssert();

        String expectedUrl = ConfigReader.getProperty("toAdminUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "url, expected url'den farklı");

        adminPages adminPages = new adminPages();
        PageFactory.initElements(Driver.getDriver(), adminPages);
        ReusableMethods.bekle(2);

        adminPages.loginFormEmail.sendKeys(ConfigReader.getProperty("toAdmin"));
        ReusableMethods.bekle(2);

        adminPages.loginFormPassword.sendKeys(ConfigReader.getProperty("adminPass"));
        ReusableMethods.bekle(2);

        adminPages.loginButton.click();
        ReusableMethods.bekle(3);

        softAssert.assertAll();
        Driver.quitDriver();
    }


    @Test
    public void adminOdemeGoruntulemeTesti(){

        Driver.getDriver().get(ConfigReader.getProperty("toAdminUrl"));
        ReusableMethods.bekle(2);
        SoftAssert softAssert = new SoftAssert();

        String expectedUrl = ConfigReader.getProperty("toAdminUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,"url, expected url'den farklı");


        adminPages adminPages = new adminPages();
        PageFactory.initElements(Driver.getDriver(), adminPages);
        ReusableMethods.bekle(2);

        adminPages.loginFormEmail.sendKeys(ConfigReader.getProperty("toAdmin"));
        ReusableMethods.bekle(2);

        adminPages.loginFormPassword.sendKeys(ConfigReader.getProperty("adminPass"));
        ReusableMethods.bekle(2);

        adminPages.loginButton.click();
        ReusableMethods.bekle(2);

        adminPages.adminPackagesButonu.click();
        ReusableMethods.bekle(3);

        // Sayfa açıldığında ekran görüntüsü al
        try {
            File klasor = new File("screenShots_US051_TC004");
            if (!klasor.exists()) {
                klasor.mkdirs();
            }

            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            File ekranGoruntusu = ts.getScreenshotAs(OutputType.FILE);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String tarihSaat = LocalDateTime.now().format(dtf);

            String dosyaYolu = "screenShots_US051_TC004/sayfaAcildiginda_" + tarihSaat + ".png";
            FileUtils.copyFile(ekranGoruntusu, new File(dosyaYolu));

            System.out.println(" Sayfa açıldığında ekran görüntüsü alındı: " + dosyaYolu);
        } catch (IOException e) {
            e.printStackTrace();
        }

        softAssert.assertAll();
        Driver.quitDriver();


    }
}
