package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest{

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
}
