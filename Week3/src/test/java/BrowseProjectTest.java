import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pageFactory.DashboardPage;
import pageFactory.LoginPage;
import pageFactory.ProjectPage;
import pageFactory.Util;

import java.net.MalformedURLException;

public class BrowseProjectTest {

    static LoginPage loginPage;
    static DashboardPage dashBoard;
    static ProjectPage projectPage;

    @BeforeEach
    public void init() throws MalformedURLException {
        loginPage = new LoginPage();
        projectPage = new ProjectPage();
        dashBoard = new DashboardPage();
        loginPage.navigateToDashboardLoginPage();
        loginPage.loggingIn(Util.VALID_USERNAME, Util.VALID_PASSWORD);
    }

    public void browseProject(String url, String expected) {
        dashBoard.waitToPresentProfileBtn();
        dashBoard.navigate(url);
        Assertions.assertEquals(expected, projectPage.getKey());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/browseProject.csv")
    public void browseProjectParameterized(String url, String key) {
        browseProject(url, key);
    }

    @Test
    public void browseProjectWithoutPermission() {
        dashBoard.waitToPresentProfileBtn();
        dashBoard.navigate("https://jira-auto.codecool.metastage.net/projects/MTP3/summary");
        Assertions.assertEquals("You can't view this project", projectPage.getErrorMessage());
    }

    @Test
    public void browseNonExistentProject() {
        dashBoard.waitToPresentProfileBtn();
        dashBoard.navigate("https://jira-auto.codecool.metastage.net/projects/MTP2/summary");
        Assertions.assertEquals("You can't view this project", projectPage.getErrorMessage());
    }

    @AfterEach
    public void tearDown() {
        loginPage.quit();
    }


}
