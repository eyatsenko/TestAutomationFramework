package com.example.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("\\src\\test\\resources\\config.properties");
        Properties properties = new Properties();
        properties.load(fileReader);
    }
}