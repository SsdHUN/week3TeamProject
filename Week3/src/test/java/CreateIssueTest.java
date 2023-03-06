import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.CsvFileSource;
import pageFactory.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateIssueTest {
    static LoginPage loginPage;
    static DashboardPage dashBoard;
    static IssuePage issuePage;
    static final String VALID_USERNAME = System.getProperty("username");
    static final String VALID_PASSWORD = System.getProperty("password");
    static final String CREATE_TEST_STING = "New Issue1";
    static final String SUMMARY_ERROR_MSG = "You must specify a summary of the issue.";
    static final int EXPECTED_LIST_SIZE = 1;

    @BeforeEach
    public void init() throws Exception {
        loginPage = new LoginPage();
        issuePage = new IssuePage();
        dashBoard = new DashboardPage();
        loginPage.navigateToDashboardLoginPage();
        loginPage.loggingIn(VALID_USERNAME, VALID_PASSWORD);
    }

    public void cancelCreation(String project, String type, String summary){
        dashBoard.clickCreateBtn();
        dashBoard.fillProjectField(project);
        dashBoard.fillTypeField(type);
        dashBoard.fillSummaryField(summary);
        dashBoard.clickCancelIssueBtn();
    }
    @Test
    public void emytyFilds(){
        dashBoard.clickCreateBtn();
        dashBoard.clickCreateIssueBtn();
        assertEquals(dashBoard.getSummoryErrorMsg(),SUMMARY_ERROR_MSG);

        dashBoard.navigate("https://jira-auto.codecool.metastage.net/browse/MTP-3381?jql=project%20%3D%2" +
                "0MTP%20AND%20resolution%20%3D%20Unresolved%20AND%20text%20~%20%22New%20Issue%202%22%20ORDER%20BY%20prio" +
                "rity%20DESC%2C%20updated%20DESC/n%22)");
        Assertions.assertEquals(issuePage.issueListSize(),EXPECTED_LIST_SIZE);
    }


    public void successfulCreateIssue(String project, String type, String summary){
        dashBoard.clickCreateBtn();
        dashBoard.fillProjectField(project);
        dashBoard.fillTypeField(type);
        dashBoard.fillSummaryField(summary);
        dashBoard.clickCreateIssueBtn();
        dashBoard.clickCreatedIssueLink();
        //String EXPEXTED_KEY = issuePage.getIssueKey();
        String EXPEXTED_TYPE = issuePage.getype();
        String EXPEXTED_SUMMARY = issuePage.getSummary();
        Assertions.assertEquals(EXPEXTED_TYPE,type);
        Assertions.assertEquals(EXPEXTED_SUMMARY,summary);
        issuePage.deleteIssue();
        Assertions.assertTrue(issuePage.isDeleteIssueValidate());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/createissue.csv")
    public void createIssue(String project, String type){
        successfulCreateIssue(project,type,CREATE_TEST_STING);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/cancelIssue.csv")
    public void cancelCreationParameterizedTest(String project, String type,String summary){
        cancelCreation(project,type,summary);
    }

    @AfterEach
    public void tearDown(){
        loginPage.quit();
    }
}
