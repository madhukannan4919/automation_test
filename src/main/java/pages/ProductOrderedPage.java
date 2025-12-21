package pages;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.RandomUtils;

import java.time.Duration;
import java.util.List;

public class ProductOrderedPage extends BasePage {

    public ProductOrderedPage(WebDriver driver) {
        super(driver);
    }

//   i am changed this code
    private By homepageLogo = By.xpath("//div[@class='logo pull-left']");
    private By btnProduct = By.xpath("//a[@href='/products']");
    private By searchBoxProduct = By.id("search_product");

    @FindBy(xpath = "//button[@id='submit_search']")
    protected WebElement btnSearch;

    @FindBy(xpath = "//button[normalize-space()='Continue Shopping']")
    private WebElement btnContinueShop;

    @FindBy(xpath = "//a[normalize-space()='Cart']//i[@class='fa fa-shopping-cart']")
    private WebElement btnViewCart;

    @FindBy(xpath = "//a[normalize-space()='Proceed To Checkout']")
    private WebElement btnProceedToCart;

    @FindBy(xpath = "//u[normalize-space()='Register / Login']")
    private WebElement btnRegister;

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement txtName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement txtEmail;

    @FindBy(xpath = "//button[normalize-space()='Signup']")
    private WebElement btnSubmitLogin;

    // Register Page Elements
    @FindBy(id = "id_gender1")
    private WebElement gender;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "first_name")
    private WebElement firstName;

    @FindBy(id = "last_name")
    private WebElement lastName;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "address1")
    private WebElement address1;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "zipcode")
    private WebElement zipcode;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumber;

    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//a[normalize-space()='Place Order']")
    private WebElement placeOrderButton;

    @FindBy(name = "name_on_card")
    private WebElement nameOnCard;

    @FindBy(name = "card_number")
    private WebElement cardNumber;

    @FindBy(name = "cvc")
    private WebElement cvc;

    @FindBy(xpath = "//input[@class='form-control card-expiry-month']")
    private WebElement expiryMonth;

    @FindBy(xpath = "//input[@placeholder='YYYY']")
    private WebElement expiryYear;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(xpath = "//b[normalize-space()='Order Placed!']")
    private WebElement verifyOrderPlaced;


    // Dynamic Product Xpath
    public By getProductDetails(String productName) {
        return By.xpath("//div[@class='productinfo text-center']/p[contains(text(),'" + productName + "')]");
    }

    public void launchUrl() {
        launch("https://automationexercise.com");
    }

    public By getHomepageLogo() {
        return homepageLogo;
    }

    public void clickBtnProduct() {
        driver.findElement(btnProduct).click();
    }

    public void searchProduct(String strProductName) {
        driver.findElement(searchBoxProduct).sendKeys(strProductName);
        btnSearch.click();
    }

    public void addProductAndMoveToCart() {

        List<WebElement> products = driver.findElements(
                By.xpath("//div[@class='product-image-wrapper']")
        );

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 2 && i < products.size(); i++) {

            js.executeScript("document.querySelectorAll('iframe[id^=\"aswift_\"]').forEach(e => e.remove());");
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", products.get(i));

            WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//div[@class='product-image-wrapper'])[" + (i + 1) + "]//a[contains(text(),'Add to cart')]")
            ));

            js.executeScript("arguments[0].click();", addBtn);

            wait.until(ExpectedConditions.elementToBeClickable(btnContinueShop)).click();
        }
        btnViewCart.click();
    }

    public void btnClickProceedToCart() {
        btnProceedToCart.click();
    }

    public void clickBtnRegister() {
        btnRegister.click();
    }

    public void enterEmailAndName(String strName, String strEmail) {
        txtName.sendKeys(strName);
        txtEmail.sendKeys(strEmail);
        btnSubmitLogin.click();
    }

    public void enterFormForRegister() {
        gender.click();
        password.sendKeys("Test@123");
        firstName.sendKeys("Tester");
        lastName.sendKeys("Smoke");
        company.sendKeys("ABC_PVT_Ltd");
        address1.sendKeys("Chennai");
        state.sendKeys("TamilNadu");
        city.sendKeys("Chennai");
        zipcode.sendKeys("600097");
        mobileNumber.sendKeys(RandomUtils.generateRandomIndianPhoneNumber());
        createAccountButton.click();
        moveToElement(continueButton);
        continueButton.click();

        waitForElementVisible(btnViewCart).click();
    }

    public void placeOrderAndFillCardDetails() {
        waitForElementVisible(btnProceedToCart).click();
        placeOrderButton.click();
        nameOnCard.sendKeys("Tester");
        cardNumber.sendKeys("123456789123456");
        cvc.sendKeys("345");
        expiryMonth.sendKeys("07");
        expiryYear.sendKeys("2029");
        moveToElement(submitButton);
        submitButton.click();
    }

    public boolean verifyOrderPlaced() {
        waitForElementVisible(verifyOrderPlaced);
        return verifyOrderPlaced.isDisplayed();
    }
}
