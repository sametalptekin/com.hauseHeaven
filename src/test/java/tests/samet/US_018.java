package tests.samet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @Test
    public void TC_002(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userPages userPages = new userPages();

        WebElement howItWorks = Driver.getDriver().findElement(By.xpath("(//*[@class='sec-heading center'])[1]"));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", howItWorks);
        ReusableMethods.bekle(1);
        Assert.assertTrue(howItWorks.isDisplayed());

        WebElement  evaluateProperty = Driver.getDriver().findElement(By.xpath("(//*[@class='middle-icon-features-content'])[1]"));
        Assert.assertTrue(evaluateProperty.isDisplayed());

        WebElement  meetYourAgent = Driver.getDriver().findElement(By.xpath("(//*[@class='middle-icon-features-content'])[2]"));
        Assert.assertTrue(meetYourAgent.isDisplayed());

        WebElement  closeTheDeal = Driver.getDriver().findElement(By.xpath("(//*[@class='middle-icon-features-content'])[3]"));
        Assert.assertTrue(closeTheDeal.isDisplayed());

        Driver.quitDriver();
    }

    @Test
    public void TC_003(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userPages userPages = new userPages();

        WebElement exploreGoodPlaces = Driver.getDriver().findElement(By.xpath("(//*[@class='sec-heading center'])[2]"));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", exploreGoodPlaces);
        ReusableMethods.bekle(1);
        Assert.assertTrue(exploreGoodPlaces.isDisplayed());

        WebElement exploreGoodPlacesIlan = Driver.getDriver().findElement(By.xpath("(//*[@class='prt-link-detail'])[1]"));
        Assert.assertTrue(exploreGoodPlacesIlan.isDisplayed());
        ReusableMethods.bekle(1);

        js.executeScript("window.scrollBy(0, 750);");
        ReusableMethods.bekle(1);
        WebElement browseMoreButton = Driver.getDriver().findElement(By.xpath("(//*[@class='btn btn-theme-light-2 rounded'])[1]"));
        browseMoreButton.click();
        ReusableMethods.bekle(1);

        String expectedUrl = "https://qa.hauseheaven.com/properties";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        Driver.quitDriver();
    }

    @Test
    public void TC_004(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userPages userPages = new userPages();

        WebElement findByLocations = Driver.getDriver().findElement(By.xpath("(//*[@class='sec-heading center'])[3]"));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", findByLocations);
        ReusableMethods.bekle(1);
        Assert.assertTrue(findByLocations.isDisplayed());

        WebElement loc = Driver.getDriver().findElement(By.xpath("(//*[@class='lp-content-title'])[1]"));
        String locExpectedYazi = loc.getText().toLowerCase();

        js.executeScript("arguments[0].scrollIntoView(true);", loc);
        ReusableMethods.bekle(1);
        js.executeScript("window.scrollBy(0, -250);");
        ReusableMethods.bekle(1);
        Assert.assertTrue(loc.isDisplayed());

        WebElement locViewButton = Driver.getDriver().findElement(By.xpath("(//*[@class='lp-property-view'])[1]"));
        locViewButton.click();
        ReusableMethods.bekle(1);

        js.executeScript("window.scrollBy(0, 100);");
        ReusableMethods.bekle(1);
        WebElement locIlan = Driver.getDriver().findElement(By.xpath("//*[@class='listing-location']"));

        String locIlanActualYazi = locIlan.getText().toLowerCase();
        Assert.assertEquals(locIlanActualYazi,locExpectedYazi);

        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(1);

        WebElement browseByButton = Driver.getDriver().findElement(By.xpath("(//*[@class='btn btn-theme-light-2 rounded'])[2]"));
        js.executeScript("arguments[0].scrollIntoView(true);", browseByButton);
        ReusableMethods.bekle(1);
        js.executeScript("window.scrollBy(0, -400);");
        ReusableMethods.bekle(1);
        browseByButton.click();

        String expectedUrl = "https://qa.hauseheaven.com/properties";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        Driver.quitDriver();

    }

    @Test
    public void TC_005() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userPages userPages = new userPages();

        WebElement goodReviews = Driver.getDriver().findElement(By.xpath("(//*[@class='sec-heading center'])[4]"));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", goodReviews);
        ReusableMethods.bekle(1);
        Assert.assertTrue(goodReviews.isDisplayed());

        js.executeScript("window.scrollBy(0, 250);");
        ReusableMethods.bekle(1);

        WebElement slickList = Driver.getDriver().findElement(By.xpath("(//*[@class='slick-list draggable'])[7]"));
        Assert.assertTrue(slickList.isDisplayed());

        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(slickList).moveByOffset(-300,0).release().perform();

        Driver.quitDriver();
    }

    @Test
    public void TC_006() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userPages userPages = new userPages();

        userPages.signInButton.click();

        userPages.loginFormEmail.sendKeys(ConfigReader.getProperty("user"));
        userPages.loginFormPassword.sendKeys(ConfigReader.getProperty("user_pass"));
        userPages.loginButton.click();

        WebElement seeOurPackages = Driver.getDriver().findElement(By.xpath("(//*[@class='sec-heading center'])[5]"));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", seeOurPackages);
        ReusableMethods.bekle(1);
        Assert.assertTrue(seeOurPackages.isDisplayed());

        WebElement choosePlanButton = Driver.getDriver().findElement(By.xpath("(//*[@class='btn-pricing'])[2]"));
        js.executeScript("arguments[0].scrollIntoView(false);", choosePlanButton);
        ReusableMethods.bekle(1);
        js.executeScript("window.scrollBy(0, 250);");
        ReusableMethods.bekle(1);

        choosePlanButton.click();
        ReusableMethods.bekle(1);

        String expectedUrl = "https://qa.hauseheaven.com/account/packages/2/subscribe";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        Driver.quitDriver();
    }

    @Test
    public void TC_007() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userPages userPages = new userPages();

        WebElement ilkIlan = Driver.getDriver().findElement(By.xpath("(//*[@class='prt-link-detail'])[1]"));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", ilkIlan);
        ReusableMethods.bekle(1);
        js.executeScript("window.scrollBy(0, 200);");
        ReusableMethods.bekle(1);
        ilkIlan.click();
        String ilkIlanUrl = Driver.getDriver().getCurrentUrl();

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(1);

        WebElement recentlyViewed = Driver.getDriver().findElement(By.xpath("(//*[@class='sec-heading center'])[6]"));
        js.executeScript("arguments[0].scrollIntoView(false);", recentlyViewed);
        ReusableMethods.bekle(1);
        Assert.assertTrue(recentlyViewed.isDisplayed());

        js.executeScript("window.scrollBy(0, 400);");
        ReusableMethods.bekle(1);

        WebElement sonIlan = Driver.getDriver().findElement(By.xpath("(//*[@class='prt-link-detail'])[7]"));
        sonIlan.click();

        String sonIlanUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(sonIlanUrl,ilkIlanUrl);
        Driver.quitDriver();
    }

}


