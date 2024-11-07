package com.example.page.demoqa.components;

import com.example.page.AbstractPageObject;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
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

    @Step
    public FormModalWindow verifyResult(String key, String value) {
        WebElement parentElement = modalTable.findElement(By.xpath(".//*[text()='" + key + "']/parent::*"));
        String values = parentElement.getText().replace(key,"").trim();

        Assert.assertEquals(values, value);
        return this;
    }

    @Step
    public FormModalWindow clickCloseModalButton() {
        waitUtils.waitForElementToBeClickable(closeModalButton);
        closeModalButton.click();
        return this;
    }
}
