package testPack6;

public class FieldMaker {

	private String fieldName;
	private String theXpath;
	private String xPathDescription;
	private int dropDownSize;
	private int valueInt;
	private String valueString;
	private double valueDouble;
	private boolean valueBoolean;
	private String errorXPath;
	private String requiredFieldErrorText;
	private String requiredFieldErrorBorderColor;
	private String requiredFieldErrorFieldColor;

	public int getValueInt() {
		return valueInt;
	}

	public void setValueInt(int valueInt) {
		this.valueInt = valueInt;
	}

	public String getValueString() {
		return valueString;
	}

	public void setValueString(String value) {
		this.valueString = value;
	}

	public double getValueDouble() {
		return valueDouble;
	}

	public void setValueDouble(double valueDouble) {
		this.valueDouble = valueDouble;
	}

	public boolean isValueBoolean() {
		return valueBoolean;
	}

	public void setValueBoolean(boolean valueBoolean) {
		this.valueBoolean = valueBoolean;
	}

	public int getDropDownSize() {
		return dropDownSize;
	}

	public void setDropDownSize(int dropDownSize) {
		this.dropDownSize = dropDownSize;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getTheXpath() {
		return theXpath;
	}

	public void setTheXpath(String theXpath) {
		this.theXpath = theXpath;
	}

	public String getxPathDescription() {
		return xPathDescription;
	}

	public void setxPathDescription(String xPathDescription) {
		this.xPathDescription = xPathDescription;
	}

	public String getRequiredFieldErrorText() {
		return requiredFieldErrorText;
	}

	public void setRequiredFieldErrorText(String requiredFieldErrorText) {
		this.requiredFieldErrorText = requiredFieldErrorText;
	}

	public String getErrorXPath() {
		return errorXPath;
	}

	public void setErrorXPath(String errorXPath) {
		this.errorXPath = errorXPath;
	}

	public String getRequiredFieldErrorBorderColor() {
		return requiredFieldErrorBorderColor;
	}

	public void setRequiredFieldErrorBorderColor(String requiredFieldErrorBorderColor) {
		this.requiredFieldErrorBorderColor = requiredFieldErrorBorderColor;
	}

	public String getRequiredFieldErrorFieldColor() {
		return requiredFieldErrorFieldColor;
	}

	public void setRequiredFieldErrorFieldColor(String requiredFieldErrorFieldColor) {
		this.requiredFieldErrorFieldColor = requiredFieldErrorFieldColor;
	}

}
