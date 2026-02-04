package com.kroll.Automation.Framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir")
                + "/src/main/java/com/kroll/Automation/Framework/config/Config.properties"
            );

            properties = new Properties();
            properties.load(fis);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load Config.properties file", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
