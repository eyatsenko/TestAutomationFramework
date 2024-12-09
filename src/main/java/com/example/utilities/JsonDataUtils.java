package com.example.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;

public class JsonDataUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T[] loadTestData(String fileName, Class<T[]> clazz) {
        try (InputStream inputStream = JsonDataUtils.class.getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new IOException("File not found: " + fileName);
            }
            return mapper.readValue(inputStream, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Error loading JSON test data", e);
        }
    }
}
