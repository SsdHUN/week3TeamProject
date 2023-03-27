package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;

public class ProjectPage extends BasePage {
    public ProjectPage() throws MalformedURLException {
        super();
    }

    @FindBy(xpath = "//*[@id='summary-body']/div/div[2]/dl/dd[2]")
    WebElement key;
    @FindBy(xpath = "/html/body/div/div/div/div/main/h1")
    WebElement errorMsg;

    public String getKey() {
        wait.until(ExpectedConditions.visibilityOf(key));
        return key.getText();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(errorMsg));
        return errorMsg.getText();
    }
}
