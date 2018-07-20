package testPack6;

public class APSearchFields {
	// This class is a factory for AP Search page field objects.

	// Search page title
	public static FieldMaker searchPageTitle() {
		FieldMaker searchPageTitle = new FieldMaker();
		searchPageTitle.setFieldName("Search Page Title");
		searchPageTitle.setTheXpath("//div[@class='section-title' and normalize-space(.//text())='Ap Input Search']");
		searchPageTitle.setxPathDescription("'" + searchPageTitle.getFieldName() + "' on the AP Search page");
		return searchPageTitle;
	}

	// Purchase Order Number text input field
	public static FieldMaker poNumberTextInput() {
		FieldMaker poNumberTextInput = new FieldMaker();
		poNumberTextInput.setFieldName("Purchase Order Number Text Input");
		poNumberTextInput.setTheXpath("//input[@name='poNumber']");
		poNumberTextInput.setxPathDescription("'" + poNumberTextInput.getFieldName() + "' on the AP Search page");
		return poNumberTextInput;
	}

	// Paykey text input field
	public static FieldMaker paykeyTextInput() {
		FieldMaker paykeyTextInput = new FieldMaker();
		paykeyTextInput.setFieldName("Paykey Text Input");
		paykeyTextInput.setTheXpath("//input[@name='payKey']");
		paykeyTextInput.setxPathDescription("'" + paykeyTextInput.getFieldName() + "' on the AP Search page");
		return paykeyTextInput;
	}

	// Invoice Number text input field
	public static FieldMaker invoiceNumberTextInput() {
		FieldMaker invoiceNumberTextInput = new FieldMaker();
		invoiceNumberTextInput.setFieldName("Invoice Number Text Input");
		invoiceNumberTextInput.setTheXpath("//input[@name='invoiceNumber']");
		invoiceNumberTextInput
				.setxPathDescription("'" + invoiceNumberTextInput.getFieldName() + "' on the AP Search page");
		return invoiceNumberTextInput;
	}

	// Basic Search button
	public static FieldMaker basicSearchButton() {
		FieldMaker basicSearchButton = new FieldMaker();
		basicSearchButton.setFieldName("//input[@name='searchBasic']");
		basicSearchButton.setTheXpath("//input[@name='searchBasic']");
		basicSearchButton.setxPathDescription("'" + basicSearchButton.getFieldName() + "' on the AP Search page");
		return basicSearchButton;
	}

	// Purchase Type dropdown
	public static FieldMaker purchaseTypeDropdown() {
		FieldMaker purchaseTypeDropdown = new FieldMaker();
		purchaseTypeDropdown.setFieldName("Purchase Type dropdown");
		purchaseTypeDropdown.setTheXpath("//select[@name='entryType']");
		purchaseTypeDropdown.setxPathDescription("'" + purchaseTypeDropdown.getFieldName() + "' on the AP Search page");
		return purchaseTypeDropdown;
	}

	// Reference Number text input field
	public static FieldMaker referenceNumberTextInput() {
		FieldMaker referenceNumberTextInput = new FieldMaker();
		referenceNumberTextInput.setFieldName("Reference Number Text Input");
		referenceNumberTextInput.setTheXpath("//input[@name='referenceNumber']");
		referenceNumberTextInput
				.setxPathDescription("'" + referenceNumberTextInput.getFieldName() + "' on the AP Search page");
		return referenceNumberTextInput;
	}

	// Status dropdown
	public static FieldMaker statusDropdown() {
		FieldMaker statusDropdown = new FieldMaker();
		statusDropdown.setFieldName("Status dropdown");
		statusDropdown.setTheXpath("//select[@name='status']");
		statusDropdown.setxPathDescription("'" + statusDropdown.getFieldName() + "' on the AP Search page");
		return statusDropdown;
	}

	// Location dropdown
	public static FieldMaker locationDropdown() {
		FieldMaker locationDropdown = new FieldMaker();
		locationDropdown.setFieldName("Location dropdown");
		locationDropdown.setTheXpath("//select[@name='locationCode']");
		locationDropdown.setxPathDescription("'" + locationDropdown.getFieldName() + "' on the AP Search page");
		return locationDropdown;
	}

