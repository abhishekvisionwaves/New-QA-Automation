package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.SeleniumAction;

public class IntellectHub extends SeleniumAction {

	protected WebDriver driver;
	WebDriverWait wait;
	
	// Constructor to initialize elements using the provided WebDriver
		public IntellectHub(WebDriver driver) {
			super(driver); // Explicitly call the parent class constructor
			this.driver = driver;
			PageFactory.initElements(driver, this); // Initialize PageFactory
		}
		
		@FindBy(xpath = "//em[contains(@class, 'custom-icon') and contains(@class, 'Knowledge-Repo_Articles')]")
		WebElement clickOnArticle;
		
		public void movedFromHomePageToArticle() {
			waitForElementToBeClickable(clickOnArticle);
			clickOnArticle.click();
		}
		
		
		@FindBy(xpath = "//input[contains(@class, 'mat-mdc-input-element') and contains(@class, 'ng-pristine')]")
		WebElement enterValueInArticleSearchBox;
		
		public void enterValueInArticleSearch(String text) {
			waitForElementToBeClickable(enterValueInArticleSearchBox);
			enterValueInArticleSearchBox.sendKeys(text);
		}
		
		@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[7]")
		WebElement clickOnCreateNewCategoryIcon;
		
		@FindBy(xpath = "//input[contains(@class, 'mat-mdc-input-element') and contains(@placeholder, 'Category name')]")
		WebElement insertCategoryName;
		
		@FindBy(xpath = "//textarea[contains(@class, 'mat-mdc-input-element') and contains(@class, 'cdk-textarea-autosize')]")
		WebElement insertCategoryDescription;
		
		@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[3]")
		WebElement clickOnCategoryIcon;
		
		@FindBy(xpath = "(//mat-icon[contains(@class, 'mat-icon') and contains(@aria-label, 'fontset icon')])[26]")
		WebElement selectCategoryIcon;
		
		@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[6]")
		WebElement clickOnCategorySubmitButton;
		
		public void createCategory(String categoryName, String description) throws InterruptedException {
			waitForElementToBeClickable(clickOnCreateNewCategoryIcon);
			clickOnCreateNewCategoryIcon.click();
			insertCategoryName.sendKeys(categoryName);
			insertCategoryDescription.sendKeys(description);
			waitForElementToBeVisible(clickOnCategoryIcon);
			clickOnCategoryIcon.click();
			waitForElementToBeClickable(selectCategoryIcon);
			selectCategoryIcon.click();
			waitForElementToBeClickable(clickOnCategorySubmitButton);
			clickOnCategorySubmitButton.click();
			Thread.sleep(5000);
		}
		
		@FindBy(xpath = "(//span[@class='mat-ripple mat-mdc-button-ripple'])[2]")
		WebElement clickOnCreateArticleIcon;
		
		@FindBy(xpath = "//input[starts-with(@id, 'mat-input') and contains(@placeholder, 'Article name')]")
		WebElement enterArticleName;
		
		@FindBy(xpath = "//input[contains(@class, 'mat-mdc-input-element') and contains(@placeholder, 'Category')]")
		WebElement enterCategoryName;
		
		@FindBy(xpath = "//span[contains(@class, 'ng-star-inserted') and text()='Report Test']")
		WebElement selectCategory;
		
		@FindBy(xpath = "(//span[@class='mat-mdc-focus-indicator'])[29]")
		WebElement clickOnProceedButton;
		
		public void createArticle(String article, String categoryName) throws InterruptedException {
			waitForElementToBeClickable(clickOnCreateArticleIcon);
			clickOnCreateArticleIcon.click();
			enterArticleName.sendKeys(article);
			enterCategoryName.sendKeys(categoryName);
			waitForElementToBeClickable(selectCategory);
			selectCategory.click();
			waitForElementToBeClickable(clickOnProceedButton);
			clickOnProceedButton.click();
		}
		
		@FindBy(xpath = "//em[contains(@class, 'custom-icon') and contains(@class, 'Knowledge-Repo_Home')]")
		WebElement clickOnHomePage;
		
		@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[7]")
		WebElement clickedOn3DotInRecentArticle;
		
		@FindBy(xpath = "//span[contains(text(), 'Delete')]")
		WebElement clickOnDelete;
		
		@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[13]")
		WebElement deletePopup;
		
		public void deleteArticle() {
			waitForElementToBeClickable(clickOnHomePage);
			clickOnHomePage.click();
			clickedOn3DotInRecentArticle.click();
			waitForElementToBeClickable(clickOnDelete);
			clickOnDelete.click();
			driver.switchTo().alert().accept();
		}
		
