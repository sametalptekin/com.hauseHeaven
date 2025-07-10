package tests.mertcan;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_024 {

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

        userPages.agentsButton.click();
        ReusableMethods.bekle(1);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, 200);");
        ReusableMethods.bekle(1);

        userPages.agentsProperties.isDisplayed();

        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }
    @Test
    public void TC_003(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(2);
        userPages userPages=new userPages();

        userPages.signinButton.click();

        userPages.loginFormEmail.sendKeys(ConfigReader.getProperty("user"));
        userPages.loginFormPassword.sendKeys(ConfigReader.getProperty("user_pass"));
        userPages.loginButton.click();

        ReusableMethods.bekle(2);
        Assert.assertTrue(userPages.logoutButton.isDisplayed());

        userPages.agentsButton.click();
        ReusableMethods.bekle(1);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, 200);");
        ReusableMethods.bekle(1);

        userPages.firstAgent.click();
        ReusableMethods.bekle(1);

        js.executeScript("window.scrollBy(0, 500);");
        ReusableMethods.bekle(1);

        Assert.assertTrue(userPages.agentInfo.isDisplayed());
        Driver.quitDriver();



    }
}
