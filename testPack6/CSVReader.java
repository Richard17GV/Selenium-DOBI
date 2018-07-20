package testPack6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
	public static void main(String[] args) {

	}

	public static String[] readPODataCSV(int lineNumber) {
		String csvFile = "C:/WebDriverWork/DOBI_tests_1/data/POData1.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		String poData[] = { "0" };
		int lineNum = 1;
		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// choose the data line to store into the array
				if (lineNum == lineNumber) {
					// use comma as separator
					poData = line.split(cvsSplitBy);
				}
				++lineNum;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return poData;
	}
}

