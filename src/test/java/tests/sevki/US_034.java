package tests.sevki;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.adminPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_034 {

    @Test
    public void TC_001() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(2);
        adminPages adminPages = new adminPages();


        adminPages.loginFormEmail.sendKeys(ConfigReader.getProperty("admin"));
        adminPages.loginFormPassword.sendKeys(ConfigReader.getProperty("admin_pass"));
        adminPages.loginButton.click();

        ReusableMethods.bekle(2);
        Assert.assertTrue(adminPages.realestateMenu.isDisplayed());
        Driver.quitDriver();
    }


    @Test
    public void TC_002() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(2);
        adminPages adminPages = new adminPages();
        SoftAssert softAssert = new SoftAssert();


        adminPages.loginFormEmail.sendKeys(ConfigReader.getProperty("admin"));
        adminPages.loginFormPassword.sendKeys(ConfigReader.getProperty("admin_pass"));
        adminPages.loginButton.click();

        adminPages.realestateMenu.click();
        ReusableMethods.bekle(2);

        try {
            adminPages.propertiesMenu.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        try {
            adminPages.featuresMenu.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        try {
            adminPages.facilitiesMenu.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        try {
            adminPages.categoriesMenu.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        try {
            adminPages.typesMenu.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }


        Driver.quitDriver();


    }
}

