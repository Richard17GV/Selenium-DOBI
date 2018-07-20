package testPack6;

import org.openqa.selenium.WebDriver;

public class SubmittedPOFields {

	// This class is a factory for Submitted PO page field objects.

	public static FieldMaker locationValue() {
		FieldMaker locationValue = new FieldMaker();
		locationValue.setFieldName("Location");
		locationValue.setTheXpath("//*[@id='voucherInputForm']/div[2]/div[2]/table[1]/tbody/tr[1]/td[2]");
		locationValue.setxPathDescription("'" + locationValue.getFieldName() + "' on the submitted purchase order page");
		return locationValue;
	}

	public static FieldMaker purchaseOrderNumberValue() {
		FieldMaker purchaseOrderNumberValue = new FieldMaker();
		purchaseOrderNumberValue.setFieldName("Purchase Order Number");
		purchaseOrderNumberValue.setTheXpath("//*[@id='voucherInputForm']/div[2]/div[2]/table[1]/tbody/tr[2]/td[2]");
		purchaseOrderNumberValue.setxPathDescription(
				"'" + purchaseOrderNumberValue.getFieldName() + "' on the submitted purchase order page");
		return purchaseOrderNumberValue;
	}

	public static FieldMaker payKeyValue() {
		FieldMaker payKeyValue = new FieldMaker();
		payKeyValue.setFieldName("Pay Key");
		payKeyValue.setTheXpath("//*[@id='voucherInputForm']/div[2]/div[2]/table[1]/tbody/tr[3]/td[2]");
		payKeyValue.setxPathDescription("'" + payKeyValue.getFieldName() + "' on the submitted purchase order page");
		return payKeyValue;
	}

	public static FieldMaker backOrderNumberValue() {
		FieldMaker backOrderNumberValue = new FieldMaker();
		backOrderNumberValue.setFieldName("BackOrder Number");
		backOrderNumberValue.setTheXpath("//*[@id='voucherInputForm']/div[2]/div[2]/table[1]/tbody/tr[4]/td[2]");
		backOrderNumberValue.setxPathDescription(
				"'" + backOrderNumberValue.getFieldName() + "' on the submitted purchase order page");
		return backOrderNumberValue;
	}
	
	public static FieldMaker referenceNumberValue() {
		FieldMaker referenceNumberValue = new FieldMaker();
		referenceNumberValue.setFieldName("Reference Number");
		referenceNumberValue.setTheXpath("//*[@id='voucherInputForm']/div[2]/div[2]/table[1]/tbody/tr[5]/td[2]");
		referenceNumberValue.setxPathDescription(
				"'" + referenceNumberValue.getFieldName() + "' on the submitted purchase order page");
		return referenceNumberValue;
	}

	public static FieldMaker vendorValue() {
		FieldMaker vendorValue = new FieldMaker();
		vendorValue.setFieldName("Vendor");
		vendorValue.setTheXpath("//*[@id='voucherInputForm']/div[2]/div[2]/table[1]/tbody/tr[6]/td[2]");
		vendorValue.setxPathDescription("'" + vendorValue.getFieldName() + "' on the submitted purchase order page");
		return vendorValue;
	}

	public static FieldMaker purchaseOrderDateValue() {
		FieldMaker purchaseOrderDateValue = new FieldMaker();
		purchaseOrderDateValue.setFieldName("Purchase Order Date");
		purchaseOrderDateValue.setTheXpath("//*[@id='voucherInputForm']/div[2]/div[2]/table[1]/tbody/tr[8]/td[2]");
		purchaseOrderDateValue.setxPathDescription(
				"'" + purchaseOrderDateValue.getFieldName() + "' on the submitted purchase order page");
		return purchaseOrderDateValue;
	}

	public static FieldMaker purchaserValue() {
		FieldMaker purchaserValue = new FieldMaker();
		purchaserValue.setFieldName("Purchaser");
		purchaserValue.setTheXpath("//*[@id='voucherInputForm']/div[2]/div[2]/table[1]/tbody/tr[9]/td[2]");
		purchaserValue.setxPathDescription("'" + purchaserValue.getFieldName() + "' on the submitted purchase order page");
		return purchaserValue;
	}

	public static FieldMaker createdByValue() {
		FieldMaker createdByValue = new FieldMaker();
		createdByValue.setFieldName("Created By");
		createdByValue.setTheXpath("//*[@id='voucherInputForm']/div[2]/div[2]/table[2]/tbody/tr[1]/td[1]");
		createdByValue.setxPathDescription("'" + createdByValue.getFieldName() + "' on the submitted purchase order page");
		return createdByValue;
	}

	public static FieldMaker createdDateValue() {
		FieldMaker createdDateValue = new FieldMaker();
		createdDateValue.setFieldName("Created Date");
		createdDateValue.setTheXpath("//*[@id='voucherInputForm']/div[2]/div[2]/table[2]/tbody/tr[2]/td[1]");
		createdDateValue.setxPathDescription("'" + createdDateValue.getFieldName() + "' on the submitted purchase order page");
		return createdDateValue;
	}

	public static FieldMaker approvedByValue() {
		FieldMaker approvedByValue = new FieldMaker();
		approvedByValue.setFieldName("Approved By");
		approvedByValue.setTheXpath("//*[@id='voucherInputForm']/div[2]/div[2]/table[2]/tbody/tr[3]/td[1]");
		approvedByValue.setxPathDescription("'" + approvedByValue.getFieldName() + "' on the submitted purchase order page");
		return approvedByValue;
	}

	public static FieldMaker approvedDateValue() {
		FieldMaker approvedDateValue = new FieldMaker();
		approvedDateValue.setFieldName("Approved Date");
		approvedDateValue.setTheXpath("//*[@id='voucherInputForm']/div[2]/div[2]/table[2]/tbody/tr[4]/td[1]");
		approvedDateValue.setxPathDescription("'" + approvedDateValue.getFieldName() + "' on the submitted purchase order page");
		return approvedDateValue;
	}

	public static FieldMaker termsValue() {
		FieldMaker termsValue = new FieldMaker();
		termsValue.setFieldName("Terms");
		termsValue.setTheXpath("//*[@id='vendorTerms']");
		termsValue.setxPathDescription("'" + termsValue.getFieldName() + "' on the submitted purchase order page");
		return termsValue;
	}

	public static FieldMaker currencyValue() {
		FieldMaker currencyValue = new FieldMaker();
		currencyValue.setFieldName("Currency Type");
		currencyValue.setTheXpath("//*[@id='currencyCode']");
		currencyValue.setxPathDescription("'" + currencyValue.getFieldName() + "'on the submitted purchase order page");
		return currencyValue;
	}
	
	public static FieldMaker lineItem_DepartmentNumber(WebDriver driver) {
		FieldMaker lineItem_DepartmentNumber = new FieldMaker();
		lineItem_DepartmentNumber.setFieldName("Line Input - Department");
		lineItem_DepartmentNumber.setTheXpath("//*[@id='departmentWithEvent']");
		lineItem_DepartmentNumber.setDropDownSize(Utility.findDropdownSize(driver, "", "", lineItem_DepartmentNumber.getTheXpath()));
		lineItem_DepartmentNumber.setxPathDescription(
				"'" + lineItem_DepartmentNumber.getFieldName() + "' on the 'Submitted Purchase Order' page");
		return lineItem_DepartmentNumber;
	}

	public static FieldMaker lineItem_Account(WebDriver driver) {
		FieldMaker lineItem_Account = new FieldMaker();
		lineItem_Account.setFieldName("Line Input - Account");
		lineItem_Account.setTheXpath("//*[@id='voucherAccountWithEvent']");
		lineItem_Account.setDropDownSize(Utility.findDropdownSize(driver, "", "", lineItem_Account.getTheXpath()));
		lineItem_Account.setxPathDescription(
				"'" + lineItem_Account.getFieldName() + "' on the 'Submitted Purchase Order' page");
		return lineItem_Account;
	}

	public static FieldMaker lineItem_LineOfService(WebDriver driver) {
		FieldMaker lineItem_LineOfService = new FieldMaker();
		lineItem_LineOfService.setFieldName("Line Input - Line of Service");
		lineItem_LineOfService.setTheXpath("//*[@id='lineOfService']");
		lineItem_LineOfService.setDropDownSize(Utility.findDropdownSize(driver, "", "", lineItem_LineOfService.getTheXpath()));
		lineItem_LineOfService.setxPathDescription(
				"'" + lineItem_LineOfService.getFieldName() + "' on the 'Submitted Purchase Order' page");
		return lineItem_LineOfService;
	}

