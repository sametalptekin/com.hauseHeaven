package tests.samet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_015 {

    @Test
    public void TC_001(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userPages userPages = new userPages();

        userPages.signinButton.click();

        userPages.loginFormEmail.sendKeys(ConfigReader.getProperty("user"));
        userPages.loginFormPassword.sendKeys(ConfigReader.getProperty("user_pass"));
        userPages.loginButton.click();

        ReusableMethods.bekle(1);
        Assert.assertTrue(userPages.logoutButton.isDisplayed());

        Driver.quitDriver();

    }

    @Test
    public void TC_002(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userPages userPages = new userPages();

        userPages.signinButton.click();

        userPages.loginFormEmail.sendKeys(ConfigReader.getProperty("user"));
        userPages.loginFormPassword.sendKeys(ConfigReader.getProperty("user_pass"));
        userPages.loginButton.click();
        ReusableMethods.bekle(1);

        userPages.usernameButton.click();
        ReusableMethods.bekle(1);

        userPages.settingsButtonDashboard.click();
        ReusableMethods.bekle(1);

        userPages.firstNameBox.clear();
        userPages.firstNameBox.sendKeys(ConfigReader.getProperty("firstname"));

        userPages.lastNameBox.clear();
        userPages.lastNameBox.sendKeys(ConfigReader.getProperty("lastname"));

        userPages.usernameBox.clear();
        userPages.usernameBox.sendKeys(ConfigReader.getProperty("username"));

        userPages.phoneBox.clear();
        userPages.phoneBox.sendKeys(ConfigReader.getProperty("phone"));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, 600);");
        ReusableMethods.bekle(1);

        WebElement birthdayYearDdMenu = Driver.getDriver().findElement(By.xpath("//*[@id='year']"));
        WebElement birthdayMonthDdMenu = Driver.getDriver().findElement(By.xpath("//*[@id='month']"));
        WebElement birthdayDayDdMenu = Driver.getDriver().findElement(By.xpath("//*[@id='day']"));

        Select select = new Select(birthdayYearDdMenu);
        select.selectByValue("2000");

        Select select1 = new Select(birthdayMonthDdMenu);
        select1.selectByValue("1");

        Select select2 = new Select(birthdayDayDdMenu);
        select2.selectByValue("1");

        WebElement genderDdMenu = Driver.getDriver().findElement(By.xpath("//*[@id='gender']"));

        Select select3 = new Select(genderDdMenu);
        select3.selectByIndex(0);

        //save butonuna tıkla.
        Driver.getDriver().findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //successfully mesajı görüntülendi mi?
        WebElement successAlert = Driver.getDriver().findElement(By.xpath("//*[@class='alert alert-success alert-dismissible']"));
        ReusableMethods.bekle(2);
        Assert.assertTrue(successAlert.isDisplayed());

        Driver.quitDriver();
    }

    @Test
    public void TC_003(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userPages userPages = new userPages();

        userPages.signinButton.click();

        userPages.loginFormEmail.sendKeys(ConfigReader.getProperty("user"));
        userPages.loginFormPassword.sendKeys(ConfigReader.getProperty("user_pass"));
        userPages.loginButton.click();

        userPages.usernameButton.click();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, 100);");
        ReusableMethods.bekle(1);

        userPages.buyCreditsButtonDashboard.click();

        userPages.purchaseButton.click();
        ReusableMethods.bekle(1);

        userPages.cardNumberBox.sendKeys("4242 4242 4242 4242");
        userPages.fullNameBox.sendKeys("Zhang San");
        userPages.expDateBox.sendKeys("1234");
        userPages.cvcBox.sendKeys("567");

        js.executeScript("window.scrollBy(0, 100);");
        ReusableMethods.bekle(1);

        userPages.checkoutButton.click();
        ReusableMethods.bekle(1);

        WebElement successAlert = Driver.getDriver().findElement(By.xpath("//*[@class='alert alert-success alert-dismissible']"));
        Assert.assertTrue(successAlert.isDisplayed());
        Driver.quitDriver();
    }

    @Test
    public void TC_004(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userPages userPages = new userPages();

        userPages.signinButton.click();

        userPages.loginFormEmail.sendKeys(ConfigReader.getProperty("user"));
        userPages.loginFormPassword.sendKeys(ConfigReader.getProperty("user_pass"));
        userPages.loginButton.click();

        userPages.usernameButton.click();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, 100);");
        ReusableMethods.bekle(1);

        userPages.securityButtonDashboard.click();
        userPages.newPasswordBox.sendKeys(ConfigReader.getProperty("user_pass"));
        userPages.confirmationPassBox.sendKeys(ConfigReader.getProperty("user_pass"));

        userPages.updatePassButton.click();
        ReusableMethods.bekle(1);

        WebElement successAlert = Driver.getDriver().findElement(By.xpath("//*[@class='alert alert-success alert-dismissible']"));
        Assert.assertTrue(successAlert.isDisplayed());
        Driver.quitDriver();

    }
}


