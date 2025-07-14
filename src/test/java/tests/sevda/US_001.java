package tests.sevda;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;



public class US_001 {

    @Test
    public void TC_001 ()
    {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        ReusableMethods.bekle(2);
        userPages userPages=new userPages();

        Assert.assertTrue(Driver.getDriver().getTitle().toLowerCase().contains("home") || Driver.getDriver().getCurrentUrl().contains("hauseheaven"));

        Assert.assertTrue(userPages.signinButton.isDisplayed());

        Assert.assertTrue(userPages.signupButton.isDisplayed());

        Assert.assertTrue(userPages.homeButton.isDisplayed());

        Assert.assertTrue(userPages.projectsButton.isDisplayed());
        Assert.assertTrue(userPages.agentsButton.isDisplayed());

        Assert.assertTrue(userPages.blogButton.isDisplayed());
        Assert.assertTrue(userPages.contactButton.isDisplayed());
        Assert.assertTrue(userPages.listingButton.isDisplayed());
        Driver.quitDriver();

    }
    @Test
    public void TC_002 ()
    {





    }



}