	public static FieldMaker lineItem_Chartfield1(WebDriver driver) {
		FieldMaker lineItem_Chartfield1 = new FieldMaker();
		lineItem_Chartfield1.setFieldName("Line Input - Chartfield1");
		lineItem_Chartfield1.setTheXpath("//*[@id='chartfield1WithEvent']");
		lineItem_Chartfield1.setDropDownSize(Utility.findDropdownSize(driver, "", "", lineItem_Chartfield1.getTheXpath()));
		lineItem_Chartfield1.setxPathDescription(
				"'" + lineItem_Chartfield1.getFieldName() + "' on the 'Submitted Purchase Order' page");
		return lineItem_Chartfield1;
	}

	public static FieldMaker lineItem_Project(WebDriver driver) {
		FieldMaker lineItem_Project = new FieldMaker();
		lineItem_Project.setFieldName("Line Input - Project");
		lineItem_Project.setTheXpath("//*[@id='projectWithEvent']");
		lineItem_Project.setDropDownSize(Utility.findDropdownSize(driver, "", "", lineItem_Project.getTheXpath()));
		lineItem_Project.setxPathDescription(
				"'" + lineItem_Project.getFieldName() + "' on the 'Submitted Purchase Order' page");
		return lineItem_Project;
	}

	public static FieldMaker lineItem_Job(WebDriver driver) {
		FieldMaker lineItem_Job = new FieldMaker();
		lineItem_Job.setFieldName("Line Input - Job");
		lineItem_Job.setTheXpath("//*[@id='jobWithEvent']");
		lineItem_Job.setDropDownSize(Utility.findDropdownSize(driver, "", "", lineItem_Job.getTheXpath()));
		lineItem_Job.setxPathDescription("'" + lineItem_Job.getFieldName() + "' on the 'Submitted Purchase Order' page");
		return lineItem_Job;
	}

	public static FieldMaker lineItem_Equipment(WebDriver driver) {
		FieldMaker lineItem_Equipment = new FieldMaker();
		lineItem_Equipment.setFieldName("Line Input - Equipment");
		lineItem_Equipment.setTheXpath("//*[@id='equipmentWithEvent']");
		lineItem_Equipment.setDropDownSize(Utility.findDropdownSize(driver, "", "", lineItem_Equipment.getTheXpath()));
		lineItem_Equipment.setxPathDescription(
				"'" + lineItem_Equipment.getFieldName() + "' on the 'Submitted Purchase Order' page");
		return lineItem_Equipment;
	}

	public static FieldMaker lineItem_ServiceDate() {
		FieldMaker lineItem_Reimbursable = new FieldMaker();
		lineItem_Reimbursable.setFieldName("Line Input - Service Date");
		lineItem_Reimbursable.setTheXpath("//*[@id='serviceDate']");
		lineItem_Reimbursable.setxPathDescription(
				"'" + lineItem_Reimbursable.getFieldName() + "' on the 'Submitted Purchase Order' page");
		return lineItem_Reimbursable;
	}

	public static FieldMaker lineItem_Reimbursable() {
		FieldMaker lineItem_Reimbursable = new FieldMaker();
		lineItem_Reimbursable.setFieldName("Line Input - Reimbursable");
		lineItem_Reimbursable.setTheXpath("//*[@id='isReimbursable']");
		lineItem_Reimbursable.setxPathDescription(
				"'" + lineItem_Reimbursable.getFieldName() + "' on the 'Submitted Purchase Order' page");
		return lineItem_Reimbursable;
	}

	public static FieldMaker lineItem_Description() {
		FieldMaker lineItem_Description = new FieldMaker();
		lineItem_Description.setFieldName("Line Input - Description");
		lineItem_Description.setTheXpath("//*[@id='description']");
		lineItem_Description.setxPathDescription("'" + lineItem_Description.getFieldName()
				+ "' input text field on the 'Submitted Purchase Order' page");
		lineItem_Description.setRequiredFieldErrorBorderColor("#ff0000");
		lineItem_Description.setRequiredFieldErrorFieldColor("#ff0000");
		return lineItem_Description;
	}
	
	public static FieldMaker line_AmountEntry() {
		FieldMaker line_AmountEntry = new FieldMaker();
		line_AmountEntry.setFieldName("Line Input - Line Amount");
		line_AmountEntry.setTheXpath("//*[@id='amountInput']");
		line_AmountEntry.setxPathDescription("'" + line_AmountEntry.getFieldName() + "' on the submitted purchase order page");
		return line_AmountEntry;
	}

	public static FieldMaker line_AccountingDateEntry() {
		FieldMaker line_AccountingDateEntry = new FieldMaker();
		line_AccountingDateEntry.setFieldName("Line Input - Accounting Date");
		line_AccountingDateEntry.setTheXpath("//*[@id='accountingDateInput']");
		line_AccountingDateEntry.setxPathDescription(
				"'" + line_AccountingDateEntry.getFieldName() + "' on the submitted purchase order page");
		return line_AccountingDateEntry;
	}

	public static FieldMaker line_MarkupPercentEntry() {
		FieldMaker line_MarkupPercentEntry = new FieldMaker();
		line_MarkupPercentEntry.setFieldName("Line Input - Markup Percent");
		line_MarkupPercentEntry.setTheXpath("//*[@id='markupPercent']");
		line_MarkupPercentEntry.setxPathDescription(
				"'" + line_MarkupPercentEntry.getFieldName() + "' on the submitted purchase order page");
		return line_MarkupPercentEntry;
	}

	public static FieldMaker line_CustomerEntry() {
		FieldMaker line_CustomerEntry = new FieldMaker();
		line_CustomerEntry.setFieldName("Line Input - Customer");
		line_CustomerEntry.setTheXpath("//*[@id='customerWithEvent']");
		line_CustomerEntry.setxPathDescription(
				"'" + line_CustomerEntry.getFieldName() + "' on the submitted purchase order page");
		return line_CustomerEntry;
	}

	public static FieldMaker line_VendorEntry() {
		FieldMaker line_VendorEntry = new FieldMaker();
		line_VendorEntry.setFieldName("Line Input - Vendor");
		line_VendorEntry.setTheXpath("//*[@id='vendorName']");
		line_VendorEntry.setxPathDescription("'" + line_VendorEntry.getFieldName() + "' on the submitted purchase order page");
		return line_VendorEntry;
	}

	public static FieldMaker addLineItemButton() {
		FieldMaker addLineItemButton = new FieldMaker();
		addLineItemButton.setFieldName("Add Line Item Button");
		addLineItemButton.setTheXpath("//*[@id='addVoucherLineItemButton']");
		addLineItemButton.setxPathDescription("'" + addLineItemButton.getFieldName() + "' on the submitted purchase order page");
		return addLineItemButton;
	}

	public static FieldMaker updateLineItemButton() {
		FieldMaker updateLineItemButton = new FieldMaker();
		updateLineItemButton.setFieldName("Update Line Item Button");
		updateLineItemButton.setTheXpath("//*[@id='editVoucherLineItemButtonRest']");
		updateLineItemButton.setxPathDescription(
				"'" + updateLineItemButton.getFieldName() + "' on the submitted purchase order page");
		return updateLineItemButton;
	}

	public static FieldMaker cancelUpdateLineItemButton() {
		FieldMaker cancelUpdateLineItemButton = new FieldMaker();
		cancelUpdateLineItemButton.setFieldName("Cancel update Line Item Button");
		cancelUpdateLineItemButton.setTheXpath("//*[@id='candelVoucherLineItemButtonRest']");
		cancelUpdateLineItemButton.setxPathDescription(
				"'" + cancelUpdateLineItemButton.getFieldName() + "' on the submitted purchase order page");
		return cancelUpdateLineItemButton;
	}

	public static FieldMaker line1_IncludeCheckbox() {
		FieldMaker line1_IncludeCheckbox = new FieldMaker();
		line1_IncludeCheckbox.setFieldName("Line 1 Include checkbox");
		line1_IncludeCheckbox.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[1]");
		line1_IncludeCheckbox.setxPathDescription(
				"'" + line1_IncludeCheckbox.getFieldName() + "' on the submitted purchase order page");
		return line1_IncludeCheckbox;
	}

	public static FieldMaker line2_IncludeCheckbox() {
		FieldMaker line2_IncludeCheckbox = new FieldMaker();
		line2_IncludeCheckbox.setFieldName("Line 2 Include checkbox");
		line2_IncludeCheckbox.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[1]");
		line2_IncludeCheckbox.setxPathDescription(
				"'" + line2_IncludeCheckbox.getFieldName() + "' on the submitted purchase order page");
		return line2_IncludeCheckbox;
	}
		
	public static FieldMaker line1_DepartmentValue() {
		FieldMaker line1_DepartmentValue = new FieldMaker();
		line1_DepartmentValue.setFieldName("Line 1 Department value");
		line1_DepartmentValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[1]/td[2]");
		line1_DepartmentValue.setxPathDescription(
				"'" + line1_DepartmentValue.getFieldName() + "' on the submitted purchase order page");
		return line1_DepartmentValue;
	}

