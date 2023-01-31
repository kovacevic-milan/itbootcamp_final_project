package tests;

import com.github.javafaker.Faker;
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
        loginPage.visitTheLoginPage();
    }

    @Test
    public void isLoginPresentedInUrl() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void isFieldTypeCorrect() {
        String emailTypeExpected = "email";
        String passwordTypeExpected = "password";

        String emailTypeActual = loginPage.getEmailFieldType();
        String passwordTypeActual = loginPage.getPasswordFieldType();

        Assert.assertEquals(emailTypeActual, emailTypeExpected);
        Assert.assertEquals(passwordTypeActual, passwordTypeExpected);
    }

    @Test
    public void isErrorDisplayedWhenUserDoesNotExist() {
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void isErrorDisplayedWhenPasswordIsWrong() {
        String validEmail = "admin@admin.com";
        String password = faker.internet().password();
        loginPage.login(validEmail, password);
        Assert.assertTrue(loginPage.isWrongPasswordMessageDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    // nekad radi, nekada ne - mozda fali waiter
    @Test
    public void isThereHomeInURLWhenLoggedIn() throws InterruptedException {
        loginPage.correctLogin();
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
        Thread.sleep(10000);
    }

    @Test
    public void isThereLogoutButton() throws InterruptedException {
        loginPage.correctLogin();
        Assert.assertTrue(loginPage.isLogoutButtonDisplayed());
        Thread.sleep(5000);
        loginPage.logout();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
        Thread.sleep(5000);
        
    }




}
