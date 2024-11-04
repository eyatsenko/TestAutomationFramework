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

        logger.info("Fill firstname");
        formPage.fillFirstName(user.getFirstName());

        logger.info("Fill lastname");
        formPage.fillLastName(user.getLastName());

        logger.info("Fill email");
        formPage.fillEmailField(user.getEmail());

        logger.info("Select Gender");
        formPage.selectGender(user.getGender());

        logger.info("Fill Mobile Number");
        formPage.fillNumberField(user.getMobileNumber());

        logger.info("Click on Calendar");
        calendar = formPage.clickOnCalendar();

        logger.info("Fill Date of birth");
        calendar.setDate(12, "May", 2015);

        logger.info("Fill Subjects");
        formPage.fillSubjects(user.getSubjects());

        logger.info("Select Hobbies");
        formPage.selectHobbies(user.getHobbies());
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        logger.info("Select Picture");
        formPage.uploadPicture(user.getPicture());

        logger.info("Fill Current Address");
        formPage.fillCurrentAddress(user.getCurrentAddress());

        logger.info("Select State");
        formPage.selectState(user.getState());

        logger.info("Select City");
        formPage.selectCity(user.getCity());

        logger.info("Click Submit button");
        formPage.clickSubmitButton();

        Assert.assertTrue(formModalWindow.isModalTableDisplayed());
    }
}
