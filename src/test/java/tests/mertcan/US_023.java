package tests.mertcan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_023 {


    @Test
    public void TC_001(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(2);
        userPages userPages=new userPages();

        userPages.signinButton.click();

        userPages.loginFormEmail.sendKeys(ConfigReader.getProperty("user"));
        userPages.loginFormPassword.sendKeys(ConfigReader.getProperty("user_pass"));
        userPages.loginButton.click();

        ReusableMethods.bekle(2);
        Assert.assertTrue(userPages.logoutButton.isDisplayed());
        Driver.quitDriver();
    }

    @Test
    public void TC_002(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(2);
        userPages userPages=new userPages();

        userPages.signinButton.click();

        userPages.loginFormEmail.sendKeys(ConfigReader.getProperty("user"));
        userPages.loginFormPassword.sendKeys(ConfigReader.getProperty("user_pass"));
        userPages.loginButton.click();

        ReusableMethods.bekle(2);
        Assert.assertTrue(userPages.logoutButton.isDisplayed());

        userPages.projectsButton.click();
        ReusableMethods.bekle(1);

        int expectedResimSayisi = 9;
        int actualResimSayisi = userPages.projeSayisi.size();

        Assert.assertEquals(actualResimSayisi, expectedResimSayisi, "Resim sayısı beklenenle uyuşmuyor!");

        ReusableMethods.bekle(2);
        Driver.quitDriver();

    }
      }
