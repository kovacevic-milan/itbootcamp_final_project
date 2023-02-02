package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]")
    private WebElement enterLoginPageButton;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement errorMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement wrongPasswordMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")
    private WebElement logoutButton;


    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void visitTheLoginPage() {
        enterLoginPageButton.click();
    }

    public void login(String username, String password) { //malo cekamo na ovo, sporije radi debugger
        driverWait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
        this.emailField.clear();
        this.emailField.sendKeys(username);

        this.passwordField.clear();
        this.passwordField.sendKeys(password);

        loginButton.click();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public boolean isWrongPasswordMessageDisplayed() {
        return wrongPasswordMessage.isDisplayed();
    }

    public String getEmailFieldType() {
        return emailField.getAttribute("type");
    }

    public String getPasswordFieldType(){
        return passwordField.getAttribute("type");
    }

    public void correctLogin(){
        String validEmail = "admin@admin.com";
        String validPassword = "12345";
        login(validEmail, validPassword);
    }

    public boolean isLogoutButtonDisplayed() {
        return logoutButton.isDisplayed();
    }

    public void logout(){
        logoutButton.click();
    }
}
