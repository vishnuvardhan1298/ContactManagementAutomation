package com.cm.framework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestData {
    private static Properties props = new Properties();

    static {
        // Change the path below if your file is inside a folder in resources
    	String filePath = "testdata.properties";

 // <-- update if needed

        try (InputStream is = TestData.class.getClassLoader().getResourceAsStream(filePath)) {
            if (is == null) {
                throw new RuntimeException("Properties file not found in classpath: " + filePath);
            }
            props.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load test data from " + filePath, e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }

    public static String randomEmail() {
        return "user" + System.currentTimeMillis() + "@example.com";
    }

    public static String randomPhone() {
        String s = String.valueOf(System.currentTimeMillis());
        return s.substring(s.length() - 10);
    }
}
