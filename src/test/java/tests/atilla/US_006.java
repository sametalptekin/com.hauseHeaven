package tests.atilla;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;



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
        String ilanUrl = "https://qa.hauseheaven.com/properties/satilik-daire-6";
        ReusableMethods.waitForPageToLoad(5);
        String girilenIlanUrl = Driver.getDriver().getCurrentUrl();

        if (!ilanUrl.equals(girilenIlanUrl)) {
            Driver.getDriver().get(ilanUrl);
        }
        String expectedilanTitle = "Ego Dominus Tuus";
        String actualIlanTitle = userPages.getSatilikDaire6baslik.getText();

        if (actualIlanTitle.contains(expectedilanTitle)) {
            System.out.println("Sayfa başarılı şekilde açıldı. Title: " + actualIlanTitle);
        } else {
            System.out.println("Sayfa açılamadı veya title beklendiği gibi değil." + "\nBeklenen: " + expectedilanTitle +"\nGerçek: " + actualIlanTitle);
            Assert.fail("Title kontrolü başarısız.");
        }

        String expectedFiyatTitle = "$130,000";
        String actualFiyatTitle = userPages.satilikDaire6fiyat.getText();
        actualFiyatTitle.replaceAll("[^\\d]", "");

        if (actualFiyatTitle.contains(expectedFiyatTitle)) {
            System.out.println("Sayfa başarılı şekilde açıldı. Fiyat: " + actualFiyatTitle);
        } else {
            System.out.println("Sayfa açılamadı veya fiyat beklendiği gibi değil." + "\nBeklenen: " + expectedFiyatTitle +"\nGerçek: " + actualFiyatTitle);
            Assert.fail("Fiyat kontrolü başarısız.");
        }


    }

    @Test
    public void TC_004() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(3);
        userPages userPages = new userPages();

        // Filtre verileri
        String locationdata = "Tacoma";
        String minPricedata = "5000";
        String propertyTypedata = "Apartment";

        userPages.locationInput.sendKeys(locationdata);
        ReusableMethods.bekle(1);
        userPages.minPrice.click();
        ReusableMethods.popuptanSec(minPricedata);
        ReusableMethods.bekle(2);
        userPages.propertyType.click();
        ReusableMethods.popuptanSec(propertyTypedata);
        ReusableMethods.bekle(2);
        userPages.filtreSubmit.click();
        ReusableMethods.waitForVisibility(userPages.locationInput, 10);

        // İlanları al
        List<WebElement> locations = Driver.getDriver().findElements(By.xpath("//*[@class='listing-locate']"));
        List<WebElement> prices = Driver.getDriver().findElements(By.xpath("//*[@class='listing-card-info-price']"));

        int minPrice = Integer.parseInt(minPricedata);
        boolean filtreHatasiVar = false;

        for (int i = 0; i < locations.size(); i++) {
            String loc = locations.get(i).getText().toLowerCase();
            String priceText = prices.get(i).getText().toLowerCase();

            int price;
            if (priceText.contains("million")) {
                String numberPart = priceText.replaceAll("[^\\d]", "");
                price = numberPart.isEmpty() ? 0 : Integer.parseInt(numberPart) * 1_000_000;
            } else {
                price = Integer.parseInt(priceText.replaceAll("[^\\d]", ""));
            }

            System.out.println("İlan " + (i + 1) + ": Lokasyon = " + loc + ", Fiyat = " + price);
            System.out.println();

            if (!loc.contains(locationdata.toLowerCase())) {
                System.err.println("!!! Uyarı: Beklenmeyen lokasyon bulundu: " + loc);
                System.out.println();
                filtreHatasiVar = true;
            }

            if (price < minPrice) {
                System.err.println("!!! Uyarı: Minimum fiyatın altında ilan bulundu: " + price);
                System.out.println();
                filtreHatasiVar = true;
            }
        }

        if (filtreHatasiVar) {
            try {
                String screenshotPath = ReusableMethods.getScreenshot("TC_004_FiltreHatasi");
                System.out.println("Ekran görüntüsü alındı: " + screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Assert.assertFalse(filtreHatasiVar, "Bazı ilanlar filtre kriterlerine uymuyor.");
    }



    @AfterTest
    public void tearDown() {
        Driver.quitDriver();
    }
}
