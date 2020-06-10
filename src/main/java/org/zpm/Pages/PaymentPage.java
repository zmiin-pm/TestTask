package org.zpm.Pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.zpm.Driver.DriverHolder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PaymentPage extends AbstractPage {

    @FindBy(css = ".woocommerce-billing-fields")
    WebElement billingDetails;

    @FindBy(css = ".woocommerce-shipping-fields")
    WebElement additionalDetails;

    @FindBy(css = ".woocommerce-checkout-review-order-table")
    WebElement orderDetails;

    @FindBy(id = "payment")
    WebElement paymentDetails;

    @FindBy(css = ".woocommerce-billing-fields input[id^=\"bill\"]")
    List<WebElement> billingFields;

    @FindBy(css = ".payment_methods label")
    List<WebElement> paymentMethods;

    @FindBy(id = "place_order")
    WebElement placeOrderButton;

    public boolean checkoutAllDetailsIsPresent() {
        return (billingDetails.isDisplayed()) &&
                (additionalDetails.isDisplayed()) &&
                (orderDetails.isDisplayed()) &&
                (paymentDetails.isDisplayed());
    }

    public PaymentPage setBillingDetails() {
        Map<String, String> billingDetails = new HashMap<>();
        billingDetails.put("billing_first_name", "Donald");
        billingDetails.put("billing_last_name", "Trump");
        billingDetails.put("billing_company", "USA");
        billingDetails.put("billing_email", "gohehi9540@zaelmo.com");
        billingDetails.put("billing_phone", "322 233 322");
        billingDetails.put("billing_address_1", "White House");
        billingDetails.put("billing_address_2", "1");
        billingDetails.put("billing_city", "Washington");
        billingDetails.put("billing_state", "Washington");
        billingDetails.put("billing_postcode", "20001");

        for (WebElement element: billingFields) {
            element.sendKeys(billingDetails
                    .get(element.getAttribute("id")));
        }
        return this;
    }

    public PaymentPage setRandomPaymentMethod(){
        Random random = new Random();
        WebElement paymentMethod = paymentMethods.get(random.nextInt(3));
       try {
           paymentMethod.click();
       } catch (StaleElementReferenceException e) {
           paymentMethod.click();
       }
        return this;
    }

    public OrderConfirmationPage clickPlaceOrderButton(){
        placeOrderButton.click();
        return new OrderConfirmationPage();
    }


}
