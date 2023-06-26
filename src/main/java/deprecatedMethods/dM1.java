package deprecatedMethods;

import org.testng.ITestListener;
import org.testng.ITestResult;


// original name of this deprecated method : ListenersDemoS
public class dM1 implements ITestListener {

    public void onTestSuccess(ITestResult result){
        System.out.println("test passed: " + result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result){
        System.out.println("Test failed: " + result.getMethod().getMethodName());
        System.out.println("Exception thrown by this method " + result.getThrowable().getMessage());
    }



}
