package Abhinandan_Project.UI.Listeners;

import Abhinandan_Project.UI.Test.TestBase;
import Abhinandan_Project.Utility.BrowserUtility;
import Abhinandan_Project.Utility.ExtentReporterUtility;
import Abhinandan_Project.Utility.LoggerUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListeners implements ITestListener {
    Logger logger = LoggerUtility.getogger(this.getClass());

    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));

        ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " " + "PASSED");
        ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " " + "FAILED");
        logger.error(result.getThrowable().getMessage());

        ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
        ExtentReporterUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());

        Object testclass = result.getInstance();
        BrowserUtility browserUtility = ((TestBase) testclass).getInstance();
        try {
            logger.info("Capturing Screenshot for the failed test");
            String screenshotPath = browserUtility.takeScreenshot(result.getMethod().getMethodName());
            ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);
            logger.info("Attaching the Screenshot to the HTML file");
        } catch (Exception e) {
            logger.warn("Screenshot could not be captured for '" + result.getMethod().getMethodName()
                    + "' — browser may have crashed or timed out: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");

        ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("TestSuite Started");
        ExtentReporterUtility.setupSparkReporter("report.html");

    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("TestSuite Completed");
        ExtentReporterUtility.flushReport();
    }
}
