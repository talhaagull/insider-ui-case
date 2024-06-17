package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.CommonMethods;
import utilities.Driver;
import java.util.List;

public class QAJobsPage {

    public QAJobsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "See all QA jobs")
    public WebElement seeAllQAJobsButton;

    @FindBy(id = "filter-by-location")
    public WebElement filterByLocationMenu;

    @FindBy(id = "filter-by-department")
    public WebElement filterByDepartmentMenu;

    @FindBy(css = "#jobs-list .position-list-item")
    public List<WebElement> jobItems;

    public WebElement firstViewRoleButton() {
        return jobItems.get(0).findElement(By.cssSelector("a.btn.btn-navy"));
    }

    @FindBy(css = "[data-team='qualityassurance']")
    public WebElement jobListingCheck;

    @FindBy(css = "#jobs-list .position-list-item .position-title")
    public List<WebElement> jobsTitle;

    @FindBy(css = "#jobs-list .position-list-item .position-department")
    public List<WebElement> jobsDepartment;

    @FindBy(css = "#jobs-list .position-list-item .position-location")
    public List<WebElement> jobsLocation;

    @FindBy(xpath = "//a[text()='Apply for this job']")
    public WebElement applyForThisJobButton;


    public void goToQAJobsPage(){
        CommonMethods.goToUrl("QAJobsPage");
    }

    public void clickSeeAllQAJobsButton(){
        CommonMethods.clickElement(seeAllQAJobsButton);
    }

    public void filterByLocation(String location){
        CommonMethods.selectFromMenu(filterByLocationMenu, location);
    }

    public void filterByDepartment(String department){
        CommonMethods.selectFromMenu(filterByDepartmentMenu, department);
    }

    public void verifyJobsPresence(){
        Assert.assertFalse(jobItems.isEmpty(), "No job items found in the jobs list");
    }

    public void validateJobsPositionDepartmentAndLocation(String positionValue, String departmentValue, String locationValue) {
        CommonMethods.waitForVisibility(jobListingCheck, 15);
        for (int i = 0; i < jobsTitle.size(); i++) {
            String position = jobsTitle.get(i).getText();
            String department = jobsDepartment.get(i).getText();
            String location = jobsLocation.get(i).getText();

            Assert.assertTrue(position.contains(positionValue),
                    "Job position does not contain the expected value: " + positionValue + ". Actual value: " + position);
            Assert.assertTrue(department.contains(departmentValue),
                    "Job department does not contain the expected value: " + departmentValue + ". Actual value: " + department);
            Assert.assertTrue(location.contains(locationValue),
                    "Job location does not contain the expected value: " + locationValue + ". Actual value: " + location);
        }
    }

    public void clickFirstViewRoleButtonAndSwitchToNewWindow(){
        CommonMethods.JavascriptClick(firstViewRoleButton());
        CommonMethods.switchToNewWindow();
    }

    public void applyForThisJobButtonIsDisplayed(){
        CommonMethods.elementIsDisplayed(applyForThisJobButton);
    }

}
