package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrandProductPageTest extends BaseTest {

    @Test(priority = 1)
    public void verifyTheWebsiteLaunch() {
        brandProductPage.launchUrl();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("automationexercise"), "Incorrect Url loaded!");

        WebElement homeLogo = driver.findElement(brandProductPage.getHomepageLogo());
        Assert.assertTrue(homeLogo.isDisplayed(), "Home logo is not displayed ");
    }

    @Test(priority = 2)
    public void clickBtnProductPage() {
        brandProductPage.clickBtnProduct();
        Assert.assertTrue(driver.getCurrentUrl().contains("products"), "Product page did not open!");
    }

    @Test(priority = 3)
    public void verifyBrandsText() {
        WebElement btnBrand = driver.findElement(brandProductPage.isBrandsTextDisplayed());
        Assert.assertTrue(btnBrand.isDisplayed(),"Brand name is not displayed ");
    }

    @Test(priority = 4)
    public void clickBtnBrand1(){
        brandProductPage.ClickBtnBrand1();
        Assert.assertTrue(driver.getCurrentUrl().contains("Polo"),"Brand is not loaded!");
    }

    @Test(priority = 5)
    public void clickBtnBrand2(){
        brandProductPage.ClickBtnBrand2();
        Assert.assertTrue(driver.getCurrentUrl().contains("Allen"),"Brand is not loaded!");
    }

}
