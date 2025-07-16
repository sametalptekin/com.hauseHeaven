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





    }