	public static FieldMaker line2_DepartmentValue() {
		FieldMaker line2_DepartmentValue = new FieldMaker();
		line2_DepartmentValue.setFieldName("Line 2 Department value");
		line2_DepartmentValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[2]");
		line2_DepartmentValue.setxPathDescription(
				"'" + line2_DepartmentValue.getFieldName() + "' on the submitted purchase order page");
		return line2_DepartmentValue;
	}

	public static FieldMaker line1_AccountValue() {
		FieldMaker line1_AccountValue = new FieldMaker();
		line1_AccountValue.setFieldName("Line 1 Account value");
		line1_AccountValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[1]/td[3]");
		line1_AccountValue.setxPathDescription(
				"'" + line1_AccountValue.getFieldName() + "' on the submitted purchase order page");
		return line1_AccountValue;
	}

	public static FieldMaker line2_AccountValue() {
		FieldMaker line2_AccountValue = new FieldMaker();
		line2_AccountValue.setFieldName("Line 2 Account value");
		line2_AccountValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[3]");
		line2_AccountValue.setxPathDescription(
				"'" + line2_AccountValue.getFieldName() + "' on the submitted purchase order page");
		return line2_AccountValue;
	}

	public static FieldMaker line1_LineOfServiceValue() {
		FieldMaker line1_LineOfServiceValue = new FieldMaker();
		line1_LineOfServiceValue.setFieldName("Line 1 Line of Service value");
		line1_LineOfServiceValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[1]/td[4]");
		line1_LineOfServiceValue.setxPathDescription(
				"'" + line1_LineOfServiceValue.getFieldName() + "' on the submitted purchase order page");
		return line1_LineOfServiceValue;
	}

	public static FieldMaker line2_LineOfServiceValue() {
		FieldMaker line2_LineOfServiceValue = new FieldMaker();
		line2_LineOfServiceValue.setFieldName("Line 2 Line of Service value");
		line2_LineOfServiceValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[4]");
		line2_LineOfServiceValue.setxPathDescription(
				"'" + line2_LineOfServiceValue.getFieldName() + "' on the submitted purchase order page");
		return line2_LineOfServiceValue;
	}

	public static FieldMaker line1_AmountValue() {
		FieldMaker line1_AmountValue = new FieldMaker();
		line1_AmountValue.setFieldName("Line 1 Amount value");
		line1_AmountValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[1]/td[5]");
		line1_AmountValue.setxPathDescription("'" + line1_AmountValue.getFieldName() + "' on the submitted purchase order page");
		return line1_AmountValue;
	}

	public static FieldMaker line2_AmountValue() {
		FieldMaker line2_AmountValue = new FieldMaker();
		line2_AmountValue.setFieldName("Line 2 Amount value");
		line2_AmountValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[5]");
		line2_AmountValue.setxPathDescription("'" + line2_AmountValue.getFieldName() + "' on the submitted purchase order page");
		return line2_AmountValue;
	}

	public static FieldMaker line1_Chartfield1Value() {
		FieldMaker line1_Chartfield1Value = new FieldMaker();
		line1_Chartfield1Value.setFieldName("Line 1 Chartfield1 value");
		line1_Chartfield1Value.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[1]/td[6]");
		line1_Chartfield1Value.setxPathDescription(
				"'" + line1_Chartfield1Value.getFieldName() + "' on the submitted purchase order page");
		return line1_Chartfield1Value;
	}

	public static FieldMaker line2_Chartfield1Value() {
		FieldMaker line2_Chartfield1Value = new FieldMaker();
		line2_Chartfield1Value.setFieldName("Line 2 Chartfield1 value");
		line2_Chartfield1Value.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[6]");
		line2_Chartfield1Value.setxPathDescription(
				"'" + line2_Chartfield1Value.getFieldName() + "' on the submitted purchase order page");
		return line2_Chartfield1Value;
	}

	public static FieldMaker line1_DescriptionValue() {
		FieldMaker line1_DescriptionValue = new FieldMaker();
		line1_DescriptionValue.setFieldName("Line 1 Description value");
		line1_DescriptionValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[1]/td[7]");
		line1_DescriptionValue.setxPathDescription(
				"'" + line1_DescriptionValue.getFieldName() + "' on the submitted purchase order page");
		return line1_DescriptionValue;
	}

	public static FieldMaker line2_DescriptionValue() {
		FieldMaker line2_DescriptionValue = new FieldMaker();
		line2_DescriptionValue.setFieldName("Line 2 Description value");
		line2_DescriptionValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[7]");
		line2_DescriptionValue.setxPathDescription(
				"'" + line2_DescriptionValue.getFieldName() + "' on the submitted purchase order page");
		return line2_DescriptionValue;
	}

	public static FieldMaker line1_ReceiptDateValue() {
		FieldMaker line1_ReceiptDateValue = new FieldMaker();
		line1_ReceiptDateValue.setFieldName("Line 1 Receipt Date value");
		line1_ReceiptDateValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[1]/td[8]");
		line1_ReceiptDateValue.setxPathDescription(
				"'" + line1_ReceiptDateValue.getFieldName() + "' on the submitted purchase order page");
		return line1_ReceiptDateValue;
	}

	public static FieldMaker line2_ReceiptDateValue() {
		FieldMaker line2_ReceiptDateValue = new FieldMaker();
		line2_ReceiptDateValue.setFieldName("Line 2 Receipt Date value");
		line2_ReceiptDateValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[8]");
		line2_ReceiptDateValue.setxPathDescription(
				"'" + line2_ReceiptDateValue.getFieldName() + "' on the submitted purchase order page");
		return line2_ReceiptDateValue;
	}

	public static FieldMaker line1_AccountingDateValue() {
		FieldMaker line1_AccountingDateValue = new FieldMaker();
		line1_AccountingDateValue.setFieldName("Line 1 Accounting Date value");
		line1_AccountingDateValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[1]/td[9]");
		line1_AccountingDateValue.setxPathDescription(
				"'" + line1_AccountingDateValue.getFieldName() + "' on the submitted purchase order page");
		return line1_AccountingDateValue;
	}
	
	public static FieldMaker line2_AccountingDateValue() {
		FieldMaker line2_AccountingDateValue = new FieldMaker();
		line2_AccountingDateValue.setFieldName("Line 2 Accounting Date value");
		line2_AccountingDateValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[9]");
		line2_AccountingDateValue.setxPathDescription(
				"'" + line2_AccountingDateValue.getFieldName() + "' on the submitted purchase order page");
		return line2_AccountingDateValue;
	}

	public static FieldMaker line1_EquipmentValue() {
		FieldMaker line1_EquipmentValue = new FieldMaker();
		line1_EquipmentValue.setFieldName("Line 1 Equipment value");
		line1_EquipmentValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[1]/td[10]");
		line1_EquipmentValue.setxPathDescription(
				"'" + line1_EquipmentValue.getFieldName() + "' on the submitted purchase order page");
		return line1_EquipmentValue;
	}

	public static FieldMaker line2_EquipmentValue() {
		FieldMaker line2_EquipmentValue = new FieldMaker();
		line2_EquipmentValue.setFieldName("Line 2 Equipment value");
		line2_EquipmentValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[10]");
		line2_EquipmentValue.setxPathDescription(
				"'" + line2_EquipmentValue.getFieldName() + "' on the submitted purchase order page");
		return line2_EquipmentValue;
	}

	public static FieldMaker line1_MerchantValue() {
		FieldMaker line1_MerchantValue = new FieldMaker();
		line1_MerchantValue.setFieldName("Line 1 Merchant value");
		line1_MerchantValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[1]/td[11]");
		line1_MerchantValue.setxPathDescription(
				"'" + line1_MerchantValue.getFieldName() + "' on the submitted purchase order page");
		return line1_MerchantValue;
	}

	public static FieldMaker line2_MerchantValue() {
		FieldMaker line2_MerchantValue = new FieldMaker();
		line2_MerchantValue.setFieldName("Line 2 Merchant value");
		line2_MerchantValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[11]");
		line2_MerchantValue.setxPathDescription(
				"'" + line2_MerchantValue.getFieldName() + "' on the submitted purchase order page");
		return line2_MerchantValue;
	}

	public static FieldMaker line1_AttendeesValue() {
		FieldMaker line1_AttendeesValue = new FieldMaker();
		line1_AttendeesValue.setFieldName("Line 1 Attendees value");
		line1_AttendeesValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[1]/td[12]");
		line1_AttendeesValue.setxPathDescription(
				"'" + line1_AttendeesValue.getFieldName() + "' on the submitted purchase order page");
		return line1_AttendeesValue;
	}

