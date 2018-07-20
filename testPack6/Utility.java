package testPack6;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Utility {

	static testingVars varInit(testingVars testVar1) {
		testVar1.PassResult = 0;
		testVar1.FailResult = 0;
		return testVar1;
	}

	public static String setDepartment(FieldMaker fieldName, WebDriver driver, testingVars testVars,
			PrintWriter logfile) {
		// returns text only if the department cannot be accessed.
		String noDeptChange = "";
		try {
			driver.findElement(By.xpath(fieldName.getTheXpath())).isEnabled();
		} catch (Exception e) {
			logger(logfile, "\tDepartment dropdown is NOT enabled.  FAIL");
			++testVars.FailResult;
		}

		// See the current Department dropdown selection
		WebElement departmentDropdown = driver.findElement(By.xpath(fieldName.getTheXpath()));
		Select mySelect = new Select(departmentDropdown);
		WebElement option = mySelect.getFirstSelectedOption();
		logger(logfile, "\tDepartment is currently " + option.getText()); // prints current department selection

		if (!(option.getText()).matches(".*" + testVars.department + ".*")) {

			String res = setDropdownSelection(driver, fieldName, testVars.department, -1, logfile);
			if (res != "") {
				logger(logfile, "\t" + testVars.department + " department doesn't exist for this user.");
				noDeptChange = "DeptNotChanged";
			} else {
				logger(logfile, "\tDepartment change was successful.");
			}
		}
		Utility.waitABit(4);

		// See the changed Department dropdown selection
		WebElement deptDropdown = driver.findElement(By.xpath(fieldName.getTheXpath()));
		Select mySelect2 = new Select(deptDropdown);
		WebElement option2 = mySelect2.getFirstSelectedOption();
		logger(logfile, "\tDepartment is changed to " + option2.getText()); // prints changed department selection

		return noDeptChange;

	}

	public static String changeDepartment(WebDriver driver, testingVars testVars, PrintWriter logfile) {
		// returns text only if the department cannot be accessed.

		String noDeptChange = "";
		try {
			driver.findElement(By.xpath("//select[@name='departmentDropdownList']")).isEnabled();
		} catch (Exception e) {
			logger(logfile, "\tDepartment dropdown is NOT enabled.  FAIL");
			++testVars.FailResult;
		}

		// See the current Department dropdown selection
		WebElement departmentDropdown = driver.findElement(By.id("departmentDropdownList"));
		Select mySelect = new Select(departmentDropdown);
		WebElement option = mySelect.getFirstSelectedOption();
		logger(logfile, "\tDepartment is currently " + option.getText()); // prints current department selection

		if (!(option.getText()).matches(".*" + testVars.department + ".*")) {

			try { // Select department
				Select clickThis = new Select(departmentDropdown);
				clickThis.selectByValue(testVars.department);
				logger(logfile, "\tDepartment is changing to " + testVars.department); // prints current department
																						// selection
			} catch (Exception e) {
				logger(logfile, "\t" + testVars.department + " department doesn't exist for this user.");
				noDeptChange = "DeptNotChanged";
			}

			// Sleep a little after changing the department.
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (noDeptChange == "") {
				// verify the Department dropdown choice.
				WebElement deptDropdown = driver.findElement(By.id("departmentDropdownList"));
				Select newSelection = new Select(deptDropdown);
				WebElement myChoice = newSelection.getFirstSelectedOption();
				logger(logfile, "\tDepartment change to " + ((WebElement) myChoice).getText() + " is verified. PASS");
				++testVars.PassResult;
			}
		}
		return noDeptChange;
	}

	public static void navigateToAPSearch(WebDriver driver, testingVars testVars, PrintWriter outputfile) {
		// Navigate to AP Search page

		try {
			driver.findElement(By.linkText("AP")).click();
			// logger(outputfile, "\tClicked on the 'AP' menu link"); ++testVars.PassResult;
		} catch (Exception e) {
			logger(outputfile, "\t'AP' menu link could not be clicked. FAIL *************************\n");
			++testVars.FailResult;
		}

		try {
			driver.findElement(By.linkText("AP INPUT")).click();
			// logger(outputfile, "\tClicked on the 'AP INPUT' menu link");
			// ++testVars.PassResult;
		} catch (Exception e) {
			logger(outputfile, "\t'AP INPUT' menu link could not be clicked. FAIL *************************\n");
			++testVars.FailResult;
		}

		// Verify that the search page has the section title 'AP INPUT SEARCH
		try {
			driver.findElement(
					By.xpath("//div[@class='section-title' and normalize-space(.//text())='Ap Input Search']"));
			// logger(outputfile, "\t'AP INPUT SEARCH' is a section title on the AP Search
			// page. PASS\n"); ++testVars.PassResult;
		} catch (Exception e) {
			logger(outputfile,
					"\t'AP INPUT SEARCH' is NOT a section title on the AP Search page. FAIL *************************\n");
			++testVars.FailResult;
		}

		driver.findElement(By.xpath("//input[@value='Clear']")).click();

	}

	public static void loginToDOBI(WebDriver driver, PrintWriter logfile, testingVars testVars) {

		// Open DOBITest and login
		if (driver.findElement(By.xpath("//input[@name='UserName']")).isEnabled()) {
			// logger(logfile, "\tDOBI login screen Is Displayed.");
			driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys("SSC\\DOBITEST10");
			driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("dobitest10");
			driver.findElement(By.xpath("//span[@id='submitButton']")).click();
			// logger(logfile, "\tLogin as admin user DOBITEST10 attempted.");
		} else {
			logger(logfile, "\tCould not log in to DOBI test.");
		}

		try {
			driver.findElement(By.xpath("//div[@id='error']")).isEnabled();
			logger(logfile, "\tDOBI login attempt has failed. FAIL --------------");
			++testVars.FailResult;
		} catch (Exception e) {
			logger(logfile, "\tDOBI login attempt has succeeded. PASS");
			++testVars.PassResult;
		}

		// Verify that the DOBI Home page is displayed.
		try {
			driver.findElement(By.xpath("//nav[@id='primary-nav']")).isEnabled();
			logger(logfile, "\tDOBI HOME page Is Displayed. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			logger(logfile, "\tDOBI HOME page Is NOT Displayed. FAIL ---------------");
			++testVars.FailResult;
		}

		try {
			Thread.sleep(testVars.millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static PrintWriter initializeLogFile(testingVars testVars) {

		String fileName = new SimpleDateFormat("yyyyMMddHHmmss'.txt'").format(new Date());
		fileName = "TestLogs\\" + testVars.logTitle + fileName;

		// create a file first
		PrintWriter outputfile = null;
		try {
			outputfile = new PrintWriter(fileName);
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
			System.out.println("Could not create output file.");
		}

		if (outputfile == null) {
			System.out.println("Could not create output file. Exiting test program.");
			System.exit(0);
		}
		return outputfile;

	}

	public static WebDriver initializeDOBIWebPage(boolean headlessFlag) {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		/* options.addArguments("--start-maximized"); */
		if (headlessFlag) {
		options.addArguments("--headless");
		}

		WebDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		driver.get("https://dobitest.savageservices.com");

		return driver;

	}

	public static void logger(PrintWriter outfile, String logtext) {
		outfile.println(logtext);
		System.out.println(logtext);
	}

	public static void logTestStats(PrintWriter outfile, testingVars testVars) {
		logger(outfile, "\r\n*************************************");
		logger(outfile, "Number of Passed tests: " + testVars.PassResult);
		logger(outfile, "Number of Failed tests: " + testVars.FailResult);
		logger(outfile, "*************************************");
	}

	public static void checkEmptySearchResultsIndicators(WebDriver driver, testingVars testVars, PrintWriter logfile) {

		try {
			driver.findElement(By
					.xpath("//*[@id='dataTable']/tbody/tr/td [ normalize-space(text())='No data available in table']"));
			logger(logfile, "\tIn empty AP Search Results, 'No data available in table' appears. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			logger(logfile,
					"\tIn empty AP Search Results, 'No data available in table' DOES NOT appear. FAIL *************************");
			++testVars.FailResult;
		}

		try {
			driver.findElement(
					By.xpath("//*[@id='dataTable_info' and normalize-space(text())='Showing 0 to 0 of 0 entries']"));
			logger(logfile, "\tIn empty AP Search Results, 'Showing 0 to 0 of 0 entries' appears. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			logger(logfile,
					"\tIn empty AP Search Results, 'Showing 0 to 0 of 0 entries' DOES NOT appear. FAIL *************************");
			++testVars.FailResult;
		}

		try {
			driver.findElement(By.xpath("//*[@class='paginate_button previous disabled']"));
			logger(logfile, "\tIn empty AP Search Results, Previous page link is disabled. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			logger(logfile,
					"\tIn empty AP Search Results, Previous page link is NOT disabled. FAIL *************************");
			++testVars.FailResult;
		}

		try {
			driver.findElement(By.xpath("//*[@class='paginate_button next disabled']"));
			logger(logfile, "\tIn empty AP Search Results, Next page link is disabled. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			logger(logfile,
					"\tIn empty AP Search Results, Next page link is NOT disabled. FAIL *************************");
			++testVars.FailResult;
		}

	}

	public static void checkSearchResultsIndicators(WebDriver driver, String RcdCnt, boolean PrevEnabled,
			boolean NextEnabled, testingVars testVars, PrintWriter logfile) {
		// Check results table indicators when search results are not empty.
		try {
			driver.findElement(By
					.xpath("//*[@id='dataTable']/tbody/tr/td [ normalize-space(text())='No data available in table']"));
			logger(logfile,
					"\tIn non-empty AP Search Results, 'No data available in table' appears. FAIL *************************");
			++testVars.FailResult;
		} catch (Exception e) {
			logger(logfile, "\tIn non-empty AP Search Results, 'No data available in table' DOES NOT appear. PASS ");
			++testVars.PassResult;
		}

		if (RcdCnt != "") {
			try {
				driver.findElement(By.xpath(
						"//*[@id='dataTable_info' and normalize-space(text())='Showing " + RcdCnt + " entries']"));
				logger(logfile, "\tIn non-empty AP Search Results, 'Showing " + RcdCnt + " entries' appears. PASS");
				++testVars.PassResult;
			} catch (Exception e) {
				logger(logfile, "\tIn non-empty AP Search Results, 'Showing " + RcdCnt
						+ " entries' DOES NOT appear. FAIL *************************");
				++testVars.FailResult;
			}
		} else {
			try {
				String rcdCount = driver.findElement(By.xpath("//*[@id='dataTable_info']")).getText();
				logger(logfile, "\tIn non-empty AP Search Results, " + rcdCount + " appears. PASS");
				++testVars.PassResult;
			} catch (Exception e) {
				logger(logfile,
						"\tIn non-empty AP Search Results, record count DOES NOT appear. FAIL *************************");
				++testVars.FailResult;
			}
		}

		if (RcdCnt != "") {
			if (PrevEnabled == false) {
				try {
					driver.findElement(By.xpath("//*[@class='paginate_button previous disabled']"));
					logger(logfile, "\tIn empty AP Search Results, Previous page link is disabled. PASS");
					++testVars.PassResult;
				} catch (Exception e) {
					logger(logfile,
							"\tIn empty AP Search Results, Previous page link is NOT disabled. FAIL *************************");
					++testVars.FailResult;
				}
			} else {
				try {
					driver.findElement(By.xpath("//*[@class='paginate_button previous']"));
					logger(logfile, "\tIn non-empty AP Search Results, Previous page link is enabled. PASS");
					++testVars.PassResult;
				} catch (Exception e) {
					logger(logfile,
							"\tIn non-empty AP Search Results, Previous page link is NOT enabled. FAIL *************************");
					++testVars.FailResult;
				}
			}

			if (NextEnabled == false) {
				try {
					driver.findElement(By.xpath("//*[@class='paginate_button next disabled']"));
					logger(logfile, "\tIn empty AP Search Results, Next page link is disabled. PASS");
					++testVars.PassResult;
				} catch (Exception e) {
					logger(logfile,
							"\tIn empty AP Search Results, Next page link is NOT disabled. FAIL *************************");
					++testVars.FailResult;
				}
			} else {
				try {
					driver.findElement(By.xpath("//*[@class='paginate_button next']"));
					logger(logfile, "\tIn non-empty AP Search Results, Next page link is enabled. PASS");
					++testVars.PassResult;
				} catch (Exception e) {
					logger(logfile,
							"\tIn non-empty AP Search Results, Next page link is NOT enabled. FAIL *************************");
					++testVars.FailResult;
				}
			}
		}
	}

	public static String getResultsText(WebDriver driver, int colnum, testingVars testVars, PrintWriter logfile) {
		String recordNum = "";

		recordNum = driver.findElement(By.xpath("//*[@id='dataTable']/tbody/tr[1]/td[1]/a")).getText();

		try {
			recordNum = driver.findElement(By.xpath("//*[@id='dataTable']/tbody/tr[1]/td[1]/a")).getText();
		} catch (Exception e) {
			logger(logfile, "\tDid not find first results record. FAIL *************************");
			++testVars.FailResult;
		}
		return recordNum;
	}

	public static void chainedFieldTests(WebDriver driver, testingVars testVars, PrintWriter outputfile) {
		// Verify status default selections when different Purchase Types are selected.

		// For Purchase Type, Select Expense Report. Verify Status = 'New'
		String selectvalue = "ExpenseReport";
		String ptypeDropdown = "entryType";
		String expectedStatus = "New";
		String statusDropdown = "status";
		setAPSearchDropdown(driver, ptypeDropdown, selectvalue, -1, testVars, outputfile);
		logger(outputfile, "\tSet Purchase Type dropdown to " + selectvalue + ".");
		checkDropdownSelection(driver, statusDropdown, expectedStatus, testVars, outputfile);

		// For Purchase Type, Select default = "All". Verify Status = 'New'
		selectvalue = "";
		ptypeDropdown = "entryType";
		expectedStatus = "New";
		statusDropdown = "status";
		setAPSearchDropdown(driver, ptypeDropdown, selectvalue, 0, testVars, outputfile);
		logger(outputfile, "\tSet Purchase Type dropdown to " + selectvalue + ".");
		checkDropdownSelection(driver, statusDropdown, expectedStatus, testVars, outputfile);

		// For Purchase Type, Select Purchase Order. Verify Status = 'New'
		selectvalue = "PurchaseOrder";
		ptypeDropdown = "entryType";
		expectedStatus = "New";
		statusDropdown = "status";
		setAPSearchDropdown(driver, ptypeDropdown, selectvalue, -1, testVars, outputfile);
		logger(outputfile, "\tSet Purchase Type dropdown to " + selectvalue + ".");
		checkDropdownSelection(driver, statusDropdown, expectedStatus, testVars, outputfile);

		// For Purchase Type, Select e-Voucher. Verify Status = 'Open'
		selectvalue = "Voucher";
		ptypeDropdown = "entryType";
		expectedStatus = "Open";
		statusDropdown = "status";
		setAPSearchDropdown(driver, ptypeDropdown, selectvalue, -1, testVars, outputfile);
		logger(outputfile, "\tSet Purchase Type dropdown to " + selectvalue + ".");
		checkDropdownSelection(driver, statusDropdown, expectedStatus, testVars, outputfile);

		// For Purchase Type, Select Purchase Card. Verify Status = 'Open'
		selectvalue = "PurchaseCard";
		ptypeDropdown = "entryType";
		expectedStatus = "Open";
		statusDropdown = "status";
		setAPSearchDropdown(driver, ptypeDropdown, selectvalue, -1, testVars, outputfile);
		logger(outputfile, "\tSet Purchase Type dropdown to " + selectvalue + ".");
		checkDropdownSelection(driver, statusDropdown, expectedStatus, testVars, outputfile);

	}

	public static void setAPSearchDropdown(WebDriver driver, String dropdownID, String criteria, int critOptionNum,
			testingVars testVars, PrintWriter logfile) {
		WebElement theDropdown = driver.findElement(By.id(dropdownID));
		Select theSelect = new Select(theDropdown);
		if (criteria != "") {
			theSelect.selectByValue(criteria);
			logger(logfile, "\tSelected " + criteria + " in " + dropdownID);
		} else if (critOptionNum != -1) {
			theSelect.selectByIndex(critOptionNum);
		} else {
			logger(logfile, "\tCould not select value for dropdown " + dropdownID);
		}
		WebElement theChoice = theSelect.getFirstSelectedOption();
		logger(logfile, "\tSetting " + dropdownID + " value to " + ((WebElement) theChoice).getText() + ".");

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static String setDropdownSelection(WebDriver driver, FieldMaker fieldName, String criteria,
			int critOptionNum, PrintWriter logfile) {
		if (criteria != "") {
			try {
				WebElement theDropdown = driver.findElement(By.xpath(fieldName.getTheXpath()));
				Select theSelect = new Select(theDropdown);
				theSelect.selectByValue(criteria);
			} catch (Exception e) {
				return "Dropdown not changed";
			}
		} else if (critOptionNum != -1) {
			try {
				WebElement theDropdown = driver.findElement(By.xpath(fieldName.getTheXpath()));
				Select theSelect = new Select(theDropdown);
				theSelect.selectByIndex(critOptionNum);
			} catch (Exception e) {
				return "Dropdown not changed";
			}
		} else {
			logger(logfile, "\tCould not select value for dropdown " + fieldName.getFieldName());
		}
		waitABit();
		return "";
	}

	public static void chooseDropdownSelection(WebDriver driver, String dropdownID, String criteria, int critOptionNum,
			PrintWriter logfile) {
		if (criteria != "") {
			WebElement theDropdown = driver.findElement(By.id(dropdownID));
			Select theSelect = new Select(theDropdown);
			theSelect.selectByValue(criteria);
		} else if (critOptionNum != -1) {
			WebElement theDropdown = driver.findElement(By.id(dropdownID));
			Select theSelect = new Select(theDropdown);
			theSelect.selectByIndex(critOptionNum);
		} else {
			logger(logfile, "\tCould not select value for dropdown " + dropdownID);
		}
		waitABit();
	}

	public static String findDropdownSelection(WebDriver driver, String dropdownId, String dropdownName) {
		String dropdownSelection = "No contents in dropdown";
		if (dropdownId != "") {
			WebElement theDropdown = driver.findElement(By.id(dropdownId));
			Select newSelection = new Select(theDropdown);
			WebElement myChoice = newSelection.getFirstSelectedOption();
			dropdownSelection = ((WebElement) myChoice).getText();
		} else if (dropdownName != "") {
			WebElement theDropdown = driver.findElement(By.id(dropdownName));
			Select newSelection = new Select(theDropdown);
			WebElement myChoice = newSelection.getFirstSelectedOption();
			dropdownSelection = ((WebElement) myChoice).getText();
		}
		waitABit();
		return dropdownSelection;
	}

	public static int findDropdownSize(WebDriver driver, String dropdownId, String dropdownName, String xPath) {
		if (dropdownId != "") {
			WebElement theDropdown = driver.findElement(By.id(dropdownId));
			Select theSelect = new Select(theDropdown);
			List<WebElement> l = theSelect.getOptions();
			return l.size();
		} else if (dropdownName != "") {
			WebElement theDropdown = driver.findElement(By.name(dropdownName));
			Select theSelect = new Select(theDropdown);
			List<WebElement> l = theSelect.getOptions();
			return l.size();
		} else if (xPath != "") {
			WebElement theDropdown = driver.findElement(By.xpath(xPath));
			Select theSelect = new Select(theDropdown);
			List<WebElement> l = theSelect.getOptions();
			return l.size();
		} else {
			return 0;
		}
	}

	public static void checkDropdownSelection(WebDriver driver, String dropdown, String expectedSelection,
			testingVars testVars, PrintWriter logfile) {
		WebElement theDropdown = driver.findElement(By.id(dropdown));
		Select newSelection = new Select(theDropdown);
		WebElement myChoice = newSelection.getFirstSelectedOption();
		String selectedSelection = ((WebElement) myChoice).getText();

		waitABit();

		if (selectedSelection.matches(".*" + expectedSelection + ".*")) { // (selectedSelection == expectedSelection) {
			logger(logfile, "\tDropdown " + dropdown + " matches " + selectedSelection + " as expected. PASS");
			++testVars.PassResult;
		} else {
			logger(logfile, "\tDropdown " + dropdown + " does NOT match " + selectedSelection
					+ ". Expected selection is " + expectedSelection + ".  FAIL --------------");
			++testVars.FailResult;
		}
	}

	public static void setAPSearchTextInputField(WebDriver driver, String textField, String selectvalue,
			testingVars testVars, PrintWriter logfile) {
		driver.findElement(By.xpath("//input[@name='" + textField + "']")).sendKeys(selectvalue);
	}

	public static void setAPSearchRadioButton(WebDriver driver, String radioButton, String selectvalue,
			testingVars testVars, PrintWriter logfile) {
		driver.findElement(By.xpath("//input[@id='" + radioButton + "']")).click();
	}

	public static void checkStatusInSearchResults(WebDriver driver, String status, testingVars testVars,
			PrintWriter logfile) {

		driver.findElement(
				By.xpath("//*[@id='dataTable']/tbody/tr[1]/td[13 and normalize-space(text())='" + status + "']"));

		try {
			driver.findElement(
					By.xpath("//*[@id='dataTable']/tbody/tr[1]/td[13 and normalize-space(text())='" + status + "']"));
			logger(logfile, "\t" + status + " search tests yielded expected search results. PASS");
			++testVars.PassResult;
		} catch (Exception e) {

			logger(logfile, "\t" + status
					+ " status is expected, but not found in the first row of the Search results. FAIL ----------------");
			++testVars.FailResult;
		}

	}

	public static void advancedSearchClick(WebDriver driver, testingVars testVars, PrintWriter logfile) {
		try {
			driver.findElement(By.xpath("//input[@name='searchAdvanced']")).click();
		} catch (Exception e) {
			Utility.logger(logfile, "\tCould not click on Advanced Search button. FAIL *************************");
			++testVars.FailResult;
		}

		try {
			driver.findElement(By.xpath("//*[@class='sorting_1']")).isEnabled(); // row 1 is populated in search results
			Utility.logger(logfile, "\tA list of search results IS displayed. ");
		} catch (Exception e) {
			Utility.logger(logfile, "\tA list of search results did NOT display.  ");
		}

	}

	public static void aPSearchPickaDate(WebDriver driver, String dateField, String chosenDate, testingVars testVars,
			PrintWriter logfile) {
		// from chosenDate, determine month and year string
		// triple click between the two date fields to select the desired field based on
		// click on left or right datepicker arrows until the expected month and date
		// string appears
		// obtain the date from the chosenDate string
		// search on each date field in the date picker until the chosenDate is found
		// click on the discovered date field.
		// logger(logfile, "Entering APSearchPickaDate");
		int i = 0;
		String inDay = "0";

		// from chosenDate, determine month and year string
		String inMonth = "";
		String inDate = "";
		if (chosenDate.substring(1, 2).matches(".*/.*")) {
			inDate = "0" + chosenDate;
		} else {
			inDate = chosenDate;
		}
		if (inDate.substring(4, 5).matches(".*/.*")) {
			inDate = inDate.substring(0, 3) + "0" + inDate.substring(3);
		}
		// logger(logfile,inDate);
		if (inDate.substring(3, 4).matches("0")) {
			inDay = inDate.substring(4, 5);
		} else {
			inDay = inDate.substring(3, 5);
		}
		String inYear = inDate.substring(6);
		inMonth = inDate.substring(0, 2);
		String theMonth = "";
		switch (inMonth) {
		case "01":
			theMonth = "JANUARY";
			break;
		case "02":
			theMonth = "FEBRUARY";
			break;
		case "03":
			theMonth = "MARCH";
			break;
		case "04":
			theMonth = "APRIL";
			break;
		case "05":
			theMonth = "MAY";
			break;
		case "06":
			theMonth = "JUNE";
			break;
		case "07":
			theMonth = "JULY";
			break;
		case "08":
			theMonth = "AUGUST";
			break;
		case "09":
			theMonth = "SEPTEMBER";
			break;
		case "10":
			theMonth = "OCTOBER";
			break;
		case "11":
			theMonth = "NOVEMBER";
			break;
		case "12":
			theMonth = "DECEMBER";
			break;
		}

		// select the start or end date field. Triple click is necessary for stable
		// operation.
		if (dateField == "startDate") {
			driver.findElement(By.xpath("//input[@name='startDate']")).click();
			driver.findElement(By.xpath("//input[@id='endDate']")).click();
			driver.findElement(By.xpath("//input[@name='startDate']")).click();

		} else if (dateField == "endDate") {
			driver.findElement(By.xpath("//input[@id='endDate']")).click();
			driver.findElement(By.xpath("//input[@name='startDate']")).click();
			driver.findElement(By.xpath("//input[@id='endDate']")).click();
		} else {
			driver.findElement(By.xpath(dateField)).click();
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// logger (logfile, "working with the datapicker");
		String toolMonth = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/span[1]")).getText(); // month
																													// field
																													// in
																													// datepicker
		String toolYear = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/span[2]")).getText(); // year
																													// field
																													// in
																													// datepicker

		while (i < 30) {
			if (toolYear.matches(inYear)) {
				if (!(toolMonth.matches(theMonth))) {
					driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']/div/a[1]")).click();
					i++;
					toolMonth = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/span[1]")).getText();
					// logger(logfile,"Expected month is " + theMonth + ". DatePicker Month is " +
					// toolMonth);
				} else {
					break;
				}
			} else {

				driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']/div/a[1]")).click();
				i++;

				toolYear = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/span[2]")).getText();
				// logger(logfile,"Expected year is " + inYear + ". DatePicker Year is " +
				// toolYear);
			}
		}

		int intyear = Integer.parseInt(inYear);
		int intmonth = Integer.parseInt(inMonth);
		int intday = Integer.parseInt(inDay);
		LocalDate dt = LocalDate.of(intyear, intmonth, intday);
		String calDay = String.valueOf(dt.getDayOfWeek()); // dt.getDayOfWeek();
		int tdDay = 0;

		switch (calDay) {
		case "SUNDAY":
			tdDay = 1;
			break;
		case "MONDAY":
			tdDay = 2;
			break;
		case "TUESDAY":
			tdDay = 3;
			break;
		case "WEDNESDAY":
			tdDay = 4;
			break;
		case "THURSDAY":
			tdDay = 5;
			break;
		case "FRIDAY":
			tdDay = 6;
			break;
		case "SATURDAY":
			tdDay = 7;
			break;
		}

		int weekNum = 1 + (intday / 7);

		// click on the calendar date
		driver.findElement(By.xpath(
				"//*[@id='ui-datepicker-div']/table/tbody/tr[" + Integer.toString(weekNum) + "]/td[" + tdDay + "]/a"))
				.click();

		String setDate = "";
		if (dateField == "startDate" || dateField == "endDate") {
			setDate = driver.findElement(By.xpath("//*[@name='" + dateField + "']")).getAttribute("value");
		} else {
			setDate = driver.findElement(By.xpath(dateField)).getAttribute("value");
		}

		if (setDate.matches(".*" + inDate + ".*")) {
			logger(logfile, "\tExpected Date, " + inDate + " is set in the " + dateField + " field. PASS");
			++testVars.PassResult;
		} else {
			logger(logfile, "\t" + setDate + "is set in the " + dateField + " field instead of the expected date, "
					+ inDate + ". FAIL -------------------------------------");
			++testVars.FailResult;
		}
	}

	public static void changeDateType(WebDriver driver, String dtype, testingVars testVars, PrintWriter logfile) {

		switch (dtype) {

		case "Purchase Date":

			driver.findElement(By.xpath("//input[@id='apEntryDateType1']")).click();

			try { // Purchase Date radio button exists
				driver.findElement(By.xpath("//input[@id='apEntryDateType1']")).click();
				logger(logfile, "\tPurchase Date radio button is enabled. ");
			} catch (Exception e) {
				logger(logfile, "\tPurchase Date radio button could NOT be selected.  FAIL *************************");
				++testVars.FailResult;
			}
			break;

		case "Invoice Date":
			try { // Invoice Date radio button exists
				driver.findElement(By.xpath("//input[@id='apEntryDateType2']")).click();
				logger(logfile, "\tInvoice Date radio button is enabled. ");
			} catch (Exception e) {
				logger(logfile, "\tInvoice Date radio button could NOT be selected.  FAIL *************************");
				++testVars.FailResult;
			}
			break;

		case "Entered Date":
			try { // Entered Date radio button exists
				driver.findElement(By.xpath("//input[@id='apEntryDateType3']")).click();
				logger(logfile, "\tEntered Date radio button is enabled. ");
			} catch (Exception e) {
				logger(logfile, "\tEntered Date radio button could NOT be selected.  FAIL *************************");
				++testVars.FailResult;
			}
			break;
		default:
			logger(logfile, "\tEntered Date radio button is selected by default.");
		}
	}

	public static void changeResultsEntriesShown(WebDriver driver, String numEntries, testingVars testVars,
			PrintWriter logfile) {

		logger(logfile, "\tChanging the number of search results shown.");
		try {
			WebElement theDropdown = driver.findElement(By.name("dataTable_length"));
			Select theSelect = new Select(theDropdown);
			theSelect.selectByValue(numEntries);
		} catch (Exception e) {
			logger(logfile, "\tCould not select value for dropdown 'Show " + numEntries + " entries");
		}
	}

	public static void changeDisplayedResultsPage(WebDriver driver, String pageNum, testingVars testVars,
			PrintWriter logfile) {
		logger(logfile, "\tChanging the page of search results shown.");

		try {
			driver.findElement(By.xpath("//*[@id='dataTable_paginate']/span/a[" + pageNum + "]")).click();
		} catch (Exception e) {
			logger(logfile, "\tCould not click on page number in search results. FAIL *************************\n");
			++testVars.FailResult;
		}
	}

	public static void changePageAndVerifyLandingPage(WebDriver driver, String navigate, String landing,
			testingVars testVars, PrintWriter logfile) {

		// Choose results page navigation

		switch (navigate) {
		case "Prev":
		case "prev":
			// check that the Prev button is active, and then click it.

			try {
				driver.findElement(By.xpath("//*[@class='paginate_button previous disabled']"));
				logger(logfile, "\tCan't click on the Prev button right now.");
			} catch (Exception e) {
				try {
					driver.findElement(By.xpath("//*[@class='paginate_button previous']"));
					driver.findElement(By.xpath("//*[@class='paginate_button previous']")).click();

					logger(logfile, "\tClicked on the PREV button. PASS");
					++testVars.PassResult;
				} catch (Exception x) {
					logger(logfile,
							"\tCan't click on the PREV button, although it was expected. FAIL *************************");
					++testVars.FailResult;
				}
			}
			break;

		case "Next":
		case "next":
			// check that the Next button is active, and then click it.
			try {
				driver.findElement(By.xpath("//*[@class='paginate_button next disabled']"));
				logger(logfile, "\tCan't click on the NEXT button right now.");
			} catch (Exception e) {
				try {
					driver.findElement(By.xpath("//*[@class='paginate_button next']"));
					driver.findElement(By.xpath("//*[@class='paginate_button next']")).click();
					logger(logfile, "\tClicked on the NEXT button. PASS");
					++testVars.PassResult;
				} catch (Exception x) {
					logger(logfile,
							"\tCan't click on the NEXT button, although it was expected. FAIL *************************");
					++testVars.FailResult;
				}
			}
			break;

		case "":
			// exit from this switch
			break;

		default:
			// click on the displayed page number
			// be careful, don't enter words or disallowed page numbers into the 'navigate'
			// string, or this switch statement will fail.
			Utility.changeDisplayedResultsPage(driver, testVars.pageNum, testVars, logfile);
		}

		try { // for a search on Closed Purchase Orders during January 2018, 6 records appear.
			driver.findElement(By
					.xpath("//*[@id='dataTable_info' and normalize-space(text())='Showing " + landing + " entries']"));
			logger(logfile, "\tIn non-empty AP Search Results, 'Showing " + landing + " entries' appears. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			logger(logfile, "\tIn non-empty AP Search Results, 'Showing " + landing
					+ " entries' DOES NOT appear. FAIL *************************");
			++testVars.FailResult;
		}

	}

	public static void clearAPSearchCriteria(WebDriver driver, testingVars testVars, PrintWriter logfile) {
		try { // Clear Button exists
			driver.findElement(By.xpath("//input[@value='Clear']")).click();
		} catch (Exception e) {
			logger(logfile, "\tClear Button could NOT be clicked.  FAIL *************************");
			++testVars.FailResult;
		}
	}

	public static void quickAPSearch(WebDriver driver, testingVars testVars, PrintWriter logfile) {
		advancedSearchClick(driver, testVars, logfile);
	}

	public static void verifySearchResultsLayout(WebDriver driver, testingVars testVars, PrintWriter logfile) {

		// determine whether the first record of a result set exists. If so, verify
		// search results indicators. If not, verify empty search results indicators.
		try {
			driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[1]/td[1]/a")).isDisplayed();
			Utility.checkSearchResultsIndicators(driver, "", false, false, testVars, logfile);
		} catch (Exception e) {
			Utility.checkEmptySearchResultsIndicators(driver, testVars, logfile);
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
		logger(logfile, "\tChanging LOGIN to " + NewUserName + ", role is " + role);

		try {
			driver.findElement(By.xpath("//nav[@id='primary-nav']")).isEnabled();
			logger(logfile, "\tDOBI HOME page Is Displayed.\n");
		} catch (Exception e) {
			logger(logfile, "\tDOBI HOME page Is NOT Displayed.\n");
		}

	}

	public static void navigateToAddEditPurchaseOrder(WebDriver driver, testingVars testVars, PrintWriter logfile) {
		try {
			driver.findElement(By.linkText("AP")).click();
			// logger(logfile, "\tClicked on the 'AP' menu link"); ++testVars.PassResult;
		} catch (Exception e) {
			logger(logfile, "\t'AP' menu link could not be clicked. FAIL *************************\n");
			++testVars.FailResult;
		}

		try {
			driver.findElement(By.linkText("AP INPUT")).click();
			// logger(logfile, "\tClicked on the 'AP INPUT' menu link");
			// ++testVars.PassResult;
		} catch (Exception e) {
			logger(logfile, "\t'AP INPUT' menu link could not be clicked. FAIL *************************\n");
			++testVars.FailResult;
		}

		try {
			driver.findElement(By.linkText("PURCHASE ORDER")).click();
			// logger(logfile, "\tClicked on the 'Purchase Order' menu link");
			// ++testVars.PassResult;
		} catch (Exception e) {
			logger(logfile, "\t'Purchase Order' menu link could not be clicked. FAIL *************************\n");
			++testVars.FailResult;
		}

	}

	public static void verifyLandingPage(WebDriver driver, testingVars testVars, PrintWriter logfile) {

		try { // Page title
			driver.findElement(
					By.xpath("//div[@id='main-content']/section/div[2]/div[1 and normalize-space(.//text())='"
							+ testVars.landingPage + "']"));
			Utility.logger(logfile, "\tThe '" + testVars.landingPage + "' page has opened. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(logfile,
					"\tThe '" + testVars.landingPage + "' page has NOT opened. FAIL *************************");
			++testVars.FailResult;
		}

	}

	public static void verifyPageElement(WebDriver driver, FieldMaker setFields, testingVars testVars,
			PrintWriter logfile) {

		/*
		 * manual try on findElement
		 * driver.findElement(By.xpath(setFields.getTheXpath()));
		 */

		try {
			driver.findElement(By.xpath(setFields.getTheXpath()));
			Utility.logger(logfile, "\t" + setFields.getxPathDescription() + " does exist. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(logfile,
					"\t" + setFields.getxPathDescription() + " does NOT exist. FAIL *************************");
			++testVars.FailResult;
		}

	}

	public static String getValueText(WebDriver driver, FieldMaker getData) {
		try {

			return getData.getValueString();

		} catch (Exception e) {
		}
		return "";
	}

	public static String getDataText(WebDriver driver, FieldMaker getData) {
		try {
			return driver.findElement(By.xpath(getData.getTheXpath())).getText();

		} catch (Exception e) {
		}
		return "";
	}

	public static void waitABit() {
		waitABit(1);
	}

	public static void waitABit(int numberOfHalfSeconds) {

		if (numberOfHalfSeconds >= 1) {
			for (int i = 1; i <= numberOfHalfSeconds; i++) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}

	public static String clarifyColor(String rgbColor) {

		if (rgbColor.substring(0, 4).equals("rgba")) {
			String[] hexValue = rgbColor.replace("rgba(", "").replace(")", "").split(",");

			int hexValue1 = Integer.parseInt(hexValue[0]);
			hexValue[1] = hexValue[1].trim();
			int hexValue2 = Integer.parseInt(hexValue[1]);
			hexValue[2] = hexValue[2].trim();
			int hexValue3 = Integer.parseInt(hexValue[2]);

			String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);

			return actualColor;

		} else if (rgbColor.substring(0, 4).equals("rgb(")) {
			String[] hexValue = rgbColor.replace("rgb(", "").replace(")", "").split(",");

			int hexValue1 = Integer.parseInt(hexValue[0]);
			hexValue[1] = hexValue[1].trim();
			int hexValue2 = Integer.parseInt(hexValue[1]);
			hexValue[2] = hexValue[2].trim();
			int hexValue3 = Integer.parseInt(hexValue[2]);

			String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);

			return actualColor;

		} else {
			return "not a color";
		}

	}

	public static String getNewPurchaseOrderNumber(WebDriver driver, testingVars testVars, PrintWriter logfile) {
		String newPONum = "";
		try {
			driver.findElement(By.xpath(AddEditPOFields.addPO_PageTitle().getTheXpath()));
			newPONum = driver.findElement(By.xpath(AddEditPOFields.purchaseOrderNumberValue().getTheXpath())).getText();
		} catch (Exception e) {
			Utility.logger(logfile,
					"\t'Need to be on the Add/Edit Purchase Order page to get a new Purchase Order number.");
		}
		return newPONum;
	}

	public static void acceptAlert(WebDriver driver, testingVars testVars, PrintWriter logfile) {
		Alert javascriptprompt = driver.switchTo().alert();
		Utility.logger(logfile, "\t\tConfirm dialog displays: " + javascriptprompt.getText());
		javascriptprompt.accept();
		Utility.waitABit(4);
	}

	public static double getPOTotalValue(WebDriver driver, testingVars testVars, PrintWriter logfile) {
		double theTotal = 0;
		String poTotal = "";
		try {
			poTotal = driver.findElement(By.xpath(AddEditPOFields.totalValue().getTheXpath())).getText();
		} catch (Exception e) {
			Utility.logger(logfile, "\t'Could not retrieve the Total value on the Add/Edit Purchase Order page.");
		}
		theTotal = Double.parseDouble(poTotal);
		return theTotal;
	}

	public static void verifyPresenceOfAPSearchFields(WebDriver driver, testingVars testVars, PrintWriter logfile) {
		Utility.navigateToAPSearch(driver, testVars, logfile);

		FieldMaker searchField = APSearchFields.searchPageTitle();
		driver.findElement(By.xpath(searchField.getTheXpath())).isDisplayed();
		System.out.println("Title");

		searchField = APSearchFields.poNumberTextInput();
		driver.findElement(By.xpath(searchField.getTheXpath())).isDisplayed();
		System.out.println("PO #");

		searchField = APSearchFields.paykeyTextInput();
		driver.findElement(By.xpath(searchField.getTheXpath())).isDisplayed();
		System.out.println("Paykey");

		searchField = APSearchFields.invoiceNumberTextInput();
		driver.findElement(By.xpath(searchField.getTheXpath())).isDisplayed();
		System.out.println("Invoice#");

		searchField = APSearchFields.basicSearchButton();
		driver.findElement(By.xpath(searchField.getTheXpath())).isDisplayed();
		System.out.println("basic search button");

		searchField = APSearchFields.purchaseTypeDropdown();
		driver.findElement(By.xpath(searchField.getTheXpath())).isDisplayed();
		System.out.println("Purchase type");

		searchField = APSearchFields.referenceNumberTextInput();
		driver.findElement(By.xpath(searchField.getTheXpath())).isDisplayed();
		System.out.println("RefNum");

		searchField = APSearchFields.statusDropdown();
		driver.findElement(By.xpath(searchField.getTheXpath())).isDisplayed();
		System.out.println("status");

		searchField = APSearchFields.locationDropdown();
		driver.findElement(By.xpath(searchField.getTheXpath())).isDisplayed();
		System.out.println("location");

		searchField = APSearchFields.vendorDropdown();
		driver.findElement(By.xpath(searchField.getTheXpath())).isDisplayed();
		System.out.println("vendor");

		searchField = APSearchFields.purchaseDateRadioButton();
		driver.findElement(By.xpath(searchField.getTheXpath())).isDisplayed();
		System.out.println("pdate radio button");

		searchField = APSearchFields.invoiceDateRadioButton();
		driver.findElement(By.xpath(searchField.getTheXpath())).isDisplayed();
		System.out.println("Inv date radion button");

		searchField = APSearchFields.enteredDateRadioButton();
		driver.findElement(By.xpath(searchField.getTheXpath())).isDisplayed();
		System.out.println("Entered Date radio button");

		searchField = APSearchFields.startDatepicker();
		driver.findElement(By.xpath(searchField.getTheXpath())).isDisplayed();
		System.out.println("Start Date");

		searchField = APSearchFields.endDatepicker();
		driver.findElement(By.xpath(searchField.getTheXpath())).isDisplayed();
		System.out.println("End Date");

		searchField = APSearchFields.advancedSearchButton();
		driver.findElement(By.xpath(searchField.getTheXpath())).isDisplayed();
		System.out.println("Advanced Search Button");

		searchField = APSearchFields.clearButton();
		driver.findElement(By.xpath(searchField.getTheXpath())).isDisplayed();
		System.out.println("Clear button");

		searchField = APSearchFields.emptySearchResultsText();
		driver.findElement(By.xpath(searchField.getTheXpath())).isDisplayed();
		System.out.println("Empty Results text");

		searchField = APSearchFields.searchResults_EntriesPerPageDropdown();
		driver.findElement(By.xpath(searchField.getTheXpath())).isDisplayed();
		System.out.println("Entries per page");

		searchField = APSearchFields.searchResults_FilterTextInput();
		driver.findElement(By.xpath(searchField.getTheXpath())).isDisplayed();
		System.out.println("Search results filter");
	}

}
