package pages;

import org.openqa.selenium.support.PageFactory;

public class adminPages {

    public adminPages() {
        PageFactory.initElements(utilities.Driver.getDriver("https://qa.hauseheaven.com/admin/login"), this);
    }
}
