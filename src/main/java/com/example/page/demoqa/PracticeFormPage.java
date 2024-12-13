package com.example.page.demoqa;

import com.example.driver.DriverManager;
import com.example.page.AbstractPageObject;
import com.example.page.demoqa.components.CalendarComponent;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @Step
    public PracticeFormPage fillFirstName(String firstname) {
        waitUtils.waitForElementToBeClickable(firstNameField);
        firstNameField.sendKeys(firstname);
        return this;
    }

    @Step
    public PracticeFormPage fillLastName(String lastname) {
        waitUtils.waitForElementToBeClickable(lastNameField);
        lastNameField.sendKeys(lastname);
        return this;
    }

    @Step
    public PracticeFormPage fillEmailField(String email) {
        waitUtils.waitForElementToBeClickable(userEmailField);
        userEmailField.sendKeys(email);
        return this;
    }

    @Step
    public PracticeFormPage selectGender(String gender) {
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

    @Step
    public PracticeFormPage fillNumberField(String number) {
        waitUtils.waitForElementToBeClickable(userNumberField);
        userNumberField.sendKeys(number);
        return this;
    }

    @Step
    public CalendarComponent clickOnCalendar() {
        waitUtils.waitForElementToBeClickable(dateOfBirth);
        dateOfBirth.click();
        return new CalendarComponent();
    }

    @Step
    public PracticeFormPage fillSubjects(String[] subjects) {
        for (String subject : subjects) {
            subjectsInput.sendKeys(subject);
            subjectsInput.sendKeys(ENTER);
        }
        return this;
    }

    @Step
    public PracticeFormPage selectHobbies(String[] hobbies) {
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
                    return this;
                }
                case "Music": {
                    waitUtils.waitForElementToBeClickable(musicCheckBox);
                    if (!isMusicSelected) {
                        musicCheckBox.click();
                        isMusicSelected = true;
                    }
                    return this;
                }
                default:
                    return this;
            }
        }
        return this;
    }

    @Step
    public PracticeFormPage uploadPicture (String path) {
        waitUtils.waitForElementToBeClickable(uploadPictureButton);
        uploadPictureButton.sendKeys(path);
        return this;
    }

    @Step
    public PracticeFormPage fillCurrentAddress(String address) {
        waitUtils.waitForElementToBeClickable(currentAddressField);
        currentAddressField.sendKeys(address);
        return this;
    }

    @Step
    public PracticeFormPage selectState(String stateName) {
        waitUtils.waitForElementToBeClickable(selectStateDropDownList);
        selectStateDropDownList.sendKeys(stateName);
        selectStateDropDownList.sendKeys(ENTER);
        return this;
    }

    @Step
    public PracticeFormPage selectCity(String cityName) {
        waitUtils.waitForElementToBeClickable(selectCityDropDownList);
        selectCityDropDownList.sendKeys(cityName);
        selectCityDropDownList.sendKeys(ENTER);
        return this;
    }

    @Step
    public PracticeFormPage clickSubmitButton() {
        waitUtils.waitForElementToBeClickable(submitButton);
        submitButton.click();
        return this;
    }
}
