package com.example.page.demoqa.elements;

import com.example.driver.DriverManager;
import com.example.page.AbstractPageObject;
import com.example.utilities.JsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.example.driver.DriverManager.waitUtils;
import static org.testng.Assert.assertEquals;

@SuppressWarnings("unused")
public class CheckBoxPage extends AbstractPageObject {
    @FindBy(xpath = "//button[@title='Expand all']")
    private WebElement expandButton;

    @FindBy(xpath = "//button[@title='Collapse all']")
    private WebElement collapseButton;

    @FindBy(xpath = "//label[@for='tree-node-notes']")
    private WebElement notesNode;

    @FindBy(xpath = "//label[@for='tree-node-commands']")
    private WebElement commandsNode;

    @FindBy(id = "result")
    private WebElement result;

    @Step("Select one Node")
    public void selectOneNode(String nodeName) {
        WebElement node;
        logger.info("Selecting node with name '{}'", nodeName);
        if (nodeName.equals("Word File.doc")) {
            node = DriverManager.getDriver().findElement(By.xpath("//label[@for='tree-node-wordFile']"));
        } else if (nodeName.equals("Excel File.doc")) {
            node = DriverManager.getDriver().findElement(By.xpath("//label[@for='tree-node-excelFile']"));
        } else {
            node = DriverManager.getDriver().findElement(By.xpath("//label[@for='tree-node-" +
                    nodeName.toLowerCase() + "']"));
        }
        JsUtils.scrollToElement(node);
        waitUtils.waitForElementToBeClickable(node);
        node.click();
    }

    @Step("Expand all nodes")
    public void expandAllNodes() {
        logger.info("Expand all nodes");
        waitUtils.waitForElementToBeClickable(expandButton);
        expandButton.click();
    }

    @Step
    public void checkThatNodeIsSelected(String nodeName) {
        logger.info("Check that node '{}' and sub-nodes are selected", nodeName);
        JsUtils.scrollToBottom();
        waitUtils.waitForElementToBeVisible(result);
        switch (nodeName) {
            case "Home": {
                assertEquals(result.getText(), "You have selected :\n" +
                        "home\n" +
                        "desktop\n" +
                        "notes\n" +
                        "commands\n" +
                        "documents\n" +
                        "workspace\n" +
                        "react\n" +
                        "angular\n" +
                        "veu\n" +
                        "office\n" +
                        "public\n" +
                        "private\n" +
                        "classified\n" +
                        "general\n" +
                        "downloads\n" +
                        "wordFile\n" +
                        "excelFile");
                break;
            }
            case "Desktop": {
                assertEquals(result.getText(), "You have selected :\n" +
                        "desktop\n" +
                        "notes\n" +
                        "commands");
                break;
            }
            case "Documents": {
                assertEquals(result.getText(), "You have selected :\n" +
                        "documents\n" +
                        "workspace\n" +
                        "react\n" +
                        "angular\n" +
                        "veu\n" +
                        "office\n" +
                        "public\n" +
                        "private\n" +
                        "classified\n" +
                        "general");
                break;
            }
            case "WorkSpace": {
                assertEquals(result.getText(), "You have selected :\n" +
                        "workspace\n" +
                        "react\n" +
                        "angular\n" +
                        "veu");
                break;
            }
            case "Office": {
                assertEquals(result.getText(), "You have selected :\n" +
                        "office\n" +
                        "public\n" +
                        "private\n" +
                        "classified\n" +
                        "general");
                break;
            }
            case "Downloads": {
                assertEquals(result.getText(), "You have selected :\n" +
                        "downloads\n" +
                        "wordFile\n" +
                        "excelFile");
                break;
            }
            case "Word File.doc": {
                assertEquals(result.getText(), "You have selected :\n" +
                        "wordFile");
                break;
            }
            case "Excel File.doc": {
                assertEquals(result.getText(), "You have selected :\n" +
                        "excelFile");
                break;
            }
            default: {
                Assert.assertTrue(result.getText().contains(nodeName.toLowerCase()));
            }
        }
    }
}
