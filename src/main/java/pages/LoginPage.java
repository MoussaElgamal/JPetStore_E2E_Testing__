
package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By usernameTextBox =
        By.xpath("//input[@name='username']");

    private By passwordTextBox =
        By.xpath("//input[@name='password']");

    private By loginButton =
        By.xpath("//input[@name='signon']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
            driver, Duration.ofSeconds(10)
        );
    }

    // Enter Username
    public void enterUsername(String username) {
        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(usernameTextBox)
        );

        element.clear();
        element.sendKeys(username);
    }

    // Enter Password
    public void enterPassword(String password) {
        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(passwordTextBox)
        );

        element.clear();
        element.sendKeys(password);
    }

    // Click Login
    public void clickLogin() {
        wait.until(
            ExpectedConditions.elementToBeClickable(loginButton)
        ).click();
    }
}
