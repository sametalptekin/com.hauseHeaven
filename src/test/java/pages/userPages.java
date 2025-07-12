package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class userPages {

    public void userPages(){
        PageFactory.initElements(utilities.Driver.getDriver(), this);
    }


    /*
       ------------------------- HEADER -------------------------
     */




    /*
       ------------------------- BODY -------------------------

     */

    // body kısmındaki locate'lerimizi bu kısma ekleyelim.


    /*
       ------------------------- FOOTER -------------------------
     */

    // footer kısmındaki locate'lerimizi bu kısma ekleyelim.


    /*
       -------------------------ILAN-PROFİL-USTMENU-------------------------

     */

    @FindBy(xpath = "//*[@class='add-listing']")
    public WebElement signInButton;

    @FindBy(xpath = "//*[@class='login-item']")
    public WebElement profilButonu;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement userNameKutusu;

    @FindBy (xpath = "//*[@id=\"password\"]")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//*[@class='btn btn-md full-width btn-theme-light-2 rounded']")
    public WebElement loginButonu;

    @FindBy(xpath = "//a[@class='text-success']")
    public WebElement addPropertyButonu;

    @FindBy(xpath = "//a[normalize-space(text())='Listing']")
    public WebElement listingButonu;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[contains(text(), 'Home')]")
    public WebElement homeButonu;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[contains(text(), 'Projects')]")
    public WebElement projectsButonu;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[contains(text(), 'Agents')]")
    public WebElement agentsButonu;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[contains(text(), 'Blog')]")
    public WebElement blogButonu;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[contains(text(), 'Contact')]")
    public WebElement contactButonu;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[contains(text(), 'Sign Up')]")
    public WebElement signupButonu;

    @FindBy(xpath = "//img[@class='logo']")
    public WebElement logoButonu;

    @FindBy(xpath = "//*[@class='login-item'])[1]")
    public WebElement usernameButonu;

    @FindBy(xpath = "//*[@class='login-item'])[2]")
    public WebElement logoutButonu;

    @FindBy(xpath = "//div[@role='textbox' and contains(@class, 'ck-editor__editable') and @contenteditable='true']")
    public WebElement ilanFormContent;

    @FindBy(xpath = "//*[@id='name']")
    public WebElement ilanFormTitle;

    @FindBy(xpath = "//*[@id='description']")
    public WebElement ilanFormDescription;

    @FindBy(xpath = "//input[@name='location' and @placeholder='Property location']")
    public WebElement ilanFormPublicLocation;

    @FindBy(xpath = "//*[@name=\"number_bedroom\"]")
    public WebElement ilanFormBedrooms;

    @FindBy(xpath = "//*[@name=\"number_bathroom\"]")
    public WebElement ilanFormBathroom;

    @FindBy(xpath = "//*[@id='number_floor']")
    public WebElement ilanFormFloors;

    @FindBy(xpath = "//input[@name='square' and @placeholder='Square :unit']")
    public WebElement ilanFormSquare;

    @FindBy(id ="price-number")
    public WebElement ilanFormPrice;

    @FindBy(xpath = "//select[@name='facilities[][id]']")
    public WebElement ilanFormFacilities;

    @FindBy(name = "facilities[7][distance]")
    public WebElement ilanFormDistance;

//    @FindBy(xpath = "//*[@class='btn btn-info']")
//    public WebElement ilanFormAddNewButonu;

    @FindBy (xpath = "//*[@name=\"features[]\"]")
    public WebElement ilanFormWifiButonu;

    @FindBy (xpath = "//input[@name='features[]' and @value='5']")
    public WebElement ilanFormGardenButonu;



    @FindBy (xpath = "//*[@id='select2-category_id-container']")
    public WebElement ilanFormCategoryButonu;

    @FindBy (className ="select2-search__field")
    public WebElement CategoryButonu;

    @FindBy (xpath = "//*[@class='fa fa-save']")
    public WebElement ilanSaveAndExitButonu;

    @FindBy(xpath = "//a[@href='https://qa.hauseheaven.com/public/account/properties' and @title='Properties' and contains(., 'Properties')]")
    public WebElement accountDashboardProtertiesButonu;

    @FindBy(xpath = "//a[@href='https://qa.hauseheaven.com/public/account/properties/edit/58' and normalize-space(text())=\"SHREK'IN BATAKLIGI\"]" )
    public WebElement accountIlanButonu;

    @FindBy (xpath = "//*[@class='fa fa-trash']")
    public WebElement ilanSilmeButonu;

    @FindBy (xpath = "//*[@class='fa fa-save']" )
    public WebElement accountDashboardSaveExitButonu;

    @FindBy (xpath = "//*[@class='float-end btn btn-danger delete-crud-entry']")
    public WebElement ilanSilmeUyarıButonu;

      /*
       -------------------------KREDI SATIN ALMA-------------------------

     */


    @FindBy(xpath = "//*[@title='credits']")
    public WebElement buyCreditsButonu;




}
