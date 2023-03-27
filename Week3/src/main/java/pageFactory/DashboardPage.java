package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;


public class DashboardPage extends BasePage {
    @FindBy (id = "header-details-user-fullname")
    WebElement profileBtn;
    @FindBy (id = "view_profile")
    WebElement profile;
    @FindBy (id = "log_out")
    WebElement logoutBtn;
    @FindBy(xpath = "//*[@id='create_link']")
    WebElement createBtn;
    @FindBy (xpath = "//input[@id='project-field']")
    WebElement projectField;
    @FindBy (xpath = "//input[@id='issuetype-field']")
    WebElement issueTypeField;
    @FindBy (xpath = "//input[@id='summary']")
    WebElement summaryField;
    @FindBy (xpath = "//input[@id='create-issue-submit']")
    WebElement createIssueBtn;
    @FindBy (xpath = "//*[text()='Cancel']")
    WebElement cancelIssueBtn;
    @FindBy(xpath = "//h2[normalize-space()='Create Issue']")
    WebElement createIssueString;
    @FindBy (css = ".issue-created-key.issue-link")
    WebElement createdIssueLink;
    @FindBy(xpath = "//*[@id='dialog-form']/div/div[2]/div[1]/div")
    WebElement issueSummaryErrorMsg;

    public DashboardPage() throws MalformedURLException {
        super();
    }

    public String getSummoryErrorMsg(){
        wait.until(ExpectedConditions.visibilityOf(issueSummaryErrorMsg));
        return issueSummaryErrorMsg.getText();
    }
    public void waitToPresentPfofilBtn(){
        wait.until(ExpectedConditions.visibilityOf(profileBtn));
    }
    public void clickProfileBtn(){
        wait.until(ExpectedConditions.visibilityOf(profileBtn));
        profileBtn.click();
    }
    public void clickProfile(){
        wait.until(ExpectedConditions.visibilityOf(profile));
        profile.click();
    }
    public void clickLogoutBtn(){
        wait.until(ExpectedConditions.visibilityOf(logoutBtn));
        logoutBtn.click();
    }
    public void navigateProfilePage(){
        clickProfileBtn();
        clickProfile();
    }
    public void logout(){
        clickProfileBtn();
        clickLogoutBtn();
    }
    public void clickCreatedIssueLink(){
        wait.until(ExpectedConditions.elementToBeClickable(createdIssueLink));
        createdIssueLink.click();
    }
    public void clickCreateBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(createBtn));
        createBtn.click();
    }
    public void clickCreateIssueBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(createIssueBtn));
        createIssueBtn.click();
    }
    public void clickCancelIssueBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(cancelIssueBtn));
        cancelIssueBtn.click();
    }
    public void clickCreateIssueString(){
        wait.until(ExpectedConditions.elementToBeClickable(createIssueString));
        createIssueString.click();
    }
    public void fillProjectField(String project){
        wait.until(ExpectedConditions.elementToBeClickable(projectField));
        projectField.click();
        projectField.sendKeys(project);
        createIssueString.click();
    }
    public void fillTypeField(String issueType){
        wait.until(ExpectedConditions.elementToBeClickable(issueTypeField));
        issueTypeField.click();
        issueTypeField.sendKeys(issueType);
        createIssueString.click();
    }
    public void fillSummaryField(String summaryData ){
        wait.until(ExpectedConditions.elementToBeClickable(summaryField));
        summaryField.sendKeys(summaryData);
    }

    public void navigate(String url){
        driver.get(url);
    }
}
