package tests;

import org.testng.annotations.Test;
import pages.CareersPage;
import pages.HomePage;
import pages.QAJobsPage;
import utilities.TestBase;

public class InsiderWebsiteTest extends TestBase {
    HomePage homePage = new HomePage();
    QAJobsPage qaJobsPage = new QAJobsPage();
    CareersPage careersPage = new CareersPage();

    @Test
    public void testInsiderSite() {
        extentTest = extentReports.createTest("insider test","open insider page, search job");
        homePage.goHomePage();
        homePage.homePageIsOpened();
        extentTest.info("homepage is opened");
        homePage.clickCompanyMenu();
        homePage.clickCareersOption();
        careersPage.areCareerPageBlocksOpen();

        qaJobsPage.goToQAJobsPage();
        qaJobsPage.clickSeeAllQAJobsButton();
        extentTest.info("see all jobs button clicked");

        qaJobsPage.filterByLocation("Istanbul, Turkey");
        qaJobsPage.filterByDepartment("Quality Assurance");
        qaJobsPage.verifyJobsPresence();
        extentTest.info("jobs presence verified");

        qaJobsPage.validateJobsPositionDepartmentAndLocation("Quality Assurance", "Quality Assurance", "Istanbul, Turkey");

        qaJobsPage.clickFirstViewRoleButtonAndSwitchToNewWindow();
        qaJobsPage.applyForThisJobButtonIsDisplayed();
        extentTest.pass("test passed, lever page successfully opened");
    }


}
