package tests.enes;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;

public class US_002 {

    @Test
    public void TC_001(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userPages userPages= new userPages();
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertTrue(userPages.listingButton.isDisplayed());
        softAssert.assertTrue(userPages.homeButton.isDisplayed());
        softAssert.assertTrue(userPages.projectsButton.isDisplayed());
        softAssert.assertTrue(userPages.agentsButton.isDisplayed());
        softAssert.assertTrue(userPages.blogButton.isDisplayed());
        softAssert.assertTrue(userPages.contactButton.isDisplayed());
        softAssert.assertTrue(userPages.signupButton.isDisplayed());
        softAssert.assertTrue(userPages.addPropertyButton.isDisplayed());
        softAssert.assertTrue(userPages.signinButton.isDisplayed());
        softAssert.assertTrue(userPages.logoButton.isDisplayed());

        softAssert.assertAll();
        Driver.quitDriver();


    }

    @Test
    public void TC_002(){

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userPages userPages= new userPages();
        SoftAssert softAssert=new SoftAssert();

        try {
            userPages.homeButton.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        try {
            userPages.logoButton.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        try {
            userPages.projectsButton.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        try {
            userPages.listingButton.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        try {
            userPages.agentsButton.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        try {
            userPages.blogButton.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        try {
            userPages.contactButton.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        try {
            userPages.signinButton.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        try {
            userPages.signupButton.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        try {
            userPages.addPropertyButton.click();
            softAssert.assertTrue(true);
        } catch (Exception e) {
            softAssert.fail();
        }
        softAssert.assertAll();

        Driver.quitDriver();


    }

}
