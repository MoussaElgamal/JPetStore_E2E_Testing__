
package tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderConfirmationPage;
import pages.PaymentPage;
import pages.ShoppingCartPage;
import pages.FishDetailPage;
import pages.FishPage;

public class PurchaseTest extends BaseTest {

    @Test
    public void testSelectFish() {

        try {
            // 1. Login
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterUsername("123456");
            loginPage.enterPassword("123456");
            loginPage.clickLogin();

            // 2. Home Page
            HomePage homePage = new HomePage(driver);
            homePage.clickFish();

            // 3. Fish Page
            FishPage fishPage = new FishPage(driver);
            fishPage.selectAngelfish();

            // 4. Fish Detail Page
            FishDetailPage detailPage = new FishDetailPage(driver);
            detailPage.addFishToCart("Large Angelfish");

            // 5. Shopping Cart
            ShoppingCartPage cart = new ShoppingCartPage(driver);
            cart.proceedToCheckout();

            // 6. Payment Page
            PaymentPage paymentPage = new PaymentPage(driver);
            paymentPage.fillPaymentDetails();
            paymentPage.clickContinue();

            // 7. Order Confirmation
            OrderConfirmationPage orderConfirmationPage =
                new OrderConfirmationPage(driver);

            orderConfirmationPage.clickConfirm();

            // 8. Verify Order
            Assert.assertTrue(
                orderConfirmationPage.isOrderSuccessful(),
                "Order confirmation was not displayed!"
            );

        } catch (Exception e) {

            System.err.println("Purchase test failed!");
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();

            // Mark the test as FAILED
            Assert.fail("Purchase test failed: " + e.getMessage(), e);
        }
    }
}
