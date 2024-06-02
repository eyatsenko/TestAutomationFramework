package com.example.testcase;

import com.example.base.BaseWeb;
import com.example.driver.DriverManager;
import com.example.page.MainPage;
import com.example.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.example.page.login.LoginPage;

public class Example extends BaseWeb {
    private MainPage mainPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage();
        loginPage = new LoginPage();
    }

    @Test(dataProvider = "testData", dataProviderClass = DataProvider1.class, description = "Check login")
    public void LoginTest(String username, String password) {
        logger.info("Click on Sign in Link");
        mainPage.clickSignInLink();

        Assert.assertEquals(DriverManager.getDriver().getTitle(), "Zoho Accounts");
        WaitUtils.waitForSeconds(5);
        logger.info("Enter email");
        loginPage.fillEmail(username);

        WaitUtils.waitForSeconds(5);
        logger.info("Click on next button");
        loginPage.clickNextButton();

        WaitUtils.waitForSeconds(5);
        logger.info("Enter password");
        loginPage.fillPassword(password);

        WaitUtils.waitForSeconds(5);
        logger.info("Click on Sign in button");
        loginPage.clickSignInButton();
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "Zoho Accounts");

        WaitUtils.waitForSeconds(10);
        logger.info("Click on Profile button");
        loginPage.clickProfileButton();

        WaitUtils.waitForSeconds(5);
        logger.info("Click on Logout button");
        loginPage.clickLogoutButton();
        WaitUtils.waitForSeconds(10);
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "Explore All Products | Zoho");
/*
        Using Fluent Interface Pattern:
        loginPage
                .clickSignInButton()
                .wait(5)
                .fillEmail(username)
                .wait(5)
                .clickNextButton()
                .wait(5)
                .fillPassword(password)
                .wait(5)
                .clickSignInButton()
                .wait(5)
                .clickProfileButton()
                .wait(5)
                .clickLogoutButton();
        */
    }
}
