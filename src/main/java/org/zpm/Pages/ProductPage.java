package org.zpm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//form[@class = \"cart\"]/*[@type = \"submit\"]")
    private WebElement addToBasketButton;

    @FindBy(xpath = "//li[@class=\"description_tab active\"]/a")
    private WebElement descriptionTab;

    @FindBy(css = ".woocommerce-Tabs-panel--description > h2")
    private WebElement descriptionText;

    public boolean checkAddToBusketButtonIsPresent() {
        return addToBasketButton.isDisplayed();
    }

    public ProductPage clickOnDescriptionTab() {
        descriptionTab.click();
        return this;
    }

    public boolean checkForDescription() {
        return descriptionText.isDisplayed();
    }

}
