package org.zpm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//form[@class = \"cart\"]/*[@type = \"submit\"]")
    private WebElement addToBasketButton;

    @FindBy(xpath = "//li[@class=\"description_tab active\"]/a")
    private WebElement descriptionTab;

    @FindBy(css = ".woocommerce-Tabs-panel--description p")
    private WebElement descriptionText;

    @FindBy(css = ".reviews_tab > a")
    private WebElement reviewsTab;

    @FindBy(css = "div#comments > p.woocommerce-noreviews")
    private WebElement reviewsText;

    public boolean checkAddToBasketButtonIsPresent() {
        return addToBasketButton.isDisplayed();
    }

    public ProductPage clickOnDescriptionTab() {
        descriptionTab.click();
        return this;
    }

    public boolean checkForDescription() {
        return descriptionText.getText()!=null;
    }

    public ProductPage clickOnReviewsTab() {
        reviewsTab.click();
        return this;
    }

    public boolean checkForReviews(){
        return  reviewsText.isDisplayed();
    }

}
