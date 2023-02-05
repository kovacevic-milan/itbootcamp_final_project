package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        profilePage.signup();
        profilePage.enterMyProfile();

    }

    @Test
    public void editAccountTest() {
        profilePage.editProfile();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")));
        Assert.assertTrue(profilePage.isMessageVisible());
    }

}
