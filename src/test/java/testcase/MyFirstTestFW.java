package testcase;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class MyFirstTestFW extends BaseTest {
    @Test
    public static void LoginTest() {
        System.out.println("Click on Sign in Button");
        driver.findElement(By.partialLinkText("Sign in")).click();

        System.out.println("Enter email");
        driver.findElement(By.id("login_id")).sendKeys("eduardyacenko@gmail.com");

        System.out.println("Click on next button");
        driver.findElement(By.id("nextbtn")).click();

        System.out.println("Enter password");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Apriorit!1672");

        System.out.println("Click on Next button");
        driver.findElement(By.xpath("//button[@id='nextbtn']//span[contains(text(),'Sign in')]")).click();
    }
}
