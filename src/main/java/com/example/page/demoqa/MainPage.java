package com.example.page.demoqa;

import com.example.page.demoqa.bookStoreApplication.BookStoreApplicationPage;
import com.example.utilities.JsUtils;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.example.page.AbstractPageObject;

import static com.example.driver.DriverManager.waitUtils;

@Getter
@SuppressWarnings("unused")
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

    @Step("Open 'Elements' page")
    public MainPage openElementsPage() {
        logger.info("Open 'Elements' page");
        waitUtils.waitForElementToBeClickable(elementsCard);
        elementsCard.click();
        return this;
    }

    @Step("Open Forms Page")
    public MainPage openFormsPage() {
        logger.info("Open 'Forms' page");
        waitUtils.waitForElementToBeClickable(formsCard);
        formsCard.click();
        return this;
    }

    @Step("Open 'Alert Frame Windows' page")
    public MainPage openAlertFrameWindowsPage() {
        logger.info("Open 'Alert Frame Windows' page");
        waitUtils.waitForElementToBeClickable(alertFrameWindowsCard);
        alertFrameWindowsCard.click();
        return this;
    }

    @Step("Open 'Widgets' page")
    public MainPage openWidgetsPage() {
        logger.info("Open 'Widgets' page");
        waitUtils.waitForElementToBeClickable(widgetsCard);
        widgetsCard.click();
        return this;
    }

    @Step("Open 'Interactions' page")
    public MainPage openInteractionsPage() {
        logger.info("Open 'Interactions' page");
        waitUtils.waitForElementToBeClickable(interactionsCard);
        interactionsCard.click();
        return this;
    }

    @Step("Open Book Store Application Page")
    public BookStoreApplicationPage openBookStoreApplicationPage() {
        logger.info("Open 'Book Store Application' page");
        JsUtils.scrollToBottom();
        waitUtils.waitForElementToBeClickable(bookStoreApplicationCard);
        bookStoreApplicationCard.click();
        return new BookStoreApplicationPage();
    }
}
