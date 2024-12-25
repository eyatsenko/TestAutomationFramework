package com.example.page.demoqa.bookStoreApplication;

import com.example.page.AbstractPageObject;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.driver.DriverManager.waitUtils;

@Getter
public class BookStoreApplicationPage extends AbstractPageObject {

    @FindBy(id = "searchBox")
    private WebElement searchInput;

    @Step
    public BookStoreApplicationPage enterBookName(String bookName) {
        waitUtils.waitForElementToBeClickable(searchInput);
        searchInput.sendKeys(bookName);
        return this;
    }
}