	public static FieldMaker line2_AttendeesValue() {
		FieldMaker line2_AttendeesValue = new FieldMaker();
		line2_AttendeesValue.setFieldName("Line 2 Attendees value");
		line2_AttendeesValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[12]");
		line2_AttendeesValue.setxPathDescription(
				"'" + line2_AttendeesValue.getFieldName() + "' on the submitted purchase order page");
		return line2_AttendeesValue;
	}

	public static FieldMaker line1_ProjectValue() {
		FieldMaker line1_ProjectValue = new FieldMaker();
		line1_ProjectValue.setFieldName("Line 1 Project value");
		line1_ProjectValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[1]/td[13]");
		line1_ProjectValue.setxPathDescription(
				"'" + line1_ProjectValue.getFieldName() + "' on the submitted purchase order page");
		return line1_ProjectValue;
	}

	public static FieldMaker line2_ProjectValue() {
		FieldMaker line2_ProjectValue = new FieldMaker();
		line2_ProjectValue.setFieldName("Line 2 Project value");
		line2_ProjectValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[13]");
		line2_ProjectValue.setxPathDescription(
				"'" + line2_ProjectValue.getFieldName() + "' on the submitted purchase order page");
		return line2_ProjectValue;
	}

	public static FieldMaker line1_JobValue() {
		FieldMaker line1_JobValue = new FieldMaker();
		line1_JobValue.setFieldName("Line 1 Job value");
		line1_JobValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[1]/td[14]");
		line1_JobValue
				.setxPathDescription("'" + line1_JobValue.getFieldName() + "' on the submitted purchase order page");
		return line1_JobValue;
	}

	public static FieldMaker line2_JobValue() {
		FieldMaker line2_JobValue = new FieldMaker();
		line2_JobValue.setFieldName("Line 2 Job value");
		line2_JobValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[14]");
		line2_JobValue
				.setxPathDescription("'" + line2_JobValue.getFieldName() + "' on the submitted purchase order page");
		return line2_JobValue;
	}

	public static FieldMaker line1_ServiceDate() {
		FieldMaker line1_ServiceDate = new FieldMaker();
		line1_ServiceDate.setFieldName("Line 1 Service Date");
		line1_ServiceDate.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[1]/td[15]");
		line1_ServiceDate
				.setxPathDescription("'" + line1_ServiceDate.getFieldName() + "' on the submitted purchase order page");
		return line1_ServiceDate;
	}

	public static FieldMaker line2_ServiceDate() {
		FieldMaker line2_ServiceDate = new FieldMaker();
		line2_ServiceDate.setFieldName("Line 2 Service Date");
		line2_ServiceDate.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[15]");
		line2_ServiceDate
				.setxPathDescription("'" + line2_ServiceDate.getFieldName() + "' on the submitted purchase order page");
		return line2_ServiceDate;
	}

	public static FieldMaker line1_ReimbursableValue() {
		FieldMaker line1_ReimbursableValue = new FieldMaker();
		line1_ReimbursableValue.setFieldName("Line 1 Reimbursable value");
		line1_ReimbursableValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[1]/td[16]");
		line1_ReimbursableValue.setxPathDescription(
				"'" + line1_ReimbursableValue.getFieldName() + "' on the submitted purchase order page");
		return line1_ReimbursableValue;
	}

	public static FieldMaker line2_ReimbursableValue() {
		FieldMaker line2_ReimbursableValue = new FieldMaker();
		line2_ReimbursableValue.setFieldName("Line 2 Reimbursable value");
		line2_ReimbursableValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[16]");
		line2_ReimbursableValue.setxPathDescription(
				"'" + line2_ReimbursableValue.getFieldName() + "' on the submitted purchase order page");
		return line2_ReimbursableValue;
	}

	public static FieldMaker line1_MarkupPercentageValue() {
		FieldMaker line1_MarkupPercentageValue = new FieldMaker();
		line1_MarkupPercentageValue.setFieldName("Line 1 Markup Percentage value");
		line1_MarkupPercentageValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[1]/td[17]");
		line1_MarkupPercentageValue.setxPathDescription(
				"'" + line1_MarkupPercentageValue.getFieldName() + "' on the submitted purchase order page");
		return line1_MarkupPercentageValue;
	}

	public static FieldMaker line2_MarkupPercentageValue() {
		FieldMaker line2_MarkupPercentageValue = new FieldMaker();
		line2_MarkupPercentageValue.setFieldName("Line 2 Markup Percentage value");
		line2_MarkupPercentageValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[17]");
		line2_MarkupPercentageValue.setxPathDescription(
				"'" + line2_MarkupPercentageValue.getFieldName() + "' on the submitted purchase order page");
		return line2_MarkupPercentageValue;
	}

	public static FieldMaker line1_CustomerValue() {
		FieldMaker line1_CustomerValue = new FieldMaker();
		line1_CustomerValue.setFieldName("Line 1 Customer value");
		line1_CustomerValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[1]/td[18]");
		line1_CustomerValue.setxPathDescription(
				"'" + line1_CustomerValue.getFieldName() + "' on the submitted purchase order page");
		return line1_CustomerValue;
	}

	public static FieldMaker line2_CustomerValue() {
		FieldMaker line2_CustomerValue = new FieldMaker();
		line2_CustomerValue.setFieldName("Line 2 Customer value");
		line2_CustomerValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[18]");
		line2_CustomerValue.setxPathDescription(
				"'" + line2_CustomerValue.getFieldName() + "' on the submitted purchase order page");
		return line2_CustomerValue;
	}

	public static FieldMaker line1_VendorNameValue() {
		FieldMaker line1_VendorNameValue = new FieldMaker();
		line1_VendorNameValue.setFieldName("Line 1 Vendor Name value");
		line1_VendorNameValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[1]/td[19]");
		line1_VendorNameValue.setxPathDescription(
				"'" + line1_VendorNameValue.getFieldName() + "' on the submitted purchase order page");
		return line1_VendorNameValue;
	}

	public static FieldMaker line2_VendorNameValue() {
		FieldMaker line2_VendorNameValue = new FieldMaker();
		line2_VendorNameValue.setFieldName("Line 2 Vendor Name value");
		line2_VendorNameValue.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[19]");
		line2_VendorNameValue.setxPathDescription(
				"'" + line2_VendorNameValue.getFieldName() + "' on the submitted purchase order page");
		return line2_VendorNameValue;
	}

	public static FieldMaker line1_AttachmentsLink() {
		FieldMaker line1_AttachmentsLink = new FieldMaker();
		line1_AttachmentsLink.setFieldName("Line 1 Attachments Link");
		line1_AttachmentsLink.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[1]/td[20]/a");
		line1_AttachmentsLink.setxPathDescription(
				"'" + line1_AttachmentsLink.getFieldName() + "' on the submitted purchase order page");
		return line1_AttachmentsLink;
	}

	public static FieldMaker line2_AttachmentsLink() {
		FieldMaker line2_AttachmentsLink = new FieldMaker();
		line2_AttachmentsLink.setFieldName("Line 2 Attachments link");
		line2_AttachmentsLink.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[20]/a");
		line2_AttachmentsLink.setxPathDescription(
				"'" + line2_AttachmentsLink.getFieldName() + "' on the submitted purchase order page");
		return line2_AttachmentsLink;
	}

	public static FieldMaker line1_EditLink() {
		FieldMaker line1_EditLink = new FieldMaker();
		line1_EditLink.setFieldName("Line 1 Edit Link");
		line1_EditLink.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[1]/td[21]/a");
		line1_EditLink
				.setxPathDescription("'" + line1_EditLink.getFieldName() + "' on the submitted purchase order page");
		return line1_EditLink;
	}

	public static FieldMaker line2_EditLink() {
		FieldMaker line2_EditLink = new FieldMaker();
		line2_EditLink.setFieldName("Line 2 Edit Link");
		line2_EditLink.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[21]/a");
		line2_EditLink
				.setxPathDescription("'" + line2_EditLink.getFieldName() + "' on the submitted purchase order page");
		return line2_EditLink;
	}

	public static FieldMaker line1_VoidLink() {
		FieldMaker line1_VoidLink = new FieldMaker();
		line1_VoidLink.setFieldName("Line 1 Void Link");
		line1_VoidLink.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[1]/td[21]/span/a");
		line1_VoidLink
				.setxPathDescription("'" + line1_VoidLink.getFieldName() + "' on the submitted purchase order page");
		return line1_VoidLink;
	}

	public static FieldMaker line2_VoidLink() {
		FieldMaker line2_VoidLink = new FieldMaker();
		line2_VoidLink.setFieldName("Line 2 Void Link");
		line2_VoidLink.setTheXpath("//*[@id='voucherLineItems']/tbody/tr[2]/td[21]/span/a");
		line2_VoidLink
				.setxPathDescription("'" + line2_VoidLink.getFieldName() + "' on the submitted purchase order page");
		return line2_VoidLink;
	}

