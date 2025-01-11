package com.example.testcase.demoqa;

import com.example.base.AbstractBaseTest;
import com.example.models.User;
import com.example.page.demoqa.MainPage;
import com.example.page.demoqa.forms.PracticeFormPage;
import com.example.page.demoqa.forms.FormModalWindow;
import com.example.page.demoqa.forms.FormsSidebarMenu;
import com.example.utilities.RandomDataUtils;
import com.example.utilities.TimeFormatUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.text.ParseException;

public class FormsTests extends AbstractBaseTest {
    private MainPage mainPage;
    private PracticeFormPage formPage;
    private FormModalWindow formModalWindow;
    private FormsSidebarMenu formsSidebarMenu;
    private User user;

    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage();
        formPage = new PracticeFormPage();
        formModalWindow = new FormModalWindow();
        formsSidebarMenu = new FormsSidebarMenu();
        user = RandomDataUtils.getRandomUser();
    }

    @Test(description = "Check form filling with all valid data", priority = 1)
    public void fillAllFormTest() throws ParseException {
        mainPage.openFormsPage();

        formsSidebarMenu.clickPracticeFormMenuItem();

        formPage.fillFirstName(user.getFirstName())
                .fillLastName(user.getLastName())
                .fillEmail(user.getEmail())
                .selectGender(user.getGender())
                .fillNumber(user.getMobileNumber())
                .setDateOfBirth(user.getDayOfBirth(), user.getMonthOfBirth(), user.getYearOfBirth())
                .fillSubjects(user.getSubjects())
                .selectHobbies(user.getHobbies())
                .uploadPicture(user.getPicture())
                .fillCurrentAddress(user.getCurrentAddress())
                .selectState(user.getState())
                .selectCity(user.getCity())
                .submitForm();

        formModalWindow.checkThatModalWindowIsDisplayed();

        formModalWindow.verifyModalResult("Student Name", user.getFirstName() + " " + user.getLastName());
        formModalWindow.verifyModalResult("Student Email", user.getEmail());
        formModalWindow.verifyModalResult("Gender", user.getGender());
        formModalWindow.verifyModalResult("Mobile", user.getMobileNumber());
        formModalWindow.verifyModalResult("Date of Birth", user.getDayOfBirth() + " " + TimeFormatUtils
                .getFullFormatMonth(user.getMonthOfBirth()) + "," + user.getYearOfBirth());
        formModalWindow.verifyModalResult("Subjects", (String.join(", ", user.getSubjects())));
        formModalWindow.verifyModalResult("Hobbies", (String.join(", ", user.getHobbies())));
        formModalWindow.verifyModalResult("Picture", Paths.get(user.getPicture()).getFileName().toString());
        formModalWindow.verifyModalResult("Address", user.getCurrentAddress());
        formModalWindow.verifyModalResult("State and City", user.getState() + " " + user.getCity());

        formModalWindow.closeModalWindow();
    }

    @Test(description = "Check form filling with only required fields", priority = 2)
    public void fillRequiredFieldsFormTest() throws ParseException {
        mainPage.openFormsPage();

        formsSidebarMenu.clickPracticeFormMenuItem();

        formPage.fillFirstName(user.getFirstName())
                .fillLastName(user.getLastName())
                .selectGender(user.getGender())
                .fillNumber(user.getMobileNumber())
                .setDateOfBirth(user.getDayOfBirth(), user.getMonthOfBirth(), user.getYearOfBirth())
                .submitForm();

        formModalWindow.checkThatModalWindowIsDisplayed();

        formModalWindow.verifyModalResult("Student Name", user.getFirstName() + " " + user.getLastName());
        formModalWindow.verifyModalResult("Student Email", "");
        formModalWindow.verifyModalResult("Gender", user.getGender());
        formModalWindow.verifyModalResult("Mobile", user.getMobileNumber());
        formModalWindow.verifyModalResult("Date of Birth", user.getDayOfBirth() + " " + TimeFormatUtils
                .getFullFormatMonth(user.getMonthOfBirth()) + "," + user.getYearOfBirth());
        formModalWindow.verifyModalResult("Subjects", "");
        formModalWindow.verifyModalResult("Hobbies", "");
        formModalWindow.verifyModalResult("Picture", "");
        formModalWindow.verifyModalResult("Address", "");
        formModalWindow.verifyModalResult("State and City", "");

        formModalWindow.closeModalWindow();
    }

    @Test(description = "Check form filling with missing First Name", priority = 3)
    public void fillAllFormMissingFirstNameTest() throws ParseException {
        mainPage.openFormsPage();

        formsSidebarMenu.clickPracticeFormMenuItem();

        formPage.fillLastName(user.getLastName())
                .fillEmail(user.getEmail())
                .selectGender(user.getGender())
                .fillNumber(user.getMobileNumber())
                .setDateOfBirth(user.getDayOfBirth(), user.getMonthOfBirth(), user.getYearOfBirth())
                .fillSubjects(user.getSubjects())
                .selectHobbies(user.getHobbies())
                .uploadPicture(user.getPicture())
                .fillCurrentAddress(user.getCurrentAddress())
                .selectState(user.getState())
                .selectCity(user.getCity())
                .submitForm();

        formModalWindow.checkThatModalWindowIsNotDisplayed();
        formPage.checkThatFirstNameFieldIsHighlightedInRed();
    }

    @Test(description = "Check form filling with missing Last Name", priority = 4)
    public void fillAllFormMissingLastNameTest() throws ParseException {
        mainPage.openFormsPage();

        formsSidebarMenu.clickPracticeFormMenuItem();

        formPage.fillFirstName(user.getFirstName())
                .fillEmail(user.getEmail())
                .selectGender(user.getGender())
                .fillNumber(user.getMobileNumber())
                .setDateOfBirth(user.getDayOfBirth(), user.getMonthOfBirth(), user.getYearOfBirth())
                .fillSubjects(user.getSubjects())
                .selectHobbies(user.getHobbies())
                .uploadPicture(user.getPicture())
                .fillCurrentAddress(user.getCurrentAddress())
                .selectState(user.getState())
                .selectCity(user.getCity())
                .submitForm();

        formModalWindow.checkThatModalWindowIsNotDisplayed();
        formPage.checkThatLastNameFieldIsHighlightedInRed();
    }

    @Test(description = "Check form filling with missing Phone Number", priority = 5)
    public void fillAllFormMissingPhoneNumberTest() throws ParseException {
        mainPage.openFormsPage();

        formsSidebarMenu.clickPracticeFormMenuItem();

        formPage.fillFirstName(user.getFirstName())
                .fillLastName(user.getLastName())
                .fillEmail(user.getEmail())
                .selectGender(user.getGender())
                .setDateOfBirth(user.getDayOfBirth(), user.getMonthOfBirth(), user.getYearOfBirth())
                .fillSubjects(user.getSubjects())
                .selectHobbies(user.getHobbies())
                .uploadPicture(user.getPicture())
                .fillCurrentAddress(user.getCurrentAddress())
                .selectState(user.getState())
                .selectCity(user.getCity())
                .submitForm();

        formModalWindow.checkThatModalWindowIsNotDisplayed();
        formPage.checkThatPhoneNumberFieldIsHighlightedInRed();
    }
}
