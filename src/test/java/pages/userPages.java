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

    @FindBy(xpath = "//ul[@class='nav-menu']//a[contains(text(), 'Home')]")
    public WebElement homeButton;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[contains(text(), 'Projects')]")
    public WebElement projectsButton;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[contains(text(), 'Agents')]")
    public WebElement agentsButton;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[contains(text(), 'Blog')]")
    public WebElement blogButton;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[contains(text(), 'Contact')]")
    public WebElement contactButton;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[contains(text(), 'Sign Up')]")
    public WebElement signupButton;

    @FindBy(xpath = "//a[@class='text-success']")
    public WebElement addPropertyButton;

    @FindBy(xpath = "//img[@class='logo']")
    public WebElement logoButton;












    /*
       ------------------------- BODY -------------------------

     */

    // body kısmındaki locate'lerimizi bu kısma ekleyelim.




    /*
       ------------------------- FOOTER -------------------------
     */

    // footer kısmındaki locate'lerimizi bu kısma ekleyelim.
}