	public static FieldMaker lines_TotalValue() {
		FieldMaker lines_TotalValue = new FieldMaker();
		lines_TotalValue.setFieldName("Lines Total value");
		lines_TotalValue.setTheXpath("//*[@id='totalAmount']");
		lines_TotalValue
				.setxPathDescription("'" + lines_TotalValue.getFieldName() + "' on the submitted purchase order page");
		return lines_TotalValue;
	}

	public static FieldMaker DifferenceValue() {
		FieldMaker DifferenceValue = new FieldMaker();
		DifferenceValue.setFieldName("Difference value");
		DifferenceValue.setTheXpath("//*[@id='differenceDisplay']");
		DifferenceValue
				.setxPathDescription("'" + DifferenceValue.getFieldName() + "' on the submitted purchase order page");
		return DifferenceValue;
	}

	public static FieldMaker eVoucherInvoiceTitle() {
		FieldMaker eVoucherInvoiceTitle = new FieldMaker();
		eVoucherInvoiceTitle.setFieldName("eVoucher Invoice Title");
		eVoucherInvoiceTitle.setTheXpath("//*[@id='voucherInputForm']/div[2]/div[11]/span");
		eVoucherInvoiceTitle.setxPathDescription(
				"'" + eVoucherInvoiceTitle.getFieldName() + "' on the submitted purchase order page");
		return eVoucherInvoiceTitle;
	}

	public static FieldMaker invoiceDateEntry() {
		FieldMaker invoiceDateEntry = new FieldMaker();
		invoiceDateEntry.setFieldName("Invoice Date Entry");
		invoiceDateEntry.setTheXpath("//*[@id='invoiceDate']");
		invoiceDateEntry
				.setxPathDescription("'" + invoiceDateEntry.getFieldName() + "' on the submitted purchase order page");
		invoiceDateEntry.setErrorXPath("//*[@id='voucherForm.invoiceDate.errors']");
		invoiceDateEntry.setRequiredFieldErrorText("Invoice Date is required");
		return invoiceDateEntry;
	}

	public static FieldMaker invoiceAmountEntry() {
		FieldMaker invoiceAmountEntry = new FieldMaker();
		invoiceAmountEntry.setFieldName("Invoice Amount Entry");
		invoiceAmountEntry.setTheXpath("//*[@id='invoiceAmount']");
		invoiceAmountEntry.setxPathDescription(
				"'" + invoiceAmountEntry.getFieldName() + "' on the submitted purchase order page");
		invoiceAmountEntry.setErrorXPath("//*[@id='voucherForm.invoiceAmount.errors']");
		invoiceAmountEntry.setRequiredFieldErrorText("Invalid Invoice Amount");
		return invoiceAmountEntry;
	}

	public static FieldMaker statusValue() {
		FieldMaker statusValue = new FieldMaker();
		statusValue.setFieldName("Status Value");
		statusValue.setTheXpath("//*[@id='status']/table/tbody/tr[3]/td[2]");
		statusValue.setxPathDescription("'" + statusValue.getFieldName() + "' on the submitted purchase order page");
		return statusValue;
	}

	public static FieldMaker checkDateValue() {
		FieldMaker checkDateValue = new FieldMaker();
		checkDateValue.setFieldName("Check Date Value");
		checkDateValue.setTheXpath("//*[@id='status']/table/tbody/tr[4]/td[2]");
		checkDateValue
				.setxPathDescription("'" + checkDateValue.getFieldName() + "' on the submitted purchase order page");
		return checkDateValue;
	}

	public static FieldMaker notesEntry() {
		FieldMaker notesEntry = new FieldMaker();
		notesEntry.setFieldName("Notes Entry field");
		notesEntry.setTheXpath("//*[@id='voucherForm.apEntryNotes']");
		notesEntry.setxPathDescription("'" + notesEntry.getFieldName() + "' on the submitted purchase order page");
		return notesEntry;
	}

	public static FieldMaker invoiceNumberEntry() {
		FieldMaker invoiceNumberEntry = new FieldMaker();
		invoiceNumberEntry.setFieldName("Invoice Number Entry");
		invoiceNumberEntry.setTheXpath("//*[@id='invoiceNumber']");
		invoiceNumberEntry.setxPathDescription(
				"'" + invoiceNumberEntry.getFieldName() + "' on the submitted purchase order page");
		invoiceNumberEntry.setErrorXPath("//*[@id='voucherForm.invoiceNumber.errors']");
		invoiceNumberEntry.setRequiredFieldErrorText("Invoice Number is required");
		return invoiceNumberEntry;
	}

	public static FieldMaker remittanceEntry() {
		FieldMaker remittanceEntry = new FieldMaker();
		remittanceEntry.setFieldName("Remittance Entry");
		remittanceEntry.setTheXpath("//*[@id='remittance']");
		remittanceEntry
				.setxPathDescription("'" + remittanceEntry.getFieldName() + "' on the submitted purchase order page");
		remittanceEntry.setErrorXPath("//*[@id='voucherForm.remittance.errors']");
		remittanceEntry.setRequiredFieldErrorText("Remittance is required");
		return remittanceEntry;
	}

	public static FieldMaker entryDateValue() {
		FieldMaker entryDateValue = new FieldMaker();
		entryDateValue.setFieldName("Entry Date Value");
		entryDateValue.setTheXpath("//*[@id='status']/table/tbody/tr[3]/td[4]");
		entryDateValue
				.setxPathDescription("'" + entryDateValue.getFieldName() + "' on the submitted purchase order page");
		return entryDateValue;
	}

	public static FieldMaker checkACHNumberValue() {
		FieldMaker checkACHNumberValue = new FieldMaker();
		checkACHNumberValue.setFieldName("Check/ACH# Value");
		checkACHNumberValue.setTheXpath("//*[@id='status']/table/tbody/tr[4]/td[4]");
		checkACHNumberValue.setxPathDescription(
				"'" + checkACHNumberValue.getFieldName() + "' on the submitted purchase order page");
		return checkACHNumberValue;
	}

	public static FieldMaker eVoucherNotesHistoryTitle() {
		FieldMaker eVoucherNotesHistoryTitle = new FieldMaker();
		eVoucherNotesHistoryTitle.setFieldName("eVoucher Order Notes/History Title");
		eVoucherNotesHistoryTitle.setTheXpath("//*[@id='voucherInputForm']/div[2]/div[13]/span");
		eVoucherNotesHistoryTitle.setxPathDescription(
				"'" + eVoucherNotesHistoryTitle.getFieldName() + "' on the submitted purchase order page");
		return eVoucherNotesHistoryTitle;
	}

	public static FieldMaker eVoucherNotesHistoryEntry() {
		FieldMaker eVoucherNotesHistoryEntry = new FieldMaker();
		eVoucherNotesHistoryEntry.setFieldName("eVoucher Order Notes/History Entry");
		eVoucherNotesHistoryEntry.setTheXpath("//*[@id='voucherForm.historyNotes']");
		eVoucherNotesHistoryEntry.setxPathDescription(
				"'" + eVoucherNotesHistoryEntry.getFieldName() + "' on the submitted purchase order page");
		return eVoucherNotesHistoryEntry;
	}

	public static FieldMaker approvalsTitle() {
		FieldMaker approvalsTitle = new FieldMaker();
		approvalsTitle.setFieldName("Approvals Title");
		approvalsTitle.setTheXpath("//*[@id='voucherInputForm']/div[2]/div[15]/span");
		approvalsTitle
				.setxPathDescription("'" + approvalsTitle.getFieldName() + "' on the submitted purchase order page");
		return approvalsTitle;
	}

	public static FieldMaker levelDepartmentColumnTitle() {
		FieldMaker levelDepartmentColumnTitle = new FieldMaker();
		levelDepartmentColumnTitle.setFieldName("Level Department column title");
		levelDepartmentColumnTitle.setTheXpath("//*[@id='approversDiv']/table/thead/tr/th[2]");
		levelDepartmentColumnTitle.setxPathDescription(
				"'" + levelDepartmentColumnTitle.getFieldName() + "' on the submitted purchase order page");
		return levelDepartmentColumnTitle;
	}

	public static FieldMaker approverColumnTitle() {
		FieldMaker approverColumnTitle = new FieldMaker();
		approverColumnTitle.setFieldName("Approver column title");
		approverColumnTitle.setTheXpath("//*[@id='approversDiv']/table/thead/tr/th[3]");
		approverColumnTitle.setxPathDescription(
				"'" + approverColumnTitle.getFieldName() + "' on the submitted purchase order page");
		return approverColumnTitle;
	}

