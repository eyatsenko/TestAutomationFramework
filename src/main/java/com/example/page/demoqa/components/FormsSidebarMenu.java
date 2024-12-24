package com.example.page.demoqa.components;

import com.example.page.AbstractPageObject;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.driver.DriverManager.waitUtils;

@Getter
public class FormsSidebarMenu extends AbstractPageObject {

    @FindBy(xpath = "//span[normalize-space()='Practice Form']")
    private WebElement practiceFormMenuItem;

    @Step("Click on Login menu item in Sidebar")
    public FormsSidebarMenu clickPracticeFormMenuItem() {
        logger.info("Open Practice Form page");
        waitUtils.waitForElementToBeClickable(practiceFormMenuItem);
        practiceFormMenuItem.click();
        return this;
    }
}
