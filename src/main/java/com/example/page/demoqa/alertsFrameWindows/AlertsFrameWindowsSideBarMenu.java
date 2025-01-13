package com.example.page.demoqa.alertsFrameWindows;

import com.example.page.demoqa.components.SidebarMenu;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.driver.DriverManager.waitUtils;

@SuppressWarnings("unused")
public class AlertsFrameWindowsSideBarMenu extends SidebarMenu {
    @FindBy(xpath = "//span[normalize-space()='Alerts']")
    private WebElement alertsMenuItem;

    @Step("Click on 'Alerts' item in Sidebar")
    public AlertsPage clickAlertsMenuItem() {
        logger.info("Click on 'Alerts' item in Sidebar");
        waitUtils.waitForElementToBeClickable(alertsMenuItem);
        alertsMenuItem.click();
        return new AlertsPage();
    }
}