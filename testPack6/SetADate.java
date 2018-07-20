package testPack6;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SetADate {


	public static String getCurrentDate() {

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String date1 = dateFormat.format(date);

		return date1;
	}

	public static void useDatePicker(WebDriver driver, FieldMaker dateField, FieldMaker monthPicker,
			FieldMaker monthDisplay, FieldMaker yearDisplay, String chosenDate, testingVars testVars,
			PrintWriter logfile) {
		// from chosenDate, determine month and year string
		// triple click between the two date fields to select the desired field based on
		// click on left or right datepicker arrows until the expected month and date
		// string appears
		// obtain the date from the chosenDate string
		// search on each date field in the date picker until the chosenDate is found
		// click on the discovered date field.
		// logger(logfile, "\tEntering useDatePicker()");

		String inDate = standardizeDateString(chosenDate);

		// from chosenDate, determine month and year string
		String inMonth = "";
		int i = 0;
		String inDay = "0";

		// logger(logfile,inDate);
		if (inDate.substring(3, 4).matches("0")) {
			inDay = inDate.substring(4, 5);
		} else {
			inDay = inDate.substring(3, 5);
		}

		// logger(logfile, "\tchoosing Month");
		String inYear = inDate.substring(6);
		inMonth = inDate.substring(0, 2);

		String theMonth = getVerbalMonth(inMonth);

		// logger(logfile, "\tmanipulating datepicker");
		driver.findElement(By.xpath(dateField.getTheXpath())).click();
		Utility.waitABit();
		String toolMonth = driver.findElement(By.xpath(monthDisplay.getTheXpath())).getText().trim(); // month field in
																										// datepicker
		String toolYear = driver.findElement(By.xpath(yearDisplay.getTheXpath())).getText().trim(); // year field in
																									// datepicker

		while (i < 30) {
			if (toolYear.matches(inYear)) {
				if (!(toolMonth.matches(theMonth))) {
					driver.findElement(By.xpath(monthPicker.getTheXpath())).click();
					i++;
					toolMonth = driver.findElement(By.xpath(monthDisplay.getTheXpath())).getText().trim();
					Utility.logger(logfile, "\tExpected month is " + theMonth + ". DatePicker Month is " + toolMonth);
				} else {
					break;
				}
			} else {

				driver.findElement(By.xpath(monthPicker.getTheXpath())).click();
				i++;

				toolYear = driver.findElement(By.xpath(yearDisplay.getTheXpath())).getText().trim();
				Utility.logger(logfile, "\tExpected year is " + inYear + ". DatePicker Year is " + toolYear);
			}
		}

		int intyear = Integer.parseInt(inYear);
		int intmonth = Integer.parseInt(inMonth);
		int intday = Integer.parseInt(inDay);
		LocalDate dt = LocalDate.of(intyear, intmonth, intday);
		String calDay = String.valueOf(dt.getDayOfWeek());

		int tdDay = findNumDayOfWeek(calDay);

		int weekNum = 1 + (intday / 7);

		// click on the calendar date
		driver.findElement(By.xpath(
				"//*[@id='ui-datepicker-div']/table/tbody/tr[" + Integer.toString(weekNum) + "]/td[" + tdDay + "]/a"))
				.click();
		// logger(logfile, "\tComparing the set date with expected date.");
		String setDate = driver.findElement(By.xpath(dateField.getTheXpath())).getAttribute("value");
		if (setDate.matches(".*" + inDate + ".*")) {
			Utility.logger(logfile,
					"\tExpected Date, " + inDate + " is set in the " + dateField.getFieldName() + " field. PASS");
			++testVars.PassResult;
		} else {
			Utility.logger(logfile,
					"\t" + setDate + "is set in the " + dateField.getFieldName()
							+ " field instead of the expected date, " + inDate
							+ ". FAIL -------------------------------------");
			++testVars.FailResult;
		}
	}

	public static String standardizeDateString(String chosenDate) {
		// fix date by embedding zeroes to have a mm/dd/yyyy format.
		String inDate = "";
		if (chosenDate.substring(1, 2).matches(".*/.*")) {
			inDate = "0" + chosenDate;
		} else {
			inDate = chosenDate;
		}
		if (inDate.substring(4, 5).matches(".*/.*")) {
			inDate = inDate.substring(0, 3) + "0" + inDate.substring(3);
		}
		return inDate;
	}

	public static String getVerbalMonth(String numMonth) {

		String theMonth = "";
		switch (numMonth) {
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
		return theMonth;
	}

	public static int findNumDayOfWeek(String calDay) {
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

		return tdDay;
	}

}
