package com.example.testcase.demoqa;

import com.example.base.AbstractBaseTest;
import com.example.models.User;
import com.example.page.demoqa.MainPage;
import com.example.page.demoqa.alertsFrameWindows.AlertsFrameWindowsSideBarMenu;
import com.example.page.demoqa.alertsFrameWindows.AlertsPage;
import com.example.utilities.RandomDataUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsFrameWindowsTests extends AbstractBaseTest {
    private MainPage mainPage;
    private AlertsFrameWindowsSideBarMenu alertsFrameWindowsSideBarMenu;
    private AlertsPage alertsPage;
    private User user;

    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage();
        alertsFrameWindowsSideBarMenu = new AlertsFrameWindowsSideBarMenu();
        user = RandomDataUtils.getRandomUser();
    }

    @Test(description = "Check opening of the first Alert", priority = 1)
    public void openTheFirstAlertTest() {
        mainPage.openAlertFrameWindowsPage();
        alertsPage = alertsFrameWindowsSideBarMenu.clickAlertsMenuItem();
        alertsPage.openTheFirstAlertAndAccept();
    }

    @Test(description = "Check opening of the Alert with Timer", priority = 2)
    public void openTimerAlertTest() {
        mainPage.openAlertFrameWindowsPage();
        alertsPage = alertsFrameWindowsSideBarMenu.clickAlertsMenuItem();
        alertsPage.openTimerAlertAndAccept();
    }

    @Test(description = "Check opening Confirm Alert and accepting", priority = 3)
    public void openConfirmAlertAcceptTest() {
        mainPage.openAlertFrameWindowsPage();
        alertsPage = alertsFrameWindowsSideBarMenu.clickAlertsMenuItem();
        alertsPage.openConfirmAlertAndAccept();
        alertsPage.checkThatConfirmAlertHasBeenAccepted();
    }

    @Test(description = "Check opening Confirm Alert and dismissing", priority = 4)
    public void openConfirmAlertDismissTest() {
        mainPage.openAlertFrameWindowsPage();
        alertsPage = alertsFrameWindowsSideBarMenu.clickAlertsMenuItem();
        alertsPage.openConfirmAlertAndDismiss();
        alertsPage.checkThatConfirmAlertHasBeenDismissed();
    }

    @Test(description = "Check opening Prompt Alert and sending a value", priority = 5)
    public void openPromptAlertTest() {
        mainPage.openAlertFrameWindowsPage();
        alertsPage = alertsFrameWindowsSideBarMenu.clickAlertsMenuItem();
        alertsPage.openPromptAlertAndSendValue("Test 123");
        alertsPage.checkThatEnteredTextIsDisplayed("Test 123");
    }
}
