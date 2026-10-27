package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
            driver, Duration.ofSeconds(10)
        );
    }

    // Locators
    private By quantityField = By.xpath(
        "//tr[td[contains(normalize-space(), 'Large Angelfish')]]//input"
    );

    private By updateCartButton = By.xpath(
        "//input[@value='Update Cart'] | " +
        "//button[normalize-space()='Update Cart']"
    );

    private By removeButton = By.xpath(
        "//tr[td[contains(normalize-space(), 'Large Angelfish')]]" +
        "//*[self::a or self::button or self::input]" +
        "[normalize-space()='Remove' or @value='Remove']"
    );

    private By checkoutButton = By.xpath(
        "//*[@id='Cart']/a"
    );

    private By subtotal = By.xpath(
        "//*[contains(normalize-space(), 'Sub Total:')]"
    );

    // Enter Quantity
    public void enterQuantity(String quantity) {
        WebElement field = wait.until(
            ExpectedConditions.visibilityOfElementLocated(quantityField)
        );

        field.clear();
        field.sendKeys(quantity);
    }

    // Update Cart
    public void clickUpdateCart() {
        wait.until(
            ExpectedConditions.elementToBeClickable(updateCartButton)
        ).click();
    }

    // Update Quantity
    public void updateQuantity(String quantity) {
        enterQuantity(quantity);
        clickUpdateCart();

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(subtotal)
        );
    }

    // Remove Item
    public void removeItem() {
        wait.until(
            ExpectedConditions.elementToBeClickable(removeButton)
        ).click();
    }

    // Proceed to Checkout
    public void proceedToCheckout() {
        wait.until(
            ExpectedConditions.elementToBeClickable(checkoutButton)
        ).click();
    }

    // Get Subtotal
    public String getSubtotal() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(subtotal)
        ).getText();
    }

    // Get Quantity
    public String getQuantity() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(quantityField)
        ).getAttribute("value");
    }
}
