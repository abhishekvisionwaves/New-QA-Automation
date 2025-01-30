package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.NavigateToApplication;
import common.SeleniumAction;
import utils.ExcelReader;

public class ServiceHealth extends SeleniumAction {

	protected WebDriver driver;
	WebDriverWait wait;
	NavigateToApplication navigateToApplication;

	// Constructor to initialize elements using the provided WebDriver
	public ServiceHealth(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 10-second wait
		PageFactory.initElements(driver, this);
		System.out.println("NavigateToApplication initialized");
	}

	@FindBy(xpath = "//span[contains(text(), 'Network availability')]")
	WebElement getDashboardValue;

	@FindBy(xpath = "//div[@class='headercell-label ng-star-inserted']")
	List<WebElement> getDashboardComponentList;

	public void getDashboardComonent() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Explicit wait
		wait.until(ExpectedConditions.visibilityOf(getDashboardValue)); // Wait until the element is visible
		String expectedValue = "Network availability";
		String actualValue = getDashboardValue.getText(); // Get the text of the element
		System.out.println("Dashboard Value: " + actualValue);
		org.testng.Assert.assertEquals(actualValue, expectedValue,
				"Dashboard value does not match the expected value!");
	}

	public void printDashboardComponents() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Explicit wait
		wait.until(ExpectedConditions.visibilityOfAllElements(getDashboardComponentList)); // Wait for all elements to
																							// be visible
		String excelFilePath = "D:\\Automation Excel\\ServiceHealth.xlsx";
		int colNum = 0;

		List<String> expectedList = new ArrayList<>();
		try {
			expectedList = ExcelReader.readColumnData(excelFilePath, colNum);
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<String> actualList = new ArrayList<>();

		for (WebElement component : getDashboardComponentList) {
			actualList.add(component.getText().trim());
			System.out.println(component.getText().trim()); // Print the text of each component
		}

		System.out.println("actualList : " + actualList);
		System.out.println("expectedList : " + expectedList);

		if (actualList.equals(expectedList)) {
			System.out.println("Dashboard items match the expected list.");
		} else {
			System.out.println("Dashboard items do not match the expected list.");
		}
	}

	@FindBy(xpath = "//em[contains(@class, 'custom-icon') and contains(@class, 'Service-health_Rule-configuration')]")
	WebElement clickOnRuleConfiguration;

	@FindBy(xpath = "//div[contains(text(), 'Rule configuration')]")
	WebElement getRuleConfigurationValue;

	@FindBy(xpath = "//div[@class='headercell-label ng-star-inserted']")
	List<WebElement> getRuleConfigurationComponentList;

	public void clickOnRuleConfiguration() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Explicit wait
		wait.until(ExpectedConditions.elementToBeClickable(clickOnRuleConfiguration)); // Wait until the element is
																						// clickable
		clickOnRuleConfiguration.click(); // Click on the element
	}

	public void verifyRuleConfigurationText() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Explicit wait
		wait.until(ExpectedConditions.visibilityOf(getRuleConfigurationValue)); // Wait until the element is visible

		String expectedValue = "Rule configuration"; // Expected text
		String actualValue = getRuleConfigurationValue.getText(); // Get the actual text from the element
		System.out.println("Rule Configuration Value: " + actualValue);

		org.testng.Assert.assertEquals(actualValue, expectedValue,
				"The Rule configuration text does not match the expected value.");
	}

	public void fetchAndPrintRuleConfigurationComponents() {
		// Explicit wait to ensure the elements are visible
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElements(getRuleConfigurationComponentList));

		String excelFilePath = "D:\\Automation Excel\\ServiceHealth.xlsx";
		int colNum = 1;

		List<String> expectedList = new ArrayList<>();
		try {
			expectedList = ExcelReader.readColumnData(excelFilePath, colNum);
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<String> actualList = new ArrayList<>();

		// Iterate through the list and print each element's text
		System.out.println("Rule Configuration Components:");
		for (WebElement component : getRuleConfigurationComponentList) {
			String componentText = component.getText().trim();
			System.out.println("- " + componentText);
		}
		System.out.println("actualList : " + actualList);
		System.out.println("expectedList : " + expectedList);

		if (actualList.equals(expectedList)) {
			System.out.println("Dashboard items match the expected list.");
		} else {
			System.out.println("Dashboard items do not match the expected list.");
		}
	}

	@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[3]")
	WebElement clickOnRefresh;

	public void refreshPage() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnRefresh)).click();
	}

	@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[6]")
	WebElement clickOnRuleConfigurationFilter;

	@FindBy(xpath = "//span[contains(@class, 'mat-mdc-select-placeholder') and contains(@class, 'mat-mdc-select-min-line') and text()='Select filter']")
	WebElement clickOnSelectFilter;

	@FindBy(xpath = "//span[contains(@class, 'ng-star-inserted') and text()='Name']")
	WebElement selectFilterValue;

	@FindBy(xpath = "//span[contains(@class, 'mat-mdc-select-placeholder') and text()='Select operator']")
	WebElement clickOnSelectOperation;

	@FindBy(xpath = "//span[contains(@class, 'ng-star-inserted') and text()='Contains']")
	WebElement clickOnContains;

	@FindBy(xpath = "//input[@type='text' and @placeholder='Name']")
	WebElement insertName;

	@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[37]")
	WebElement clickOnFilterApplyButton;

	public void verifyRuleConfigurationFilter() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnRuleConfigurationFilter)).click();
	}

	public void clickOnSelectFilter() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Explicit wait
		wait.until(ExpectedConditions.elementToBeClickable(clickOnSelectFilter)); // Wait until the element is clickable
		clickOnSelectFilter.click(); // Click on the element
		selectFilterValue.click();
		clickOnSelectOperation.click();
		clickOnContains.click();
		insertName.sendKeys("call");
		clickOnFilterApplyButton.click();
	}

	@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[4]")
	WebElement clickOnRuleConfigurationCreateButton;

	@FindBy(xpath = "//mat-label[@class='input-label ng-star-inserted']")
	List<WebElement> getRuleConfigurationCreateComponentList;

	@FindBy(xpath = "//em[contains(@class, 'custom-icon') and contains(@class, 'Monitoring-View') and contains(@class, 'iconcolor')]")
	WebElement clickOnCustomerServiceMonitoring;

	@FindBy(xpath = "//div[@class='card-header-heading' and text()='Congestion']")
	WebElement getCustomerServiceValue;

	public void verifyCustomerServiceMonitoring() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Explicit wait
		wait.until(ExpectedConditions.elementToBeClickable(clickOnCustomerServiceMonitoring)); // Wait for the element
		clickOnCustomerServiceMonitoring.click();
		String actualValue = "Congestion";
		String expectedValue = getCustomerServiceValue.getText();
		Assert.assertEquals(actualValue, expectedValue, "Text does not match the expected value.");
	}
}
