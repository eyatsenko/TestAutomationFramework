package com.example.page.demoqa.elements;

import com.example.page.demoqa.components.SidebarMenu;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.driver.DriverManager.waitUtils;

public class ElementsSideBarMenu extends SidebarMenu {
    @FindBy(xpath = "//span[normalize-space()='Text Box']")
    private WebElement textBoxMenuItem;

    @FindBy(xpath = "//span[normalize-space()='Check Box']")
    private WebElement checkBoxMenuItem;

    @Step("Click on 'Text Box' item in Sidebar")
    public TextBoxPage clickTextBoxMenuItem() {
        logger.info("Click on 'Text Box' item in Sidebar");
        waitUtils.waitForElementToBeClickable(textBoxMenuItem);
        textBoxMenuItem.click();
        return new TextBoxPage();
    }

    @Step("Click on 'Check Box' item in Sidebar")
    public CheckBoxPage clickCheckBoxMenuItem() {
        logger.info("Click on 'Check Box' item in Sidebar");
        waitUtils.waitForElementToBeClickable(checkBoxMenuItem);
        checkBoxMenuItem.click();
        return new CheckBoxPage();
    }
}