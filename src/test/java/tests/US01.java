package tests;

import org.testng.annotations.Test;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;

public class US01 {

    userPages adminPages= new userPages();

    @Test
    public void US01(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        adminPages.signinButton.click();

        Driver.quitDriver();
    }
}
