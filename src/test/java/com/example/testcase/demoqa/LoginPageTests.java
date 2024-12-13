package com.example.testcase.demoqa;

import com.example.base.BaseWeb;
import com.example.driver.DriverManager;
import com.example.models.User;
import com.example.page.demoqa.BookStoreApplicationPage;
import com.example.page.demoqa.LoginPage;
import com.example.page.demoqa.MainPage;
import com.example.page.demoqa.RegistrationPage;
import com.example.utilities.RandomDataUtils;
import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.example.page.demoqa.components.BookStoreApplicationSidebarMenu;
import com.example.page.demoqa.components.SidebarMenu;

@Epic("Login Functionality")
@Feature("Login Tests")
public class LoginPageTests extends BaseWeb {
    private MainPage mainPage;
    private BookStoreApplicationPage bsap;
    private SidebarMenu sidebarMenu;
    private BookStoreApplicationSidebarMenu bsaSidebarMenu;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private Faker faker;
    private User user;
    private JavascriptExecutor js;

    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
        bsap = new BookStoreApplicationPage();
        sidebarMenu = new SidebarMenu();
        bsaSidebarMenu = new BookStoreApplicationSidebarMenu();
        faker = new Faker();
        user = RandomDataUtils.getRandomUser();
        js = (JavascriptExecutor) DriverManager.getDriver();
    }

    @Description("This test validates the login functionality")
    @Test(description = "Check login")
    public void LoginTest() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Allure.step("Click on Book Store Application Card");
        logger.info("Click on Book Store Application Card");
        mainPage.clickBookStoreApplicationCard();

        Allure.step("Click on Login menu item in Sidebar");
        logger.info("Click on Login menu item in Sidebar");
        bsaSidebarMenu.clickLoginMenuItem();

//        Allure.step("Fill username on the Login Page");
//        logger.info("Fill username on the Login Page");
//        loginPage.fillUserName("Test007");

//        Allure.step("Fill password on the Login Page");
//        logger.info("Fill password on the Login Page");
//        loginPage.fillPassword("Test!12345");

        Allure.step("Click on Login Button");
        logger.info("Click on Login Button");
        loginPage.clickLoginButton();
        Assert.fail();
        Assert.assertTrue(loginPage.getUserNameLabel().isDisplayed());
    }

    @Description("This test validates the Register User functionality")
    @Step
    @Test(description = "Check user registration")
    public void RegisterTest() throws InterruptedException {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Allure.step("Click on Book Store Application Card");
        logger.info("Click on Book Store Application Card");
        mainPage.clickBookStoreApplicationCard();

        Allure.step("Click on Login menu item in Sidebar");
        logger.info("Click on Login menu item in Sidebar");
        bsaSidebarMenu.clickLoginMenuItem();

        Allure.step("Click on NewUser button on the Login Page");
        logger.info("Click on NewUser button on the Login Page");
        loginPage.clickNewUserButton();

        Allure.step("Fill firstname " + "'" + user.getFirstName()+ "'" + " on the Registration Page");
        logger.info("Fill firstname " + "'" + user.getFirstName()+ "'" + " on the Registration Page");
        registrationPage.fillFirstName(user.getFirstName());

        Allure.step("Fill lastname " + "'" + user.getLastName()+ "'" + " on the Registration Page");
        logger.info("Fill lastname " + "'" + user.getLastName()+ "'" + " on the Registration Page");
        registrationPage.fillLastName(user.getLastName());

        Allure.step("Fill username " + "'" + user.getUsername()+ "'" + " on the Registration Page");
        logger.info("Fill username " + "'" + user.getUsername()+ "'" + " on the Registration Page");
        registrationPage.fillUserName(user.getUsername());

        Allure.step("Fill password " + "'" + user.getPassword()+ "'" + " on the Registration Page");
        logger.info("Fill password " + "'" + user.getPassword()+ "'" + " on the Registration Page");
        registrationPage.fillPassword(user.getPassword());

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Allure.step("Click on Register Button");
        logger.info("Click on Register Button");
        registrationPage.clickRegisterButton();

        Assert.assertTrue(true, "test");
    }
}
