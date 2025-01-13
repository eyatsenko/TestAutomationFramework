package com.example.page.demoqa.elements;

import com.example.driver.DriverManager;
import com.example.page.AbstractPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.example.driver.DriverManager.waitUtils;

public class ButtonsPage extends AbstractPageObject {
    @FindBy(id = "doubleClickBtn")
    private WebElement doubleClickButton;

    @FindBy(id = "rightClickBtn")
    private WebElement rightClickButton;

    @FindBy(xpath = "(//button[normalize-space()='Click Me'])[1]")
    private WebElement dynamicClickButton;

    @FindBy(id = "doubleClickMessage")
    private WebElement doubleClickMessage;

    @FindBy(id = "rightClickMessage")
    private WebElement rightClickMessage;

    @FindBy(id = "dynamicClickMessage")
    private WebElement dynamicClickMessage;

    @Step("Click on 'Double Click Me' button")
    public void clickOnDoubleClickButton() {
        logger.info("Click on 'Double Click Me' button");
        waitUtils.waitForElementToBeClickable(doubleClickButton);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.doubleClick(doubleClickButton).perform();
    }

    @Step("Click on 'Right Click Me' button")
    public void clickOnRightClickButton() {
        logger.info("Click on 'Right Click Me' button");
        waitUtils.waitForElementToBeClickable(rightClickButton);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.contextClick(rightClickButton).perform();
    }

    @Step("Click on 'Click Me' button")
    public void clickOnClickButton() {
        logger.info("Click on 'Click Me' button");
        waitUtils.waitForElementToBeClickable(dynamicClickButton);
        dynamicClickButton.click();
    }

    @Step("Check chat text 'You have done a double click' is displayed")
    public void checkThatDoubleClickIsPerformed() {
        logger.info("Check chat text 'You have done a double click' is displayed");
        waitUtils.waitForElementToBeVisible(doubleClickMessage);
        Assert.assertEquals(doubleClickMessage.getText(), "You have done a double click");
    }

    @Step("Check chat text 'You have done a right click' is displayed")
    public void checkThatRightClickIsPerformed() {
        logger.info("Check chat text 'You have done a right click' is displayed");
        waitUtils.waitForElementToBeVisible(rightClickMessage);
        Assert.assertEquals(rightClickMessage.getText(), "You have done a right click");
    }

    @Step("Check chat text 'You have done a dynamic click' is displayed")
    public void checkThatDynamicClickIsPerformed() {
        logger.info("Check chat text 'You have done a dynamic click' is displayed");
        waitUtils.waitForElementToBeVisible(dynamicClickMessage);
        Assert.assertEquals(dynamicClickMessage.getText(), "You have done a dynamic click");
    }
}
