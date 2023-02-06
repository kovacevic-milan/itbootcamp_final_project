package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest {

    Faker faker = new Faker();


    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
       // loginPage.visitTheLoginPage();
    }

    @Test
    public void isLoginPresentedInUrl() {
        loginPage.visitTheLoginPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void isFieldTypeCorrect() {
        loginPage.visitTheLoginPage();
        String emailTypeExpected = "email";
        String passwordTypeExpected = "password";

        String emailTypeActual = loginPage.getEmailFieldType();
        String passwordTypeActual = loginPage.getPasswordFieldType();

        Assert.assertEquals(emailTypeActual, emailTypeExpected);
        Assert.assertEquals(passwordTypeActual, passwordTypeExpected);
    }

    @Test
    public void isErrorDisplayedWhenUserDoesNotExist() {
        loginPage.visitTheLoginPage();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void isErrorDisplayedWhenPasswordIsWrong() {
        loginPage.visitTheLoginPage();
        String validEmail = "admin@admin.com";
        String password = faker.internet().password();
        loginPage.login(validEmail, password);
        Assert.assertTrue(loginPage.isWrongPasswordMessageDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }


    @Test
    public void isThereHomeInURLWhenLoggedIn() {
        loginPage.visitTheLoginPage();
        loginPage.correctLogin();
        driverWait.until(ExpectedConditions.urlContains("/home"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
        loginPage.logout();
    }

    @Test
    public void isThereLogoutButton() throws InterruptedException {
        loginPage.visitTheLoginPage();
        loginPage.correctLogin();
        Assert.assertTrue(loginPage.isLogoutButtonDisplayed());
        Thread.sleep(5000);
        loginPage.logout();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
        Thread.sleep(5000);
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }


}
