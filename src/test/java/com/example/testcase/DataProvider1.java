package com.example.testcase;

import com.example.utilities.PropertyUtils;
import org.testng.annotations.DataProvider;

public class DataProvider1{
    private final String username = PropertyUtils.getProperty("username");;
    private final String password = PropertyUtils.getProperty("password");;

    @DataProvider(name = "testData")
    public String[][] getTestData() {
        return new String[][]{
                {username, password}
        };
    }
}

