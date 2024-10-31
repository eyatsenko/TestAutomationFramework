package com.example.utilities;

import com.example.models.LoginData;
import org.testng.annotations.DataProvider;

public class LoginTestDataUtils {
    private final String username = PropertyUtils.getProperty("username");
    private final String password = PropertyUtils.getProperty("password");

    @DataProvider(name = "testDataProp")
    public String[][] getPropTestData() {
        return new String[][]{
                {username, password}
        };
    }

    @DataProvider(name = "testDataJson")
    public Object[][] getJsonTestData() {
        LoginData[] loginDataArray = JsonDataUtils.loadTestData("testdata/loginTestData.json", LoginData[].class);
        Object[][] data = new Object[loginDataArray.length][2];
        for (int i = 0; i < loginDataArray.length; i++) {
            data[i][0] = loginDataArray[i].getUsername();
            data[i][1] = loginDataArray[i].getPassword();
        }
        return data;
    }
}

