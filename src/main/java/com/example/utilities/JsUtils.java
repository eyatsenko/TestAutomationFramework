package com.example.utilities;

import com.example.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JsUtils {

    private static JavascriptExecutor getJsExecutor() {
        return (JavascriptExecutor) DriverManager.getDriver();
    }

    public static void scrollToBottom() {
        getJsExecutor().executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public static void scrollToTop() {
        getJsExecutor().executeScript("window.scrollTo(0, 0);");
    }

    public static void scrollToElement(WebElement element) {
        getJsExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void clickElement(WebElement element) {
        getJsExecutor().executeScript("arguments[0].click();", element);
    }

    public static void setInputValue(WebElement element, String value) {
        getJsExecutor().executeScript("arguments[0].value = arguments[1];", element, value);
    }

    public static String getElementText(WebElement element) {
        return (String) getJsExecutor().executeScript("return arguments[0].textContent;", element);
    }

    public static void setElementStyle(WebElement element, String style) {
        getJsExecutor().executeScript("arguments[0].style = arguments[1];", element, style);
    }

    public static Object executeScript(String script, Object... args) {
        return getJsExecutor().executeScript(script, args);
    }

    public static void waitForPageLoad() {
        getJsExecutor().executeScript(
                "return document.readyState === 'complete' ? true : false;"
        );
    }
}
