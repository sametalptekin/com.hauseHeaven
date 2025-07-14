package tests.samet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_021 {

    @Test
    public void TC_001(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userPages userPages = new userPages();

        Assert.assertTrue(userPages.listingButton.isDisplayed());

        userPages.listingButton.click();
        String expectedUrl = "https://qa.hauseheaven.com/properties?layout=sidebar";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        WebElement ilanSayisi = Driver.getDriver().findElement(By.xpath("//*[@class='m-0']"));
        Assert.assertTrue(ilanSayisi.isDisplayed());

        Driver.quitDriver();
    }

    @Test
    public void TC_002() {
        Driver.getDriver().get(ConfigReader.getProperty("househeavenproperties.url"));
        userPages userPages = new userPages();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, 400);");
        ReusableMethods.bekle(1);

        WebElement ilanlar = Driver.getDriver().findElement(By.xpath("(//*[@class='property-listing property-2 '])[1]"));
        Assert.assertTrue(ilanlar.isDisplayed());

        WebElement ilanIsmi = Driver.getDriver().findElement(By.xpath("(//*[@class='prt-link-detail'])[1]"));
        Assert.assertTrue(ilanIsmi.isDisplayed());

        String expectedIcerik = ilanIsmi.getText();

        WebElement ilanBeds = Driver.getDriver().findElement(By.xpath("(//*[@class='listing-card-info-icon'])[1]"));
        Assert.assertTrue(ilanBeds.isDisplayed());

        WebElement ilanBaths = Driver.getDriver().findElement(By.xpath("(//*[@class='listing-card-info-icon'])[2]"));
        Assert.assertTrue(ilanBaths.isDisplayed());

        WebElement ilanFiyat = Driver.getDriver().findElement(By.xpath("(//*[@class='listing-card-info-price'])[1]"));
        Assert.assertTrue(ilanFiyat.isDisplayed());

        WebElement ilanLoc = Driver.getDriver().findElement(By.xpath("(//*[@class='foot-location d-flex'])[1]"));
        Assert.assertTrue(ilanLoc.isDisplayed());

        ilanIsmi.click();

        WebElement ilanIsmi2 = Driver.getDriver().findElement(By.xpath("(//h3)[1]"));

        String actualIcerik = ilanIsmi2.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        Driver.quitDriver();





    }

    @Test
    public void TC_003() {
        Driver.getDriver().get(ConfigReader.getProperty("househeavenproperties.url"));
        userPages userPages = new userPages();

        WebElement ilanFilter = Driver.getDriver().findElement(By.xpath("//*[@id='filter_search']"));
        Assert.assertTrue(ilanFilter.isDisplayed());

        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//*[@placeholder='Search for a location']"));

        String locData = "Denver";
        String cityData = "denver";
        String typeData = "For Sale";
        String minData = "10000";
        String bedroomData = "4";

        searchBox.sendKeys(locData);
        ReusableMethods.bekle(1);

        WebElement city = Driver.getDriver().findElement(By.xpath("//*[@id='select2-city_id-container']"));
        city.click();

        WebElement cityBox = Driver.getDriver().findElement(By.xpath("//*[@class='select2-search__field']"));
        cityBox.sendKeys(cityData);
        ReusableMethods.bekle(1);
        WebElement cityDataSelect = Driver.getDriver().findElement(By.xpath("//*[@class='select2-results__option select2-results__option--selectable select2-results__option--highlighted']"));
        cityDataSelect.click();
        ReusableMethods.bekle(1);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, 400);");
        ReusableMethods.bekle(1);

        WebElement type = Driver.getDriver().findElement(By.xpath("//*[@id='select2-select-type-container']"));
        type.click();
        ReusableMethods.bekle(1);
        ReusableMethods.popuptanSec(typeData);
        ReusableMethods.bekle(1);

        js.executeScript("window.scrollBy(0, 400);");

        WebElement min = Driver.getDriver().findElement(By.xpath("//*[@id='select2-minprice-container']"));
        min.click();
        ReusableMethods.bekle(1);
        ReusableMethods.popuptanSec(minData);
        ReusableMethods.bekle(1);

        js.executeScript("window.scrollBy(0, 200);");
        ReusableMethods.bekle(1);

        WebElement bedroom = Driver.getDriver().findElement(By.xpath("//*[@id='select2-select-bedroom-container']"));
        bedroom.click();
        ReusableMethods.bekle(1);
        ReusableMethods.popuptanSec(bedroomData);
        ReusableMethods.bekle(1);

        js.executeScript("window.scrollBy(0, 400);");
        ReusableMethods.bekle(1);

        WebElement fireplace = Driver.getDriver().findElement(By.xpath("(//*[@class='checkbox-custom-label'])[15]"));
        WebElement privateBalcony = Driver.getDriver().findElement(By.xpath("(//*[@class='checkbox-custom-label'])[19]"));

        fireplace.click();
        ReusableMethods.bekle(1);

        privateBalcony.click();
        ReusableMethods.bekle(1);

        js.executeScript("window.scrollBy(0, 1200);");
        ReusableMethods.bekle(1);

        WebElement findNewHomeButton = Driver.getDriver().findElement(By.xpath("//*[@class='btn btn btn-theme-light-2 rounded full-width mt-3']"));
        findNewHomeButton.click();
        ReusableMethods.bekle(1);

        js.executeScript("window.scrollBy(0, 200);");
        ReusableMethods.bekle(1);

        String actualLoc = userPages.ilanLocation.getText().toLowerCase();
        Assert.assertTrue(actualLoc.equals(locData.toLowerCase()));

        WebElement ilanBed = Driver.getDriver().findElement(By.xpath("(//*[@class='listing-card-info-icon'])[1]"));
        String ilanBedSayi = ilanBed.getText().toLowerCase();
        Assert.assertTrue(ilanBedSayi.contains(bedroomData));

        Driver.quitDriver();
    }
}
