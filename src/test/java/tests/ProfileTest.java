package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LocalePage;
import pages.ProfilePage;

public class ProfileTest extends BaseTest {

    private ProfilePage profilePage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        profilePage = new ProfilePage(driver, driverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        profilePage.signup();
        profilePage.enterMyProfile();

    }

    Faker faker = new Faker();

    @Test
    public void editAccountTest() {
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().cellPhone();
        String city = "Bucaramanga";
        String country = faker.country().name();
        String twitter = "https://twitter.com/" + faker.name().firstName().toLowerCase();
        String github = "https://github.com/" + faker.name().firstName().toLowerCase();

        profilePage.editProfile(name, phone, country, twitter, github, city);

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")));
        Assert.assertTrue(profilePage.isMessageVisible());

        Assert.assertEquals(profilePage.getNameValue(), name);
        Assert.assertEquals(profilePage.getPhoneValue(), phone);
        Assert.assertEquals(profilePage.getCityValue(), city);
        Assert.assertEquals(profilePage.getCountryValue(), country);
        Assert.assertEquals(profilePage.getTwitterValue(), twitter);
        Assert.assertEquals(profilePage.getGithubValue(), github);
    }

}
