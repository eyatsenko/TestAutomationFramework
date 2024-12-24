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

import static com.example.config.ConfigurationManager.configuration;

public enum BrowserFactory {

    CHROME {
        @Override
        public WebDriver createLocalDriver() {
            return new ChromeDriver(getOptions());
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

    public abstract WebDriver createLocalDriver();

    public abstract AbstractDriverOptions<?> getOptions();
}