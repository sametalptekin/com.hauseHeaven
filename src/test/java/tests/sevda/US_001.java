package tests.sevda;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class US_001 {

    @Test
    public void TC_001 ()
    {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        ReusableMethods.bekle(2);
        userPages userPages=new userPages();

        Assert.assertTrue(Driver.getDriver().getTitle().toLowerCase().contains("home") || Driver.getDriver().getCurrentUrl().contains("hauseheaven"));

        Assert.assertTrue(userPages.signinButton.isDisplayed());

        Assert.assertTrue(userPages.signupButton.isDisplayed());

        Assert.assertTrue(userPages.homeButton.isDisplayed());

        Assert.assertTrue(userPages.projectsButton.isDisplayed());
        Assert.assertTrue(userPages.agentsButton.isDisplayed());

        Assert.assertTrue(userPages.blogButton.isDisplayed());
        Assert.assertTrue(userPages.contactButton.isDisplayed());
        Assert.assertTrue(userPages.listingButton.isDisplayed());
        Driver.quitDriver();

    }



    @Test
    public void TC_002() throws IOException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        userPages userPages = new userPages();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        userPages.AllowCookies.click();

        String citydata = "Newark";
        String minPricedata = "5000";
        String propertyTypedata = "Apartment";

// Min Price seçimi
        userPages.minPrice.click();
        ReusableMethods.popuptanSec(minPricedata);
        ReusableMethods.bekle(2);

// Property Type seçimi
        userPages.propertyType.click();
        ReusableMethods.popuptanSec(propertyTypedata);
        ReusableMethods.bekle(2);

// City dropdown elementinin görünür ve tıklanabilir olmasını sağla
        js.executeScript("arguments[0].scrollIntoView(true);", userPages.city);
        wait.until(ExpectedConditions.elementToBeClickable(userPages.city)).click();  // dropdown açıldı

// Şehir arama inputunu bekle ve şehir adını yaz
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='select2-search__field']")));
        searchInput.sendKeys(citydata);
        ReusableMethods.bekle(1);
        searchInput.sendKeys(Keys.ENTER);

        ReusableMethods.bekle(2);

// Search butonunu scroll yap ve tıkla
        js.executeScript("arguments[0].scrollIntoView(true);", userPages.SearchButton);
        wait.until(ExpectedConditions.elementToBeClickable(userPages.SearchButton)).click();  // Search tıklaması önemli!

// Yeni sayfanın yüklenmesini bekle (url'de /public/properties olduğunu doğrula)
        wait.until(ExpectedConditions.urlContains("/properties"));

// Sonuçların yüklenmesini bekle
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='listing-locate']")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='listing-card-info-price']")));

// Filtrelenmiş sonuçları tekrar al
        List<WebElement> locations = Driver.getDriver().findElements(By.xpath("//*[@class='listing-locate']"));
        List<WebElement> prices = Driver.getDriver().findElements(By.xpath("//*[@class='listing-card-info-price']"));

        int minPrice = Integer.parseInt(minPricedata);
        boolean filtreHatasiVar = false;

        for (int i = 0; i < locations.size(); i++) {
            String loc = locations.get(i).getText().toLowerCase();
            String priceText = prices.get(i).getText().toLowerCase();

            int price;
            if (priceText.contains("million")) {
                String numberPart = priceText.replaceAll("[^\\d]", "");
                price = numberPart.isEmpty() ? 0 : Integer.parseInt(numberPart) * 1_000_000;
            } else {
                price = Integer.parseInt(priceText.replaceAll("[^\\d]", ""));
            }

            System.out.println("İlan " + (i + 1) + ": Lokasyon = " + loc + ", Fiyat = " + price);
            System.out.println();

            if (!loc.contains(citydata.toLowerCase())) {
                System.err.println("!!! Uyarı: Beklenmeyen lokasyon bulundu: " + loc);
                System.out.println();
                filtreHatasiVar = true;
            }

            if (price < minPrice) {
                System.err.println("!!! Uyarı: Minimum fiyatın altında ilan bulundu: " + price);
                System.out.println();
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
    public void TC_003()
    {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userPages userPages = new userPages();
        userPages.AllowCookies.click();
        userPages.addPropertyButton.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
        ReusableMethods.bekle(2);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        Driver.getDriver().navigate().back();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


        js.executeScript("arguments[0].scrollIntoView(true);", userPages.Favori);
        ReusableMethods.bekle(1);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", userPages.Favori);


        wait.until(ExpectedConditions.elementToBeClickable(userPages.Favori));

        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", userPages.Favori);

        // 3. Beklenen: Login sayfasına yönlendirilmesi
        String currentUrl = Driver.getDriver().getCurrentUrl();
        boolean isRedirectedToLogin = currentUrl.contains("/login") || currentUrl.contains("/giris");

        // 4. Test sonucu
        Assert.assertTrue(isRedirectedToLogin, "Ziyaretçi login olmadan favori ekleyemez; login sayfasına yönlendirilmeliydi.");



        Driver.quitDriver();


    }




}
