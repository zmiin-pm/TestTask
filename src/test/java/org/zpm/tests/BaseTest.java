package org.zpm.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.zpm.Driver.DriverHolder;
import org.zpm.Driver.DriverType;
import org.zpm.Pages.*;


public class BaseTest {

    HomePage home;
    ShopPage shop;
    ProductPage productPage;
    MyAccountPage accountPage;
    BasketPage basket;
    PaymentPage payment;
    OrderConfirmationPage confirmation;

    @BeforeSuite
    public void beforeSuite() {
        DriverHolder.INSTANCE.initDriver(       // открытие браузера ХРОМ
                DriverType.CHROME,
                20,  // implicitly
                10); // explicitly
    }

    @AfterSuite
    public void afterClass() {
        DriverHolder.INSTANCE.getDriver().quit();
    }       // закрытие браузера
}
