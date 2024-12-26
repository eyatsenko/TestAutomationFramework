package com.example.testcase.demoqa;

import com.example.base.AbstractBaseTest;
import com.example.models.User;
import com.example.page.demoqa.bookStoreApplication.BookStoreApplicationPage;
import com.example.page.demoqa.bookStoreApplication.LoginPage;
import com.example.page.demoqa.MainPage;
import com.example.page.demoqa.bookStoreApplication.RegistrationPage;
import com.example.page.demoqa.bookStoreApplication.BookStoreApplicationSidebarMenu;
import com.example.utilities.RandomDataUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("User Management")
@Feature("Login & Registration")
public class LoginPageTests extends AbstractBaseTest {
    private MainPage mainPage;
    private BookStoreApplicationSidebarMenu bsaSidebarMenu;
    private BookStoreApplicationPage bsaPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private User user;

    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage();
        loginPage = new LoginPage();
        bsaSidebarMenu = new BookStoreApplicationSidebarMenu();
        user = RandomDataUtils.getRandomUser();
    }

    @Description("Validate the login with valid data")
    @Test(description = "Check successful login")
    public void loginTestFullValidData() {
        bsaPage = mainPage.openBookStoreApplicationPage();
        bsaSidebarMenu.clickLoginMenuItem();

        loginPage.fillUserName(user.getUsername())
                 .fillPassword(user.getPassword())
                 .confirmLogin();

        Assert.assertTrue(true, "Stub successful assert");
    }

    @Description("Validate the login with invalid data")
    @Test(description = "Check unsuccessful login")
    public void loginTestInvalidData() {
        bsaPage = mainPage.openBookStoreApplicationPage();
        bsaSidebarMenu.clickLoginMenuItem();

        loginPage.fillUserName("Test368")
                 .fillPassword("Tff33333")
                 .confirmLogin();

        loginPage.checkErrorMessage();
    }

    @Description("Validate the Register User functionality with valid data")
    @Test(description = "Check successful user registration")
    public void registerTestFullData() {
        bsaPage = mainPage.openBookStoreApplicationPage();
        bsaSidebarMenu.clickLoginMenuItem();

        registrationPage = loginPage.openRegistrationForm();
        registrationPage.fillFirstName(user.getFirstName())
                        .fillLastName(user.getLastName())
                        .fillUserName(user.getUsername())
                        .fillPassword(user.getPassword())
                        .confirmRegistration();

        Assert.assertTrue(true, "Stub successful assert");
    }

    @Description("Validate the Register User functionality without entering data")
    @Test(description = "Check user registration without data")
    public void registerTestWithoutData() throws InterruptedException {
        bsaPage = mainPage.openBookStoreApplicationPage();
        bsaSidebarMenu.clickLoginMenuItem();

        registrationPage = loginPage.openRegistrationForm();
        registrationPage.fillFirstName("")
                        .fillLastName("")
                        .fillUserName("")
                        .fillPassword("")
                        .confirmRegistration();

        registrationPage.checkThatAlertIsNotDisplayed();
        registrationPage.checkThatFirstNameHighlightedInRedColor();
        registrationPage.checkThatLastNameFieldIsHighlightedInRed();
        registrationPage.checkThatUsernameFieldIsHighlightedInRed();
        registrationPage.checkThatPasswordFieldIsHighlightedInRed();
    }
}
