package com.example.base;

import com.example.driver.DriverManager;
import com.example.driver.TargetFactory;
import com.example.report.AllureManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static com.example.config.ConfigurationManager.configuration;

public abstract class BaseWeb {

    @BeforeSuite
    public void beforeSuite() {
        AllureManager.setAllureEnvironmentInformation();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void preCondition(@Optional("chrome") String browser) {
        WebDriver driver = new TargetFactory().createInstance(browser);
        DriverManager.setDriver(driver);

        DriverManager.getDriver().get(configuration().url());
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        DriverManager.quit();
    }
}
