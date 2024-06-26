package Login;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtentReport.ExtentReport;

public class Listeners implements ITestListener {

	WebDriver driver;
	ExtentTest t;
	ExtentReports extent = ExtentReport.Object();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		t  = extent.createTest(result.getMethod().getMethodName());
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Successfully passes");
		t.log(Status.PASS, "Testpass");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
			
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

}
