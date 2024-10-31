package com.example.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected static WebDriver driver;
    protected static Properties prop = new Properties();
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeTest
    public void setUp() {
        String propFileName = System.getProperty("user.dir") + "\\src\\test\\resources\\general.properties";
        try (FileReader fileReaderProperties = new FileReader(propFileName)) {
            if (driver == null) {
                prop.load(fileReaderProperties);
            }
            switch (prop.getProperty("browser")) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    maximizeAndOpenUrl();
                    break;
                }
                case "safari": {
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
                    maximizeAndOpenUrl();
                    break;
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
                    maximizeAndOpenUrl();
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
                    maximizeAndOpenUrl();
                    break;
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public void maximizeAndOpenUrl() {
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url.base"));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        logger.info("Driver has been closed!");
    }
}
