package org.zpm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ShopPage extends AbstractPage {

    @FindBy(xpath = "//nav/a[contains(text(), 'Home')]")
    private WebElement homeLink;

    @FindBy(css = ".add_to_cart_button")
    private List<WebElement> productsCouldBeAddToBasket;

    @FindBy(css = ".wpmenucart-contents > .cartcontents")
    private WebElement itemsInBasketSpan;

    @FindBy(css = ".wpmenucart-contents > .amount")
    private WebElement totalPriceInBasketSpan;

    @FindBy(css = "a.wpmenucart-contents")
    private WebElement shoppingCart;

    public HomePage clickHomeLink() {
        homeLink.click();
        return new HomePage();
    }

    public WebElement getRandomProductButton() {
        Random random = new Random();
        WebElement randomAddToBasketButton = productsCouldBeAddToBasket
                .get(random
                        .nextInt(productsCouldBeAddToBasket
                                .size()));
        return randomAddToBasketButton;
    }

    public ShopPage clickRandomAddToBasketButton() {
        getRandomProductButton().click();
        return new ShopPage();
    }

    public int getNumberOfItemsInTheBasket() {
        return itemsInBasketSpan.getText().charAt(0);
    }

    public int getTotalPriceInBasket() {
        return Integer.parseInt(
                totalPriceInBasketSpan
                        .getText()
                        .substring(1, 2));
    }

    public BasketPage clickShoppingCart() {
        shoppingCart.click();
        return new BasketPage();
    }
}
