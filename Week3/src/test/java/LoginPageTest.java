
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageFactory.*;

import java.net.MalformedURLException;

public class LoginPageTest {
    static DashboardPage dashBoard;
    static ProfilePage profilePage;
    static LoginPage loginPage;
    static final String EXPECTED_ERROR_MSG = "Sorry, your username and password are incorrect - please try again.";
    static String EXPECTED_LOGOUT_MSG = "You are now logged out. Any automatic login has also been stopped.";

    @BeforeEach
    public void init() throws MalformedURLException {
        profilePage = new ProfilePage();
        dashBoard = new DashboardPage();
        loginPage = new LoginPage();
        loginPage.navigateToDashboardLoginPage();
    }

    @Test
    public void validLogin() {
        loginPage.loggingIn(Util.VALID_USERNAME, Util.VALID_PASSWORD);
        dashBoard.navigateProfilePage();
        String username = profilePage.getUserName();
        Assertions.assertEquals(username, Util.VALID_USERNAME);
        dashBoard.logout();
    }

    @Test
    public void emptyFieldLogin() {
        loginPage.clickOnLoginBtn();
        String errorMsg = loginPage.getErrorMsg();
        Assertions.assertEquals(errorMsg, EXPECTED_ERROR_MSG);
    }

    @Test
    public void logoutAfterASuccessfulLogin() {
        loginPage.loggingIn(Util.VALID_USERNAME, Util.VALID_PASSWORD);
        dashBoard.logout();
        Assertions.assertEquals(loginPage.getLogoutMsg(), EXPECTED_LOGOUT_MSG);


    }

    @AfterEach
    public void tearDown() {
        loginPage.quit();
    }
}