	public static FieldMaker statusColumnTitle() {
		FieldMaker statusColumnTitle = new FieldMaker();
		statusColumnTitle.setFieldName("Status column title");
		statusColumnTitle.setTheXpath("//*[@id='approversDiv']/table/thead/tr/th[4]");
		statusColumnTitle
				.setxPathDescription("'" + statusColumnTitle.getFieldName() + "' on the submitted purchase order page");
		return statusColumnTitle;
	}

	public static FieldMaker firstApprovalDepartment() {
		FieldMaker firstApprovalDepartment = new FieldMaker();
		firstApprovalDepartment.setFieldName("First Approver's Department");
		firstApprovalDepartment.setTheXpath("//*[@id='approversDiv']/table/tbody/tr[1]/td[2]");
		firstApprovalDepartment.setxPathDescription(
				"'" + firstApprovalDepartment.getFieldName() + "' on the submitted purchase order page");
		return firstApprovalDepartment;
	}

	public static FieldMaker firstApproverSelection() {
		FieldMaker firstApproverSelection = new FieldMaker();
		firstApproverSelection.setFieldName("First Approver");
		firstApproverSelection.setTheXpath("//*[@id='approversDiv']/table/tbody/tr[1]/td[3]");
		firstApproverSelection.setxPathDescription(
				"'" + firstApproverSelection.getFieldName() + "' on the submitted purchase order page");
		return firstApproverSelection;
	}

	public static FieldMaker firstApprovalStatus() {
		FieldMaker firstApprovalStatus = new FieldMaker();
		firstApprovalStatus.setFieldName("First Approval Status");
		firstApprovalStatus.setTheXpath("//*[@id='approversDiv']/table/tbody/tr[1]/td[4]");
		firstApprovalStatus.setxPathDescription(
				"'" + firstApprovalStatus.getFieldName() + "' on the submitted purchase order page");
		return firstApprovalStatus;
	}

	public static FieldMaker secondApprovalDepartment() {
		FieldMaker secondApprovalDepartment = new FieldMaker();
		secondApprovalDepartment.setFieldName("Second Approver's Department");
		secondApprovalDepartment.setTheXpath("//*[@id='approversDiv']/table/tbody/tr[2]/td[2]");
		secondApprovalDepartment.setxPathDescription(
				"'" + secondApprovalDepartment.getFieldName() + "' on the submitted purchase order page");
		return secondApprovalDepartment;
	}

	public static FieldMaker secondApproverSelection() {
		FieldMaker secondApproverSelection = new FieldMaker();
		secondApproverSelection.setFieldName("Second Approver");
		secondApproverSelection.setTheXpath("//*[@id='approversDiv']/table/tbody/tr[2]/td[3]");
		secondApproverSelection.setxPathDescription(
				"'" + secondApproverSelection.getFieldName() + "' on the submitted purchase order page");
		return secondApproverSelection;
	}

	public static FieldMaker secondApprovalStatus() {
		FieldMaker secondApprovalStatus = new FieldMaker();
		secondApprovalStatus.setFieldName("Second Approval Status");
		secondApprovalStatus.setTheXpath("//*[@id='approversDiv']/table/tbody/tr[2]/td[4]");
		secondApprovalStatus.setxPathDescription(
				"'" + secondApprovalStatus.getFieldName() + "' on the submitted purchase order page");
		return secondApprovalStatus;
	}

	public static FieldMaker thirdApprovalDepartment() {
		FieldMaker thirdApprovalDepartment = new FieldMaker();
		thirdApprovalDepartment.setFieldName("Third Approver's Department");
		thirdApprovalDepartment.setTheXpath("//*[@id='approversDiv']/table/tbody/tr[3]/td[2]");
		thirdApprovalDepartment.setxPathDescription(
				"'" + thirdApprovalDepartment.getFieldName() + "' on the submitted purchase order page");
		return thirdApprovalDepartment;
	}

	public static FieldMaker thirdApproverSelection() {
		FieldMaker thirdApproverSelection = new FieldMaker();
		thirdApproverSelection.setFieldName("Third Approver");
		thirdApproverSelection.setTheXpath("//*[@id='approversDiv']/table/tbody/tr[3]/td[3]");
		thirdApproverSelection.setxPathDescription(
				"'" + thirdApproverSelection.getFieldName() + "' on the submitted purchase order page");
		return thirdApproverSelection;
	}

	public static FieldMaker thirdApprovalStatus() {
		FieldMaker thirdApprovalStatus = new FieldMaker();
		thirdApprovalStatus.setFieldName("Third Approval Status");
		thirdApprovalStatus.setTheXpath("//*[@id='approversDiv']/table/tbody/tr[3]/td[4]");// *[@id="approversDiv"]/table/tbody/tr[3]/td[4]
		thirdApprovalStatus.setxPathDescription(
				"'" + thirdApprovalStatus.getFieldName() + "' on the submitted purchase order page");
		return thirdApprovalStatus;
	}

	public static FieldMaker saveButton() {
		FieldMaker saveButton = new FieldMaker();
		saveButton.setFieldName("Save Button");
		saveButton.setTheXpath("//*[@id='save']");
		saveButton.setxPathDescription("'" + saveButton.getFieldName() + "' on the submitted purchase order page");
		return saveButton;
	}

	public static FieldMaker submitForReviewButton() {
		FieldMaker submitForReviewButton = new FieldMaker();
		submitForReviewButton.setFieldName("Submit for Review Button");
		submitForReviewButton.setTheXpath("//*[@id='submitForReviewButton']");
		submitForReviewButton.setxPathDescription(
				"'" + submitForReviewButton.getFieldName() + "' on the submitted purchase order page");
		return submitForReviewButton;
	}

	public static FieldMaker voidButton() {
		FieldMaker voidButton = new FieldMaker();
		voidButton.setFieldName("Void Button");
		voidButton.setTheXpath("//*[@id='void']");
		voidButton.setxPathDescription("'" + voidButton.getFieldName() + "' on the submitted purchase order page");
		return voidButton;
	}

	public static FieldMaker printButton() {
		FieldMaker printButton = new FieldMaker();
		printButton.setFieldName("Submitted Purchase Order page Print button");
		printButton.setTheXpath("//*[@id='printButton']");
		printButton.setxPathDescription("'" + printButton.getFieldName() + "' on the 'Submitted Purchase Order' page");
		return printButton;
	}

	public static FieldMaker reviewedInvoiceTitle() {
		FieldMaker reviewedInvoiceTitle = new FieldMaker();
		reviewedInvoiceTitle.setFieldName("Reviewed Invoice title");
		reviewedInvoiceTitle.setTheXpath("//*[@id='voucherInputForm']/div[2]/div[7]/span");
		reviewedInvoiceTitle.setxPathDescription(
				"'" + reviewedInvoiceTitle.getFieldName() + "' on the reviewed purchase order page");
		return reviewedInvoiceTitle;
	}

	public static FieldMaker reviewedInvoiceDateValue() {
		FieldMaker reviewedInvoiceDateValue = new FieldMaker();
		reviewedInvoiceDateValue.setFieldName("Reviewed Invoice date value");
		reviewedInvoiceDateValue.setTheXpath("//*[@id='voucherForm.invoiceDate']");
		reviewedInvoiceDateValue.setxPathDescription(
				"'" + reviewedInvoiceDateValue.getFieldName() + "' on the reviewed purchase order page");
		return reviewedInvoiceDateValue;
	}

	public static FieldMaker reviewedInvoiceAmountValue() {
		FieldMaker reviewedInvoiceAmountValue = new FieldMaker();
		reviewedInvoiceAmountValue.setFieldName("Reviewed Invoice amount value");
		reviewedInvoiceAmountValue.setTheXpath("//*[@id='invoiceAmount']");
		reviewedInvoiceAmountValue.setxPathDescription(
				"'" + reviewedInvoiceAmountValue.getFieldName() + "' on the reviewed purchase order page");
		return reviewedInvoiceAmountValue;
	}

	public static FieldMaker reviewedStatusValue() {
		FieldMaker reviewedStatusValue = new FieldMaker();
		reviewedStatusValue.setFieldName("Review Status value");
		reviewedStatusValue.setTheXpath("//*[@id='status']/table/tbody/tr[3]/td[2]");
		reviewedStatusValue.setxPathDescription(
				"'" + reviewedStatusValue.getFieldName() + "' on the reviewed purchase order page");
		return reviewedStatusValue;
	}

	public static FieldMaker reviewedCheckDateValue() {
		FieldMaker reviewedCheckDateValue = new FieldMaker();
		reviewedCheckDateValue.setFieldName("Reviewed Check date value");
		reviewedCheckDateValue.setTheXpath("//*[@id='status']/table/tbody/tr[4]/td[2]");
		reviewedCheckDateValue.setxPathDescription(
				"'" + reviewedCheckDateValue.getFieldName() + "' on the reviewed purchase order page");
		return reviewedCheckDateValue;
	}

