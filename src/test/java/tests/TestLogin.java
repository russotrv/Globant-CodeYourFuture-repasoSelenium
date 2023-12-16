package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utils.LocalDriver;

public class TestLogin {
    private HomePage homePage;
    private String userName;

    @BeforeTest
    public void pretest() {
        LocalDriver driver = new LocalDriver();
        this.homePage = new HomePage(driver.getDriver());
    }

    @Test
    public void registerUser() {
        userName = "nombre";
        this.homePage.homeVisible();
        LoginPage loginPage = this.homePage.clickSignUpLogin();
        loginPage.visibleTitleSignUp();
        loginPage.fillInputName(userName);
        loginPage.fillInputEmail("nombre@gmail.com");

        SignUpPage signUpPage = loginPage.clickSignUpButton();

        signUpPage.validateTitleAccount();
        signUpPage.selectGenderRadio();
        signUpPage.fillPassword("password");
        signUpPage.fillDay("15");
        signUpPage.fillMonth("De");
        signUpPage.fillYear("1985");
        signUpPage.clickNewsletter();
        signUpPage.clickOffer();
        signUpPage.fillName(userName);
        signUpPage.fillLastName("apellido");
        signUpPage.fillAddress("direccion 111");
        signUpPage.fillCountry("new");
        signUpPage.fillState("provincia");
        signUpPage.fillCity("ciudad");
        signUpPage.fillZipCode("codigo postal 1818");
        signUpPage.fillMobileNumber("555-5554443");

        AccountCreatedPage accountCreatedPage = signUpPage.clickCreateAccount();
        accountCreatedPage.validateTitleAccountCreated();

        LoggedHomePage loggedHomePage  = accountCreatedPage.clickContinueButton();

        loggedHomePage.checkLogged(userName);
        AccountDeletedPage accountDeletedPage = loggedHomePage.deleteAccount();
        accountDeletedPage.validateTitleAccountDeleted();
        accountDeletedPage.clickContinueButton();
    }

    @AfterTest
    public void postTest() {
//        this.homePage.close();
    }
}