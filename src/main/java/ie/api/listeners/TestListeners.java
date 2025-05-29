package ie.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

	private static final Logger logger = LogManager.getLogger(TestListeners.class);

	public void onStart(ITestContext context) {
		logger.info("Test Suite Started");
	}

	public void onTestStart(ITestResult result) {
		logger.info("Method : " + result.getMethod().getMethodName() + " execution started");
		logger.info("Description : " + result.getMethod().getDescription());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info("Method : " + result.getMethod().getMethodName() + " executed successfully");
	}

	public void onTestFailure(ITestResult result) {
		logger.error("Test case failed : " + result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		logger.info("Test case skipped : " + result.getMethod().getMethodName());
	}

	public void onFinish(ITestContext context) {
		logger.info("Test Suite Finished");
	}

}