	// Vendor dropdown
	public static FieldMaker vendorDropdown() {
		FieldMaker vendorDropdown = new FieldMaker();
		vendorDropdown.setFieldName("Vendor dropdown");
		vendorDropdown.setTheXpath("//select[@name='vendor']");
		vendorDropdown.setxPathDescription("'" + vendorDropdown.getFieldName() + "' on the AP Search page");
		return vendorDropdown;
	}

	// Purchase Date radio button
	public static FieldMaker purchaseDateRadioButton() {
		FieldMaker purchaseDateRadioButton = new FieldMaker();
		purchaseDateRadioButton.setFieldName("Purchase Date radio button");
		purchaseDateRadioButton.setTheXpath("//input[@id='apEntryDateType1']");
		purchaseDateRadioButton
				.setxPathDescription("'" + purchaseDateRadioButton.getFieldName() + "' on the AP Search page");
		return purchaseDateRadioButton;
	}

	// Invoice Date radio button
	public static FieldMaker invoiceDateRadioButton() {
		FieldMaker invoiceDateRadioButton = new FieldMaker();
		invoiceDateRadioButton.setFieldName("Invoice Date radio button");
		invoiceDateRadioButton.setTheXpath("//input[@id='apEntryDateType2']");
		invoiceDateRadioButton
				.setxPathDescription("'" + invoiceDateRadioButton.getFieldName() + "' on the AP Search page");
		return invoiceDateRadioButton;
	}

	// Entered Date radio button
	public static FieldMaker enteredDateRadioButton() {
		FieldMaker enteredDateRadioButton = new FieldMaker();
		enteredDateRadioButton.setFieldName("Entered Date radio button");
		enteredDateRadioButton.setTheXpath("//input[@id='apEntryDateType3']");
		enteredDateRadioButton
				.setxPathDescription("'" + enteredDateRadioButton.getFieldName() + "' on the AP Search page");
		return enteredDateRadioButton;
	}

	// Start Date datepicker field
	public static FieldMaker startDatepicker() {
		FieldMaker startDatepicker = new FieldMaker();
		startDatepicker.setFieldName("Start Date datepicker field");
		startDatepicker.setTheXpath("//input[@name='startDate']");
		startDatepicker.setxPathDescription("'" + startDatepicker.getFieldName() + "' on the AP Search page");
		return startDatepicker;
	}

	// End Date datepicker field
	public static FieldMaker endDatepicker() {
		FieldMaker endDatepicker = new FieldMaker();
		endDatepicker.setFieldName("End Date datepicker field");
		endDatepicker.setTheXpath("//input[@name='endDate']");
		endDatepicker.setxPathDescription("'" + endDatepicker.getFieldName() + "' on the AP Search page");
		return endDatepicker;
	}

	// Advanced Search button
	public static FieldMaker advancedSearchButton() {
		FieldMaker advancedSearchButton = new FieldMaker();
		advancedSearchButton.setFieldName("Advanced Search Button");
		advancedSearchButton.setTheXpath("//input[@name='searchAdvanced']");
		advancedSearchButton.setxPathDescription("'" + advancedSearchButton.getFieldName() + "' on the AP Search page");
		return advancedSearchButton;
	}

	// Clear button
	public static FieldMaker clearButton() {
		FieldMaker clearButton = new FieldMaker();
		clearButton.setFieldName("Clear Button");
		clearButton.setTheXpath("//input[@value='Clear']");
		clearButton.setxPathDescription("'" + clearButton.getFieldName() + "' on the AP Search page");
		return clearButton;
	}

	// Search results table
	// Empty Search results indicator
	public static FieldMaker emptySearchResultsText() {
		FieldMaker clearButton = new FieldMaker();
		clearButton.setFieldName("Clear Button");
		clearButton.setTheXpath("//td[@class='dataTables_empty']");
		clearButton.setxPathDescription("'" + clearButton.getFieldName() + "' on the AP Search page");
		return clearButton;
	}

	// PO Search Results Line 1 - ID
	public static FieldMaker poSearchResultsLine1_ID() {
		FieldMaker searchResultsLine1_ID = new FieldMaker();
		searchResultsLine1_ID.setFieldName("Search Results Line 1 - ID");
		searchResultsLine1_ID.setTheXpath("//*[@id='dataTable']/tbody/tr[1]/td[1]/a");
		searchResultsLine1_ID
				.setxPathDescription("'" + searchResultsLine1_ID.getFieldName() + "' on the AP Search page");
		return searchResultsLine1_ID;
	}

