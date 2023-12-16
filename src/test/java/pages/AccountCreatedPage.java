package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage{

    @FindBy(css = ".title")
    private WebElement titleAccountCreated;

    @FindBy(css = "[data-qa=\"continue-button\"]")
    private WebElement continueButton;

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public void validateTitleAccountCreated() {
        this.softAssert.assertTrue(this.titleAccountCreated.isDisplayed());
        this.softAssert.assertEquals(this.titleAccountCreated.getText(), "Account Created");
    }

    public LoggedHomePage clickContinueButton(){
        this.waitClickable(this.continueButton);
        this.clickElement(this.continueButton);
        return new LoggedHomePage(this.driver);
    }
}
