package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RandomUtils;

import java.util.List;

public class ProductOrderedPageTest extends BaseTest {

    @Test(priority = 1)
    public void verifyTheWebsiteLaunch() {
        productOrderedPage.launchUrl();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("automationexercise"), "Incorrect URL loaded!");

        WebElement homeLogo = driver.findElement(productOrderedPage.getHomepageLogo());
        Assert.assertTrue(homeLogo.isDisplayed(), "Home logo is not displayed");
    }

    @Test(priority = 2)
    public void clickBtnProductPage() {
        productOrderedPage.clickBtnProduct();
        Assert.assertTrue(driver.getCurrentUrl().contains("products"), "Product page did not open!");
    }

    @Test(priority = 4)
    public void searchProduct() {
        productOrderedPage.searchProduct("Sleeveless");
        Assert.assertTrue(driver.getCurrentUrl().contains("search"), "Search did not execute!");
    }

    @Test(priority = 5)
    public void verifySearchedProduct() {
        List<WebElement> listedProducts =
                driver.findElements(productOrderedPage.getProductDetails("Sleeveless"));

        Assert.assertTrue(listedProducts.size() > 0, "No products found!");

        for (WebElement listedProduct : listedProducts) {
            System.out.println(listedProduct.getText());
        }
    }

    @Test(priority = 6)
    public void addProductToCart() {
        productOrderedPage.addProductAndMoveToCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Cart page did not open!");
    }

    @Test(priority = 7)
    public void verifyTheProceedCard() {
        productOrderedPage.btnClickProceedToCart();

    }

    @Test(priority = 8)
    public void verifyTheButtonRegister() {
        productOrderedPage.clickBtnRegister();
    }

    @Test(priority = 9)
    public void verifyTheRegister() {
        productOrderedPage.enterEmailAndName("Tester", RandomUtils.generateRandomEmail());
    }

    @Test(priority = 10)
    public void enterRegisterForm() {
        productOrderedPage.enterFormForRegister();
    }

    @Test(priority = 11)
    public void verifyAddCPaymentDetails() {
        productOrderedPage.placeOrderAndFillCardDetails();
    }

    @Test(priority = 12)
    public void verifyOrderPlaced() {
        Assert.assertTrue(productOrderedPage.verifyOrderPlaced(), "Order not placed!");
    }
}
