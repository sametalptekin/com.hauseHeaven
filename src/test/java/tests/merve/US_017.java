package tests.merve;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class US_017 {

    @Test
    public void ustMenuGorunurlukTesti(){

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

        // 7- ust menunun görünür olup olmadıgını test et

        softAssert.assertTrue(userPages.listingButonu.isDisplayed());
        softAssert.assertTrue(userPages.homeButonu.isDisplayed());
        softAssert.assertTrue(userPages.projectsButonu.isDisplayed());
        softAssert.assertTrue(userPages.agentsButonu.isDisplayed());
        softAssert.assertTrue(userPages.blogButonu.isDisplayed());
        softAssert.assertTrue(userPages.contactButonu.isDisplayed());
        softAssert.assertTrue(userPages.signupButonu.isDisplayed());
        softAssert.assertTrue(userPages.addPropertyButonu.isDisplayed());
        softAssert.assertTrue(userPages.logoButonu.isDisplayed());
        softAssert.assertTrue(userPages.profilButonu.isDisplayed());


        ReusableMethods.bekle(2);



        // ust menu aktifliği test et

        try {
                userPages.homeButonu.click();
                softAssert.assertTrue(true);
            } catch (Exception e) {
                softAssert.fail();
            }
        try {
                userPages.logoButonu.click();
                softAssert.assertTrue(true);
            } catch (Exception e) {
                softAssert.fail();
            }
        try {
                userPages.projectsButonu.click();
                softAssert.assertTrue(true);
            } catch (Exception e) {
                softAssert.fail();
            }
        try {
                userPages.listingButonu.click();
                softAssert.assertTrue(true);
            } catch (Exception e) {
                softAssert.fail();
            }
        try {
                userPages.agentsButonu.click();
                softAssert.assertTrue(true);
            } catch (Exception e) {
                softAssert.fail();
            }
        try {
                userPages.blogButonu.click();
                softAssert.assertTrue(true);
            } catch (Exception e) {
                softAssert.fail();
            }
        try {
                userPages.contactButonu.click();
                softAssert.assertTrue(true);
            } catch (Exception e) {
                softAssert.fail();
            }

        try {
                userPages.signupButonu.click();
                softAssert.assertTrue(true);
            } catch (Exception e) {
                softAssert.fail();
            }
        try {
                userPages.addPropertyButonu.click();
                softAssert.assertTrue(true);
            } catch (Exception e) {
                softAssert.fail();

            }
        try {
            userPages.profilButonu.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();

        }



        softAssert.assertAll();
        Driver.quitDriver();





    }
}
