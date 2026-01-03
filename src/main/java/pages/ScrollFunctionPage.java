package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScrollFunctionPage extends BasePage {

    public ScrollFunctionPage(WebDriver driver){super((driver));}

    private By homepageLogo = By.xpath("//div[@class='logo pull-left']");

    @FindBy(xpath = "//h2[normalize-space()='Subscription']")
    private WebElement subscriptionText;

    @FindBy(xpath = "//i[@class='fa fa-angle-up']")
    private WebElement upArrowBtn;


    public void launchUrl() {
        launch("https://automationexercise.com");
    }

    public By getHomepageLogo() {
        return homepageLogo;
    }

    public void scrollToBottomOfPage() {
        scrollToPageEnd();
    }

    public boolean SubscriptionVisible() {
        return subscriptionText.isDisplayed();
    }

    public void clickUpArrowBtn(){
        upArrowBtn.click();
    }


}
