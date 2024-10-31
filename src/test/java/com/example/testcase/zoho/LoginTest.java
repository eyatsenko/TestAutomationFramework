package com.example.testcase.zoho;

import com.example.base.BaseWeb;
import com.example.page.zoho.HomePage;
import com.example.page.zoho.MainPage;
import com.example.utilities.LoginTestDataUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.example.page.zoho.login.LoginPage;

public class LoginTest extends BaseWeb {
    private MainPage mainPage;
    private LoginPage loginPage;
    private HomePage homePage;
    private final String loginPageTitle = "Zoho Accounts";
    private final String mainPageTitle = "Zoho | Cloud Software Suite for Businesses";

    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage();
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Test(dataProvider = "testDataJson", dataProviderClass = LoginTestDataUtils.class, description = "Check login")
    public void LoginTest(String username, String password) {
        logger.info("Click on Sign in Link");
        mainPage.clickSignInLink();

        Assert.assertEquals(loginPage.getPageTitle(), loginPageTitle);
        logger.info("Enter email");
        loginPage.fillEmail(username);

        logger.info("Click on next button");
        loginPage.clickNextButton();

        logger.info("Enter password");
        loginPage.fillPassword(password);

        logger.info("Click on Sign in button");
        loginPage.clickSignInButton();
        Assert.assertEquals(loginPage.getPageTitle(), loginPageTitle);

        logger.info("Click on Profile button");
        homePage.clickProfileButton();

        homePage.clickLogoutButton();
        Assert.assertEquals(mainPage.getPageTitle(), mainPageTitle);
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
