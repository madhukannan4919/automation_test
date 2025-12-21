package base;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.ProductOrderedPage;

public class BaseTest {

    protected WebDriver driver;

    public ProductOrderedPage productOrderedPage;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.initDriver("chrome");

        productOrderedPage = new ProductOrderedPage(driver);
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }

}