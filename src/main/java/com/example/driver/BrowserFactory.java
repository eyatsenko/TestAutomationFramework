package com.example.driver;

import com.example.data.changeless.BrowserData;
import com.example.exceptions.HeadlessNotSupportedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;

import static com.example.config.ConfigurationManager.configuration;
import static java.lang.Boolean.TRUE;

public enum BrowserFactory {

    CHROME {
        @Override
        public WebDriver createLocalDriver() {
            return new ChromeDriver(getOptions());
        }

        @Override
        public WebDriver createTestContainerDriver() {
            BrowserWebDriverContainer<?> driverContainer = new BrowserWebDriverContainer<>()
                                                                                .withCapabilities(new ChromeOptions());
            driverContainer.start();

            return new RemoteWebDriver(driverContainer.getSeleniumAddress(), new ChromeOptions());
        }

        @Override
        public ChromeOptions getOptions() {
            var chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(BrowserData.getDefaultOptions());

            if (configuration().headless()) {
                chromeOptions.addArguments(BrowserData.getChromeHeadlessOption());
            }

            return chromeOptions;
        }
    }, FIREFOX {
        @Override
        public WebDriver createLocalDriver() {
            return new FirefoxDriver(getOptions());
        }

        @Override
        public WebDriver createTestContainerDriver() {
            BrowserWebDriverContainer<?> driverContainer = new BrowserWebDriverContainer<>()
                                                                                .withCapabilities(new FirefoxOptions());
            driverContainer.start();

            return new RemoteWebDriver(driverContainer.getSeleniumAddress(), new FirefoxOptions());
        }

        @Override
        public FirefoxOptions getOptions() {
            var firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments(BrowserData.getDefaultOptions());

            if (configuration().headless()) {
                firefoxOptions.addArguments(BrowserData.getGenericHeadlessOption());
            }

            return firefoxOptions;
        }
    }, EDGE {
        @Override
        public WebDriver createLocalDriver() {
            return new EdgeDriver(getOptions());
        }

        public WebDriver createTestContainerDriver() {
            BrowserWebDriverContainer<?> driverContainer = new BrowserWebDriverContainer<>()
                                                                                   .withCapabilities(new EdgeOptions());
            driverContainer.start();

            return new RemoteWebDriver(driverContainer.getSeleniumAddress(), new EdgeOptions());
        }

        @Override
        public EdgeOptions getOptions() {
            var edgeOptions = new EdgeOptions();
            edgeOptions.addArguments(BrowserData.getDefaultOptions());

            if (configuration().headless()) {
                edgeOptions.addArguments(BrowserData.getGenericHeadlessOption());
            }

            return edgeOptions;
        }
    }, SAFARI {
        @Override
        public WebDriver createLocalDriver() {
            return new SafariDriver(getOptions());
        }

        public WebDriver createTestContainerDriver() {
            throw new IllegalArgumentException("Browser Safari not supported on TestContainers yet");
        }

        @Override
        public SafariOptions getOptions() {
            var safariOptions = new SafariOptions();
            safariOptions.setAutomaticInspection(false);

            if (TRUE.equals(configuration().headless()))
                throw new HeadlessNotSupportedException(safariOptions.getBrowserName());

            return safariOptions;
        }
    };

    /**
     * Used to run local tests where the WebDriverManager will take care of the driver
     *
     * @return a new WebDriver instance based on the browser set
     */
    public abstract WebDriver createLocalDriver();

    /**
     * @return a new AbstractDriverOptions instance based on the browser set
     */
    public abstract AbstractDriverOptions<?> getOptions();

    /**
     * Used to run the remote test execution using Testcontainers
     *
     * @return a new WebDriver instance based on the browser set
     */
    public abstract WebDriver createTestContainerDriver();
}