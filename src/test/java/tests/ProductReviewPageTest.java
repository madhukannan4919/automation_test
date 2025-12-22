package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RandomUtils;


public class ProductReviewPageTest extends BaseTest {

    @Test(priority = 1)
    public void verifyTheWebsiteLaunch() {
        productReviewPage.launchUrl();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("automationexercise"),"Incorrect Url loaded!");

        WebElement homeLogo = driver.findElement(productReviewPage.getHomepageLogo());
        Assert.assertTrue(homeLogo.isDisplayed(),"Home logo is not displayed");

    }

    @Test(priority = 2)
    public void clickBtnProductPage() {
        productReviewPage.clickBtnProduct();
        Assert.assertTrue(driver.getCurrentUrl().contains("products"),"Product page did not open!");
    }

    @Test(priority = 3)
    public void viewBtn() {
        productReviewPage.clickViewBtn();
    }

    @Test(priority = 4)
    public void verifyTheReviewPage() {
        WebElement productLogo = driver.findElement(productReviewPage.getViewProduct());
        Assert.assertTrue(productLogo.isDisplayed(),"Review logo is not displayed ");
    }
    @Test(priority = 5)
    public void verifyNameAndEmail() {
        productReviewPage.enterReviewForm("Tester", RandomUtils.generateRandomEmail());
    }
    @Test(priority = 6)
    public void verifyReviewComments(){

        productReviewPage.enterReviewComments();
    }
    @Test(priority = 7)
    public void verifyReviewBtn(){

        productReviewPage.clickReviewBtn();
    }
    @Test(priority = 8)
    public void verifyThankYou(){

        Assert.assertTrue(productReviewPage.verifyThankYou(),"Message not displayed");
    }

}
