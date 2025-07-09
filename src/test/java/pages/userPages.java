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




    /*
       ------------------------- FOOTER -------------------------
     */

    // footer kısmındaki locate'lerimizi bu kısma ekleyelim.
}
