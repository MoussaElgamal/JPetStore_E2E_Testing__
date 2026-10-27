package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FishDetailPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public FishDetailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locator
    private By addToCart(String description) {
        return By.xpath(
            "//td[normalize-space()='" + description + "']/following-sibling::td[2]"
        );
    }

    // Actions
    public void addFishToCart(String description) {
        wait.until(
            ExpectedConditions.elementToBeClickable(addToCart(description))
        ).click();
    }
}