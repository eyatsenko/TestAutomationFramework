package com.example.utilities;

import com.example.driver.DriverManager;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WaitUtils {
    public static void waitForSeconds(int seconds) {
        WebDriver driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
}
