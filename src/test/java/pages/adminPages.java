package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

import java.awt.*;


public class adminPages {

    public adminPages() {
        PageFactory.initElements(utilities.Driver.getDriver(), this);
    }

    /*
     -----------------------------------------LOGİN------------------------------------------
     */
    @FindBy(xpath = "//*[@name='username']")
    public WebElement loginFormEmail;
    @FindBy(xpath = "//*[@name='password']")
    public WebElement loginFormPassword;
    @FindBy(xpath = "//*[@class='signin']")
    public WebElement loginButton;

  /*
     -----------------------------------------DASHBOARD------------------------------------------
     */

    @FindBy(xpath = "//*[@class='breadcrumb-item active']")
    public WebElement dashboardButton;

    @FindBy(xpath = "//*[@class='toast-message']")
    public WebElement errormessage;

    @FindBy(xpath = "//*[@id='cms-plugins-blog']")
    public WebElement blogMenu;

    @FindBy(xpath = "//*[@id='cms-plugins-testimonial']")
    public WebElement testimonialsMenu;

    @FindBy(xpath = "//*[@id='cms-plugins-real-estate']")
    public WebElement realestateMenu;

    @FindBy(xpath = "//*[@id='cms-plugins-newsletter']")
    public WebElement newsletterMenu;

    @FindBy(xpath = "//*[@id='cms-plugins-consult']")
    public WebElement consultMenu;

    @FindBy(xpath = "//*[@id='cms-plugins-real-estate-account']")
    public WebElement accountsMenu;

    @FindBy(xpath = "//*[@id='cms-plugins-package']")
    public WebElement packagesMenu;

    @FindBy(xpath = "//*[@id='cms-plugins-contact']")
    public WebElement contactMenu;

    @FindBy(xpath = "//*[@id='cms-plugins-location']")
    public WebElement locationsMenu;

    @FindBy(xpath = "//*[@id='cms-plugins-translation']")
    public WebElement translationsMenu;

    @FindBy(xpath = "//*[@id='cms-core-platform-administration']")
    public WebElement platformAdministrationMenu;

    @FindBy(xpath = "//*[@id='cms-plugins-property']")
    public WebElement propertiesMenu;

    @FindBy(xpath = "//*[@id='cms-plugins-re-feature']")
    public WebElement featuresMenu;

    @FindBy(xpath = "//*[@id='cms-plugins-facility']")
    public WebElement facilitiesMenu;

    @FindBy(xpath = "//*[@id='cms-plugins-real-estate-category']")
    public WebElement categoriesMenu;

    @FindBy(xpath = "//*[@id=\"cms-plugins-package\"]/a/span")
    public WebElement adminPackagesButonu;


    @FindBy(xpath = "//*[@id='cms-plugins-real-estate-type']")
    public WebElement typesMenu;


    @FindBy(xpath = "//*[@data-action='create']")
    public WebElement createButton;

    @FindBy(xpath = "//*[@placeholder='Name']")
    public WebElement nameBox;

    @FindBy(xpath = "//*[@placeholder='Position/Company']")
    public WebElement positionBox;


    @FindBy(xpath = "//*[@role='textbox']")
    public WebElement textbox;

    @FindBy(xpath = "//*[@class='btn btn-info'][1]")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@class='btn btn-icon btn-sm btn-danger deleteDialog'][1]")
    public WebElement deleteButton;

    @FindBy(xpath = "   //*[@class='float-end btn btn-danger delete-crud-entry']")
    public WebElement alertMsg;

    @FindBy(xpath = "   //*[@class='toast-message']")
    public WebElement successfully;

}
//*[@class='toast-message']




