package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class userPages {

    public userPages(){
        PageFactory.initElements(utilities.Driver.getDriver(), this);
    }


    /*
       ------------------------- HEADER -------------------------
     */

    @FindBy(xpath = "//*[@class='add-listing']")
    public WebElement signinButton;

    @FindBy(xpath = "//a[normalize-space(text())='Listing']")
    public WebElement listingButton;





    /*
       ------------------------- BODY -------------------------

     */

    // body kısmındaki locate'lerimizi bu kısma ekleyelim.
    @FindBy(xpath = "//a[@class='prt-view']")
    public WebElement satilikDaire6button;

    @FindBy(xpath = "//h3[@class='prt-price-fix']")
    public WebElement satilikDaire6fiyat;

    @FindBy(xpath = "//h3[contains(text(), 'Satılık Daire')]")
    public WebElement getSatilikDaire6baslik;

    @FindBy(xpath = "//input[@placeholder='Search for a location']")
    public WebElement locationInput;

    @FindBy(xpath = "//span[@id='select2-minprice-container']")
    public WebElement minPrice;

    @FindBy(xpath ="//span[@id='select2-ptypes-container']")
    public WebElement propertyType;

    @FindBy(xpath = "//*[@class='btn search-btn']")
    public WebElement filtreSubmit;

    @FindBy(xpath = "//*[@class='btn btn-likes add-to-wishlist']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[contains(@class, 'alert-success')]")
    public WebElement saveAlert;







    /*
       ------------------------- FOOTER -------------------------
     */

    // footer kısmındaki locate'lerimizi bu kısma ekleyelim.
}
