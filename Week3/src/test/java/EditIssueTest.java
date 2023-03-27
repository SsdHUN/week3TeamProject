import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pageFactory.*;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditIssueTest {
    static LoginPage loginPage;
    static IssuePage issuePage;
    static DashboardPage dashboardPage;
    static final String SUMMARY_DATA = "TestIssue1";
    static final String EDIT_DATA = "TestIssue2";
    static final String EMPTY_ERROR = "You must specify a summary of the issue.";

    @BeforeEach
    public void init() throws MalformedURLException {

        dashboardPage = new DashboardPage();
        loginPage = new LoginPage();
        issuePage = new IssuePage();
        loginPage.navigateToDashboardLoginPage();
        loginPage.loggingIn(Util.VALID_USERNAME, Util.VALID_PASSWORD);
    }

    public void editIssueProjects(String Url, String expectedResult) {
        dashboardPage.waitToPresentProfileBtn();
        loginPage.navigate(Url);
        assertEquals(issuePage.getIssueKey(), expectedResult);

    }

    public void editIssue(String Url, String expectedResult, String newValue) {
        dashboardPage.waitToPresentProfileBtn();
        loginPage.navigate(Url);
        assertEquals(issuePage.getIssueKey(), expectedResult);
        issuePage.clickOnEditIssueBtn();
        issuePage.editSummary(newValue);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/issues.csv")
    public void editIssueProjectsTest(String Url, String expectedResult) {
        editIssueProjects(Url, expectedResult);
        issuePage.editBtnVisible();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/editIssue.csv")
    public void successfullyEditIssue(String Url, String expectedResult) {
        editIssue(Url, expectedResult, EDIT_DATA);
        issuePage.clickOnUpdateBtn();
        issuePage.waitForUpdate();
        assertEquals(issuePage.getIssueKey(), expectedResult);
        assertEquals(issuePage.getSummary(), EDIT_DATA);
        issuePage.clickOnEditIssueBtn();
        issuePage.editSummary(SUMMARY_DATA);
        issuePage.clickOnUpdateBtn();
        issuePage.waitForUpdate();
        assertEquals(issuePage.getIssueKey(), expectedResult);
        assertEquals(issuePage.getSummary(), SUMMARY_DATA);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/editIssue.csv")
    public void cancelEditIssue(String Url, String expectedResult) {
        editIssue(Url, expectedResult, EDIT_DATA);
        issuePage.clickOnCancelButtonAndAcceptAlert();
        assertEquals(issuePage.getIssueKey(), expectedResult);
        assertEquals(issuePage.getSummary(), SUMMARY_DATA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/editIssue.csv")
    public void emptyRequiredField(String Url, String expectedResult) {
        editIssue(Url, expectedResult, "");
        issuePage.clickOnUpdateBtn();
        assertEquals(issuePage.errorDisplayed(), EMPTY_ERROR);
        issuePage.clickOnCancelButtonAndAcceptAlert();
    }


    @AfterEach
    public void tearDown() {
        loginPage.quit();
    }
}