package com.example.page.demoqa.elements;

import com.example.page.AbstractPageObject;
import com.example.utilities.JsUtils;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.driver.DriverManager.waitUtils;

@Getter
@SuppressWarnings("unused")
public class WebTablesPage extends AbstractPageObject {
    @FindBy(id = "addNewRecordButton")
    private WebElement addButton;

    @FindBy(id = "searchBox")
    private WebElement searchField;

    @FindBy(xpath = "//div[@role='grid']")
    private WebElement table;

    @Step("Open registration form")
    public RegistrationForm openRegistrationForm() {
        logger.info("Open registration form");
        JsUtils.scrollToElement(addButton);
        waitUtils.waitForElementToBeClickable(addButton);
        addButton.click();
        return new RegistrationForm();
    }

    //TODO: add methods and rest of elements
}
