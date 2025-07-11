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

    @FindBy(xpath = "//h3[contains(text(), 'Ego Dominus Tuus')]")
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

    @FindBy(xpath = "//*[@class='form-control ht-80']")
    public WebElement reviewWriteArea;
    @FindBy(xpath = "//div[@class='comment-text']/p")
    public WebElement commentText;
    @FindBy(xpath = "//h4[@class='author-name']")
    public WebElement authorName;
    @FindBy(xpath = "//div[@class='comment-date']")
    public WebElement commentDate;
    @FindBy(xpath = "//button[@class='btn btn-theme-light-2 rounded']")
    public WebElement reviewSubmitButton;
    @FindBy(xpath = "//a[@class='prt-view' and @href='https://qa.hauseheaven.com/properties/eryaman-kasmir-evleri']")
    public WebElement satilikDaire4button;
    @FindBy(xpath = "//input[@id='name']")
    public WebElement isimKutusu;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement telefonKutusu;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailKutusu;

    @FindBy(xpath = "//input[@name='subject']")
    public WebElement konuKutusu;

    @FindBy(xpath = "//textarea[@name='content']")
    public WebElement mesajAlani;

    @FindBy(xpath = "//textarea[@name='content']/ancestor::form//button[@type='submit']")
    public WebElement sendMessageButton;

    @FindBy(xpath = "//div[contains(@class, 'alert-success')]")
    public WebElement successMessageAlert;





    /*
       ------------------------- LOGIN -------------------------
    */

    @FindBy(xpath = "//*[@id='email']")
    public WebElement loginFormEmail;
    @FindBy(xpath = "//*[@id='password']")
    public WebElement loginFormPassword;
    @FindBy(xpath = "//*[@class='btn btn-md full-width btn-theme-light-2 rounded']")
    public WebElement loginButton;


    /*
       ------------------------- FOOTER -------------------------
     */

    // footer kısmındaki locate'lerimizi bu kısma ekleyelim.
}
