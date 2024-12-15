package com.example.page.demoqa;

import com.example.utilities.JsUtils;
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
    public MainPage openElementsPage() {
        waitUtils.waitForElementToBeClickable(elementsCard);
        elementsCard.click();
        return this;
    }

    @Step("Open Forms Page")
    public MainPage openFormsPage() {
        waitUtils.waitForElementToBeClickable(formsCard);
        formsCard.click();
        return this;
    }

    @Step
    public MainPage openAlertFrameWindowsPage() {
        waitUtils.waitForElementToBeClickable(alertFrameWindowsCard);
        alertFrameWindowsCard.click();
        return this;
    }

    @Step
    public MainPage openWidgetsPage() {
        waitUtils.waitForElementToBeClickable(widgetsCard);
        widgetsCard.click();
        return this;
    }

    @Step
    public MainPage openInteractionsPage() {
        waitUtils.waitForElementToBeClickable(interactionsCard);
        interactionsCard.click();
        return this;
    }

    @Step("Open Book Store Application Page")
    public BookStoreApplicationPage openBookStoreApplicationPage() {
        JsUtils.scrollToBottom();
        waitUtils.waitForElementToBeClickable(bookStoreApplicationCard);
        bookStoreApplicationCard.click();
        return new BookStoreApplicationPage();
    }
}
