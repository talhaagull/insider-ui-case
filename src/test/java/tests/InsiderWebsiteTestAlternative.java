package tests;

import org.testng.annotations.Test;
import pages.CareersPage;
import pages.HomePage;
import pages.QAJobsPage;
import utilities.TestBase;

public class InsiderWebsiteTestAlternative extends TestBase {

    @Test
    public void testHomePageIsOpened() {
        extentTest = extentReports.createTest("insider test","open insider page, search job");
        HomePage homePage = new HomePage();
        homePage.goHomePage();
        homePage.homePageIsOpened();
        extentTest.info("homepage is opened");
    }


    @Test(dependsOnMethods = "testHomePageIsOpened")
    public void testNavigateToCareersPageAndCheckCareerPageBlocks() {
        HomePage homePage = new HomePage();
        CareersPage careersPage = new CareersPage();

        homePage.clickCompanyMenu();
        extentTest.info("selected the “Company” menu in the navigation bar");
        homePage.clickCareersOption();
        extentTest.info("selected the “Careers”");
        careersPage.areCareerPageBlocksOpen();
        extentTest.info("Career page, Locations, Teams and Life at Insider blocks are checked to be open or closed");
    }


    @Test(dependsOnMethods = "testNavigateToCareersPageAndCheckCareerPageBlocks")
    public void testFilterQAJobs() {
        QAJobsPage qaJobsPage = new QAJobsPage();

        qaJobsPage.goToQAJobsPage();
        qaJobsPage.clickSeeAllQAJobsButton();
        qaJobsPage.filterByLocation("Istanbul, Turkey");
        qaJobsPage.filterByDepartment("Quality Assurance");
        qaJobsPage.verifyJobsPresence();
        extentTest.info("jobs presence verified");
    }

    @Test(dependsOnMethods = "testFilterQAJobs")
    public void testCheckAllJobsPositionDepartmentAndLocation(){
        QAJobsPage qaJobsPage = new QAJobsPage();
        qaJobsPage.validateJobsPositionDepartmentAndLocation("Quality Assurance", "Quality Assurance", "Istanbul, Turkey");
    }

    @Test(dependsOnMethods = "testFilterQAJobs")
    public void testValidateRedirectLeverApplicationPage() {
        QAJobsPage qaJobsPage = new QAJobsPage();

        qaJobsPage.clickFirstViewRoleButtonAndSwitchToNewWindow();
        qaJobsPage.applyForThisJobButtonIsDisplayed();
        extentTest.pass("test passed, lever page successfully opened");
    }


}
