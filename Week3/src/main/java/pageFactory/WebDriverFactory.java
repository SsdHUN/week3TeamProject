package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;


public class WebDriverFactory {

    static String gridUrl = String.format("https://selenium:%s@seleniumhub.codecool.metastage.net/wd/hub", Util.VALID_PASSWORD);

    private static WebDriver webDriver = null;

    public static WebDriver createWebDriver(String browserName, boolean isRemote) throws MalformedURLException {
        if (webDriver == null) {
            if (!isRemote) {
                switch (browserName) {
                    case "Firefox":
                        webDriver = new FirefoxDriver();
                        break;
                    case "Chrome": {
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--remote-allow-origins=*");
                        webDriver = new ChromeDriver(chromeOptions);
                    }
                }
            } else {
                if (Objects.equals(browserName, "Chrome")) {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    webDriver = new RemoteWebDriver(new URL(gridUrl), chromeOptions);
                } else {
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    webDriver = new RemoteWebDriver(new URL(gridUrl), firefoxOptions);
                }
            }
        }
        return webDriver;
    }

    public static void shutDown() {
        webDriver.quit();
        webDriver = null;
    }
}
