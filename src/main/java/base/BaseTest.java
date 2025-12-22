package base;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.ProductOrderedPage;
import pages.ProductReviewPage;

public class BaseTest {

    protected WebDriver driver;

    public ProductOrderedPage productOrderedPage;
    public ProductReviewPage  productReviewPage;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.initDriver("chrome");

        productOrderedPage = new ProductOrderedPage(driver);
        productReviewPage =new ProductReviewPage(driver);
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }


}