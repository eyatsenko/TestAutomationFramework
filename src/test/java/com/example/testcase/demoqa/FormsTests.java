package com.example.testcase.demoqa;

import com.example.base.BaseTest;
import com.example.driver.DriverManager;
import com.example.models.User;
import com.example.page.demoqa.MainPage;
import com.example.page.demoqa.PracticeFormPage;
import com.example.page.demoqa.components.CalendarComponent;
import com.example.page.demoqa.components.FormModalWindow;
import com.example.page.demoqa.components.FormsSidebarMenu;
import com.example.utilities.RandomDataUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Arrays;

public class FormsTests extends BaseTest {
    private MainPage mainPage;
    private PracticeFormPage formPage;
    private FormModalWindow formModalWindow;
    private FormsSidebarMenu formsSidebarMenu;
    private User user;
    private CalendarComponent calendar;
    private JavascriptExecutor js;

    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage();
        formPage = new PracticeFormPage();
        formModalWindow = new FormModalWindow();
        formsSidebarMenu = new FormsSidebarMenu();
        user = RandomDataUtils.getRandomUser();
        js = (JavascriptExecutor) DriverManager.getDriver();
    }

    @Test(description = "Check form filling")
    public void FillFormTest() throws ParseException {
        logAndStep("Click on Forms Card");
        mainPage.clickFormsCard();

        logAndStep("Click on Login menu item in Sidebar");
        formsSidebarMenu.clickPracticeFormMenuItem();

        logAndStep("Fill firstname: " + user.getFirstName());
        formPage.fillFirstName(user.getFirstName());

        logAndStep("Fill lastname: " + user.getLastName());
        formPage.fillLastName(user.getLastName());

        logAndStep("Fill email: " + user.getEmail());
        formPage.fillEmailField(user.getEmail());

        logAndStep("Select Gender: " + user.getGender());
        formPage.selectGender(user.getGender());

        logAndStep("Fill Mobile Number: " + user.getMobileNumber());
        formPage.fillNumberField(user.getMobileNumber());
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        logAndStep("Click on Calendar");
        calendar = formPage.clickOnCalendar();

        logAndStep("Fill Date of birth");
        calendar.setDate(12, "May", 2015);

        logAndStep("Fill Subjects: " + String.join(", ", user.getSubjects()));
        formPage.fillSubjects(user.getSubjects());

        logAndStep("Select Hobbies");
        formPage.selectHobbies(user.getHobbies());

        logAndStep("Select Picture");
        formPage.uploadPicture(user.getPicture());

        logAndStep("Fill Current Address: " + user.getCurrentAddress());
        formPage.fillCurrentAddress(user.getCurrentAddress());

        logAndStep("Select State: " + user.getState());
        formPage.selectState(user.getState());

        logAndStep("Select City: " + user.getCity());
        formPage.selectCity(user.getCity());

        logAndStep("Click Submit button");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        formPage.clickSubmitButton();

        logAndStep("Check that Modal Window is displayed");
        Assert.assertTrue(formModalWindow.isModalTableDisplayed());

        logAndStep("Check that username is: " + user.getFirstName() + " " + user.getLastName());
        formModalWindow.verifyResult("Student Name", user.getFirstName() + " " + user.getLastName());
        logAndStep("Check that Email is: " + user.getEmail());
        formModalWindow.verifyResult("Student Email", user.getEmail());
        logAndStep("Check that Gender is: " + user.getGender());
        formModalWindow.verifyResult("Gender", user.getGender());
        logAndStep("Check that Mobile is: " + user.getMobileNumber());
        formModalWindow.verifyResult("Mobile", user.getMobileNumber());
        logAndStep("Check that Date of Birth is: " + user.getDateOfBirth());
        formModalWindow.verifyResult("Date of Birth", "12 May,2015");
        logAndStep("Check that Subjects is: " + Arrays.toString(user.getSubjects()));
        formModalWindow.verifyResult("Subjects", (String.join(", ", user.getSubjects())));
        logAndStep("Check that Address is: " + user.getCurrentAddress());
        formModalWindow.verifyResult("Address", user.getCurrentAddress());
        logAndStep("Check that State and City is: " + user.getState() + " " + user.getCity());
        formModalWindow.verifyResult("State and City", user.getState() + " " + user.getCity());

        logAndStep("Close modal window");
        formModalWindow.clickCloseModalButton();
    }
}
