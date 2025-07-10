package tests.samet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.userPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_018 {

    @Test
    public void TC_001(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        userPages userPages = new userPages();

        WebElement filterSearchBox = Driver.getDriver().findElement(By.xpath("//*[@class='hero-search-wrap']"));
        Assert.assertTrue(filterSearchBox.isDisplayed());
        ReusableMethods.bekle(1);

        userPages.locationInput.sendKeys("Denver");
        ReusableMethods.bekle(1);

        WebElement minPriceDdMenu = Driver.getDriver().findElement(By.xpath("//*[@id='select2-minprice-container']"));

        Select select = new Select(minPriceDdMenu);
        select.selectByValue("500");

        Select select1 = new Select(userPages.maxPrice);
        select1.selectByIndex(2);

        Select select2 = new Select(userPages.propertyType);
        select2.selectByIndex(0);

        Select select3 = new Select(userPages.bedRooms);
        select3.selectByIndex(0);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, 100);");
        ReusableMethods.bekle(1);

        userPages.filtreSubmit.click();

        String expectedResult = userPages.locationInput.getText();
        String actualResult = userPages.ilanLocation.getText();

        Assert.assertEquals(actualResult,expectedResult);
        Driver.quitDriver();
    }
}
