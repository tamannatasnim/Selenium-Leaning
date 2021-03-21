package listeners;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class Current_Listener_ITestListener implements ITestListener{
	//onStart(): An onStart() method is executed on the start of any test method
	public void onStart(ITestContext arg) {
		System.out.println("Starts Test Execution...."+arg.getName());
	}
	//onFinish(): An onFinish() is invoked when any test case finishes its execution
	public void onFinish(ITestContext arg) {
		System.out.println(" Finish Test Execution...."+arg.getName());
	}

	// onTestStart(): An onTestStart() is invoked only when any test method gets started
	public void onTestStart(ITestResult arg0) {
		System.out.println("Starts Test...."+arg0.getName());
	}
	//onTestSkipped(): An onTestSkipped() run only when any test method has been skipped
	public void onTestSkipped(ITestResult arg0) {
		System.out.println(" Skipped Test...."+arg0.getName());
	}
	//onTestSuccess(): An onTestSuccess() method is executed on the success of a test method
	public void onTestSuccess(ITestResult arg0) {
		System.out.println(" Passed Test...."+arg0.getName());
	}
	//onTestFailure(): An onTestFailure() method is invoked when test method fails
	public void onTestFailure(ITestResult arg0) {
		System.out.println(" Failed Test...."+arg0.getName());
	}
	//onTestFailedButWithinSuccessPercentage(): 
	//This method is invoked each time when the test method fails but within success percentage
	public void onTestFailedButWithinSuccessPercentage(ITestContext arg0) {

	}
}