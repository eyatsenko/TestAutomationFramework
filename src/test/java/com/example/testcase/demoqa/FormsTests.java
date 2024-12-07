package com.example.testcase.demoqa;

import com.example.base.BaseWeb;
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
import com.example.page.demoqa.components.SidebarMenu;

import java.text.ParseException;

public class FormsTests extends BaseWeb {
    private MainPage mainPage;
    private PracticeFormPage formPage;
    private FormModalWindow formModalWindow;
    private SidebarMenu sidebarMenu;
    private FormsSidebarMenu formsSidebarMenu;
    private User user;
    private CalendarComponent calendar;
    private JavascriptExecutor js;


    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage();
        formPage = new PracticeFormPage();
        formModalWindow = new FormModalWindow();
        sidebarMenu = new SidebarMenu();
        formsSidebarMenu = new FormsSidebarMenu();
        user = RandomDataUtils.getRandomUser();
        js = (JavascriptExecutor) DriverManager.getDriver();
    }

    @Test(description = "Check form filling")
    public void FillFormTest() throws ParseException {
        logger.info("Click on Forms Card");
        mainPage.clickFormsCard();

        logger.info("Click on Login menu item in Sidebar");
        formsSidebarMenu.clickPracticeFormMenuItem();

        logger.info("Fill firstname: " + user.getFirstName());
        formPage.fillFirstName(user.getFirstName());

        logger.info("Fill lastname: " + user.getLastName());
        formPage.fillLastName(user.getLastName());

        logger.info("Fill email: " + user.getEmail());
        formPage.fillEmailField(user.getEmail());

        logger.info("Select Gender: " + user.getGender());
        formPage.selectGender(user.getGender());

        logger.info("Fill Mobile Number: " + user.getMobileNumber());
        formPage.fillNumberField(user.getMobileNumber());
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        logger.info("Click on Calendar");
        calendar = formPage.clickOnCalendar();

        logger.info("Fill Date of birth");
        calendar.setDate(12, "May", 2015);

        logger.info("Fill Subjects: " + String.join(", ", user.getSubjects()));
        formPage.fillSubjects(user.getSubjects());

        logger.info("Select Hobbies");
        formPage.selectHobbies(user.getHobbies());

        logger.info("Select Picture");
        formPage.uploadPicture(user.getPicture());

        logger.info("Fill Current Address: " + user.getCurrentAddress());
        formPage.fillCurrentAddress(user.getCurrentAddress());

//TODO: fix selector
//        logger.info("Select State: " + user.getState());
//        formPage.selectState(user.getState());

//TODO: fix selector
//        logger.info("Select City: " + user.getCity());
//        formPage.selectCity(user.getCity());

        logger.info("Click Submit button");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        formPage.clickSubmitButton();

        logger.info("Check that Modal Window is displayed");
        Assert.assertTrue(formModalWindow.isModalTableDisplayed());

        logger.info("Check username");
        formModalWindow.verifyResult("Student Name", user.getFirstName() + " " + user.getLastName());
        logger.info("Check Email");
        formModalWindow.verifyResult("Student Email", user.getEmail());
        logger.info("Check Gender");
        formModalWindow.verifyResult("Gender", user.getGender());
        logger.info("Check Mobile");
        formModalWindow.verifyResult("Mobile", user.getMobileNumber());
        logger.info("Check Date of Birth");
        formModalWindow.verifyResult("Date of Birth", "12 May,2015");
        logger.info("Check Subjects");
        formModalWindow.verifyResult("Subjects", (String.join(", ", user.getSubjects())));
        logger.info("Check Address");
        formModalWindow.verifyResult("Address", user.getCurrentAddress());
//        logger.info("Check State and City");
//        formModalWindow.verifyResult("State and City", user.getState() + " " + user.getCity());

        logger.info("Close modal window");
        formModalWindow.clickCloseModalButton();
    }
}
