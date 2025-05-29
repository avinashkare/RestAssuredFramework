package ie.api.listeners;

import java.io.FileInputStream;
import java.io.InputStream;

import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Allure;

public class AllureLogListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        attachLog();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        attachLog();
    }

    public void attachLog() {
        String logPath = "logs/test.log";
        try (InputStream is = new FileInputStream(logPath)) {
            Allure.addAttachment("Execution Log", is);
        } catch (Exception e) {
            Allure.addAttachment("Execution Log", "Log file not found: " + e.getMessage());
        }
    }
}
