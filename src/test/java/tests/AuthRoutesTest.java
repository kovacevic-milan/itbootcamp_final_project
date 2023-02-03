package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AuthRoutesTest extends BaseTest{


    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
    }

    @Test
    public void visitHomeTest(){
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        driverWait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void visitProfileTest(){
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        driverWait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void visitAdminCitiesTest(){
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        driverWait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void visitAdminUsersTest(){
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        driverWait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

}
