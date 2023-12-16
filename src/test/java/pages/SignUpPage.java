package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class SignUpPage extends BasePage{

    private int randomIndex;
    @FindBy(css = ".title:first-child")
    private WebElement titleAccountInfo;

    @FindBy(css = "#password")
    private WebElement inputPassword;

    @FindBy(css = ".radio")
    private List<WebElement> genderRadios;

    @FindBy(css = "#days")
    private WebElement selectDays;

    @FindBy(css = "#months")
    private WebElement selectMonths;

    @FindBy(css = "#years")
    private WebElement selectYears;

    //@FindBy(css = "div.container div.row div.col-sm-4.col-sm-offset-1 div.login-form form:nth-child(2) div.checkbox:nth-child(7) > label:nth-child(2)")
    @FindBy(css = "#newsletter")
    private WebElement newsletterButton;

    @FindBy(css = "#optin")
    private WebElement offerButton;

    @FindBy(css = "#first_name")
    private WebElement nameInput;

    @FindBy(css = "#last_name")
    private WebElement lastNameInput;

    @FindBy(css = "#address1")
    private WebElement addressInput;

    @FindBy(css = "#country")
    private WebElement countryInput;

    @FindBy(css = "#state")
    private WebElement stateInput;

    @FindBy(css = "#city")
    private WebElement cityInput;

    @FindBy(css = "#zipcode")
    private WebElement zipCodeInput;

    @FindBy(css = "#mobile_number")
    private WebElement mobileNumberInput;

    @FindBy(css = "[data-qa=\"create-account\"]")
    private WebElement createAccountButton;


    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void validateTitleAccount() {
        this.softAssert.assertTrue(this.titleAccountInfo.isDisplayed());
        this.softAssert.assertEquals(this.titleAccountInfo.getText(), "Enter Account Information");
    }

    public void selectGenderRadio() {
        Random random = new Random();
        randomIndex = random.nextInt(2);
        this.clickElement(this.genderRadios.get(randomIndex));
    }

    public void fillPassword(String text) {
        this.waitVisible(this.inputPassword);
        this.textToElement(this.inputPassword, text);
    }

    public void fillDay(String day) {
        this.textToElement(this.selectDays, day);
    }

    public void fillMonth(String month) {
        this.textToElement(this.selectMonths, month);
    }

    public void fillYear(String year) {
        this.textToElement(this.selectYears, year);
    }

    public void clickNewsletter(){
        this.waitClickable(newsletterButton);
        this.clickElement(newsletterButton);
    }


    public void clickOffer() {
        this.waitClickable(offerButton);
        this.clickElement(offerButton);
    }

    public void fillName(String name) {
        this.textToElement(this.nameInput, name);
    }

    public void fillLastName(String lastName) {
        this.textToElement(this.lastNameInput, lastName);
    }

    public void fillAddress(String address) {
        this.textToElement(this.addressInput, address);
    }

    public void fillCountry(String country) {
        this.textToElement(this.countryInput, country);
    }

    public void fillState(String state) {
        this.textToElement(this.stateInput, state);
    }

    public void fillCity(String city) {
        this.textToElement(this.cityInput, city);
    }

    public void fillZipCode(String zipcode) {
        this.textToElement(this.zipCodeInput, zipcode);
    }

    public void fillMobileNumber(String mobile) {
        this.textToElement(this.mobileNumberInput, mobile);
    }

    public AccountCreatedPage clickCreateAccount(){
        this.waitClickable(this.createAccountButton);
        this.clickElement(this.createAccountButton);
        return new AccountCreatedPage(this.driver);
    }
}