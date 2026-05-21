package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import config.ConfigReader;

/**
 * RetryAnalyzer - Retries failed tests based on configured retry count.
 */
public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;

    @Override
    public boolean retry(ITestResult result) {
        int maxRetryCount = ConfigReader.getRetryCount();
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
