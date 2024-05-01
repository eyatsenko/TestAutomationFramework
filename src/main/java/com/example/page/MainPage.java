package com.example.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPageObject {
    @FindBy(linkText = "Sign in")
    private WebElement signInLink;

    @Step
    public void clickSignInLink() {
        this.signInLink.click();
    }
}
