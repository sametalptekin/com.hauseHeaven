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

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class US_008 {

    @Test
    public void TC_001() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userPages userPages = new userPages();
        userPages.projectsButton.click();
        int expectedSayiResult = 9;
        List<WebElement> projectList = Driver.getDriver().findElements(By.xpath("//*[@data-slick-index='4']"));
        int actualSayiResult = projectList.size();
        if(actualSayiResult == expectedSayiResult){
            System.out.println("Proje Sayısı aynı"+ "\nBeklenen:" + expectedSayiResult + "\nGerçek:" + actualSayiResult);
        }else {
            System.err.println("Proje sayıları uyumsuz!"+ "\nBeklenen proje sayısı: " + expectedSayiResult + "\nama bulunan: " + actualSayiResult );
            Assert.fail("Proje sayısı beklenenden farklı!");
        }
    }
    @Test
    public void TC_002(){
        Driver.getDriver().get(ConfigReader.getProperty("househeavenprojects.url"));
        userPages userPages = new userPages();
        ReusableMethods.waitForPageToLoad(5);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", userPages.coastalHarmonyEstates);
        String expectedIlanTipi = "Selling";
        String expectedBaslik = "Coastal Harmony Estates";
        String expectedKonum = "9012 Riverview Lane, Sedona, AZ";
        String expectedFiyat = "$1.5million - $2million";

        // İlan tipi doğrulama
        String actualIlanTipi = userPages.coastalHarmonyEstatesilanTipi.getText().trim();
        Assert.assertEquals(actualIlanTipi, expectedIlanTipi, "İlan tipi eşleşmiyor!");

        String actualBaslik = userPages.coastalHarmonyEstatesbaslik.getText().replace("\"", "").trim();
        Assert.assertEquals(actualBaslik, expectedBaslik, "Başlık eşleşmiyor!");

        // Konum doğrulama
        String actualKonum = userPages.coastalHarmonyEstateskonum.getText().replace("\"", "").trim();
        Assert.assertTrue(actualKonum.contains(expectedKonum), "Konum bilgisi eşleşmiyor!");

        // Fiyat doğrulama
        String actualFiyat = userPages.coastalHarmonyEstatesfiyat.getText().replace("\"", "").trim();
        Assert.assertTrue(actualFiyat.contains(expectedFiyat), "Fiyat bilgisi eşleşmiyor!");

    }

    @AfterTest
    public void tearDown() {
        Driver.quitDriver();
    }
}
