package com.example.testcase.demoqa;

import com.example.base.BaseTest;
import com.example.models.User;
import com.example.page.demoqa.MainPage;
import com.example.page.demoqa.elements.ElementsSideBarMenu;
import com.example.page.demoqa.elements.TextBoxPage;
import com.example.utilities.RandomDataUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsTests extends BaseTest {
    private MainPage mainPage;
    private ElementsSideBarMenu elementsSideBarMenu;
    private TextBoxPage textBoxPage;
    private User user;

    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage();
        elementsSideBarMenu = new ElementsSideBarMenu();
        user = RandomDataUtils.getRandomUser();
    }

    @Test(description = "Check TextBox page filling with all valid data", priority = 1)
    public void fillTextBoxPageAllDataTest() {
        mainPage.openElementsPage();

        textBoxPage = elementsSideBarMenu.clickTextBoxMenuItem();

        textBoxPage.fillFullName(user.getFirstName() + " " + user.getLastName())
                   .fillEmail(user.getEmail())
                   .fillCurrentAddress(user.getCurrentAddress())
                   .fillPermanentAddress(user.getPermanentAddress())
                   .submitData();

        textBoxPage.checkThatOutputIsDisplayed();

        textBoxPage.verifyOutputResult("Name", user.getFirstName() + " " + user.getLastName());
        textBoxPage.verifyOutputResult("Email", user.getEmail());
        textBoxPage.verifyOutputResult("Current Address", user.getCurrentAddress());
        textBoxPage.verifyOutputResult("Permanent Address", user.getPermanentAddress());
    }
}
