package tests.enes;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;

import java.net.HttpURLConnection;

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
    @Test
    public void TC_003(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userPages userPages = new userPages();
        SoftAssert softAssert = new SoftAssert();

        userPages.logoButton.click();
        String currentUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains("qa.hauseheaven.com"));

        userPages.homeButton.click();
        currentUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains("qa.hauseheaven.com"));

        userPages.projectsButton.click();
        currentUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains("project"));

        userPages.listingButton.click();
        currentUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains("properties"));

        userPages.agentsButton.click();
        currentUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains("agents"));

        userPages.homeButton.click();
        currentUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains("qa.hauseheaven.com"));

        userPages.blogButton.click();
        currentUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains("blog"));

        userPages.contactButton.click();
        currentUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains("contact"));


        userPages.signupButton.click();
        currentUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains("register"));

        userPages.addPropertyButton.click();
        currentUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains("login"));

        userPages.signinButton.click();
        currentUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains("login"));

        softAssert.assertAll();
        Driver.quitDriver();
    }

    @Test
    public void TC_004(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userPages userPages = new userPages();
        SoftAssert softAssert = new SoftAssert();

        userPages.logoButton.click();
        softAssert.assertTrue(userPages.locationInput.isDisplayed());

        userPages.homeButton.click();
        softAssert.assertTrue(userPages.locationInput.isDisplayed());

        userPages.listingButton.click();
        softAssert.assertTrue(userPages.propertyPagePropertyYazisi.isDisplayed());

        userPages.projectsButton.click();
        softAssert.assertTrue(userPages.projectsPageProjectsYazisi.isDisplayed());

        userPages.agentsButton.click();
        softAssert.assertTrue(userPages.agentsPageAllagentsYazisi.isDisplayed());

        userPages.blogButton.click();
        softAssert.assertTrue(userPages.blogPageBlogYazisi.isDisplayed());

        userPages.contactButton.click();
        softAssert.assertTrue(userPages.contactPageContactYazisi.isDisplayed());

        userPages.signupButton.click();
        softAssert.assertTrue(userPages.signupPageRegisterYazisi.isDisplayed());

        userPages.signinButton.click();
        softAssert.assertTrue(userPages.signinPageLoginYazisi.isDisplayed());

        softAssert.assertAll();
        Driver.quitDriver();

    }

}
