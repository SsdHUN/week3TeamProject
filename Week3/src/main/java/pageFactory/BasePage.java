package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.time.Duration;

public class BasePage {
    WebDriverWait wait;
    WebDriver driver;
    String browserType = System.getProperty("browserType");
    Boolean isRemote = Boolean.valueOf(System.getProperty("isRemote"));

    public BasePage() throws MalformedURLException {
        if (browserType == null){
            browserType = "Chrome";
        }
        this.driver = WebDriverFactory.createWebDriver(browserType, isRemote);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public void quit(){
        WebDriverFactory.shutDown();
    }
}