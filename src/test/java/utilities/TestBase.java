package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.ITestResult;
import org.testng.annotations.*;


public class TestBase {
    protected static ExtentSparkReporter spark;
    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;


    @BeforeTest(alwaysRun = true)
    public void setup() {
        extentReports = new ExtentReports();
        String filePath = System.getProperty("user.dir") + "/test-output/Report.html";
        spark = new ExtentSparkReporter(filePath);
        extentReports.attachReporter(spark);
        extentReports.setSystemInfo("Enviroment","QA");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
        spark.config().setDocumentTitle("Insider Test");
        spark.config().setReportName("TestNG Reports");
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            String screenshotLocation = CommonMethods.takeScreenshot(Driver.getDriver(), result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);
            extentTest.fail(result.getThrowable());
        } else if (ITestResult.SKIP ==  result.getStatus()) {
            extentTest.skip("Test Case is skipped: " + result.getName());
        }

    }

    @AfterTest(alwaysRun = true)
    public void tearDownTest() {
        extentReports.flush();
    }

    @AfterSuite
    public void endTest(){
        Driver.closeDriver();
    }

}
