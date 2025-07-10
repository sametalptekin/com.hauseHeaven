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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

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
    @Test
    public void TC_002(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userPages userPages = new userPages();
        userPages.signinButton.click();
        userPages.loginFormEmail.sendKeys(ConfigReader.getProperty("user"));
        userPages.loginFormPassword.sendKeys(ConfigReader.getProperty("user_pass"));
        userPages.loginButton.click();

        userPages.listingButton.click();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", userPages.satilikDaire4button);
        ReusableMethods.bekle(2);
        userPages.satilikDaire4button.click();
        ReusableMethods.waitForVisibility(userPages.reviewWriteArea, 10);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", userPages.reviewSubmitButton);
        ReusableMethods.bekle(5);
        userPages.reviewWriteArea.click();
        userPages.reviewWriteArea.sendKeys("Mükemmel Bir İlan");
        userPages.reviewSubmitButton.click();


        ReusableMethods.waitForPageToLoad(5);
        String expectedComment = "Mükemmel Bir İlan";
        String expectedAuthor = "Team2 Test";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM, yyyy", Locale.ENGLISH);
        String expectedDate = LocalDate.now().format(formatter).toLowerCase();

        String actualComment = userPages.commentText.getText().trim();
        String actualAuthor = userPages.authorName.getText().replace("\"", "").trim(); // çift tırnakları sil
        String actualDate = userPages.commentDate.getText().replace("\"", "").trim().toLowerCase();

        if (actualComment.equals(expectedComment) && actualAuthor.equals(expectedAuthor) && actualDate.equals(expectedDate)) {
            System.out.println("Yorum başarılı şekilde eklendi!");
        } else {
            System.err.println("Yorum doğrulaması başarısız!");

            if (!actualComment.equals(expectedComment)) {
                System.err.println("Beklenen yorum: " + expectedComment + " | Gerçek: " + actualComment);
            }

            if (!actualAuthor.equals(expectedAuthor)) {
                System.err.println("Beklenen yazar: " + expectedAuthor + " | Gerçek: " + actualAuthor);
            }

            if (!actualDate.equals(expectedDate)) {
                System.err.println("Beklenen tarih: " + expectedDate + " | Gerçek: " + actualDate);
            }
        }

    }
    @AfterTest
    public void tearDown() {
        Driver.quitDriver();
    }

}
