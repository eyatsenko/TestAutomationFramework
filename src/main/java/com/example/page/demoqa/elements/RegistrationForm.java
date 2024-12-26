package com.example.page.demoqa.elements;

import com.example.page.AbstractPageObject;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.example.driver.DriverManager.waitUtils;

@Getter
@SuppressWarnings("unused")
public class RegistrationForm extends AbstractPageObject {
    @FindBy(xpath = "//div[@id='registration-form-modal']/../..")
    private WebElement registrationFormModal;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@id='age']")
    private WebElement ageField;

    @FindBy(xpath = "//input[@id='salary']")
    private WebElement salaryField;

    @FindBy(xpath = "//input[@id='department']")
    private WebElement departmentField;

    @FindBy(xpath = "//button[@class='close']")
    private WebElement closeButton;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitButton;

    @Step("Fill firstname: {firstname}")
    public RegistrationForm fillFirstName(String firstname) {
        logger.info("Filling 'First Name' field with value: '{}'", firstname);
        waitUtils.waitForElementToBeClickable(firstNameField);
        firstNameField.sendKeys(firstname);
        return this;
    }

    @Step("Fill lastname: {lastname}")
    public RegistrationForm fillLastName(String lastname) {
        logger.info("Filling 'Last Name' field with value: '{}'", lastname);
        waitUtils.waitForElementToBeClickable(lastNameField);
        lastNameField.sendKeys(lastname);
        return this;
    }

    @Step("Fill email with value: {email}")
    public RegistrationForm fillEmail(String email) {
        logger.info("Filling 'Email' field with value: '{}'", email);
        waitUtils.waitForElementToBeClickable(userEmailField);
        userEmailField.sendKeys(email);
        return this;
    }

    @Step("Fill age with value: {age}")
    public RegistrationForm fillAge(String age) {
        logger.info("Filling 'Age' field with value: '{}'", age);
        waitUtils.waitForElementToBeClickable(ageField);
        ageField.sendKeys(age);
        return this;
        //TODO: add Age into User class and RandomUserGenerator
    }

    @Step("Fill salary with value: {salary}")
    public RegistrationForm fillSalary(String salary) {
        logger.info("Filling 'Salary' field with value: '{}'", salary);
        waitUtils.waitForElementToBeClickable(salaryField);
        salaryField.sendKeys(salary);
        return this;
    }

    @Step("Fill department with value: {department}")
    public RegistrationForm fillDepartment(String departmentName) {
        logger.info("Filling 'Department' field with value: '{}'", departmentName);
        waitUtils.waitForElementToBeClickable(departmentField);
        departmentField.sendKeys(departmentName);
        return this;
    }

    @Step("Close modal window")
    public void closeModalWindow() {
        logger.info("Close modal window");
        waitUtils.waitForElementToBeClickable(closeButton);
        closeButton.click();
    }

    @Step("Submit user data")
    public void submitUserData() {
        logger.info("Submit user data");
        waitUtils.waitForElementToBeClickable(submitButton);
        submitButton.click();
    }
}
