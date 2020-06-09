package org.zpm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends AbstractPage{

    @FindBy(xpath = "//nav/a[contains(text(), 'Home')]")
    private WebElement homeLink;

    public HomePage clickHomeLink() {
        homeLink.click();
        return new HomePage();
    }
}
