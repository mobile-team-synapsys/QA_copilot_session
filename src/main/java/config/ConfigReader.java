package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigReader - Reads configuration properties from config.properties file.
 * Provides centralized access to all configuration values.
 */
public class ConfigReader {

    private static Properties properties;
    private static final String CONFIG_PATH = "src/test/resources/config.properties";

    static {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(CONFIG_PATH);
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found in config.properties");
        }
        return value.trim();
    }

    public static String getBaseUrl() {
        return getProperty("base.url");
    }

    public static String getAdminUrl() {
        return getProperty("admin.url");
    }

    public static String getBrowser() {
        return getProperty("browser");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(getProperty("headless"));
    }

    public static int getImplicitWait() {
        return Integer.parseInt(getProperty("implicit.wait"));
    }

    public static int getExplicitWait() {
        return Integer.parseInt(getProperty("explicit.wait"));
    }

    public static int getPageLoadTimeout() {
        return Integer.parseInt(getProperty("page.load.timeout"));
    }

    public static String getAdminUsername() {
        return getProperty("admin.username");
    }

    public static String getAdminPassword() {
        return getProperty("admin.password");
    }

    public static String getUserUsername() {
        return getProperty("user.username");
    }

    public static String getUserPassword() {
        return getProperty("user.password");
    }

    public static String getScreenshotPath() {
        return getProperty("screenshot.path");
    }

    public static boolean screenshotOnFailure() {
        return Boolean.parseBoolean(getProperty("screenshot.on.failure"));
    }

    public static int getRetryCount() {
        return Integer.parseInt(getProperty("retry.count"));
    }

    public static String getReportPath() {
        return getProperty("report.path");
    }
}
