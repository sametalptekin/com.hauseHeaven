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
    @Test
    public void TC_003(){
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        userPages userPages=new userPages();

        String minPriceData = "500";
        String maxPriceData = "2000";

        int min = Integer.parseInt(minPriceData);
        int max = Integer.parseInt(maxPriceData);

        userPages.minPrice.click();
        ReusableMethods.popuptanSec(minPriceData);
        ReusableMethods.bekle(1);
        userPages.maxPrice.click();
        ReusableMethods.popuptanSec(maxPriceData);
        ReusableMethods.bekle(1);

        userPages.filtreSubmit.click();
        List<WebElement> fiyatlar = userPages.ilanFiyatListesi;
        Assert.assertFalse(fiyatlar.isEmpty(), "Hiç ilan bulunamadı");

        for (WebElement  fiyatElement : fiyatlar){
            String fiyatText = fiyatElement.getText();
            fiyatText = fiyatText.replaceAll("[^0-9]", "");
            if (fiyatText.isEmpty()) {
                Assert.fail("Fiyat metni boş veya sayısal değil");
            }

            int actualFiyat = Integer.parseInt(fiyatText);

            Assert.assertTrue(actualFiyat >= min && actualFiyat <= max,
                    "Fiyat aralığı dışında: $" + actualFiyat);

        }
        Driver.quitDriver();

    }
    @Test
    public void TC_004(){
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        userPages userPages=new userPages();

        String bedRoomsData= "1";

        userPages.bedRooms.click();
        ReusableMethods.popuptanSec(bedRoomsData);
        ReusableMethods.bekle(1);

        userPages.filtreSubmit.click();

        List<WebElement> odaBilgisi =userPages.tumOdaBilgileri;
        Assert.assertFalse(odaBilgisi.isEmpty());

        for (WebElement oda : odaBilgisi) {
            String odaYazisi = oda.getText().trim();
            if (odaYazisi.toLowerCase().contains("bed")) {
                Assert.assertTrue(odaYazisi.toLowerCase().contains("1 bed"),
                        "Farklı odalı ilan bulundu: " + odaYazisi);
            }
        }
        Driver.quitDriver();

}
}
