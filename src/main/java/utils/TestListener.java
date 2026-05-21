package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * TestListener - TestNG listener for logging test execution and capturing screenshots on failure.
 */
public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("========== STARTING TEST: " + result.getName() + " ==========");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("========== TEST PASSED: " + result.getName() + " ==========");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("========== TEST FAILED: " + result.getName() + " ==========");
        logger.error("Failure reason: " + result.getThrowable().getMessage());

        // Capture screenshot on failure
        String screenshotPath = ScreenshotUtils.captureScreenshot(result.getName());
        logger.info("Failure screenshot saved at: " + screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("========== TEST SKIPPED: " + result.getName() + " ==========");
    }
}
