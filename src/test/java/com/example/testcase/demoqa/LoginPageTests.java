package com.example.testcase.demoqa;

import com.example.base.BaseTest;
import com.example.models.User;
import com.example.page.demoqa.LoginPage;
import com.example.page.demoqa.MainPage;
import com.example.page.demoqa.RegistrationPage;
import com.example.utilities.JsUtils;
import com.example.utilities.RandomDataUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.example.page.demoqa.components.BookStoreApplicationSidebarMenu;

@Epic("Login Functionality")
@Feature("Login Tests")
public class LoginPageTests extends BaseTest {
    private MainPage mainPage;
    private BookStoreApplicationSidebarMenu bsaSidebarMenu;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private User user;

    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
        bsaSidebarMenu = new BookStoreApplicationSidebarMenu();
        user = RandomDataUtils.getRandomUser();
    }

    @Description("This test validates the login functionality")
    @Test(description = "Check login")
    public void LoginTest() {
        JsUtils.scrollToBottom();
        logAndStep("Click on Book Store Application Card");
        mainPage.clickBookStoreApplicationCard();

        logAndStep("Click on Login menu item in Sidebar");
        bsaSidebarMenu.clickLoginMenuItem();

        logAndStep("Fill username on the Login Page");
        loginPage.fillUserName("Test007");

        logAndStep("Fill password on the Login Page");
        loginPage.fillPassword("Test!12345");

        logAndStep("Click on Login Button");
        loginPage.clickLoginButton();
        Assert.fail("Test failure");
        Assert.assertTrue(loginPage.getUserNameLabel().isDisplayed());
    }

    @Description("This test validates the Register User functionality")
    @Test(description = "Check user registration")
    public void RegisterTest() {
        JsUtils.scrollToBottom();
        logAndStep("Click on Book Store Application Card");
        mainPage.clickBookStoreApplicationCard();

        logAndStep("Click on Login menu item in Sidebar");
        bsaSidebarMenu.clickLoginMenuItem();

        logAndStep("Click on NewUser button on the Login Page");
        loginPage.clickNewUserButton();

        logAndStep("Fill firstname " + "'" + user.getFirstName()+ "'" + " on the Registration Page");
        registrationPage.fillFirstName(user.getFirstName());

        logAndStep("Fill lastname " + "'" + user.getLastName()+ "'" + " on the Registration Page");
        registrationPage.fillLastName(user.getLastName());

        logAndStep("Fill username " + "'" + user.getUsername()+ "'" + " on the Registration Page");
        registrationPage.fillUserName(user.getUsername());

        logAndStep("Fill password " + "'" + user.getPassword()+ "'" + " on the Registration Page");
        registrationPage.fillPassword(user.getPassword());

        JsUtils.scrollToBottom();

        logAndStep("Click on Register Button");
        registrationPage.clickRegisterButton();

        Assert.assertTrue(true, "test");
    }
}
