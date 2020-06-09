package org.zpm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.zpm.Driver.DriverHolder;

import java.util.List;

public abstract class AbstractPage {

    protected AbstractPage() {
        PageFactory.initElements(DriverHolder.INSTANCE.getDriver(), this);
    }

}
