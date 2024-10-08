package listeners;

import org.automationCore.Base;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import extendReport.ExtendManager;

public class ExtendListeners extends Base implements ITestListener{
	private static final ExtentReports extent= ExtendManager.createInstance();
	private static final ThreadLocal<ExtentTest> test= new ThreadLocal();
 public ThreadLocal<ExtentTest> getTestInstances()
 {
	 return test;
 }
 public synchronized void onStart(ITestContext context) {
	    System.out.println("Extent Reports Version 3 Test Suite started!");
	}
 public synchronized void onFinish(ITestContext context) {
	    System.out.println(("Extent Reports Version 3  Test Suite is ending!"));
	    extent.flush();//this method is used to get logs results to the report
	}
 public synchronized void onTestStart(ITestResult result) {
	    System.out.println((result.getMethod().getMethodName() + " started!"));
	    ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
	    test.set(extentTest);
	}
 public synchronized void onTestSuccess(ITestResult result) {
	    System.out.println((result.getMethod().getMethodName() + " passed!"));
	    test.get().pass("Test Passed");//if the test result is success
	}
 public synchronized void onTestFailure(ITestResult result) {
	    System.out.println((result.getMethod().getMethodName() + " failed!"));
	    test.get().fail(result.getThrowable());//if the test result is failed
	}
	public synchronized void onTestSkipped(ITestResult result) {
	    System.out.println((result.getMethod().getMethodName() + " skipped!"));
	    test.get().skip(result.getThrowable());//if the test result skipped
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
	}
 
 
}
