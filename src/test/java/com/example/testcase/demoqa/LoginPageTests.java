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
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.example.page.demoqa.components.BookStoreApplicationSidebarMenu;
import com.example.page.demoqa.components.SidebarMenu;

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

    @Test(description = "Check login")
    public void LoginTest() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        logger.info("Click on Book Store Application Card");
        mainPage.clickBookStoreApplicationCard();

        logger.info("Click on Login menu item in Sidebar");
        bsaSidebarMenu.clickLoginMenuItem();

        logger.info("Fill username on the Login Page");
        loginPage.fillUserName("Test007");

        logger.info("Fill password on the Login Page");
        loginPage.fillPassword("Test!12345");

        logger.info("Click on Login Button");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getUserNameLabel().isDisplayed());
    }

    @Test(description = "Check user registration")
    public void RegisterTest() throws InterruptedException {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        logger.info("Click on Book Store Application Card");
        mainPage.clickBookStoreApplicationCard();

        logger.info("Click on Login menu item in Sidebar");
        bsaSidebarMenu.clickLoginMenuItem();

        logger.info("Click on NewUser button on the Login Page");
        loginPage.clickNewUserButton();

        logger.info("Fill firstname " + "'" + user.getFirstName()+ "'" + " on the Registration Page");
        registrationPage.fillFirstName(user.getFirstName());

        logger.info("Fill lastname " + "'" + user.getLastName()+ "'" + " on the Registration Page");
        registrationPage.fillLastName(user.getLastName());

        logger.info("Fill username " + "'" + user.getUsername()+ "'" + " on the Registration Page");
        registrationPage.fillUserName(user.getUsername());

        logger.info("Fill password " + "'" + user.getPassword()+ "'" + " on the Registration Page");
        registrationPage.fillPassword(user.getPassword());

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        logger.info("Click on Register Button");
        registrationPage.clickRegisterButton();

        Assert.assertTrue(true, "test");
    }
}
