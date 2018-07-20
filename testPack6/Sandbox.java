package testPack6;

import java.io.PrintWriter;

import org.openqa.selenium.WebDriver;

public class Sandbox {

	public static void main(String[] args) {

		for (int i = 1; i <= 1; i++) {
			System.out.println("i is " + i);
		}
		
		
		
		// INITIALIZE DOBI ---------------------------------------------------------------------
		testingVars testVars = new testingVars();
		Utility.varInit(testVars);
		testVars.logTitle = "AddEditPurchaseOrdersPage_";

		PrintWriter logfile = Utility.initializeLogFile(testVars);
		WebDriver driver = Utility.initializeDOBIWebPage();

		Utility.logger(logfile, "\nDOBI Test: Verify 'Add Purchase Order' as an Admin user.");

		Utility.loginToDOBI(driver, logfile, testVars);
		Utility.changeDepartment(driver, testVars, logfile);
		// INITIALIZE DOBI ---------------------------------------------------------------------

		
		
		
		
		
	}
}