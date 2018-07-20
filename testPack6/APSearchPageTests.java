package testPack6;

import java.io.PrintWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class APSearchPageTests {

	public static void main(String[] args) {

		testingVars testVars = new testingVars();

		PrintWriter outputfile = Utility.initializeLogFile(testVars);
		WebDriver driver = Utility.initializeDOBIWebPage();

		Utility.varInit(testVars);
		Utility.logger(outputfile, "\tDOBI Test: Verify AP Searches for Purchase Orders, Expense Reports, and more.");

		Utility.logger(outputfile, "\nLogin Tests");
		Utility.loginToDOBI(driver, outputfile, testVars);

		Utility.logger(outputfile, "\nSet Department Tests");
		Utility.changeDepartment(driver, testVars, outputfile);
		Utility.navigateToAPSearch(driver, testVars, outputfile);

		Utility.logger(outputfile, "\nSearch Page Contents Tests");
		verifyAPSearchPageElements(driver, testVars, outputfile);

		Utility.logger(outputfile, "\nVerify column title sets by Purchase Type when search results are empty.");
		aPSearchResultsColumnTitlesTests(driver, "Purchase Order", testVars, outputfile);
		aPSearchResultsColumnTitlesTests(driver, "Purchase Card", testVars, outputfile);
		aPSearchResultsColumnTitlesTests(driver, "Expense Report", testVars, outputfile);
		aPSearchResultsColumnTitlesTests(driver, "e-Voucher", testVars, outputfile);
		aPSearchResultsColumnTitlesTests(driver, "All", testVars, outputfile);
		Utility.checkEmptySearchResultsIndicators(driver, testVars, outputfile);

		Utility.logger(outputfile, "\nChained Field Tests for Purchase Type and Status.");
		Utility.chainedFieldTests(driver, testVars, outputfile);

		Utility.logger(outputfile, "\nSingle Criteria Search Tests - Basic Search Section");
		basicSearchTests(driver, testVars, outputfile);

		Utility.logger(outputfile, "\nSingle Criteria Search Tests - Advanced Search Section");
		advancedSearchOneCriteriaTests(driver, testVars, outputfile);

		Utility.logger(outputfile, "\nSingle Criteria Search Tests - Status options");
		searchByStatusTests(driver, testVars, outputfile);
		// Blocking out working tests
		// *****************************************************************
		// */
		/// * // Blocking out working tests
		// *****************************************************************

		Utility.logger(outputfile,
				"\nNon-Empty Search Results - Verify 'Number of Records' and 'Pagination' indicators.");
		// need to do a search on Closed Purchase Orders for January 1 - 31, 2018 for
		// department 57130. 6 records will appear.
		testVars.department = "57130";
		testVars.pType = "PurchaseOrder";
		testVars.referenceNum = "";
		testVars.status = "Closed";
		testVars.loc = "";
		testVars.ven = "";
		testVars.startdate = "03/01/2018";
		testVars.enddate = "03/31/2018";
		testVars.dateType = "";
		testVars.recordCount = "1 to 25 of 608";
		testVars.prevEnabled = false;
		testVars.nextEnabled = true;
		generalAPSearch(driver, testVars, outputfile);
		aPSearchResultsColumnTitlesTests(driver, testVars.pType, testVars, outputfile);
		Utility.checkSearchResultsIndicators(driver, testVars.recordCount, testVars.prevEnabled, testVars.nextEnabled,
				testVars, outputfile);

		Utility.logger(outputfile,
				"\nSearch Scenario 1: Find and open a Purchase Order record with Diamond Marine Svcs, All statuses, 3/1 - 3/31/2018, Location MV.");
		testVars.department = "57130";
		testVars.pType = "PurchaseOrder";
		testVars.referenceNum = "";
		testVars.status = "";
		testVars.loc = "MV";
		testVars.ven = "98590";
		testVars.startdate = "03/01/2018";
		testVars.enddate = "03/31/2018";
		testVars.dateType = "";
		testVars.recordCount = "1 to 16 of 16";
		testVars.prevEnabled = false;
		testVars.nextEnabled = false;
		testVars.landingPage = "Add/Edit Purchase Order";
		generalAPSearch(driver, testVars, outputfile);
		aPSearchResultsColumnTitlesTests(driver, testVars.pType, testVars, outputfile);
		Utility.checkSearchResultsIndicators(driver, testVars.recordCount, testVars.prevEnabled, testVars.nextEnabled,
				testVars, outputfile);
		openFirstRecord_VerifyPurchaseType(driver, testVars.landingPage, testVars, outputfile);

		Utility.logger(outputfile, "\nSearch Scenario 2: Find and open an Expense Report, Void, 4/1 - 4/30/2018.");
		testVars.department = "57130";
		testVars.pType = "ExpenseReport";
		testVars.referenceNum = "";
		testVars.status = "Void";
		testVars.loc = "MV";
		testVars.ven = "";
		testVars.startdate = "04/01/2018";
		testVars.enddate = "04/30/2018";
		testVars.dateType = "";
		testVars.recordCount = "1 to 2 of 2";
		testVars.prevEnabled = false;
		testVars.nextEnabled = false;
		testVars.landingPage = "Add/Edit Expense Report";
		generalAPSearch(driver, testVars, outputfile);
		String rcdNum = Utility.getResultsText(driver, 1, testVars, outputfile);
		testVars.landingPage = testVars.landingPage + " " + rcdNum;
		aPSearchResultsColumnTitlesTests(driver, testVars.pType, testVars, outputfile);
		Utility.checkSearchResultsIndicators(driver, testVars.recordCount, testVars.prevEnabled, testVars.nextEnabled,
				testVars, outputfile);
		openFirstRecord_VerifyPurchaseType(driver, testVars.landingPage, testVars, outputfile);

		Utility.logger(outputfile,
				"\nSearch Scenario 3: Find and open an e-Voucher, Closed status, 4/1 - 4/30/2018, vendor is Rouse Enterprises, LLC. Look at a record on page 2.");
		testVars.department = "57130";
		testVars.pType = "Voucher";
		testVars.referenceNum = "";
		testVars.status = "Closed";
		testVars.loc = "MV";
		testVars.ven = "98824";
		testVars.startdate = "04/01/2018";
		testVars.enddate = "04/30/2018";
		testVars.dateType = "";
		testVars.recordCount = "11 to 20 of 22";
		testVars.prevEnabled = true;
		testVars.nextEnabled = true;
		testVars.landingPage = "Add/Edit E-Voucher";
		testVars.numEntries = "10";
		testVars.pageNum = "2";
		generalAPSearch(driver, testVars, outputfile);
		aPSearchResultsColumnTitlesTests(driver, testVars.pType, testVars, outputfile);
		Utility.changeResultsEntriesShown(driver, testVars.numEntries, testVars, outputfile);
		Utility.changeDisplayedResultsPage(driver, testVars.pageNum, testVars, outputfile);
		Utility.checkSearchResultsIndicators(driver, testVars.recordCount, testVars.prevEnabled, testVars.nextEnabled,
				testVars, outputfile);
		openFirstRecord_VerifyPurchaseType(driver, testVars.landingPage, testVars, outputfile);

		Utility.logger(outputfile,
				"\nSearch Scenario 4: Purchase Card, closed, 3/1 - 3/31/2018, view 100 results per page.");
		testVars.department = "57130";
		testVars.pType = "PurchaseCard";
		testVars.referenceNum = "";
		testVars.status = "Closed";
		testVars.loc = "MV";
		testVars.ven = "";
		testVars.startdate = "03/01/2018";
		testVars.enddate = "03/31/2018";
		testVars.dateType = "";
		testVars.recordCount = "1 to 26 of 26";
		testVars.prevEnabled = false;
		testVars.nextEnabled = false;
		testVars.landingPage = "Add / Edit Purchase Card";
		testVars.numEntries = "100";
		testVars.pageNum = "";
		generalAPSearch(driver, testVars, outputfile);
		aPSearchResultsColumnTitlesTests(driver, testVars.pType, testVars, outputfile);
		Utility.changeResultsEntriesShown(driver, testVars.numEntries, testVars, outputfile);
		Utility.checkSearchResultsIndicators(driver, testVars.recordCount, testVars.prevEnabled, testVars.nextEnabled,
				testVars, outputfile);
		openFirstRecord_VerifyPurchaseType(driver, testVars.landingPage, testVars, outputfile);

		Utility.logger(outputfile, "\nSearch Scenario 5: RefNum = 31218EF, 4/1-4/30/2018, all statuses, all locations");
		testVars.department = "57130";
		testVars.pType = "";
		testVars.referenceNum = "31218EF";
		testVars.status = "";
		testVars.loc = "";
		testVars.ven = "";
		testVars.startdate = "04/01/2018";
		testVars.enddate = "04/30/2018";
		testVars.dateType = "";
		testVars.recordCount = "1 to 1 of 1";
		testVars.prevEnabled = false;
		testVars.nextEnabled = false;
		testVars.landingPage = "Add/Edit E-Voucher";
		generalAPSearch(driver, testVars, outputfile);
		aPSearchResultsColumnTitlesTests(driver, testVars.pType, testVars, outputfile);
		Utility.checkSearchResultsIndicators(driver, testVars.recordCount, testVars.prevEnabled, testVars.nextEnabled,
				testVars, outputfile);
		openFirstRecord_VerifyPurchaseType(driver, testVars.landingPage, testVars, outputfile);

		Utility.logger(outputfile,
				"\nSearch Scenario 6: RefNum = 25318EF, purchasedate = 2/16/2018, Vendor is Diamond Marine Svcs, Location is MV ");
		testVars.department = "57130";
		testVars.pType = "";
		testVars.referenceNum = "25318EF";
		testVars.status = "";
		testVars.loc = "MV";
		testVars.ven = "98590";
		testVars.startdate = "02/16/2018";
		testVars.enddate = "02/16/2018";
		testVars.recordCount = "1 to 1 of 1";
		testVars.prevEnabled = false;
		testVars.nextEnabled = false;
		testVars.landingPage = "Add/Edit E-Voucher";
		testVars.dateType = "Purchase Date";
		generalAPSearch(driver, testVars, outputfile);
		aPSearchResultsColumnTitlesTests(driver, testVars.pType, testVars, outputfile);
		Utility.checkSearchResultsIndicators(driver, testVars.recordCount, testVars.prevEnabled, testVars.nextEnabled,
				testVars, outputfile);
		openFirstRecord_VerifyPurchaseType(driver, testVars.landingPage, testVars, outputfile);

		Utility.logger(outputfile,
				"\nSearch Scenario 7: RefNum = 25318EF, purchasedate = 2/16/2018, Vendor is EFS LLC, location = All. Expect no results returned. ");
		testVars.department = "57130";
		testVars.pType = "";
		testVars.referenceNum = "25318EF";
		testVars.status = "";
		testVars.loc = "MV";
		testVars.ven = "84371";
		testVars.startdate = "02/16/2018";
		testVars.enddate = "02/16/2018";
		testVars.recordCount = "0 to 0 of 0";
		testVars.prevEnabled = false;
		testVars.nextEnabled = false;
		testVars.landingPage = "Add/Edit E-Voucher";
		testVars.dateType = "Purchase Date";
		generalAPSearch(driver, testVars, outputfile);
		aPSearchResultsColumnTitlesTests(driver, testVars.pType, testVars, outputfile);
		Utility.checkEmptySearchResultsIndicators(driver, testVars, outputfile);

		Utility.logger(outputfile,
				"\nSearch Scenario 8: All Purchase Types and statuses, 4/1 - 4/30/2018, Vendor is EFS LLC. Exercise Number of page results and Search results filter.");
		testVars.department = "57130";
		testVars.pType = "";
		testVars.referenceNum = "";
		testVars.status = "";
		testVars.loc = "";
		testVars.ven = "84371";
		testVars.startdate = "04/01/2018";
		testVars.enddate = "04/30/2018";
		testVars.recordCount = "1 to 25 of 797";
		testVars.prevEnabled = false;
		testVars.nextEnabled = true;
		testVars.landingPage = "";
		testVars.dateType = "";
		testVars.pageNum = "5";
		generalAPSearch(driver, testVars, outputfile);
		aPSearchResultsColumnTitlesTests(driver, testVars.pType, testVars, outputfile);
		Utility.checkSearchResultsIndicators(driver, testVars.recordCount, testVars.prevEnabled, testVars.nextEnabled,
				testVars, outputfile);
		Utility.changePageAndVerifyLandingPage(driver, "Prev", testVars.recordCount, testVars, outputfile); // Prev is
																											// disabled.
																											// Page
																											// reference
																											// won't
																											// change.
		Utility.changePageAndVerifyLandingPage(driver, "Next", "26 to 50 of 797", testVars, outputfile); // Page 2 will
																											// be
																											// displayed.
		Utility.changePageAndVerifyLandingPage(driver, "Next", "51 to 75 of 797", testVars, outputfile);
		Utility.changePageAndVerifyLandingPage(driver, "5", "101 to 125 of 797", testVars, outputfile); // Page 8 will
																										// be displayed.
		Utility.changePageAndVerifyLandingPage(driver, "Prev", "76 to 100 of 797", testVars, outputfile); // Page 7 will
																											// be
																											// displayed.
		int ii = 0;
		int iii = 0;
		for (int i = 0; i <= 8; i++) {
			ii = ((i + 4) * 25) + 1;
			iii = ((i + 5) * 25);
			testVars.pageNum = ii + " to " + iii + " of 797";
			Utility.changePageAndVerifyLandingPage(driver, "Next", testVars.pageNum, testVars, outputfile);
		}

		Utility.logger(outputfile,
				"\nSearch Scenario 9: Clear all AP search fields, then select different departments, while performing an AP search on each one. Note whether search results exist and what the record count is.");
		Utility.navigateToAPSearch(driver, testVars, outputfile);
		Utility.clearAPSearchCriteria(driver, testVars, outputfile);
		testVars.department = "37020";
		Utility.changeDepartment(driver, testVars, outputfile);
		Utility.quickAPSearch(driver, testVars, outputfile);
		Utility.verifySearchResultsLayout(driver, testVars, outputfile);
		testVars.department = "25570";
		Utility.changeDepartment(driver, testVars, outputfile);
		Utility.quickAPSearch(driver, testVars, outputfile);
		Utility.verifySearchResultsLayout(driver, testVars, outputfile);
		testVars.department = "56160";
		Utility.changeDepartment(driver, testVars, outputfile);
		Utility.quickAPSearch(driver, testVars, outputfile);
		Utility.verifySearchResultsLayout(driver, testVars, outputfile);
		testVars.department = "56170";
		Utility.changeDepartment(driver, testVars, outputfile);
		Utility.quickAPSearch(driver, testVars, outputfile);
		Utility.verifySearchResultsLayout(driver, testVars, outputfile);
		testVars.department = "56180";
		Utility.changeDepartment(driver, testVars, outputfile);
		Utility.quickAPSearch(driver, testVars, outputfile);
		Utility.verifySearchResultsLayout(driver, testVars, outputfile);
		testVars.department = "56190";
		Utility.changeDepartment(driver, testVars, outputfile);
		Utility.quickAPSearch(driver, testVars, outputfile);
		Utility.verifySearchResultsLayout(driver, testVars, outputfile);
		testVars.department = "56200";
		Utility.changeDepartment(driver, testVars, outputfile);
		Utility.quickAPSearch(driver, testVars, outputfile);
		Utility.verifySearchResultsLayout(driver, testVars, outputfile);

		Utility.logger(outputfile,
				"\nSearch Scenario 10a: Search as a non-admin user, search Purchase Order for same department.");
		String newUserName = "AmandaMarcel"; // Amanda is a coordinator for departments 57130 and 57160 as of June 2018
		String newrole = "Coordinator";
		Utility.changeLoggedInUser(driver, newUserName, newrole, outputfile);
		Utility.navigateToAPSearch(driver, testVars, outputfile);
		Utility.clearAPSearchCriteria(driver, testVars, outputfile);
		Utility.quickAPSearch(driver, testVars, outputfile);
		Utility.verifySearchResultsLayout(driver, testVars, outputfile);

		Utility.logger(outputfile,
				"\nSearch Scenario 10b: Search as a non-admin user, search Purchase Order for a department that the user doesn't have rights to.");
		testVars.department = "57130";
		Utility.changeDepartment(driver, testVars, outputfile);
		Utility.quickAPSearch(driver, testVars, outputfile);
		Utility.verifySearchResultsLayout(driver, testVars, outputfile);
		testVars.department = "56200";
		if (Utility.changeDepartment(driver, testVars, outputfile) == "") {
			Utility.quickAPSearch(driver, testVars, outputfile);
			Utility.verifySearchResultsLayout(driver, testVars, outputfile);
		} else {
			Utility.logger(outputfile, "User does not have access to department 37020. PASS.");
			++testVars.PassResult;
		}

		Utility.logger(outputfile,
				"\nSearch Scenario 11: Check field contents boundaries: long text and special characters into input text fields.");
		String longText = "abcdefghijklmnopqrstuvwxyz01234567890abcdefghijklmnopqrstuvwxyz01234567890abcdefghijklmnopqrstuvwxyz01234567890abcdefghijklmnopqrstuvwxyz01234567890abcdefghijklmnopqrstuvwxyz01234567890abcdefghijklmnopqrstuvwxyz01234567890abcdefghijklmnopqrstuvwxyz01234567890abcdefghijklmnopqrstuvwxyz01234567890";
		String specialText = "~!@#$%^&*()_+<>?,./:\";'{}[]\\|";
		// String badDate = "04/31/2018";
		Utility.navigateToAPSearch(driver, testVars, outputfile);
		Utility.clearAPSearchCriteria(driver, testVars, outputfile);
		driver.findElement(By.xpath("//input[@name='poNumber']")).sendKeys(longText);
		driver.findElement(By.xpath("//input[@name='searchBasic']")).click();
		Utility.checkEmptySearchResultsIndicators(driver, testVars, outputfile);
		Utility.clearAPSearchCriteria(driver, testVars, outputfile);
		driver.findElement(By.xpath("//input[@name='payKey']")).sendKeys(longText);
		driver.findElement(By.xpath("//input[@name='searchBasic']")).click();
		Utility.checkEmptySearchResultsIndicators(driver, testVars, outputfile);
		Utility.clearAPSearchCriteria(driver, testVars, outputfile);
		driver.findElement(By.xpath("//input[@name='invoiceNumber']")).sendKeys(longText);
		driver.findElement(By.xpath("//input[@name='searchBasic']")).click();
		Utility.checkEmptySearchResultsIndicators(driver, testVars, outputfile);
		Utility.clearAPSearchCriteria(driver, testVars, outputfile);
		driver.findElement(By.xpath("//input[@name='poNumber']")).sendKeys(specialText);
		driver.findElement(By.xpath("//input[@name='searchBasic']")).click();
		Utility.checkEmptySearchResultsIndicators(driver, testVars, outputfile);
		Utility.clearAPSearchCriteria(driver, testVars, outputfile);
		driver.findElement(By.xpath("//input[@name='payKey']")).sendKeys(specialText);
		driver.findElement(By.xpath("//input[@name='searchBasic']")).click();
		Utility.checkEmptySearchResultsIndicators(driver, testVars, outputfile);
		Utility.clearAPSearchCriteria(driver, testVars, outputfile);
		driver.findElement(By.xpath("//input[@name='invoiceNumber']")).sendKeys(specialText);
		driver.findElement(By.xpath("//input[@name='searchBasic']")).click();
		Utility.checkEmptySearchResultsIndicators(driver, testVars, outputfile);
		Utility.clearAPSearchCriteria(driver, testVars, outputfile);
		driver.findElement(By.xpath("//input[@name='referenceNumber']")).sendKeys(longText);
		Utility.advancedSearchClick(driver, testVars, outputfile);
		Utility.checkEmptySearchResultsIndicators(driver, testVars, outputfile);
		Utility.clearAPSearchCriteria(driver, testVars, outputfile);
		driver.findElement(By.xpath("//input[@name='referenceNumber']")).sendKeys(specialText);
		Utility.advancedSearchClick(driver, testVars, outputfile);
		Utility.checkEmptySearchResultsIndicators(driver, testVars, outputfile);

		Utility.logger(outputfile, "\nSearch Scenario 12: Verify date field error messages.");
		Utility.clearAPSearchCriteria(driver, testVars, outputfile);
		Utility.aPSearchPickaDate(driver, "startDate", "04/01/2018", testVars, outputfile);
		Utility.aPSearchPickaDate(driver, "endDate", "03/01/2018", testVars, outputfile);
		Utility.advancedSearchClick(driver, testVars, outputfile);
		try {
			driver.findElement(By.xpath(
					"//span[@id='endDate.errors' and normalize-space(.//text())='Start date cannot be after end date']"));
			Utility.logger(outputfile,
					"\t'Error text appears indicating that the end date is earlier than the start date. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			try {
				driver.findElement(By.xpath("//span[@id='endDate.errors']")).isEnabled();
				Utility.logger(outputfile,
						"\tThe displayed error is: "
								+ driver.findElement(By.xpath("//span[@id='endDate.errors']")).getText()
								+ " . FAIL **************************");
				++testVars.FailResult;
			} catch (Exception f) {
				Utility.logger(outputfile,
						"\t'No error text appears to indicate that the end date is earlier than the start date. FAIL *************************");
				++testVars.FailResult;
			}
		}

		Utility.clearAPSearchCriteria(driver, testVars, outputfile);
		Utility.aPSearchPickaDate(driver, "startDate", "06/02/2018", testVars, outputfile);
		Utility.aPSearchPickaDate(driver, "endDate", "06/01/2018", testVars, outputfile);
		Utility.advancedSearchClick(driver, testVars, outputfile);
		try {
			driver.findElement(By.xpath(
					"//span[@id='endDate.errors' and normalize-space(.//text())='Start date cannot be after end date']"));
			Utility.logger(outputfile,
					"\t'Error text appears indicating that the end date is earlier than the start date. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			try {
				driver.findElement(By.xpath("//span[@id='endDate.errors']")).isEnabled();
				Utility.logger(outputfile,
						"\tThe displayed error is: "
								+ driver.findElement(By.xpath("//span[@id='endDate.errors']")).getText()
								+ " . FAIL **************************");
				++testVars.FailResult;
			} catch (Exception f) {
				Utility.logger(outputfile,
						"\t'No error text appears to indicate that the end date is earlier than the start date. FAIL *************************");
				++testVars.FailResult;
			}
		}

		Utility.logger(outputfile, "\nSearch Scenario 13: Test the search results filter.");
		Utility.navigateToAPSearch(driver, testVars, outputfile);
		Utility.clearAPSearchCriteria(driver, testVars, outputfile);
		testVars.department = "57130";
		Utility.changeDepartment(driver, testVars, outputfile);
		Utility.aPSearchPickaDate(driver, "startDate", "03/01/2018", testVars, outputfile);
		Utility.aPSearchPickaDate(driver, "endDate", "03/31/2018", testVars, outputfile);
		Utility.quickAPSearch(driver, testVars, outputfile);

		try {
			String resultsText = driver.findElement(By.xpath("//*[@id='dataTable']/tbody/tr[3]/td[9]")).getText(); // shows
																													// the
																													// vendor
																													// in
																													// the
																													// first
																													// record
																													// of
																													// the
																													// results
			Utility.logger(outputfile, "\tRecordCount before filtering is: "
					+ driver.findElement(By.xpath("//*[@id='dataTable_info']")).getText());
			driver.findElement(By.xpath("//*[@id='dataTable_filter']/label/input")).sendKeys("econ"); // enter letters
																										// into the
																										// search
																										// results
																										// filter
			Utility.logger(outputfile, "\t'Entering 'econ' into the search results filter.");
			if (!(driver.findElement(By.xpath("//*[@id='dataTable']/tbody/tr[1]/td[9]")).getText()
					.matches(resultsText))) { // compare the new contents of the vendor field in the first record
				Utility.logger(outputfile, "\tRecordCount after filtering is: "
						+ driver.findElement(By.xpath("//*[@id='dataTable_info']")).getText());
				Utility.logger(outputfile, "\t'Search results filter is working. Pass.");
				++testVars.PassResult;
			} else {
				Utility.logger(outputfile, "\tSearch results filter did not work as expected. FAIL -----------------");
				++testVars.FailResult;
			}
		} catch (Exception e) {

		}

		driver.close();

		Utility.logger(outputfile, "End of AP Search tests.");
		Utility.logTestStats(outputfile, testVars);
		outputfile.close();

	} // End of Main

	public static void verifyAPSearchPageElements(WebDriver driver, testingVars testVars, PrintWriter outputfile) {

		try { // Page title
			driver.findElement(
					By.xpath("//div[@class='section-title' and normalize-space(.//text())='Ap Input Search']"));
			Utility.logger(outputfile, "\t'AP Input Search' is the page title on the AP Search page. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile,
					"\t'AP Input Search' is NOT the page title on the AP Search page. FAIL *************************");
			++testVars.FailResult;
		}

		try { // Basic Search section title
			driver.findElement(
					By.xpath("//legend[@class='section-subtitle2' and normalize-space(text())='Basic Search']"));
			Utility.logger(outputfile, "\t'Basic Search' is a section title on the AP Search page. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile,
					"\t'Basic Search' is NOT a section title on the AP Search page. FAIL *************************");
			++testVars.FailResult;
		}

		try { // Purchase Order Number text entry field label exists
			driver.findElement(By.xpath(
					"//*[@id='voucherSearch']/fieldset[1]/table/tbody/tr/td[1 and normalize-space(text())='Purchase Order Number:']"));
			Utility.logger(outputfile, "\tPurchase Order Number input field label exists. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile,
					"\tPurchase Order Number input field label does NOT exist.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Purchase Order Number text entry field exists
			driver.findElement(By.xpath("//input[@name='poNumber']")).isEnabled();
			Utility.logger(outputfile, "\tPurchase Order Number input field is enabled. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile,
					"\tPurchase Order Number input field is NOT enabled.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Paykey text entry field label exists
			driver.findElement(By.xpath(
					"//*[@id='voucherSearch']/fieldset[1]/table/tbody/tr/td[3 and normalize-space(text())='Paykey:']"));
			Utility.logger(outputfile, "\tPaykey input field label exists. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile, "\tPaykey input field label does NOT exist.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Paykey text entry field exists
			driver.findElement(By.xpath("//input[@name='payKey']")).isEnabled();
			Utility.logger(outputfile, "\tPayKey input field is enabled. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile, "\tPayKey input field is NOT enabled.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Invoice Number text entry field label exists
			driver.findElement(By.xpath(
					"//*[@id='voucherSearch']/fieldset[1]/table/tbody/tr/td[5 and normalize-space(text())='Invoice Number:']"));
			Utility.logger(outputfile, "\tInvoice Number input field label exists. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile,
					"\tInvoice Number input field label does NOT exist.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Invoice Number text entry field exists
			driver.findElement(By.xpath("//input[@name='invoiceNumber']")).isEnabled();
			Utility.logger(outputfile, "\tInvoice Number input field is enabled. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile, "\tInvoice Number input field is NOT enabled.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Basic Search button exists
			driver.findElement(By.xpath("//input[@name='searchBasic']")).isEnabled();
			Utility.logger(outputfile, "\tBasic Search button is enabled. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile,
					"\tBasic Search button input field is NOT enabled.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // 'Advanced Search' section title exists
			driver.findElement(
					By.xpath("//legend[@class='section-subtitle2' and normalize-space(text())='Advanced Search']"));
			Utility.logger(outputfile, "\t'Advanced Search' is a section title on the AP Search page. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile,
					"\t'Advanced Search' is NOT a section title on the AP Search page. FAIL ************************n");
			++testVars.FailResult;
		}

		try { // Purchase Type text entry field label exists
			driver.findElement(By.xpath(
					"//*[@id='voucherSearch']/fieldset[2]/table/tbody/tr[1]/td[1 and normalize-space(text())='Purchase Type:']"));
			Utility.logger(outputfile, "\tPurchase Type input field label exists. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile,
					"\tPurchase Type input field label does NOT exist.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Purchase Type dropdown exists
			driver.findElement(By.xpath("//select[@name='entryType']")).isEnabled();
			Utility.logger(outputfile, "\tPurchase Type dropdown is enabled. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile, "\tPurchase Type dropdown is NOT enabled.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Reference Number text entry field label exists
			driver.findElement(By.xpath(
					"//*[@id='voucherSearch']/fieldset[2]/table/tbody/tr[2]/td[1 and normalize-space(text())='Reference Number:']"));
			Utility.logger(outputfile, "\tReference Number input field label exists. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile,
					"\tReference Number input field label does NOT exist.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Reference Number text entry field exists
			driver.findElement(By.xpath("//input[@name='referenceNumber']")).isEnabled();
			Utility.logger(outputfile, "\tReference Number text entry field is enabled. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile,
					"\tReference Number text entry field is NOT enabled.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Status text entry field label exists
			driver.findElement(By.xpath(
					"//*[@id='voucherSearch']/fieldset[2]/table/tbody/tr[3]/td[1 and normalize-space(text())='Status:']"));
			Utility.logger(outputfile, "\tStatus input field label exists. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile, "\tStatus input field label does NOT exist.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Status dropdown exists
			driver.findElement(By.xpath("//select[@name='status']")).isEnabled();
			Utility.logger(outputfile, "\tStatus dropdown field is enabled. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile, "\tStatus dropdown field is NOT enabled.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Location text entry field label exists
			driver.findElement(By.xpath(
					"//*[@id='voucherSearch']/fieldset[2]/table/tbody/tr[4]/td[1 and normalize-space(text())='Location:']"));
			Utility.logger(outputfile, "\tLocation input field label exists. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile, "\tLocation input field label does NOT exist.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Location dropdown exists
			driver.findElement(By.xpath("//select[@name='locationCode']")).isEnabled();
			Utility.logger(outputfile, "\tLocation dropdown field is enabled. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile, "\tLocation dropdown field is NOT enabled.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Vendor text entry field label exists
			driver.findElement(By.xpath(
					"//*[@id='voucherSearch']/fieldset[2]/table/tbody/tr[5]/td[1 and normalize-space(text())='Vendor:']"));
			Utility.logger(outputfile, "\tVendor input field label exists. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile, "\tVendor input field label does NOT exist.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Vendor dropdown exists
			driver.findElement(By.xpath("//select[@name='vendor']")).isEnabled();
			Utility.logger(outputfile, "\tVendor dropdown field is enabled. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile, "\tVendor dropdown field is NOT enabled.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Date Type radio button row label exists
			driver.findElement(By.xpath(
					"//*[@id='voucherSearch']/fieldset[2]/table/tbody/tr[6]/td[1 and normalize-space(text())='Date Type:']"));
			Utility.logger(outputfile, "\tDate Type input field label exists. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile, "\tDate Type input field label does NOT exist.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Purchase Date radio button label exists
			driver.findElement(By.xpath(
					"//*[@id='voucherSearch']/fieldset[2]/table/tbody/tr[6]/td[2]/span[1 and normalize-space(.//text())='Purchase Date']"));
			Utility.logger(outputfile, "\tPurchase Date input field label exists. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile,
					"\tPurchase Date input field label does NOT exist.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Purchase Date radio button exists
			driver.findElement(By.xpath("//input[@id='apEntryDateType1']")).isEnabled();
			Utility.logger(outputfile, "\tPurchase Date radio button is enabled. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile, "\tPurchase Date radio button is NOT enabled.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Invoice Date radio button label exists
			driver.findElement(By.xpath(
					"//*[@id='voucherSearch']/fieldset[2]/table/tbody/tr[6]/td[2]/span[2 and normalize-space(.//text())='Invoice Date']"));
			Utility.logger(outputfile, "\tInvoice Date input field label exists. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile,
					"\tInvoice Date input field label does NOT exist.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Invoice Date radio button exists
			driver.findElement(By.xpath("//input[@id='apEntryDateType2']")).isEnabled();
			Utility.logger(outputfile, "\tInvoice Date radio button is enabled. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile, "\tInvoice Date radio button is NOT enabled.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Entered Date radio button label exists
			driver.findElement(By.xpath(
					"//*[@id='voucherSearch']/fieldset[2]/table/tbody/tr[6]/td[2]/span[3 and normalize-space(.//text())='Entered Date']"));
			Utility.logger(outputfile, "\tEntered Date input field label exists. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile,
					"\tEntered Date input field label does NOT exist.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Entered Date radio button exists
			driver.findElement(By.xpath("//input[@id='apEntryDateType3']")).isEnabled();
			Utility.logger(outputfile, "\tEntered Date radio button is enabled. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile, "\tEntered Date radio button is NOT enabled.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Start Date field label exists
			driver.findElement(By.xpath(
					"//*[@id='voucherSearch']/fieldset[2]/table/tbody/tr[7]/td[1 and normalize-space(text())='Start Date:']"));
			Utility.logger(outputfile, "\tStart Date input field label exists. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile,
					"\tStart Date input field label does NOT exist.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // Start Date entry field exists
			driver.findElement(By.xpath("//input[@name='startDate']")).isEnabled();
			Utility.logger(outputfile, "\tStart Date entry field is enabled. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile, "\tStart Date entry field is NOT enabled.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // End Date field label exists
			driver.findElement(By.xpath(
					"//*[@id='voucherSearch']/fieldset[2]/table/tbody/tr[7]/td[3 and normalize-space(text())='End Date:']"));
			Utility.logger(outputfile, "\tEnd Date input field label exists. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile, "\tEnd Date input field label does NOT exist.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // End Date entry field exists
			driver.findElement(By.xpath("//input[@name='endDate']")).isEnabled();
			Utility.logger(outputfile, "\tEnd Date entry field is enabled. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile, "\tEnd Date entry field is NOT enabled.  FAIL *************************");
			++testVars.FailResult;
		}
		try { // Search button exists
			driver.findElement(By.xpath("//input[@name='searchAdvanced']")).isEnabled();
			Utility.logger(outputfile, "\tSearch button is enabled. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile, "\tSearch button is NOT enabled.  FAIL *************************");
			++testVars.FailResult;
		}
		try { // Clear Button exists
			driver.findElement(By.xpath("//input[@value='Clear']")).isEnabled();
			Utility.logger(outputfile, "\tClear Button is enabled. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile, "\tClear Button is NOT enabled.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // 'Search Results' section title exists
			driver.findElement(
					By.xpath("//legend[@class='section-subtitle2' and normalize-space(text())='Search Results']"));
			Utility.logger(outputfile, "\t'Search Results' is a section title on the AP Search page. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile,
					"\t'Search Results' is NOT a section title on the AP Search page. FAIL ************************n");
			++testVars.FailResult;
		} // *[@id="dataTable_filter"]/label

		try { // 'Number of displayed results' dropdown exists
			driver.findElement(By.xpath("//select[@name='dataTable_length']")).isEnabled();
			Utility.logger(outputfile, "\t'Number of displayed results' dropdown field is enabled. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile,
					"\t'Number of displayed results' dropdown field is NOT enabled.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // 'Search' results filter label exists
			driver.findElement(By.xpath("//*[@id='dataTable_filter' and normalize-space(.//text())='Search:']"));
			Utility.logger(outputfile, "\tSearch filter field label exists. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile,
					"\tSearch filter input field label does NOT exist.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // 'Search' results filter field exists
			driver.findElement(By.xpath("//*[@id='dataTable_filter']/label/input")).isEnabled();
			Utility.logger(outputfile, "\t'Search' results filter field is enabled. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile,
					"\t'Search' results filter field is NOT enabled.  FAIL *************************");
			++testVars.FailResult;
		}

		try { // 'empty results table' exists
			driver.findElement(By.xpath("//td[@class='dataTables_empty']")).isEnabled();
			Utility.logger(outputfile, "\tEmpty results table is displayed. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile, "\tEmpty results table is NOT displayed.  FAIL *************************");
			++testVars.FailResult;
		}

	}

	public static void aPSearchResultsColumnTitlesTests(WebDriver driver, String pType, testingVars testVars,
			PrintWriter logfile) {

		if (pType == "") {
			Utility.logger(logfile, "\tPurchase Type is 'All'");
			String colName = "id";
			String colNum = "1";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Location";
			colNum = "2";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Paykey";
			colNum = "3";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "PO#";
			colNum = "4";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "BO#";
			colNum = "5";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Reference#";
			colNum = "6";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Type";
			colNum = "7";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Purchase Date";
			colNum = "8";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Vendor";
			colNum = "9";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Purchaser";
			colNum = "10";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "PO/Invoice Amt";
			colNum = "11";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Non Coded Amt";
			colNum = "12";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Status";
			colNum = "13";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Invoice#";
			colNum = "14";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "InvoiceDate";
			colNum = "15";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Check#";
			colNum = "16";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "CheckDate";
			colNum = "17";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);
		}

		if (pType == "Expense Report") {
			Utility.logger(logfile, "\tPurchase Type is 'Expense Report'");
			String colName = "id";
			String colNum = "1";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Paykey";
			colNum = "2";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "PO#";
			colNum = "3";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Purchase Date";
			colNum = "4";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Vendor";
			colNum = "5";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Purchaser";
			colNum = "6";// Purchaser
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "PO/Invoice Amt";
			colNum = "7";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Status";
			colNum = "9";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

		}

		if (pType == "Purchase Order") {
			Utility.logger(logfile, "\tPurchase Type is 'Purchase Order'");
			String colName = "id";
			String colNum = "1";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Location";
			colNum = "2";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Paykey";
			colNum = "3";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "PO#";
			colNum = "4";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Purchase Date";
			colNum = "5";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Vendor";
			colNum = "6";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Purchaser";
			colNum = "7";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Status";
			colNum = "8";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

		}

		if (pType == "e-Voucher") {
			Utility.logger(logfile, "\tPurchase Type is 'e-Voucher'");
			String colName = "id";
			String colNum = "1";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Paykey";
			colNum = "2";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "PO#";
			colNum = "3";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "BO#";
			colNum = "4";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Reference#";
			colNum = "5";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Type";
			colNum = "6";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Purchase Date";
			colNum = "7";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Vendor";
			colNum = "8";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Purchaser";
			colNum = "9";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "PO/Invoice Amt";
			colNum = "10";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Non Coded Amt";
			colNum = "11";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Status";
			colNum = "12";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Invoice#";
			colNum = "13";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "InvoiceDate";
			colNum = "14";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Check#";
			colNum = "15";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "CheckDate";
			colNum = "16";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

		}

		if (pType == "Purchase Card") {
			Utility.logger(logfile, "\tPurchase Type is 'Purchase Card'");
			String colName = "id";
			String colNum = "1";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Paykey";
			colNum = "2";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "PO#";
			colNum = "3";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "BO#";
			colNum = "4";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Reference#";
			colNum = "5";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Type";
			colNum = "6";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Purchase Date";
			colNum = "7";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Vendor";
			colNum = "8";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Purchaser";
			colNum = "9";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "PO/Invoice Amt";
			colNum = "10";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Non Coded Amt";
			colNum = "11";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Status";
			colNum = "12";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Invoice#";
			colNum = "13";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "InvoiceDate";
			colNum = "14";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "Check#";
			colNum = "15";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);

			colName = "CheckDate";
			colNum = "16";
			checkSearchResultsColumnNames(driver, colNum, colName, testVars, logfile);
		}

	}

	public static void checkSearchResultsColumnNames(WebDriver driver, String colNum, String colName,
			testingVars testVars, PrintWriter logfile) {
		try {
			driver.findElement(By.xpath("//*[@id=\"dataTable\"]/thead/tr/th[" + colNum
					+ " and normalize-space(text())='" + colName + "']"));
			Utility.logger(logfile,
					"\tColumn number " + colNum + " of the AP Search results table is titled '" + colName + "'. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(logfile, "\tColumn number " + colNum + " of the AP Search results table is NOT titled '"
					+ colName + "'. FAIL *************************");
			++testVars.FailResult;
		}

	}

	public static void basicSearchTests(WebDriver driver, testingVars testVars, PrintWriter outputfile) {

		// In Basic Search, search by Purchase Order Number
		Utility.navigateToAPSearch(driver, testVars, outputfile);
		driver.findElement(By.xpath("//input[@name='poNumber']")).sendKeys("E302A");
		driver.findElement(By.xpath("//input[@name='searchBasic']")).click();
		Utility.logger(outputfile, "\tSearching by Purchase Order Number input field.");

		try { // Purchase Order Search Results - PO Number and Description text
			driver.findElement(By.xpath("//td[@class='form-right-col2' and normalize-space(text())='E302A']"));
			driver.findElement(
					By.xpath("//*[@id='lineItem_4013771']/td[7 and normalize-space(text())='Flame Screen']"));
			Utility.logger(outputfile, "\tFound 'Flame Screen' Purchase Order using 'Basic Search'. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile,
					"\t'Basic Search' is NOT a section title on the AP Search page. FAIL *************************");
			++testVars.FailResult;
		}

		// In Basic Search, search by Paykey
		Utility.navigateToAPSearch(driver, testVars, outputfile);
		driver.findElement(By.xpath("//input[@name='payKey']")).sendKeys("D335EMV");
		driver.findElement(By.xpath("//input[@name='searchBasic']")).click();
		Utility.logger(outputfile, "\tSearching by Paykey input field.");

		try { // Purchase Order Search Results - PO Number and Description text
			driver.findElement(By.xpath("//td[@class='form-right-col2' and normalize-space(text())='E302A']"));
			driver.findElement(
					By.xpath("//*[@id='lineItem_4013771']/td[7 and normalize-space(text())='Flame Screen']"));
			Utility.logger(outputfile, "\tFound 'Flame Screen' Purchase Order using 'Basic Search'. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile,
					"\t'Basic Search' is NOT a section title on the AP Search page. FAIL *************************");
			++testVars.FailResult;
		}

		// In Basic Search, search by Invoice Number
		Utility.navigateToAPSearch(driver, testVars, outputfile);
		driver.findElement(By.xpath("//input[@name='invoiceNumber']")).sendKeys("065847");
		driver.findElement(By.xpath("//input[@name='searchBasic']")).click();
		Utility.logger(outputfile, "\tSearching by Invoice Number input field.");

		try { // Purchase Order Search Results - PO Number and Description text
			driver.findElement(By.xpath("//td[@class='form-right-col2' and normalize-space(text())='E302A']"));
			driver.findElement(
					By.xpath("//*[@id='lineItem_4013771']/td[7 and normalize-space(text())='Flame Screen']"));
			Utility.logger(outputfile, "\tFound 'Flame Screen' Purchase Order using 'Basic Search'. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(outputfile,
					"\t'Basic Search' is NOT a section title on the AP Search page. FAIL *************************");
			++testVars.FailResult;
		}

		// Search on Expense Report and 4/2/2018, filter by Johnny, and verify that the
		// PO doesn't appear.
		// search on Purchase Order and 4/2/2018, filter by Johnny, and verify that the
		// PO appears.
		// search by closed, 4/2, PO type, Location = MV, verify that the PO appears.
		// search by closed, 4/2, PO type, Location <> MV, filter by Johnny, and verify
		// that the PO doesn't appear.
		// search by vendor, PO type, date 4/1 - 4/30, filter by Johnny, verify that PO
		// appears.

	}

	public static void advancedSearchOneCriteriaTests(WebDriver driver, testingVars testVars, PrintWriter outputfile) {

		// In Advanced Search, search without setting filter selections
		Utility.logger(outputfile,
				"\tEnter Search page, don't change default criteria, and click Advanced Search button.");
		Utility.navigateToAPSearch(driver, testVars, outputfile);
		setFieldsToGenericSearch(driver, testVars, outputfile);
		Utility.advancedSearchClick(driver, testVars, outputfile); // click Search button and check for non-empty
																	// results

		// In Advanced Search, search by Purchase Order Type
		Utility.logger(outputfile,
				"\tEnter Search page, clear criteria, select Purchase Order, and click Advanced Search button.");
		Utility.navigateToAPSearch(driver, testVars, outputfile);
		setFieldsToGenericSearch(driver, testVars, outputfile);
		String dropdown = "entryType";
		String selectvalue = "PurchaseOrder"; // selecting 'Purchase Order' type.
		Utility.setAPSearchDropdown(driver, dropdown, selectvalue, -1, testVars, outputfile);
		Utility.advancedSearchClick(driver, testVars, outputfile);
		// Check that Search results have 'Purchase Order' in the first row.

		// In Advanced Search, search by Location = "MV"
		Utility.logger(outputfile,
				"\tEnter Search page, clear criteria, select 'MV' location, and click Advanced Search button.");
		Utility.navigateToAPSearch(driver, testVars, outputfile);
		setFieldsToGenericSearch(driver, testVars, outputfile);
		dropdown = "location";
		selectvalue = "MV";
		Utility.setAPSearchDropdown(driver, dropdown, selectvalue, -1, testVars, outputfile);
		Utility.advancedSearchClick(driver, testVars, outputfile);
		// Check that Search results have Location = MV in the first row.

		// In Advanced Search, search by Vendor = "ROUSE ENTERPRISES, LLC - 1024294 -
		// SAV-001"
		Utility.logger(outputfile,
				"\tEnter Search page, clear criteria, select 'Rouse Enterprises' vendor, and click Advanced Search button.");
		Utility.navigateToAPSearch(driver, testVars, outputfile);
		setFieldsToGenericSearch(driver, testVars, outputfile);
		dropdown = "vendor";
		selectvalue = "98824";
		Utility.setAPSearchDropdown(driver, dropdown, selectvalue, -1, testVars, outputfile);
		Utility.advancedSearchClick(driver, testVars, outputfile);
		// Check that Search results have Vendor = 'Rouse Enterprises' in the first row.
	}

	public static void setFieldsToGenericSearch(WebDriver driver, testingVars testVars, PrintWriter logfile) {

		String selectvalue = "";
		String dropdown = "entryType";
		Utility.setAPSearchDropdown(driver, dropdown, selectvalue, 0, testVars, logfile);

		selectvalue = "";
		String textField = "referenceNumber";
		Utility.setAPSearchTextInputField(driver, textField, selectvalue, testVars, logfile);

		selectvalue = "";
		dropdown = "status";
		Utility.setAPSearchDropdown(driver, dropdown, selectvalue, 0, testVars, logfile);

		selectvalue = "";
		dropdown = "location";
		Utility.setAPSearchDropdown(driver, dropdown, selectvalue, 0, testVars, logfile);

		selectvalue = "";
		dropdown = "vendor";
		Utility.setAPSearchDropdown(driver, dropdown, selectvalue, 0, testVars, logfile);

		selectvalue = "EnteredDate";
		String radioButton = "apEntryDateType3";
		Utility.setAPSearchRadioButton(driver, radioButton, selectvalue, testVars, logfile);

		driver.findElement(By.xpath("//input[@name='startDate']")).click();
		driver.findElement(By.xpath("//input[@id='endDate']")).click();
		driver.findElement(By.xpath("//input[@name='startDate']")).click();
		driver.findElement(By.xpath("//input[@id='endDate']")).click();
	}

	public static void searchByStatusTests(WebDriver driver, testingVars testVars, PrintWriter outputfile) {

		// In Advanced Search, search by Status = New
		Utility.logger(outputfile,
				"\tEnter Search page, clear criteria, select 'New' status, and click Advanced Search button.");
		Utility.navigateToAPSearch(driver, testVars, outputfile);
		setFieldsToGenericSearch(driver, testVars, outputfile);
		String dropdown = "status";
		String selectvalue = "New";
		Utility.setAPSearchDropdown(driver, dropdown, selectvalue, -1, testVars, outputfile);
		Utility.advancedSearchClick(driver, testVars, outputfile);
		Utility.checkStatusInSearchResults(driver, selectvalue, testVars, outputfile);

		// In Advanced Search, search by Status = Open
		Utility.logger(outputfile,
				"\tEnter Search page, clear criteria, select 'OPEN' status, and click Advanced Search button.");
		dropdown = "status";
		selectvalue = "Open";
		Utility.setAPSearchDropdown(driver, dropdown, selectvalue, -1, testVars, outputfile);
		Utility.advancedSearchClick(driver, testVars, outputfile);
		Utility.checkStatusInSearchResults(driver, selectvalue, testVars, outputfile);

		// In Advanced Search, search by Status = Pending Approval
		Utility.logger(outputfile,
				"\tEnter Search page, clear criteria, select 'PENDING APPROVAL' status, and click Advanced Search button.");
		dropdown = "status";
		selectvalue = "PendingApproval";
		Utility.setAPSearchDropdown(driver, dropdown, selectvalue, -1, testVars, outputfile);
		Utility.advancedSearchClick(driver, testVars, outputfile);
		Utility.checkStatusInSearchResults(driver, selectvalue, testVars, outputfile);

		// In Advanced Search, search by Status = Closed
		Utility.logger(outputfile,
				"\tEnter Search page, clear criteria, select 'CLOSED' status, set dates to April 2018, and click Advanced Search button.");
		driver.findElement(By.xpath("//input[@value='Clear']")).click();
		dropdown = "status";
		selectvalue = "Closed";
		Utility.setAPSearchDropdown(driver, dropdown, selectvalue, -1, testVars, outputfile);
		// Set start and end date fields to 4/1/2018 and 4/30/2018. Needs to be
		// refactored, it's hard-coded now.
		Utility.aPSearchPickaDate(driver, "startDate", "04/01/2018", testVars, outputfile);
		Utility.aPSearchPickaDate(driver, "endDate", "04/30/2018", testVars, outputfile);
		// APSearchDatePicker(driver, outputfile);
		Utility.advancedSearchClick(driver, testVars, outputfile);
		Utility.checkStatusInSearchResults(driver, selectvalue, testVars, outputfile);

		// In Advanced Search, search by Status = Void
		Utility.logger(outputfile,
				"\tEnter Search page, clear criteria, select 'VOID' status, dates are set to April 2018, and click Advanced Search button.");
		dropdown = "status";
		selectvalue = "Void";
		Utility.setAPSearchDropdown(driver, dropdown, selectvalue, -1, testVars, outputfile);
		// UseDatePicker(driver, outputfile);
		Utility.advancedSearchClick(driver, testVars, outputfile);
		Utility.checkStatusInSearchResults(driver, selectvalue, testVars, outputfile);
	}

	public static void generalAPSearch(WebDriver driver, testingVars testVars, PrintWriter logfile) {

		if (testVars.department != "") {
			Utility.changeDepartment(driver, testVars, logfile);
		}
		Utility.navigateToAPSearch(driver, testVars, logfile);
		if (testVars.pType != "") {
			Utility.setAPSearchDropdown(driver, "entryType", testVars.pType, -1, testVars, logfile);
		} else {
			Utility.setAPSearchDropdown(driver, "entryType", testVars.pType, 0, testVars, logfile);
		}
		if (testVars.referenceNum != "") {
			Utility.setAPSearchTextInputField(driver, "referenceNumber", testVars.referenceNum, testVars, logfile);
		}
		if (testVars.status != "") {
			Utility.setAPSearchDropdown(driver, "status", testVars.status, -1, testVars, logfile);
		} else {
			Utility.setAPSearchDropdown(driver, "status", "", 0, testVars, logfile);
		}
		if (testVars.loc != "") {
			Utility.setAPSearchDropdown(driver, "location", testVars.loc, -1, testVars, logfile);
		} else {
			Utility.setAPSearchDropdown(driver, "location", testVars.loc, 0, testVars, logfile);
		}
		if (testVars.ven != "") {
			Utility.setAPSearchDropdown(driver, "vendor", testVars.ven, -1, testVars, logfile);
		} else {
			Utility.setAPSearchDropdown(driver, "vendor", testVars.ven, 0, testVars, logfile);
		}
		if (testVars.startdate != "") {
			Utility.aPSearchPickaDate(driver, "startDate", testVars.startdate, testVars, logfile);
		}
		if (testVars.enddate != "") {
			Utility.aPSearchPickaDate(driver, "endDate", testVars.enddate, testVars, logfile);
		}
		Utility.changeDateType(driver, testVars.dateType, testVars, logfile);

		Utility.advancedSearchClick(driver, testVars, logfile);
	}

	public static void openFirstRecord_VerifyPurchaseType(WebDriver driver, String landingPage, testingVars testVars,
			PrintWriter logfile) {

		try {
			driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[1]/td[1]/a")).click();
		} catch (Exception e) {
			Utility.logger(logfile, "\tCould not click on first record in results. FAIL *************************\n");
			++testVars.FailResult;
		}

		try { // Page title
			driver.findElement(
					By.xpath("//div[@id='main-content']/section/div[2]/div[1 and normalize-space(.//text())='"
							+ landingPage + "']"));
			Utility.logger(logfile, "\tThe '" + landingPage + "' page was opened on a click on a search result. PASS");
			++testVars.PassResult;
		} catch (Exception e) {
			Utility.logger(logfile, "\tThe '" + landingPage
					+ "' page was NOT opened on a click on a search result. FAIL *************************");
			++testVars.FailResult;
		}

	}

}
