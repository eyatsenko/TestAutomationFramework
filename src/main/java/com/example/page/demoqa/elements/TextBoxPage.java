package com.example.page.demoqa.elements;

import com.example.page.AbstractPageObject;
import com.example.utilities.JsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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

    @FindBy(id = "output")
    private WebElement outputSection;

    @FindBy(xpath = "//p[@id='name']")
    private WebElement resultName;

    @FindBy(xpath = "//p[@id='email']")
    private WebElement resultEmail;

    @FindBy(xpath = "//p[@id='currentAddress']")
    private WebElement resultCurrentAddress;

    @FindBy(xpath = "//p[@id='permanentAddress']")
    private WebElement resultPermanentAddress;

    @Step("Fill 'Full Name' field with value: {fullName}")
    public TextBoxPage fillFullName(String fullName) {
        logger.info("Fill 'Full Name' field with value: '{}'", fullName);
        waitUtils.waitForElementToBeClickable(fullNameTextBox);
        fullNameTextBox.sendKeys(fullName);
        return this;
    }

    @Step("Fill 'Email' field with value: {email}")
    public TextBoxPage fillEmail(String email) {
        logger.info("Fill 'Email' field with value: '{}'", email);
        waitUtils.waitForElementToBeClickable(userEmailField);
        userEmailField.sendKeys(email);
        return this;
    }

    @Step("Fill 'Current Address' field with value: {currentAddress}")
    public TextBoxPage fillCurrentAddress(String currentAddress) {
        logger.info("Fill 'Current Address' field with value: '{}'", currentAddress);
        waitUtils.waitForElementToBeClickable(currentAddressField);
        currentAddressField.sendKeys(currentAddress);
        return this;
    }

    @Step("Fill 'Permanent Address' field with value: {permanentAddress}")
    public TextBoxPage fillPermanentAddress(String permanentAddress) {
        logger.info("Fill 'Permanent Address' field with value: '{}'", permanentAddress);
        waitUtils.waitForElementToBeClickable(permanentAddressField);
        permanentAddressField.sendKeys(permanentAddress);
        return this;
    }

    @Step("Submit data")
    public void submitData() {
        logger.info("Submit data");
        JsUtils.scrollToBottom();
        waitUtils.waitForElementToBeClickable(submitButton);
        submitButton.click();
    }

    @Step("Check that {key} is: {value}")
    public TextBoxPage verifyOutputResult(String key, String value) {
        logger.info("Check that {} is: {}", key, value);

        switch (key) {
            case "Name": {

                Assert.assertEquals(resultName.getText(), "Name:" + value);
                break;
            }
            case "Email": {
                Assert.assertEquals(resultEmail.getText(), "Email:" + value);
                break;
            }
            case "Current Address": {
                Assert.assertEquals(resultCurrentAddress.getText(), "Current Address :" + value);
                break;
            }
            case "Permanent Address": {
                Assert.assertEquals(resultPermanentAddress.getText(), "Permananet Address :" + value);
                break;
            }
        }
        return this;
    }

    @Step
    public boolean isOutputDisplayed() {
        waitUtils.waitForElementToBeClickable(outputSection);
        return outputSection.isDisplayed();
    }

    @Step("Check that Modal Window is displayed")
    public void checkThatOutputIsDisplayed() {
        logger.info("Check that Output is displayed");
        Assert.assertTrue(isOutputDisplayed());
    }
}
