import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pageFactory.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrowseIssueTest {

    static LoginPage loginPage;
    static IssuePage issuePage;
    static DashboardPage dashboardPage;
    static final String VALID_USERNAME = System.getProperty("username");
    static final String VALID_PASSWORD = System.getProperty("password");


    @BeforeEach
    public void init(){
        dashboardPage = new DashboardPage();
        loginPage = new LoginPage();
        issuePage = new IssuePage();
        loginPage.navigateToDashboardLoginPage();
        loginPage.loggingIn(VALID_USERNAME, VALID_PASSWORD);

    }
    public void browseIssue(String Url, String expectedResult){
        dashboardPage.waitToPresentPfofilBtn();
        loginPage.navigate(Url);
        assertEquals(issuePage.getIssueKey(), expectedResult);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/issues.csv")
    public void browseIssueTest(String issue, String expectedResult){
        browseIssue(issue, expectedResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/issueswitherror.csv")
    public void browseIssueWithError(String issue, String errorMessage){
        dashboardPage.waitToPresentPfofilBtn();
        loginPage.navigate(issue);
        Assertions.assertEquals(issuePage.cantViewErrorDisplayed(),errorMessage);

    }

    @AfterEach
    public void tearDown(){
        loginPage.quit();
    }
}