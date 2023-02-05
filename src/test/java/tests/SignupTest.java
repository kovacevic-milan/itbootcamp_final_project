package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest {

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
       // signupPage.visitTheSignUpPage();
    }

    @Test
    public void isSignupPresentedInUrl() {
        signupPage.visitTheSignUpPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test
    public void isSignUpFieldTypeCorrect() {
        signupPage.visitTheSignUpPage();
        String emailTypeExpected = "email";
        String passwordTypeExpected = "password";
        String confirmPasswordTypeExpected = "password";

        String emailTypeActual = signupPage.getEmailSignUpFieldType();
        String passwordTypeActual = signupPage.getPasswordSignUpFieldType();
        String confirmPasswordTypeActual = signupPage.getConfirmPasswordSignUpFieldType();

        Assert.assertEquals(emailTypeActual, emailTypeExpected);
        Assert.assertEquals(passwordTypeActual, passwordTypeExpected);
        Assert.assertEquals(confirmPasswordTypeActual, confirmPasswordTypeExpected);
    }

    //ovaj test radi samo ssamostalno, i to zbog afterMethoda u BaseTest
    @Test (priority = 1)
    public void userAlreadyExist() {
        signupPage.visitTheSignUpPage();
        signupPage.existingUserSignup();
        Assert.assertTrue(signupPage.isErrorEmailDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }


    @Test
    public void isVerifyMessageDisplayedTest() {
        signupPage.visitTheSignUpPage();
        signupPage.validSignUp();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]")));
        Assert.assertTrue(signupPage.isVerifyMessageDisplayed());
    }
}