	// PO Search Results Line 1 - Location
	public static FieldMaker poSearchResultsLine1_Location() {
		FieldMaker searchResultsLine1_Location = new FieldMaker();
		searchResultsLine1_Location.setFieldName("Search Results Line 1 - Location");
		searchResultsLine1_Location.setTheXpath("//*[@id='dataTable']/tbody/tr[1]/td[2]");
		searchResultsLine1_Location
				.setxPathDescription("'" + searchResultsLine1_Location.getFieldName() + "' on the AP Search page");
		return searchResultsLine1_Location;
	}

	// PO Search Results Line 1 - Paykey
	public static FieldMaker poSearchResultsLine1_Paykey() {
		FieldMaker searchResultsLine1_Paykey = new FieldMaker();
		searchResultsLine1_Paykey.setFieldName("Search Results Line 1 - Paykey");
		searchResultsLine1_Paykey.setTheXpath("//*[@id='dataTable']/tbody/tr[1]/td[3]");
		searchResultsLine1_Paykey
				.setxPathDescription("'" + searchResultsLine1_Paykey.getFieldName() + "' on the AP Search page");
		return searchResultsLine1_Paykey;
	}

	// PO Search Results Line 1 - Purchase Order Number
	public static FieldMaker poSearchResultsLine1_PurchaseOrderNumber() {
		FieldMaker searchResultsLine1_PurchaseOrderNumber = new FieldMaker();
		searchResultsLine1_PurchaseOrderNumber.setFieldName("Search Results Line 1 - Purchase Order Number");
		searchResultsLine1_PurchaseOrderNumber.setTheXpath("//*[@id='dataTable']/tbody/tr[1]/td[4]");
		searchResultsLine1_PurchaseOrderNumber.setxPathDescription(
				"'" + searchResultsLine1_PurchaseOrderNumber.getFieldName() + "' on the AP Search page");
		return searchResultsLine1_PurchaseOrderNumber;
	}

	// poSSearch Results Line 1 - Purchase Date
	public static FieldMaker poSearchResultsLine1_PurchaseDate() {
		FieldMaker searchResultsLine1_PurchaseDate = new FieldMaker();
		searchResultsLine1_PurchaseDate.setFieldName("Search Results Line 1 - Purchase Date");
		searchResultsLine1_PurchaseDate.setTheXpath("//*[@id='dataTable']/tbody/tr[1]/td[5]");
		searchResultsLine1_PurchaseDate
				.setxPathDescription("'" + searchResultsLine1_PurchaseDate.getFieldName() + "' on the AP Search page");
		return searchResultsLine1_PurchaseDate;
	}

	// PO Search Results Line 1 - Vendor
	public static FieldMaker poSearchResultsLine1_Vendor() {
		FieldMaker searchResultsLine1_Vendor = new FieldMaker();
		searchResultsLine1_Vendor.setFieldName("Search Results Line 1 - Vendor");
		searchResultsLine1_Vendor.setTheXpath("//*[@id='dataTable']/tbody/tr[1]/td[6]");
		searchResultsLine1_Vendor
				.setxPathDescription("'" + searchResultsLine1_Vendor.getFieldName() + "' on the AP Search page");
		return searchResultsLine1_Vendor;
	}

	// PO Search Results Line 1 - Purchaser
	public static FieldMaker poSearchResultsLine1_Purchaser() {
		FieldMaker searchResultsLine1_Purchaser = new FieldMaker();
		searchResultsLine1_Purchaser.setFieldName("Search Results Line 1 - Purchaser");
		searchResultsLine1_Purchaser.setTheXpath("//*[@id='dataTable']/tbody/tr[1]/td[7]");
		searchResultsLine1_Purchaser
				.setxPathDescription("'" + searchResultsLine1_Purchaser.getFieldName() + "' on the AP Search page");
		return searchResultsLine1_Purchaser;
	}

	// PO Search Results Line 1 - Status
	public static FieldMaker poSearchResultsLine1_Status() {
		FieldMaker searchResultsLine1_Status = new FieldMaker();
		searchResultsLine1_Status.setFieldName("Search Results Line 1 - Status");
		searchResultsLine1_Status.setTheXpath("//*[@id='dataTable']/tbody/tr[1]/td[8]");
		searchResultsLine1_Status
				.setxPathDescription("'" + searchResultsLine1_Status.getFieldName() + "' on the AP Search page");
		return searchResultsLine1_Status;
	}

