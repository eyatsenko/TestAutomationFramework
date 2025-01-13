package com.example.page.demoqa.elements;

import com.example.driver.DriverManager;
import com.example.enums.Column;
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

    @Step("Check that row is absent in the table")
    public WebTablesPage checkThatRowIsAbsentInTheTable(String cellText) {
        logger.info("Check that row is absent in the table");
        try {
            webTableUtils.findRowByCellText(cellText);
        } catch (Exception e) {
            Assert.assertTrue(true, "Row is not found by text {cellText}");
        }
        return this;
    }

    public WebElement findRowInTableByEmail(String email) {
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

    @Step("Check that First Name is: {cellValue}")
    public WebTablesPage verifyFirstNameValue(String email, String cellValue) {
        logger.info("Check that First Name is : '{}'", cellValue);
        String actualValue = webTableUtils.getCellValueForColumn(this.findRowInTableByEmail(email),
                Column.getIndexByName("First Name"));
        Assert.assertEquals(actualValue, cellValue, "FirstName is: '" + actualValue
                + "', but should be '" + cellValue + "'!");
        return this;
    }

    @Step("Check that Last Name is: {cellValue}")
    public WebTablesPage verifyLastNameValue(String email, String cellValue) {
        logger.info("Check that Last Name is : '{}'", cellValue);
        String actualValue = webTableUtils.getCellValueForColumn(this.findRowInTableByEmail(email),
                Column.getIndexByName("Last Name"));
        Assert.assertEquals(actualValue, cellValue, "LastName is: '" + actualValue
                + "', but should be '" + cellValue + "'!");
        return this;
    }

    @Step("Check that Email is: {cellValue}")
    public WebTablesPage verifyEmailValue(String email, String cellValue) {
        logger.info("Check that Email is : '{}'", cellValue);
        String actualValue = webTableUtils.getCellValueForColumn(this.findRowInTableByEmail(email),
                Column.getIndexByName("Email"));
        Assert.assertEquals(actualValue, cellValue, "Email is: '" + actualValue
                + "', but should be '" + cellValue + "'!");
        return this;
    }

    @Step("Check that Age is: {cellValue}")
    public WebTablesPage verifyAgeValue(String email, String cellValue) {
        logger.info("Check that Age is : '{}'", cellValue);
        String actualValue = webTableUtils.getCellValueForColumn(this.findRowInTableByEmail(email),
                Column.getIndexByName("Age"));
        Assert.assertEquals(actualValue, cellValue, "Age is: '" + actualValue
                + "', but should be '" + cellValue + "'!");
        return this;
    }

    @Step("Check that Salary is: {cellValue}")
    public WebTablesPage verifySalaryValue(String email, String cellValue) {
        logger.info("Check that Salary is : '{}'", cellValue);
        String actualValue = webTableUtils.getCellValueForColumn(this.findRowInTableByEmail(email),
                Column.getIndexByName("Salary"));
        Assert.assertEquals(actualValue, cellValue, "Salary is: '" + actualValue
                + "', but should be '" + cellValue + "'!");
        return this;
    }

    @Step("Check that Department is: {cellValue}")
    public WebTablesPage verifyDepartmentValue(String email, String cellValue) {
        logger.info("Check that Department is : '{}'", cellValue);
        String actualValue = webTableUtils.getCellValueForColumn(this.findRowInTableByEmail(email),
                Column.getIndexByName("Department"));
        Assert.assertEquals(actualValue, cellValue, "Department is: '" + actualValue
                + "', but should be '" + cellValue + "'!");
        return this;
    }

    @Step
    public RegistrationForm openEditWindowsForRecord(String email) {
        JsUtils.waitForPageLoad();
        WebElement row = webTableUtils.findRowByCellText(email);
        webTableUtils.findButtonWithTitleInCell(row, "Action", "Edit").click();
        return new RegistrationForm();
    }

    @Step
    public WebTablesPage deleteRecordForUserWithEmail(String email) {
        WebElement row = webTableUtils.findRowByCellText(email);
        webTableUtils.findButtonWithTitleInCell(row, "Action", "Delete").click();
        return this;
    }
}
