package testPack6;

import java.io.PrintWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepartmentCyclingResearch {
	public static void main(String[] args) {
		
		testingVars testVars = new testingVars();
		Utility.varInit(testVars);
		testVars.logTitle = "DepartmentResearch_";
		
		PrintWriter logfile = Utility.initializeLogFile(testVars);
		WebDriver driver = Utility.initializeDOBIWebPage();		
		
		Utility.logger(logfile, "\nDOBI Test: DOBI Researcher: cycle through departments for page variations.");

		Utility.loginToDOBI(driver, logfile, testVars); 
				
		Utility.logger(logfile, "\nThis is a utility for researching page behavior based on selected department.");
		
		String logLine = "";
		int numDepts = 0;
		boolean deptFound = false;

		int i_end = Utility.findDropdownSize(driver, "departmentDropdownList", "","//*[@id='departmentDropdownList']");
		Utility.logger(logfile,  "There are " + String.valueOf(i_end) + " departments.");

		Utility.logger(logfile, "\nIn the following list of Purchase order line item fields, capitalized names are enabled fields. lowercase names are disabled fields.");
		
		for (int i = 1; i <= i_end; i++) {
			try {
				Utility.chooseDropdownSelection(driver, "departmentDropdownList", "", i,  logfile);
				deptFound = true;
			} catch (Exception e) {
				
			}
			if (deptFound) {
				logLine = "";
				Utility.navigateToAddEditPurchaseOrder(driver, testVars, logfile) ;
				logLine = "Department = " +	Utility.findDropdownSelection(driver, "departmentDropdownList", "") + "  PO Line fields: ";
				Utility.waitABit();
				++numDepts; 
				try {
				driver.findElement(By.xpath("//select[@id='lineOfService']")).getAttribute("disabled").matches(".*true.*");
				logLine = logLine + " los, ";
			} catch (Exception e) {
				logLine = logLine + " LINEofSERVICE";
			}
			try {
				driver.findElement(By.xpath("//select[@id='chartfield1WithEvent']")).getAttribute("disabled").matches(".*true.*");
				logLine = logLine + " chrtfld";
			} catch (Exception e) {
				logLine = logLine + " CHARTFIELD1";
			}
			try {
				driver.findElement(By.xpath("//select[@id='projectWithEvent']")).getAttribute("disabled").matches(".*true.*");
				logLine = logLine + " proj";
			} catch (Exception e) {
				logLine = logLine + " PROJECT";
			}
			try {
				driver.findElement(By.xpath("//select[@id='jobWithEvent']")).getAttribute("disabled").matches(".*true.*");
				logLine = logLine + " jb";
			} catch (Exception e) {
				logLine = logLine + " JOB";
			}
			try {
				driver.findElement(By.xpath("//select[@id='equipmentWithEvent']")).getAttribute("disabled").matches(".*true.*");
				logLine = logLine + " equipm";
			} catch (Exception e) {
				logLine = logLine + " EQUIPMENT";
			}
			deptFound = false;
			Utility.logger(logfile,  "\t" + String.valueOf(numDepts) + ": " + logLine + ".");
			}
		}
	}
}
