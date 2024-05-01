package com.example.testcase;

import com.example.base.BaseWeb;
import com.example.driver.DriverManager;
import com.example.page.MainPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.page.login.LoginPage;

import java.time.Duration;

public class Example extends BaseWeb {
    private static final Logger logger = LoggerFactory.getLogger(Example.class);

    @Test(dataProvider = "testData", description = "Check login")
    public static void LoginTest(String username, String password) {
        var mainPage = new MainPage();
        logger.info("Click on Sign in Link");
        mainPage.clickSignInLink();

        var loginPage = new LoginPage();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Enter email");
        loginPage.fillEmail(username);

        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Click on next button");
        loginPage.clickNextButton();

        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Enter password");
        loginPage.fillPassword(password);

        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Click on Sign in button");
        loginPage.clickSignInButton();

        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Click on Profile button");
        loginPage.clickProfileButton();

        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Click on Logout button");
        loginPage.clickLogoutButton();
    }

    @DataProvider(name = "testData")
    public String[][] getTestData() {
        return new String[][]{
                {"eduardyacenko@gmail.com", "Apriorit!1672"}
        };
    }
}
