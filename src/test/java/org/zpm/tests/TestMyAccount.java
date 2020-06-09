package org.zpm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.zpm.Pages.HomePage;
import org.zpm.Pages.MyAccountPage;


public class TestMyAccount extends BaseTest {     //  Тесты для раздела №1 (MY ACCOUNT) из пункта 3.2

    HomePage home;
    MyAccountPage accountPage;


    @BeforeMethod
    public void beforeMethod() {
        home = new HomePage().open();               // переход на страницу http://practice.automationtesting.in/
        accountPage = home.clickMyAccountMenu();    // переход по ссылке MyAccountMenu

        String name = "gohehi9540@zaelmo.com";      // почта пользователя
        String password = "2020ItIsTooMuch!?";      // пароль

        accountPage.loginMyAccount(name, password);  // ввод данных пользователя и клик по submitButton
    }

    @Test
    public void SuccessfullyLoginToTheWebPage() {       // проверка успешногшо входа в аккаунт
        Assert.assertTrue(accountPage
                .getUserNameHelloText()
                .equals("gohehi9540"));
    }

    @Test
    public void MustViewDashboard() {       //      проверка отображения Dashboard
        Assert.assertTrue(accountPage
                .clickDashboard()
                .checkDashboardTextIsPresent());
    }

    @AfterMethod
    public void afterMethod() {
        accountPage.signOutMyAccount();     // выход из аккаунта
    }

}
