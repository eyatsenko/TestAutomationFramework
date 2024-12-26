package com.example.testcase.zoho;

import com.example.base.AbstractBaseTest;
import com.example.page.zoho.HomePage;
import com.example.page.zoho.MainPage;
import com.example.utilities.LoginTestDataUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.example.page.zoho.login.LoginPage;

public class LoginTest extends AbstractBaseTest {
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
        logAndStep("Click on Sign in Link");
        mainPage.clickSignInLink();

        Assert.assertEquals(loginPage.getPageTitle(), loginPageTitle);
        logAndStep("Enter email");
        loginPage.fillEmail(username);

        logAndStep("Click on next button");
        loginPage.clickNextButton();

        logAndStep("Enter password");
        loginPage.fillPassword(password);

        logAndStep("Click on Sign in button");
        loginPage.clickSignInButton();
        Assert.assertEquals(loginPage.getPageTitle(), loginPageTitle);

        logAndStep("Click on Profile button");
        homePage.clickProfileButton();

        homePage.clickLogoutButton();
        Assert.assertEquals(mainPage.getPageTitle(), mainPageTitle);
    }
}
