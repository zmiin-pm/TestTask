package org.zpm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.zpm.Pages.HomePage;
import org.zpm.Pages.ProductPage;
import org.zpm.Pages.ShopPage;

public class TestHomePage extends BaseTest {        // Тесты для раздела №2 (HOME PAGE) из пункта 3.2



    @BeforeMethod
    public void beforeMethod() {
        home = new HomePage().open();               // переход на страницу http://practice.automationtesting.in/
        shop = home.clickShopMenuItem();            // переход по ссылке Shop
        home = shop.clickHomeLink();                // переход по ссылке Home
    }

    @Test(priority = 1)
    public void whetherTheHomePageHasThreeArrivalsOnly() {
        Assert.assertTrue(home.countArrivals() == 3);
    }

    @Test(priority = 2)
    public void whetherItIsNavigatingToNextPage() {
        productPage = home.clickOnProduct();                                   // клик по случайному новому продукту и преход на страницу продкукта
        Assert.assertTrue(productPage.checkAddToBasketButtonIsPresent());      // проверка наличия кнопки добавления в корзину
    }

    @Test(priority = 3)
    public void shouldBeADescriptionRegardingTheBook() {
        productPage = home.clickOnProduct();                    // переход на страницу продукта
        Assert.assertTrue(productPage
                .clickOnDescriptionTab()                        // клик по вкладке описания
                .checkForDescription());                        // проверка наличия описания
    }

    @Test
    public void shouldBeAReviewsRegardingTheBook(){
        productPage = home.clickOnProduct();                    // переход на страницу продукта
        productPage.clickOnReviewsTab();
        Assert.assertTrue(productPage.checkForReviews());
    }

}
