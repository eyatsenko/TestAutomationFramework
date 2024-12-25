package com.example.page.demoqa.forms;

import com.example.page.AbstractPageObject;
import com.example.utilities.JsUtils;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.text.ParseException;

import static com.example.driver.DriverManager.waitUtils;
import static org.openqa.selenium.Keys.ENTER;

@Getter
public class PracticeFormPage extends AbstractPageObject {
    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "userEmail")
    private WebElement userEmailField;

    @FindBy(xpath = "//label[normalize-space()='Male']")
    private WebElement maleRadioButton;

    @FindBy(xpath = "//label[normalize-space()='Female']")
    private WebElement femaleRadioButton;

    @FindBy(id = "//label[normalize-space()='Other']")
    private WebElement otherRadioButton;

    @FindBy(id = "userNumber")
    private WebElement userNumberField;

    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//input[@id='subjectsInput']")
    private WebElement subjectsInput;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    private WebElement sportCheckBox;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    private WebElement readingCheckBox;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    private WebElement musicCheckBox;

    @FindBy(id = "uploadPicture")
    private WebElement uploadPictureButton;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressField;

    @FindBy(xpath = "//*[@id='state']//input")
    private WebElement selectStateDropDownList;

    @FindBy(xpath = "//*[@id='city']//input")
    private WebElement selectCityDropDownList;

    @FindBy(id = "submit")
    private WebElement submitButton;

    boolean isSportSelected = false;
    boolean isReadingSelected = false;
    boolean isMusicSelected = false;

    @Step("Fill firstname: {firstname}")
    public PracticeFormPage fillFirstName(String firstname) {
        logger.info("Filling 'First Name' field with value: '{}'", firstname);
        waitUtils.waitForElementToBeClickable(firstNameField);
        firstNameField.sendKeys(firstname);
        return this;
    }

    @Step("Fill lastname: {lastname}")
    public PracticeFormPage fillLastName(String lastname) {
        logger.info("Filling 'Last Name' field with value: '{}'", lastname);
        waitUtils.waitForElementToBeClickable(lastNameField);
        lastNameField.sendKeys(lastname);
        return this;
    }

    @Step("Fill email: {email}")
    public PracticeFormPage fillEmail(String email) {
        logger.info("Filling 'Email' field with value: '{}'", email);
        waitUtils.waitForElementToBeClickable(userEmailField);
        userEmailField.sendKeys(email);
        return this;
    }

    @Step("Select gender: {gender}")
    public PracticeFormPage selectGender(String gender) {
        logger.info("Select gender: {}", gender);
        switch (gender) {
            case "Male": {
                waitUtils.waitForElementToBeClickable(maleRadioButton);
                maleRadioButton.click();
                return this;
            }
            case "Female": {
                waitUtils.waitForElementToBeClickable(femaleRadioButton);
                femaleRadioButton.click();
                return this;
            }
            default: {
                waitUtils.waitForElementToBeClickable(otherRadioButton);
                otherRadioButton.click();
                return this;
            }
        }
    }

    @Step("Fill phone number: {number}")
    public PracticeFormPage fillNumber(String number) {
        logger.info("Filling 'Phone Number' field with value: '{}'", number);
        waitUtils.waitForElementToBeClickable(userNumberField);
        userNumberField.sendKeys(number);
        return this;
    }

    @Step("Open calendar")
    public CalendarComponent openCalendar() {
        logger.info("Open Calendar");
        JsUtils.scrollToBottom();
        waitUtils.waitForElementToBeClickable(dateOfBirth);
        dateOfBirth.click();
        return new CalendarComponent();
    }

    @Step("Set DOB")
    public PracticeFormPage setDateOfBirth(int day, String month, int year) throws ParseException {
        logger.info("Filling 'DOB' field with value: '{}'", year);
        openCalendar().setDate(day, month, year);
        return this;
    }

    @Step("Fill Subjects: {subjects}")
    public PracticeFormPage fillSubjects(String[] subjects) {
        logger.info("Filling 'Subjects' field with value: '{}'", subjects);
        for (String subject : subjects) {
            subjectsInput.sendKeys(subject);
            subjectsInput.sendKeys(ENTER);
        }
        return this;
    }

    @Step("Select Hobbies: {hobbies}")
    public PracticeFormPage selectHobbies(String[] hobbies) {
        logger.info("Filling 'Hobbies' field with value: '{}'", hobbies);
        for (String hobby : hobbies) {
            switch (hobby) {
                case "Sports": {
                    waitUtils.waitForElementToBeClickable(sportCheckBox);
                    if (!isSportSelected) {
                        sportCheckBox.click();
                        isSportSelected = true;
                    }
                    return this;
                }
                case "Reading": {
                    waitUtils.waitForElementToBeClickable(readingCheckBox);
                    readingCheckBox.click();
                    if (!isReadingSelected) {
                        readingCheckBox.click();
                        isReadingSelected = true;
                    }
                    break;
                }
                case "Music": {
                    waitUtils.waitForElementToBeClickable(musicCheckBox);
                    if (!isMusicSelected) {
                        musicCheckBox.click();
                        isMusicSelected = true;
                    }
                    break;
                }
                default:
                    break;
            }
        }
        return this;
    }

    @Step("Upload a Picture: {path}")
    public PracticeFormPage uploadPicture(String path) {
        logger.info("Upload a picture: '{}'", path);
        waitUtils.waitForElementToBeClickable(uploadPictureButton);
        uploadPictureButton.sendKeys(path);
        return this;
    }

    @Step("Fill CurrentAddress: {address}")
    public PracticeFormPage fillCurrentAddress(String address) {
        logger.info("Filling 'Current Address' field with value: '{}'", address);
        waitUtils.waitForElementToBeClickable(currentAddressField);
        currentAddressField.sendKeys(address);
        return this;
    }

    @Step("Select State: {stateName}")
    public PracticeFormPage selectState(String stateName) {
        logger.info("Select 'State': '{}'", stateName);
        waitUtils.waitForElementToBeClickable(selectStateDropDownList);
        selectStateDropDownList.sendKeys(stateName);
        selectStateDropDownList.sendKeys(ENTER);
        return this;
    }

    @Step("Select City: {cityName}")
    public PracticeFormPage selectCity(String cityName) {
        logger.info("Select 'City': '{}'", cityName);
        waitUtils.waitForElementToBeClickable(selectCityDropDownList);
        selectCityDropDownList.sendKeys(cityName);
        selectCityDropDownList.sendKeys(ENTER);
        return this;
    }

    @Step("Click on Submit Button")
    public void submitForm() {
        logger.info("Submitting Form");
        JsUtils.scrollToBottom();
        waitUtils.waitForElementToBeClickable(submitButton);
        submitButton.click();
    }

    @Step("Check that First Name field is highlighted in red")
    public void checkThatFirstNameFieldIsHighlightedInRed() {
        logger.info("Check that First Name field is highlighted in red");
        JsUtils.scrollToTop();
        String currentColor = firstNameField.getCssValue("border-color");
        Assert.assertEquals(currentColor, "rgb(220, 53, 69)");
    }

    @Step("Check that Last Name field is highlighted in red")
    public void checkThatLastNameFieldIsHighlightedInRed() {
        logger.info("Check that Last Name field is highlighted in red");
        JsUtils.scrollToTop();
        String currentColor = lastNameField.getCssValue("border-color");
        Assert.assertEquals(currentColor, "rgb(220, 53, 69)");
    }

    @Step("Check that Phone Number field is highlighted in red")
    public void checkThatPhoneNumberFieldIsHighlightedInRed() {
        logger.info("Check that Phone Number field is highlighted in red");
        JsUtils.scrollToTop();
        String currentColor = userNumberField.getCssValue("border-color");
        Assert.assertEquals(currentColor, "rgb(220, 53, 69)");
    }
}