package com.example.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {

    private static Properties properties = new Properties();
    private static final Logger logger = LoggerFactory.getLogger(PropertyUtils.class);

    static {
        try (InputStream input = PropertyUtils.class.getClassLoader().getResourceAsStream("testdata/testdata.properties")) {
            if (input == null) {
                logger.info("Sorry, unable to find testdata.properties");
            } else {
                properties.load(input);
            }
        } catch (IOException ex) {
            logger.info("IOException occurred while loading properties", ex);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}