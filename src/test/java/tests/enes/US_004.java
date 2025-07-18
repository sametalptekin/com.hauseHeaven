package tests.enes;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_004 {
    @Test
    public void TC_001(){

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        userPages userpages=new userPages();

        Assert.assertTrue(userpages.locationInput.isDisplayed());

        Driver.quitDriver();


    }

}
