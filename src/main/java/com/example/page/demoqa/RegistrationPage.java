package com.example.page.demoqa;

import com.example.page.AbstractPageObject;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.driver.DriverManager.waitUtils;

@Getter
public class RegistrationPage extends AbstractPageObject {
    @FindBy(id = "firstname")
    private WebElement firstNameInput;

    @FindBy(id = "lastname")
    private WebElement lastNameInput;

    @FindBy(id = "userName")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "register")
    private WebElement registerButton;

    @Step("Fill firstname on the Login Page")
    public RegistrationPage fillFirstName(String firstname) {
        waitUtils.waitForElementToBeClickable(firstNameInput);
        firstNameInput.sendKeys(firstname);
        return this;
    }

    @Step("Fill lastname on the Login Page")
    public RegistrationPage fillLastName(String lastname) {
        waitUtils.waitForElementToBeClickable(lastNameInput);
        lastNameInput.sendKeys(lastname);
        return this;
    }

    @Step("Fill username on the Login Page")
    public RegistrationPage fillUserName(String username) {
        waitUtils.waitForElementToBeClickable(userNameInput);
        userNameInput.sendKeys(username);
        return this;
    }

    @Step
    public RegistrationPage fillPassword(String password) {
        waitUtils.waitForElementToBeClickable(passwordInput);
        passwordInput.sendKeys(password);
        return this;
    }


    @Step
    public RegistrationPage clickRegisterButton() {
        waitUtils.waitForElementToBeClickable(registerButton);
        registerButton.click();
        return this;
    }
}
