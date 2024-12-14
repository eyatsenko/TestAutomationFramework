package com.example.testcase.demoqa;

import com.example.base.BaseTest;
import com.example.models.User;
import com.example.page.demoqa.MainPage;
import com.example.page.demoqa.PracticeFormPage;
import com.example.page.demoqa.components.CalendarComponent;
import com.example.page.demoqa.components.FormModalWindow;
import com.example.page.demoqa.components.FormsSidebarMenu;
import com.example.utilities.RandomDataUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.ParseException;

public class FormsTests extends BaseTest {
    private MainPage mainPage;
    private PracticeFormPage formPage;
    private FormModalWindow formModalWindow;
    private FormsSidebarMenu formsSidebarMenu;
    private User user;
    private CalendarComponent calendar;

    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage();
        formPage = new PracticeFormPage();
        formModalWindow = new FormModalWindow();
        formsSidebarMenu = new FormsSidebarMenu();
        user = RandomDataUtils.getRandomUser();
    }

    @Test(description = "Check form filling")
    public void FillFormTest() throws ParseException {
        mainPage.clickFormsCard();

        formsSidebarMenu.clickPracticeFormMenuItem();

        formPage.fillFirstName(user.getFirstName())
                .fillLastName(user.getLastName())
                .fillEmailField(user.getEmail())
                .selectGender(user.getGender())
                .fillNumberField(user.getMobileNumber())
                .clickOnCalendar().setDate(12, "May", 2015);

        formPage.fillSubjects(user.getSubjects())
                .selectHobbies(user.getHobbies())
                .uploadPicture(user.getPicture())
                .fillCurrentAddress(user.getCurrentAddress())
                .selectState(user.getState())
                .selectCity(user.getCity())
                .clickSubmitButton();

        logAndStep("Check that Modal Window is displayed");
        Assert.assertTrue(formModalWindow.isModalTableDisplayed());

        formModalWindow.verifyModalResult("Student Name", user.getFirstName() + " " + user.getLastName());
        formModalWindow.verifyModalResult("Student Email", user.getEmail());
        formModalWindow.verifyModalResult("Gender", user.getGender());
        formModalWindow.verifyModalResult("Mobile", user.getMobileNumber());
        formModalWindow.verifyModalResult("Date of Birth", "12 May,2015");
        formModalWindow.verifyModalResult("Subjects", (String.join(", ", user.getSubjects())));
        formModalWindow.verifyModalResult("Address", user.getCurrentAddress());
        formModalWindow.verifyModalResult("State and City", user.getState() + " " + user.getCity());

        formModalWindow.clickCloseModalButton();
    }
}
