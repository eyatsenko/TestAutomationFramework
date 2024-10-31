package com.example.page.zoho;

import com.example.page.AbstractPageObject;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.driver.DriverManager.waitUtils;

@Getter
public class MainPage extends AbstractPageObject {
    @FindBy(linkText = "Sign In")
    private WebElement signInLink;

    @Step
    public MainPage clickSignInLink() {
        waitUtils.waitForElementToBeClickable(signInLink);
        signInLink.click();
        return this;
    }
}
