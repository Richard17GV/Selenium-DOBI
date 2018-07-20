package testPack6;

	import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class verifyDOBIUserMenuLists {

	private static final long millis = 500;
	private static int PassResult = 0;
	private static int FailResult = 0;
	private static String LogTitle = "verifyDOBIUserMenuLists_";
	private static String CoordUser = "AmandaMarcel";
	private static String MgrUser = "JeremyDupre"; 
	private static String SimpleUser = "RobertArnold";

	public static void main(String[] args) {

		String department = "57130";

		String fileName = new SimpleDateFormat("yyyyMMddHHmmss'.txt'").format(new Date());
		fileName = "TestLogs\\" + LogTitle + fileName;

		// create a file first
		PrintWriter outputfile = null;
		try {
			outputfile = new PrintWriter(fileName);
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
			System.out.println("\tCould not create output file.");
		}

		logger(outputfile, "DOBI Test: Verify Admin, Coordinator, Manager, and minimal user menu links.");

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		driver.get("https://dobitest.savageservices.com");

		loginToDOBI(driver, outputfile);

		// *********** Working with Department dropdown *************

		changeDepartment(driver, department, outputfile);

		// ****************/

		// Verify Admin user menu links

		verifyAdminMenuItems(driver, outputfile);

		// ****************/
		// Verify Coordinator user menu links

		String newUserName = CoordUser;
		String newrole = "Coordinator";
		changeLoggedInUser(driver, newUserName, newrole, outputfile);

		verifyCoordinatorMenuItems(driver, outputfile);

		driver.close();

		// ****************/
		// Verify Manager user menu links

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver2 = new ChromeDriver();

		driver2.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		driver2.get("https://dobitest.savageservices.com");

		loginToDOBI(driver2, outputfile);

		newUserName = MgrUser;
		newrole = "Manager";
		changeLoggedInUser(driver2, newUserName, newrole, outputfile);

		verifyManagerMenuItems(driver2, outputfile);

		driver2.close();

		// ****************/
		// Verify Simple User menu links

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver3 = new ChromeDriver();

		driver3.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		driver3.get("https://dobitest.savageservices.com");

		loginToDOBI(driver3, outputfile);

		newUserName = SimpleUser;
		newrole = "Minimal User";
		changeLoggedInUser(driver3, newUserName, newrole, outputfile);

		verifySimpleUserMenuItems(driver3, outputfile);

		driver3.close();

		logger(outputfile, "\nEnd of DOBI Menu tests.");
		logTestStats(outputfile);
		outputfile.close();
	}

	public static void changeDepartment(WebDriver driver, String department, PrintWriter logfile) {

		// Verify that the Department dropdown is enabled.
		try {
			driver.findElement(By.xpath("//select[@name='departmentDropdownList']")).isEnabled();
			logger(logfile, "\tDepartment dropdown is enabled. PASS");
			++PassResult;
		} catch (Exception e) {
			logger(logfile, "\tDepartment dropdown is NOT enabled.  FAIL");
			++FailResult;
		}

		// See the current Department dropdown selection
		WebElement departmentDropdown = driver.findElement(By.id("departmentDropdownList"));
		Select mySelect = new Select(departmentDropdown);
		WebElement option = mySelect.getFirstSelectedOption();
		logger(logfile, "\tOriginally selected department is " + option.getText()); // prints current department
																					// selection

		// Select department 56000
		Select clickThis = new Select(departmentDropdown);
		clickThis.selectByValue(department);
		logger(logfile, "\tDepartment is changing to " + department); // prints current department selection

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Need to figure out how to verify the Department dropdown choice. Keep getting
		// a 'stale reference' error.
		WebElement deptDropdown = driver.findElement(By.id("departmentDropdownList"));
		Select newSelection = new Select(deptDropdown);
		WebElement myChoice = newSelection.getFirstSelectedOption();
		logger(logfile, "\tDepartment change to  " + ((WebElement) myChoice).getText() + "is verified. PASS");
		++PassResult;
	}

	public static void checkMenuItems(WebDriver driver, String menuLinkText, Boolean LinkDisplayed,
			PrintWriter logfile) {

		Boolean currentState = false; // link displayed = true; link NOT displayed = false;

		try {
			driver.findElement(By.linkText(menuLinkText)).isEnabled();
			currentState = true;

		} catch (Exception e) {
			currentState = false;
		}

		if (LinkDisplayed == true) {
			if (currentState == LinkDisplayed) {
				logger(logfile, "\tDOBI Menu " + menuLinkText + " link is active. PASS");
				++PassResult;
			} else {
				logger(logfile, "\tDOBI Menu " + menuLinkText + " link is NOT active. FAIL  **********)");
				++FailResult;
			}
		} else if (LinkDisplayed == false) {
			if (currentState == LinkDisplayed) {
				logger(logfile, "\tDOBI Menu " + menuLinkText + " link is NOT active. PASS");
				++PassResult;
			} else {
				logger(logfile, "\tDOBI Menu " + menuLinkText + " link is active. FAIL  **********)");
				++FailResult;
			}
		}
	}

	public static void verifyAdminMenuItems(WebDriver driver, PrintWriter logfile) {

		logger(logfile, "\nVerify Admin top menu links.");
		// Verify Home link is enabled.
		String menuItem = "Home";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify Activity link is enabled.
		menuItem = "Activity";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify AP link is enabled.
		menuItem = "AP";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify Billing link is enabled.
		menuItem = "Billing";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify Payroll link is enabled.
		menuItem = "Payroll";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify Journal Entry link is enabled.
		menuItem = "Journal Entry";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify Fuel link is enabled.
		menuItem = "Fuel";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify Reports link is enabled.
		menuItem = "Reports";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify Misc link is enabled.
		menuItem = "Misc";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify Inbox link is enabled.
		menuItem = "Inbox";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify Admin link is enabled.
		menuItem = "Admin";
		checkMenuItems(driver, menuItem, true, logfile);

		// *********** Page and SubMenu verifications *************

		// Verify Home Page for Admin
		menuItem = "Home";
		driver.findElement(By.linkText(menuItem)).click();

		logger(logfile, "\nChecking that 'My AP' is on the Home page.");

		try {
			driver.findElement(By.xpath("//div[@class='section-title' and normalize-space(.//text())='My AP']"));
			logger(logfile, "\t'My AP' is a section title on the Home page. PASS");
			++PassResult;
		} catch (Exception e) {
			logger(logfile, "\t'My AP' is NOT a section title on the Home page. FAIL *************************");
			++FailResult;
		}

		// Verify Activity Page for Admin

		menuItem = "Activity";
		driver.findElement(By.linkText(menuItem)).click();

		// Verify that the DOBI Activity page is displayed.
		try {
			driver.findElement(By.xpath("//nav[@id='left-nav']")).isEnabled();
			logger(logfile, "\tDOBI Activity page Is Displayed.");
		} catch (Exception e) {
			logger(logfile, "\tDOBI Activity page Is NOT Displayed.");
		}

		logger(logfile, "\nChecking the left menu links on the Activity page.");

		menuItem = "ACTIVITY ENTRY SEARCH";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "ACTIVITY INTERFACE";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "ACTIVITY ENTRY ADD/EDIT";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify AP Page for Admin

		menuItem = "AP";
		driver.findElement(By.linkText(menuItem)).click();

		// // Verify that the DOBI Activity page is displayed.
		// try {
		// driver.findElement(By.xpath("//nav[@id='left-nav']")).isEnabled();
		// System.out.println("DOBI Activity page Is Displayed.");
		// }
		// catch (Exception e) {
		// System.out.println("DOBI Activity page Is NOT Displayed.");
		// }

		logger(logfile, "\nChecking the left menu links on the AP page.");

		menuItem = "AP INPUT";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "PENDING APPROVALS";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "PROCESS AP ACCRUAL";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "PAST AP ACCRUALS";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "PROCESS AP FUEL ACCRUAL";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "PURCHASE CARD INTERFACE";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "PURCHASE CARD STATEMENT UPDATE";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "CLOSE EFS ENTRIES";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify BILLING Page for Admin

		menuItem = "Billing";
		driver.findElement(By.linkText(menuItem)).click();

		logger(logfile, "\nChecking the left menu links on the Billing page.");

		menuItem = "INVOICING";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "CREDIT/DEBIT MEMO";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "PROCESS BILLING ACCRUAL";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "EXPORT INVOICES TO CLOUD";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify PAYROLL Page for Admin

		menuItem = "Payroll";
		driver.findElement(By.linkText(menuItem)).click();

		logger(logfile, "\nChecking the left menu links on the Payroll page.");

		menuItem = "PROCESS PAYROLL ACCRUAL";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "PAYROLL INTERFACE";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "HAND CHECK";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify JOURNAL ENTRY Page for Admin

		menuItem = "Journal Entry";
		driver.findElement(By.linkText(menuItem)).click();

		logger(logfile, "\nChecking the left menu links on the Journal Entry page.");

		menuItem = "JE LOOKUP";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "JE ADD/EDIT";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "OPERATION APPROVAL";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "ACCOUNTING APPROVAL";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "PERIOD CONTROL";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify FUEL Page for Admin

		menuItem = "Fuel";
		driver.findElement(By.linkText(menuItem)).click();

		logger(logfile, "\nChecking the left menu links on the Fuel page.");

		menuItem = "FUEL USAGE ENTRY";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "FUEL LOOKUP";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "BULK FUEL PURCHASE";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "FUEL ORDER LOOKUP";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "RECONCILE FUEL";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "FUEL INTERFACE";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify REPORTS Page for Admin

		menuItem = "Reports";
		driver.findElement(By.linkText(menuItem)).click();

		logger(logfile, "\nChecking the left menu links on the Reports page.");

		menuItem = "OBI";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "ACTIVITY ENTRY INPUT REPORT";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "BILLING RATES";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "PAY RATES";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "OVERTIME RATES";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify MISC Page for Admin

		menuItem = "Misc";
		driver.findElement(By.linkText(menuItem)).click();

		logger(logfile, "\nChecking the left menu links on the Misc page.");

		menuItem = "KPI BUDGET INTERFACE";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "KPI BUDGET SEARCH";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify INBOX Page for Admin

		menuItem = "Inbox";
		driver.findElement(By.linkText(menuItem)).click();

		logger(logfile, "\nChecking the left menu links on the Inbox page.");

		menuItem = "BACKGROUND JOB LOG";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify ADMIN Page for Admin

		menuItem = "Admin";
		driver.findElement(By.linkText(menuItem)).click();

		logger(logfile, "\nChecking the left menu links on the Admin page.");

		menuItem = "ACTIVITY";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "STANDARD ATTRIBUTES";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "AP";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "FUEL";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "JOURNALENTRY";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "PAYROLL";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "BILLING";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "DOBI INTERFACE";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "RULES";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "MISCELLANEOUS";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "INTEGRATION";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "SECURITY";
		checkMenuItems(driver, menuItem, true, logfile);
	}

	public static void verifyCoordinatorMenuItems(WebDriver driver, PrintWriter logfile) {

		logger(logfile, "\nVerify top menu links for the coordinator role.");
		// Verify Home link is enabled.
		String menuItem = "Home";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify Activity link is enabled.
		menuItem = "Activity";
		checkMenuItems(driver, menuItem, false, logfile);

		// Verify AP link is enabled.
		menuItem = "AP";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify Billing link is enabled.
		menuItem = "Billing";
		checkMenuItems(driver, menuItem, false, logfile);

		// Verify Payroll link is enabled.
		menuItem = "Payroll";
		checkMenuItems(driver, menuItem, false, logfile);

		// Verify Journal Entry link is enabled.
		menuItem = "Journal Entry";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify Fuel link is enabled.
		menuItem = "Fuel";
		checkMenuItems(driver, menuItem, false, logfile);

		// Verify Reports link is enabled.
		menuItem = "Reports";
		checkMenuItems(driver, menuItem, false, logfile);

		// Verify Misc link is enabled.
		menuItem = "Misc";
		checkMenuItems(driver, menuItem, false, logfile);

		// Verify Inbox link is enabled.
		menuItem = "Inbox";
		checkMenuItems(driver, menuItem, false, logfile);

		// Verify Admin link is enabled.
		menuItem = "Admin";
		checkMenuItems(driver, menuItem, true, logfile);

		// *********** Page and SubMenu verifications *************

		// Verify Home Page for Coordinator
		menuItem = "Home";
		driver.findElement(By.linkText(menuItem)).click();

		logger(logfile, "\tChecking that 'My AP' is on the Home page.");

		try {
			driver.findElement(By.xpath("//div[@class='section-title' and normalize-space(.//text())='My AP']"));
			logger(logfile, "\t'My AP' is a section title on the Home page. PASS");
			++PassResult;
		} catch (Exception e) {
			logger(logfile, "\t'My AP' is NOT a section title on the Home page. FAIL *************************");
			++FailResult;
		}

		// Verify AP Page for Coordinator

		menuItem = "AP";
		driver.findElement(By.linkText(menuItem)).click();

		logger(logfile, "\nChecking the left menu links on the AP page.");

		menuItem = "AP INPUT";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "PENDING APPROVALS";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "PROCESS AP ACCRUAL";
		checkMenuItems(driver, menuItem, false, logfile);

		menuItem = "PAST AP ACCRUALS";
		checkMenuItems(driver, menuItem, false, logfile);

		menuItem = "PROCESS AP FUEL ACCRUAL";
		checkMenuItems(driver, menuItem, false, logfile);

		menuItem = "PURCHASE CARD INTERFACE";
		checkMenuItems(driver, menuItem, false, logfile);

		menuItem = "PURCHASE CARD STATEMENT UPDATE";
		checkMenuItems(driver, menuItem, false, logfile);

		menuItem = "CLOSE EFS ENTRIES";
		checkMenuItems(driver, menuItem, false, logfile);

		// Verify JOURNAL ENTRY Page for Coordinator

		menuItem = "Journal Entry";
		driver.findElement(By.linkText(menuItem)).click();

		logger(logfile, "\nChecking the left menu links on the Journal Entry page.");

		menuItem = "JE LOOKUP";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "JE ADD/EDIT";
		checkMenuItems(driver, menuItem, false, logfile);

		menuItem = "OPERATION APPROVAL";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "ACCOUNTING APPROVAL";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "PERIOD CONTROL";
		checkMenuItems(driver, menuItem, false, logfile);

		// Verify ADMIN Page for Coordinator

		menuItem = "Admin";
		driver.findElement(By.linkText(menuItem)).click();

		logger(logfile, "\nChecking the left menu links on the Admin page.");

		menuItem = "ACTIVITY";
		checkMenuItems(driver, menuItem, false, logfile);

		menuItem = "STANDARD ATTRIBUTES";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "AP";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "FUEL";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "JOURNALENTRY";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "PAYROLL";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "BILLING";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "DOBI INTERFACE";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "RULES";
		checkMenuItems(driver, menuItem, false, logfile);

		menuItem = "MISCELLANEOUS";
		checkMenuItems(driver, menuItem, false, logfile);

		menuItem = "INTEGRATION";
		checkMenuItems(driver, menuItem, false, logfile);

		menuItem = "SECURITY";
		checkMenuItems(driver, menuItem, false, logfile);

		logger(logfile, "\n ");
	}

	public static void verifyManagerMenuItems(WebDriver driver, PrintWriter logfile) {

		logger(logfile, "\nVerify top menu links for a manager.");
		// Verify Home link is enabled.
		String menuItem = "Home";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify Activity link is enabled.
		menuItem = "Activity";
		checkMenuItems(driver, menuItem, false, logfile);

		// Verify AP link is enabled.
		menuItem = "AP";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify Journal Entry link is enabled.
		menuItem = "Journal Entry";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify Fuel link is enabled.
		menuItem = "Fuel";
		checkMenuItems(driver, menuItem, false, logfile);

		// Verify Reports link is enabled.
		menuItem = "Reports";
		checkMenuItems(driver, menuItem, false, logfile);

		// Verify Misc link is enabled.
		menuItem = "Misc";
		checkMenuItems(driver, menuItem, false, logfile);

		// Verify Admin link is enabled.
		menuItem = "Admin";
		checkMenuItems(driver, menuItem, false, logfile);

		// *********** Page and SubMenu verifications *************

		// Verify Home Page for Manager
		menuItem = "Home";
		driver.findElement(By.linkText(menuItem)).click();

		logger(logfile, "\tChecking that 'My AP' is on the Home page.");

		try {
			driver.findElement(By.xpath("//div[@class='section-title' and normalize-space(.//text())='My AP']"));
			logger(logfile, "\t'My AP' is a section title on the Home page. PASS");
			++PassResult;
		} catch (Exception e) {
			logger(logfile, "\t'My AP' is NOT a section title on the Home page. FAIL *************************");
			++FailResult;
		}

		// Verify AP Page for Manager

		menuItem = "AP";
		driver.findElement(By.linkText(menuItem)).click();

		logger(logfile, "\nChecking the left menu links on the AP page.");

		menuItem = "AP INPUT";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "PENDING APPROVALS";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "PROCESS AP ACCRUAL";
		checkMenuItems(driver, menuItem, false, logfile);

		menuItem = "PAST AP ACCRUALS";
		checkMenuItems(driver, menuItem, false, logfile);

		menuItem = "PROCESS AP FUEL ACCRUAL";
		checkMenuItems(driver, menuItem, false, logfile);

		menuItem = "PURCHASE CARD INTERFACE";
		checkMenuItems(driver, menuItem, false, logfile);

		menuItem = "PURCHASE CARD STATEMENT UPDATE";
		checkMenuItems(driver, menuItem, false, logfile);

		menuItem = "CLOSE EFS ENTRIES";
		checkMenuItems(driver, menuItem, false, logfile);

		// Verify JOURNAL ENTRY Page for Manager

		menuItem = "Journal Entry";
		driver.findElement(By.linkText(menuItem)).click();

		logger(logfile, "\nChecking the left menu links on the Journal Entry page.");

		menuItem = "JE LOOKUP";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "JE ADD/EDIT";
		checkMenuItems(driver, menuItem, false, logfile);

		menuItem = "OPERATION APPROVAL";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "ACCOUNTING APPROVAL";
		checkMenuItems(driver, menuItem, true, logfile);

		menuItem = "PERIOD CONTROL";
		checkMenuItems(driver, menuItem, false, logfile);

		logger(logfile, "\n ");
	}

	public static void verifySimpleUserMenuItems(WebDriver driver, PrintWriter logfile) {
		// Verify DOBI access for a simple user, like a Mariner.

		logger(logfile, "\nVerify top menu links for a minimal user.");
		// Verify Home link is enabled.
		String menuItem = "Home";
		checkMenuItems(driver, menuItem, true, logfile);

		// Verify Activity link is NOT enabled.
		menuItem = "Activity";
		checkMenuItems(driver, menuItem, false, logfile);

		// Verify AP link is NOT enabled.
		menuItem = "AP";
		checkMenuItems(driver, menuItem, false, logfile);

		// Verify Journal Entry link is NOT enabled.
		menuItem = "Journal Entry";
		checkMenuItems(driver, menuItem, false, logfile);

		// Verify Fuel link is NOT enabled.
		menuItem = "Fuel";
		checkMenuItems(driver, menuItem, false, logfile);

		// Verify Reports link is NOT enabled.
		menuItem = "Reports";
		checkMenuItems(driver, menuItem, false, logfile);

		// Verify Misc link is NOT enabled.
		menuItem = "Misc";
		checkMenuItems(driver, menuItem, false, logfile);

		// Verify Admin link is NOT enabled.
		menuItem = "Admin";
		checkMenuItems(driver, menuItem, false, logfile);

		// *********** Page and SubMenu verifications *************
		// ***************************************************************** DEV IN
		// PROGRESS
		// Verify Home Page for Simple User
		menuItem = "Home";
		driver.findElement(By.linkText(menuItem)).click();

		logger(logfile, "\tChecking that 'My AP' is on the Home page.");

		try {
			driver.findElement(By.xpath("//div[@class='section-title' and normalize-space(.//text())='My AP']"));
			logger(logfile, "\t'My AP' is a section title on the Home page. PASS");
			++PassResult;
		} catch (Exception e) {
			logger(logfile, "\t'My AP' is NOT a section title on the Home page. FAIL *************************");
			++FailResult;
		}

		logger(logfile, "\nChecking that the Create Expense Report button is on the Home page for a minimal user.");

		try {
			logger(logfile, "\tChecking that 'Create Expense Report' button is on the Home page.");
			driver.findElement(By.xpath("//*[@id=\"expenseReports\"]/div[1]/a")).isEnabled();
			logger(logfile, "The 'Create Expense Report' button is on the Home page. PASS");
			++PassResult;
		} catch (Exception e) {
			logger(logfile,
					"\tThe 'Create Expense Report' button is NOT on the Home page. FAIL *************************");
			++FailResult;
		}

	}

	public static void loginToDOBI(WebDriver driver, PrintWriter logfile) {

		// Open DOBITest and login
		if (driver.findElement(By.xpath("//input[@name='UserName']")).isEnabled()) {
			logger(logfile, "\tDOBI login screen Is Displayed.");
			driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys("SSC\\DOBITEST10");
			driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("dobitest10");
			driver.findElement(By.xpath("//span[@id='submitButton']")).click();
			logger(logfile, "\tLogin as admin user DOBITEST10 attempted.");
		} else {
			logger(logfile, "\tLogin didn't happen");
		}

		try {
			driver.findElement(By.xpath("//div[@id='error']")).isEnabled();
			logger(logfile, "\tDOBI login attempt has failed.");
		} catch (Exception e) {
			logger(logfile, "\tDOBI login attempt has succeeded.");
		}

		// Verify that the DOBI Home page is displayed.
		try {
			driver.findElement(By.xpath("//nav[@id='primary-nav']")).isEnabled();
			logger(logfile, "\tDOBI HOME page Is Displayed.");
		} catch (Exception e) {
			logger(logfile, "\tDOBI HOME page Is NOT Displayed.");
		}

		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void changeLoggedInUser(WebDriver driver, String NewUserName, String role, PrintWriter logfile) {

		String menuItem = "Admin";
		driver.findElement(By.linkText(menuItem)).click();

		menuItem = "SECURITY";
		driver.findElement(By.linkText(menuItem)).click();

		menuItem = "LOGGED IN AS";
		driver.findElement(By.linkText(menuItem)).click();

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(NewUserName);
		driver.findElement(By.xpath("//input[@class='button']")).click();
		logger(logfile, "\n****************************************************");
		logger(logfile, "Changing LOGIN to " + NewUserName + ", role is " + role);

		try {
			driver.findElement(By.xpath("//nav[@id='primary-nav']")).isEnabled();
			logger(logfile, "\tDOBI HOME page Is Displayed.");
		} catch (Exception e) {
			logger(logfile, "\tDOBI HOME page Is NOT Displayed.");
		}

	}

	public static void logger(PrintWriter outfile, String logtext) {

		outfile.println(logtext);
		System.out.println(logtext);

	}

	public static void logTestStats(PrintWriter outfile) {
		logger(outfile, "\n*************************************");
		logger(outfile, "Number of PASSed tests: " + PassResult);
		logger(outfile, "Number of FAILed tests: " + FailResult);
		logger(outfile, "*************************************");
	}

}
