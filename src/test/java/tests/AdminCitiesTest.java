package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest {

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        loginPage.visitTheLoginPage();
        loginPage.correctLogin();
        adminCitiesPage.enterAdminCitiesPage();
        //driverWait.until(ExpectedConditions.urlContains("/admin/cities"));

    }

    @Test (priority = 1)
    public void urlAndLogoutButtonTest() {
        adminCitiesPage.enterAdminCitiesPage();
        driverWait.until(ExpectedConditions.urlContains("/admin/cities"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button[2]")));
        Assert.assertTrue(adminCitiesPage.logoutButtonIsVisible());
        //adminCitiesPage.logoutAdminCities();
    }

    @Test (priority = 2)
    public void isMessageDisplayedWhenTownCrated() throws InterruptedException {
        adminCitiesPage.enterAdminCitiesPage();
        adminCitiesPage.createNewCityMethod();
        Assert.assertTrue(adminCitiesPage.isMessageTownCreatedDisplayed());
        Thread.sleep(3000);
        //adminCitiesPage.logoutAdminCities();
    }

    @Test (priority = 3)
    public void isMessageDisplayedWhenTownEdited() {
        adminCitiesPage.enterAdminCitiesPage();
        adminCitiesPage.editCreatedCityMethod();
        Assert.assertTrue(adminCitiesPage.isEditSavedMessageDisplayed());
        //adminCitiesPage.logoutAdminCities();
    }

    @Test (priority = 4)
    public void searchCitiesTest() {
        adminCitiesPage.enterAdminCitiesPage();
        adminCitiesPage.searchForCities();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-left")));
        Assert.assertTrue(adminCitiesPage.isSearchedCityVisible());
        //adminCitiesPage.logoutAdminCities();

    }

    @Test (priority = 5)
    public void isCitiDeleted() {
        adminCitiesPage.enterAdminCitiesPage();
        adminCitiesPage.searchForCities();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-left")));
        adminCitiesPage.deleteCities();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
        Assert.assertTrue(adminCitiesPage.isCityDeletedMessageVisible());
       // adminCitiesPage.logoutAdminCities();
    }

}
