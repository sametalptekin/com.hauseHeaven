package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class userPages {

    public userPages(){
        PageFactory.initElements(utilities.Driver.getDriver(), this);
    }

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
       ------------------------- DASHBOARD -------------------------
    */
    @FindBy(xpath = "//*[@title='Profile']")
    public WebElement profileButtonDashboard;

    @FindBy(xpath = "//*[@title='Settings']")
    public WebElement settingsButtonDashboard;

    @FindBy(xpath = "//*[@title='credits']")
    public WebElement buyCreditsButtonDashboard;

    @FindBy(xpath = "//*[@title='Properties']")
    public WebElement propertiesButtonDashboard;

    @FindBy(xpath = "//a[@href='https://qa.hauseheaven.com/account/security']")
    public WebElement securityButtonDashboard;

    @FindBy(xpath = "//*[@class='no-underline mr2 black-50 hover-black-70 pv1 ph2 db']")
    public WebElement logoutButtonDashboard;

    //Settings

    @FindBy(xpath = "//*[@id='first_name']")
    public WebElement firstNameBox;

    @FindBy(xpath = "//*[@id='last_name']")
    public WebElement lastNameBox;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement usernameBox;

    @FindBy(xpath = "//*[@id='phone']")
    public WebElement phoneBox;

    //Buy Credits

    @FindBy(xpath = "(//button[@class='btn btn-primary mt-2'])[2]")
    public WebElement purchaseButton;

    @FindBy(xpath = "//*[@id='stripe-number']")
    public WebElement cardNumberBox;

    @FindBy(xpath = "//*[@id='stripe-name']")
    public WebElement fullNameBox;

    @FindBy(xpath = "//*[@id='stripe-exp']")
    public WebElement expDateBox;

    @FindBy(xpath = "//*[@id='stripe-cvc']")
    public WebElement cvcBox;

    @FindBy(xpath = "//*[@class='payment-checkout-btn btn btn-info']")
    public WebElement checkoutButton;

    //Security

    @FindBy(xpath = "//*[@id='password']")
    public WebElement newPasswordBox;

    @FindBy(xpath = "//*[@id='password_confirmation']")
    public WebElement confirmationPassBox;

    @FindBy(xpath = "//*[@class='btn btn-theme-light-2']")
    public WebElement updatePassButton;

    /*
       ------------------------- HEADER -------------------------
     */

    @FindBy(xpath = "//*[@class='add-listing']")
    public WebElement signinButton;

    @FindBy(xpath = "//a[normalize-space(text())='Listing']")
    public WebElement listingButton;

    @FindBy(xpath = "(//*[@class='login-item'])[1]")
    public WebElement usernameButton;

    @FindBy(xpath = "(//*[@class='login-item'])[2]")
    public WebElement logoutButton;


    /*
       ------------------------- BODY -------------------------

     */

    // body kısmındaki locate'lerimizi bu kısma ekleyelim.




    /*
       ------------------------- FOOTER -------------------------
     */

    // footer kısmındaki locate'lerimizi bu kısma ekleyelim.
}
