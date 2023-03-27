package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;
import java.util.List;

public class IssuePage extends BasePage{
    public IssuePage() throws MalformedURLException {
        super();
    }

    @FindBy (id = "key-val")
    WebElement issueKey;
    @FindBy(id = "opsbar-operations_more")
    WebElement moreBtn;
    @FindBy (id = "delete-issue")
    WebElement deleteBtn;
    @FindBy (id = "edit-issue")
    WebElement editIssueBtn;
    @FindBy (id = "summary")
    WebElement editIssueSummary;
    @FindBy (id = "summary-val")
    WebElement summary;
    @FindBy (id = "type-val")
    WebElement type;
    @FindBy (xpath = "//div[@class='aui-message closeable aui-message-success aui-will-close']")
    WebElement deleteIssuePopUp;
    @FindBy (xpath = "//*[@id='delete-issue-submit']")
    WebElement PopUpDeleteBtn;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div/ol")
    WebElement issueList;
    @FindBy (id = "edit-issue-submit")
    WebElement editBtn;
    @FindBy (xpath = "//button[normalize-space()='Cancel']")
    WebElement cancelBtn;

    @FindBy (xpath = "//div[@class='error']")
    WebElement errorField;
    @FindBy (css = "h1")
    WebElement error;
    @FindBy (id = "aui-flag-container")
    WebElement updateConfirm;


    public String getIssueKey(){
        wait.until(ExpectedConditions.elementToBeClickable(issueKey));
        return issueKey.getText();
    }
    public String getSummary(){
        wait.until(ExpectedConditions.elementToBeClickable(summary));
        return summary.getText();
    }
    public String getype(){
        wait.until(ExpectedConditions.elementToBeClickable(type));
        return type.getText();
    }
    public void clickMoreBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(moreBtn));
        moreBtn.click();
    }
    public void clickDeleteBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
        deleteBtn.click();
    }
    public void clickPopUpDeleteBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(PopUpDeleteBtn));
        PopUpDeleteBtn.click();
    }
    public Boolean isDeleteIssueValidate(){
        wait.until(ExpectedConditions.visibilityOf(deleteIssuePopUp));
        return deleteIssuePopUp.isDisplayed();
    }
    public void deleteIssue(){
    clickMoreBtn();
    clickDeleteBtn();
    clickPopUpDeleteBtn();
    }
    public int issueListSize(){
        wait.until(ExpectedConditions.elementToBeClickable(issueList));
        List<WebElement> liElements = issueList.findElements(By.tagName("li"));
        return liElements.size();
    }
    public void clickOnEditIssueBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(editIssueBtn));
        editIssueBtn.click();
    }
    public void editBtnVisible(){
        wait.until(ExpectedConditions.elementToBeClickable(editIssueBtn));
    }
    public void editSummary(String text){
        wait.until(ExpectedConditions.elementToBeClickable(editIssueSummary));
        editIssueSummary.clear();
        editIssueSummary.sendKeys(text);
    }
    public void clickOnUpdateBtn(){
        wait.until((ExpectedConditions.elementToBeClickable(editBtn)));
        editBtn.click();
    }
    public void waitForUpdate(){
        wait.until((ExpectedConditions.visibilityOf(updateConfirm)));
        wait.until((ExpectedConditions.invisibilityOf(updateConfirm)));
    }
    public void clickOnCancelButtonAndAcceptAlert(){
        wait.until(ExpectedConditions.elementToBeClickable(cancelBtn));
        cancelBtn.click();
        driver.switchTo().alert().accept();
    }
    public String errorDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(errorField));
        return errorField.getText();
    }
    public String cantViewErrorDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(error));
        return error.getText();
    }
}
