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

        //TODO: Add asserts
    }
}
