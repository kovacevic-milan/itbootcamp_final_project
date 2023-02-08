package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminCitiesPage;
import pages.LoginPage;

public class AdminCitiesTest extends BaseTest {

    private LoginPage loginPage;
    private AdminCitiesPage adminCitiesPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, driverWait);
        adminCitiesPage = new AdminCitiesPage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
    }

    @Test
    public void urlAndLogoutButtonTest() {
        loginPage.visitTheLoginPage();
        loginPage.correctLogin();
        adminCitiesPage.enterAdminCitiesPage();
        driverWait.until(ExpectedConditions.urlContains("/admin/cities"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button[2]")));
        Assert.assertTrue(adminCitiesPage.logoutButtonIsVisible());

    }

    @Test
    public void isMessageDisplayedWhenTownCrated() throws InterruptedException {
        loginPage.visitTheLoginPage();
        loginPage.correctLogin();
        adminCitiesPage.enterAdminCitiesPage();
        adminCitiesPage.createNewCityMethod();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
        Assert.assertTrue(adminCitiesPage.isMessageTownCreatedDisplayed());
    }

    @Test
    public void isMessageDisplayedWhenTownEdited() {
        loginPage.visitTheLoginPage();
        loginPage.correctLogin();
        adminCitiesPage.enterAdminCitiesPage();
        adminCitiesPage.editCreatedCityMethod();
        Assert.assertTrue(adminCitiesPage.isEditSavedMessageDisplayed());
    }

    @Test
    public void searchCitiesTest() {
        loginPage.visitTheLoginPage();
        loginPage.correctLogin();
        adminCitiesPage.enterAdminCitiesPage();
        adminCitiesPage.searchForCities();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-left")));
        Assert.assertTrue(adminCitiesPage.isSearchedCityVisible());
    }

    @Test(priority = 5)
    public void isCitiDeleted() {
        loginPage.visitTheLoginPage();
        loginPage.correctLogin();
        adminCitiesPage.enterAdminCitiesPage();
        adminCitiesPage.searchForCities();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-left")));
        adminCitiesPage.deleteCities();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
        Assert.assertTrue(adminCitiesPage.isCityDeletedMessageVisible());
    }

    @AfterMethod
    public void afterMethod() {
        adminCitiesPage.logoutAdminCities();
    }

}
