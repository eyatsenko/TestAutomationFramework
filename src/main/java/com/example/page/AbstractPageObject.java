package com.example.page;

import com.example.driver.DriverManager;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.example.config.ConfigurationManager.configuration;
import static org.openqa.selenium.support.PageFactory.initElements;

public class AbstractPageObject {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected AbstractPageObject() {
        initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), configuration().timeout()), this);
    }

    public String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }
}