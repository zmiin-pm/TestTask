package org.zpm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends AbstractPage {

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "input[name='login'][type='submit']")
    private WebElement loginSubmitButton;

    @FindBy(css = ".woocommerce-MyAccount-content > p > strong")
    private WebElement userNameHelloText;

    @FindBy(css = ".woocommerce-MyAccount-content > p > a")
    private WebElement signOutLink;

    @FindBy(css = ".woocommerce-MyAccount-navigation-link--dashboard > a")
    private WebElement dashboardLink;

    @FindBy(css = ".woocommerce-MyAccount-content p:nth-child(2)")
    WebElement dashboardText;

    public MyAccountPage loginMyAccount(String name, String password) {
        usernameInput.sendKeys(name);
        passwordInput.sendKeys(password);
        loginSubmitButton.click();
        return this;
    }

    public String getUserNameHelloText() {
        return userNameHelloText.getText();
    }

    public MyAccountPage signOutMyAccount() {
        signOutLink.click();
        return this;
    }

    public MyAccountPage clickDashboard() {
        dashboardLink.click();
        return this;
    }

    public boolean checkDashboardTextIsPresent() {
        return dashboardText.getText().contains("From your account dashboard you can");
    }

}
