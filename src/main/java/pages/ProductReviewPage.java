package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends BasePage {

    public ProductReviewPage(WebDriver driver){super((driver));}


    private By homepageLogo = By.xpath("//div[@class='logo pull-left']");
    private By btnProduct = By.xpath("//a[@href='/products']");
    private By viewProduct = By.xpath("//a[normalize-space()='Write Your Review']");

    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    private WebElement viewBtn;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement name;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email ;

    @FindBy(xpath = "//textarea[@id='review']")
    private WebElement review ;

    @FindBy(xpath = "//button[@id='button-review']")
    private WebElement btnReview;

    @FindBy(xpath = "//span[normalize-space()='Thank you for your review.']")
    private WebElement verifyThankYou;


    public void launchUrl() {
        launch("https://automationexercise.com");
    }

    public By getHomepageLogo() {
        return homepageLogo;
    }
    public void clickBtnProduct() {
        driver.findElement(btnProduct).click();
    }
    public void clickViewBtn() {
        scrollToElement(viewBtn);
        moveToElement(viewBtn);
        viewBtn.click();
    }
    public By getViewProduct(){
        return viewProduct;
    }
    public void enterReviewForm(String strName, String strEmail){
        name.sendKeys(strName);
        email.sendKeys(strEmail);
    }
    public void enterReviewComments(){
        review.sendKeys("Excellent product ");
    }
    public void clickReviewBtn(){
        btnReview.click();
    }
    public boolean verifyThankYou() {
        scrollToElement(verifyThankYou);
        waitForElementVisible(verifyThankYou);
        return verifyThankYou.isDisplayed();
    }
}
