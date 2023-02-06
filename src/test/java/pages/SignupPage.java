package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage {

    Faker faker = new Faker();

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]")
    private WebElement enterSignupScreen;

    @FindBy (id = "name")
    private WebElement name;

    @FindBy(id = "email")
    private WebElement emailSignUpField;

    @FindBy(id = "password")
    private WebElement passwordSignUpField;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordSignUpField;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button")
    private WebElement signUpButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]")
    private WebElement emailAlreadyExistError;

    @FindBy (xpath = "//*[@id=\"app\"]/div[4]/div/div")
    private WebElement verifyMessage;


    public SignupPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void visitTheSignUpPage() {
        enterSignupScreen.click();
    }

    public String getEmailSignUpFieldType() {
        return emailSignUpField.getAttribute("type");
    }

    public String getPasswordSignUpFieldType() {
        return passwordSignUpField.getAttribute("type");
    }

    public String getConfirmPasswordSignUpFieldType() {
        return confirmPasswordSignUpField.getAttribute("type");
    }

    public void existingUserSignup(){
        this.name.sendKeys("Test Test");
        this.emailSignUpField.sendKeys("admin@admin.com");
        this.passwordSignUpField.sendKeys("123654");
        this.confirmPasswordSignUpField.sendKeys("123654");
        this.signUpButton.click();
    }

    public boolean isErrorEmailDisplayed() {
        return emailAlreadyExistError.isDisplayed();
    }

    public boolean isVerifyMessageDisplayed(){
        return verifyMessage.isDisplayed();
    }

    public void validSignUp (){
        this.name.sendKeys(faker.name().fullName());
        this.emailSignUpField.sendKeys(faker.internet().emailAddress());
        this.passwordSignUpField.sendKeys("milan1234");
        this.confirmPasswordSignUpField.sendKeys("milan1234");
        this.signUpButton.click();
    }
}
