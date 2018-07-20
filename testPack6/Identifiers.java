package testPack6;

public class Identifiers {

	public static String makeUniqueID() {
		// here's a little utility to create a 'unique' string per run.
		long unixTime = System.currentTimeMillis() / 1000L;
		String uniqueValue = Long.toHexString(unixTime).toUpperCase();
		Utility.waitABit(2);
		return (uniqueValue);
	}

	public String uniqueIDTester() {

		// Run this utility for several hours or days to see when duplicate ids get
		// generated.
		// June 26, 2018: ran for 18 hours without duplicates being generated.
		long unixTime = System.currentTimeMillis() / 1000L;
		String uniqueValue = Long.toHexString(unixTime).toUpperCase();
		Utility.waitABit(2);

		int k = 0;
		for (k = 0; k <= 90000000; k++) {
			unixTime = System.currentTimeMillis() / 1000L;
			String unique_no = Long.toHexString(unixTime).toUpperCase();
			System.out.println(String.valueOf(k) + ": unique_no is " + unique_no);
			// unique_no = uniqueValue;
			if (unique_no == uniqueValue) {
				System.out.println("Duplicate 'unique' string created. FAIL -------------------");
				return ("Duplicated string is " + unique_no + ". Duplication happened at " + String.valueOf(k)
						+ " seconds.");

			}
			Utility.waitABit(2);
		}
		return ("String duplication never occurred after " + String.valueOf(k) + " seconds.");
	}

}
