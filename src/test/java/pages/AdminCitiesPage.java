package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage {

    Faker faker = new Faker();

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/button[2]")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button")
    private WebElement createNewCityButton;

    @FindBy(id = "name")
    private WebElement nameOfTheCityInput;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div[3]/button[2]")
    private WebElement confirmCreateButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement messageTownSaved;

    @FindBy(xpath = "//*[@id=\"edit\"]/span")
    private WebElement editButton;

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement editTextField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement editSavedMessage;

    @FindBy(className = "btnSave")
    private WebElement saveEditButton;

    @FindBy(id = "search")
    private WebElement inputSearch;

    @FindBy(className = "text-left")
    private WebElement searchResults;

    @FindBy(className = "v-btn__content")
    private WebElement deleteButton;

    String cityName = faker.address().city();


    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public boolean logoutButtonIsVisible() {
        return this.logoutButton.isDisplayed();

    }

    public boolean isMessageTownCreatedDisplayed() {
        return this.messageTownSaved.isDisplayed();
    }

    public void enterAdminCitiesPage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
    }

    public void logoutAdminCities() {
        logoutButton.click();
    }

    public void createNewCityMethod() {
        this.createNewCityButton.click();
        this.nameOfTheCityInput.click();
        this.nameOfTheCityInput.sendKeys(cityName);
        this.confirmCreateButton.click();
    }

    public void editCreatedCityMethod() {
        this.editButton.click();
        this.editTextField.click();
        this.editTextField.sendKeys(Keys.CONTROL + "a");
        this.editTextField.sendKeys(Keys.DELETE);
        this.editTextField.sendKeys(cityName + " - edited");
        saveEditButton.click();
    }

    public boolean isEditSavedMessageDisplayed() {
        return this.editSavedMessage.isDisplayed();

    }

    public void searchForCities() {
        this.inputSearch.click();
        this.inputSearch.sendKeys(cityName + " - edited");

    }

    public boolean isSearchedCityVisible() {
        return searchResults.isDisplayed();
    }

    public void deleteCities() {

    }

}
