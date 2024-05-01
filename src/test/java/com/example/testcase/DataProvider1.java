package com.example.testcase;

import org.testng.annotations.DataProvider;

public class DataProvider1{
    @DataProvider(name = "testData")
    public String[][] getTestData() {
        return new String[][]{
                {"macro5vv@gmail.com", "Acer!1243"}
        };
    }
}

