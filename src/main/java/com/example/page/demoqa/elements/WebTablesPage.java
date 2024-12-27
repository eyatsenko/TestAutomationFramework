package com.example.page.demoqa.elements;

import com.example.driver.DriverManager;
import com.example.page.AbstractPageObject;
import com.example.utilities.JsUtils;
import com.example.utilities.WebTableUtils;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.example.driver.DriverManager.waitUtils;

@Getter
@SuppressWarnings("unused")
public class WebTablesPage extends AbstractPageObject {

    @Getter
    enum Column {
        FIRSTNAME(1, "First Name"),
        LASTNAME(2, "Last Name"),
        AGE(3, "Age"),
        EMAIL(4, "Email"),
        SALARY(5, "Salary"),
        DEPARTMENT(6, "Department"),
        ACTION(7, "Action");

        private final int index;
        private final String name;

        Column(int index, String name) {
            this.index = index;
            this.name = name;
        }

        public static int getIndexByName(String name) {
            for (Column column : Column.values()) {
                if (column.getName().equalsIgnoreCase(name)) {
                    return column.getIndex();
                }
            }
            throw new IllegalArgumentException("No column found with name: " + name);
        }
    }

    @FindBy(id = "addNewRecordButton")
    private WebElement addButton;

    @FindBy(id = "searchBox")
    private WebElement searchField;

    @FindBy(xpath = "//div[@class='rt-tbody']")
    private WebElement table;

    WebTableUtils webTableUtils = new WebTableUtils(DriverManager.getDriver(), table);

    @Step("Open registration form")
    public RegistrationForm openRegistrationForm() {
        logger.info("Open registration form");
        JsUtils.scrollToElement(addButton);
        waitUtils.waitForElementToBeClickable(addButton);
        addButton.click();
        return new RegistrationForm();
    }

    @Step("Check that row is present in the table")
    public WebTablesPage checkThatRowIsPresentInTheTable(String cellText) {
        logger.info("Check that row is present in the table");
        try {
            webTableUtils.findRowByCellText(cellText);
            Assert.assertTrue(true);
        } catch (Exception e) {
            logger.error(e.getMessage());
            Assert.fail("Row is not found by text {cellText}");
        }
        return this;
    }

    @Step("Find row by Email: {email}")
    public WebElement findRowInTableByEmail(String email) {
        logger.info("Find row by Email: '{}'", email);
        return webTableUtils.findRowByCellText(email);
    }

    @Step("Check that column {columnName} contains: {cellValue}")
    public WebTablesPage verifyCellValueInRow(WebElement row, String columnName, String cellValue) {
        logger.info("Check that column '{}' contains: '{}'", columnName, cellValue);
        String actualValue = webTableUtils.getCellValueForColumn(row, Column.getIndexByName(columnName));
        Assert.assertEquals(actualValue, cellValue, "Column '" + columnName + "' contains value '"
                + actualValue + "', but should be '" + cellValue + "'!");
        return this;
    }

    //TODO: add methods and rest of elements
}
