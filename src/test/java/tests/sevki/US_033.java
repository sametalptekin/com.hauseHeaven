package tests.sevki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class US_033 {


    @Test
    public void TC_001() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(2);
        adminPages adminPages = new adminPages();


        adminPages.loginFormEmail.sendKeys(ConfigReader.getProperty("admin"));
        adminPages.loginFormPassword.sendKeys(ConfigReader.getProperty("admin_pass"));
        adminPages.loginButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(adminPages.testimonialsMenu));
        adminPages.testimonialsMenu.click();

        ReusableMethods.bekle(2);
        Assert.assertTrue(adminPages.testimonialsMenu.isDisplayed());
        Driver.quitDriver();

    }
    @Test
    public void TC_002() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(2);
        adminPages adminPages = new adminPages();


        adminPages.loginFormEmail.sendKeys(ConfigReader.getProperty("admin"));
        adminPages.loginFormPassword.sendKeys(ConfigReader.getProperty("admin_pass"));
        adminPages.loginButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(adminPages.testimonialsMenu));
        adminPages.testimonialsMenu.click();


        List<WebElement> rows = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table//tbody/tr")));
        assert rows.size() > 0;
        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }

    @Test
    public void TC_003() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(2);
        adminPages adminPages = new adminPages();


        adminPages.loginFormEmail.sendKeys(ConfigReader.getProperty("admin"));
        adminPages.loginFormPassword.sendKeys(ConfigReader.getProperty("admin_pass"));
        adminPages.loginButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(adminPages.testimonialsMenu));
        adminPages.testimonialsMenu.click();

        adminPages.createButton.click();
        ReusableMethods.bekle(2);
        adminPages.nameBox.sendKeys(ConfigReader.getProperty("name"));
        ReusableMethods.bekle(2);
        adminPages.positionBox.sendKeys(ConfigReader.getProperty("position"));
        ReusableMethods.bekle(2);
        adminPages.textbox.sendKeys(ConfigReader.getProperty("textbox"));
        ReusableMethods.bekle(2);
        adminPages.saveButton.click();


        Assert.assertTrue(adminPages.testimonialsMenu.isDisplayed());
        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }


    @Test
    public void TC_004() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(2);
        adminPages adminPages = new adminPages();


        adminPages.loginFormEmail.sendKeys(ConfigReader.getProperty("admin"));
        adminPages.loginFormPassword.sendKeys(ConfigReader.getProperty("admin_pass"));
        adminPages.loginButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(adminPages.testimonialsMenu));
        adminPages.testimonialsMenu.click();
        adminPages.deleteButton.click();
        ReusableMethods.bekle(2);

        adminPages.alertMsg.click();
        Assert.assertTrue(adminPages.successfully.isDisplayed());

        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }


}

































