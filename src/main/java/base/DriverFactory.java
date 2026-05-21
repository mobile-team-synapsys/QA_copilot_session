package base;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

/**
 * DriverFactory - Manages WebDriver instances using ThreadLocal for parallel execution.
 * Supports Chrome, Firefox, and Edge browsers.
 */
public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Initializes WebDriver based on configuration settings.
     */
    public static WebDriver initDriver() {
        String browser = ConfigReader.getBrowser().toLowerCase();
        boolean headless = ConfigReader.isHeadless();

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless=new");
                }
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--window-size=1920,1080");
                driver.set(new ChromeDriver(chromeOptions));
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) {
                    firefoxOptions.addArguments("--headless");
                }
                driver.set(new FirefoxDriver(firefoxOptions));
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                if (headless) {
                    edgeOptions.addArguments("--headless=new");
                }
                driver.set(new EdgeDriver(edgeOptions));
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        WebDriver webDriver = driver.get();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getImplicitWait()));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigReader.getPageLoadTimeout()));
        webDriver.manage().window().maximize();

        return webDriver;
    }

    /**
     * Returns the current thread's WebDriver instance.
     */
    public static WebDriver getDriver() {
        return driver.get();
    }

    /**
     * Quits the WebDriver and removes it from ThreadLocal.
     */
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
