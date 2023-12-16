package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedHomePage extends BasePage{

    private MenuBar menuBar = new MenuBar(this.driver);
    public LoggedHomePage(WebDriver driver) {
        super(driver);
    }

    public void checkLogged(String text){
        WebElement logged = this.menuBar.getLoggedIn();
        this.softAssert.assertTrue(logged.isDisplayed());
        this.softAssert.assertEquals(logged.getText(), text);
    }

    public AccountDeletedPage deleteAccount(){
        WebElement deleteButton = this.menuBar.getDeleteAccount();
        this.waitClickable(deleteButton);
        this.clickElement(deleteButton);
        return new AccountDeletedPage(this.driver);
    }
}
