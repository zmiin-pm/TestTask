package org.zpm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.zpm.Pages.HomePage;

public class TestShopPage extends BaseTest {

    @BeforeClass
    public void beforeClass() {
        home = new HomePage().open();       // переход на страницу http://practice.automationtesting.in/
        shop = home.clickShopMenuItem();    // переход по ссылке Shop
    }

    @Test
    public void userCanViewThatBookInTheMenuItemWithPrice() {
        shop.clickRandomAddToBasketButton();                    // добавление в корзину случайного товара
        try {
            Thread.sleep(3000);                             // ожидание необходимо для обновления цены
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(
                (shop.getNumberOfItemsInTheBasket() != 0)   // проверка того, что количество товаров не нулевое
                        &&                                           // и того, что
                        (shop.getTotalPriceInBasket() != 0));       // цена товаров в корзине не нулевая
    }

    @Test(dependsOnMethods = "userCanViewThatBookInTheMenuItemWithPrice")    // без добавления товара тест даст отрицательный результат
    public void  userCanFindTotalAndSubtotalValues(){
        basket = shop.clickShoppingCart();              // переход в корзину по ссылке
        Assert.assertTrue(basket
                .checkSubPriceAndPriceNotNull());       // проверка, что цена товара и общая цена не нулевые
    }

    @Test(dependsOnMethods = "userCanViewThatBookInTheMenuItemWithPrice")   // для сравнения цен нужны предыдущие тесты
    public void totalAlwaysBiggerSubtotal(){
        basket = shop.clickShoppingCart();              // переход в корзину по ссылке
        Assert.assertTrue((basket.getTotalPrice()) > (basket.getSubtotalPrice()));
    }


}
