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

    @FindBy(xpath = "//h3[text()='Satılık Daire']")
    public WebElement getSatilikDaire6baslik;







    /*
       ------------------------- FOOTER -------------------------
     */

    // footer kısmındaki locate'lerimizi bu kısma ekleyelim.
}
