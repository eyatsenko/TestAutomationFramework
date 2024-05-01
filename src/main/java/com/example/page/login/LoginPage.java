package com.example.page.login;

import com.example.driver.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.example.page.AbstractPageObject;

import java.time.Duration;

public class LoginPage extends AbstractPageObject {

    @FindBy(id = "login_id")
    private WebElement email;

    @FindBy(id = "nextbtn")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath =
            "//div[@class='head-sign-in zh_innr_nav']/div[@class='zgh-user-box']/div[@class='zgh-userPanel']/img[1]")
    private WebElement profileButton;

    @FindBy(xpath = "//div[@class='zgh-userPanel active']//a[normalize-space()='Sign Out']")
    private WebElement logoutButton;


    @Step
    public LoginPage fillEmail(String email) {
        this.email.sendKeys(email);
        return this;
    }

    @Step
    public LoginPage clickNextButton() {
        this.nextButton.click();
        return this;
    }

    @Step
    public LoginPage fillPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    @Step
    public LoginPage clickSignInButton() {
        this.nextButton.click();
        return this;
    }

    @Step
    public LoginPage clickProfileButton() {
        this.profileButton.click();
        return this;
    }

    @Step
    public LoginPage clickLogoutButton() {
        this.logoutButton.click();
        return this;
    }

    @Step
    public LoginPage wait (int seconds) {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        return this;
    }
}
