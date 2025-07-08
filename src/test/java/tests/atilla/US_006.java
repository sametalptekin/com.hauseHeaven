package tests.atilla;

import org.testng.Assert;
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
        ReusableMethods.bekle(3);
    }

    @Test
    public void TC_002() {
        String url = ConfigReader.getProperty("househeavenproperties.url");
        Driver.getDriver().get(url);

        ReusableMethods.bekle(10);

        String expectedTitle = "Properties";
        String actualTitle = Driver.getDriver().getTitle();

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Sayfa başarılı şekilde açıldı. Title: " + actualTitle);
        } else {
            System.out.println("Sayfa açılamadı veya title beklendiği gibi değil.");
            System.out.println("Beklenen: " + expectedTitle);
            System.out.println("Gerçek: " + actualTitle);
            Assert.fail("Title kontrolü başarısız.");
        }
    }

    @AfterTest
    public void tearDown() {
        Driver.quitDriver();
    }
}
