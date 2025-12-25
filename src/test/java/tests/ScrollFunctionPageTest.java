package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScrollFunctionPageTest extends BaseTest {

    @Test(priority = 1)
    public void verifyTheWebsiteLaunch() {
        productReviewPage.launchUrl();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("automationexercise"),"Incorrect Url loaded!");

        WebElement homeLogo = driver.findElement(productReviewPage.getHomepageLogo());
        Assert.assertTrue(homeLogo.isDisplayed(),"Home logo is not displayed");

    }
}
