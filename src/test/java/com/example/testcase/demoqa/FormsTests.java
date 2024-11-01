package com.example.testcase.demoqa;

import com.example.base.BaseWeb;
import com.example.driver.DriverManager;
import com.example.models.User;
import com.example.page.demoqa.MainPage;
import com.example.page.demoqa.PracticeFormPage;
import com.example.page.demoqa.components.FormModalWindow;
import com.example.page.demoqa.components.FormsSidebarMenu;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.example.page.demoqa.components.SidebarMenu;

public class FormsTests extends BaseWeb {
    private MainPage mainPage;
    private PracticeFormPage formPage;
    private FormModalWindow formModalWindow;
    private SidebarMenu sidebarMenu;
    private FormsSidebarMenu formsSidebarMenu;
    private Faker faker;
    private User user;
    private JavascriptExecutor js;

    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage();
        formPage = new PracticeFormPage();
        formModalWindow = new FormModalWindow();
        sidebarMenu = new SidebarMenu();
        formsSidebarMenu = new FormsSidebarMenu();
        faker = new Faker();
        user = new User();
        js = (JavascriptExecutor) DriverManager.getDriver();
        user.setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setUsername((user.getFirstName() + user.getLastName()).toLowerCase())
                .setPassword("Test!12345")
                .setEmail((user.getFirstName()+"."+user.getLastName()).toLowerCase()+"@fakemail.xyz")
                .setGender("Male")
                .setMobileNumber(String.valueOf(faker.number().digits(10)))
                .setDateOfBirth("08051995")
                .setSubjects(new String[]{"Maths", "Arts"})
                .setHobbies(new String[]{"Sports", "Reading", "Music"})
                .setPicture("src/resources/img.png")
                .setCurrentAddress(faker.address().fullAddress())
                .setState("NCR")
                .setCity("Noida");
    }

    @Test(description = "Check form filling")
    public void FillFormTest() throws InterruptedException {
        logger.info("Click on Forms Card");
        mainPage.clickFormsCard();

        Thread.sleep(1000);
        logger.info("Click on Login menu item in Sidebar");
        formsSidebarMenu.clickPracticeFormMenuItem();

        Thread.sleep(1000);
        logger.info("Fill firstname");
        formPage.fillFirstName(user.getFirstName());

        Thread.sleep(1000);
        logger.info("Fill lastname");
        formPage.fillLastName(user.getLastName());

        Thread.sleep(1000);
        logger.info("Fill email");
        formPage.fillEmailField(user.getEmail());

        Thread.sleep(1000);
        logger.info("Select Gender");
        formPage.selectGender(user.getGender());

        Thread.sleep(1000);
        logger.info("Fill Mobile Number");
        formPage.fillNumberField(user.getMobileNumber().toString());

//        logger.info("Fill Date of birth");
//        formPage.setDateOfBirth(user.getDateOfBirth());

//        Thread.sleep(2000);
//        logger.info("Fill Subjects");
//        formPage.fillSubjects(user.getSubjects());

        Thread.sleep(1000);
        logger.info("Select Hobbies");
        formPage.selectHobbies(user.getHobbies());
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Thread.sleep(1000);
        logger.info("Select Hobbies");
        formPage.selectHobbies(user.getHobbies());

        Thread.sleep(1000);
        logger.info("Fill Current Address");
        formPage.fillCurrentAddress(user.getCurrentAddress());

//        Thread.sleep(2000);
//        logger.info("Select State");
//        formPage.selectState(user.getState());
//
//        Thread.sleep(2000);
//        logger.info("Select City");
//        formPage.selectCity(user.getCity());

        Thread.sleep(1000);
        logger.info("Click Submit button");
        formPage.clickSubmitButton();

        Thread.sleep(2000);
        Assert.assertTrue(formModalWindow.getModalTable().isDisplayed());
    }
}
