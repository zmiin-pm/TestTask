package org.zpm.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.zpm.Driver.DriverHolder;
import org.zpm.Driver.DriverType;


public class BaseTest {

    @BeforeSuite
    public void beforeSuite() {
        DriverHolder.INSTANCE.initDriver(       // открытие браузера ХРОМ
                DriverType.CHROME,
                10,  // implicitly
                0); // explicitly
    }

    @AfterSuite
    public void afterClass() {
        DriverHolder.INSTANCE.getDriver().quit();
    }       // закрытие браузера
}