	public static FieldMaker reviewedNotesEntry() {
		FieldMaker reviewedNotesEntry = new FieldMaker();
		reviewedNotesEntry.setFieldName("Reviewed PO - Notes entry");
		reviewedNotesEntry.setTheXpath("//*[@id='status']/table/tbody/tr[5]/td[2]");
		reviewedNotesEntry
				.setxPathDescription("'" + reviewedNotesEntry.getFieldName() + "' on the reviewed purchase order page");
		return reviewedNotesEntry;
	}

	public static FieldMaker reviewedInvoiceNumberValue() {
		FieldMaker reviewedInvoiceNumberValue = new FieldMaker();
		reviewedInvoiceNumberValue.setFieldName("Reviewed PO - Invoice Number display");
		reviewedInvoiceNumberValue.setTheXpath("//*[@id='voucherForm.invoiceNumber']");
		reviewedInvoiceNumberValue.setxPathDescription(
				"'" + reviewedInvoiceNumberValue.getFieldName() + "' on the reviewed purchase order page");
		return reviewedInvoiceNumberValue;
	}

	public static FieldMaker reviewedRemittanceValue() {
		FieldMaker reviewedRemittanceValue = new FieldMaker();
		reviewedRemittanceValue.setFieldName("Reviewed PO - Remittance display");
		reviewedRemittanceValue.setTheXpath("//*[@id='status']/table/tbody/tr[2]/td[4]");
		reviewedRemittanceValue.setxPathDescription(
				"'" + reviewedRemittanceValue.getFieldName() + "' on the reviewed purchase order page");
		return reviewedRemittanceValue;
	}

	public static FieldMaker reviewedEntryDateValue() {
		FieldMaker reviewedEntryDateValue = new FieldMaker();
		reviewedEntryDateValue.setFieldName("Reviewed PO - Entry Date display");
		reviewedEntryDateValue.setTheXpath("//*[@id='status']/table/tbody/tr[3]/td[4]");
		reviewedEntryDateValue.setxPathDescription(
				"'" + reviewedEntryDateValue.getFieldName() + "' on the reviewed purchase order page");
		return reviewedEntryDateValue;
	}

	public static FieldMaker reviewedCheckACHValue() {
		FieldMaker reviewedCheckACHValue = new FieldMaker();
		reviewedCheckACHValue.setFieldName("Reviewed PO - Check/ACH# display");
		reviewedCheckACHValue.setTheXpath("//*[@id='status']/table/tbody/tr[4]/td[4]");
		reviewedCheckACHValue.setxPathDescription(
				"'" + reviewedCheckACHValue.getFieldName() + "' on the reviewed purchase order page");
		return reviewedCheckACHValue;
	}

	public static FieldMaker displayedApprovalsTitle() {
		FieldMaker displayedApprovalsTitle = new FieldMaker();
		displayedApprovalsTitle.setFieldName("Displayed Approvals title");
		displayedApprovalsTitle.setTheXpath("//*[@id='voucherInputForm']/div[2]/div[11]/span");
		displayedApprovalsTitle.setxPathDescription(
				"'" + displayedApprovalsTitle.getFieldName() + "' on the reviewed purchase order page");
		return displayedApprovalsTitle;
	}

	public static FieldMaker reviewedLevelColumnTitle() {
		FieldMaker reviewedLevelColumnTitle = new FieldMaker();
		reviewedLevelColumnTitle.setFieldName("Reviewed - Level column title");
		reviewedLevelColumnTitle.setTheXpath("//*[@id='approversDiv']/table/thead/tr[1]/th[1]");
		reviewedLevelColumnTitle.setxPathDescription(
				"'" + reviewedLevelColumnTitle.getFieldName() + "' on the reviewed purchase order page");
		return reviewedLevelColumnTitle;
	}

	public static FieldMaker reviewedLevelValue() {
		FieldMaker reviewedLevelValue = new FieldMaker();
		reviewedLevelValue.setFieldName("Reviewed - Level value");
		reviewedLevelValue.setTheXpath("//*[@id='approversDiv']/table/thead/tr[1]/td[1]");
		reviewedLevelValue
				.setxPathDescription("'" + reviewedLevelValue.getFieldName() + "' on the reviewed purchase order page");
		return reviewedLevelValue;
	}

	public static FieldMaker reviewedDepartmentColumnTitle() {
		FieldMaker reviewedDepartmentColumnTitle = new FieldMaker();
		reviewedDepartmentColumnTitle.setFieldName("Reviewed - Department column title");
		reviewedDepartmentColumnTitle.setTheXpath("//*[@id='approversDiv']/table/thead/tr[1]/th[2]");
		reviewedDepartmentColumnTitle.setxPathDescription(
				"'" + reviewedDepartmentColumnTitle.getFieldName() + "' on the reviewed purchase order page");
		return reviewedDepartmentColumnTitle;
	}

	public static FieldMaker reviewedDepartmentValue() {
		FieldMaker reviewedDepartmentValue = new FieldMaker();
		reviewedDepartmentValue.setFieldName("Reviewed - Department value");
		reviewedDepartmentValue.setTheXpath("//*[@id='approversDiv']/table/thead/tr[1]/td[2]");
		reviewedDepartmentValue.setxPathDescription(
				"'" + reviewedDepartmentValue.getFieldName() + "' on the reviewed purchase order page");
		return reviewedDepartmentValue;
	}

	public static FieldMaker reviewedApproverColumnTitle() {
		FieldMaker reviewedApproverColumnTitle = new FieldMaker();
		reviewedApproverColumnTitle.setFieldName("Reviewed - Approver column title");
		reviewedApproverColumnTitle.setTheXpath("//*[@id='approversDiv']/table/thead/tr[1]/th[3]");
		reviewedApproverColumnTitle.setxPathDescription(
				"'" + reviewedApproverColumnTitle.getFieldName() + "' on the reviewed purchase order page");
		return reviewedApproverColumnTitle;
	}

	public static FieldMaker reviewedApproverValue() {
		FieldMaker reviewedApproverValue = new FieldMaker();
		reviewedApproverValue.setFieldName("Reviewed - Approver value");
		reviewedApproverValue.setTheXpath("//*[@id='approversDiv']/table/thead/tr[1]/td[3]");
		reviewedApproverValue.setxPathDescription(
				"'" + reviewedApproverValue.getFieldName() + "' on the reviewed purchase order page");
		return reviewedApproverValue;
	}

	public static FieldMaker reviewedApprovalStatusTitle() {
		FieldMaker reviewedApprovalStatusTitle = new FieldMaker();
		reviewedApprovalStatusTitle.setFieldName("Reviewed - Approver column title");
		reviewedApprovalStatusTitle.setTheXpath("//*[@id='approversDiv']/table/thead/tr[1]/th[3]");
		reviewedApprovalStatusTitle.setxPathDescription(
				"'" + reviewedApprovalStatusTitle.getFieldName() + "' on the reviewed purchase order page");
		return reviewedApprovalStatusTitle;
	}

	public static FieldMaker reviewedApprovalStatusValue() {
		FieldMaker reviewedApprovalStatusValue = new FieldMaker();
		reviewedApprovalStatusValue.setFieldName("Reviewed - Approval Status value");
		reviewedApprovalStatusValue.setTheXpath("//*[@id='approversDiv']/table/thead/tr[1]/td[4]");
		reviewedApprovalStatusValue.setxPathDescription(
				"'" + reviewedApprovalStatusValue.getFieldName() + "' on the reviewed purchase order page");
		return reviewedApprovalStatusValue;
	}

	public static FieldMaker address1ValueLabel() {
		FieldMaker address1ValueLabel = new FieldMaker();
		address1ValueLabel.setFieldName("Address1 Value data");
		address1ValueLabel.setTheXpath("//*[@id=\"address1Cell\"]");// *[@id="address1Cell"]
		address1ValueLabel.setxPathDescription(
				"'" + address1ValueLabel.getFieldName() + "' data value on the 'Submitted Purchase Order' page");
		return address1ValueLabel;
	}

	public static FieldMaker address2ValueLabel() {
		FieldMaker address2ValueLabel = new FieldMaker();
		address2ValueLabel.setFieldName("Address2 Value data");
		address2ValueLabel.setTheXpath("//*[@id=\"address2Cell\"]");
		address2ValueLabel.setxPathDescription(
				"'" + address2ValueLabel.getFieldName() + "' data value on the 'Submitted Purchase Order' page");
		return address2ValueLabel;
	}

