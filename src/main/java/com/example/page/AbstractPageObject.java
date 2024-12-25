package com.example.page;

import com.example.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.time.Duration;

import static com.example.config.ConfigurationManager.configuration;
import static org.openqa.selenium.support.PageFactory.initElements;

public class AbstractPageObject {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected String redColor = "rgb(220, 53, 69)";

    protected AbstractPageObject() {
        initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), configuration().timeout()), this);
    }

    public String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    public void checkThatElementIsHighlightedInColor(WebElement element, String color) {
        try {
            waitForBorderColorChange(element, color);
        } catch (Exception e) {
            logger.error("Expected color: {}, but found: {}", color, element.getCssValue("border-color"), e);
            Assert.fail("Element is not highlighted in the expected color: " + color);
        }
    }

    public void waitForBorderColorChange(WebElement element, String expectedColor) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(2))
                .until(driver -> element.getCssValue("border-color").equals(expectedColor));
    }
}