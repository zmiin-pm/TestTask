package org.zpm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.zpm.Driver.DriverHolder;

import java.util.List;
import java.util.Random;


public class HomePage extends AbstractPage {

    @FindBy(id = "menu-item-50")
    private WebElement myAccountMenu;

    @FindBy(id = "menu-item-40")
    private WebElement shopMenuItem;

    @FindBy(xpath = "//ul[@class=\"products\"]")
    private List<WebElement> productArrivals;

    @FindBy(xpath = "//ul[@class=\"products\"]//img")
    private List<WebElement> productArrivalsImg;

    @FindBy(xpath = "//ul[@class=\"products\"]//img/ancestor::a")
    private List<WebElement> productImgLink;

    public HomePage open() {
        DriverHolder.INSTANCE.getDriver().get("http://practice.automationtesting.in/");
        return this;
    }

    public MyAccountPage clickMyAccountMenu() {
        myAccountMenu.click();
        return new MyAccountPage();
    }

    public ShopPage clickShopMenuItem() {
        shopMenuItem.click();
        return new ShopPage();
    }

    public int countArrivals() {
        return productArrivals.size();
    }

    public ProductPage clickOnProduct() {
        Random random = new Random();
        productImgLink.get(random.nextInt(3)).click();
        return new ProductPage();
    }
}
