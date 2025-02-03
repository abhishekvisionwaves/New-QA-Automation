package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.SeleniumAction;
import utils.ExcelDataReader;
import utils.ExcelReader;

public class CustomerCare extends SeleniumAction {

	protected WebDriver driver;

	WebDriverWait wait;

	public CustomerCare(WebDriver driver) {
		super(driver); // Explicitly call the parent class constructor
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize PageFactory
	}

	@FindBy(xpath = "//img[contains(@class, 'menu-image')]")
	private WebElement clickOnNetSingularity;

	@FindBy(xpath = "//em[contains(@class, 'icomoon') and contains(@class, 'Search') and contains(@class, 'icon-menu-config')]")
	private WebElement clickOnSearchButton;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement insertModule;

	@FindBy(xpath = "//span[contains(text(), 'Customer Care')]")
	private WebElement selectModule;

	@FindBy(xpath = "//span[@class='areaFilter' and text()='Analytics']")
	private WebElement getDashboardStringMatch;

	@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[3]")
	private WebElement clickOnGISButton;

	@FindBy(xpath = "//div[@style='font-size: 18px;'][text()='GIS']")
	private WebElement verifyGisValue;

	@FindBy(xpath = "//input[@placeholder='Search geography']")
	private WebElement searchGeographyInput;

	@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[3]")
	private WebElement backToDashboardPage;

	@FindBy(xpath = "//em[contains(@class, 'Customer-care_Customer-361')]")
	private WebElement clickOnCustomer360;

	@FindBy(xpath = "//span[@class='searchHeading' and text()='Search customer']")
	private WebElement getCustomer360Value;

	@FindBy(xpath = "//input[@placeholder='Enter name or number']")
	private WebElement insertValueInCustomer360SearchBox;

	@FindBy(xpath = "//span[@class='db_cardheading']")
	private List<WebElement> dashboardList;

	@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[4]")
	private WebElement clickOnViewDetailsButton;

//	@FindBy(xpath = "//span[@class='ng-star-inserted' and contains(text(), 'Avalon Technologies')]")
//	private WebElement selectCustomerValue;

	@FindBy(xpath = "//span[@id='subsID' and contains(text(), '(TTVC5663)')]")
	private WebElement verifyCustomerInformation;

	@FindBy(xpath = "(//bntv-icon[@class='button-icon'])[12]")
	WebElement clickOn3Dot;

	@FindBy(xpath = "//span[@class='ng-star-inserted' and text()='Edit']")
	WebElement clickOnEdit;

	@FindBy(xpath = "//input[@placeholder='Enter task title']")
	WebElement insertTitle;

	@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[60]")
	WebElement clickOnSubmitButton;

	@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[5]")
	WebElement clickOnTask;

	@FindBy(xpath = "//input[@placeholder='Enter task title']")
	WebElement enterTaskTitle;

	@FindBy(xpath = "//span[contains(@class, 'mat-mdc-select-placeholder') and text()='Select task type']")
	WebElement clickOnTaskType;

	@FindBy(xpath = "//span[contains(@class, 'ng-star-inserted') and text()='SMS']")
	WebElement selectTaskTypeValue;

	@FindBy(xpath = "//span[contains(text(), 'Select task priority')]")
	WebElement clickOnPriority;

	@FindBy(xpath = "//span[contains(@class, 'ng-star-inserted') and text()='High']")
	WebElement selectPriorityValue;

	@FindBy(xpath = "//div[@role='textbox']")
	WebElement enterDescrption;

	@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[26]")
	WebElement clickOnTaskSubmitButton;

	// Method to click on Net Singularity
	public void clickOnNetSingularity() {
		waitForElementToBeClickable(clickOnNetSingularity);
		clickOnNetSingularity.click();
	}

	// Method to click on Search button
	public void clickOnSearchButton() throws InterruptedException {
		waitForElementToBeClickable(clickOnSearchButton);
		clickOnSearchButton.click();
	}

	// Method to insert text into the Search module
	public void insertModuleText(String text) throws InterruptedException {
		waitForElementToBeVisible(insertModule);
		insertModule.sendKeys(text);
	}

	// Method to select the Customer Care module
	public void selectModule() throws InterruptedException {
		waitForElementToBeClickable(selectModule);
		selectModule.click();
	}

	// Method to get the Dashboard name text
	public String getDashboardNameText() throws InterruptedException {
		waitForElementToBeVisible(getDashboardStringMatch);
		return getDashboardStringMatch.getText();
	}

