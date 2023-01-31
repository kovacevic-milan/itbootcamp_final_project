package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]")
    private WebElement signupButton;

    @FindBy(id = "email")
    private WebElement emailSignUpField;

    @FindBy(id = "password")
    private WebElement passwordSignUpField;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordSignUpField;


    public SignupPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void visitTheSignUpPage() {
        signupButton.click();
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
}
