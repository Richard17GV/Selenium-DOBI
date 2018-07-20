package testPack6;

import org.openqa.selenium.WebDriver;

public class AddEditPOFields {
	// This class is a factory for AddEditPO page field objects.

	public static FieldMaker referenceNumberTextInput() {
		FieldMaker referenceNumberField = new FieldMaker();
		referenceNumberField.setFieldName("Reference Number");
		referenceNumberField.setTheXpath("//*[@id='referenceNumberInput']");
		referenceNumberField.setxPathDescription(
				"'" + referenceNumberField.getFieldName() + "' input text field on the 'Add/Edit Purchase Order' page");
		return referenceNumberField;
	}

	public static FieldMaker vendorDropdown(WebDriver driver) {
		FieldMaker vendorDropdown = new FieldMaker();
		vendorDropdown.setFieldName("Vendor");
		vendorDropdown.setTheXpath("//*[@id='vendorWithEvent']");
		vendorDropdown.setDropDownSize(Utility.findDropdownSize(driver, "", "", vendorDropdown.getTheXpath()));
		vendorDropdown
				.setxPathDescription("'" + vendorDropdown.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		vendorDropdown.setErrorXPath("//*[@id='purchaseOrderForm.vendor.errors']");
		vendorDropdown.setRequiredFieldErrorText("Vendor is required");
		vendorDropdown.setRequiredFieldErrorBorderColor("#ff0000");
		vendorDropdown.setRequiredFieldErrorFieldColor("#ff0000");
		return vendorDropdown;
	}

	public static FieldMaker purchaseOrderDate() {
		FieldMaker purchaseOrderDate = new FieldMaker();
		purchaseOrderDate.setFieldName("Order Date");
		purchaseOrderDate.setTheXpath("//*[@id='purchaseOrderForm.purchaseDate']");
		purchaseOrderDate.setxPathDescription(
				"'" + purchaseOrderDate.getFieldName() + "' datepicker field on the 'Add/Edit Purchase Order' page");
		return purchaseOrderDate;
	}

	public static FieldMaker pODateMonthPicker() {
		FieldMaker pODateMonthPicker = new FieldMaker();
		pODateMonthPicker.setFieldName("Previous Month Arrow");
		pODateMonthPicker.setTheXpath("//*[@id='ui-datepicker-div']/div/a[1]/span");
		pODateMonthPicker.setxPathDescription(
				"'" + pODateMonthPicker.getFieldName() + "' datepicker field on the 'Add/Edit Purchase Order' page");
		return pODateMonthPicker;
	}

	public static FieldMaker pODateMonthDisplay() {
		FieldMaker pODateMonthDisplay = new FieldMaker();
		pODateMonthDisplay.setFieldName("Month in Datepicker");
		pODateMonthDisplay.setTheXpath("//*[@id='ui-datepicker-div']/div/div/span[1]");
		pODateMonthDisplay.setxPathDescription(
				"'" + pODateMonthDisplay.getFieldName() + "' datepicker field on the 'Add/Edit Purchase Order' page");
		return pODateMonthDisplay;
	}

	public static FieldMaker pODateYearDisplay() {
		FieldMaker pODateYearDisplay = new FieldMaker();
		pODateYearDisplay.setFieldName("Year in Datepicker");
		pODateYearDisplay.setTheXpath("//*[@id='ui-datepicker-div']/div/div/span[2]");
		pODateYearDisplay.setxPathDescription(
				"'" + pODateYearDisplay.getFieldName() + "' datepicker field on the 'Add/Edit Purchase Order' page");
		return pODateYearDisplay;
	}

	public static FieldMaker purchaserDropdown(WebDriver driver) {
		FieldMaker purchaserDropdown = new FieldMaker();
		purchaserDropdown.setFieldName("Purchaser");
		purchaserDropdown.setTheXpath("//*[@id='purchaseOrderForm.purchaser']");
		purchaserDropdown.setDropDownSize(Utility.findDropdownSize(driver, "", "", purchaserDropdown.getTheXpath()));
		purchaserDropdown.setxPathDescription(
				"'" + purchaserDropdown.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		purchaserDropdown.setErrorXPath("//*[@id='purchaseOrderForm.purchaser.errors']");
		purchaserDropdown.setRequiredFieldErrorText("Purchaser is required");
		purchaserDropdown.setRequiredFieldErrorBorderColor("#ff0000");
		purchaserDropdown.setRequiredFieldErrorFieldColor("#ff0000");
		return purchaserDropdown;
	}

	public static FieldMaker shipViaDropdown(WebDriver driver) {
		FieldMaker shipViaDropdown = new FieldMaker();
		shipViaDropdown.setFieldName("Ship Via");
		shipViaDropdown.setTheXpath("//*[@id='purchaseOrderForm.shipVia']");
		shipViaDropdown.setDropDownSize(Utility.findDropdownSize(driver, "", "", shipViaDropdown.getTheXpath()));
		shipViaDropdown
				.setxPathDescription("'" + shipViaDropdown.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return shipViaDropdown;
	}

	public static FieldMaker lineItem_DepartmentNumber(WebDriver driver) {
		FieldMaker lineItem_DepartmentNumber = new FieldMaker();
		lineItem_DepartmentNumber.setFieldName("Department");
		lineItem_DepartmentNumber.setTheXpath("//*[@id='departmentWithEvent']");
		lineItem_DepartmentNumber
				.setDropDownSize(Utility.findDropdownSize(driver, "", "", lineItem_DepartmentNumber.getTheXpath()));
		lineItem_DepartmentNumber.setxPathDescription(
				"'" + lineItem_DepartmentNumber.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return lineItem_DepartmentNumber;
	}

	public static FieldMaker lineItem_Account(WebDriver driver) {
		FieldMaker lineItem_Account = new FieldMaker();
		lineItem_Account.setFieldName("Account");
		lineItem_Account.setTheXpath("//*[@id='accountWithEvent']");
		lineItem_Account.setDropDownSize(Utility.findDropdownSize(driver, "", "", lineItem_Account.getTheXpath()));
		lineItem_Account
				.setxPathDescription("'" + lineItem_Account.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return lineItem_Account;
	}

	public static FieldMaker lineItem_LineOfService(WebDriver driver) {
		FieldMaker lineItem_LineOfService = new FieldMaker();
		lineItem_LineOfService.setFieldName("Line of Service");
		lineItem_LineOfService.setTheXpath("//*[@id='lineOfService']");
		lineItem_LineOfService
				.setDropDownSize(Utility.findDropdownSize(driver, "", "", lineItem_LineOfService.getTheXpath()));
		lineItem_LineOfService.setxPathDescription(
				"'" + lineItem_LineOfService.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return lineItem_LineOfService;
	}

	public static FieldMaker lineItem_Chartfield1(WebDriver driver) {
		FieldMaker lineItem_Chartfield1 = new FieldMaker();
		lineItem_Chartfield1.setFieldName("Chartfield1");
		lineItem_Chartfield1.setTheXpath("//*[@id='chartfield1WithEvent']");
		lineItem_Chartfield1
				.setDropDownSize(Utility.findDropdownSize(driver, "", "", lineItem_Chartfield1.getTheXpath()));
		lineItem_Chartfield1.setxPathDescription(
				"'" + lineItem_Chartfield1.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return lineItem_Chartfield1;
	}

	public static FieldMaker lineItem_Project(WebDriver driver) {
		FieldMaker lineItem_Project = new FieldMaker();
		lineItem_Project.setFieldName("Project");
		lineItem_Project.setTheXpath("//*[@id='projectWithEvent']");
		lineItem_Project.setDropDownSize(Utility.findDropdownSize(driver, "", "", lineItem_Project.getTheXpath()));
		lineItem_Project
				.setxPathDescription("'" + lineItem_Project.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return lineItem_Project;
	}

	public static FieldMaker lineItem_Job(WebDriver driver) {
		FieldMaker lineItem_Job = new FieldMaker();
		lineItem_Job.setFieldName("Job");
		lineItem_Job.setTheXpath("//*[@id='jobWithEvent']");
		lineItem_Job.setDropDownSize(Utility.findDropdownSize(driver, "", "", lineItem_Job.getTheXpath()));
		lineItem_Job.setxPathDescription("'" + lineItem_Job.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return lineItem_Job;
	}

	public static FieldMaker lineItem_Equipment(WebDriver driver) {
		FieldMaker lineItem_Equipment = new FieldMaker();
		lineItem_Equipment.setFieldName("Equipment");
		lineItem_Equipment.setTheXpath("//*[@id='equipmentWithEvent']");
		lineItem_Equipment.setDropDownSize(Utility.findDropdownSize(driver, "", "", lineItem_Equipment.getTheXpath()));
		lineItem_Equipment.setxPathDescription(
				"'" + lineItem_Equipment.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return lineItem_Equipment;
	}

	public static FieldMaker lineItem_Reimbursable() {
		FieldMaker lineItem_Reimbursable = new FieldMaker();
		lineItem_Reimbursable.setFieldName("Reimbursable");
		lineItem_Reimbursable.setTheXpath("//*[@id='isReimbursable']");
		lineItem_Reimbursable.setxPathDescription(
				"'" + lineItem_Reimbursable.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return lineItem_Reimbursable;
	}

	public static FieldMaker lineItem_PartNumber() {
		FieldMaker lineItem_PartNumber = new FieldMaker();
		lineItem_PartNumber.setFieldName("Part Number");
		lineItem_PartNumber.setTheXpath("//*[@id='partNumber']");
		lineItem_PartNumber.setxPathDescription(
				"'" + lineItem_PartNumber.getFieldName() + "' input text field on the 'Add/Edit Purchase Order' page");
		return lineItem_PartNumber;
	}

	public static FieldMaker lineItem_Description() {
		FieldMaker lineItem_Description = new FieldMaker();
		lineItem_Description.setFieldName("Description");
		lineItem_Description.setTheXpath("//*[@id='description']");
		lineItem_Description.setxPathDescription(
				"'" + lineItem_Description.getFieldName() + "' input text field on the 'Add/Edit Purchase Order' page");
		lineItem_Description.setRequiredFieldErrorBorderColor("#ff0000");
		lineItem_Description.setRequiredFieldErrorFieldColor("#ff0000");
		return lineItem_Description;
	}

	public static FieldMaker lineItem_Quantity() {
		FieldMaker lineItem_Quantity = new FieldMaker();
		lineItem_Quantity.setFieldName("Quantity");
		lineItem_Quantity.setTheXpath("//*[@id='quantity']");
		lineItem_Quantity.setxPathDescription(
				"'" + lineItem_Quantity.getFieldName() + "' input text field on the 'Add/Edit Purchase Order' page");
		lineItem_Quantity.setRequiredFieldErrorBorderColor("#ff0000");
		lineItem_Quantity.setRequiredFieldErrorFieldColor("#ff0000");
		return lineItem_Quantity;
	}

	public static FieldMaker lineItem_UnitCost() {
		FieldMaker lineItem_UnitCost = new FieldMaker();
		lineItem_UnitCost.setFieldName("Unit Cost");
		lineItem_UnitCost.setTheXpath("//*[@id='unitPrice']");
		lineItem_UnitCost.setxPathDescription(
				"'" + lineItem_UnitCost.getFieldName() + "' input text field on the 'Add/Edit Purchase Order' page");
		lineItem_UnitCost.setRequiredFieldErrorBorderColor("#ff0000");
		lineItem_UnitCost.setRequiredFieldErrorFieldColor("#ff0000");
		return lineItem_UnitCost;
	}

	public static FieldMaker addPO_PageTitle() {
		FieldMaker addPO_PageTitle = new FieldMaker();
		addPO_PageTitle.setFieldName("Add/Edit Purchase Order page title");
		addPO_PageTitle
				.setTheXpath("//div[@class='section-title' and normalize-space(.//text())='Add/Edit Purchase Order']");
		addPO_PageTitle.setxPathDescription(
				"'" + addPO_PageTitle.getFieldName() + "' input text field on the 'Add/Edit Purchase Order' page");
		return addPO_PageTitle;
	}

	public static FieldMaker regularLabel() {
		FieldMaker regularLabel = new FieldMaker();
		regularLabel.setFieldName("'Regular' label");
		regularLabel.setTheXpath("//*[@id='main-content']/section/div[2]/div[1 and normalize-space(text())='Regular']");
		regularLabel.setxPathDescription(
				"'" + regularLabel.getFieldName() + "' input text field on the 'Add/Edit Purchase Order' page");
		return regularLabel;
	}

	public static FieldMaker locationLabel() {
		FieldMaker locationLabel = new FieldMaker();
		locationLabel.setFieldName("'Location' label");
		locationLabel.setTheXpath(
				"//*[@id='purchaseOrderInputForm']/div[1]/table/tbody/tr[1]/td[1 and normalize-space(text())='Location:']");
		locationLabel.setxPathDescription(
				"'" + locationLabel.getFieldName() + "' input text field on the 'Add/Edit Purchase Order' page");
		return locationLabel;
	}

	public static FieldMaker locationValue() {
		FieldMaker locationValue = new FieldMaker();
		locationValue.setFieldName("Location value");
		locationValue.setTheXpath("//*[@id='purchaseOrderInputForm']/div[1]/table/tbody/tr[1]/td[2]");
		locationValue.setxPathDescription(
				"'" + locationValue.getFieldName() + "' input text field on the 'Add/Edit Purchase Order' page");
		return locationValue;
	}

	public static FieldMaker purchaseOrderNumberLabel() {
		FieldMaker purchaseOrderNumberLabel = new FieldMaker();
		purchaseOrderNumberLabel.setFieldName("Purchase Order Number label");
		purchaseOrderNumberLabel.setTheXpath(
				"//*[@id='purchaseOrderInputForm']/div[1]/table/tbody/tr[2]/td[1 and normalize-space(text())='Purchase Order Number:']");
		purchaseOrderNumberLabel.setxPathDescription("'" + purchaseOrderNumberLabel.getFieldName()
				+ "' input text field on the 'Add/Edit Purchase Order' page");
		return purchaseOrderNumberLabel;
	}

	public static FieldMaker purchaseOrderNumberValue() {
		FieldMaker purchaseOrderNumberValue = new FieldMaker();
		purchaseOrderNumberValue.setFieldName("Purchase Order Number value");
		purchaseOrderNumberValue.setTheXpath("//*[@id='purchaseOrderInputForm']/div[1]/table/tbody/tr[2]/td[2]");
		purchaseOrderNumberValue.setxPathDescription(
				"'" + purchaseOrderNumberValue.getFieldName() + "' data value on the 'Add/Edit Purchase Order' page");
		return purchaseOrderNumberValue;
	}

	public static FieldMaker referenceNumberLabel() {
		FieldMaker referenceNumberLabel = new FieldMaker();
		referenceNumberLabel.setFieldName("Reference Number label");
		referenceNumberLabel.setTheXpath(
				"//*[@id='purchaseOrderInputForm']/div[1]/table/tbody/tr[3]/td[1 and normalize-space(text())='Reference Number:']");
		referenceNumberLabel.setxPathDescription(
				"'" + referenceNumberLabel.getFieldName() + "' input text field on the 'Add/Edit Purchase Order' page");
		return referenceNumberLabel;
	}

	public static FieldMaker referenceNumberValueLabel() {
		FieldMaker referenceNumberValueLabel = new FieldMaker();
		referenceNumberValueLabel.setFieldName("Reference Number value data");
		referenceNumberValueLabel.setTheXpath("//*[@id='purchaseOrderInputForm']/div[1]/table/tbody/tr[3]/td[2]");
		referenceNumberValueLabel.setxPathDescription(
				"'" + referenceNumberValueLabel.getFieldName() + "' data value on the 'Add/Edit Purchase Order' page");
		return referenceNumberValueLabel;
	}

	public static FieldMaker vendorLabel() {
		FieldMaker vendorLabel = new FieldMaker();
		vendorLabel.setFieldName("Vendor label");
		vendorLabel.setTheXpath(
				"//*[@id='purchaseOrderInputForm']/div[1]/table/tbody/tr[4]/td[1 and normalize-space(text())='Vendor:']");
		vendorLabel.setxPathDescription(
				"'" + vendorLabel.getFieldName() + "' input text field on the 'Add/Edit Purchase Order' page");
		return vendorLabel;
	}

	public static FieldMaker vendorValueLabel() {
		FieldMaker vendorValueLabel = new FieldMaker();
		vendorValueLabel.setFieldName("Vendor Data Value");
		vendorValueLabel.setTheXpath("//*[@id='purchaseOrderInputForm']/div[1]/table/tbody/tr[4]/td[2]");
		vendorValueLabel.setxPathDescription(
				"'" + vendorValueLabel.getFieldName() + "' data value on the 'Add/Edit Purchase Order' page");
		return vendorValueLabel;
	}

	public static FieldMaker addressLabel() {
		FieldMaker addressLabel = new FieldMaker();
		addressLabel.setFieldName("Address label");
		addressLabel.setTheXpath(
				"//*[@id='purchaseOrderInputForm']/div[1]/table/tbody/tr[5]/td[1 and normalize-space(text())='Address:']");
		addressLabel.setxPathDescription(
				"'" + addressLabel.getFieldName() + "' input text field on the 'Add/Edit Purchase Order' page");
		return addressLabel;
	}

	public static FieldMaker address1ValueLabel() {
		FieldMaker address1ValueLabel = new FieldMaker();
		address1ValueLabel.setFieldName("Address1 Value data");
		address1ValueLabel.setTheXpath("//*[@id=\"address1Cell\"]/text()");
		address1ValueLabel.setxPathDescription(
				"'" + address1ValueLabel.getFieldName() + "' data value on the 'Add/Edit Purchase Order' page");
		return address1ValueLabel;
	}

	public static FieldMaker address2ValueLabel() {
		FieldMaker address2ValueLabel = new FieldMaker();
		address2ValueLabel.setFieldName("Address2 Value data");
		address2ValueLabel.setTheXpath("//*[@id=\"address2Cell\"]/text()");
		address2ValueLabel.setxPathDescription(
				"'" + address2ValueLabel.getFieldName() + "' data value on the 'Add/Edit Purchase Order' page");
		return address2ValueLabel;
	}

	public static FieldMaker purchaseOrderDateLabel() {
		FieldMaker purchaseOrderDateLabel = new FieldMaker();
		purchaseOrderDateLabel.setFieldName("Purchase Order Date label");
		purchaseOrderDateLabel.setTheXpath(
				"//*[@id='purchaseOrderInputForm']/div[1]/table/tbody/tr[6]/td[1 and normalize-space(text())='Purchase Order Date:']");
		purchaseOrderDateLabel.setxPathDescription("'" + purchaseOrderDateLabel.getFieldName()
				+ "' input text field on the 'Add/Edit Purchase Order' page");
		return purchaseOrderDateLabel;
	}

	public static FieldMaker purchaseOrderDateValueLabel() {
		FieldMaker purchaseOrderDateValueLabel = new FieldMaker();
		purchaseOrderDateValueLabel.setFieldName("Purchase Order Date Value Data");
		purchaseOrderDateValueLabel.setTheXpath("//*[@id='purchaseOrderInputForm']/div[1]/table/tbody/tr[6]/td[2]");
		purchaseOrderDateValueLabel.setxPathDescription(
				"'" + purchaseOrderDateValueLabel.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return purchaseOrderDateValueLabel;
	}

	public static FieldMaker purchaserLabel() {
		FieldMaker purchaserLabel = new FieldMaker();
		purchaserLabel.setFieldName("Purchaser label");
		purchaserLabel.setTheXpath(
				"//*[@id='purchaseOrderInputForm']/div[1]/table/tbody/tr[6]/td[3 and normalize-space(text())='Purchaser:']");
		purchaserLabel.setxPathDescription(
				"'" + purchaserLabel.getFieldName() + "' input text field on the 'Add/Edit Purchase Order' page");
		return purchaserLabel;
	}

	public static FieldMaker purchaserValueLabel() {
		FieldMaker purchaserValueLabel = new FieldMaker();
		purchaserValueLabel.setFieldName("Purchaser value data");
		purchaserValueLabel.setTheXpath("//*[@id='purchaseOrderInputForm']/div[1]/table/tbody/tr[6]/td[4]");
		purchaserValueLabel.setxPathDescription(
				"'" + purchaserValueLabel.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return purchaserValueLabel;
	}

	public static FieldMaker vendorTermsValueLabel() {
		FieldMaker vendorTermsValueLabel = new FieldMaker();
		vendorTermsValueLabel.setFieldName("Vendor Terms value data");
		vendorTermsValueLabel.setTheXpath("//*[@id='vendorTerms']");
		vendorTermsValueLabel.setxPathDescription(
				"'" + vendorTermsValueLabel.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return vendorTermsValueLabel;
	}

	public static FieldMaker currencyValueLabel() {
		FieldMaker currencyValueLabel = new FieldMaker();
		currencyValueLabel.setFieldName("Currency Type value data");
		currencyValueLabel.setTheXpath("//*[@id='currencyCode']");
		currencyValueLabel.setxPathDescription(
				"'" + currencyValueLabel.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return currencyValueLabel;
	}

	public static FieldMaker shipViaLabel() {
		FieldMaker shipViaLabel = new FieldMaker();
		shipViaLabel.setFieldName("Ship via label");
		shipViaLabel.setTheXpath(
				"//*[@id='purchaseOrderInputForm']/div[1]/table/tbody/tr[7]/td[1 and normalize-space(text())='Ship via:']");
		shipViaLabel.setxPathDescription(
				"'" + shipViaLabel.getFieldName() + "' input text field on the 'Add/Edit Purchase Order' page");
		return shipViaLabel;
	}

	public static FieldMaker shipViaValueLabel() {
		FieldMaker shipViaValueLabel = new FieldMaker();
		shipViaValueLabel.setFieldName("Ship via value data");
		shipViaValueLabel.setTheXpath("//*[@id='purchaseOrderInputForm']/div[1]/table/tbody/tr[7]/td[2]");
		shipViaValueLabel.setxPathDescription(
				"'" + shipViaValueLabel.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return shipViaValueLabel;
	}

	public static FieldMaker createdByLabel() {
		FieldMaker createdByLabel = new FieldMaker();
		createdByLabel.setFieldName("Created By label");
		createdByLabel.setTheXpath(
				"//*[@id='purchaseOrderInputForm']/div[1]/table/tbody/tr[7]/td[3 and normalize-space(text())='Created By:']");
		createdByLabel.setxPathDescription(
				"'" + createdByLabel.getFieldName() + "' input text field on the 'Add/Edit Purchase Order' page");
		return createdByLabel;
	}

	public static FieldMaker createdByValue() {
		FieldMaker createdByValue = new FieldMaker();
		createdByValue.setFieldName("Created By value data");
		createdByValue.setTheXpath("//*[@id='purchaseOrderInputForm']/div[1]/table/tbody/tr[7]/td[4]");
		createdByValue
				.setxPathDescription("'" + createdByValue.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return createdByValue;
	}

	public static FieldMaker poLineItemsSectionTitle() {
		FieldMaker poLineItemsSectionTitle = new FieldMaker();
		poLineItemsSectionTitle.setFieldName("Purchase Order Line Items section title");
		poLineItemsSectionTitle.setTheXpath(
				"//*[@id='purchaseOrderInputForm']/div[2 and normalize-space(.//text())='Purchase Order Line Items']");
		poLineItemsSectionTitle.setxPathDescription("'" + poLineItemsSectionTitle.getFieldName()
				+ "' input text field on the 'Add/Edit Purchase Order' page");
		return poLineItemsSectionTitle;
	}

	public static FieldMaker accountInfoTitle() {
		FieldMaker accountInfoTitle = new FieldMaker();
		accountInfoTitle.setFieldName("Account Info section title");
		accountInfoTitle.setTheXpath("//*[@id='accountInfo' and normalize-space(text())='AccountInfo:']");
		accountInfoTitle.setxPathDescription(
				"'" + accountInfoTitle.getFieldName() + "' input text field on the 'Add/Edit Purchase Order' page");
		return accountInfoTitle;
	}

	public static FieldMaker line1DepartmentValue() {
		FieldMaker line1DepartmentValue = new FieldMaker();
		line1DepartmentValue.setFieldName("Line 1: Department");
		line1DepartmentValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[1]/td[1]");
		line1DepartmentValue.setxPathDescription(
				"'" + line1DepartmentValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line1DepartmentValue;
	}

	public static FieldMaker line1AccountValue() {
		FieldMaker line1AccountValue = new FieldMaker();
		line1AccountValue.setFieldName("Line 1: Account");
		line1AccountValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[1]/td[2]");
		line1AccountValue.setxPathDescription(
				"'" + line1AccountValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line1AccountValue;
	}

	public static FieldMaker line1LoSValue() {
		FieldMaker line1LoSValue = new FieldMaker();
		line1LoSValue.setFieldName("Line 1: Line of Service");
		line1LoSValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[1]/td[3]");
		line1LoSValue.setxPathDescription(
				"'" + line1LoSValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line1LoSValue;
	}

	public static FieldMaker line1Chartfield1Value() {
		FieldMaker line1Chartfield1Value = new FieldMaker();
		line1Chartfield1Value.setFieldName("Line 1: Chartfield1");
		line1Chartfield1Value.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[1]/td[4]");
		line1Chartfield1Value.setxPathDescription(
				"'" + line1Chartfield1Value.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line1Chartfield1Value;
	}

	public static FieldMaker line1ProjectValue() {
		FieldMaker line1ProjectValue = new FieldMaker();
		line1ProjectValue.setFieldName("Line 1: Project");
		line1ProjectValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[1]/td[5]");
		line1ProjectValue.setxPathDescription(
				"'" + line1ProjectValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line1ProjectValue;
	}

	public static FieldMaker line1JobValue() {
		FieldMaker line1JobValue = new FieldMaker();
		line1JobValue.setFieldName("Line 1: Job");
		line1JobValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[1]/td[6]");
		line1JobValue.setxPathDescription(
				"'" + line1JobValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line1JobValue;
	}

	public static FieldMaker line1EquipmentValue() {
		FieldMaker line1EquipmentValue = new FieldMaker();
		line1EquipmentValue.setFieldName("Line 1: Equipment");
		line1EquipmentValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[1]/td[7]");
		line1EquipmentValue.setxPathDescription(
				"'" + line1EquipmentValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line1EquipmentValue;
	}

	public static FieldMaker line1ServiceDate() {
		FieldMaker line1ServiceDate = new FieldMaker();
		line1ServiceDate.setFieldName("Line 1: ReImbursable");
		line1ServiceDate.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[1]/td[8]");
		line1ServiceDate.setxPathDescription(
				"'" + line1ServiceDate.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line1ServiceDate;
	}

	public static FieldMaker line1ReImbursableValue() {
		FieldMaker line1ReImbursableValue = new FieldMaker();
		line1ReImbursableValue.setFieldName("Line 1: ReImbursable");
		line1ReImbursableValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[1]/td[9]");
		line1ReImbursableValue.setxPathDescription(
				"'" + line1ReImbursableValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line1ReImbursableValue;
	}

	public static FieldMaker line1PartNumberValue() {
		FieldMaker line1PartNumberValue = new FieldMaker();
		line1PartNumberValue.setFieldName("Line 1: Part Number");
		line1PartNumberValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[1]/td[10]");
		line1PartNumberValue.setxPathDescription(
				"'" + line1PartNumberValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line1PartNumberValue;
	}

	public static FieldMaker line1DescriptionValue() {
		FieldMaker line1DescriptionValue = new FieldMaker();
		line1DescriptionValue.setFieldName("Line 1: Description");
		line1DescriptionValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[1]/td[11]");
		line1DescriptionValue.setxPathDescription(
				"'" + line1DescriptionValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line1DescriptionValue;
	}

	public static FieldMaker line1QuantityValue() {
		FieldMaker line1QuantityValue = new FieldMaker();
		line1QuantityValue.setFieldName("Line 1: Quantity");
		line1QuantityValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[1]/td[12]");
		line1QuantityValue.setxPathDescription(
				"'" + line1QuantityValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line1QuantityValue;
	}

	public static FieldMaker line1UnitCostValue() {
		FieldMaker line1UnitCostValue = new FieldMaker();
		line1UnitCostValue.setFieldName("Line 1: Unit Cost");
		line1UnitCostValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[1]/td[13]");
		line1UnitCostValue.setxPathDescription(
				"'" + line1UnitCostValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line1UnitCostValue;
	}

	public static FieldMaker line1CalcExtCostValue() {
		FieldMaker line1CalcExtCostValue = new FieldMaker();
		line1CalcExtCostValue.setFieldName("Line 1: Calc Ext Cost");
		line1CalcExtCostValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[1]/td[14]");
		line1CalcExtCostValue.setxPathDescription(
				"'" + line1CalcExtCostValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line1CalcExtCostValue;
	}

	public static FieldMaker line1AttachmentsValue() {
		FieldMaker line1AttachmentsValue = new FieldMaker();
		line1AttachmentsValue.setFieldName("Line 1: Chartfield1");
		line1AttachmentsValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[1]/td[15]");
		line1AttachmentsValue.setxPathDescription(
				"'" + line1AttachmentsValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line1AttachmentsValue;
	}

	public static FieldMaker line1_VoidLink() {
		FieldMaker line1_VoidLink = new FieldMaker();
		line1_VoidLink.setFieldName("Line 1 Void Link");
		line1_VoidLink.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[1]/td[16]/span/a");
		line1_VoidLink
				.setxPathDescription("'" + line1_VoidLink.getFieldName() + "' on the submitted purchase order page");
		return line1_VoidLink;
	}

	public static FieldMaker line2_VoidLink() {
		FieldMaker line2_VoidLink = new FieldMaker();
		line2_VoidLink.setFieldName("Line 2 Void Link");
		line2_VoidLink.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[2]/td[16]/span/a");
		line2_VoidLink
				.setxPathDescription("'" + line2_VoidLink.getFieldName() + "' on the submitted purchase order page");
		return line2_VoidLink;
	}

	public static FieldMaker line1_VoidState() {
		FieldMaker line1_VoidLink = new FieldMaker();
		line1_VoidLink.setFieldName("Line 1 Void Link");
		line1_VoidLink.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[1]/td[16]");
		line1_VoidLink
				.setxPathDescription("'" + line1_VoidLink.getFieldName() + "' on the submitted purchase order page");
		return line1_VoidLink;
	}

	public static FieldMaker line2_VoidState() {
		FieldMaker line2_VoidLink = new FieldMaker();
		line2_VoidLink.setFieldName("Line 2 Void Link");
		line2_VoidLink.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[2]/td[16]");
		line2_VoidLink
				.setxPathDescription("'" + line2_VoidLink.getFieldName() + "' on the submitted purchase order page");
		return line2_VoidLink;
	}

	public static FieldMaker line2DepartmentValue() {
		FieldMaker line2DepartmentValue = new FieldMaker();
		line2DepartmentValue.setFieldName("Line 2: Department");
		line2DepartmentValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[2]/td[1]");
		line2DepartmentValue.setxPathDescription(
				"'" + line2DepartmentValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line2DepartmentValue;
	}

	public static FieldMaker line2AccountValue() {
		FieldMaker line2AccountValue = new FieldMaker();
		line2AccountValue.setFieldName("Line 2: Account");
		line2AccountValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[2]/td[2]");
		line2AccountValue.setxPathDescription(
				"'" + line2AccountValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line2AccountValue;
	}

	public static FieldMaker line2LoSValue() {
		FieldMaker line2LoSValue = new FieldMaker();
		line2LoSValue.setFieldName("Line 2: Line of Service");
		line2LoSValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[2]/td[3]");
		line2LoSValue.setxPathDescription(
				"'" + line2LoSValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line2LoSValue;
	}

	public static FieldMaker line2Chartfield1Value() {
		FieldMaker line2Chartfield1Value = new FieldMaker();
		line2Chartfield1Value.setFieldName("Line 2: Chartfield1");
		line2Chartfield1Value.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[2]/td[4]");
		line2Chartfield1Value.setxPathDescription(
				"'" + line2Chartfield1Value.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line2Chartfield1Value;
	}

	public static FieldMaker line2ProjectValue() {
		FieldMaker line2ProjectValue = new FieldMaker();
		line2ProjectValue.setFieldName("Line 2: Project");
		line2ProjectValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[2]/td[5]");
		line2ProjectValue.setxPathDescription(
				"'" + line2ProjectValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line2ProjectValue;
	}

	public static FieldMaker line2JobValue() {
		FieldMaker line2JobValue = new FieldMaker();
		line2JobValue.setFieldName("Line 2: Job");
		line2JobValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[2]/td[6]");
		line2JobValue.setxPathDescription(
				"'" + line2JobValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line2JobValue;
	}

	public static FieldMaker line2EquipmentValue() {
		FieldMaker line2EquipmentValue = new FieldMaker();
		line2EquipmentValue.setFieldName("Line 2: Equipment");
		line2EquipmentValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[2]/td[7]");
		line2EquipmentValue.setxPathDescription(
				"'" + line2EquipmentValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line2EquipmentValue;
	}

	public static FieldMaker line2ServiceDate() {
		FieldMaker line2ServiceDate = new FieldMaker();
		line2ServiceDate.setFieldName("Line 1: ReImbursable");
		line2ServiceDate.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[2]/td[8]");
		line2ServiceDate.setxPathDescription(
				"'" + line2ServiceDate.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line2ServiceDate;
	}

	public static FieldMaker line2ReImbursableValue() {
		FieldMaker line2ReImbursableValue = new FieldMaker();
		line2ReImbursableValue.setFieldName("Line 2: ReImbursable");
		line2ReImbursableValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[2]/td[9]");
		line2ReImbursableValue.setxPathDescription(
				"'" + line2ReImbursableValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line2ReImbursableValue;
	}

	public static FieldMaker line2PartNumberValue() {
		FieldMaker line2PartNumberValue = new FieldMaker();
		line2PartNumberValue.setFieldName("Line 2: Part Number");
		line2PartNumberValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[2]/td[10]");
		line2PartNumberValue.setxPathDescription(
				"'" + line2PartNumberValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line2PartNumberValue;
	}

	public static FieldMaker line2DescriptionValue() {
		FieldMaker line2DescriptionValue = new FieldMaker();
		line2DescriptionValue.setFieldName("Line 2: Description");
		line2DescriptionValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[2]/td[11]");
		line2DescriptionValue.setxPathDescription(
				"'" + line2DescriptionValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line2DescriptionValue;
	}

	public static FieldMaker line2QuantityValue() {
		FieldMaker line2QuantityValue = new FieldMaker();
		line2QuantityValue.setFieldName("Line 2: Quantity");
		line2QuantityValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[2]/td[12]");
		line2QuantityValue.setxPathDescription(
				"'" + line2QuantityValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line2QuantityValue;
	}

	public static FieldMaker line2UnitCostValue() {
		FieldMaker line2UnitCostValue = new FieldMaker();
		line2UnitCostValue.setFieldName("Line 2: Unit Cost");
		line2UnitCostValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[2]/td[13]");
		line2UnitCostValue.setxPathDescription(
				"'" + line2UnitCostValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line2UnitCostValue;
	}

	public static FieldMaker line2CalcExtCostValue() {
		FieldMaker line2CalcExtCostValue = new FieldMaker();
		line2CalcExtCostValue.setFieldName("Line 2: Calc Ext Cost");
		line2CalcExtCostValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[2]/td[14]");
		line2CalcExtCostValue.setxPathDescription(
				"'" + line2CalcExtCostValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line2CalcExtCostValue;
	}

	public static FieldMaker line2AttachmentsValue() {
		FieldMaker line2AttachmentsValue = new FieldMaker();
		line2AttachmentsValue.setFieldName("Line 2: Attachments");
		line2AttachmentsValue.setTheXpath("//div[@id='purchaseOrderLineItemList']/table/tbody/tr[2]/td[15]");
		line2AttachmentsValue.setxPathDescription(
				"'" + line2AttachmentsValue.getFieldName() + "' data on the 'Add/Edit Purchase Order' page");
		return line2AttachmentsValue;
	}

	public static FieldMaker totalLabel() {
		FieldMaker totalLabel = new FieldMaker();
		totalLabel.setFieldName("Total label");
		totalLabel.setTheXpath("//*[@id='total']/table/tbody/tr[1]/td[1 and normalize-space(text())='Total:']");
		totalLabel.setxPathDescription(
				"'" + totalLabel.getFieldName() + "' input text field on the 'Add/Edit Purchase Order' page");
		return totalLabel;
	}

	public static FieldMaker totalValue() {
		FieldMaker totalValue = new FieldMaker();
		totalValue.setFieldName("Total value placeholder");
		totalValue.setTheXpath("//*[@id='total']/table/tbody/tr[1]/td[2]");
		totalValue.setxPathDescription(
				"'" + totalValue.getFieldName() + "' input text field on the 'Add/Edit Purchase Order' page");
		return totalValue;
	}

	public static FieldMaker statusLabel() {
		FieldMaker statusLabel = new FieldMaker();
		statusLabel.setFieldName("Status label");
		statusLabel.setTheXpath("//*[@id='total']/table/tbody/tr[2]/td[1 and normalize-space(text())='Status:']");
		statusLabel.setxPathDescription(
				"'" + statusLabel.getFieldName() + "' input text field on the 'Add/Edit Purchase Order' page");
		return statusLabel;
	}

	public static FieldMaker statusValue() {
		FieldMaker statusValue = new FieldMaker();
		statusValue.setFieldName("Status value");
		statusValue.setTheXpath("//*[@id='total']/table/tbody/tr[2]/td[2]");
		statusValue.setxPathDescription(
				"'" + statusValue.getFieldName() + "' input text field on the 'Add/Edit Purchase Order' page");
		return statusValue;
	}

	public static FieldMaker purchaseOrderNotesHistoryLabel() {
		FieldMaker purchaseOrderNotesHistoryLabel = new FieldMaker();
		purchaseOrderNotesHistoryLabel.setFieldName("Purchase Order Notes/History label");
		purchaseOrderNotesHistoryLabel.setTheXpath(
				"//*[@id='purchaseOrderInputForm']/div[6 and normalize-space(.//text())='Purchase Order Notes/History']");
		purchaseOrderNotesHistoryLabel.setxPathDescription("'" + purchaseOrderNotesHistoryLabel.getFieldName()
				+ "' input text field on the 'Add/Edit Purchase Order' page");
		return purchaseOrderNotesHistoryLabel;
	}

	public static FieldMaker printButton() {
		FieldMaker printButton = new FieldMaker();
		printButton.setFieldName("Add/Edit Purchase Order page Print button");
		printButton.setTheXpath("//*[@id='printButton']");
		printButton.setxPathDescription("'" + printButton.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return printButton;
	}

	public static FieldMaker lineItemButton() {
		FieldMaker lineItemButton = new FieldMaker();
		lineItemButton.setFieldName("Add Purchase Order line item button");
		lineItemButton.setTheXpath("//*[@id='addPurchaseOrderLineItemButton']");
		lineItemButton
				.setxPathDescription("'" + lineItemButton.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return lineItemButton;
	}

	public static FieldMaker saveButton() {
		FieldMaker saveButton = new FieldMaker();
		saveButton.setFieldName("Add Purchase Order Save button");
		saveButton.setTheXpath("//*[@id='savePurchaseOrder']");
		saveButton.setxPathDescription("'" + saveButton.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return saveButton;
	}

	public static FieldMaker voidButton() {
		FieldMaker voidButton = new FieldMaker();
		voidButton.setFieldName("Add Purchase Order VOID button");
		voidButton.setTheXpath("//*[@id='voidPurchaseOrderButton']");
		voidButton.setxPathDescription("'" + voidButton.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return voidButton;
	}

	public static FieldMaker submitNewPOButton() {
		FieldMaker submitNewPOButton = new FieldMaker();
		submitNewPOButton.setFieldName("New Purchase Order Submit button");
		submitNewPOButton.setTheXpath("//*[@id='submitPurchaseOrderButton']");
		submitNewPOButton.setxPathDescription(
				"'" + submitNewPOButton.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return submitNewPOButton;
	}

	public static FieldMaker attachmentFileNameEntryField() {
		FieldMaker attachmentFileNameEntryField = new FieldMaker();
		attachmentFileNameEntryField.setFieldName("Attachment file name entry field");
		attachmentFileNameEntryField.setTheXpath("//*[@id='fileData']");
		attachmentFileNameEntryField.setxPathDescription(
				"'" + attachmentFileNameEntryField.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return attachmentFileNameEntryField;
	}

	public static FieldMaker attachmentUploadButton() {
		FieldMaker attachmentUploadButton = new FieldMaker();
		attachmentUploadButton.setFieldName("Attachment file upload button");
		attachmentUploadButton.setTheXpath("//*[@id='uploadFile']");
		attachmentUploadButton.setxPathDescription(
				"'" + attachmentUploadButton.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return attachmentUploadButton;
	}

	public static FieldMaker attachmentFileNameDisplay() {
		FieldMaker attachmentFileNameDisplay = new FieldMaker();
		attachmentFileNameDisplay.setFieldName("Attached file displayed name.");
		attachmentFileNameDisplay.setTheXpath("//*[@id='attachments']/tbody/tr[1]td[1]/a");
		attachmentFileNameDisplay.setxPathDescription(
				"'" + attachmentFileNameDisplay.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return attachmentFileNameDisplay;
	}

	public static FieldMaker attachmentFileDescriptionDisplay() {
		FieldMaker attachmentFileDescriptionDisplay = new FieldMaker();
		attachmentFileDescriptionDisplay.setFieldName("Attached file displayed description.");
		attachmentFileDescriptionDisplay.setTheXpath("//*[@id='attachments']/tbody/tr[1]td[2]");
		attachmentFileDescriptionDisplay.setxPathDescription(
				"'" + attachmentFileDescriptionDisplay.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return attachmentFileDescriptionDisplay;
	}

	public static FieldMaker attachmentFileAssociationLink() {
		FieldMaker attachmentFileAssociationLink = new FieldMaker();
		attachmentFileAssociationLink.setFieldName("Attached file displayed description.");
		attachmentFileAssociationLink.setTheXpath("//*[@id='attachments']/tbody/tr[1]td[3]/a");
		attachmentFileAssociationLink.setxPathDescription(
				"'" + attachmentFileAssociationLink.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return attachmentFileAssociationLink;
	}

	public static FieldMaker attachmentFileDeleteLink() {
		FieldMaker attachmentFileDeleteLink = new FieldMaker();
		attachmentFileDeleteLink.setFieldName("Attached file delete link.");
		attachmentFileDeleteLink.setTheXpath("//*[@id='attachments']/tbody/tr[1]td[4]/a");
		attachmentFileDeleteLink.setxPathDescription(
				"'" + attachmentFileDeleteLink.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return attachmentFileDeleteLink;
	}

	public static FieldMaker attachmentFileFolderOption() {
		FieldMaker attachmentFileFolderOption = new FieldMaker();
		attachmentFileFolderOption.setFieldName("Attached file folder option.");
		attachmentFileFolderOption.setTheXpath("//*[@id='attachments']/tbody/tr[1]td[5]");
		attachmentFileFolderOption.setxPathDescription(
				"'" + attachmentFileFolderOption.getFieldName() + "' on the 'Add/Edit Purchase Order' page");
		return attachmentFileFolderOption;
	}

}
	

