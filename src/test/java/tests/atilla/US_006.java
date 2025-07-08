package tests.atilla;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_006 {

    @Test
    public void TC_001(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(3);
        userPages userPages = new userPages();

        userPages.listingButton.click();

    }



}
