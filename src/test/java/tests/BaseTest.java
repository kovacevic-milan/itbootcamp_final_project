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
    protected LoginPage loginPage;
    protected SignupPage signupPage;
    protected AdminCitiesPage adminCitiesPage;
    protected AuthRoutesPage authRoutesPage;
    protected LocalePage localePage;
    protected ProfilePage profilePage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver.", "D:\\chromedriver\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, driverWait);
        signupPage = new SignupPage(driver, driverWait);
        adminCitiesPage = new AdminCitiesPage(driver, driverWait);
        authRoutesPage = new AuthRoutesPage(driver, driverWait);
        localePage = new LocalePage(driver, driverWait);
        profilePage = new ProfilePage(driver, driverWait);


    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://vue-demo.daniel-avellaneda.com/");
    }

    @AfterMethod
    public void afterMethod(){
        List<WebElement> elements = driver.findElements(By.className(("btnLogout")));
        if (!elements.isEmpty()) {
            elements.get(0).click();
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
