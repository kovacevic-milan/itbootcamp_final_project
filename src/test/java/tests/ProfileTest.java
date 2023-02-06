package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {

    Faker faker = new Faker();

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        profilePage.signup();
        profilePage.enterMyProfile();

    }

    @Test
    public void editAccountTest() {
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().cellPhone();
        String city = "Addieville";
        String country = faker.country().name();
        String twitter = "https://twitter.com/" + faker.name().firstName().toLowerCase();
        String github = "https://github.com/" + faker.name().firstName().toLowerCase();


        profilePage.editProfile(name, phone, country, twitter, github, city );

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")));
        Assert.assertTrue(profilePage.isMessageVisible());

        Assert.assertEquals(profilePage.getNameValue(), name );
        Assert.assertEquals(profilePage.getPhoneValue(), phone);
        Assert.assertEquals(profilePage.getCityValue(), city);
        Assert.assertEquals(profilePage.getCoutryValue(), country);
        Assert.assertEquals(profilePage.getTwitterValue(), twitter);
        Assert.assertEquals(profilePage.getGithubValue(), github);
    }

}
