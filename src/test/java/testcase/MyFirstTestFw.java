package testcase;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.ReadXlsData;

public class MyFirstTestFw extends BaseTest {
    @Test (dataProviderClass = ReadXlsData.class, dataProvider = "testData")
    public static void LoginTest(String username, String password) {
        System.out.println("Click on Sign in Button");
        driver.findElement(By.partialLinkText(locators.getProperty("signin_link"))).click();

        System.out.println("Enter email");
        driver.findElement(By.id(locators.getProperty("email_field"))).sendKeys(username);

        System.out.println("Click on next button");
        driver.findElement(By.id(locators.getProperty("next_button"))).click();

        System.out.println("Enter password");
        driver.findElement(By.xpath(locators.getProperty("pwd_field"))).sendKeys(password);

        System.out.println("Click on Next button");
        driver.findElement(By.xpath(locators.getProperty("login_next_button"))).click();
    }
}
