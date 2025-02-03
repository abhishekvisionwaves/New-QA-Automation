package CustomerCare;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseSetup;
import pages.CustomerCare;
import utils.ExtentListener;
import utils.RetryAnalyzer;


public class VerifyCustomerCare extends BaseSetup {

	public CustomerCare cs;

	@Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
	public void navigateToApplicationTest() throws InterruptedException {
		cs = new CustomerCare(driver);
		ExtentListener.test.log(Status.INFO, "Selecting Module");
		cs.clickOnNetSingularity();
		cs.clickOnSearchButton();
		cs.insertModuleText("cust");
		cs.selectModule();
	}

	@Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
	public void validateOnDashboardTest() throws InterruptedException {
		cs = new CustomerCare(driver);
		ExtentListener.test.log(Status.INFO, "Verify Dashboard Component");
		cs.clickOnDashboardListItems();
		String dashboardText = cs.getDashboardNameText();
		Assert.assertEquals(dashboardText, "Analytics", "Dashboard text doesn't match");
	}

	@Test(priority = 3)
	public void verifySearchGeographyTest() throws InterruptedException {
		cs = new CustomerCare(driver);
		ExtentListener.test.log(Status.INFO, "Verifying Search Geography");
		cs.clickOnGISButton();
		String expectedGisText = "GIS"; // Replace with the expected text value of the GIS element
		String actualGisText = cs.getGisValueText();
		Assert.assertEquals(actualGisText, expectedGisText, "GIS value does not match the expected text.");
		cs.enterTextInSearchGeography("Test");
	}

	@Test(priority = 4)
	public void navigateToDashboardFromGis() throws InterruptedException {
		ExtentListener.test.log(Status.INFO, "Navigate To Dashboard From Gis");
		cs.navigateBackToDashboardPage();
		String dashboardText = cs.getDashboardNameText();
		Assert.assertEquals(dashboardText, "Analytics", "Dashboard text doesn't match");
	}

	@Test(priority = 5) // , retryAnalyzer = RetryAnalyzer.class)
	public void ValidateOnCustomer360Test() throws InterruptedException {
		cs = new CustomerCare(driver);
		ExtentListener.test.log(Status.INFO, "Verifying Customer 360 Text");
		cs.clickOnCustomer360();
		String customerText = cs.getCustomerValueText();
		Assert.assertEquals(customerText, "Search customer", "Customer value text doesn't match");
	}

	@Test(priority = 6)
	public void searchCustomer360() throws InterruptedException {
		ExtentListener.test.log(Status.INFO, "Search Customer 360");
		cs.enterValueInCustomer360SearchBox("Avalon Technologies (9000012345)");
//		cs.selectCustomerValue();
		cs.clickOnViewDetailsButton();
		cs.verifyCustomerInformationText();
	}

	@Test(priority = 7)
	public void createTasks() throws Exception {
		cs = new CustomerCare(driver);
		ExtentListener.test.log(Status.INFO, "Create New Task");
		cs.clickOnCustomer360();
		cs.enterValueInCustomer360SearchBox("Avalon Technologies (9000012345)");
		cs.clickOnViewDetailsButton();
		cs.createTask();
	}
}
