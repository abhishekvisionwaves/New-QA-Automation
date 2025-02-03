package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.SeleniumAction;

public class CaseManagement2 extends SeleniumAction {

    protected WebDriver driver;

    // Constructor to initialize elements using the provided WebDriver
    public CaseManagement2(WebDriver driver) {
        super(driver); // Call the parent class constructor
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize PageFactory
    }

    // Side Menu Bar elements
    @FindBy(xpath = "//em[contains(@class, 'custom-icon root-modules icon icomoon Case-Management_Dashboard white ng-star-inserted')]")
    private WebElement analyticsSideMenuBar;

    @FindBy(xpath = "//em[starts-with(@class, 'custom-icon') and contains(@class, 'Case-Management_Cases')]")
    private WebElement casesSideMenuBar;

    // Dashboard elements
    @FindBy(xpath = "(//span[contains(@class, 'mat-mdc-button-touch-target')])[15]")
    private WebElement completedCaseIconOnDashboard;

    @FindBy(xpath = "(//span[contains(@class, 'mat-mdc-button-touch-target')])[13]")
    private WebElement gisIconDashboard;

    @FindBy(xpath = "(//span[contains(@class, 'mat-mdc-button-touch-target')])[17]")
    private WebElement casesListIconDashboard;

    @FindBy(xpath = "//div[contains(@style, 'font-size') and contains(text(), 'Active cases')]")
    private WebElement activeCasesTextOnDashboard;

    // GIS Page elements
    @FindBy(xpath = "//div[contains(text(), 'GIS (Active cases)')]")
    private WebElement gisActiveCasesText;

    @FindBy(xpath = "(//span[contains(@class, 'mat-mdc-button-touch-target')])[7]")
    private WebElement caseListIconOnGisPage;

    @FindBy(xpath = "(//span[contains(@class, 'mat-mdc-button-touch-target')])[6]")
    private WebElement completedCaseIconOnGisPage;

    @FindBy(xpath = "(//span[contains(@class, 'mat-mdc-button-touch-target')])[8]")
    private WebElement activeCaseIconOnGisPage;

    @FindBy(xpath = "//input[@placeholder='Search geography']")
    private WebElement searchBoxOnGisPage;

    @FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[3]")
    private WebElement clickSearchOnGisPage;

    // Methods for Side Menu Bar
    public void clickAnalyticsSideMenuBar() throws InterruptedException {
        waitForElementToBeClickable(analyticsSideMenuBar);
        analyticsSideMenuBar.click();
    }

    public void clickCasesSideMenuBar() throws InterruptedException {
        waitForElementToBeClickable(casesSideMenuBar);
        casesSideMenuBar.click();
    }

    // Methods for Dashboard
    public void clickCompletedCaseIconOnDashboard() throws InterruptedException {
        waitForElementToBeClickable(completedCaseIconOnDashboard);
        completedCaseIconOnDashboard.click();
    }

    public void clickGisIconDashboard() throws InterruptedException {
        waitForElementToBeClickable(gisIconDashboard);
        gisIconDashboard.click();
    }

    public void clickCasesListIconDashboard() throws InterruptedException {
        waitForElementToBeClickable(casesListIconDashboard);
        casesListIconDashboard.click();
    }

    public String getActiveCasesTextOnDashboard() {
        return activeCasesTextOnDashboard.getText();
    }

    // Methods for GIS Page
    public String getGisActiveCasesText() {
        return gisActiveCasesText.getText();
    }

    public void clickCaseListIconOnGisPage() throws InterruptedException {
        waitForElementToBeClickable(caseListIconOnGisPage);
        caseListIconOnGisPage.click();
    }

    public void clickCompletedCaseIconOnGisPage() throws InterruptedException {
        waitForElementToBeClickable(completedCaseIconOnGisPage);
        completedCaseIconOnGisPage.click();
    }

    public void clickActiveCaseIconOnGisPage() throws InterruptedException {
        waitForElementToBeClickable(activeCaseIconOnGisPage);
        activeCaseIconOnGisPage.click();
    }

    public void enterTextInSearchBoxOnGisPage(String text) {
        searchBoxOnGisPage.clear();
        searchBoxOnGisPage.sendKeys(text);
    }

    public void clickSearchOnGisPage() throws InterruptedException {
        waitForElementToBeClickable(clickSearchOnGisPage);
        clickSearchOnGisPage.click();
    }
}
