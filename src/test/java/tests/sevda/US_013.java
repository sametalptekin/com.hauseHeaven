package tests.sevda;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class US_013 {
    @Test
    public void TC_002()
    {
        Driver.getDriver().get(ConfigReader.getProperty("toLoginUrl"));
        userPages userPages = new userPages();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        userPages.AllowCookies.click();

// Login ol
        userPages.loginFormEmail.sendKeys("sevda123@test.com");
        userPages.loginFormPassword.sendKeys("Sevda123.");
        userPages.loginButton.click();
        userPages.DashboardUser.click();
        wait.until(ExpectedConditions.visibilityOf(userPages.logoutButtonUst));
        Assert.assertTrue(userPages.logoutButtonUst.isDisplayed(), "Logout butonu görünmüyor!");
        System.out.println("Login başarılı dashboard sayfasına gidildi");

//  Logout işlemi
        userPages.logoutButtonUst.click();
        wait.until(ExpectedConditions.urlContains("/public"));
        System.out.println("Logout başarılı, public sayfasına dönüldü");

//  Geri tuşuna bas (tarayıcı back)
        Driver.getDriver().navigate().back();

//  Beklenen: login/public sayfasında kalmalı, dashboard görünmemeli
        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("/login"),
                ExpectedConditions.urlContains("/public")
        ));

        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login") || currentUrl.contains("/public"),
                " Geri tuşuyla dashboard'a erişildi, oturum sonlanmamış!");

// Alternatif olarak dashboard'a ait logout butonunun görünmediğini kontrol edebilirsin
        boolean isLogoutVisible = false;
        try {
            isLogoutVisible = userPages.logoutButtonUst.isDisplayed();
        } catch (NoSuchElementException e) {
            // logout butonu yok, beklenen durum
        }
        Assert.assertFalse(isLogoutVisible, " Geri tuşuyla dashboard'a erişildi, logout butonu hala görünüyor!");

        System.out.println(" Oturum kapatıldıktan sonra geri tuşu ile dashboard'a erişilemedi.");

        Driver.quitDriver();





    }
    @Test
    public void TC_001()
    {

        // Site login sayfasına git
        Driver.getDriver().get(ConfigReader.getProperty("toLoginUrl"));

        userPages userPages = new userPages();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        userPages.AllowCookies.click();

        //  Email ve şifre girip login ol
        userPages.loginFormEmail.sendKeys("sevda123@test.com");
        userPages.loginFormPassword.sendKeys("Sevda123.");
        userPages.loginButton.click();

        //  Login anasayfasına yönlendirme bekle
        wait.until(ExpectedConditions.urlContains("/public"));

        //  URL kontrolü
        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/public"), " Başarılı login");
        userPages.logoutButtonUst.click();

        //  Login sayfasına tekrar git (logout yapmadan veya yeni sekme açarak)
        Driver.getDriver().get(ConfigReader.getProperty("toLoginUrl"));

        //  Remember me seçeneğinin görünür olduğundan emin ol
        Assert.assertTrue(userPages.rememberMeCheckbox.isDisplayed(), "Remember me seçeneği görünmüyor!");

        System.out.println("Login sayfasında Remember me seçeneği görüntülendi.");

        Driver.quitDriver();

    }

}
