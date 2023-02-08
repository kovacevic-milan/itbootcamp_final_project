package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthRoutesPage;
import pages.LoginPage;

import java.util.List;

public class AuthRoutesTest extends BaseTest {

    private AuthRoutesPage authRoutesPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        authRoutesPage = new AuthRoutesPage(driver, driverWait);
    }


    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
    }

    @Test
    public void visitHomeTest() {
        authRoutesPage.getUrlHome();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void visitProfileTest() {
        authRoutesPage.getUrlLogin();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void visitAdminCitiesTest() {
        authRoutesPage.getUrlAdminCities();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void visitAdminUsersTest() {
        authRoutesPage.getUrlAdminUsers();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

}
