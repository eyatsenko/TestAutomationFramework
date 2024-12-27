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

    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage();
        elementsSideBarMenu = new ElementsSideBarMenu();
        user = RandomDataUtils.getRandomUser();
    }

    @Test(description = "Check adding a new record", priority = 1)
    public void checkAddingNewRecordTest() {
        mainPage.openElementsPage();

        webTablesPage = elementsSideBarMenu.clickWebTablesMenuItem();
        registrationForm = webTablesPage.openRegistrationForm();
        registrationForm.fillFirstName(user.getFirstName())
                        .fillLastName(user.getLastName())
                        .fillEmail(user.getEmail())
                        .fillAge("35")
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
    }

    //TODO: Add new tests
}
