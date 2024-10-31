package com.example.page.login;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.example.page.AbstractPageObject;

import static com.example.driver.DriverManager.waitUtils;

@Getter
public class LoginPage extends AbstractPageObject {

    @FindBy(id = "login_id")
    private WebElement emailField;

    @FindBy(id = "nextbtn")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @Step
    public LoginPage fillEmail(String email) {
        waitUtils.waitForElementToBeClickable(emailField);
        emailField.sendKeys(email);
        return this;
    }

    @Step
    public LoginPage clickNextButton() {
        waitUtils.waitForElementToBeClickable(nextButton);
        nextButton.click();
        return this;
    }

    @Step
    public LoginPage fillPassword(String password) {
        waitUtils.waitForElementToBeClickable(passwordInput);
        passwordInput.sendKeys(password);
        return this;
    }

    @Step
    public LoginPage clickSignInButton() {
        waitUtils.waitForElementToBeClickable(nextButton);
        nextButton.click();
        return this;
    }
}