	public static FieldMaker attachmentFileNameEntryField() {
		FieldMaker attachmentFileNameEntryField = new FieldMaker();
		attachmentFileNameEntryField.setFieldName("Attachment file name entry field");
		attachmentFileNameEntryField.setTheXpath("//*[@id='fileDescription']");
		attachmentFileNameEntryField.setxPathDescription(
				"'" + attachmentFileNameEntryField.getFieldName() + "' on the 'Submitted Purchase Order' page");
		return attachmentFileNameEntryField;
	}

	public static FieldMaker attachmentUploadButton() {
		FieldMaker attachmentUploadButton = new FieldMaker();
		attachmentUploadButton.setFieldName("Attachment file upload button");
		attachmentUploadButton.setTheXpath("//*[@id='uploadFile']");
		attachmentUploadButton.setxPathDescription(
				"'" + attachmentUploadButton.getFieldName() + "' on the 'Submitted Purchase Order' page");
		return attachmentUploadButton;
	}

	public static FieldMaker attachmentFileNameDisplay() {
		FieldMaker attachmentFileNameDisplay = new FieldMaker();
		attachmentFileNameDisplay.setFieldName("Attached file displayed name.");
		attachmentFileNameDisplay.setTheXpath("//*[@id='attachments']/table/tbody/tr[1]/td[1]/a");
		attachmentFileNameDisplay.setxPathDescription(
				"'" + attachmentFileNameDisplay.getFieldName() + "' on the 'Submitted Purchase Order' page");
		return attachmentFileNameDisplay;
	}

	public static FieldMaker attachmentFileDescriptionDisplay() {
		FieldMaker attachmentFileDescriptionDisplay = new FieldMaker();
		attachmentFileDescriptionDisplay.setFieldName("Attached file displayed description.");
		attachmentFileDescriptionDisplay.setTheXpath("//*[@id='attachments']/table/tbody/tr[1]/td[2]");
		attachmentFileDescriptionDisplay.setxPathDescription(
				"'" + attachmentFileDescriptionDisplay.getFieldName() + "' on the 'Submitted Purchase Order' page");
		return attachmentFileDescriptionDisplay;
	}

	public static FieldMaker attachmentFileAssociationLink() {
		FieldMaker attachmentFileAssociationLink = new FieldMaker();
		attachmentFileAssociationLink.setFieldName("Attached file displayed description.");
		attachmentFileAssociationLink.setTheXpath("//*[@id='attachments']/table/tbody/tr[1]/td[3]/a");
		attachmentFileAssociationLink.setxPathDescription(
				"'" + attachmentFileAssociationLink.getFieldName() + "' on the 'Submitted Purchase Order' page");
		return attachmentFileAssociationLink;
	}

	public static FieldMaker attachmentFileDeleteLink() {
		FieldMaker attachmentFileDeleteLink = new FieldMaker();
		attachmentFileDeleteLink.setFieldName("Attached file delete link.");
		attachmentFileDeleteLink.setTheXpath("//*[@id='attachments']/table/tbody/tr[1]/td[4]/a");
		attachmentFileDeleteLink.setxPathDescription(
				"'" + attachmentFileDeleteLink.getFieldName() + "' on the 'Submitted Purchase Order' page");
		return attachmentFileDeleteLink;
	}

	public static FieldMaker attachmentFileFolderOption() {
		FieldMaker attachmentFileFolderOption = new FieldMaker();
		attachmentFileFolderOption.setFieldName("Attached file folder option.");
		attachmentFileFolderOption.setTheXpath("//*[@id='attachments']/table/tbody/tr[1]/td[5]");
		attachmentFileFolderOption.setxPathDescription(
				"'" + attachmentFileFolderOption.getFieldName() + "' on the 'Submitted Purchase Order' page");
		return attachmentFileFolderOption;
	}

	public static FieldMaker totalValue() {
		FieldMaker totalValue = new FieldMaker();
		totalValue.setFieldName("Total PO dollar amount");
		totalValue.setTheXpath("//*[@id='totalAmount']");
		totalValue.setxPathDescription(
				"'" + totalValue.getFieldName() + "' input text field on the 'Add/Edit Purchase Order' page");
		return totalValue;
	}

	// Approve Button
	public static FieldMaker approveButton() {
		FieldMaker approveButton = new FieldMaker();
		approveButton.setFieldName("Approve Button");
		approveButton.setTheXpath("//*[@id='approve']");
		approveButton
				.setxPathDescription("'" + approveButton.getFieldName() + "' on the submitted purchase order page");
		return approveButton;
	}

	// Reject Button
	public static FieldMaker rejectButton() {
		FieldMaker rejectButton = new FieldMaker();
		rejectButton.setFieldName("Reject Button");
		rejectButton.setTheXpath("//*[@id='reject']");
		rejectButton.setxPathDescription("'" + rejectButton.getFieldName() + "' on the submitted purchase order page");
		return rejectButton;
	}

	// Invoice Date on Pending Approval PO
	public static FieldMaker invoiceDate() {
		FieldMaker InvoiceDate = new FieldMaker();
		InvoiceDate.setFieldName("Invoice Date on Pending Approval PO");
		InvoiceDate.setTheXpath("//*[@id='voucherForm.invoiceDate']");
		InvoiceDate.setxPathDescription("'" + InvoiceDate.getFieldName() + "' on the submitted purchase order page");
		return InvoiceDate;
	}

	// Invoice Number on Pending Approval PO
	public static FieldMaker invoiceNumber() {
		FieldMaker InvoiceNumber = new FieldMaker();
		InvoiceNumber.setFieldName("Invoice Number on Pending Approval PO");
		InvoiceNumber.setTheXpath("//*[@id='voucherForm.invoiceNumber']");
		InvoiceNumber
				.setxPathDescription("'" + InvoiceNumber.getFieldName() + "' on the submitted purchase order page");
		return InvoiceNumber;
	}

	// Invoice Amount on Pending Approval PO
	public static FieldMaker invoiceAmount() {
		FieldMaker InvoiceAmount = new FieldMaker();
		InvoiceAmount.setFieldName("Invoice Amount on Pending Approval PO");
		InvoiceAmount.setTheXpath("//*[@id='invoiceAmount']");
		InvoiceAmount
				.setxPathDescription("'" + InvoiceAmount.getFieldName() + "' on the submitted purchase order page");
		return InvoiceAmount;
	}

	// Remittance on Pending Approval PO
	public static FieldMaker remittance() {
		FieldMaker Remittance = new FieldMaker();
		Remittance.setFieldName("Remittance on Pending Approval PO");
		Remittance.setTheXpath("//*[@id='voucherForm.remittance']");
		Remittance.setxPathDescription("'" + Remittance.getFieldName() + "' on the submitted purchase order page");
		return Remittance;
	}

	// Approved PO - Level data
	public static FieldMaker approvedPO_LevelData() {
		FieldMaker approvedPO_LevelData = new FieldMaker();
		approvedPO_LevelData.setFieldName("Approved PO - Level data");
		approvedPO_LevelData.setTheXpath("//*[@id='approversDiv']/table/tbody/tr/td[1]");
		approvedPO_LevelData.setxPathDescription(
				"'" + approvedPO_LevelData.getFieldName() + "' on the submitted purchase order page");
		return approvedPO_LevelData;
	}// *[@id='approversDiv']/table/tbody/tr/td[1]

	// Approved PO - Department data
	public static FieldMaker approvedPO_DepartmentData() {
		FieldMaker approvedPO_DepartmentData = new FieldMaker();
		approvedPO_DepartmentData.setFieldName("Approved PO - Department data");
		approvedPO_DepartmentData.setTheXpath("//*[@id='approversDiv']/table/tbody/tr/td[2]");
		approvedPO_DepartmentData.setxPathDescription(
				"'" + approvedPO_DepartmentData.getFieldName() + "' on the submitted purchase order page");
		return approvedPO_DepartmentData;
	}

	// Approved PO - Approver data
	public static FieldMaker approvedPO_ApproverData() {
		FieldMaker approvedPO_ApproverData = new FieldMaker();
		approvedPO_ApproverData.setFieldName("Approved PO - Approver data");
		approvedPO_ApproverData.setTheXpath("//*[@id='approversDiv']/table/tbody/tr/td[3]");
		approvedPO_ApproverData.setxPathDescription(
				"'" + approvedPO_ApproverData.getFieldName() + "' on the submitted purchase order page");
		return approvedPO_ApproverData;
	}

	// Approved PO - Status data
	public static FieldMaker approvedPO_StatusData() {
		FieldMaker approvedPO_StatusData = new FieldMaker();
		approvedPO_StatusData.setFieldName("Approved PO - Status data");
		approvedPO_StatusData.setTheXpath("//*[@id='approversDiv']/table/tbody/tr/td[4]");
		approvedPO_StatusData.setxPathDescription(
				"'" + approvedPO_StatusData.getFieldName() + "' on the submitted purchase order page");
		return approvedPO_StatusData;
	}
	
}
