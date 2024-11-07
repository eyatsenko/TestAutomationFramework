package com.example.page.demoqa.components;

import com.example.page.AbstractPageObject;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.driver.DriverManager.waitUtils;

@Getter
public class BookStoreApplicationSidebarMenu extends AbstractPageObject {

    @FindBy(xpath = "//span[normalize-space()='Login']")
    private WebElement loginMenuItem;

    @Step
    public BookStoreApplicationSidebarMenu clickLoginMenuItem() {
        waitUtils.waitForElementToBeClickable(loginMenuItem);
        loginMenuItem.click();
        return this;
    }
}
