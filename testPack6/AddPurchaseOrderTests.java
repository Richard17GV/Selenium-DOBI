package testPack6;

import java.io.PrintWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AddPurchaseOrderTests {

	public static void main(String[] args) {

		testingVars testVars = new testingVars();
		Utility.varInit(testVars);
		testVars.logTitle = "AddEditPurchaseOrdersPage_";

		PrintWriter logfile = Utility.initializeLogFile(testVars);
		
		boolean headlessFlag = false;  // change to true to run headless.
		WebDriver driver = Utility.initializeDOBIWebPage(headlessFlag);

		Utility.logger(logfile, "\nDOBI Test: Verify 'Add Purchase Order' as an Admin user.");

		Utility.loginToDOBI(driver, logfile, testVars);

		/*
		 * //--- SANDBOX ---//
		 * 
		 * 
		 * Utility.verifyPresenceOfAPSearchFields( driver, testVars, logfile);
		 * Utility.logger(logfile, "\nVerified AP Search page using factory."); double
		 * myProduct = Double.parseDouble("549.100") * Double.parseDouble("1");
		 * System.out.println("myProduct is: " + String.valueOf(myProduct));
		 * 
		 * driver.close(); System.exit(0);
		 * 
		 * //--- SANDBOX ---//
		 */
		Utility.changeDepartment(driver, testVars, logfile);
		Boolean skipTest = false;
		String newPONumber = "";
		String switchOff = "no dev";
		if (!(switchOff.equals("dev"))) {
			// Skip from here to the code being developed. (switchOff is 'dev')
			// --------------------------------------------------------------------------------------------------------------
			// (switchOff is 'dev')----------------------

			// Test Scenario 1: Navigate to Add/Edit Purchase Order page and verify page
			// contents.
			Utility.logger(logfile,
					"\nTest Scenario 1: Navigate to Add/Edit Purchase Order page and verify page contents and chained field behavior.");
			Utility.navigateToAddEditPurchaseOrder(driver, testVars, logfile);
			testVars.landingPage = "Add/Edit Purchase Order";
			Utility.verifyLandingPage(driver, testVars, logfile);

			verifyExistenceOfAddPOInputFields(driver, testVars, logfile);
			verifyExistenceOfAddPOInputFieldLabels(driver, testVars, logfile);
			verifyExistenceOfAddPOButtonsAndLinks(driver, testVars, logfile);
			verifyDisabledLineItemFields(driver, testVars, logfile);

			// Test Scenario 2: verify field existence on the Add/Edit PO page.
			Utility.logger(logfile,
					"\nAddPO Test Scenario 2: Verify required fields on save of an empty new Purchase Order.");
			verifyAddEditPORequiredFields(driver, testVars, logfile);

			// Test Scenario 3.1: void line items in a new PO
			Utility.logger(logfile,
					"\nAddPO Test Scenario 3.1: Enter data that matches a PO in department 57130, save it, and then void the line items.");
			testVars.department = "57130";
			Utility.setDepartment(DOBI_Fields.globalDepartmentDropdown(), driver, testVars, logfile);
			Utility.navigateToAddEditPurchaseOrder(driver, testVars, logfile);
			newPONumber = Utility.getNewPurchaseOrderNumber(driver, testVars, logfile);
			Utility.logger(logfile, "\tNew Purchase Order Number is " + newPONumber);
			FieldSetter.textField(AddEditPOFields.referenceNumberTextInput(), Identifiers.makeUniqueID(), driver);
			FieldSetter.dropdown(AddEditPOFields.vendorDropdown(driver), "98831", -1, driver, logfile); // Sea Safety &
																										// Survival -
																										// 1024301 -
																										// SAV-001
			SetADate.useDatePicker(driver, AddEditPOFields.purchaseOrderDate(), AddEditPOFields.pODateMonthPicker(),
					AddEditPOFields.pODateMonthDisplay(), AddEditPOFields.pODateYearDisplay(),
					SetADate.getCurrentDate(), testVars, logfile);
			FieldSetter.dropdown(AddEditPOFields.purchaserDropdown(driver), "51057", -1, driver, logfile); // Foret,
																											// Edward
			// FieldSetter.dropdown(AddEditPOFields.shipViaDropdown(driver), "", -1, driver,
			// logfile); //none
			FieldSetter.dropdown(AddEditPOFields.lineItem_DepartmentNumber(driver), "57130", -1, driver, logfile); // 57130
			FieldSetter.dropdown(AddEditPOFields.lineItem_Account(driver), "6110030", -1, driver, logfile); // 6110030
			FieldSetter.dropdown(AddEditPOFields.lineItem_LineOfService(driver), "9", -1, driver, logfile); // 1800

			FieldSetter.dropdown(AddEditPOFields.lineItem_Project(driver), "5628", -1, driver, logfile); // 5713000041
			FieldSetter.dropdown(AddEditPOFields.lineItem_Equipment(driver), "25562", -1, driver, logfile); // Founder
			FieldSetter.textField(AddEditPOFields.lineItem_PartNumber(), "", driver); // none
			FieldSetter.textField(AddEditPOFields.lineItem_Description(), "Supplies", driver); // Supplies
			FieldSetter.textField(AddEditPOFields.lineItem_Quantity(), "3", driver); // 549.10
			FieldSetter.textField(AddEditPOFields.lineItem_UnitCost(), "549.10", driver); // 549.10
			FieldSetter.buttonClick(AddEditPOFields.lineItemButton(), driver);
			Utility.waitABit(10);

			// Add a second line item row.
			FieldSetter.dropdown(AddEditPOFields.lineItem_DepartmentNumber(driver), "57130", -1, driver, logfile); // 57130
			FieldSetter.dropdown(AddEditPOFields.lineItem_Account(driver), "6110030", -1, driver, logfile); // 6110030
			FieldSetter.dropdown(AddEditPOFields.lineItem_LineOfService(driver), "9", -1, driver, logfile); // 1800
			FieldSetter.dropdown(AddEditPOFields.lineItem_Project(driver), "5628", -1, driver, logfile); // 5713000041
			FieldSetter.dropdown(AddEditPOFields.lineItem_Equipment(driver), "25562", -1, driver, logfile); // Founder
			FieldSetter.textField(AddEditPOFields.lineItem_PartNumber(), "", driver); // none
			FieldSetter.textField(AddEditPOFields.lineItem_Description(), "Supplies", driver); // Supplies
			FieldSetter.textField(AddEditPOFields.lineItem_Quantity(), "5", driver); // 1
			FieldSetter.textField(AddEditPOFields.lineItem_UnitCost(), "732.10", driver); // 549.10
			FieldSetter.buttonClick(AddEditPOFields.lineItemButton(), driver);
			Utility.waitABit(10);
			addAttachmentToNewPO(driver, testVars, logfile);
			associateAttachmentWithLineItem(driver, testVars, logfile);

			Utility.logger(logfile, "\tObserve the decrease in the PO Total value as each line item is voided.");
			Double preVoidTotal = Utility.getPOTotalValue(driver, testVars, logfile);

			Utility.logger(logfile, "\tVoid the second line item and verify that it was voided.");
			String calcExtCostPreVoid = driver
					.findElement(By.xpath(AddEditPOFields.line2CalcExtCostValue().getTheXpath())).getText();
			try {
				driver.findElement(By.xpath(AddEditPOFields.line2_VoidLink().getTheXpath())).click();
				Utility.acceptAlert(driver, testVars, logfile);
				Utility.waitABit(10);
			} catch (Exception e) {
			}
			String calcExtCostPostVoid = driver
					.findElement(By.xpath(AddEditPOFields.line2CalcExtCostValue().getTheXpath())).getText();
			String voidPostText = driver.findElement(By.xpath(AddEditPOFields.line2_VoidState().getTheXpath()))
					.getText();
			if (calcExtCostPreVoid.equals(calcExtCostPostVoid) && voidPostText.equals("Voided")) {
				Utility.logger(logfile, "\t\tThe selected line item was voided as expected. PASS");
				++testVars.PassResult;
			} else {
				Utility.logger(logfile, "\t\tThe selected line item was NOT voided as expected. FAIL");
				++testVars.FailResult;
			}

			Double firstVoidTotal = Utility.getPOTotalValue(driver, testVars, logfile);
			if (preVoidTotal - firstVoidTotal > 0) {
				Utility.logger(logfile, "\t\tThe Purchase Order Total decreased as expected. PASS");
				++testVars.PassResult;
			} else {
				Utility.logger(logfile, "\t\tThe Purchase Order Total DID NOT decrease as expected. FAIL");
				++testVars.FailResult;
			}

			Utility.logger(logfile, "\tVoid the first line item and verify that it was voided.");
			calcExtCostPreVoid = driver.findElement(By.xpath(AddEditPOFields.line1CalcExtCostValue().getTheXpath()))
					.getText();
			try {
				driver.findElement(By.xpath(AddEditPOFields.line1_VoidLink().getTheXpath())).click();
				Utility.acceptAlert(driver, testVars, logfile);
				Utility.waitABit(6);
			} catch (Exception e) {
			}
			calcExtCostPostVoid = driver.findElement(By.xpath(AddEditPOFields.line1CalcExtCostValue().getTheXpath()))
					.getText();
			voidPostText = driver.findElement(By.xpath(AddEditPOFields.line1_VoidState().getTheXpath())).getText();
			if (calcExtCostPreVoid.equals(calcExtCostPostVoid) && voidPostText.equals("Voided")) {
				Utility.logger(logfile, "\t\tThe selected line item was voided as expected. PASS");
				++testVars.PassResult;
			} else {
				Utility.logger(logfile, "\t\tThe selected line item was NOT voided as expected. FAIL");
				++testVars.FailResult;
			}

			Double secondVoidTotal = Utility.getPOTotalValue(driver, testVars, logfile);
			if (secondVoidTotal == 0) {
				Utility.logger(logfile, "\t\tThe Purchase Order Total decreased to zero as expected. PASS");
				++testVars.PassResult;
			} else {
				Utility.logger(logfile, "\t\tThe Purchase Order Total DID NOT decrease to zero as expected. FAIL");
				++testVars.FailResult;
			}
			Utility.waitABit(10);

			// Test Scenario 3.2: void a new PO
			Utility.logger(logfile,
					"\nAddPO Test Scenario 3.2: Search for the PO with two voided line items, and void the entire PO.");

			Utility.navigateToAPSearch(driver, testVars, logfile);
			driver.findElement(By.xpath("//input[@name='poNumber']")).sendKeys(newPONumber);
			driver.findElement(By.xpath("//input[@name='searchBasic']")).click();
			Utility.logger(logfile, "\tSearching by the Purchase Order Number input field for " + newPONumber);
			Utility.waitABit(4);

			try {
				driver.findElement(By.xpath(AddEditPOFields.purchaseOrderNumberValue().getTheXpath()));
				Utility.logger(logfile, "\tThe PO detail page appeared, as expected. PASS.");
				++testVars.PassResult;
			} catch (Exception e) {
				Utility.logger(logfile,
						"\tThe PO detail page did not appear, which is unexpected. FAIL-----------------------------------");
				++testVars.FailResult;
				skipTest = true;
			}

			if (skipTest == false) { // Void the PO and verify that the PO has VOID status.
				if (driver.findElement(By.xpath(AddEditPOFields.purchaseOrderNumberValue().getTheXpath())).getText()
						.equals(newPONumber)) {
					try {
						driver.findElement(By.xpath(AddEditPOFields.voidButton().getTheXpath())).click();
						Utility.acceptAlert(driver, testVars, logfile);
						Utility.waitABit(4);
						Utility.logger(logfile,
								"\tClicked the Purchase Order Void button and accepted the alert. PASS");
						++testVars.PassResult;

					} catch (Exception e) {
						Utility.logger(logfile,
								"\tCould not find new Purchase Order Void button. FAIL -------------------------------");
						++testVars.FailResult;
					}
					try {
						driver.findElement(By.xpath(AddEditPOFields.voidButton().getTheXpath()));
						Utility.logger(logfile,
								"\tPO VOID button exists on page after being clicked. FAIL -------------------------------");
						++testVars.FailResult;
					} catch (Exception e) {
						if (driver.findElement(By.xpath(AddEditPOFields.statusValue().getTheXpath())).getText()
								.equals("Void")) {
							Utility.logger(logfile, "\tThe PO Status is now VOID. PASS");
							++testVars.PassResult;
						} else {
							Utility.logger(logfile,
									"\tThe PO Status is not VOID even after clicking the PO VOID button, which is unexpected. FAIL -------------------------------");
							++testVars.FailResult;
						}
					}
				}
			} else {
				Utility.logger(logfile, "\t Skipped Test Scenario 3.2.");
				skipTest = false;
			}

			// Scenario 4.1
			Utility.logger(logfile,
					"\nAddPO Test Scenario 4.1: Populate a new purchase order from a data file. Validate the saved data. Approve the PO.");

			String poData[] = CSVReader.readPODataCSV(2);
			populateNewPOFromFile(driver, poData, testVars, logfile);
			addAttachmentToNewPO(driver, testVars, logfile);
			associateAttachmentWithLineItem(driver, testVars, logfile);
			validateSavedNewPO(driver, poData, testVars, logfile);

			// Scenario 4.2
			Utility.logger(logfile,
					"\nAddPO Test Scenario 4.2: Submit the new PO. Validate the fields and data on the page.");
			if (clickNewPOSubmitButton(driver, poData, testVars, logfile)) {
				validateFieldsExistOnSubmittedNewPO(driver, poData, testVars, logfile);
				validateDataOnSubmittedNewPO(driver, poData, testVars, logfile);
			}

			// Scenario 4.3
			Utility.logger(logfile,
					"\nAddPO Test Scenario 4.3: With an empty invoice section, submit the PO. Validate error messages.");
			if (!(clickInvoicedPOSubmitButton(driver))) {
				Utility.logger(logfile, "Submit button was not clicked. FAIL -----------------------------------");
				++testVars.FailResult;
			}
			validateEmptyInvoiceOnSubmitErrorMessages(driver, poData, testVars, logfile);

			// Scenario 4.4
			Utility.logger(logfile,
					"\nAddPO Test Scenario 4.4: Enter data into Invoice Section with invalid dollar amounts. Validate error messages.");

			// set the Invoice Date to the current day. Note: this method is specific to the
			// AP Search page. Need to generalize it.
			FieldMaker fieldValue = SubmittedPOFields.invoiceDateEntry();
			Utility.aPSearchPickaDate(driver, fieldValue.getTheXpath(), SetADate.getCurrentDate(), testVars, logfile);
			poData[44] = SetADate.getCurrentDate();

			// set an errant Invoice Amount
			Utility.logger(logfile, "\tentering very small Invoice Amt");
			String invValue = "1.2";
			fieldValue = SubmittedPOFields.invoiceAmountEntry();
			driver.findElement(By.xpath(fieldValue.getTheXpath())).clear();
			driver.findElement(By.xpath(fieldValue.getTheXpath())).sendKeys(invValue);

			// set an errant Remittance Amount
			Utility.logger(logfile, "\tentering very small Remittance Amt");
			String remValue = "2.1";
			fieldValue = SubmittedPOFields.remittanceEntry();
			driver.findElement(By.xpath(fieldValue.getTheXpath())).clear();
			driver.findElement(By.xpath(fieldValue.getTheXpath())).sendKeys(remValue);

			// set a unique Invoice Number
			Utility.logger(logfile, "\tentering Invoice Number");
			String invoiceID = "Invoice " + Identifiers.makeUniqueID();
			fieldValue = SubmittedPOFields.invoiceNumberEntry();
			driver.findElement(By.xpath(fieldValue.getTheXpath())).sendKeys(invoiceID);
			poData[45] = invoiceID;
			if (!(clickInvoicedPOSubmitButton(driver))) {
				Utility.logger(logfile, "Submit button was not clicked. FAIL -----------------------------------");
				++testVars.FailResult;
			}
			validateInvalidInvoiceOnSubmitErrorMessages(driver, poData, testVars, logfile);

			// Scenario 4.5
			Utility.logger(logfile,
					"\nAddPO Test Scenario 4.5: Enter the PO Total value into the Invoice and Remittance input text boxes. Validate PO submission.");
			// Get the PO total amount
			fieldValue = SubmittedPOFields.totalValue();
			String getPOTotal = driver.findElement(By.xpath(fieldValue.getTheXpath())).getAttribute("value");
			poData[46] = getPOTotal; // store InvoiceAmount as PO Total amount
			poData[47] = getPOTotal; // store Remittance Amount as PO Total amount.

			// enter the Invoice Amount
			Utility.logger(logfile, "\tEntering the PO Total into the Invoice Amt");
			fieldValue = SubmittedPOFields.invoiceAmountEntry();
			driver.findElement(By.xpath(fieldValue.getTheXpath())).clear();
			driver.findElement(By.xpath(fieldValue.getTheXpath())).sendKeys(getPOTotal);

			// enter the Remittance Amount
			Utility.logger(logfile, "\tEntering the PO Total into the Remittance Amt");
			fieldValue = SubmittedPOFields.remittanceEntry();
			driver.findElement(By.xpath(fieldValue.getTheXpath())).clear();
			driver.findElement(By.xpath(fieldValue.getTheXpath())).sendKeys(getPOTotal);
			if (!(clickInvoicedPOSubmitButton(driver))) {
				Utility.logger(logfile, "Submit button was not clicked. FAIL -----------------------------------");
				++testVars.FailResult;
			}
			validateSubmittedInvoicedPO(driver, poData, testVars, logfile);

			// Scenario 4.6
			Utility.logger(logfile, "\nAddPO Test Scenario 4.6: Validate the data on the PO page pending approval.");
			validateFieldsExistOnPOPendingApproval(driver, poData, testVars, logfile);
			validateDataOnPOPendingApproval(driver, poData, testVars, logfile);

			// Scenario 4.7
			Utility.logger(logfile,
					"\nAddPO Test Scenario 4.7: Approve the PO as admin. Validate fields and data on the Approved PO page.");
			// Approve the PO
			if (clickPOApproveButton(driver)) {
				Utility.logger(logfile, "\tApprove button is clicked");
				validateDataOnApprovedPO(driver, poData, testVars, logfile);
			} else {
				Utility.logger(logfile, "\tApprove button is NOT clicked. FAIL --------------------------");
				++testVars.FailResult;
			}

			// Scenario 5.0
			Utility.logger(logfile,
					"\nAddPO Test Scenario 5.0: Populate a new PO from a data file. Validate saved data. Reject the PO.");
			String poDataTest5[] = CSVReader.readPODataCSV(4);
			populateNewPOFromFile(driver, poDataTest5, testVars, logfile);
			addAttachmentToNewPO(driver, testVars, logfile);
			associateAttachmentWithLineItem(driver, testVars, logfile);
			validateSavedNewPO(driver, poDataTest5, testVars, logfile);
			clickNewPOSubmitButton(driver, poDataTest5, testVars, logfile);
			enterInvoiceValues(driver, poDataTest5, testVars, logfile);

			System.out.println("\tInvoiceNum = " + poDataTest5[45] + " and Remittance = " + poDataTest5[47]);
			// Submit the invoice
			if (!(clickInvoicedPOSubmitButton(driver))) {
				Utility.logger(logfile, "Submit button was not clicked. FAIL -----------------------------------");
				++testVars.FailResult;
			} else if (driver.findElement(By.xpath(APSearchFields.searchPageTitle().getTheXpath())).isDisplayed()) {
				driver.findElement(By.xpath(APSearchFields.poSearchResultsLine1_ID().getTheXpath())).click();
				Utility.waitABit(2);
			}

			// Scenario 5.1
			Utility.logger(logfile, "\nAddPO Test Scenario 5.1: Validate the data on the PO page pending approval.");
			validateFieldsExistOnPOPendingApproval(driver, poDataTest5, testVars, logfile);
			validateSubmittedInvoicedPO(driver, poDataTest5, testVars, logfile);

			// Scenario 5.2
			Utility.logger(logfile,
					"\nAAddPO Test Scenario 5.2: Reject the PO. Validate fields and data on the Rejected PO page.");
			// Reject the PO
			if (!(clickPORejectButton(driver))) {
				Utility.logger(logfile, "Reject button was not clicked. FAIL -----------------------------------");
				++testVars.FailResult;
			} else {
				Utility.logger(logfile, "\tReject button is clicked");
			}
			// Validate data displayed on the page.
			validateDataOnRejectedPO(driver, poDataTest5, testVars, logfile);
			// Void the PO
			voidAPO(driver, poDataTest5, testVars, logfile);

		} // Skip to here if code below is being developed. (switchOff is 'dev')

		// Scenario 6.0
		Utility.logger(logfile,
				"\nAddPO Test Scenario 6.0: Create a PO, and reject it. Update the PO, re-submit and approve the PO.");
		String poDataTest6[] = CSVReader.readPODataCSV(5);
		populateNewPOFromFile(driver, poDataTest6, testVars, logfile);
		addAttachmentToNewPO(driver, testVars, logfile);
		associateAttachmentWithLineItem(driver, testVars, logfile);
		validateSavedNewPO(driver, poDataTest6, testVars, logfile);
		clickNewPOSubmitButton(driver, poDataTest6, testVars, logfile);
		enterInvoiceValues(driver, poDataTest6, testVars, logfile);
		System.out.println("\tInvoiceNum = " + poDataTest6[45] + " and Remittance = " + poDataTest6[47]);
		// Submit the invoice
		if (!(clickInvoicedPOSubmitButton(driver))) {
			Utility.logger(logfile, "Submit button was not clicked. FAIL -----------------------------------");
			++testVars.FailResult;
		} else if (driver.findElement(By.xpath(APSearchFields.searchPageTitle().getTheXpath())).isDisplayed()) {
			driver.findElement(By.xpath(APSearchFields.poSearchResultsLine1_ID().getTheXpath())).click();
			Utility.waitABit(10);
		}
		// Reject the PO
		if (!(clickPORejectButton(driver))) {
			Utility.logger(logfile, "Reject button was not clicked. FAIL -----------------------------------");
			++testVars.FailResult;
		} else {
			Utility.logger(logfile, "\tReject button is clicked");
		}
		Utility.waitABit(2);

		// Scenario 6.1
		Utility.logger(logfile,
				"\nAddPO Test Scenario 6.1: Edit the PO Line item, save it, and re-submit the PO. Validate the data change.");
		// click the Line Item edit link.
		driver.findElement(By.xpath(SubmittedPOFields.line1_EditLink().getTheXpath())).click();
		Utility.waitABit(10);
		// update description value in line item
		poDataTest6[24] = "Filter - White";
		try {
			FieldSetter.textField(SubmittedPOFields.lineItem_Description(), poDataTest6[24], driver);
			Utility.logger(logfile, "\tUpdating the LineItem_Description field with a new value.");
		} catch (Exception e) {
			System.out.println("Couldn't edit the LineItem_Description field.");
		}

		if (!(clickUpdateLineItemButton(driver))) {
			Utility.logger(logfile,
					"Update Line Item button was not clicked. FAIL -----------------------------------");
			++testVars.FailResult;
		} else {
			try {
				driver.findElement(By.xpath(APSearchFields.searchPageTitle().getTheXpath())).isDisplayed();
				driver.findElement(By.xpath(APSearchFields.poSearchResultsLine1_ID().getTheXpath())).click();
				Utility.waitABit(2);
			} catch (Exception e) {
			}
		}
		Utility.waitABit(10);
		// Validate the line item change
		validateAPOField(driver, SubmittedPOFields.line1_DescriptionValue(), poDataTest6[24], false, testVars, logfile);

		// Submit the invoice
		if (!(clickInvoicedPOSubmitButton(driver))) {
			Utility.logger(logfile, "Submit button was not clicked. FAIL -----------------------------------");
			++testVars.FailResult;
		} else {
			try {
				driver.findElement(By.xpath(APSearchFields.searchPageTitle().getTheXpath())).isDisplayed();
				driver.findElement(By.xpath(APSearchFields.poSearchResultsLine1_ID().getTheXpath())).click();
				Utility.waitABit(10);
			} catch (Exception e) {
			}
		}

		// Approve the PO
		if (clickPOApproveButton(driver)) {
			Utility.logger(logfile, "\tApprove button is clicked");
			if (driver.findElement(By.xpath(SubmittedPOFields.approvedPO_StatusData().getTheXpath())).getText()
					.matches("Approved")) {
				Utility.logger(logfile, "\t" + SubmittedPOFields.approvedPO_StatusData().getFieldName()
						+ " shows that the PO is in APPROVED status. PASS");
				++testVars.PassResult;
			} else {
				Utility.logger(logfile, "\t" + SubmittedPOFields.approvedPO_StatusData().getFieldName()
						+ " shows that the PO is NOT in APPROVED status. FAIL ------------------");
				++testVars.FailResult;
			}
		} else {
			Utility.logger(logfile, "\tApprove button is NOT clicked. FAIL --------------------------");
			++testVars.FailResult;
		}

		driver.close();

		Utility.logger(logfile, "\nEnd of 'Add and Approve PO' tests.");
		Utility.logTestStats(logfile, testVars);
		logfile.close();
	}

	// END OF MAIN
	// **************************************************************************************************************************************************
	// **************************************************************************************************************************************************************
	// **************************************************************************************************************************************************************
	// **************************************************************************************************************************************************************
	// **************************************************************************************************************************************************************
	// **************************************************************************************************************************************************************
	// **************************************************************************************************************************************************************
	// **************************************************************************************************************************************************************
	// **************************************************************************************************************************************************************
	// **************************************************************************************************************************************************************
	// **************************************************************************************************************************************************************

	public static void enterInvoiceValues(WebDriver driver, String[] poData, testingVars testVars,
			PrintWriter logfile) {
		// set a unique Invoice Number
		Utility.logger(logfile, "\tentering Invoice Number");
		String invoiceID = "Invoice " + Identifiers.makeUniqueID();
		FieldMaker invoiceFieldValue = SubmittedPOFields.invoiceNumberEntry();
		driver.findElement(By.xpath(invoiceFieldValue.getTheXpath())).sendKeys(invoiceID);
		poData[45] = invoiceID;

		// Get the PO total amount
		invoiceFieldValue = SubmittedPOFields.totalValue();
		String getPOTotal = driver.findElement(By.xpath(invoiceFieldValue.getTheXpath())).getAttribute("value");
		poData[46] = getPOTotal; // store InvoiceAmount as PO Total amount
		poData[47] = getPOTotal; // store Remittance Amount as PO Total amount.

		// enter the Invoice Amount
		Utility.logger(logfile, "\tEntering the PO Total into the Invoice Amt");
		invoiceFieldValue = SubmittedPOFields.invoiceAmountEntry();
		driver.findElement(By.xpath(invoiceFieldValue.getTheXpath())).clear();
		driver.findElement(By.xpath(invoiceFieldValue.getTheXpath())).sendKeys(getPOTotal);

		// enter the Remittance Amount
		Utility.logger(logfile, "\tEntering the PO Total into the Remittance Amt");
		invoiceFieldValue = SubmittedPOFields.remittanceEntry();
		driver.findElement(By.xpath(invoiceFieldValue.getTheXpath())).clear();
		driver.findElement(By.xpath(invoiceFieldValue.getTheXpath())).sendKeys(getPOTotal);

		// set the Invoice Date to the current day. Note: this method is specific to the
		// AP Search page. Need to generalize it.
		FieldMaker fieldValue = SubmittedPOFields.invoiceDateEntry();
		Utility.aPSearchPickaDate(driver, fieldValue.getTheXpath(), SetADate.getCurrentDate(), testVars, logfile);
		poData[44] = SetADate.getCurrentDate();

	}

	public static void addAttachmentToNewPO(WebDriver driver, testingVars testVars, PrintWriter logfile) {

		try {
			driver.findElement(By.xpath("//*[@id='fileData']"))
					.sendKeys("C:\\PODocAttachments\\Sea Safety - Inv. 215582.pdf");
			Utility.waitABit(10);
			driver.findElement(By.xpath("//*[@id='uploadFile']")).click();
			Utility.logger(logfile, "\tAttached a file to new Purchase Order. PASS ");
			++testVars.PassResult;

		} catch (Exception e) {
			Utility.logger(logfile, "\tCould not attach file to new Purchase Order. FAIL ----------------------------");
			++testVars.FailResult;
		}
		Utility.waitABit(14);

	}

	public static void associateAttachmentWithLineItem(WebDriver driver, testingVars testVars, PrintWriter logfile) {

		try { // open the file association dialog
			driver.findElement(By.xpath("//div[@id='attachments']/table/tbody/tr[1]/td[3]/a")).click();
		} catch (Exception e) {
			Utility.logger(logfile,
					"\tCould not open the attachment associations dialog. FAIL ---------------------------");

		}

		try {
			driver.findElement(By.xpath("//*[@id='lineItemDialog']/ul/li/input")).click();
			Utility.logger(logfile, "\tClicked on line item choice in attachment associations dialog. PASS.");
		} catch (Exception e) {
			Utility.logger(logfile,
					"\tCould not click on line item choice in attachment associations dialog. FAIL ---------------------------");
		}

		try {
			driver.findElement(By.xpath("/html/body/div[5]/div[11]/div/button[1]")).click();
			Utility.logger(logfile, "\tSaved the line item choice in attachment associations dialog.");
		} catch (Exception e) {
			Utility.logger(logfile, "\tCould not save the line item choice in attachment associations dialog.");
		}
	}

	public static void populateNewPOFromFile(WebDriver driver, String[] poData, testingVars testVars,
			PrintWriter logfile) {

		// Test Scenario 2: Enter a new PO with two line items
		Utility.logger(logfile, "\tPopulate a new Purchase Order and save it.");
		testVars.department = poData[1];
		Utility.setDepartment(DOBI_Fields.globalDepartmentDropdown(), driver, testVars, logfile);

		Utility.navigateToAddEditPurchaseOrder(driver, testVars, logfile);
		String newPONumber = Utility.getNewPurchaseOrderNumber(driver, testVars, logfile);
		poData[43] = newPONumber;
		Utility.logger(logfile, "\tNew Purchase Order Number is " + newPONumber);

		poData[3] = Identifiers.makeUniqueID();
		FieldSetter.textField(AddEditPOFields.referenceNumberTextInput(), poData[3], driver);
		Utility.logger(logfile, "\tNew Reference Number is " + poData[3]);
		FieldSetter.dropdown(AddEditPOFields.vendorDropdown(driver), poData[4], -1, driver, logfile); // Sea Safety &
																										// Survival -
																										// 1024301 -
																										// SAV-001
		SetADate.useDatePicker(driver, AddEditPOFields.purchaseOrderDate(), AddEditPOFields.pODateMonthPicker(),
				AddEditPOFields.pODateMonthDisplay(), AddEditPOFields.pODateYearDisplay(), SetADate.getCurrentDate(),
				testVars, logfile);
		FieldSetter.dropdown(AddEditPOFields.purchaserDropdown(driver), poData[7], -1, driver, logfile); // Foret,
																											// Edward
		FieldSetter.dropdown(AddEditPOFields.shipViaDropdown(driver), poData[10], -1, driver, logfile); // none

		if (poData[12].length() > 1) { // if the 'line item: department' data is not null, create a line item.
			Utility.logger(logfile, "\tAdd the first line item to the new PO.");
			verifyPOLineItemExistence(driver, false, 1, testVars, logfile);

			FieldSetter.dropdown(AddEditPOFields.lineItem_DepartmentNumber(driver), poData[12], -1, driver, logfile); // 57130
			FieldSetter.dropdown(AddEditPOFields.lineItem_Account(driver), poData[13], -1, driver, logfile); // 6110030
			FieldSetter.dropdown(AddEditPOFields.lineItem_LineOfService(driver), poData[14], -1, driver, logfile); // 1800

			FieldSetter.dropdown(AddEditPOFields.lineItem_Project(driver), poData[17], -1, driver, logfile); // 5713000041
			FieldSetter.dropdown(AddEditPOFields.lineItem_Equipment(driver), poData[20], -1, driver, logfile); // Founder
			FieldSetter.textField(AddEditPOFields.lineItem_PartNumber(), poData[23], driver); // none
			FieldSetter.textField(AddEditPOFields.lineItem_Description(), poData[24], driver); // Supplies
			FieldSetter.textField(AddEditPOFields.lineItem_Quantity(), poData[25], driver); // 549.10
			FieldSetter.textField(AddEditPOFields.lineItem_UnitCost(), poData[26], driver); // 549.10
			FieldSetter.buttonClick(AddEditPOFields.lineItemButton(), driver);
			Utility.waitABit(10);
			verifyPOLineItemExistence(driver, true, 1, testVars, logfile);
		}

		if (poData[28].length() > 1) { // if the 'line item: department' data is not null, create a line item.
			Utility.logger(logfile, "\tAdd the second line item to the new PO.");
			verifyPOLineItemExistence(driver, false, 2, testVars, logfile);

			FieldSetter.dropdown(AddEditPOFields.lineItem_DepartmentNumber(driver), poData[28], -1, driver, logfile); // 57130
			FieldSetter.dropdown(AddEditPOFields.lineItem_Account(driver), poData[29], -1, driver, logfile); // 6110030
			FieldSetter.dropdown(AddEditPOFields.lineItem_LineOfService(driver), poData[30], -1, driver, logfile); // 1800
			Utility.waitABit(3);
			FieldSetter.dropdown(AddEditPOFields.lineItem_Project(driver), poData[33], -1, driver, logfile); // 5713000041
			FieldSetter.dropdown(AddEditPOFields.lineItem_Equipment(driver), poData[36], -1, driver, logfile); // Founder
			FieldSetter.textField(AddEditPOFields.lineItem_PartNumber(), poData[39], driver); // none
			FieldSetter.textField(AddEditPOFields.lineItem_Description(), poData[40], driver); // Supplies
			FieldSetter.textField(AddEditPOFields.lineItem_Quantity(), poData[41], driver); // 549.10
			FieldSetter.textField(AddEditPOFields.lineItem_UnitCost(), poData[42], driver); // 549.10
			FieldSetter.buttonClick(AddEditPOFields.lineItemButton(), driver);
			Utility.waitABit(10);
			verifyPOLineItemExistence(driver, true, 2, testVars, logfile);
		}
	}

	public static boolean clickUpdateLineItemButton(WebDriver driver) {
		boolean buttonClicked;
		try {
			driver.findElement(By.xpath(SubmittedPOFields.updateLineItemButton().getTheXpath())).click();
			buttonClicked = true;
		} catch (Exception e) {
			buttonClicked = false;
		}
		return buttonClicked;
	}

	public static boolean clickSaveButton(WebDriver driver) {
		boolean buttonClicked = false;
		try {
			driver.findElement(By.xpath(SubmittedPOFields.saveButton().getTheXpath())).click();
			buttonClicked = true;
		} catch (Exception e) {
			buttonClicked = false;
		}
		return buttonClicked;
	}

	public static boolean clickNewPOSubmitButton(WebDriver driver, String[] poData, testingVars testVars,
			PrintWriter logfile) {
		boolean skipTest = false;
		boolean submittedPO = true;
		try {
			driver.findElement(By.xpath(AddEditPOFields.submitNewPOButton().getTheXpath())).click();
			skipTest = false;
		} catch (Exception e) {
			skipTest = true;
		}
		if (driver
				.findElement(By.xpath("//div[@class='section-title' and normalize-space(.//text())='Ap Input Search']"))
				.isDisplayed()) { // AP Search page title.
			Utility.logger(logfile, "\tClicked the Submit button for a new PO and the PO Search page appeared. PASS");
			++testVars.PassResult;
		} else {
			Utility.logger(logfile,
					"\tClicked the Submit button for a new PO and the PO Search page DID NOT appear. FAIL---------------------------------");
			++testVars.FailResult;
			skipTest = true;
		}
		Utility.waitABit(4);
		if (skipTest == false) {
			// search on the reference number. Validate that the PO detail page appears by
			// verifying the page title and PO number.
			driver.findElement(By.xpath("//input[@value='Clear']")).click();
			driver.findElement(By.xpath("//*[@id='referenceNumber']")).sendKeys(poData[3]);
			driver.findElement(By.xpath("//*[@id='searchVoucher']")).click();
			Utility.logger(logfile, "\tSearching by the Purchase Order Reference Number input field for " + poData[3]);
			Utility.waitABit();
			driver.findElement(By.xpath("//*[@id='dataTable']/tbody/tr/td[1]/a")).click(); // click on the record that
																							// appears in the search
																							// page result set.
			Utility.waitABit(4);
			try {

				driver.findElement(By.xpath(SubmittedPOFields.purchaseOrderNumberValue().getTheXpath())).isDisplayed();
				Utility.logger(logfile, "\tThe PO detail page appeared, as expected. PASS.");
				++testVars.PassResult;
			} catch (Exception e) {
				Utility.logger(logfile,
						"\tThe PO detail page did not appear, which is unexpected. FAIL-----------------------------------");
				++testVars.FailResult;
				skipTest = true;
			}
		}

		return submittedPO;
	}

	public static boolean clickInvoicedPOSubmitButton(WebDriver driver) {
		boolean buttonClicked;
		try {
			driver.findElement(By.xpath(SubmittedPOFields.submitForReviewButton().getTheXpath())).click();
			buttonClicked = true;
		} catch (Exception e) {
			buttonClicked = false;
		}
		return buttonClicked;
	}

	public static boolean clickPOApproveButton(WebDriver driver) {
		boolean buttonClicked;
		try {
			driver.findElement(By.xpath(SubmittedPOFields.approveButton().getTheXpath())).click();
			buttonClicked = true;
		} catch (Exception e) {
			buttonClicked = false;
		}
		return buttonClicked;
	}

	public static boolean clickPORejectButton(WebDriver driver) {
		boolean buttonClicked;
		try {
			driver.findElement(By.xpath(SubmittedPOFields.rejectButton().getTheXpath())).click();
			buttonClicked = true;
		} catch (Exception e) {
			buttonClicked = false;
		}
		return buttonClicked;
	}

	public static void voidAPO(WebDriver driver, String[] poData, testingVars testVars, PrintWriter logfile) {
		try {
			driver.findElement(By.xpath(SubmittedPOFields.voidButton().getTheXpath())).click();
			Utility.acceptAlert(driver, testVars, logfile);
			Utility.waitABit(4);
			Utility.logger(logfile, "\tClicked the Purchase Order Void button and accepted the alert. PASS");
			++testVars.PassResult;

		} catch (Exception e) {
			Utility.logger(logfile,
					"\tCould not find new Purchase Order Void button. FAIL -------------------------------");
			++testVars.FailResult;
		}
		try {
			driver.findElement(By.xpath(SubmittedPOFields.voidButton().getTheXpath()));
			Utility.logger(logfile,
					"\tPO VOID button exists on page after being clicked. FAIL -------------------------------");
			++testVars.FailResult;
		} catch (Exception e) {
			if (driver.findElement(By.xpath(SubmittedPOFields.statusValue().getTheXpath())).getText().equals("Void")) {
				Utility.logger(logfile, "\tThe PO Status is now VOID. PASS");
				++testVars.PassResult;
			} else {
				Utility.logger(logfile,
						"\tThe PO Status is not VOID even after clicking the PO VOID button, which is unexpected. FAIL -------------------------------");
				++testVars.FailResult;
			}
		}
	}

	public static void verifyPOLineItemExistence(WebDriver driver, Boolean DoesExist, Integer rowNumber,
			testingVars testVars, PrintWriter logfile) {
		Boolean lineExists = false;
		try {
			driver.findElement(
					By.xpath("//*[@id='purchaseOrderLineItems']/tbody/tr[" + String.valueOf(rowNumber) + "]"));
			lineExists = true;
		} catch (Exception e) {
			lineExists = false;
		}
		if (DoesExist == false) {
			if (lineExists == false) {
				Utility.logger(logfile, "\tLine Item " + String.valueOf(rowNumber) + " is empty as expected. PASS");
				++testVars.PassResult;
			} else if (lineExists == true) {
				Utility.logger(logfile, "\tLine Item " + String.valueOf(rowNumber)
						+ " is not empty, which is unexpected. FAIL-----------------------");
				++testVars.FailResult;
			}
		} else if (DoesExist == true) {
			if (lineExists == true) {
				Utility.logger(logfile, "\tLine Item " + String.valueOf(rowNumber) + " exists as expected. PASS");
				++testVars.PassResult;
			} else if (lineExists == false) {
				Utility.logger(logfile, "\tLine Item " + String.valueOf(rowNumber)
						+ " DOES NOT exist, which is unexpected. FAIL-----------------------");
				++testVars.FailResult;
			}
		} else {
			Utility.logger(logfile, "\tLine Item test did not occur properly. FAIL-----------------------");
			++testVars.FailResult;
		}
	}

	public static void verifyExistenceOfAddPOInputFields(WebDriver driver, testingVars testVars, PrintWriter logfile) {

		Utility.logger(logfile,
				"\nVerify Add/Edit Purchase Order page contents including text input fields and dropdowns.");

		FieldMaker fieldValues = AddEditPOFields.referenceNumberTextInput();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.vendorDropdown(driver);
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.purchaseOrderDate();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.purchaserDropdown(driver);
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.shipViaDropdown(driver);
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.lineItem_DepartmentNumber(driver);
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.lineItem_Account(driver);
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.lineItem_LineOfService(driver);
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.lineItem_Chartfield1(driver);
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.lineItem_Project(driver);
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.lineItem_Job(driver);
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.lineItem_Equipment(driver);
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.lineItem_Reimbursable();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.lineItem_PartNumber();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.lineItem_Description();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.lineItem_Quantity();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.lineItem_UnitCost();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

	}

	public static void verifyExistenceOfAddPOInputFieldLabels(WebDriver driver, testingVars testVars,
			PrintWriter logfile) {

		Utility.logger(logfile, "\nVerify Add/Edit Purchase Order page titles and labels.");

		FieldMaker fieldValues = AddEditPOFields.addPO_PageTitle();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.regularLabel();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.locationLabel();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.locationValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.purchaseOrderNumberLabel();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.purchaseOrderNumberValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.referenceNumberLabel();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.vendorLabel();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.addressLabel();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.purchaseOrderDateLabel();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.purchaserLabel();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.shipViaLabel();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.createdByLabel();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.createdByValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.poLineItemsSectionTitle();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.accountInfoTitle();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.totalLabel();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.totalValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.statusLabel();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.statusValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.purchaseOrderNotesHistoryLabel();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

	}

	public static void verifyExistenceOfAddPOButtonsAndLinks(WebDriver driver, testingVars testVars,
			PrintWriter logfile) {

		Utility.logger(logfile, "\nVerify Add/Edit Purchase Order page buttons and links.");

		FieldMaker fieldValues = AddEditPOFields.printButton();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.lineItemButton();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = AddEditPOFields.saveButton();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

	}

	public static void verifyDisabledLineItemFields(WebDriver driver, testingVars testVars, PrintWriter logfile) {
		// some Purchase Order Line Item fields are disabled depending on which
		// department is selected.

		// Department || disabled Line Item fields list
		// 12110 || Chartfield1, Job, Reimbursable
		// 16540 || Chartfield1, Project, Reimbursable
		// 57130 || ChartField1, Reimbursable
		// 66010 || Chartfield1, Project, Job, Reimbursable
		// 77030 || Chartfield1, Job, Reimbursable
		// 99950 || Chartfield1, Project, Job, Reimbursable

		/*
		 * 1) set Department 2) check the "disabled' attribute for each of the fields:
		 * Chartfield1, Project, Job, and Reimbursable 3) compare the discovered
		 * disabled attribute to the expected values. 4) change department and do steps
		 * 2 and 3 again.
		 */
		Utility.logger(logfile, "\nVerify sets of Line Item disabled fields by department.");
		addPOLineItemsDisabledTests("12110", "disabled", "enabled", "disabled", "disabled", testVars, logfile, driver);
		addPOLineItemsDisabledTests("16540", "disabled", "disabled", "enabled", "disabled", testVars, logfile, driver);
		addPOLineItemsDisabledTests("57130", "disabled", "enabled", "enabled", "disabled", testVars, logfile, driver);
		addPOLineItemsDisabledTests("66010", "disabled", "disabled", "disabled", "disabled", testVars, logfile, driver);
		addPOLineItemsDisabledTests("77030", "disabled", "enabled", "disabled", "disabled", testVars, logfile, driver);
		addPOLineItemsDisabledTests("99950", "disabled", "disabled", "disabled", "disabled", testVars, logfile, driver);

	}

	public static void addPOLineItemsDisabledTests(String department, String chartfield1, String project, String job,
			String reimbursable, testingVars testVars, PrintWriter logfile, WebDriver driver) {
		Utility.logger(logfile, "\n\tVerify that for Department " + department + ", Chartfield1 is " + chartfield1
				+ ", Project is " + project + ", Job is " + job + ", Reimbursable is " + reimbursable);
		testVars.department = department;
		Utility.setDepartment(DOBI_Fields.globalDepartmentDropdown(), driver, testVars, logfile);
		Utility.navigateToAddEditPurchaseOrder(driver, testVars, logfile);
		checkIfDisabled(AddEditPOFields.lineItem_Chartfield1(driver), chartfield1, testVars, logfile, driver);
		Utility.waitABit();
		checkIfDisabled(AddEditPOFields.lineItem_Project(driver), project, testVars, logfile, driver);
		Utility.waitABit();
		checkIfDisabled(AddEditPOFields.lineItem_Job(driver), job, testVars, logfile, driver);
		Utility.waitABit();
		checkIfDisabled(AddEditPOFields.lineItem_Reimbursable(), reimbursable, testVars, logfile, driver);

	}

	public static void checkIfDisabled(FieldMaker fieldName, String expecteddisabledStatus, testingVars testVars,
			PrintWriter logfile, WebDriver driver) {

		String isItDisabled = "";
		try {
			isItDisabled = driver.findElement(By.xpath(fieldName.getTheXpath())).getAttribute("disabled");
			if (isItDisabled == null) {
				isItDisabled = "enabled";
			} else {
				isItDisabled = "disabled";
			}
			Utility.logger(logfile, "\tIn the Add Purchase Order Line Item fields the disabled status of "
					+ fieldName.getFieldName() + " is " + isItDisabled);
			if (isItDisabled.matches(expecteddisabledStatus)) {
				Utility.logger(logfile, "\tDisabled status test passes. PASS.");
				++testVars.PassResult;
			} else {
				Utility.logger(logfile, "\tDisabled status test fails. FAIL ---------------------------------.");
				++testVars.PassResult;
			}
		} catch (Exception e) {
			Utility.logger(logfile, "\tIn the Add Purchase Order Line Item fields, the disabled attribute of "
					+ fieldName.getFieldName() + " could not be found. FAIL *************************");
			++testVars.FailResult;
		}
	}

	public static void verifyAddEditPORequiredFields(WebDriver driver, testingVars testVars, PrintWriter logfile) {
		Utility.navigateToAddEditPurchaseOrder(driver, testVars, logfile);
		FieldSetter.buttonClick(AddEditPOFields.saveButton(), driver);
		verifyRequiredFielderror(driver, AddEditPOFields.vendorDropdown(driver), testVars, logfile);
		verifyRequiredFielderror(driver, AddEditPOFields.purchaserDropdown(driver), testVars, logfile);
		verifyRequiredFielderror(driver, AddEditPOFields.lineItem_Description(), testVars, logfile);
		verifyRequiredFielderror(driver, AddEditPOFields.lineItem_Quantity(), testVars, logfile);
		verifyRequiredFielderror(driver, AddEditPOFields.lineItem_UnitCost(), testVars, logfile);
	}

	public static void verifyRequiredFielderror(WebDriver driver, FieldMaker fieldName, testingVars testVars,
			PrintWriter logfile) {
		String checkFieldColor = "";
		String checkBorderColor = "";
		String fieldErrorText = "";
		String actualBorderColor = "";
		String actualFieldColor = "";

		if (fieldName.getRequiredFieldErrorText() != null && !fieldName.getRequiredFieldErrorText().isEmpty()) {
			if (fieldName.getErrorXPath() != null && !fieldName.getErrorXPath().isEmpty()) {
				fieldErrorText = driver.findElement(By.xpath(fieldName.getErrorXPath())).getText();
				if (fieldErrorText.equals(fieldName.getRequiredFieldErrorText())) {
					Utility.logger(logfile, "\t" + fieldName.getFieldName()
							+ " required field text appears as expected when field is empty and record save is attempted. PASS");
					++testVars.PassResult;
				} else {
					Utility.logger(logfile, "\t" + fieldName.getFieldName()
							+ " required field text DOES NOT appear as expected when field is empty and record save is attempted. FAIL ---------------------------");
					++testVars.FailResult;
				}
			} else {
				fieldErrorText = driver.findElement(By.xpath(fieldName.getTheXpath())).getText();
				if (fieldErrorText.equals(fieldName.getRequiredFieldErrorText())) {
					Utility.logger(logfile, "\t" + fieldName.getFieldName()
							+ " required field text appears as expected when field is empty and record save is attempted. PASS");
					++testVars.PassResult;
				} else {
					Utility.logger(logfile, "\t" + fieldName.getFieldName()
							+ " required field text DOES NOT appear as expected when field is empty and record save is attempted. FAIL ---------------------------");
					++testVars.FailResult;
				}
			}
		} // if required field error text exists, then test for it.

		if (fieldName.getRequiredFieldErrorBorderColor() != null
				&& !fieldName.getRequiredFieldErrorBorderColor().isEmpty()) {
			if (fieldName.getErrorXPath() != null && !fieldName.getErrorXPath().isEmpty()) {
				checkBorderColor = driver.findElement(By.xpath(fieldName.getErrorXPath())).getCssValue("border-color");
				actualBorderColor = Utility.clarifyColor(checkBorderColor);
				if (actualBorderColor.equals(fieldName.getRequiredFieldErrorBorderColor())) {
					Utility.logger(logfile, "\t" + fieldName.getFieldName()
							+ " required field border color appears as expected when field is empty and record save is attempted. PASS");
					++testVars.PassResult;
				} else {
					Utility.logger(logfile, "\t" + fieldName.getFieldName()
							+ " required field border color DOES NOT appear as expected when field is empty and record save is attempted. FAIL ---------------------------");
					++testVars.FailResult;
				}
			} else {
				checkBorderColor = driver.findElement(By.xpath(fieldName.getTheXpath())).getCssValue("border-color");
				actualBorderColor = Utility.clarifyColor(checkBorderColor);
				if (actualBorderColor.equals(fieldName.getRequiredFieldErrorBorderColor())) {
					Utility.logger(logfile, "\t" + fieldName.getFieldName()
							+ " required field border color appears as expected when field is empty and record save is attempted. PASS");
					++testVars.PassResult;
				} else {
					Utility.logger(logfile, "\t" + fieldName.getFieldName()
							+ " required field border color DOES NOT appear as expected when field is empty and record save is attempted. FAIL ---------------------------");
					++testVars.FailResult;
				}
			}
		} // if required field red border color exists, then test for it.

		if (fieldName.getRequiredFieldErrorFieldColor() != null
				&& !fieldName.getRequiredFieldErrorFieldColor().isEmpty()) {
			if (fieldName.getErrorXPath() != null && !fieldName.getErrorXPath().isEmpty()) {
				checkFieldColor = driver.findElement(By.xpath(fieldName.getErrorXPath())).getCssValue("color");
				actualFieldColor = Utility.clarifyColor(checkFieldColor);
				if (actualFieldColor.equals(fieldName.getRequiredFieldErrorFieldColor())) {
					Utility.logger(logfile, "\t" + fieldName.getFieldName()
							+ " required field color appears as expected when field is empty and record save is attempted. PASS");
					++testVars.PassResult;
				} else {
					Utility.logger(logfile, "\t" + fieldName.getFieldName()
							+ " required field color DOES NOT appear as expected when field is empty and record save is attempted. FAIL ---------------------------");
					++testVars.FailResult;
				}
			} else {
				checkFieldColor = driver.findElement(By.xpath(fieldName.getTheXpath())).getCssValue("color");
				actualFieldColor = Utility.clarifyColor(checkFieldColor);
				if (actualFieldColor.equals(fieldName.getRequiredFieldErrorFieldColor())) {
					Utility.logger(logfile, "\t" + fieldName.getFieldName()
							+ " required field color appears as expected when field is empty and record save is attempted. PASS");
					++testVars.PassResult;
				} else {
					Utility.logger(logfile, "\t" + fieldName.getFieldName()
							+ " required field color DOES NOT appear as expected when field is empty and record save is attempted. FAIL ---------------------------");
					++testVars.FailResult;
				}
			}
		} // if required field red color exists, then test for it.
	}

	public static void validateSavedNewPO(WebDriver driver, String[] poData, testingVars testVars,
			PrintWriter logfile) {
		Utility.logger(logfile, "\nVerify that the expected data has been saved in each field of the Purchase Order.");

		// compare the saved data each field on the Add/Edit PO page with poData, verify
		// equality.
		validateAPOField(driver, AddEditPOFields.locationValue(), poData[2], false, testVars, logfile);
		validateAPOField(driver, AddEditPOFields.vendorValueLabel(), poData[5], false, testVars, logfile);
		validateAPOField(driver, AddEditPOFields.purchaserValueLabel(), poData[8] + ", " + poData[9], false, testVars,
				logfile);
		validateAPOField(driver, AddEditPOFields.shipViaValueLabel(), poData[10], false, testVars, logfile);
		validateAPOField(driver, AddEditPOFields.line1DepartmentValue(), poData[12], false, testVars, logfile);
		validateAPOField(driver, AddEditPOFields.line1AccountValue(), poData[13], false, testVars, logfile);
		validateAPOField(driver, AddEditPOFields.line1LoSValue(), poData[15], false, testVars, logfile);
		validateAPOField(driver, AddEditPOFields.line1Chartfield1Value(), poData[16], false, testVars, logfile);
		validateAPOField(driver, AddEditPOFields.line1ProjectValue(), poData[18], false, testVars, logfile);
		validateAPOField(driver, AddEditPOFields.line1JobValue(), poData[19], false, testVars, logfile);
		validateAPOField(driver, AddEditPOFields.line1EquipmentValue(), poData[21], false, testVars, logfile);
		validateAPOField(driver, AddEditPOFields.line1ReImbursableValue(), poData[22], false, testVars, logfile);
		validateAPOField(driver, AddEditPOFields.line1PartNumberValue(), poData[23], false, testVars, logfile);
		validateAPOField(driver, AddEditPOFields.line1DescriptionValue(), poData[24], false, testVars, logfile);
		validateAPOField(driver, AddEditPOFields.line1QuantityValue(), poData[25], true, testVars, logfile);
		validateAPOField(driver, AddEditPOFields.line1UnitCostValue(), poData[26], true, testVars, logfile);
		validateAPOField(driver, AddEditPOFields.line1CalcExtCostValue(),
				String.valueOf(Double.parseDouble(poData[25]) * Double.parseDouble(poData[26])), true, testVars,
				logfile);

		boolean validateLine2 = false;
		try {
			driver.findElement(By.xpath(AddEditPOFields.line2DepartmentValue().getTheXpath())).isEnabled();
			validateLine2 = true;
		} catch (Exception e) {
			validateLine2 = false;
		}

		if (validateLine2) {
			validateAPOField(driver, AddEditPOFields.line2DepartmentValue(), poData[28], false, testVars, logfile);
			validateAPOField(driver, AddEditPOFields.line2AccountValue(), poData[29], false, testVars, logfile);
			validateAPOField(driver, AddEditPOFields.line2LoSValue(), poData[31], false, testVars, logfile);
			validateAPOField(driver, AddEditPOFields.line2Chartfield1Value(), poData[32], false, testVars, logfile);
			validateAPOField(driver, AddEditPOFields.line2ProjectValue(), poData[34], false, testVars, logfile);
			validateAPOField(driver, AddEditPOFields.line2JobValue(), poData[35], false, testVars, logfile);
			validateAPOField(driver, AddEditPOFields.line2EquipmentValue(), poData[37], false, testVars, logfile);
			validateAPOField(driver, AddEditPOFields.line2ReImbursableValue(), poData[38], false, testVars, logfile);
			validateAPOField(driver, AddEditPOFields.line2PartNumberValue(), poData[39], false, testVars, logfile);
			validateAPOField(driver, AddEditPOFields.line2DescriptionValue(), poData[40], false, testVars, logfile);
			validateAPOField(driver, AddEditPOFields.line2QuantityValue(), poData[41], true, testVars, logfile);
			validateAPOField(driver, AddEditPOFields.line2UnitCostValue(), poData[42], true, testVars, logfile);
			validateAPOField(driver, AddEditPOFields.line2CalcExtCostValue(),
					String.valueOf(Double.parseDouble(poData[41]) * Double.parseDouble(poData[42])), true, testVars,
					logfile);
		}
	}

	public static void validateAPOField(WebDriver driver, FieldMaker fieldname, String data, boolean numeric,
			testingVars testVars, PrintWriter logfile) {

		if (numeric == false) {
			if (driver.findElement(By.xpath(fieldname.getTheXpath())).getText().matches(data)) {
				Utility.logger(logfile,
						"\tSaved PO " + fieldname.getFieldName() + " data matches the expected value. PASS");
				++testVars.PassResult;
			} else {
				Utility.logger(logfile, "\tSaved PO " + fieldname.getFieldName()
						+ " data DOES NOT MATCH the expected value. FAIL ------------------------------");
				++testVars.FailResult;
				System.out.println("DOBI: " + driver.findElement(By.xpath(fieldname.getTheXpath())).getText());
				System.out.println("Excel: " + data);
			}
		} else { // if (numeric == true)

			Double savedNum = Double
					.valueOf(driver.findElement(By.xpath(fieldname.getTheXpath())).getText().replace(",", ""));

			if (savedNum == Double.parseDouble(data)) {
				Utility.logger(logfile,
						"\tSaved PO " + fieldname.getFieldName() + " data matches the expected value. PASS");
				++testVars.PassResult;
			} else {
				Utility.logger(logfile, "\tSaved PO " + fieldname.getFieldName()
						+ " data DOES NOT MATCH the expected value. FAIL ------------------------------");
				++testVars.FailResult;
			}

		}
	}

	public static void validateAPEntryField(WebDriver driver, FieldMaker fieldname, String data, boolean numeric,
			testingVars testVars, PrintWriter logfile) {

		if (numeric == false) {
			if (driver.findElement(By.xpath(fieldname.getTheXpath())).getAttribute("value").matches(data)) {
				Utility.logger(logfile,
						"\tSaved PO " + fieldname.getFieldName() + " data matches the expected value. PASS");
				++testVars.PassResult;
			} else {
				Utility.logger(logfile, "\tSaved PO " + fieldname.getFieldName()
						+ " data DOES NOT MATCH the expected value. FAIL ------------------------------");
				++testVars.FailResult;
				System.out.println("DOBI: " + driver.findElement(By.xpath(fieldname.getTheXpath())).getText());
				System.out.println("Excel: " + data);
			}
		} else { // if (numeric == true)

			Double savedNum = Double.valueOf(
					driver.findElement(By.xpath(fieldname.getTheXpath())).getAttribute("value").replace(",", ""));

			if (savedNum == Double.parseDouble(data)) {
				Utility.logger(logfile,
						"\tSaved PO " + fieldname.getFieldName() + " data matches the expected value. PASS");
				++testVars.PassResult;
			} else {
				Utility.logger(logfile, "\tSaved PO " + fieldname.getFieldName()
						+ " data DOES NOT MATCH the expected value. FAIL ------------------------------");
				++testVars.FailResult;
			}

		}
	}

	public static void validateFieldsExistOnSubmittedNewPO(WebDriver driver, String[] poData, testingVars testVars,
			PrintWriter logfile) {
		Utility.logger(logfile, "\nValidate the existence of fields on the submitted Purchase Order detail page.");

		// Location, data
		FieldMaker fieldValues = SubmittedPOFields.locationValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// PO Number
		fieldValues = SubmittedPOFields.purchaseOrderNumberValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// PayKey
		fieldValues = SubmittedPOFields.payKeyValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// BackOrder number
		fieldValues = SubmittedPOFields.backOrderNumberValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Reference Number, data
		fieldValues = SubmittedPOFields.referenceNumberValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Vendor, data
		fieldValues = SubmittedPOFields.vendorValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// address
		fieldValues = SubmittedPOFields.address1ValueLabel();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = SubmittedPOFields.address2ValueLabel();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Purchase Order Date
		fieldValues = SubmittedPOFields.purchaseOrderDateValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Purchaser, data
		fieldValues = SubmittedPOFields.purchaserValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Terms
		fieldValues = SubmittedPOFields.termsValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Currency
		fieldValues = SubmittedPOFields.currencyValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Created By
		fieldValues = SubmittedPOFields.createdByValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Created On
		fieldValues = SubmittedPOFields.createdDateValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Approved By
		fieldValues = SubmittedPOFields.approvedByValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Approved On
		fieldValues = SubmittedPOFields.approvedDateValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Line Item input fields
		// Line Item input - Department
		fieldValues = SubmittedPOFields.lineItem_DepartmentNumber(driver);
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Line Item input - Account
		fieldValues = SubmittedPOFields.lineItem_Account(driver);
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Line Item input - Line of Service
		fieldValues = SubmittedPOFields.lineItem_LineOfService(driver);
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Line Item input - Amount
		fieldValues = SubmittedPOFields.line_AmountEntry();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Line Item input - Description
		fieldValues = SubmittedPOFields.lineItem_Description();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Line Item input - ChartField1
		fieldValues = SubmittedPOFields.lineItem_Chartfield1(driver);
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Line Item input - Project
		fieldValues = SubmittedPOFields.lineItem_Project(driver);
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Line Item input - ReImbursable
		fieldValues = SubmittedPOFields.lineItem_Reimbursable();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Line Item input - Job
		fieldValues = SubmittedPOFields.lineItem_Job(driver);
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Line Item input - Equipment
		fieldValues = SubmittedPOFields.lineItem_Equipment(driver);
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Line Item input - Accounting Date
		fieldValues = SubmittedPOFields.line_AccountingDateEntry();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Line Item input - Markup Percent
		fieldValues = SubmittedPOFields.line_MarkupPercentEntry();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Line Item input - Customer
		fieldValues = SubmittedPOFields.line_CustomerEntry();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Line Item input - Vendor Name
		fieldValues = SubmittedPOFields.line_VendorEntry();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Line Item 1 saved fields, data
		// Saved Line Item 1 - Include
		fieldValues = SubmittedPOFields.line1_IncludeCheckbox();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Department
		fieldValues = SubmittedPOFields.line1_DepartmentValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Account
		fieldValues = SubmittedPOFields.line1_AccountValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Line of Service
		fieldValues = SubmittedPOFields.line1_LineOfServiceValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Amount
		fieldValues = SubmittedPOFields.line1_AmountValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Chartfield1
		fieldValues = SubmittedPOFields.line1_Chartfield1Value();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Description, data
		fieldValues = SubmittedPOFields.line1_DescriptionValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Receipt Date
		fieldValues = SubmittedPOFields.line1_ReceiptDateValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Accounting Date
		fieldValues = SubmittedPOFields.line1_AccountingDateValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Equipment, data
		fieldValues = SubmittedPOFields.line1_EquipmentValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Merchant
		fieldValues = SubmittedPOFields.line1_MerchantValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Attendees
		fieldValues = SubmittedPOFields.line1_AttendeesValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Project, data
		fieldValues = SubmittedPOFields.line1_ProjectValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Job
		fieldValues = SubmittedPOFields.line1_JobValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Reimbursable
		fieldValues = SubmittedPOFields.line1_ReimbursableValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Markup Percentage
		fieldValues = SubmittedPOFields.line1_MarkupPercentageValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Customer
		fieldValues = SubmittedPOFields.line1_CustomerValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Vendor Name
		fieldValues = SubmittedPOFields.line1_VendorNameValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Attachments link
		fieldValues = SubmittedPOFields.line1_AttachmentsLink();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Edit link
		fieldValues = SubmittedPOFields.line1_EditLink();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Void link
		fieldValues = SubmittedPOFields.line1_VoidLink();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Markup Percentage
		fieldValues = SubmittedPOFields.line1_MarkupPercentageValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Customer
		fieldValues = SubmittedPOFields.line1_CustomerValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Vendor Name
		fieldValues = SubmittedPOFields.line1_VendorNameValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Attachments link
		fieldValues = SubmittedPOFields.line1_AttachmentsLink();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Edit link
		fieldValues = SubmittedPOFields.line1_EditLink();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Void link
		fieldValues = SubmittedPOFields.line1_VoidLink();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Line Item 2 saved fields, data
		// Saved Line Item 2 - Include
		fieldValues = SubmittedPOFields.line2_IncludeCheckbox();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Department
		fieldValues = SubmittedPOFields.line2_DepartmentValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Account
		fieldValues = SubmittedPOFields.line2_AccountValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Line of Service
		fieldValues = SubmittedPOFields.line2_LineOfServiceValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Amount
		fieldValues = SubmittedPOFields.line2_AmountValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Chartfield1
		fieldValues = SubmittedPOFields.line2_Chartfield1Value();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Description
		fieldValues = SubmittedPOFields.line2_DescriptionValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Receipt Date
		fieldValues = SubmittedPOFields.line2_ReceiptDateValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Accounting Date
		fieldValues = SubmittedPOFields.line2_AccountingDateValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Equipment
		fieldValues = SubmittedPOFields.line2_EquipmentValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Merchant
		fieldValues = SubmittedPOFields.line2_MerchantValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Attendees
		fieldValues = SubmittedPOFields.line2_AttendeesValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Project
		fieldValues = SubmittedPOFields.line2_ProjectValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Job
		fieldValues = SubmittedPOFields.line2_JobValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Reimbursable
		fieldValues = SubmittedPOFields.line2_ReimbursableValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Markup Percentage
		fieldValues = SubmittedPOFields.line2_MarkupPercentageValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Customer
		fieldValues = SubmittedPOFields.line2_CustomerValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Vendor Name
		fieldValues = SubmittedPOFields.line2_VendorNameValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Attachments link
		fieldValues = SubmittedPOFields.line2_AttachmentsLink();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Edit link
		fieldValues = SubmittedPOFields.line2_EditLink();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Void link
		fieldValues = SubmittedPOFields.line2_VoidLink();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Attachment input fields
		// Attachment file name entry
		fieldValues = SubmittedPOFields.attachmentFileNameEntryField();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Attachment upload button.
		fieldValues = SubmittedPOFields.attachmentUploadButton();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Attachment saved fields, data
		// Attachment list - name column
		fieldValues = SubmittedPOFields.attachmentFileNameDisplay();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Attachment list - description column
		fieldValues = SubmittedPOFields.attachmentFileDescriptionDisplay();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Attachment list - Line Association link
		fieldValues = SubmittedPOFields.attachmentFileAssociationLink();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Attachment list - delete link
		fieldValues = SubmittedPOFields.attachmentFileDeleteLink();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Attachment list - Folder Option
		fieldValues = SubmittedPOFields.attachmentFileFolderOption();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// e-voucher Invoice input fields
		// Invoice Date entry
		fieldValues = SubmittedPOFields.invoiceDateEntry();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Invoice Amount entry
		fieldValues = SubmittedPOFields.invoiceAmountEntry();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Status value
		fieldValues = SubmittedPOFields.statusValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Check date value
		fieldValues = SubmittedPOFields.checkDateValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Check/ACH# value
		fieldValues = SubmittedPOFields.checkACHNumberValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Notes entry
		fieldValues = SubmittedPOFields.notesEntry();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Invoice Number Entry
		fieldValues = SubmittedPOFields.invoiceNumberEntry();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Remittance Entry
		fieldValues = SubmittedPOFields.remittanceEntry();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Entry date value
		fieldValues = SubmittedPOFields.entryDateValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// e-voucher notes/history
		fieldValues = SubmittedPOFields.eVoucherNotesHistoryEntry();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// approval input fields
		// First Approval Department
		fieldValues = SubmittedPOFields.firstApprovalDepartment();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// First Approver selection
		fieldValues = SubmittedPOFields.firstApproverSelection();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// First Approval Status
		fieldValues = SubmittedPOFields.firstApprovalStatus();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Second Approval Department
		fieldValues = SubmittedPOFields.secondApprovalDepartment();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Second Approver selection
		fieldValues = SubmittedPOFields.secondApproverSelection();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Second Approval Status
		fieldValues = SubmittedPOFields.secondApprovalStatus();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Third Approval Department
		fieldValues = SubmittedPOFields.thirdApprovalDepartment();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Third Approver selection
		fieldValues = SubmittedPOFields.thirdApproverSelection();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Third Approval Status
		fieldValues = SubmittedPOFields.thirdApprovalStatus();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Print button
		fieldValues = SubmittedPOFields.printButton();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Save button
		fieldValues = SubmittedPOFields.saveButton();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Submit button
		fieldValues = SubmittedPOFields.submitForReviewButton();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Void button
		fieldValues = SubmittedPOFields.voidButton();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

	}

	public static void validateEmptyInvoiceOnSubmitErrorMessages(WebDriver driver, String[] poData,
			testingVars testVars, PrintWriter logfile) {

		// Empty Invoice Date on PO Submit
		FieldMaker fieldValues = SubmittedPOFields.invoiceDateEntry();
		checkSingleEmptyInvoiceErrorMessages(driver, fieldValues, testVars, logfile);

		// Empty Invoice Number on PO Submit
		fieldValues = SubmittedPOFields.invoiceNumberEntry();
		checkSingleEmptyInvoiceErrorMessages(driver, fieldValues, testVars, logfile);

		// Empty Invoice Amount on PO Submit
		fieldValues = SubmittedPOFields.invoiceAmountEntry();
		checkSingleEmptyInvoiceErrorMessages(driver, fieldValues, testVars, logfile);

		// Empty Remittance field on Submit
		fieldValues = SubmittedPOFields.remittanceEntry();
		checkSingleEmptyInvoiceErrorMessages(driver, fieldValues, testVars, logfile);

	}

	public static void checkSingleEmptyInvoiceErrorMessages(WebDriver driver, FieldMaker fieldValues,
			testingVars testVars, PrintWriter logfile) {
		if (driver.findElement(By.xpath(fieldValues.getTheXpath())).getText().isEmpty()) {
			int len = fieldValues.getRequiredFieldErrorText().length();
			if (driver.findElement(By.xpath(fieldValues.getErrorXPath())).getText().substring(0, len)
					.matches(fieldValues.getRequiredFieldErrorText())) {
				Utility.logger(logfile,
						"\tError message due to empty " + fieldValues.getFieldName() + " appears. PASS");
				++testVars.PassResult;
			} else {
				Utility.logger(logfile,
						"\tError message due to empty " + fieldValues.getFieldName() + " DOES NOT appear. FAIL");
				++testVars.FailResult;
			}
		}

	}

	public static void validateInvalidInvoiceOnSubmitErrorMessages(WebDriver driver, String[] poData,
			testingVars testVars, PrintWriter logfile) {
		// verify the error message that appears when the entered Invoice Amount is not
		// equal to the PO Total value.
		// verify the error message that appears when the entered Remittance Amount is
		// not equal to the PO Total value.

		FieldMaker totalValue = SubmittedPOFields.totalValue();
		String poTotal = driver.findElement(By.xpath(totalValue.getTheXpath())).getAttribute("value");

		FieldMaker invAmt = SubmittedPOFields.invoiceAmountEntry();
		FieldMaker remitAmt = SubmittedPOFields.remittanceEntry();

		if (!(driver.findElement(By.xpath(invAmt.getTheXpath())).getAttribute("value").matches(poTotal))) {
			checkInvalidInvoiceErrorMessages(driver, invAmt, testVars, logfile);
		}

		if (!(driver.findElement(By.xpath(remitAmt.getTheXpath())).getAttribute("value").matches(poTotal))) {
			checkInvalidInvoiceErrorMessages(driver, invAmt, testVars, logfile);
		}

	}

	public static void checkInvalidInvoiceErrorMessages(WebDriver driver, FieldMaker fieldValues, testingVars testVars,
			PrintWriter logfile) {
		int len = fieldValues.getRequiredFieldErrorText().length();
		if (driver.findElement(By.xpath(fieldValues.getErrorXPath())).getText().substring(0, len)
				.matches(fieldValues.getRequiredFieldErrorText())) {
			Utility.logger(logfile, "\tError message appears due to invalid " + fieldValues.getFieldName() + ". PASS");
			++testVars.PassResult;
		} else {
			Utility.logger(logfile, "\tError message DOES NOT appear due to invalid " + fieldValues.getFieldName()
					+ ". FAIL -----------------------------");
			++testVars.FailResult;
		}
	}

	public static void validateSubmittedInvoicedPO(WebDriver driver, String[] poData, testingVars testVars,
			PrintWriter logfile) {
		// an invoiced PO has just been submitted. Search for the PO and verify that it
		// is in 'Pending Approval' status.
		Utility.navigateToAPSearch(driver, testVars, logfile);
		driver.findElement(By.xpath(APSearchFields.clearButton().getTheXpath())).click();
		Utility.setAPSearchDropdown(driver, "status", "", 0, testVars, logfile);
		driver.findElement(By.xpath(APSearchFields.referenceNumberTextInput().getTheXpath())).sendKeys(poData[3]);
		driver.findElement(By.xpath(APSearchFields.advancedSearchButton().getTheXpath())).click();
		Utility.logger(logfile, "\tSearching by the Reference Number input field for Purchase Order " + poData[43]);
		Utility.waitABit(4);
		driver.findElement(By.xpath(APSearchFields.poSearchResultsLine1_ID().getTheXpath())).click();
		Utility.waitABit(4);

		// verify that the right Purchase Order comes up and that the status is 'Pending
		// Approval'.
		if (driver.findElement(By.xpath(SubmittedPOFields.purchaseOrderNumberValue().getTheXpath())).getText()
				.matches(poData[43])) {
			if (driver.findElement(By.xpath(SubmittedPOFields.statusValue().getTheXpath())).getText()
					.matches("PendingApproval")) {
				Utility.logger(logfile,
						"\tSubmission of PO with invoice results in a PO status of PendingApproval. PASS");
				++testVars.PassResult;
			} else {
				Utility.logger(logfile,
						"\tSubmission of PO with invoice DID NOT result in a PO status of PendingApproval. FAIL -----------------------------");
				++testVars.FailResult;
			}
		} else {
			Utility.logger(logfile, "\tCan't find the desired PO order. FAIL ---------------------");
			++testVars.FailResult;
		}
	}

	public static void validateFieldsExistOnPOPendingApproval(WebDriver driver, String[] poData, testingVars testVars,
			PrintWriter logfile) {
		Utility.logger(logfile, "\n\tValidate the existence of fields on the submitted Purchase Order detail page.");

		// Location, data
		FieldMaker fieldValues = SubmittedPOFields.locationValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// PO Number
		fieldValues = SubmittedPOFields.purchaseOrderNumberValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// PayKey
		fieldValues = SubmittedPOFields.payKeyValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// BackOrder number
		fieldValues = SubmittedPOFields.backOrderNumberValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Reference Number, data
		fieldValues = SubmittedPOFields.referenceNumberValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Vendor, data
		fieldValues = SubmittedPOFields.vendorValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// address
		fieldValues = SubmittedPOFields.address1ValueLabel();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		fieldValues = SubmittedPOFields.address2ValueLabel();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Purchase Order Date
		fieldValues = SubmittedPOFields.purchaseOrderDateValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Purchaser, data
		fieldValues = SubmittedPOFields.purchaserValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Terms
		fieldValues = SubmittedPOFields.termsValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Currency
		fieldValues = SubmittedPOFields.currencyValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Created By
		fieldValues = SubmittedPOFields.createdByValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Created On
		fieldValues = SubmittedPOFields.createdDateValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Approved By
		fieldValues = SubmittedPOFields.approvedByValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Approved On
		fieldValues = SubmittedPOFields.approvedDateValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Line Item 1 saved fields, data
		// Saved Line Item 1 - Include
		fieldValues = SubmittedPOFields.line1_IncludeCheckbox();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Department
		fieldValues = SubmittedPOFields.line1_DepartmentValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Account
		fieldValues = SubmittedPOFields.line1_AccountValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Line of Service
		fieldValues = SubmittedPOFields.line1_LineOfServiceValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Amount
		fieldValues = SubmittedPOFields.line1_AmountValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Chartfield1
		fieldValues = SubmittedPOFields.line1_Chartfield1Value();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Description, data
		fieldValues = SubmittedPOFields.line1_DescriptionValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Receipt Date
		fieldValues = SubmittedPOFields.line1_ReceiptDateValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Accounting Date
		fieldValues = SubmittedPOFields.line1_AccountingDateValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Equipment, data
		fieldValues = SubmittedPOFields.line1_EquipmentValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Merchant
		fieldValues = SubmittedPOFields.line1_MerchantValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Attendees
		fieldValues = SubmittedPOFields.line1_AttendeesValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Project, data
		fieldValues = SubmittedPOFields.line1_ProjectValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Job
		fieldValues = SubmittedPOFields.line1_JobValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Reimbursable
		fieldValues = SubmittedPOFields.line1_ReimbursableValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Markup Percentage
		fieldValues = SubmittedPOFields.line1_MarkupPercentageValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Customer
		fieldValues = SubmittedPOFields.line1_CustomerValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Vendor Name
		fieldValues = SubmittedPOFields.line1_VendorNameValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Attachments link
		fieldValues = SubmittedPOFields.line1_AttachmentsLink();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Markup Percentage
		fieldValues = SubmittedPOFields.line1_MarkupPercentageValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Customer
		fieldValues = SubmittedPOFields.line1_CustomerValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Vendor Name
		fieldValues = SubmittedPOFields.line1_VendorNameValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 1 - Attachments link
		fieldValues = SubmittedPOFields.line1_AttachmentsLink();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Line Item 2 saved fields, data
		// Saved Line Item 2 - Include
		fieldValues = SubmittedPOFields.line2_IncludeCheckbox();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Department
		fieldValues = SubmittedPOFields.line2_DepartmentValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Account
		fieldValues = SubmittedPOFields.line2_AccountValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Line of Service
		fieldValues = SubmittedPOFields.line2_LineOfServiceValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Amount
		fieldValues = SubmittedPOFields.line2_AmountValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Chartfield1
		fieldValues = SubmittedPOFields.line2_Chartfield1Value();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Description
		fieldValues = SubmittedPOFields.line2_DescriptionValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Receipt Date
		fieldValues = SubmittedPOFields.line2_ReceiptDateValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Accounting Date
		fieldValues = SubmittedPOFields.line2_AccountingDateValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Equipment
		fieldValues = SubmittedPOFields.line2_EquipmentValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Merchant
		fieldValues = SubmittedPOFields.line2_MerchantValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Attendees
		fieldValues = SubmittedPOFields.line2_AttendeesValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Project
		fieldValues = SubmittedPOFields.line2_ProjectValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Job
		fieldValues = SubmittedPOFields.line2_JobValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Reimbursable
		fieldValues = SubmittedPOFields.line2_ReimbursableValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Markup Percentage
		fieldValues = SubmittedPOFields.line2_MarkupPercentageValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Customer
		fieldValues = SubmittedPOFields.line2_CustomerValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Vendor Name
		fieldValues = SubmittedPOFields.line2_VendorNameValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Saved Line Item 2 - Attachments link
		fieldValues = SubmittedPOFields.line2_AttachmentsLink();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Attachment input fields
		// Attachment file name entry
		fieldValues = SubmittedPOFields.attachmentFileNameEntryField();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Attachment upload button.
		fieldValues = SubmittedPOFields.attachmentUploadButton();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Attachment saved fields, data
		// Attachment list - name column
		fieldValues = SubmittedPOFields.attachmentFileNameDisplay();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Attachment list - description column
		fieldValues = SubmittedPOFields.attachmentFileDescriptionDisplay();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Attachment list - Line Association link
		fieldValues = SubmittedPOFields.attachmentFileAssociationLink();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Attachment list - Folder Option
		fieldValues = SubmittedPOFields.attachmentFileFolderOption();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Invoice Amount entry
		fieldValues = SubmittedPOFields.invoiceAmountEntry();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Status value
		fieldValues = SubmittedPOFields.statusValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Check date value
		fieldValues = SubmittedPOFields.checkDateValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Check/ACH# value
		fieldValues = SubmittedPOFields.checkACHNumberValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Notes entry
		fieldValues = SubmittedPOFields.notesEntry();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Entry date value
		fieldValues = SubmittedPOFields.entryDateValue();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// e-voucher notes/history
		fieldValues = SubmittedPOFields.eVoucherNotesHistoryEntry();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// approval input fields
		// First Approval Department
		fieldValues = SubmittedPOFields.firstApprovalDepartment();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// First Approver selection
		fieldValues = SubmittedPOFields.firstApproverSelection();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// First Approval Status
		fieldValues = SubmittedPOFields.firstApprovalStatus();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Second Approval Department
		fieldValues = SubmittedPOFields.secondApprovalDepartment();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Second Approver selection
		fieldValues = SubmittedPOFields.secondApproverSelection();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Second Approval Status
		fieldValues = SubmittedPOFields.secondApprovalStatus();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Third Approval Department
		fieldValues = SubmittedPOFields.thirdApprovalDepartment();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Third Approver selection
		fieldValues = SubmittedPOFields.thirdApproverSelection();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Third Approval Status
		fieldValues = SubmittedPOFields.thirdApprovalStatus();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Print button
		fieldValues = SubmittedPOFields.printButton();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Approve button
		fieldValues = SubmittedPOFields.approveButton();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

		// Reject button
		fieldValues = SubmittedPOFields.rejectButton();
		Utility.verifyPageElement(driver, fieldValues, testVars, logfile);

	}

	public static void validateDataOnPOPendingApproval(WebDriver driver, String[] poData, testingVars testVars,
			PrintWriter logfile) {
		validateDataOnSubmittedNewPO(driver, poData, testVars, logfile);

		FieldMaker fieldValues = SubmittedPOFields.invoiceNumber();
		if (driver.findElement(By.xpath(fieldValues.getTheXpath())).getAttribute("value").matches(poData[45])) {
			Utility.logger(logfile, "\t" + fieldValues.getFieldName() + " matches the entered value. PASS");
			++testVars.PassResult;
		} else {
			Utility.logger(logfile,
					"\t" + fieldValues.getFieldName() + " DOES NOT match the entered value. FAIL ------------------");
			++testVars.FailResult;

		}

		fieldValues = SubmittedPOFields.invoiceDate();
		if (driver.findElement(By.xpath(fieldValues.getTheXpath())).getAttribute("value").matches(poData[44])) {
			Utility.logger(logfile, "\t" + fieldValues.getFieldName() + " matches the entered value. PASS");
			++testVars.PassResult;
		} else {
			Utility.logger(logfile,
					"\t" + fieldValues.getFieldName() + " DOES NOT match the entered value. FAIL ------------------");
			++testVars.FailResult;

		}

		fieldValues = SubmittedPOFields.invoiceAmount();
		if (driver.findElement(By.xpath(fieldValues.getTheXpath())).getAttribute("value").matches(poData[46])) {
			Utility.logger(logfile, "\t" + fieldValues.getFieldName() + " matches the entered value. PASS");
			++testVars.PassResult;
		} else {
			Utility.logger(logfile,
					"\t" + fieldValues.getFieldName() + " DOES NOT match the entered value. FAIL ------------------");
			++testVars.FailResult;

		}

		fieldValues = SubmittedPOFields.remittance();
		if (driver.findElement(By.xpath(fieldValues.getTheXpath())).getAttribute("value").matches(poData[47])) {
			Utility.logger(logfile, "\t" + fieldValues.getFieldName() + " matches the entered value. PASS");
			++testVars.PassResult;
		} else {
			Utility.logger(logfile,
					"\t" + fieldValues.getFieldName() + " DOES NOT match the entered value. FAIL ------------------");
			++testVars.FailResult;
		}
	}

	public static void validateDataOnApprovedPO(WebDriver driver, String[] poData, testingVars testVars,
			PrintWriter logfile) {
		validateDataOnPOPendingApproval(driver, poData, testVars, logfile);

		FieldMaker fieldValues = SubmittedPOFields.approvedPO_LevelData();
		if (driver.findElement(By.xpath(fieldValues.getTheXpath())).getText().matches("1")) {
			Utility.logger(logfile, "\t" + fieldValues.getFieldName() + " matches the expected value. PASS");
			++testVars.PassResult;
		} else {
			Utility.logger(logfile,
					"\t" + fieldValues.getFieldName() + " DOES NOT match the expected value. FAIL ------------------");
			++testVars.FailResult;
		}

		fieldValues = SubmittedPOFields.approvedPO_DepartmentData();
		if (driver.findElement(By.xpath(fieldValues.getTheXpath())).getText().matches(testVars.department)) {
			Utility.logger(logfile, "\t" + fieldValues.getFieldName() + " matches the expected value. PASS");
			++testVars.PassResult;
		} else {
			Utility.logger(logfile,
					"\t" + fieldValues.getFieldName() + " DOES NOT match the expected value. FAIL ------------------");
			++testVars.FailResult;
		}

		fieldValues = SubmittedPOFields.approvedPO_ApproverData();
		if (driver.findElement(By.xpath(fieldValues.getTheXpath())).getText().matches("DOBITEST10")) {
			Utility.logger(logfile, "\t" + fieldValues.getFieldName() + " matches the expected value. PASS");
			++testVars.PassResult;
		} else {
			Utility.logger(logfile,
					"\t" + fieldValues.getFieldName() + " DOES NOT match the expected value. FAIL ------------------");
			++testVars.FailResult;
		}

		fieldValues = SubmittedPOFields.approvedPO_StatusData();
		if (driver.findElement(By.xpath(fieldValues.getTheXpath())).getText().matches("Approved")) {
			Utility.logger(logfile, "\t" + fieldValues.getFieldName() + " matches the expected value. PASS");
			++testVars.PassResult;
		} else {
			Utility.logger(logfile,
					"\t" + fieldValues.getFieldName() + " DOES NOT match the expected value. FAIL ------------------");
			++testVars.FailResult;
		}

	}

	public static void validateDataOnRejectedPO(WebDriver driver, String[] poData, testingVars testVars,
			PrintWriter logfile) {
		validateDataOnSubmittedNewPO(driver, poData, testVars, logfile);
		validateDataInInvoiceInputFields(driver, poData, testVars, logfile);
	}

	public static void validateDataOnSubmittedNewPO(WebDriver driver, String[] poData, testingVars testVars,
			PrintWriter logfile) {
		Utility.logger(logfile,
				"\nValidate that the data populating the submitted purchase order page matches the originally entered data.");

		// Location, data
		FieldMaker fieldValues = SubmittedPOFields.locationValue();
		validateAPOField(driver, fieldValues, poData[2], false, testVars, logfile);

		// Reference Number, data
		fieldValues = SubmittedPOFields.referenceNumberValue();
		validateAPOField(driver, fieldValues, poData[3], false, testVars, logfile);

		// Vendor, data
		fieldValues = SubmittedPOFields.vendorValue();
		validateAPOField(driver, fieldValues, poData[5], false, testVars, logfile);

		// Purchaser, data
		fieldValues = SubmittedPOFields.purchaserValue();
		validateAPOField(driver, fieldValues, poData[8] + ", " + poData[9], false, testVars, logfile);

		// Saved Line Item 1 - Department
		fieldValues = SubmittedPOFields.line1_DepartmentValue();
		validateAPOField(driver, fieldValues, poData[12], false, testVars, logfile);

		// Saved Line Item 1 - Account
		fieldValues = SubmittedPOFields.line1_AccountValue();
		validateAPOField(driver, fieldValues, poData[13], false, testVars, logfile);

		// Saved Line Item 1 - Line of Service
		fieldValues = SubmittedPOFields.line1_LineOfServiceValue();
		validateAPOField(driver, fieldValues, poData[15], false, testVars, logfile);

		// Saved Line Item 1 - Amount
		fieldValues = SubmittedPOFields.line1_AmountValue();
		validateAPOField(driver, fieldValues,
				String.valueOf(Double.parseDouble(poData[25]) * Double.parseDouble(poData[26])), true, testVars,
				logfile);

		// Saved Line Item 1 - Description, data
		fieldValues = SubmittedPOFields.line1_DescriptionValue();
		validateAPOField(driver, fieldValues, poData[24], false, testVars, logfile);

		// Saved Line Item 1 - Equipment, data
		fieldValues = SubmittedPOFields.line1_EquipmentValue();
		validateAPOField(driver, fieldValues, poData[21], false, testVars, logfile);

		// Saved Line Item 1 - Project, data
		fieldValues = SubmittedPOFields.line1_ProjectValue();
		validateAPOField(driver, fieldValues, poData[18], false, testVars, logfile);

		// Saved Line Item 2 - Department
		fieldValues = SubmittedPOFields.line2_DepartmentValue();
		validateAPOField(driver, fieldValues, poData[28], false, testVars, logfile);

		// Saved Line Item 2 - Account
		fieldValues = SubmittedPOFields.line2_AccountValue();
		validateAPOField(driver, fieldValues, poData[29], false, testVars, logfile);

		// Saved Line Item 2 - Line of Service
		fieldValues = SubmittedPOFields.line2_LineOfServiceValue();
		validateAPOField(driver, fieldValues, poData[31], false, testVars, logfile);

		// Saved Line Item 2 - Amount
		fieldValues = SubmittedPOFields.line2_AmountValue();
		validateAPOField(driver, fieldValues,
				String.valueOf(Double.parseDouble(poData[41]) * Double.parseDouble(poData[42])), true, testVars,
				logfile);

		// Saved Line Item 2 - Description
		fieldValues = SubmittedPOFields.line2_DescriptionValue();
		validateAPOField(driver, fieldValues, poData[40], false, testVars, logfile);

		// Saved Line Item 2 - Equipment
		fieldValues = SubmittedPOFields.line2_EquipmentValue();
		validateAPOField(driver, fieldValues, poData[37], false, testVars, logfile);

		// Saved Line Item 2 - Project
		fieldValues = SubmittedPOFields.line2_ProjectValue();
		validateAPOField(driver, fieldValues, poData[34], false, testVars, logfile);

	}

	public static void validateDataInInvoiceInputFields(WebDriver driver, String[] poData, testingVars testVars,
			PrintWriter logfile) {
		// Invoice Date Entry
		FieldMaker fieldValues = SubmittedPOFields.invoiceDateEntry();
		validateAPEntryField(driver, fieldValues, poData[44], false, testVars, logfile);

		// Invoice Number Entry
		fieldValues = SubmittedPOFields.invoiceNumberEntry();
		validateAPEntryField(driver, fieldValues, poData[45], false, testVars, logfile);

		// Invoice Amount Entry
		fieldValues = SubmittedPOFields.invoiceAmountEntry();
		validateAPEntryField(driver, fieldValues, poData[46], false, testVars, logfile);

		// Remittance Entry
		fieldValues = SubmittedPOFields.remittanceEntry();
		validateAPEntryField(driver, fieldValues, poData[47], false, testVars, logfile);

		// Status value
		fieldValues = SubmittedPOFields.statusValue();
		validateAPOField(driver, fieldValues, "Open", false, testVars, logfile);

	}

}