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

public class US_007 {
    @Test
    public void TC_001(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(3);
        userPages userPages = new userPages();
        userPages.listingButton.click();
        ReusableMethods.bekle(3);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", userPages.satilikDaire6button);
        ReusableMethods.bekle(2);
        userPages.satilikDaire6button.click();
        ReusableMethods.bekle(3);
        userPages.saveButton.click();
        String expectedMessage1 = "Added to wishlist successfully!";
        String actualMessage1 = userPages.saveAlert.getText();
        if(expectedMessage1.equals(actualMessage1)){
            System.out.println("Save Etme Başarılı!");
        } else{
            Assert.fail("Save edilemedi");
        }
        ReusableMethods.bekle(6);
        userPages.saveButton.click();
        String expectedMessage2 = "Removed from wishlist successfully!";
        String actualMessage2 = userPages.saveAlert.getText();
        if(expectedMessage2.equals(actualMessage2)){
            System.out.println("Save silme Başarılı!");
        } else{
            Assert.fail("Save silinemedi");
        }


    }

    @AfterTest
    public void tearDown() {
        Driver.quitDriver();
    }

}
