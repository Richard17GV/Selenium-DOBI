package testPack6;

import java.io.PrintWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FieldSetter {

	public static void dropdown(FieldMaker fieldName, String criteria, int critOptionNum, WebDriver driver,
			PrintWriter logfile) {
		if (criteria != "") {
			WebElement theDropdown = driver.findElement(By.xpath(fieldName.getTheXpath()));
			Select theSelect = new Select(theDropdown);
			theSelect.selectByValue(criteria);
		} else if (critOptionNum != -1) {
			WebElement theDropdown = driver.findElement(By.xpath(fieldName.getTheXpath()));
			Select theSelect = new Select(theDropdown);
			theSelect.selectByIndex(critOptionNum);
		} else {
			Utility.logger(logfile, "\tCould not select value for dropdown " + fieldName.getFieldName());
		}
		Utility.waitABit();
	}

	public static void textField(FieldMaker fieldName, String value, WebDriver driver) {
		fieldName.setValueString(value);
		driver.findElement(By.xpath(fieldName.getTheXpath())).clear();
		driver.findElement(By.xpath(fieldName.getTheXpath())).sendKeys(fieldName.getValueString());
	}

	public static void setAPSearchTextInputField(WebDriver driver, String textField, String selectvalue,
			testingVars testVars, PrintWriter logfile) {
		driver.findElement(By.xpath("//input[@name='" + textField + "']")).clear();
		driver.findElement(By.xpath("//input[@name='" + textField + "']")).sendKeys(selectvalue);
	}

	public static void setBoolean(FieldMaker fieldName, boolean value, WebDriver driver) {
		fieldName.setValueBoolean(value);

		if (!(driver.findElement(By.xpath(fieldName.getTheXpath())).getAttribute("value")
				.matches(String.valueOf(value)))) {
			driver.findElement(By.xpath(fieldName.getTheXpath())).click();
		}
	}

	public static void buttonClick(FieldMaker fieldName, WebDriver driver) {
		driver.findElement(By.xpath(fieldName.getTheXpath())).click();
	}

}
