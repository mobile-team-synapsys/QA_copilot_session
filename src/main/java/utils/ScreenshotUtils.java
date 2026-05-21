package utils;

import base.DriverFactory;
import config.ConfigReader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ScreenshotUtils - Captures screenshots on test failure or on demand.
 */
public class ScreenshotUtils {

    private static final Logger logger = LogManager.getLogger(ScreenshotUtils.class);

    /**
     * Captures a screenshot and saves it with the given test name.
     *
     * @param testName the name of the test case
     * @return the file path of the saved screenshot
     */
    public static String captureScreenshot(String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = testName + "_" + timestamp + ".png";
        String filePath = ConfigReader.getScreenshotPath() + fileName;

        try {
            File screenshotDir = new File(ConfigReader.getScreenshotPath());
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }

            TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File(filePath);
            FileUtils.copyFile(source, destination);

            logger.info("Screenshot saved: " + filePath);
        } catch (IOException e) {
            logger.error("Failed to capture screenshot: " + e.getMessage());
        }

        return filePath;
    }
}
