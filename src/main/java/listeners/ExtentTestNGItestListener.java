package listeners;

import browserFactory.BrowserFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import helper.Utility;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestNGItestListener implements ITestListener {


    ExtentReports extent = ExtentManager.getInstance();
    ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        parentTest.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // add your test pass logs
        WebDriver driver = BrowserFactory.getBrowserInstance();
        String base64 = Utility.captureScreenshotInBase64(driver);
        parentTest.get().pass("test passed",MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        // add your test fail logs

        WebDriver driver = BrowserFactory.getBrowserInstance();
        String base64 = Utility.captureScreenshotInBase64(driver);
        parentTest.get().fail("test failed" + result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // add your test skip logs
        parentTest.get().skip("test skipped" + result.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext context) {
        // test finish - now flush your test
        extent.flush();
    }
}
