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
    @Test
    public void TC_002(){

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        userPages userPages=new userPages();

        String location="Los Angeles";
        userPages.locationInput.sendKeys(location);
        ReusableMethods.bekle(1);

        userPages.filtreSubmit.click();
        ReusableMethods.bekle(2);

        List<WebElement> ilanKonumlari = userPages.tumIlanKonumElementleri;

        Assert.assertFalse(ilanKonumlari.isEmpty(),"İlan bulunamadi");

        for (WebElement konum : ilanKonumlari){
            String actualLocation = konum.getText().replace("📍", "").trim();
            Assert.assertEquals(actualLocation,"Los Angeles","Farklı bir konum bulundu : "+actualLocation);

        }
        Driver.quitDriver();

    }

}
