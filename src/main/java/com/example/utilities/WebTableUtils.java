package com.example.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTableUtils {

    private final WebDriver driver;
    private final WebElement table;

    public WebTableUtils(WebDriver driver, WebElement table) {
        this.driver = driver;
        this.table = table;
    }

    /**
     * Gets the text from a specific table cell by row and column number.
     *
     * @param row    the row number (starting from 1).
     * @param column the column number (starting from 1).
     * @return the text of the cell.
     */
    public String getCellValue(int row, int column) {
        WebElement cell = table.findElement(By.xpath(".//tbody/tr[" + row + "]/td[" + column + "]"));
        return cell.getText();
    }

    /**
     * Gets an input element located in a specific cell of the table.
     *
     * @param row    the row number (starting from 1).
     * @param column the column number (starting from 1).
     * @return the WebElement input.
     */
    public WebElement getInputInCell(int row, int column) {
        return table.findElement(By.xpath(".//tbody/tr[" + row + "]/td[" + column + "]//input"));
    }

    /**
     * Searches for a row where the specific column contains the provided text.
     *
     * @param columnIndex the column number (starting from 1).
     * @param searchText  the text to search for.
     * @return the WebElement of the row containing the text.
     */
    public WebElement findRowByColumnText(int columnIndex, String searchText) {
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
        for (WebElement row : rows) {
            WebElement cell = row.findElement(By.xpath(".//td[" + columnIndex + "]"));
            if (cell.getText().equals(searchText)) {
                return row;
            }
        }
        return null; // If the row is not found
    }

    /**
     * Gets all values of a specific row by its index.
     *
     * @param rowIndex the row number (starting from 1).
     * @return a list of text values of all cells in the row.
     */
    public List<String> getRowValues(int rowIndex) {
        WebElement row = table.findElement(By.xpath(".//tbody/tr[" + rowIndex + "]"));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        return cells.stream().map(WebElement::getText).toList();
    }

    /**
     * Gets all values of a specific column.
     *
     * @param columnIndex the column number (starting from 1).
     * @return a list of text values of all cells in the column.
     */
    public List<String> getColumnValues(int columnIndex) {
        List<WebElement> cells = table.findElements(By.xpath(".//tbody/tr/td[" + columnIndex + "]"));
        return cells.stream().map(WebElement::getText).toList();
    }

    /**
     * Clicks a button located in a specific cell of the table.
     *
     * @param row    the row number (starting from 1).
     * @param column the column number (starting from 1).
     */
    public void clickButtonInCell(int row, int column) {
        WebElement button = table.findElement(By.xpath(".//tbody/tr[" + row + "]/td[" + column + "]//button"));
        button.click();
    }
}