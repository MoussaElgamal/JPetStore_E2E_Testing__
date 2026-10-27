
package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Payment locators using XPath
    private By cardType =
        By.xpath("//select[@name='cardType']");

    private By cardNumber =
        By.xpath("//input[@name='creditCard']");

    private By expiryDate =
        By.xpath("//input[@name='expiryDate']");

    // Billing locators using XPath
    private By firstName =
        By.xpath("//input[@name='billToFirstName']");

    private By lastName =
        By.xpath("//input[@name='billToLastName']");

    private By address1 =
        By.xpath("//input[@name='billAddress1']");

    private By address2 =
        By.xpath("//input[@name='billAddress2']");

    private By city =
        By.xpath("//input[@name='billCity']");

    private By state =
        By.xpath("//input[@name='billState']");

    private By zip =
        By.xpath("//input[@name='billZip']");

    private By country =
        By.xpath("//input[@name='billCountry']");

    private By continueButton =
        By.xpath("//input[@value='Continue']"
                + " | //button[normalize-space()='Continue']");

    // Constructor
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
            driver, Duration.ofSeconds(10)
        );
    }

    // Wait, clear and enter text
    private void enterText(By locator, String text) {
        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(locator)
        );

        element.clear();
        element.sendKeys(text);
    }

    // Fill payment and billing details
    public void fillPaymentDetails() {

        WebElement cardTypeElement = wait.until(
            ExpectedConditions.elementToBeClickable(cardType)
        );

        new Select(cardTypeElement).selectByVisibleText("Visa");

        enterText(cardNumber, "9999 9999 9999 9999");
        enterText(expiryDate, "12/2030");

        enterText(firstName, "ABC");
        enterText(lastName, "XYZ");
        enterText(address1, "901 San Antonio Road");
        enterText(address2, "MS UCUP02-206");
        enterText(city, "Palo Alto");
        enterText(state, "CA");
        enterText(zip, "94303");
        enterText(country, "USA");
    }

    // Click Continue
    public void clickContinue() {
        wait.until(
            ExpectedConditions.elementToBeClickable(continueButton)
        ).click();
    }
}
