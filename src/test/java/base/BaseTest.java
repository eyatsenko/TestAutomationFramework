package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static Properties locators = new Properties();
    private FileReader fileReaderProperties;
    private FileReader fileReaderLocators;

    @BeforeTest
    public void setUp () throws IOException {
        if (driver == null) {
            fileReaderProperties = new FileReader( System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
//            fileReaderLocators = new FileReader( System.getProperty("user.dir") + "\\src\\test\\resources\\locators.properties");
            prop.load(fileReaderProperties);
//            locators.load(fileReaderLocators);
        }

        switch (prop.getProperty("browser")) {
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.get(prop.getProperty("testurl"));
                break;
            }
            case "safari": {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                driver.manage().window().maximize();
                driver.get(prop.getProperty("testurl"));
                break;
            }
            case "edge": {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.get(prop.getProperty("testurl"));
                break;
            }
            default: {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get(prop.getProperty("testurl"));
                break;
            }
        }
    }

    @AfterTest
    public void tearDown () {
        driver.quit();
        System.out.println("Driver has been closed!");
    }
}
