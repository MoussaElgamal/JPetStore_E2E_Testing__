package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FishPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By angelfish = By.xpath("//a[text()='FI-SW-01']");
    private By tigerShark = By.xpath("//a[text()='FI-SW-02']");
    private By koi = By.xpath("//a[text()='FI-FW-01']");
    private By goldfish = By.xpath("//a[text()='FI-FW-02']");

    // Constructor
    public FishPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions
    public void selectAngelfish() {
        wait.until(ExpectedConditions.elementToBeClickable(angelfish)).click();
    }

    public void selectTigerShark() {
        wait.until(ExpectedConditions.elementToBeClickable(tigerShark)).click();
    }

    public void selectKoi() {
        wait.until(ExpectedConditions.elementToBeClickable(koi)).click();
    }

    public void selectGoldfish() {
        wait.until(ExpectedConditions.elementToBeClickable(goldfish)).click();
    }
}