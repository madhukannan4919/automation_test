package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScrollFunctionPageTest extends BaseTest {

    @Test(priority = 1)
    public void verifyTheWebsiteLaunch() {
        scrollFunctionPage.launchUrl();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("automationexercise"),"Incorrect Url loaded!");

        WebElement homeLogo = driver.findElement(scrollFunctionPage.getHomepageLogo());
        Assert.assertTrue(homeLogo.isDisplayed(),"Home logo is not displayed");

    }
    @Test(priority = 2)
    public void verifyScrollDown() {
        scrollFunctionPage.scrollToBottomOfPage();
        Assert.assertTrue(scrollFunctionPage.SubscriptionVisible(), "Subscription text is not visible after scrolling");
    }
    @Test(priority = 3)
    public void VerifyUpArrow() {
        scrollFunctionPage.clickUpArrowBtn();
    }
    @Test(priority = 4)
    public void VerifyAutomationText() {
        Assert.assertTrue(scrollFunctionPage.automationText(),"Automation text is not visible after click upArrow");
    }

}