	// Search Results Line 1 - BackOrder Number
	public static FieldMaker searchResultsLine1_BackOrderNumber() {
		FieldMaker searchResultsLine1_BackOrderNumber = new FieldMaker();
		searchResultsLine1_BackOrderNumber.setFieldName("Search Results Line 1 - BackOrder Number");
		searchResultsLine1_BackOrderNumber.setTheXpath("xpath needed");
		searchResultsLine1_BackOrderNumber.setxPathDescription(
				"'" + searchResultsLine1_BackOrderNumber.getFieldName() + "' on the AP Search page");
		return searchResultsLine1_BackOrderNumber;
	}

	// Search Results Line 1 - Reference Number
	public static FieldMaker searchResultsLine1_ReferenceNumber() {
		FieldMaker searchResultsLine1_ReferenceNumber = new FieldMaker();
		searchResultsLine1_ReferenceNumber.setFieldName("Search Results Line 1 - Reference Number");
		searchResultsLine1_ReferenceNumber.setTheXpath("xpath needed");
		searchResultsLine1_ReferenceNumber.setxPathDescription(
				"'" + searchResultsLine1_ReferenceNumber.getFieldName() + "' on the AP Search page");
		return searchResultsLine1_ReferenceNumber;
	}

	// Search Results Line 1 - Type
	public static FieldMaker searchResultsLine1_Type() {
		FieldMaker searchResultsLine1_Type = new FieldMaker();
		searchResultsLine1_Type.setFieldName("Search Results Line 1 - Type");
		searchResultsLine1_Type.setTheXpath("xpath needed");
		searchResultsLine1_Type
				.setxPathDescription("'" + searchResultsLine1_Type.getFieldName() + "' on the AP Search page");
		return searchResultsLine1_Type;
	}

	// Search Results Line 1 - PO/Invoice Amount
	public static FieldMaker searchResultsLine1_PO_InvoiceAmount() {
		FieldMaker searchResultsLine1_PO_InvoiceAmount = new FieldMaker();
		searchResultsLine1_PO_InvoiceAmount.setFieldName("Search Results Line 1 - PO/Invoice Amount");
		searchResultsLine1_PO_InvoiceAmount.setTheXpath("xpath needed");
		searchResultsLine1_PO_InvoiceAmount.setxPathDescription(
				"'" + searchResultsLine1_PO_InvoiceAmount.getFieldName() + "' on the AP Search page");
		return searchResultsLine1_PO_InvoiceAmount;
	}

	// Search Results Line 1 - Non-coded Amount
	public static FieldMaker searchResultsLine1_NonCodedAmount() {
		FieldMaker searchResultsLine1_NonCodedAmount = new FieldMaker();
		searchResultsLine1_NonCodedAmount.setFieldName("Search Results Line 1 - Non-coded Amount");
		searchResultsLine1_NonCodedAmount.setTheXpath("xpath needed");
		searchResultsLine1_NonCodedAmount.setxPathDescription(
				"'" + searchResultsLine1_NonCodedAmount.getFieldName() + "' on the AP Search page");
		return searchResultsLine1_NonCodedAmount;
	}

	// Search Results Line 1 - Invoice Number
	public static FieldMaker searchResultsLine1_InvoiceNumber() {
		FieldMaker searchResultsLine1_InvoiceNumber = new FieldMaker();
		searchResultsLine1_InvoiceNumber.setFieldName("Search Results Line 1 - Invoice Number");
		searchResultsLine1_InvoiceNumber.setTheXpath("xpath needed");
		searchResultsLine1_InvoiceNumber
				.setxPathDescription("'" + searchResultsLine1_InvoiceNumber.getFieldName() + "' on the AP Search page");
		return searchResultsLine1_InvoiceNumber;
	}

	// Search Results Line 1 - Invoice Date
	public static FieldMaker searchResultsLine1_InvoiceDate() {
		FieldMaker searchResultsLine1_InvoiceDate = new FieldMaker();
		searchResultsLine1_InvoiceDate.setFieldName("Search Results Line 1 - Invoice Date");
		searchResultsLine1_InvoiceDate.setTheXpath("xpath needed");
		searchResultsLine1_InvoiceDate
				.setxPathDescription("'" + searchResultsLine1_InvoiceDate.getFieldName() + "' on the AP Search page");
		return searchResultsLine1_InvoiceDate;
	}

