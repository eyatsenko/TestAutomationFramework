package com.example.page.demoqa.elements;

import com.example.page.AbstractPageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxPage extends AbstractPageObject {
    @FindBy(xpath = "//button[@title='Expand all']")
    private WebElement expandButton;

    @FindBy(xpath = "//button[@title='Collapse all']")
    private WebElement collapseButton;

    @FindBy(xpath = "//label[@for='tree-node-notes']")
    private WebElement notesNode;

    @FindBy(xpath = "//label[@for='tree-node-commands']")
    private WebElement commandsNode;

}
