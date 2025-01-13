package com.example.page.demoqa.alertsFrameWindows;

import com.example.driver.DriverManager;
import com.example.page.AbstractPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.example.driver.DriverManager.waitUtils;

public class AlertsPage extends AbstractPageObject {

    @FindBy(id = "alertButton")
    private WebElement alertButton;

    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    private WebElement confirmButton;

    @FindBy(id = "promtButton")
    private WebElement promptButton;

    @FindBy(id = "confirmResult")
    private WebElement confirmResult;

    @FindBy(id = "promptResult")
    private WebElement promptResult;

    @Step("Click on the first Alert button")
    public AlertsPage openTheFirstAlertAndAccept() {
        logger.info("Click on the first Alert button");
        waitUtils.waitForElementToBeClickable(alertButton);
        alertButton.click();
        try {
            Alert alert = DriverManager.getDriver().switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            Assert.fail();
        }
        return this;
    }

    @Step("Click on Timer Alert Button")
    public AlertsPage openTimerAlertAndAccept() {
        logger.info("Click on Timer Alert Button");
        waitUtils.waitForElementToBeClickable(timerAlertButton);
        timerAlertButton.click();
        try {
            waitUtils.waitForAlert();
            Alert alert = DriverManager.getDriver().switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        }
        return this;
    }

    @Step("Open Confirm Alert and accept")
    public AlertsPage openConfirmAlertAndAccept() {
        logger.info("Open Confirm Alert and accept");
        waitUtils.waitForElementToBeClickable(confirmButton);
        confirmButton.click();
        try {
            Alert alert = DriverManager.getDriver().switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        }
        return this;
    }

    @Step("Open Confirm Alert and dismiss")
    public AlertsPage openConfirmAlertAndDismiss() {
        logger.info("Open Confirm Alert and dismiss");
        waitUtils.waitForElementToBeClickable(confirmButton);
        confirmButton.click();
        try {
            Alert alert = DriverManager.getDriver().switchTo().alert();
            alert.dismiss();
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        }
        return this;
    }

    @Step("Click on Prompt Alert Button")
    public AlertsPage openPromptAlertAndSendValue(String value) {
        waitUtils.waitForElementToBeClickable(promptButton);
        promptButton.click();
        try {
            Alert alert = DriverManager.getDriver().switchTo().alert();
            alert.sendKeys(value);
            alert.accept();
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        }
        return this;
    }

    @Step("Check that Confirm Alert has been accepted")
    public AlertsPage checkThatConfirmAlertHasBeenAccepted() {
        waitUtils.waitForElementToBeVisible(confirmResult);
        Assert.assertEquals(confirmResult.getText(), "You selected Ok");
        return this;
    }

    @Step("Check that Confirm Alert has been dismissed")
    public AlertsPage checkThatConfirmAlertHasBeenDismissed() {
        waitUtils.waitForElementToBeVisible(confirmResult);
        Assert.assertEquals(confirmResult.getText(), "You selected Cancel");
        return this;
    }

    @Step("Check that entered text '{text}' is displayed")
    public AlertsPage checkThatEnteredTextIsDisplayed(String text) {
        waitUtils.waitForElementToBeVisible(promptResult);
        Assert.assertEquals(promptResult.getText(), "You entered " + text);
        return this;
    }
}
