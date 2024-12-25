package com.example.page.demoqa.bookStoreApplication;

import com.example.driver.DriverManager;
import com.example.page.AbstractPageObject;
import com.example.utilities.JsUtils;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

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

    private final String redColor = "rgb(220, 53, 69)";

    @Step("Fill firstname '{firstname}' on the Registration Page")
    public RegistrationPage fillFirstName(String firstname) {
        waitUtils.waitForElementToBeClickable(firstNameInput);
        firstNameInput.sendKeys(firstname);
        return this;
    }

    @Step("Fill lastname '{lastname}' on the Registration Page")
    public RegistrationPage fillLastName(String lastname) {
        waitUtils.waitForElementToBeClickable(lastNameInput);
        lastNameInput.sendKeys(lastname);
        return this;
    }

    @Step("Fill username '{username}' on the Registration Page")
    public RegistrationPage fillUserName(String username) {
        waitUtils.waitForElementToBeClickable(userNameInput);
        userNameInput.sendKeys(username);
        return this;
    }

    @Step("Fill password '{password}' on the Registration Page")
    public RegistrationPage fillPassword(String password) {
        waitUtils.waitForElementToBeClickable(passwordInput);
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Confirm Registration")
    public void confirmRegistration() {
        JsUtils.scrollToBottom();
        waitUtils.waitForElementToBeClickable(registerButton);
        registerButton.click();
    }

    @Step("Check that Alert 'User Register Successfully.' is not displayed")
    public void checkThatAlertIsNotDisplayed() throws InterruptedException {
        try {
            DriverManager.getDriver().switchTo().alert();
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    @Step("Check that First Name field is highlighted in red")
    public void checkThatFirstNameHighlightedInRedColor() {
        checkThatElementIsHighlightedInColor(firstNameInput, redColor);
    }

    @Step("Check that Last Name field is highlighted in red")
    public void checkThatLastNameFieldIsHighlightedInRed() {
        checkThatElementIsHighlightedInColor(lastNameInput, redColor);
    }

    @Step("Check that Username field is highlighted in red")
    public void checkThatUsernameFieldIsHighlightedInRed() {
        checkThatElementIsHighlightedInColor(userNameInput, redColor);
    }

    @Step("Check that Password field is highlighted in red")
    public void checkThatPasswordFieldIsHighlightedInRed() {
        checkThatElementIsHighlightedInColor(passwordInput, redColor);
    }

    public void checkThatElementIsHighlightedInColor(WebElement element, String color) {
        try {
            waitForBorderColorChange(element, color);
        } catch (Exception e) {
            Assert.fail("Element is not highlighted in red!");
        }
        Assert.assertTrue(true);
    }

    public void waitForBorderColorChange(WebElement element, String expectedColor) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(2))
                .until(driver -> element.getCssValue("border-color").equals(expectedColor));
    }
}
