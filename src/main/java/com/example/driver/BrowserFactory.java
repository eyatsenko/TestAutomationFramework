package com.example.driver;

import com.example.data.changeless.BrowserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;

import static com.example.config.ConfigurationManager.configuration;

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