package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class adminPages {

    public adminPages(){
        PageFactory.initElements(utilities.Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='add-listing']")
    public WebElement signinButton;

}
