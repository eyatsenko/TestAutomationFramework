package com.example.page.demoqa.bookStoreApplication;

import com.example.page.AbstractPageObject;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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

    @FindBy(xpath = "//p[@id='name']")
    private WebElement errorMessage;

    @Step("Fill username '{username}' on the Login Page")
    public LoginPage fillUserName(String username) {
        logger.info("Filling 'Username' field with value: '{}'", username);
        waitUtils.waitForElementToBeClickable(userNameInput);
        userNameInput.sendKeys(username);
        return this;
    }

    @Step("Fill password '{password}' on the Login Page")
    public LoginPage fillPassword(String password) {
        logger.info("Filling 'Password' field with value: '{}'", password);
        waitUtils.waitForElementToBeClickable(passwordInput);
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Confirm login")
    public void confirmLogin() {
        logger.info("Confirm Login");
        waitUtils.waitForElementToBeClickable(loginButton);
        loginButton.click();
    }

    @Step("Open Registration Form")
    public RegistrationPage openRegistrationForm() {
        logger.info("Open Registration Form");
        waitUtils.waitForElementToBeClickable(newUserButton);
        newUserButton.click();
        return new RegistrationPage();
    }

    @Step("Check error message")
    public void checkErrorMessage() {
        logger.info("Check error message");
        waitUtils.waitForElementToBeVisible(errorMessage);
        Assert.assertEquals(errorMessage.getText(), "Invalid username or password!");
    }
}
