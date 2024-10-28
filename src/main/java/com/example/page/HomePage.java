package com.example.page;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HomePage extends AbstractPageObject{
    @FindBy(xpath =
            "//*[@id=\"ztb-container\"]/div[1]")
    private WebElement profileButton;

    @FindBy(xpath = "//*[@id=\"ztb-signout\"]")
    private WebElement logoutButton;

    @Step
    public HomePage clickProfileButton() {
        profileButton.click();
        return this;
    }

    @Step
    public HomePage clickLogoutButton() {
        logoutButton.click();
        return this;
    }
}
