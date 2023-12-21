package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utils.LocalDriver;

public class TestLogin {
    private HomePage homePage;

    private static String userName, lastname, password, email;
    private static String day, month, year;
    private static String address, country, state, city, zipcode, mobile;

    @BeforeTest
    public void pretest() {
        LocalDriver driver = new LocalDriver();
        this.homePage = new HomePage(driver.getDriver());
    }

    @BeforeTest
    public static void cargarDatosUsuario(){
        userName = "nombre";
        password = "password";
        email = "nombre@gmail.com";
        lastname = "apellido";
        day = "21";
        month = "De";
        year = "1989";
        address = "direccion 111";
        country = "new";
        state = "provincia";
        city = "ciudad";
        zipcode = "codigo postal 1818";
        mobile = "555-5554443";
    }

    @Test
    public void registerUser() {
        cargarDatosUsuario();

        this.homePage.homeVisible();
        LoginPage loginPage = this.homePage.clickSignUpLogin();
        loginPage.visibleTitleSignUp();
        loginPage.fillInputName(userName);
        loginPage.fillInputEmail(email);

        SignUpPage signUpPage = loginPage.clickSignUpButton();

        signUpPage.validateTitleAccount();
        signUpPage.selectGenderRadio();
        signUpPage.fillPassword(password);
        signUpPage.fillDay(day);
        signUpPage.fillMonth(month);
        signUpPage.fillYear(year);
        signUpPage.clickNewsletter();
        signUpPage.clickOffer();
        signUpPage.fillName(userName);
        signUpPage.fillLastName(lastname);
        signUpPage.fillAddress(address);
        signUpPage.fillCountry(country);
        signUpPage.fillState(state);
        signUpPage.fillCity(city);
        signUpPage.fillZipCode(zipcode);
        signUpPage.fillMobileNumber(mobile);

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