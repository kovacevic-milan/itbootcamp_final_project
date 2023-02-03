package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocalePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button")
    private WebElement languageButton;

    @FindBy(xpath = "//*[@id=\"list-item-75\"]")
    private WebElement spanishLanguage;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement spanishMessage;

    @FindBy(xpath = "//*[@id=\"list-item-73\"]")
    private WebElement englishLanguage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement englishMessage;

    @FindBy(xpath = "//*[@id=\"list-item-77\"]")
    private WebElement frenchLanguage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement frenchMessage;

    public LocalePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void changeLanguageToSpanish() {
        languageButton.click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"list-item-75\"]")));
        spanishLanguage.click();

    }

    public String isLanguageChangedToSpanish() {
        String esp = spanishMessage.getText();
        return esp;
    }

    public void changeLanguageToEnglish() {
        languageButton.click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"list-item-73\"]")));
        englishLanguage.click();

    }

    public String isLanguageChangedToEnglish() {
        return englishMessage.getText();
    }

    public void changeLanguageToFrench() {
        languageButton.click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"list-item-77\"]")));
        frenchLanguage.click();

    }

    public String isLanguageChangedToFrench() {
        return frenchMessage.getText();
    }

}
