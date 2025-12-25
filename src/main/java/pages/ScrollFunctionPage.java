package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScrollFunctionPage extends BasePage {

    public ScrollFunctionPage(WebDriver driver){super((driver));}

    private By homepageLogo = By.xpath("//div[@class='logo pull-left']");


    public void launchUrl() {
        launch("https://automationexercise.com");
    }

    public By getHomepageLogo() {

        return homepageLogo;
    }
}
