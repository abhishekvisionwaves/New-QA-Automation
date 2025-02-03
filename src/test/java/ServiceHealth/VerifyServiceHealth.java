package ServiceHealth;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseSetup;
import base.NavigateToApplication;
import pages.ServiceHealth;
import pages.TrialManagement;
import utils.ExtentListener;
import utils.RetryAnalyzer;

@Listeners(ExtentListener.class)
public class VerifyServiceHealth extends BaseSetup {

	public ServiceHealth serviceHealth;

	NavigateToApplication navigateToApplication;

	@Test(priority = 1)
	public void navigateToNetSingularity() throws InterruptedException {

		serviceHealth = new ServiceHealth(driver);
		navigateToApplication = new NavigateToApplication(driver);
		navigateToApplication.navigateToApplication("service heal");
	}

	@Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
	public void validateOnDashboardTest() throws InterruptedException {
		serviceHealth = new ServiceHealth(driver);
		ExtentListener.test.log(Status.INFO, "Verify Dashboard Component");
		serviceHealth.getDashboardComonent();
		serviceHealth.printDashboardComponents();
	}

	@Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
	public void validateOnRuleConfigurationTest() throws InterruptedException {
		serviceHealth = new ServiceHealth(driver);
		ExtentListener.test.log(Status.INFO, "Validate Rule Configuration");
		serviceHealth.clickOnRuleConfiguration();
		serviceHealth.verifyRuleConfigurationText();
		serviceHealth.refreshPage();
	}

	@Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
	public void verifyRuleConfigurationFilterTest() throws InterruptedException {
		serviceHealth = new ServiceHealth(driver);
		ExtentListener.test.log(Status.INFO, "Verify Rule Configuration Filter");
		serviceHealth.verifyRuleConfigurationFilter();
		serviceHealth.clickOnSelectFilter();
	}

	@Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
	public void verifyCustomerServiceMonitoringTest() throws InterruptedException {
		serviceHealth = new ServiceHealth(driver);
		ExtentListener.test.log(Status.INFO, "Verify Customer ServiceMonitoring");
		serviceHealth.verifyCustomerServiceMonitoring();
	}

}
