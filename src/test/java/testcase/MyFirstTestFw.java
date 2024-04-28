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
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in")));
        loginButton.click();
        Assert.assertEquals(driver.getTitle(), "Zoho Accounts");

        System.out.println("Enter email");
        WebElement loginIdField = wait.until(ExpectedConditions.elementToBeClickable(By.id("login_id")));
        loginIdField.sendKeys(username);

        System.out.println("Click on next button");
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("nextbtn")));
        nextButton.click();

        System.out.println("Enter password");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        element.click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

        System.out.println("Click on Next button");
        WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(By
                                                .xpath("//button[@id='nextbtn']//span[contains(text(),'Sign in')]")));
        nextBtn.click();
        wait.until(ExpectedConditions.titleContains("Explore All Products | Zoho"));
        Assert.assertEquals(driver.getTitle(), "Explore All Products | Zoho");

        System.out.println("Click on Profile button");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/main/div[@class='zw-template-inner']/" +
                "div[@class='zh-main']/" +
                "div[@class='load-header']/div[@class='zh-header']/div[@class='zh-wrap']/div[@class='zgh-left-nav']/" +
                "div[@class='flx zh-utilities']/div[@class='head-sign-in zh_innr_nav']/div[@class='zgh-user-box']" +
                "/div[@class='zgh-userPanel']/img[1]")));
        driver.findElement(By.xpath("//body/main/div[@class='zw-template-inner']/div[@class='zh-main']/" +
                "div[@class='load-header']/div[@class='zh-header']/div[@class='zh-wrap']/div[@class='zgh-left-nav']/" +
                "div[@class='flx zh-utilities']/div[@class='head-sign-in zh_innr_nav']/div[@class='zgh-user-box']" +
                "/div[@class='zgh-userPanel']/img[1]")).click();

        System.out.println("Click on Logout button");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='zgh-userPanel active']" +
                                                                                "//a[normalize-space()='Sign Out']")));
        driver.findElement(By.xpath("//div[@class='zgh-userPanel active']//a[normalize-space()='Sign Out']")).click();
    }
}
