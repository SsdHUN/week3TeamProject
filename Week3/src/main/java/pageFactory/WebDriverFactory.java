package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverFactory {

    private static WebDriver webDriver = null;
    public static WebDriver createWebDriver(String browserName) {
        if (webDriver == null){
            switch (browserName) {
                case "Firefox":
                    webDriver = new FirefoxDriver();
                    break;
                case "Chrome":
                default:
                    webDriver = new ChromeDriver();
                    break;
            }
        }
        return webDriver;
    }
    public static void shutDown() {
        webDriver.quit();
        webDriver = null;
    }
}