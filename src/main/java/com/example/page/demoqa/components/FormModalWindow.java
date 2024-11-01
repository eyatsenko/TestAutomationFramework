package com.example.page.demoqa.components;

import com.example.page.AbstractPageObject;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.driver.DriverManager.waitUtils;

@Getter
public class FormModalWindow extends AbstractPageObject {
    @FindBy(xpath = "//div[@class='table-responsive']")
    private WebElement modalTable;

    @FindBy(id = "closeLargeModal")
    private WebElement closeModalButton;

//    @Step
//    public FormModalWindow clickCloseModalButton() {
//        waitUtils.waitForElementToBeClickable(closeModalButton);
//        closeModalButton.click();
//        return this;
//    }

    @Step
    public FormModalWindow clickCloseModalButton() {
        waitUtils.waitForElementToBeClickable(closeModalButton);
        closeModalButton.click();
        return this;
    }
}