	// Search Results Line 1 - Check Number
	public static FieldMaker searchResultsLine1_CheckNumber() {
		FieldMaker searchResultsLine1_CheckNumber = new FieldMaker();
		searchResultsLine1_CheckNumber.setFieldName("Search Results Line 1 - Check Number");
		searchResultsLine1_CheckNumber.setTheXpath("xpath needed");
		searchResultsLine1_CheckNumber
				.setxPathDescription("'" + searchResultsLine1_CheckNumber.getFieldName() + "' on the AP Search page");
		return searchResultsLine1_CheckNumber;
	}

	// Search Results Line 1 - Check Date
	public static FieldMaker searchResultsLine1_CheckDate() {
		FieldMaker searchResultsLine1_CheckDate = new FieldMaker();
		searchResultsLine1_CheckDate.setFieldName("Search Results Line 1 - Check Date");
		searchResultsLine1_CheckDate.setTheXpath("xpath needed");
		searchResultsLine1_CheckDate
				.setxPathDescription("'" + searchResultsLine1_CheckDate.getFieldName() + "' on the AP Search page");
		return searchResultsLine1_CheckDate;
	}

	// Search Results - Entries per page dropdown
	public static FieldMaker searchResults_EntriesPerPageDropdown() {
		FieldMaker searchResults_EntriesPerPageDropdown = new FieldMaker();
		searchResults_EntriesPerPageDropdown.setFieldName("Search Results - Entries per page dropdown");
		searchResults_EntriesPerPageDropdown.setTheXpath("//select[@name='dataTable_length']");
		searchResults_EntriesPerPageDropdown.setxPathDescription(
				"'" + searchResults_EntriesPerPageDropdown.getFieldName() + "' on the AP Search page");
		return searchResults_EntriesPerPageDropdown;
	}

	// Search Results - Number of Search Results text
	public static FieldMaker searchResults_NumberOfResultsText() {
		FieldMaker searchResults_NumberOfResultsText = new FieldMaker();
		searchResults_NumberOfResultsText.setFieldName("Search Results - Number of Results text");
		searchResults_NumberOfResultsText.setTheXpath("xpath needed");
		searchResults_NumberOfResultsText.setxPathDescription(
				"'" + searchResults_NumberOfResultsText.getFieldName() + "' on the AP Search page");
		return searchResults_NumberOfResultsText;
	}

	// Search Results - Previous page link
	public static FieldMaker searchResults_PreviousPageLink() {
		FieldMaker searchResults_PreviousPageLink = new FieldMaker();
		searchResults_PreviousPageLink.setFieldName("Search Results - Previous Page link");
		searchResults_PreviousPageLink.setTheXpath("xpath needed");
		searchResults_PreviousPageLink
				.setxPathDescription("'" + searchResults_PreviousPageLink.getFieldName() + "' on the AP Search page");
		return searchResults_PreviousPageLink;
	}

	// Search Results - Next page link
	public static FieldMaker searchResults_NextPageLink() {
		FieldMaker searchResults_NextPageLink = new FieldMaker();
		searchResults_NextPageLink.setFieldName("Search Results - Next Page link");
		searchResults_NextPageLink.setTheXpath("xpath needed");
		searchResults_NextPageLink
				.setxPathDescription("'" + searchResults_NextPageLink.getFieldName() + "' on the AP Search page");
		return searchResults_NextPageLink;
	}

	// Search Results - Numeric page link
	public static FieldMaker searchResults_NumericPageLink() {
		FieldMaker searchResults_NumericPageLink = new FieldMaker();
		searchResults_NumericPageLink.setFieldName("Search Results - Numeric Page link");
		searchResults_NumericPageLink.setTheXpath("xpath needed");
		searchResults_NumericPageLink
				.setxPathDescription("'" + searchResults_NumericPageLink.getFieldName() + "' on the AP Search page");
		return searchResults_NumericPageLink;
	}

	// Search Results - Filter text input
	public static FieldMaker searchResults_FilterTextInput() {
		FieldMaker searchResults_FilterTextInput = new FieldMaker();
		searchResults_FilterTextInput.setFieldName("Search Results - Filter text input");
		searchResults_FilterTextInput.setTheXpath("//*[@id='dataTable_filter']/label/input");
		searchResults_FilterTextInput
				.setxPathDescription("'" + searchResults_FilterTextInput.getFieldName() + "' on the AP Search page");
		return searchResults_FilterTextInput;
	}

}
