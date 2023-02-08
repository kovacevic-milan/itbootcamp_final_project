package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;
import java.util.List;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait driverWait;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver.", "D:\\chromedriver\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://vue-demo.daniel-avellaneda.com/");
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
