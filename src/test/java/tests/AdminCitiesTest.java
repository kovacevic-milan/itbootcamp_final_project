package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest {

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        loginPage.visitTheLoginPage();
        loginPage.login("admin@admin.com", "12345");
       // adminCitiesPage.enterAdminCitiesPage();
        //driverWait.until(ExpectedConditions.urlContains("/admin/cities"));
    }

    @Test
    public void urlAndLogoutButtonTest() {
        adminCitiesPage.enterAdminCitiesPage();
        driverWait.until(ExpectedConditions.urlContains("/admin/cities"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button[2]")));
        Assert.assertTrue(adminCitiesPage.logoutButtonIsVisible());
        adminCitiesPage.logoutAdminCities();
    }

    @Test
    public void isMessageDisplayedWhenTownCrated() throws InterruptedException {
        adminCitiesPage.enterAdminCitiesPage();
        adminCitiesPage.createNewCityMethod();
        Assert.assertTrue(adminCitiesPage.isMessageTownCreatedDisplayed());
        Thread.sleep(3000);
        adminCitiesPage.logoutAdminCities();
    }

    @Test
    public void isMessageDisplayedWhenTownEdited() {
        adminCitiesPage.enterAdminCitiesPage();
        adminCitiesPage.editCreatedCityMethod();
        Assert.assertTrue(adminCitiesPage.isEditSavedMessageDisplayed());
        adminCitiesPage.logoutAdminCities();
    }

    @Test
    public void searchCitiesTest() {
        adminCitiesPage.enterAdminCitiesPage();
        adminCitiesPage.searchForCities();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-left")));
        Assert.assertTrue(adminCitiesPage.isSearchedCityVisible());
        adminCitiesPage.logoutAdminCities();

    }


}
