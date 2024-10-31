package com.example.page.zoho;

import com.example.page.AbstractPageObject;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.driver.DriverManager.waitUtils;

@Getter
public class HomePage extends AbstractPageObject {

    @FindBy(xpath = "//*[@id=\"ztb-container\"]//*[@class=\"ztb-profile-container ztb-profile-image-pre\"]")
    private WebElement profileButton;

    @FindBy(xpath = "//*[@id=\"ztb-signout\"]")
    private WebElement logoutButton;

    @Step
    public HomePage clickProfileButton() {
        waitUtils.waitForElementToBeClickable(profileButton);
        profileButton.click();
        return this;
    }

    @Step
    public HomePage clickLogoutButton() {
        waitUtils.waitForElementToBeClickable(logoutButton);
        logoutButton.click();
        return this;
    }
}
