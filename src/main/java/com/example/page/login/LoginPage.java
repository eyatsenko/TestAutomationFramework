package com.example.page.login;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.example.page.AbstractPageObject;

@Getter
public class LoginPage extends AbstractPageObject {

    @FindBy(id = "login_id")
    private WebElement emailField;

    @FindBy(id = "nextbtn")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath =
            "//div[@class='head-sign-in zh_innr_nav']/div[@class='zgh-user-box']/div[@class='zgh-userPanel']/img[1]")
    private WebElement profileButton;

    @FindBy(xpath = "//div[@class='zgh-userPanel active']//a[normalize-space()='Sign Out']")
    private WebElement logoutButton;


    @Step
    public LoginPage fillEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    @Step
    public LoginPage clickNextButton() {
        nextButton.click();
        return this;
    }

    @Step
    public LoginPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step
    public LoginPage clickSignInButton() {
        nextButton.click();
        return this;
    }

    @Step
    public LoginPage clickProfileButton() {
        profileButton.click();
        return this;
    }

    @Step
    public LoginPage clickLogoutButton() {
        logoutButton.click();
        return this;
    }
}
