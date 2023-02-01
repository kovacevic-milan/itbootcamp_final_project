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
        signupPage.visitTheSignUpPage();
    }

    @Test
    public void isSignupPresentedInUrl() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test
    public void isSignUpFieldTypeCorrect() {
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

    @Test
    public void userAlreadyExist() {
        signupPage.existingUserSignup();
        Assert.assertTrue(signupPage.isErrorEmailDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }


    //problemi. ovde sam stao
    @Test
    public void isVerifyMessageDisplayedTest() {
        signupPage.validSignUp();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]")));
        Assert.assertTrue(signupPage.isVerifyMessageDisplayed());
    }
}
