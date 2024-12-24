package com.example.page.demoqa.elements;

import com.example.page.AbstractPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.driver.DriverManager.waitUtils;

public class TextBoxPage extends AbstractPageObject {
    @FindBy(id = "userName")
    private WebElement fullNameTextBox;

    @FindBy(id = "userEmail")
    private WebElement userEmailField;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressField;

    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressField;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @Step("Fill Full Name field with value: '{fullName}'")
    public TextBoxPage fillFullName(String fullName) {
        logger.info("Fill Full Name field with value: '{fullName}'");
        waitUtils.waitForElementToBeClickable(userEmailField);
        userEmailField.sendKeys(fullName);
        return this;
    }
}
