package commonUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{
	
//	ExtentTest test;
//	ExtentReports report;
//	
//	@Override
//	public void onTestStart(ITestResult result) {
//		// TODO Auto-generated method stub
//		System.out.println("TestScript execution is started");
//		String methodName = result.getMethod().getMethodName();
//		Reporter.log(methodName+"TestScript execution started",true);
//		test = report.createTest(methodName); 
//	}
//
//	@Override
//	public void onTestSuccess(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//		//Reporter.log("TestScript execution is pass",true);
//		
//		//Capture the method name
//		String methodname = result.getMethod().getMethodName();
//		//System.out.println(methodname+"TestScript is passed");
//		Reporter.log(methodname+"TestScript execution is pass",true);
//		test.log(Status.PASS, "TestScript execution is pass");
//	}
//
//	@Override
//	public void onTestFailure(ITestResult result) {
//		// TODO Auto-generated method stub
//		//System.out.println("Test Failed");
//		Reporter.log("TestScript execution is Fail",true);
//	}
//
//	@Override
//	public void onTestSkipped(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//		String methodname = result.getMethod().getMethodName();
//		Reporter.log(methodname+"TestScript execution is Skipped",true);
//		
//	}
//
//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onTestFailedWithTimeout(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onStart(ITestContext context) {
//		// TODO Auto-generated method stub
//				
//		//To configure extent reports
//    	ExtentSparkReporter esr = new ExtentSparkReporter("./Extentreport/report.html");
//    	esr.config().setReportName("Vtigercrm");
//    	esr.config().setTheme(Theme.DARK);
//    	esr.config().setDocumentTitle("Vtiger");
//    	
//    	//To generate extent reports
//    	
//    	report = new ExtentReports();
//    	report.attachReporter(esr);
//    	report.setSystemInfo("Browser","Chrome");
//    	report.setSystemInfo("Chrome", "122");
//    	report.setSystemInfo("OS", "Windows");
//    	report.setSystemInfo("Author", "Shivam");
//		
//		//System.out.println("Test OnStart");
//	}
//
//	@Override
//	public void onFinish(ITestContext context) {
//		// TODO Auto-generated method stub
//		
//		report.flush();
//		//System.out.println("Test onFInish");
//	}
	
	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("testscript execution is started");
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"Testscript execution is Started",true);
		test=report.createTest(methodname);
	
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	
		//Capture the method name
		String methodname = result.getMethod().getMethodName();
	//	System.out.println(methodname+"testscript is passed");	
	Reporter.log(methodname+"Testscript execution is Pass",true);
	test.log(Status.PASS, "Testscript execution is Pass");
	
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("testScript is failed");
		//Capture the method name
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"Testscript execution is Fail",true);
		test.log(Status.FAIL, "Testscript execution is Fail");
	
		//To take screenshot if testScript is failed
		WebDriverUtil wutil = new WebDriverUtil();
		try {
			String path = wutil.screenShot(BaseClass.sdriver);
			test.addScreenCaptureFromPath(path);//this will give ss in extent report (attached ss to extent report)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("testScript is skipped");
		//Capture the method name
	String methodname = result.getMethod().getMethodName();
	Reporter.log(methodname+"Testscript execution is Skip",true);
	test.log(Status.SKIP, "Testscript execution is Skip");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
	JavaUtil jutil = new JavaUtil();
	//To configure extent reports
	ExtentSparkReporter	esr = new ExtentSparkReporter("./Extentreport/"+jutil.getRandomNumber()+"report.html");
	esr.config().setReportName("Vtigercrm");	
	esr.config().setTheme(Theme.STANDARD);
	esr.config().setDocumentTitle("Vtiger");
		
	//To generate extent reports
	report = new ExtentReports();
	report.attachReporter(esr);
	report.setSystemInfo("Browser", "Chrome");
	report.setSystemInfo("Chrome", "122");
	report.setSystemInfo("OS", "Windows");
	report.setSystemInfo("Author", "Shivam");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
	}


}
