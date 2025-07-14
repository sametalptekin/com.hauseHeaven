package tests.sevki;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.adminPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US28 {
    @Test
    public void TC_001(){

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(2);
        adminPages adminPages=new adminPages();



        adminPages.loginFormEmail.sendKeys(ConfigReader.getProperty("admin"));
        adminPages.loginFormPassword.sendKeys(ConfigReader.getProperty("admin_pass"));
        adminPages.loginButton.click();

        ReusableMethods.bekle(2);
        Assert.assertTrue(adminPages.dashboardButton.isDisplayed());
        Driver.quitDriver();
    }
    @Test

    public void TC_002(){

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(2);
        adminPages adminPages=new adminPages();



        adminPages.loginFormEmail.sendKeys(ConfigReader.getProperty("user"));
        adminPages.loginFormPassword.sendKeys(ConfigReader.getProperty("user_pass"));
        adminPages.loginButton.click();


        ReusableMethods.bekle(2);
        Assert.assertTrue(adminPages.errormessage.isDisplayed());
        Driver.quitDriver();

    }
    @Test

    public void TC_003() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(2);
        adminPages adminPages=new adminPages();
        SoftAssert softAssert=new SoftAssert();


        adminPages.loginFormEmail.sendKeys(ConfigReader.getProperty("admin"));
        adminPages.loginFormPassword.sendKeys(ConfigReader.getProperty("admin_pass"));
        adminPages.loginButton.click();

        try {
            adminPages.blogMenu.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        try {
            adminPages.testimonialsMenu.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        try {
            adminPages.realestateMenu.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        try {
            adminPages.newsletterMenu.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        try {
            adminPages.consultMenu.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        try {
            adminPages.accountsMenu.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        try {
            adminPages.packagesMenu.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        try {
            adminPages.contactMenu.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        try {
            adminPages.locationsMenu.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        try {
            adminPages.translationsMenu.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();

        }
        try {
            adminPages.platformAdministrationMenu.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();

        }


        Driver.quitDriver();
    }

}



