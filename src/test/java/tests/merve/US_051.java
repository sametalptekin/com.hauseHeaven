package tests.merve;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

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
    public void sayfaErisimTesti(){
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

        userPages.buyCreditsButonu.click();
        ReusableMethods.bekle(2);














        softAssert.assertAll();

        Driver.quitDriver();
    }
}
