package com.example.page.demoqa;

import com.example.page.AbstractPageObject;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.driver.DriverManager.waitUtils;

@Getter
public class LoginPage extends AbstractPageObject {
    @FindBy(id = "userName")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(id = "newUser")
    private WebElement newUserButton;

    @FindBy(xpath = "//label[@id='userName-value']")
    private WebElement userNameLabel;

    @Step("Fill password on the Login Page")
    public LoginPage fillUserName(String username) {
        waitUtils.waitForElementToBeClickable(userNameInput);
        userNameInput.sendKeys(username);
        return this;
    }

    @Step
    public LoginPage fillPassword(String password) {
        waitUtils.waitForElementToBeClickable(passwordInput);
        passwordInput.sendKeys(password);
        return this;
    }

    @Step
    public LoginPage clickLoginButton() {
        waitUtils.waitForElementToBeClickable(loginButton);
        loginButton.click();
        return this;
    }

    @Step
    public LoginPage clickNewUserButton() {
        waitUtils.waitForElementToBeClickable(newUserButton);
        newUserButton.click();
        return this;
    }
}
