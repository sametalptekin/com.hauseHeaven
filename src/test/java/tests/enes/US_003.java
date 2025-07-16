package tests.enes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class US_003{

    @Test
    public void TC_001() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


        long lastHeight = (long) js.executeScript("return document.body.scrollHeight");
        while (true) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(1000);
            long newHeight = (long) js.executeScript("return document.body.scrollHeight");
            if (newHeight == lastHeight) {
                break;
            }
            lastHeight = newHeight;
        }

        List<WebElement> images = Driver.getDriver().findElements(By.xpath("//img"));

        SoftAssert softAssert = new SoftAssert();
        System.out.println("Toplam görsel sayısı: " + images.size());

        for (WebElement img : images) {
            boolean isLoaded = (Boolean) js.executeScript(
                    "return arguments[0].complete && arguments[0].naturalWidth > 0", img
            );
            softAssert.assertTrue(isLoaded, "Bozuk görsel bulundu: " + img.getAttribute("src"));
        }

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test
    public void TC_002(){

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        SoftAssert softAssert= new SoftAssert();

        userPages userpages =new userPages();

        try {
            userpages.filtreSubmit.click();
            softAssert.assertTrue(true);
        }catch (Exception e){
            softAssert.fail();
        }

        try {
            userpages.browseMorePropertiesButonu.click();
            softAssert.assertTrue(true);
        }catch (Exception e){
            softAssert.fail();
        }
        try {
            userpages.browseMoreLocationsButonu.click();
            softAssert.assertTrue(true);
        }catch (Exception e){
            softAssert.fail();
        }
        softAssert.assertAll();

        Driver.quitDriver();
    }
    @Test
    public void TC_003() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        Driver.getDriver().manage().deleteAllCookies();

        SoftAssert softAssert=new SoftAssert();

        userPages userPages=new userPages();
        ReusableMethods.bekle(2);


        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        System.out.println(Driver.getDriver().getCurrentUrl());

        userPages.filtreSubmit.click();
        String expectedResult = "https://qa.hauseheaven.com/public/";
        String actualResult = Driver.getDriver().getCurrentUrl();
        System.out.println(Driver.getDriver().getCurrentUrl());

        softAssert.assertTrue(actualResult.contains(expectedResult),"hata");
        ReusableMethods.bekle(2);
        userPages.logoButton.click();
        ReusableMethods.bekle(2);
        for (int i = 0; i < 4; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(500);
        }


        userPages.browseMorePropertiesButonu.click();
        String expectedPropertiesResult = "https://qa.hauseheaven.com/public/";
        String actualPropertiesResult = Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualPropertiesResult.contains(expectedPropertiesResult),"hata1");

        ReusableMethods.bekle(2);
        userPages.homeButton.click();
        ReusableMethods.bekle(2);
        for (int i = 0; i < 7; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(500);
        }

        userPages.browseMoreLocationsButonu.click();
        String expectedLocationResult = "https://qa.hauseheaven.com/public/";
        String actualLocationResult = Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualLocationResult.contains(expectedLocationResult),"hata2");


        softAssert.assertAll();
        Driver.quitDriver();

    }
    @Test
    public void TC_004(){

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        userPages userPages = new userPages();

        SoftAssert softAssert=new SoftAssert();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ReusableMethods.bekle(1);

        userPages.aboutUsLinki.click();
        softAssert.assertTrue(userPages.aboutUsYazisi.isDisplayed());
        ReusableMethods.bekle(1);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        userPages.contactButton.click();
        softAssert.assertTrue(userPages.contactPageContactYazisi.isDisplayed());
        ReusableMethods.bekle(1);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ReusableMethods.bekle(1);
        userPages.termsAndConditionsLinki.click();
        softAssert.assertTrue(userPages.termsandconditionsYazisi.isDisplayed());
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ReusableMethods.bekle(1);

        userPages.allPropertiesLinki.click();

        softAssert.assertTrue(userPages.forSaleButonu.isDisplayed());
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ReusableMethods.bekle(2);
        userPages.housesForSaleLinki.click();
        softAssert.assertTrue(userPages.forSaleButonu.isDisplayed());
        ReusableMethods.bekle(1);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        ReusableMethods.bekle(1);
        userPages.housesForRentLinki.click();
        softAssert.assertTrue(userPages.forRentButonu.isDisplayed());

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ReusableMethods.bekle(2);

        String link1 = userPages.birinciNewsLinki.getAttribute("href");
        int status1 = ReusableMethods.getHttpResponseCode(link1);
        System.out.println("Birinci link HTTP durumu: " + status1);
        softAssert.assertTrue(status1 < 400, "Birinci news link kırık: HTTP " + status1);

        String link2 = userPages.ikinciNewsLinki.getAttribute("href");
        int status2 = ReusableMethods.getHttpResponseCode(link2);
        System.out.println("İkinci link HTTP durumu: " + status2);
        softAssert.assertTrue(status2 < 400, "İkinci news link kırık: HTTP " + status2);

        String link3 = userPages.ucuncuNewsLinki.getAttribute("href");
        int status3 = ReusableMethods.getHttpResponseCode(link3);
        System.out.println("Üçüncü link HTTP durumu: " + status3);
        softAssert.assertTrue(status3 < 400, "Üçüncü news link kırık: HTTP " + status3);

        String link4 = userPages.dorduncuNewsLinki.getAttribute("href");
        int status4 = ReusableMethods.getHttpResponseCode(link4);
        System.out.println("Dorduncu link HTTP durumu: " + status4);
        softAssert.assertTrue(status4 < 400, "İkinci news link kırık: HTTP " + status4);

        String link5 = userPages.besinciNewsLinki.getAttribute("href");
        int status5 = ReusableMethods.getHttpResponseCode(link5);
        System.out.println("Besinci link HTTP durumu: " + status5);
        softAssert.assertTrue(status5 < 400, "Üçüncü news link kırık: HTTP " + status5);

        softAssert.assertAll();

        Driver.quitDriver();
    }








}




