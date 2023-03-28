package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;


public class LoginPage extends BasePage {
    public LoginPage() throws MalformedURLException {
        super();
    }

    @FindBy(xpath = "//*[@id='login-form-username']")
    WebElement username;
    @FindBy(xpath = "//*[@id='login-form-password']")
    WebElement password;
    @FindBy(id = "login")
    WebElement loginBtn;
    @FindBy(xpath = "//*[@id='usernameerror']")
    WebElement errorMsg;
    @FindBy(xpath = "//*[@id='main']/div/div/p[1]/strong")
    WebElement logoutMsg;


    public void setUsername(String name) {
        username.sendKeys(name);
    }

    public void setPassword(String pwd) {

        password.sendKeys(pwd);
    }

    public void clickOnLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
    }

    public String getErrorMsg() {
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        return errorMsg.getText();
    }

    public String getLogoutMsg() {
        wait.until(ExpectedConditions.visibilityOf(logoutMsg));
        return logoutMsg.getText();
    }

    public void loggingIn(String user, String pwd) {
        setUsername(user);
        setPassword(pwd);
        clickOnLoginBtn();
    }

    public void quit() {
        WebDriverFactory.shutDown();
    }

    public void navigateToDashboardLoginPage() {
        driver.get("https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa");
    }

    public void navigate(String url) {
        driver.get(url);
    }

}
