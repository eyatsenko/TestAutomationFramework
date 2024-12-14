package com.example.page.demoqa;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.example.page.AbstractPageObject;

import static com.example.driver.DriverManager.waitUtils;

@Getter
public class MainPage extends AbstractPageObject {

    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsCard;

    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement formsCard;

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertFrameWindowsCard;

    @FindBy(xpath = "//h5[text()='Widgets']")
    private WebElement widgetsCard;

    @FindBy(xpath = "//h5[text()='Interactions']")
    private WebElement interactionsCard;

    @FindBy(xpath = "//h5[text()='Book Store Application']")
    private WebElement bookStoreApplicationCard;


    @Step
    public MainPage clickElementsCard() {
        waitUtils.waitForElementToBeClickable(elementsCard);
        elementsCard.click();
        return this;
    }

    @Step("Click on Forms Card")
    public MainPage clickFormsCard() {
        waitUtils.waitForElementToBeClickable(formsCard);
        formsCard.click();
        return this;
    }

    @Step
    public MainPage clickAlertFrameWindowsCard() {
        waitUtils.waitForElementToBeClickable(alertFrameWindowsCard);
        alertFrameWindowsCard.click();
        return this;
    }

    @Step
    public MainPage clickWidgetsCard() {
        waitUtils.waitForElementToBeClickable(widgetsCard);
        widgetsCard.click();
        return this;
    }

    @Step
    public MainPage clickInteractionsCard() {
        waitUtils.waitForElementToBeClickable(interactionsCard);
        interactionsCard.click();
        return this;
    }

    @Step
    public MainPage clickBookStoreApplicationCard() {
        waitUtils.waitForElementToBeClickable(bookStoreApplicationCard);
        bookStoreApplicationCard.click();
        return this;
    }
}
