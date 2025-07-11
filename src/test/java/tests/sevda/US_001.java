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

        Assert.assertTrue(Driver.getDriver().getTitle().toLowerCase().contains("home") || Driver.getDriver().getCurrentUrl().contains("hauseheaven"));




    }



}
