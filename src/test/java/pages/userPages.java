package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

import java.awt.*;


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

    @FindBy(xpath = "(//*[@class='login-item'])[1]")
    public WebElement usernameButton;

    @FindBy(xpath = "(//*[@class='login-item'])[2]")
    public WebElement logoutButton;

    /*
       ------------------------- BODY -------------------------

     */

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

    @FindBy(xpath = "//span[@id='select2-maxprice-container']")
    public WebElement maxPrice;

    @FindBy(xpath ="//span[@id='select2-ptypes-container']")
    public WebElement propertyType;

    @FindBy(xpath ="//span[@id='select2-select-bedroom-container']" )
    public WebElement bedRooms;

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
    @FindBy(xpath = "//a[@class='prt-view' and @href='https://qa.hauseheaven.com/properties/satilik-daire-4']")
    public WebElement satilikDaire4button;

    @FindBy(xpath = "//*[@data-slick-index='4']")
    public List<WebElement> projeSayisi;

    @FindBy(xpath = "//*[@class=\"fr-position\"]")
    public WebElement agentsProperties;

    @FindBy(xpath = "(//a[@class='prt-view'])[1]")
    public WebElement firstAgent;

    @FindBy(xpath = "//*[@class=\"block-wrap\"]")
    public WebElement agentInfo;

    @FindBy (xpath = "//*[@class=\"col-lg-5 col-md-5\"]")
    public WebElement contactInfo;

    @FindBy(xpath = "//*[@name=\"name\"]")
    public WebElement contactName;

    @FindBy(xpath = "(//*[@name=\"email\"])[1]")
    public WebElement contactEmail;

    @FindBy(xpath = "//*[@name=\"subject\"]")
    public WebElement contactSubject;

    @FindBy(xpath = "//*[@name=\"phone\"]")
    public WebElement contactPhone;

    @FindBy(xpath = "//*[@name=\"content\"]")
    public WebElement contactMessage;

    @FindBy(xpath = "(//*[@type=\"submit\"])[1]")
    public WebElement sendMessageButton;

    @FindBy(xpath = "//*[@class=\"contact-message contact-success-message\"]")
    public WebElement sendMessageSuccess;

    @FindBy(xpath = "//h1[contains(text(),'Properties')]")
    public WebElement propertyPagePropertyYazisi;

    @FindBy(xpath = "//h2[contains(text(),'All projects')]")
    public WebElement projectsPageProjectsYazisi;

    @FindBy(xpath = "//h1[contains(text(),'All Agents')]")
    public WebElement agentsPageAllagentsYazisi;

    @FindBy(xpath ="//h1[contains(text(),'Blog')]" )
    public WebElement blogPageBlogYazisi;

    @FindBy(xpath ="//h1[contains(text(),'Contact')]" )
    public WebElement contactPageContactYazisi;

    @FindBy(xpath = "//h2[contains(text(),'Register')]")
    public WebElement signupPageRegisterYazisi;

    @FindBy(xpath = "//h2[contains(text(),'Login')]")
    public WebElement signinPageLoginYazisi;

    @FindBy(xpath = "//span[@class='listing-location']")
    public WebElement ilanLocation;

    /*
       ------------------------- FOOTER -------------------------
     */

    // footer kısmındaki locate'lerimizi bu kısma ekleyelim.
}