		@FindBy(xpath = "//em[contains(@class, 'custom-icon') and contains(@class, 'Knowledge-Repo_Template')]")
		WebElement clickOnTemplate;
		
		public void clickOnTemplatePage() {
			waitForPageLoad();
			clickOnTemplate.click();
		}
		
		@FindBy(xpath = "//input[@type='text' and @placeholder='Search']")
		WebElement enterValueInTemplateSearchBox;
		
		@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[4]")
		WebElement clickOnSearchIcon;
		
		public void insertValueInSearchBox(String text) {
			waitForElementToBeClickable(enterValueInTemplateSearchBox);
			enterValueInTemplateSearchBox.sendKeys(text);
			waitForElementToBeClickable(clickOnSearchIcon);
			clickOnSearchIcon.click();
		}
		
		@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[7]")
		WebElement clickOnRefreshIcon;
		
		public void validateRefreshButton() {
			waitForElementToBeClickable(clickOnRefreshIcon);
			clickOnRefreshIcon.click();
		}
		
		@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[10]")
		WebElement clickOn3Dot;
		
		@FindBy(xpath = "//span[contains(@class, 'ng-star-inserted') and contains(text(), 'Rename')]")
		WebElement clickOnRename;
		
		@FindBy(xpath = "//input[@placeholder='Category name']")
		WebElement enterNewValue;
		
		@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[29]")
		WebElement clickOnUpdateButton;
		
		public void verifyCategoryRename(String text) {
			waitForElementToBeClickable(clickOn3Dot);
			clickOn3Dot.click();
			waitForElementToBeClickable(clickOnRename);
			clickOnRename.click();
			enterNewValue.sendKeys(text);
			waitForElementToBeClickable(clickOnUpdateButton);
			clickOnUpdateButton.click();
		}
		
		@FindBy(xpath = "//span[contains(text(), 'Edit')]")
		WebElement clickOnEdit;
		
		@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[6]")
		WebElement clickOnCategoryUpdateButton;
		
		public void updateCategory(String categoryName, String categoryDescription) {
			waitForElementToBeClickable(clickOn3Dot);
			clickOn3Dot.click();
			waitForElementToBeClickable(clickOnEdit);
			clickOnEdit.click();
			waitForElementToBeVisible(clickOnCategoryIcon);
			clickOnCategoryIcon.click();
			waitForElementToBeVisible(selectCategoryIcon);
			selectCategoryIcon.click();
			insertCategoryName.sendKeys(categoryName);
			waitForElementToBeClickable(insertCategoryDescription);
			insertCategoryDescription.sendKeys(categoryDescription);
			waitForElementToBeClickable(clickOnCategoryUpdateButton);
			clickOnCategoryUpdateButton.click();
		}
		
		
		
		
		@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[4]")
		WebElement clickOnCreateTemplateIcon;
		
		@FindBy(xpath = "//img[contains(@src, 'assets/blank.png')]")
		WebElement clickOnBlankPage;
		
		@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[23]")
		WebElement clickOnProceed;
		
		@FindBy(xpath = "//input[contains(@class, 'mat-mdc-input-element') and contains(@placeholder, 'Template name')]")
		WebElement enterTemplateName;
		
		@FindBy(xpath = "//input[contains(@class, 'mat-mdc-input-element') and contains(@placeholder, 'Enter template group')]")
		WebElement enterTemplateGroup;
		
		@FindBy(xpath = "//span[@class='ng-star-inserted' and text()='abc']")
		WebElement selectTemplate;
		
		@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[25]")
		WebElement clickOnSubmitButton;
		
		public void createTemplate(String templateName, String templateGroup) {
			waitForElementToBeClickable(clickOnCreateTemplateIcon);
			clickOnCreateTemplateIcon.click();
			waitForElementToBeClickable(clickOnBlankPage);
			clickOnBlankPage.click();
			waitForElementToBeClickable(clickOnProceed);
			clickOnProceed.click();
			enterTemplateName.sendKeys(templateName);
			waitForElementToBeVisible(enterTemplateGroup);
			enterTemplateGroup.sendKeys(templateGroup);
			waitForElementToBeClickable(selectTemplate);
			selectTemplate.click();
			waitForElementToBeClickable(clickOnSubmitButton);
			clickOnSubmitButton.click();
		}
		
		
		
}
