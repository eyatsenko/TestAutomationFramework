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
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user.getEmail()), "First Name",
                             user.getFirstName())
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user.getEmail()), "Last Name",
                             user.getLastName())
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user.getEmail()), "Email",
                             user.getEmail())
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user.getEmail()), "Age",
                             user.getAge())
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user.getEmail()), "Salary",
                             user.getSalary())
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user.getEmail()), "Department",
                             user.getDepartment().trim());
    }

    @Test(description = "Check editing an existing record", priority = 2, enabled = false)
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
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user2.getEmail()), "First Name",
                             user2.getFirstName())
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user2.getEmail()), "Last Name",
                             user2.getLastName())
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user2.getEmail()), "Email",
                             user2.getEmail())
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user2.getEmail()), "Age",
                             user2.getAge())
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user2.getEmail()), "Salary",
                             user2.getSalary())
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user2.getEmail()), "Department",
                             user2.getDepartment());
    }

    @Test(description = "Check editing a new record", priority = 3, enabled = false)
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
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user2.getEmail()), "First Name",
                             user2.getFirstName())
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user2.getEmail()), "Last Name",
                             user2.getLastName())
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user2.getEmail()), "Email",
                             user2.getEmail())
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user2.getEmail()), "Age",
                             user2.getAge())
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user2.getEmail()), "Salary",
                             user2.getSalary())
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user2.getEmail()), "Department",
                             user2.getDepartment());
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
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user.getEmail()), "First Name",
                             user.getFirstName())
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user.getEmail()), "Last Name",
                             user.getLastName())
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user.getEmail()), "Email",
                             user.getEmail())
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user.getEmail()), "Age",
                             user.getAge())
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user.getEmail()), "Salary",
                             user.getSalary())
                     .verifyCellValueInRow(webTablesPage.findRowInTableByEmail(user.getEmail()), "Department",
                             user.getDepartment());
        webTablesPage.deleteRecordForUserWithEmail(user.getEmail());
        webTablesPage.checkThatRowIsAbsentInTheTable(user.getEmail());
    }
    //TODO: Add new tests
}
