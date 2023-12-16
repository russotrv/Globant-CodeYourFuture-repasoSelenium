package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MenuBar extends BasePage{
    @FindBy(css = ".shop-menu ul li")
    private List<WebElement> elementos;

    public MenuBar(WebDriver driver) {
        super(driver);
    }

    public WebElement getHome() {
        return this.elementos.get(0);
    }

    public WebElement getSignUpLogin() {
        return this.elementos.get(3);
    }

    //cuando se crea la cuenta el elemento 9 es "logged in as userName"
    public WebElement getLoggedIn() { return this.elementos.get(9);}

    public WebElement getDeleteAccount(){ return this.elementos.get(4);}
    public void clickSignUpLogin() {
        this.waitClickable(this.getSignUpLogin());
        this.clickElement(this.getSignUpLogin());
    }

}