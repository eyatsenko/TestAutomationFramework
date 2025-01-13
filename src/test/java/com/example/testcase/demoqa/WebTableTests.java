package com.example.testcase.demoqa;

import com.example.base.AbstractBaseTest;
import com.example.models.User;
import com.example.page.demoqa.MainPage;
import com.example.page.demoqa.elements.ElementsSideBarMenu;
import com.example.page.demoqa.elements.RegistrationForm;
import com.example.page.demoqa.elements.WebTablesPage;
import com.example.utilities.RandomDataUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTableTests extends AbstractBaseTest {
    private MainPage mainPage;
    private ElementsSideBarMenu elementsSideBarMenu;
    private WebTablesPage webTablesPage;
    private RegistrationForm registrationForm;
    private User user;
    private User user2;

    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage();
        elementsSideBarMenu = new ElementsSideBarMenu();
        user = RandomDataUtils.getRandomUser();
        user2 = RandomDataUtils.getRandomUser();
    }

    @Test(description = "Check adding a new record", priority = 1)
    public void checkAddingNewRecordTest() {
        mainPage.openElementsPage();

        webTablesPage = elementsSideBarMenu.clickWebTablesMenuItem();
        registrationForm = webTablesPage.openRegistrationForm();
        registrationForm.fillFirstName(user.getFirstName())
                        .fillLastName(user.getLastName())
                        .fillEmail(user.getEmail())
                        .fillAge(user.getAge())
                        .fillSalary(user.getSalary())
                        .fillDepartment(user.getDepartment())
                        .submitUserData();

        webTablesPage.checkThatRowIsPresentInTheTable(user.getEmail())
                     .verifyFirstNameValue(user.getEmail(), user.getFirstName())
                     .verifyLastNameValue(user.getEmail(), user.getLastName())
                     .verifyEmailValue(user.getEmail(), user.getEmail())
                     .verifyAgeValue(user.getEmail(), user.getAge())
                     .verifySalaryValue(user.getEmail(), user.getSalary())
                     .verifyDepartmentValue(user.getEmail(), user.getDepartment());
    }

    @Test(description = "Check editing an existing record", priority = 2)
    public void checkEditingExistingRecordTest() {
        mainPage.openElementsPage();

        webTablesPage = elementsSideBarMenu.clickWebTablesMenuItem();

        registrationForm = webTablesPage.openEditWindowsForRecord("alden@example.com");
        registrationForm.checkThatRegistrationWindowIsOpenedForValidUser("alden@example.com")
                        .fillFirstName(user2.getFirstName())
                        .fillLastName(user2.getLastName())
                        .fillEmail(user2.getEmail())
                        .fillAge(user2.getAge())
                        .fillSalary(user2.getSalary())
                        .fillDepartment(user2.getDepartment())
                        .submitUserData();

        webTablesPage.checkThatRowIsPresentInTheTable(user2.getEmail())
                     .verifyFirstNameValue(user2.getEmail(), user2.getFirstName())
                     .verifyLastNameValue(user2.getEmail(), user2.getLastName())
                     .verifyEmailValue(user2.getEmail(), user2.getEmail())
                     .verifyAgeValue(user2.getEmail(), user2.getAge())
                     .verifySalaryValue(user2.getEmail(), user2.getSalary())
                     .verifyDepartmentValue(user2.getEmail(), user2.getDepartment());
    }

    @Test(description = "Check editing a new record", priority = 3)
    public void checkEditingNewRecordTest() {
        mainPage.openElementsPage();

        webTablesPage = elementsSideBarMenu.clickWebTablesMenuItem();
        registrationForm = webTablesPage.openRegistrationForm();
        registrationForm.fillFirstName(user.getFirstName())
                        .fillLastName(user.getLastName())
                        .fillEmail(user.getEmail())
                        .fillAge(user.getAge())
                        .fillSalary(user.getSalary())
                        .fillDepartment(user.getDepartment())
                        .submitUserData();

        registrationForm = webTablesPage.openEditWindowsForRecord(user.getEmail());
        registrationForm.checkThatRegistrationWindowIsOpenedForValidUser(user.getEmail())
                        .fillFirstName(user2.getFirstName())
                        .fillLastName(user2.getLastName())
                        .fillEmail(user2.getEmail())
                        .fillAge(user2.getAge())
                        .fillSalary(user2.getSalary())
                        .fillDepartment(user2.getDepartment())
                        .submitUserData();

        webTablesPage.checkThatRowIsPresentInTheTable(user2.getEmail())
                     .verifyFirstNameValue(user2.getEmail(), user2.getFirstName())
                     .verifyLastNameValue(user2.getEmail(), user2.getLastName())
                     .verifyEmailValue(user2.getEmail(), user2.getEmail())
                     .verifyAgeValue(user2.getEmail(), user2.getAge())
                     .verifySalaryValue(user2.getEmail(), user2.getSalary())
                     .verifyDepartmentValue(user2.getEmail(), user2.getDepartment());
    }

    @Test(description = "Check deleting an existing record", priority = 4)
    public void checkDeletingNewRecordTest() {
        mainPage.openElementsPage();

        webTablesPage = elementsSideBarMenu.clickWebTablesMenuItem();
        registrationForm = webTablesPage.openRegistrationForm();
        registrationForm.fillFirstName(user.getFirstName())
                        .fillLastName(user.getLastName())
                        .fillEmail(user.getEmail())
                        .fillAge(user.getAge())
                        .fillSalary(user.getSalary())
                        .fillDepartment(user.getDepartment())
                        .submitUserData();

        webTablesPage.checkThatRowIsPresentInTheTable(user.getEmail())
                     .verifyFirstNameValue(user.getEmail(), user.getFirstName())
                     .verifyLastNameValue(user.getEmail(), user.getLastName())
                     .verifyEmailValue(user.getEmail(), user.getEmail())
                     .verifyAgeValue(user.getEmail(), user.getAge())
                     .verifySalaryValue(user.getEmail(), user.getSalary())
                     .verifyDepartmentValue(user.getEmail(), user.getDepartment());

        webTablesPage.deleteRecordForUserWithEmail(user.getEmail())
                     .checkThatRowIsAbsentInTheTable(user.getEmail());
    }
}
