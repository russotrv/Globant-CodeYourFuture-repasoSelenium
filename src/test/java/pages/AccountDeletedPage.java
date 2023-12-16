package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDeletedPage extends BasePage{

    @FindBy(css = "title")
    private WebElement titleAccountDeleted;

    @FindBy(css = "[data-qa=\"continue-button\"]")
    private WebElement continueButton;
    public AccountDeletedPage(WebDriver driver) {
        super(driver);
    }

    public void validateTitleAccountDeleted() {
        this.softAssert.assertTrue(this.titleAccountDeleted.isDisplayed());
        this.softAssert.assertEquals(this.titleAccountDeleted.getText(), "Account Deleted!");
    }

    public LoggedHomePage clickContinueButton(){
        this.waitClickable(this.continueButton);
        this.clickElement(this.continueButton);
        return new LoggedHomePage(this.driver);
    }


}
