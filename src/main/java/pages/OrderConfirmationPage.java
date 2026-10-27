
package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By confirmButton = By.xpath(
        "//button[normalize-space()='Confirm']" +
        " | //input[@value='Confirm']" +
        " | //a[normalize-space()='Confirm']"
    );

    // Constructor
    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
            driver, Duration.ofSeconds(10)
        );
    }

    // Actions
    public void clickConfirm() {
        wait.until(
            ExpectedConditions.elementToBeClickable(confirmButton)
        ).click();
    }

    // Example: Verify the order confirmation
    public boolean isOrderSuccessful() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Thank you')]")
            )
        ).isDisplayed();
    }
}
