package com.example.page.demoqa.components;

import com.example.driver.DriverManager;
import com.example.page.AbstractPageObject;
import com.example.utilities.TimeFormatUtils;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;

import static com.example.driver.DriverManager.waitUtils;


@Getter
public class CalendarComponent extends AbstractPageObject {

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    private WebElement monthDatePicker;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    private WebElement yearDatePicker;

    @Step("Fill Date of birth")
    public void setDate(int day, String month, int year) throws ParseException {
        Select yearSelect = new Select(yearDatePicker);
        Select monthSelect = new Select(monthDatePicker);

        waitUtils.waitForElementToBeClickable(yearDatePicker);
        yearSelect.selectByValue(String.valueOf(year));

        waitUtils.waitForElementToBeClickable(monthDatePicker);
        monthSelect.selectByVisibleText(TimeFormatUtils
                .getFullFormatMonth(String.valueOf(day), String.valueOf(month), String.valueOf(year)));

        waitUtils.waitForElementToBeClickable(DriverManager.getDriver().findElement(
                By.xpath("//*[contains(@class, 'react-datepicker__day--0" + day + "') " +
                "and not(contains(@class, " + "'react-datepicker__day--outside-month'))]")));

        DriverManager.getDriver().findElement(
                By.xpath("//*[contains(@class, 'react-datepicker__day--0" + day + "') " +
                        "and not(contains(@class, " + "'react-datepicker__day--outside-month'))]")).click();
    }
}
