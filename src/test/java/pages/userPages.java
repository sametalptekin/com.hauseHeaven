package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;


public class userPages {

    public static WebElement logoutButton;
    public HTMLInputElement listingButton;
    public Alert loginFormEmail;
    public Alert loginFormPassword;

    public void userPages(){
        PageFactory.initElements(utilities.Driver.getDriver(), this);
    }


    /*
       ------------------------- HEADER -------------------------
     */

    @FindBy(xpath = "//*[@class='add-listing']")
    public static WebElement signinButton;



    /*
       ------------------------- BODY -------------------------

     */

    // body kısmındaki locate'lerimizi bu kısma ekleyelim.




    /*
       ------------------------- FOOTER -------------------------
     */

    // footer kısmındaki locate'lerimizi bu kısma ekleyelim.
}
