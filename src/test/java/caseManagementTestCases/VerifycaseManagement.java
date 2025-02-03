package caseManagementTestCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseSetup;
import base.NavigateToApplication;
import pages.CaseManagement2;

import utils.ExtentListener;
import utils.RetryAnalyzer;

//@Listeners(ExtentListener.class)
public class VerifycaseManagement extends BaseSetup {
	
	
	public CaseManagement2 caseManagement2;
	NavigateToApplication navigateToApplication;

	@Test(priority = 1)
	public void navigateToNetSingularity() throws InterruptedException {
		caseManagement2 = new CaseManagement2(driver);
		navigateToApplication = new NavigateToApplication(driver);
		navigateToApplication.navigateToApplication("case");
	}
	
	
	@Test(priority = 2)
	public void validateOnDashboardTest() throws InterruptedException {
		caseManagement2 = new CaseManagement2(driver);
		ExtentListener.test.log(Status.INFO, "Verify Dashboard text");
		String dashboardText = caseManagement2.getActiveCasesTextOnDashboard();
	//	System.out.println("get active case text on dashboard");
		System.out.println("Text on dashboard = "+dashboardText);
		Assert.assertEquals(dashboardText, "Active cases", "Dashboard text doesn't match");
		
	}
	
	
	@Test(priority = 3)
	public void clickgis() throws InterruptedException {
		caseManagement2 = new CaseManagement2(driver);
		caseManagement2.clickGisIconDashboard();
		caseManagement2.enterTextInSearchBoxOnGisPage("Indore");
		caseManagement2.clickSearchOnGisPage();
Thread.sleep(5000);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
