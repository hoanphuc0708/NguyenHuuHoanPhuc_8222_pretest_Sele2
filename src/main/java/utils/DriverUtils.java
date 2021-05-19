package utils;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.remote.BrowserType.CHROME;

public class DriverUtils {
    private static ThreadLocal<String> driverType = new ThreadLocal<>();

    private static String getDriverType() {
        if (driverType != null && driverType.get() == null) {
            driverType.set(CHROME);
        }
        return driverType.get();
    }

    public static void setDriverType(String type) {
        if (driverType != null && driverType.get() == null) {
            driverType.set(type);
        }
    }

    public static WebDriver getDriver() {
        return DriverFactory.valueOf(getDriverType().toUpperCase())
                .getDriverManager()
                .getDriver();
    }

    public static void quitDriver() {
        DriverFactory.valueOf(getDriverType().toUpperCase())
                .getDriverManager()
                .quitDriver();
    }

    public static String getCurrentURL() {
        return getWebDriver().getCurrentUrl();
    }

    public static void navigate(String url) {
        getWebDriver().get(url);
    }

    public static WebDriver getWebDriver() {
        return getDriver();
    }
}