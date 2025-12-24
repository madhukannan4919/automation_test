package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrandProductPage extends BasePage {

    public BrandProductPage(WebDriver driver){super((driver));}

    private By homepageLogo =By .xpath("//div[@class='logo pull-left']");
    private By btnProduct = By.xpath("//a[@href='/products']");
    private By btnBrand = By.xpath("//h2[normalize-space()='Brands']");

    @FindBy(xpath = "//a[@href='/brand_products/Polo']")
    private WebElement btnBrand1;

    @FindBy(xpath = "//a[@href='/brand_products/Allen Solly Junior']")
    private WebElement btnBrand2;


    public void launchUrl() {
        launch("https://automationexercise.com");
    }

    public By getHomepageLogo() {
        return homepageLogo;
    }

    public void clickBtnProduct(){
        driver.findElement(btnProduct).click();
    }

    public void ClickBtnBrand1(){
        waitForElementVisible(btnBrand1);
        btnBrand1.click();
    }

    public By isBrandsTextDisplayed() {
        return btnBrand;
    }

    public void ClickBtnBrand2(){
        waitForElementVisible(btnBrand2);
        btnBrand2.click();
    }
}
