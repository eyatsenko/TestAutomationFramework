package com.example.page.demoqa.components;

import com.example.page.AbstractPageObject;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.driver.DriverManager.waitUtils;

@Getter
public class SidebarMenu extends AbstractPageObject {
    @FindBy(xpath = "//div[contains(@class,'left-pannel')]//div[text()='Elements']")
    private WebElement elementsMenuItem;

    @FindBy(xpath = "//div[contains(@class,'left-pannel')]//div[text()='Forms']")
    private WebElement formsMenuItem;

    @FindBy(xpath = "//div[contains(@class,'left-pannel')]//div[text()='Alerts, Frame & Windows']")
    private WebElement alertFrameWindowsMenuItem;

    @FindBy(xpath = "//div[contains(@class,'left-pannel')]//div[text()='Widgets']")
    private WebElement widgetsMenuItem;

    @FindBy(xpath = "//div[contains(@class,'left-pannel')]//div[text()='Interactions']")
    private WebElement interactionsMenuItem;

    @FindBy(xpath = "//div[contains(@class,'left-pannel')]//div[text()='Book Store Application']")
    private WebElement bookStoreApplicationMenuItem;

    @Step
    public SidebarMenu clickElementsMenuItem() {
        waitUtils.waitForElementToBeClickable(elementsMenuItem);
        elementsMenuItem.click();
        return this;
    }

    @Step
    public SidebarMenu clickFormsMenuItem() {
        waitUtils.waitForElementToBeClickable(formsMenuItem);
        formsMenuItem.click();
        return this;
    }

    @Step
    public SidebarMenu clickAlertFrameWindowsMenuItem() {
        waitUtils.waitForElementToBeClickable(alertFrameWindowsMenuItem);
        alertFrameWindowsMenuItem.click();
        return this;
    }

    @Step
    public SidebarMenu clickWidgetsMenuItem() {
        waitUtils.waitForElementToBeClickable(widgetsMenuItem);
        widgetsMenuItem.click();
        return this;
    }

    @Step
    public SidebarMenu clickInteractionsMenuItem() {
        waitUtils.waitForElementToBeClickable(interactionsMenuItem);
        interactionsMenuItem.click();
        return this;
    }

    @Step
    public SidebarMenu clickBookStoreApplicationMenuItem() {
        waitUtils.waitForElementToBeClickable(bookStoreApplicationMenuItem);
        bookStoreApplicationMenuItem.click();
        return this;
    }
}
