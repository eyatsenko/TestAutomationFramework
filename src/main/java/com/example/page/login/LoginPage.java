package com.example.page.login;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.example.page.AbstractPageObject;

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
    public void fillEmail(String email) {
        this.email.sendKeys(email);
    }

    @Step
    public void clickNextButton() {
        this.nextButton.click();
    }

    @Step
    public void fillPassword(String password) {
        this.password.sendKeys(password);
    }

    @Step
    public void clickSignInButton() {
        this.nextButton.click();
    }

    @Step
    public void clickProfileButton() {
        this.profileButton.click();
    }

    @Step
    public void clickLogoutButton() {
        this.logoutButton.click();
    }
}
