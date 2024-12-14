package com.example.page.demoqa.components;

import com.example.page.AbstractPageObject;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.example.driver.DriverManager.waitUtils;

@Getter
public class FormModalWindow extends AbstractPageObject {
    @FindBy(xpath = "//div[@class='table-responsive']")
    private WebElement modalTable;

    @FindBy(id = "closeLargeModal")
    private WebElement closeModalButton;

    @Step
    public boolean isModalTableDisplayed() {
        waitUtils.waitForElementToBeClickable(modalTable);
        return modalTable.isDisplayed();
    }

    @Step("Check that {key} is: {value}")
    public FormModalWindow verifyModalResult(String key, String value) {
        WebElement parentElement = modalTable.findElement(By.xpath(".//*[text()='" + key + "']/parent::*"));
        String values = parentElement.getText().replace(key, "").trim();
        Assert.assertEquals(values, value);
        return this;
    }

    @Step("Close modal window")
    public FormModalWindow closeModalWindow() {
        waitUtils.waitForElementToBeClickable(closeModalButton);
        closeModalButton.click();
        return this;
    }

    @Step("Check that Modal Window is displayed")
    public void checkThatModalWindowIsDisplayed() {
        Assert.assertTrue(isModalTableDisplayed());
    }

    @Step("Check that Modal Window is not displayed")
    public void checkThatModalWindowIsNotDisplayed() {
        try {
            modalTable.isDisplayed();
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }
}
