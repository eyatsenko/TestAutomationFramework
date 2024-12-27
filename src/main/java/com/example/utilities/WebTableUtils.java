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

    public List<WebElement> getAllRows() {
        return table.findElements(By.xpath("//div[@class='rt-tr-group']"));
    }

    public String getCellValueForColumn(WebElement row, int columnIndex) {
        WebElement cell = row.findElement(By.xpath(".//div[@class='rt-td']" + "[" + columnIndex + "]"));
        return cell.getText();
    }

    public WebElement findRowByCellText(String cellText) {
        List<WebElement> rows = getAllRows();
        for (int i = 1; i <= rows.size(); i++) {
            WebElement currentRow = table.findElement(By.xpath(".//div[@class='rt-tr-group']" + "[" + i + "]"));
            List<WebElement> cells = currentRow.findElements(By.xpath(".//div[@class='rt-td']"));
            for (WebElement cell : cells) {
                if (cell.getText().equals(cellText)) {
                    return currentRow;
                }
            }
        }
        return null;
    }

    public void findButtonWithTitleInCell(int row, int column, String title) {
        WebElement button = table.findElement(By.xpath(".//tbody/tr[" + row + "]/td[" +
                column + "]//button[@title=" + title + "]"));
    }
}