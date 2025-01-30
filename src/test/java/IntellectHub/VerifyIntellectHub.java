package IntellectHub;

import org.testng.annotations.Test;

import base.BaseSetup;
import base.NavigateToApplication;
import pages.IntellectHub;

public class VerifyIntellectHub extends BaseSetup {

	IntellectHub intellectHub;
	NavigateToApplication navigateToApplication;
	
	@Test(priority = 1)
	public void navigateToNetSingularity() throws InterruptedException {
		intellectHub = new IntellectHub(driver);
		navigateToApplication = new NavigateToApplication(driver);
		navigateToApplication.navigateToApplication("intellect");
	}
	
	@Test(priority = 2)
	public void navigateToArticle() {
		intellectHub = new IntellectHub(driver);
		intellectHub.movedFromHomePageToArticle();
	}
	
	@Test(priority = 3)
	public void verifyArticleSearchBox() throws InterruptedException {
		intellectHub = new IntellectHub(driver);
		intellectHub.enterValueInArticleSearch("monday");
	}
	
//	@Test(priority = 4)
//	public void verifyCreateCategory() throws InterruptedException {
//		intellectHub = new IntellectHub(driver);
//		intellectHub.createCategory("Auto", "Mation");
//	}
	
//	@Test(priority = 5)
//	public void verifyCreateArticle() throws InterruptedException {
//		intellectHub = new IntellectHub(driver);
//		intellectHub.createArticle("Automation Article", "Report");
//	}
	
	@Test(priority = 6)
	public void verifyArticleDeleteFunctionality() {
		intellectHub = new IntellectHub(driver);
		intellectHub.deleteArticle();
	}
	
	
	
	@Test(priority = 7)
	public void navigateToTemplate() {
		intellectHub = new IntellectHub(driver);
		intellectHub.clickOnTemplatePage();
	}
	
	@Test(priority = 8)
	public void verifyTemplateSearch() {
		intellectHub = new IntellectHub(driver);
		intellectHub.insertValueInSearchBox("demo");
		
	}
	
	@Test(priority = 9)
	public void verifyRefreshButton() {
		intellectHub = new IntellectHub(driver);
		intellectHub.validateRefreshButton();
	}
	
	@Test(priority = 10)
	public void verifyCategoryRenameFunctionality() {
		intellectHub = new IntellectHub(driver);
		intellectHub.verifyCategoryRename(" update value");
	}
	
	@Test(priority = 11)
	public void verifyCategoryUpdateFunctionality() {
		intellectHub = new IntellectHub(driver);
		intellectHub.updateCategory(" New", " New");
	}
	
	@Test(priority = 12)
	public void verifyCreateTemplate() {
		intellectHub = new IntellectHub(driver);
		intellectHub.createTemplate("Automation", "abc");
		
	}
}
