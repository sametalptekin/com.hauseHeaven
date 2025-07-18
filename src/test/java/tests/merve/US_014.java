package tests.merve;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;



public class US_014 {

    @Test
    public void loginTesti(){

        // 1- "https://qa.househeaven.com/" adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // 2- house heaven anasayfaya gittiğini dogrulayın

        SoftAssert softAssert = new SoftAssert();

        String expectedUrl = ConfigReader.getProperty("toUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,"url expected url'den farklı");

        // 3- sign in butonuna basın

        userPages userPages = new userPages();
        PageFactory.initElements(Driver.getDriver(), userPages);
        userPages.signInButton.click();

        ReusableMethods.bekle(2);
        // 4- username Kutusuna "username" yazın

        userPages.userNameKutusu.sendKeys(ConfigReader.getProperty("toUser"));

        ReusableMethods.bekle(2);
        // 5- password kutusuna "şifre" girin

        userPages.passwordKutusu.sendKeys(ConfigReader.getProperty("userPass"));

        ReusableMethods.bekle(2);
        //  6- login butonuna tıkla
        userPages.loginButonu.click();
        ReusableMethods.bekle(2);




        softAssert.assertAll();

        Driver.quitDriver();




    }

    @Test
    public void ilanEklemeTesti() throws InterruptedException , IOException {
        // 1- "https://qa.househeaven.com/" adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // 2- house heaven anasayfaya gittiğini dogrulayın

        SoftAssert softAssert = new SoftAssert();

        String expectedUrl = ConfigReader.getProperty("toUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,"url expected url'den farklı");

        // 3- sign in butonuna basın

        userPages userPages = new userPages();
        PageFactory.initElements(Driver.getDriver(), userPages);
        userPages.signinButton.click();

        ReusableMethods.bekle(2);
        // 4- username Kutusuna "username" yazın

        userPages.userNameKutusu.sendKeys(ConfigReader.getProperty("toUser"));

        ReusableMethods.bekle(2);
        // 5- password kutusuna "şifre" girin

        userPages.passwordKutusu.sendKeys(ConfigReader.getProperty("userPass"));

        ReusableMethods.bekle(2);
        //  6- login butonuna tıkla
        userPages.loginButonu.click();
        ReusableMethods.bekle(2);

        // 7- ilan ekleme butonuna tıklama

        userPages.addPropertyButonu.click();

        ReusableMethods.bekle(2);
        // 8- ilan formu title doldurma

        userPages.ilanFormTitle.sendKeys(ConfigReader.getProperty("ilanTitle"));
        ReusableMethods.bekle(2);

        // 9 - ilan formu Description doldurma
        userPages.ilanFormDescription.sendKeys(ConfigReader.getProperty("description"));
        ReusableMethods.bekle(2);

        // 10 - fiyat- konum vs gibi detaylı alanların doldurulması

        userPages.ilanFormContent.sendKeys(ConfigReader.getProperty("content"));
        ReusableMethods.bekle(2);

//        userPages.ilanFormGorselButonu.click();
//        ReusableMethods.bekle(1);
//        userPages.ilanFormGorselButonu.sendKeys("C:\\Users\\Venus\\Desktop\\ilanGorsel\\resim1.jpg");
//        ReusableMethods.bekle(2);

        // Görselin yolu
        File file = new File("C:\\Users\\Venus\\Desktop\\ilanGorsel\\resim1.jpg");

        // Görseli base64 string'e çevir
        String base64Image = Base64.getEncoder().encodeToString(Files.readAllBytes(file.toPath()));

        // JavaScript ile Dropzone'a simüle dosya yükleme
        String script = "var dropzone = Dropzone.forElement('#multiple-upload');" +
                "var base64 = '" + base64Image + "';" +
                "var blob = fetch('data:image/jpeg;base64,' + base64).then(res => res.blob()).then(blob => {" +
                "   var file = new File([blob], 'image.jpg', { type: 'image/jpeg' });" +
                "   dropzone.addFile(file);" +
                "});";


        ((JavascriptExecutor) Driver.getDriver()).executeScript(script);

        Thread.sleep(3000);  // dosyanın yüklenmesini beklemek için

        userPages.ilanFormPublicLocation.sendKeys(ConfigReader.getProperty("publicLocation"));
        ReusableMethods.bekle(2);

        userPages.ilanFormBedrooms.sendKeys(ConfigReader.getProperty("bedrooms"));
        ReusableMethods.bekle(2);

        userPages.ilanFormBathroom.sendKeys(ConfigReader.getProperty("bathroom"));
        ReusableMethods.bekle(2);

        userPages.ilanFormFloors.sendKeys(ConfigReader.getProperty("floors"));
        ReusableMethods.bekle(2);

        userPages.ilanFormSquare.sendKeys(ConfigReader.getProperty("square"));
        ReusableMethods.bekle(2);

        userPages.ilanFormPrice.sendKeys(ConfigReader.getProperty("price"));
        ReusableMethods.bekle(2);

        userPages.ilanFormFacilities.sendKeys(ConfigReader.getProperty("facilities"));
        ReusableMethods.bekle(2);

        userPages.ilanFormDistance.sendKeys(ConfigReader.getProperty("distance"));
        ReusableMethods.bekle(2);

        userPages.ilanFormWifiButonu.click();
        ReusableMethods.bekle(2);

        userPages.ilanFormGardenButonu.click();
        ReusableMethods.bekle(2);




        userPages.ilanFormCategoryButonu.click();
        userPages.CategoryButonu.sendKeys(ConfigReader.getProperty("categoriButonu"));
        ReusableMethods.bekle(2);

        userPages.CategoryButonu.sendKeys(Keys.ENTER);
        ReusableMethods.bekle(1);

        userPages.ilanSaveAndExitButonu.click();
        ReusableMethods.bekle(2);





















        softAssert.assertAll();

        Driver.quitDriver();


    }

}
