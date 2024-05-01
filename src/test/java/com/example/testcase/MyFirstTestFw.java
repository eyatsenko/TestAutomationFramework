package com.example.testcase;

import com.example.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class MyFirstTestFw extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(MyFirstTestFw.class);

    @Test (dataProvider = "testData")
    public static void LoginTest(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        logger.info("Click on Sign in Button");
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in")));
        loginButton.click();
        Assert.assertEquals(driver.getTitle(), "Zoho Accounts");

        logger.info("Enter email");
        WebElement loginIdField = wait.until(ExpectedConditions.elementToBeClickable(By.id("login_id")));
        loginIdField.sendKeys(username);

        logger.info("Click on next button");
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("nextbtn")));
        nextButton.click();

        logger.info("Enter password");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        element.click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

        logger.info("Click on Next button");
        WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='nextbtn']")));
        nextBtn.click();
        wait.until(ExpectedConditions.titleContains("Explore All Products | Zoho"));
        Assert.assertEquals(driver.getTitle(), "Explore All Products | Zoho");

        logger.info("Click on Profile button");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='head-sign-in zh_innr_nav']" +
                                                "/div[@class='zgh-user-box']/div[@class='zgh-userPanel']/img[1]")));
        driver.findElement(By.xpath("//div[@class='head-sign-in zh_innr_nav']" +
                                            "/div[@class='zgh-user-box']/div[@class='zgh-userPanel']/img[1]")).click();

        logger.info("Click on Logout button");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='zgh-userPanel active']" +
                                                                                "//a[normalize-space()='Sign Out']")));
        driver.findElement(By.xpath("//div[@class='zgh-userPanel active']//a[normalize-space()='Sign Out']")).click();
    }

    @DataProvider(name = "testData")
    public String[][] getTestData() {
        return new String[][] {
                {"eduardyacenko@gmail.com", "Apriorit!1672"},
        };
    }
}
