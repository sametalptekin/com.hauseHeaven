package tests.demo;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.adminPages;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;

public class US_001_demo {

    @Test
    public void TC001() {

            // 1- "https://qa.househeaven.com/" adresine gidin
            Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

            // 2- house heaven anasayfaya gittiğini dogrulayın

            SoftAssert softAssert = new SoftAssert();

            String expectedUrl = ConfigReader.getProperty("toUrl");
            String actualUrl = Driver.getDriver().getCurrentUrl();

            softAssert.assertEquals(actualUrl, expectedUrl, "url expected url'den farklı");

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
        public void TC002() throws InterruptedException, IOException {

            // 1- "https://qa.househeaven.com/" adresine gidin
            Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

            // 2- house heaven anasayfaya gittiğini dogrulayın

            SoftAssert softAssert = new SoftAssert();

            String expectedUrl = ConfigReader.getProperty("toUrl");
            String actualUrl = Driver.getDriver().getCurrentUrl();

            softAssert.assertEquals(actualUrl, expectedUrl, "url expected url'den farklı");

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

            // 7- ilan ekleme butonuna tıklama

            userPages.addPropertyButonu.click();

            ReusableMethods.bekle(2);
            // 8- ilan formu title doldurma

            userPages.ilanFormTitle.sendKeys(ConfigReader.getProperty("ilanTitle"));
            ReusableMethods.bekle(2);

            // 9 - ilan formu Description doldurma
            userPages.ilanFormDescription.sendKeys(ConfigReader.getProperty("description"));
            ReusableMethods.bekle(2);

            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("window.scrollBy(0, 180);");
            ReusableMethods.bekle(1);

            // 10 - fiyat- konum vs gibi detaylı alanların doldurulması

            userPages.ilanFormContent.sendKeys(ConfigReader.getProperty("content"));
            ReusableMethods.bekle(2);
            JavascriptExecutor js9 = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("window.scrollBy(0, 200);");
            ReusableMethods.bekle(1);

//        userPages.ilanFormGorselButonu.click();
//        ReusableMethods.bekle(1);
//        userPages.ilanFormGorselButonu.sendKeys("C:\\Users\\Venus\\Desktop\\ilanGorsel\\resim1.jpg");
//        ReusableMethods.bekle(2);

            WebElement imagesBox = Driver.getDriver().findElement(By.xpath("//*[@class='dropzone needsclick dz-clickable']"));
            JavascriptExecutor js1 = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", imagesBox);
            js.executeScript("window.scrollBy(0, 200);");
            ReusableMethods.bekle(1);

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

            WebElement locationBox = Driver.getDriver().findElement(By.xpath("//input[@name='location' and @placeholder='Property location']"));
            JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", locationBox);
            js.executeScript("window.scrollBy(0, 200);");
            ReusableMethods.bekle(1);

            userPages.ilanFormCity.click();
            ReusableMethods.bekle(1);

            userPages.ilanFormCityKutusu.sendKeys(ConfigReader.getProperty("ilanCity"));
            userPages.ilanFormCityKutusu.sendKeys(Keys.ENTER);


            userPages.ilanFormPublicLocation.sendKeys(ConfigReader.getProperty("publicLocation"));
            ReusableMethods.bekle(2);

            WebElement bathroomBox = Driver.getDriver().findElement(By.xpath("//*[@name=\"number_bathroom\"]"));
            JavascriptExecutor js6 = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", bathroomBox);
            js.executeScript("window.scrollBy(0, 250);");
            ReusableMethods.bekle(1);

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

            WebElement facilitiesBox = Driver.getDriver().findElement(By.xpath("//select[@name='facilities[][id]']"));
            JavascriptExecutor js3 = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", facilitiesBox);
            js.executeScript("window.scrollBy(0, 200);");
            ReusableMethods.bekle(1);


            userPages.ilanFormFacilities.sendKeys(ConfigReader.getProperty("facilities"));
            ReusableMethods.bekle(2);



            userPages.ilanFormDistance.sendKeys(ConfigReader.getProperty("distance"));
            ReusableMethods.bekle(2);

            WebElement wifigardenBox = Driver.getDriver().findElement(By.xpath("//input[@name='features[]' and @value='5']"));
            JavascriptExecutor js4 = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", wifigardenBox);
            js.executeScript("window.scrollBy(0, 350);");
            ReusableMethods.bekle(1);


            ReusableMethods.bekle(1);
            userPages.ilanFormWifiButonu.click();
            ReusableMethods.bekle(2);

            userPages.ilanFormGardenButonu.click();
            ReusableMethods.bekle(2);

            JavascriptExecutor js5 = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("window.scrollTo(0, 0);");
            ReusableMethods.bekle(1);


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

    @Test
    public void TC003(){
        Driver.getDriver().get(ConfigReader.getProperty("toAdminUrl"));
        ReusableMethods.bekle(2);

        SoftAssert softAssert = new SoftAssert();

        String expectedUrl = ConfigReader.getProperty("toAdminUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "url, expected url'den farklı");

        adminPages adminPages = new adminPages();
        PageFactory.initElements(Driver.getDriver(), adminPages);
        ReusableMethods.bekle(2);

        adminPages.loginFormEmail.sendKeys(ConfigReader.getProperty("toAdmin"));
        ReusableMethods.bekle(2);

        adminPages.loginFormPassword.sendKeys(ConfigReader.getProperty("adminPass"));
        ReusableMethods.bekle(2);

        adminPages.loginButton.click();
        ReusableMethods.bekle(3);

        adminPages.pendingPropertiesButonu.click();
        ReusableMethods.bekle(1);

        adminPages.adminIlanButonu.click();
        ReusableMethods.bekle(1);

        adminPages.ilanGorunurYapmaButonu.click();
        ReusableMethods.bekle(1);

        Actions actions = new Actions(Driver.getDriver());
        actions
                .sendKeys(Keys.ARROW_DOWN) // Bir alt seçeneğe iner
                .sendKeys(Keys.ENTER)      // Seçimi onaylar
                .build()
                .perform();


        adminPages.adminSaveExitButonu.click();
        ReusableMethods.bekle(1);

        softAssert.assertAll();
        Driver.quitDriver();


    }

    @Test
    public void TC_004() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userPages userPages = new userPages();

//        // 3- sign in butonuna basın
//
//        PageFactory.initElements(Driver.getDriver(), userPages);
//        userPages.signInButton.click();
//
//        ReusableMethods.bekle(2);
//        // 4- username Kutusuna "username" yazın
//
//        userPages.userNameKutusu.sendKeys(ConfigReader.getProperty("toUser"));
//
//        ReusableMethods.bekle(2);
//        // 5- password kutusuna "şifre" girin
//
//        userPages.passwordKutusu.sendKeys(ConfigReader.getProperty("userPass"));
//
//        ReusableMethods.bekle(2);
//        //  6- login butonuna tıkla
//        userPages.loginButonu.click();
//        ReusableMethods.bekle(2);

        String locationData = "Denver";
        String minPriceData = "500";
        String maxPriceData = "50000";



        userPages.locationInput.sendKeys(locationData);
        ReusableMethods.bekle(1);
        userPages.minPrice.click();
        ReusableMethods.popuptanSec(minPriceData);
        ReusableMethods.bekle(1);
        userPages.maxPrice.click();
        ReusableMethods.popuptanSec(maxPriceData);
        ReusableMethods.bekle(1);



//        Actions actions = new Actions(Driver.getDriver());
//        actions
//                .sendKeys(Keys.ARROW_DOWN) // Bir alt seçeneğe iner
//                .sendKeys(Keys.ENTER)      // Seçimi onaylar
//                .build()
//                .perform();



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








}











