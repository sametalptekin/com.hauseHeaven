package tests.mertcan;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_026 {

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

}
