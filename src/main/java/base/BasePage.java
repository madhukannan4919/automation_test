package base;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public  class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

        public BasePage(WebDriver driver) {
            this.driver = DriverFactory.getDriver();
            PageFactory.initElements(this.driver, this);
            this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
            PageFactory.initElements(this.driver, this);
        }



        public void launch(String strUrl){
            driver.manage().deleteAllCookies();
            driver.get(strUrl);
        }

        public WebElement waitForElementVisible(WebElement element){
            return wait.until(ExpectedConditions.visibilityOf(element));

        }

        public void moveToElement(WebElement element){
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
        }


    }

