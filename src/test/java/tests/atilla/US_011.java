package tests.atilla;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class US_011 {

    @Test
    public void TC_001(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(2);
        userPages userPages = new userPages();

        userPages.signinButton.click();

        userPages.loginFormEmail.sendKeys(ConfigReader.getProperty("user"));
        userPages.loginFormPassword.sendKeys(ConfigReader.getProperty("user_pass"));
        userPages.loginButton.click();

        ReusableMethods.bekle(2);
        Assert.assertTrue(userPages.logoutButton.isDisplayed());
        userPages.contactButton.click();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, 180);");
        ReusableMethods.bekle(1);
        tearDown();
    }

    @Test
    public void TC_002(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(2);
        userPages userPages = new userPages();

        userPages.signinButton.click();

        userPages.loginFormEmail.sendKeys(ConfigReader.getProperty("user"));
        userPages.loginFormPassword.sendKeys(ConfigReader.getProperty("user_pass"));
        userPages.loginButton.click();

        ReusableMethods.bekle(2);
        Assert.assertTrue(userPages.logoutButton.isDisplayed());
        userPages.contactButton.click();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, 180);");
        ReusableMethods.bekle(1);

        String Ad = "Deneme";
        String email = "a@a.com";
        String konu = "Deneme";
        String Mesaj = "Deneme mesaj";
        String telno = "05111111111";

        userPages.contactName.sendKeys(Ad);
        userPages.contactEmail.sendKeys(email);
        userPages.contactSubject.sendKeys(konu);
        userPages.contactPhone.sendKeys(telno);
        userPages.contactMessage.sendKeys(Mesaj);
        userPages.sendMessageBttn.click();

        ReusableMethods.waitForVisibility(userPages.sendMessageSuccess, 10);
        Assert.assertTrue(userPages.sendMessageSuccess.isDisplayed(), "Mesaj gönderme başarılı olmadı!");

    }

    @AfterTest
    public void tearDown(){
        Driver.quitDriver();
    }
}
