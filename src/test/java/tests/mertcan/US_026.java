package tests.mertcan;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_026 {

    @Test
    public void TC_001(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(2);
        userPages userPages=new userPages();

        userPages.signinButton.click();

        userPages.loginFormEmail.sendKeys(ConfigReader.getProperty("user"));
        userPages.loginFormPassword.sendKeys(ConfigReader.getProperty("user_pass"));
        userPages.loginButton.click();

        ReusableMethods.bekle(2);
        Assert.assertTrue(userPages.logoutButton.isDisplayed());
        Driver.quitDriver();
    }

    @Test
    public void TC_002(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(2);
        userPages userPages=new userPages();

        userPages.signinButton.click();

        userPages.loginFormEmail.sendKeys(ConfigReader.getProperty("user"));
        userPages.loginFormPassword.sendKeys(ConfigReader.getProperty("user_pass"));
        userPages.loginButton.click();

        ReusableMethods.bekle(2);
        Assert.assertTrue(userPages.logoutButton.isDisplayed());

        userPages.contactButton.click();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, 200);");
        ReusableMethods.bekle(1);

        Assert.assertTrue(userPages.contactInfo.isDisplayed());
        Driver.quitDriver();

    }

    Faker faker = new Faker();

    @Test
    public void TC_003(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(2);
        userPages userPages=new userPages();

        userPages.signinButton.click();

        userPages.loginFormEmail.sendKeys(ConfigReader.getProperty("user"));
        userPages.loginFormPassword.sendKeys(ConfigReader.getProperty("user_pass"));
        userPages.loginButton.click();

        ReusableMethods.bekle(2);
        Assert.assertTrue(userPages.logoutButton.isDisplayed());

        userPages.contactButton.click();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, 200);");
        ReusableMethods.bekle(1);


        userPages.contactName.sendKeys(faker.name().name());
        userPages.contactEmail.sendKeys(faker.internet().emailAddress());
        userPages.contactSubject.sendKeys(faker.superhero().name());
        userPages.contactPhone.sendKeys(faker.phoneNumber().phoneNumber());
        userPages.contactMessage.sendKeys(faker.lorem().sentence());
        userPages.sendMessageBttn.click();

        ReusableMethods.bekle(8);
        Assert.assertTrue(userPages.sendMessageSuccess.isDisplayed());

        ReusableMethods.bekle(1);
        Driver.quitDriver();
    }


    @Test
    public void TC_004() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(2);
        userPages userPages = new userPages();

        userPages.signinButton.click();

        userPages.loginFormEmail.sendKeys(ConfigReader.getProperty("user"));
        userPages.loginFormPassword.sendKeys(ConfigReader.getProperty("user_pass"));
        userPages.loginButton.click();

        ReusableMethods.bekle(2);
        Assert.assertTrue(userPages.logoutButton.isDisplayed());

        userPages.contactButton.click();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, 180);");
        ReusableMethods.bekle(1);

        WebDriver driver = Driver.getDriver(); // Eğer yukarıda varsa tekrar yazmana gerek yok

        String fullText = userPages.reachUsElement.getText();
        String adres = fullText.split("\n")[1].trim();

        js.executeScript("window.scrollBy(0, 300);");
        ReusableMethods.bekle(3);

        // Harita üzerindeki adres

        String mapAdress = userPages.mapAddressElement.getText().trim();

        Assert.assertTrue(mapAdress.contains(adres));
        ReusableMethods.bekle(1);
        Driver.quitDriver();
    }
}
