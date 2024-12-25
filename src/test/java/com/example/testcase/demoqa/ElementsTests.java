package com.example.testcase.demoqa;

import com.example.base.BaseTest;
import com.example.models.User;
import com.example.page.demoqa.MainPage;
import com.example.page.demoqa.elements.ElementsSideBarMenu;
import com.example.page.demoqa.elements.TextBoxPage;
import com.example.utilities.RandomDataUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @Test(description = "Check TextBox page filling with only User Name", priority = 2)
    public void fillTextBoxPageOnlyUserNameTest() {
        mainPage.openElementsPage();

        textBoxPage = elementsSideBarMenu.clickTextBoxMenuItem();

        textBoxPage.fillFullName(user.getFirstName() + " " + user.getLastName())
                   .submitData();

        textBoxPage.checkThatOutputIsDisplayed();
        textBoxPage.verifyOutputResult("Name", user.getFirstName() + " " + user.getLastName());
    }

    @Test(description = "Check TextBox page filling with only Email", priority = 3)
    public void fillTextBoxPageOnlyEmailTest() {
        mainPage.openElementsPage();

        textBoxPage = elementsSideBarMenu.clickTextBoxMenuItem();
        textBoxPage.fillEmail(user.getEmail())
                   .submitData();

        textBoxPage.checkThatOutputIsDisplayed();
        textBoxPage.verifyOutputResult("Email", user.getEmail());
    }

    @Test(description = "Check TextBox page filling with only Current Address", priority = 4)
    public void fillTextBoxPageOnlyCurrentAddressTest() {
        mainPage.openElementsPage();

        textBoxPage = elementsSideBarMenu.clickTextBoxMenuItem();
        textBoxPage.fillCurrentAddress(user.getCurrentAddress())
                   .submitData();

        textBoxPage.checkThatOutputIsDisplayed();
        textBoxPage.verifyOutputResult("Current Address", user.getCurrentAddress());
    }

    @Test(description = "Check TextBox page filling with only Permanent Address", priority = 5)
    public void fillTextBoxPageOnlyPermanentAddressTest() {
        mainPage.openElementsPage();

        textBoxPage = elementsSideBarMenu.clickTextBoxMenuItem();
        textBoxPage.fillPermanentAddress(user.getPermanentAddress())
                   .submitData();

        textBoxPage.checkThatOutputIsDisplayed();
        textBoxPage.verifyOutputResult("Permanent Address", user.getPermanentAddress());
    }

    @Test(description = "Check TextBox page filling with invalid Email", priority = 6,
                                                dataProvider = "invalidEmailProvider")
    public void fillTextBoxPageInvalidEmailTest(String invalidEmail) {
        mainPage.openElementsPage();

        textBoxPage = elementsSideBarMenu.clickTextBoxMenuItem();
        textBoxPage.fillEmail(invalidEmail)
                   .submitData();

        textBoxPage.checkThatOutputIsNotDisplayed();
        textBoxPage.checkThatEmailFieldIsHighlightedInRed();
    }

    @DataProvider(name = "invalidEmailProvider")
    public static Object[][] provideStrings() {
        return new Object[][]{
                {"user"},
                {"user@"},
                {"user@g"},
                {"user.com"},
                {"@test.com"},
                {"@"}
        };
    }
}
