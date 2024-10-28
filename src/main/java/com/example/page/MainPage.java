package com.example.page;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class MainPage extends AbstractPageObject {
    @FindBy(linkText = "Sign In")
    private WebElement signInLink;

    @Step
    public MainPage clickSignInLink() {
        signInLink.click();
        return this;
    }
}
