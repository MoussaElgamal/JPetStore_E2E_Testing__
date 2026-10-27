package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void testFishNavigation() {

        HomePage homePage = new HomePage(driver);

        homePage.clickFish();

        System.out.println("Fish category clicked successfully");
    }
}