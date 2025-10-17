package managers;

import enums.BrowserType;
import enums.ExecutionType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        if (driver.get() == null) {
            String browser = ConfigReader.get("browser").trim().toUpperCase();
            String execution = ConfigReader.get("execution").trim().toUpperCase();

            BrowserType browserType = BrowserType.valueOf(browser);
            ExecutionType executionType = ExecutionType.valueOf(execution);

            System.out.println("Launching " + browserType + " on " + executionType +
                    " | Thread ID: " + Thread.currentThread().getId());

            driver.set(createDriver(browserType, executionType));
        }
        return driver.get();
    }

    private WebDriver createDriver(BrowserType browserType, ExecutionType executionType) {
        return switch (executionType) {
            case LOCAL -> createLocalDriver(browserType);
            case REMOTE, GRID -> createRemoteDriver(browserType);
            case CLOUD -> createCloudDriver(browserType);
        };
    }

    private WebDriver createLocalDriver(BrowserType browserType) {
        return switch (browserType) {
            case CHROME -> {
                ChromeOptions options = new ChromeOptions();
                if (Boolean.parseBoolean(ConfigReader.get("headless"))) {
                    options.addArguments("--headless=new");
                }
                yield new ChromeDriver(options);
            }
            case FIREFOX -> new FirefoxDriver();
            case EDGE -> new EdgeDriver();
        };
    }

    private WebDriver createRemoteDriver(BrowserType browserType) {
        try {
            String gridUrl = ConfigReader.get("gridUrl");
            DesiredCapabilities capabilities = new DesiredCapabilities();

            switch (browserType) {
                case CHROME -> capabilities.setBrowserName("chrome");
                case FIREFOX -> capabilities.setBrowserName("firefox");
                case EDGE -> capabilities.setBrowserName("MicrosoftEdge");
            }

            System.out.println("Connecting to Selenium Grid: " + gridUrl);
            return new RemoteWebDriver(new URL(gridUrl), capabilities);

        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Grid URL", e);
        }
    }

    private WebDriver createCloudDriver(BrowserType browserType) {
        try {
            String cloudUrl = ConfigReader.get("cloudUrl");
            String username = ConfigReader.get("cloudUser");
            String key = ConfigReader.get("cloudKey");

            String fullUrl = "https://" + username + ":" + key + "@" + new URL(cloudUrl).getHost() + "/wd/hub";

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", browserType.name().toLowerCase());
            caps.setCapability("browserVersion", "latest");

            // 🧠 Example: BrowserStack/LambdaTest-specific capabilities
            Map<String, Object> bstackOptions = new HashMap<>();
            bstackOptions.put("os", "Windows");
            bstackOptions.put("osVersion", "11");
            bstackOptions.put("buildName", "Cucumber BDD Parallel Build");
            bstackOptions.put("sessionName", "BDD Test - " + browserType);
            bstackOptions.put("local", "false");
            caps.setCapability("bstack:options", bstackOptions);

            System.out.println("Connecting to Cloud: " + fullUrl);
            return new RemoteWebDriver(new URL(fullUrl), caps);

        } catch (Exception e) {
            throw new RuntimeException("Failed to connect to Cloud provider", e);
        }
    }

    public void quitDriver() {
        if (driver.get() != null) {
            System.out.println("Closing browser on Thread: " + Thread.currentThread().getId());
            driver.get().quit();
            driver.remove();
        }
    }
}
