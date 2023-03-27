package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;

public class ProfilePage extends BasePage {

    public ProfilePage() throws MalformedURLException {
        super();
    }

    @FindBy(id = "up-d-username")
    WebElement username;

    public String getUserName() {
        return username.getText();
    }
}
