package tests.samet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;

public class US_018 {

    @Test
    public void TC_001() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userPages userPages = new userPages();

        String locationData = "Denver";
        String minPriceData = "500";
        String maxPriceData = "50000";
        String propertyTypeData = "Apartment";
        String bedRoomsData = "1";

        userPages.locationInput.sendKeys(locationData);
        ReusableMethods.bekle(1);
        userPages.minPrice.click();
        ReusableMethods.popuptanSec(minPriceData);
        ReusableMethods.bekle(1);
        userPages.maxPrice.click();
        ReusableMethods.popuptanSec(maxPriceData);
        ReusableMethods.bekle(1);
        userPages.propertyType.click();
        ReusableMethods.popuptanSec(propertyTypeData);
        ReusableMethods.bekle(1);
        userPages.bedRooms.click();
        ReusableMethods.popuptanSec(bedRoomsData);
        ReusableMethods.bekle(1);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, 100);");
        ReusableMethods.bekle(1);

        userPages.filtreSubmit.click();
        ReusableMethods.bekle(1);

        js.executeScript("window.scrollBy(0, 100);");
        ReusableMethods.bekle(1);

        List<WebElement> locations = Driver.getDriver().findElements(By.xpath("//*[@class='listing-locate']"));
        List<WebElement> prices = Driver.getDriver().findElements(By.xpath("//*[@class='listing-card-info-price']"));
        List<WebElement> bedRooms = Driver.getDriver().findElements(By.xpath("(//div[@class='listing-card-info-icon'])[1]"));

        int minPrice = Integer.parseInt(minPriceData);
        boolean filtreHatasiVar = false;

        for (int i = 0; i < locations.size(); i++) {
            String loc = locations.get(i).getText().toLowerCase();

            if (!loc.contains(locationData.toLowerCase())) {
                System.out.println("Hata! Beklenmeyen Lokasyon Bulundu: " + loc);
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
        Driver.quitDriver();
    }

}


