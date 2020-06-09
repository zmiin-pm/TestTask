package org.zpm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends AbstractPage {

    @FindBy(css = ".cart-subtotal .woocommerce-Price-amount.amount")
    WebElement subtotalPrice;

    @FindBy(css = ".order-total .woocommerce-Price-amount.amount")
    WebElement totalPrice;

    public int getSubtotalPrice() {
        return Integer.parseInt(subtotalPrice.getText().substring(1,4));
    }

    public int getTotalPrice() {
        return Integer.parseInt(totalPrice.getText().substring(1,4));
    }

    public boolean checkSubPriceAndPriceNotNull() {
        return ((getSubtotalPrice() != 0 && (getTotalPrice() != 0)));
    }
}
