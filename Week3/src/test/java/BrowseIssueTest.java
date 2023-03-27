import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pageFactory.*;


import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrowseIssueTest {

    static LoginPage loginPage;
    static IssuePage issuePage;
    static DashboardPage dashboardPage;


    @BeforeEach
    public void init() throws MalformedURLException {
        dashboardPage = new DashboardPage();
        loginPage = new LoginPage();
        issuePage = new IssuePage();
        loginPage.navigateToDashboardLoginPage();
        loginPage.loggingIn(Util.VALID_USERNAME, Util.VALID_PASSWORD);

    }

    public void browseIssue(String Url, String expectedResult) {
        dashboardPage.waitToPresentProfileBtn();
        loginPage.navigate(Url);
        assertEquals(issuePage.getIssueKey(), expectedResult);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/issues.csv")
    public void browseIssueTest(String issue, String expectedResult) {
        browseIssue(issue, expectedResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/issuesWithError.csv")
    public void browseIssueWithError(String issue, String errorMessage) {
        dashboardPage.waitToPresentProfileBtn();
        loginPage.navigate(issue);
        Assertions.assertEquals(issuePage.cantViewErrorDisplayed(), errorMessage);

    }

    @AfterEach
    public void tearDown() {
        loginPage.quit();
    }
}