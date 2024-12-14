package com.example.base;

import com.example.driver.DriverManager;
import com.example.driver.TargetFactory;
import com.example.report.AllureManager;
import com.example.utilities.ScreenshotUtil;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.config.ConfigurationManager.configuration;

public abstract class BaseTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeSuite
    public void beforeSuite() {
        AllureManager.setAllureEnvironmentInformation();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void preCondition(@Optional("chrome") String browser) {
        Allure.step("WebDriver instantiating...");
        WebDriver driver = new TargetFactory().createInstance(browser);
        DriverManager.setDriver(driver);
        DriverManager.getDriver().get(configuration().url());
    }

    protected void logAndStep(String stepDescription) {
        Allure.step(stepDescription);
        logger.info(stepDescription);
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {
            File screenshot = ScreenshotUtil.takeScreenshot(DriverManager.getDriver());
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            Allure.addAttachment("screenshot_" + timestamp, FileUtils.openInputStream(screenshot));
        }
        Allure.step("WebDriver quiting...");
        DriverManager.quit();
    }
}