	// Method to click on the GIS button
	public void clickOnGISButton() throws InterruptedException {
		waitForElementToBeClickable(clickOnGISButton);
		clickOnGISButton.click();
		System.out.println("Clicked on the GIS button.");
	}

	public String getGisValueText() {
		waitForElementToBeVisible(verifyGisValue);
		return verifyGisValue.getText(); // Get the text of the GIS value
	}

	public void enterTextInSearchGeography(String text) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(searchGeographyInput)).sendKeys(text);
	}

	public void navigateBackToDashboardPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Set wait timeout
		wait.until(ExpectedConditions.elementToBeClickable(backToDashboardPage)).click();
		System.out.println("Navigated back to the dashboard page.");
	}

	// Method to click on Customer 360
	public void clickOnCustomer360() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnCustomer360)).click();
	}

	// Method to get Customer value text
	public String getCustomerValueText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(getCustomer360Value));
		return getCustomer360Value.getText();
	}

	public void enterValueInCustomer360SearchBox(String value) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Set wait timeout
		wait.until(ExpectedConditions.visibilityOf(insertValueInCustomer360SearchBox)); // Wait for the element to be
		insertValueInCustomer360SearchBox.sendKeys(value); // Enter the provided value
		insertValueInCustomer360SearchBox.sendKeys(Keys.ENTER);
	}

	// Method to click on each dashboard item in the list
	public void clickOnDashboardListItems() {
		String excelFilePath = "D:\\Customer_Care.xlsx";
		int colNum = 1;

		List<String> expectedList = new ArrayList<>();
		try {
			expectedList = ExcelReader.readColumnData(excelFilePath, colNum);
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<String> actualList = new ArrayList<>();
		for (WebElement item : dashboardList) {
			actualList.add(item.getText().trim());
		}

		if (actualList.equals(expectedList)) {
			System.out.println("Dashboard items match the expected list.");
		} else {
			System.out.println("Dashboard items do not match the expected list.");
		}
	}

//	public void selectCustomerValue() {
////		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Set wait timeout
////		wait.until(ExpectedConditions.elementToBeClickable(selectCustomerValue)).click();
//		waitForElementToBeClickable(selectCustomerValue, 30);
//		selectCustomerValue.click();
//		System.out.println("Customer 'Avalon Technologies' selected.");
//	}

	public void clickOnViewDetailsButton() {
		waitForElementToBeClickable(clickOnViewDetailsButton);
		clickOnViewDetailsButton.click();
	}

	public void verifyCustomerInformationText() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(verifyCustomerInformation)); // Wait for the element to be visible
		String expectedText = "(TTVC5663)";
		String actualText = verifyCustomerInformation.getText();
		System.out.println("expectedText " + expectedText);
		System.out.println("actualText " + actualText);
		Assert.assertEquals(actualText, "(TTVC5663)", "Value text doesn't match");
	}

//	public void editTasks() throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Explicit wait
//		clickOnCustomer360.click();
//		wait.until(ExpectedConditions.elementToBeClickable(clickOn3Dot)); // Wait until the element is clickable
//		System.out.println("Clicked on 3 dots");
//		clickOnEdit.click();
//		System.out.println("Clicked on edit");
//		insertTitle.sendKeys(" Approved");
//		clickOnSubmitButton.click();
//	}

	public void createTask() throws IOException, InterruptedException {

		waitForElementToBeClickable(clickOnTask);
		clickOnTask.click();

		// Define Excel file path
		String excelFilePath = "D:\\Customer_Care.xlsx"; // Path to your Excel file

		// Read data from Excel file
		List<String[]> formData = ExcelDataReader.readExcelData(excelFilePath);

		for (String[] data : formData) {
			String taskName = data[0]; // Task Name column
			String description = data[1];

			waitForElementToBeClickable(enterTaskTitle);
			enterTaskTitle.sendKeys(taskName);

			waitForElementToBeClickable(enterDescrption);
			enterDescrption.sendKeys(description);

			// Log task creation
			System.out.println("Task Created: Task Name = " + taskName + ", Description = " + description);
		}
		waitForElementToBeClickable(clickOnTaskType);
		clickOnTaskType.click();

		waitForElementToBeClickable(selectTaskTypeValue);
		selectTaskTypeValue.click();

		waitForElementToBeClickable(clickOnPriority);
		clickOnPriority.click();

		waitForElementToBeClickable(selectPriorityValue);
		selectPriorityValue.click();

		waitForElementToBeClickable(clickOnTaskSubmitButton);
		clickOnTaskSubmitButton.click();
	}
}
