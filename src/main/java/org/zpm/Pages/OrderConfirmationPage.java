package org.zpm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends AbstractPage {

    @FindBy(css = ".order_details")
    WebElement orderDetails;

    @FindBy(css = "customer_details")
    WebElement customerDetails;

    @FindBy(css = "address")
    WebElement billingDetails;

    public boolean checkoutDetailsIsPresent(){
        return (orderDetails.isDisplayed())&&
                (customerDetails.isDisplayed())&&
                (billingDetails.isDisplayed());
    }



}
