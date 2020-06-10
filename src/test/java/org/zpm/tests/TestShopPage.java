package org.zpm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.zpm.Pages.HomePage;

public class TestShopPage extends BaseTest {

    @BeforeClass
    public void beforeClass() {
        home = new HomePage().open();            // переход на страницу http://practice.automationtesting.in/
        shop = home.clickShopMenuItem();         // переход по ссылке Shop
        shop.clickRandomAddToBasketButton();     // добавление в корзину случайного товара
    }

    @Test
    public void userCanViewThatBookInTheMenuItemWithPrice() {
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

    @Test(priority = 1)
    // без добавления товара тест даст отрицательный результат
    public void userCanFindTotalAndSubtotalValues() {
        basket = shop.clickShoppingCart();              // переход в корзину по ссылке
        Assert.assertTrue(basket
                .checkSubPriceAndPriceNotNull());       // проверка, что цена товара и общая цена не нулевые
    }

    @Test(priority = 2)
    public void totalAlwaysBiggerSubtotal() {
        Assert.assertTrue((basket.getTotalPrice()) > (basket.getSubtotalPrice()));
    }

    @Test(priority = 3)
    public void userCanViewBillingOrderAdditionalDetailsAndPaymentGateway() {
        payment = basket.clickProceedToCheckoutButton();
        Assert.assertTrue(payment.checkoutAllDetailsIsPresent());
    }

    @Test(priority = 4)     // Все условия, описанные в тест-кейсе не могут быть выполнены без регистрации аккаунта(тест-кейс - негативный)
    public void orderConfirmationPageWithOrderBankCustomerAndBillingDetails(){
        payment
                .setBillingDetails()
                .setRandomPaymentMethod();
        confirmation = payment.clickPlaceOrderButton();
        Assert.assertTrue(confirmation.checkoutDetailsIsPresent());

    }
}
