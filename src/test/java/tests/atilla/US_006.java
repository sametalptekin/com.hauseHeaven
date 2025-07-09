package tests.atilla;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
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
        tearDown();
    }

    @Test
    public void TC_002() {
        Driver.getDriver().get(ConfigReader.getProperty("househeavenproperties.url"));
        ReusableMethods.bekle(3);
        String expectedTitle = "Properties";
        String actualTitle = Driver.getDriver().getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Sayfa başarılı şekilde açıldı. Title: " + actualTitle);
        } else {
            System.out.println("Sayfa açılamadı veya title beklendiği gibi değil." + "\nBeklenen: " + expectedTitle +"\nGerçek: " + actualTitle);
            Assert.fail("Title kontrolü başarısız.");
        }
        tearDown();
    }


    @Test
    public void TC_003() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(3);
        userPages userPages = new userPages();
        userPages.listingButton.click();
        ReusableMethods.bekle(3);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", userPages.satilikDaire6button);
        ReusableMethods.bekle(2);
        userPages.satilikDaire6button.click();
        ReusableMethods.bekle(3);

        String expectedilanTitle = "Satılık Daire";
        String actualIlanTitle = userPages.getSatilikDaire6baslik.getText();
        if (actualIlanTitle.contains(expectedilanTitle)) {
            System.out.println("Sayfa başarılı şekilde açıldı. Title: " + actualIlanTitle);
        } else {
            System.out.println("Sayfa açılamadı veya title beklendiği gibi değil." + "\nBeklenen: " + expectedilanTitle +"\nGerçek: " + actualIlanTitle);
            Assert.fail("Title kontrolü başarısız.");
        }

        String expectedFiyatTitle = "$130,000";
        String actualFiyatTitle = userPages.satilikDaire6fiyat.getText();

        if (actualFiyatTitle.contains(expectedFiyatTitle)) {
            System.out.println("Sayfa başarılı şekilde açıldı. Fiyat: " + actualFiyatTitle);
        } else {
            System.out.println("Sayfa açılamadı veya fiyat beklendiği gibi değil." + "\nBeklenen: " + expectedFiyatTitle +"\nGerçek: " + actualFiyatTitle);
            Assert.fail("Fiyat kontrolü başarısız.");
        }


    }

    @AfterTest
    public void tearDown() {
        Driver.quitDriver();
    }
}
