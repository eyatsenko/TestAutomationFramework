package testcase;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReadXlsData;

import java.time.Duration;

public class MyFirstTestFw extends BaseTest {
    @Test (dataProviderClass = ReadXlsData.class, dataProvider = "testData")
    public static void LoginTest(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        System.out.println("Click on Sign in Button");
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By
                                                                    .linkText(locators.getProperty("signin_link"))));
        loginButton.click();
        Assert.assertEquals(driver.getTitle(), "Zoho Accounts");

        System.out.println("Enter email");
        WebElement loginIdField = wait.until(ExpectedConditions.elementToBeClickable(By
                                                                            .id(locators.getProperty("email_field"))));
        loginIdField.sendKeys(username);

        System.out.println("Click on next button");
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By
                                                                            .id(locators.getProperty("next_button"))));
        nextButton.click();

        System.out.println("Enter password");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locators
                                                                                          .getProperty("pwd_field"))));
        element.click();
        driver.findElement(By.xpath(locators.getProperty("pwd_field"))).sendKeys(password);

        System.out.println("Click on Next button");
        WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locators
                                                                                   .getProperty("login_next_button"))));
        nextBtn.click();
        wait.until(ExpectedConditions.titleContains("Explore All Products | Zoho"));
        Assert.assertEquals(driver.getTitle(), "Explore All Products | Zoho");

        System.out.println("Click on Profile button");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locators.getProperty("profile_icon"))));
        driver.findElement(By.xpath(locators.getProperty("profile_icon"))).click();

        System.out.println("Click on Logout button");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locators.getProperty("logout_button"))));
        driver.findElement(By.xpath(locators.getProperty("logout_button"))).click();
    }
}
