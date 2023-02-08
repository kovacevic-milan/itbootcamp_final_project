package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

    Faker faker = new Faker();

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]")
    private WebElement myProfileButton;

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement nameEditField;

    @FindBy(id = "phone")
    private WebElement phoneEditField;

    @FindBy(id = "city")
    private WebElement cityEditField;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "email")
    private WebElement emailSignUpField;

    @FindBy(id = "password")
    private WebElement passwordSignUpField;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordSignUpField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button")
    private WebElement signUpButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div/div[1]")
    private WebElement verifyMessageToClose;

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div/div[3]/button")
    private WebElement closeVerifyMessage;

    @FindBy(id = "country")
    private WebElement countryField;

    @FindBy(id = "urlTwitter")
    private WebElement twitterField;

    @FindBy(id = "urlGitHub")
    private WebElement gitHubField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement messageSuccess;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button")
    private WebElement saveButton;


    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void enterMyProfile() {
        myProfileButton.click();
    }

    public void signup() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]")).click();
        this.name.sendKeys(faker.name().fullName());
        this.emailSignUpField.sendKeys(faker.internet().emailAddress());
        this.passwordSignUpField.sendKeys("sifra");
        this.confirmPasswordSignUpField.sendKeys("sifra");
        this.signUpButton.click();
        closeVerifyMessage.click();
    }


    public void editName(String name) {
        nameEditField.click();
        nameEditField.sendKeys(Keys.CONTROL + "a");
        nameEditField.sendKeys(Keys.ENTER);
        nameEditField.sendKeys(name);

    }

    public void editPhone(String phone) {
        phoneEditField.click();
        phoneEditField.clear();
        phoneEditField.sendKeys(phone);

    }

    public void editCity(String city) {
        cityEditField.click();
        cityEditField.sendKeys(Keys.CONTROL + "a");
        cityEditField.sendKeys(Keys.DELETE);
        cityEditField.sendKeys(city);
        cityEditField.sendKeys(Keys.TAB);
    }

    public void editCountry(String country) {
        countryField.click();
        countryField.sendKeys(country);
    }

    public void editTwitter(String twitter) {
        twitterField.click();
        twitterField.sendKeys(twitter);
    }

    public void editGitHub(String github) {
        gitHubField.click();
        gitHubField.sendKeys(github);
    }

    public boolean isMessageVisible() {
        return messageSuccess.isDisplayed();
    }

    public void clickSave() {
        saveButton.click();
    }

    public void editProfile(String name, String phone, String country, String twitter, String github, String city) {
        editName(name);
        editPhone(phone);
        editCity(city);
        editCountry(country);
        editTwitter(twitter);
        editGitHub(github);
        clickSave();
    }


    public String getNameValue() {
        return nameEditField.getAttribute("value");
    }

    public String getPhoneValue() {
        return phoneEditField.getAttribute("value");
    }

    public String getCityValue() {
        return cityEditField.getAttribute("value");
    }

    public String getCountryValue() {
        return countryField.getAttribute("value");
    }

    public String getTwitterValue(){
        return twitterField.getAttribute("value");
    }

    public String getGithubValue(){
        return gitHubField.getAttribute("value");
    }

}
