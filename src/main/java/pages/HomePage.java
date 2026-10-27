package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By fishLink = By.xpath("//a[contains(@href,'FISH')]");
    private By dogsLink = By.xpath("//a[contains(@href,'DOGS')]");
    private By catsLink = By.xpath("//a[contains(@href,'CATS')]");
    private By birdsLink = By.xpath("//a[contains(@href,'BIRDS')]");
    private By reptilesLink = By.xpath("//a[contains(@href,'REPTILES')]");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions
    public void clickFish() {
        wait.until(ExpectedConditions.elementToBeClickable(fishLink)).click();
    }

    public void clickDogs() {
        wait.until(ExpectedConditions.elementToBeClickable(dogsLink)).click();
    }

    public void clickReptiles() {
        wait.until(ExpectedConditions.elementToBeClickable(reptilesLink)).click();
    }

    public void clickCats() {
        wait.until(ExpectedConditions.elementToBeClickable(catsLink)).click();
    }

    public void clickBirds() {
        wait.until(ExpectedConditions.elementToBeClickable(birdsLink)).click();
    }
}