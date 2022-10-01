package ch.post.pf.nf.ta.baseutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class TestAutomationApp {

	private static final String CONFIG_PATH = "C:/NAPF_Test/args.properties";
	public static Properties prop = null;
	protected static String testCaseFilePath = null;

	static {
		try {
			prop = readPropertiesFile(CONFIG_PATH);
		} catch (IOException e) {
			System.out.println("Cannot read from properties file");
		}
		String excelFilePathToBecopied = "/MasterFile.xls";

		testCaseFilePath = prop.getProperty("TestDataFolederPath");
		String newSheetPath = "C:/NAPF_Test";

		try {

			InputStream fi = TestAutomationApp.class.getResourceAsStream(excelFilePathToBecopied);
			Object[][] testData = getDataFromExcelSheet(fi, 0);
			System.out.println("Test Data =" + testData);
			Workbook wb = createNewExcelFile(newSheetPath + "/" + "TestCases" + ".xls");

			for (int i = 1; i < testData[0].length; i++) {
				ArrayList<Object> headerOfMasterFile = new ArrayList<Object>();
				ArrayList<Object> respectiveRow = new ArrayList<Object>();

				addNewSheets((String) testData[i][0], newSheetPath + "/" + "TestCases" + ".xls", wb);

				for (int j = 0; j < testData[0].length; j++) {
					headerOfMasterFile.add(testData[0][j]);
					respectiveRow.add(testData[i][j]);
					/*
					 * System.out.println(headerOfMasterFile.get(j) + " " + respectiveRow.get(j));
					 */
				}

				contentCreation(testCaseFilePath + "/" + (String) testData[i][0] + ".xls",
						newSheetPath + "/" + "TestCases" + ".xls", (String) testData[i][0], headerOfMasterFile,
						respectiveRow, (String) testData[i][0], wb);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {

		CommonUtils.waitTime(2000);
		TestNG testng = new TestNG();
		ZipSecureFile.setMinInflateRatio(-1.0d);
		testng.setTestJar("NAPF-TestAutomation.jar");
		ZipSecureFile.setMinInflateRatio(-1.0d);
		testng.setXmlPathInJar("NAPFSuite.xml");
		ZipSecureFile.setMinInflateRatio(-1.0d);
		testng.run();
		System.out.println("test file location --> " + prop.getProperty("TestDataFolederPath"));
	}

	public static Object[][] getDataFromExcelSheet(InputStream inputStream, int i) {

		String value;
		Workbook wb;
		try {
			wb = new HSSFWorkbook(inputStream);

			Sheet sheet = wb.getSheetAt(i); // creating a Sheet object to retrieve object

			Iterator<Row> itr = sheet.iterator(); // iterating over excel file

			Object[][] object = new Object[sheet.getLastRowNum() + 1][sheet.getRow(0).getLastCellNum()];

			while (itr.hasNext()) {
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column
				while (cellIterator.hasNext())

				{
					Cell cell = cellIterator.next();
					CellType type = cell.getCellType();
					if (type == CellType.FORMULA) {
						switch (cell.getCachedFormulaResultType()) {
						case NUMERIC:
							object[row.getRowNum()][cell.getColumnIndex()] = cell.getNumericCellValue();
							break;
						case STRING:
							object[row.getRowNum()][cell.getColumnIndex()] = cell.getStringCellValue();
							break;
						}
					} else {
						switch (cell.getCellType()) {
						case STRING:
							object[row.getRowNum()][cell.getColumnIndex()] = cell.getStringCellValue();

							break;

						case NUMERIC:
							object[row.getRowNum()][cell.getColumnIndex()] = cell.getNumericCellValue();

							break;

						default:
						}

					}
				}
			}

			return object;
		} catch (IOException e) {

		}
		return null;

	}

	public static Workbook createNewExcelFile(String newSheetPath) {
		Workbook wb = new HSSFWorkbook();
		System.out.println("Inside createNewExcelFile - sheet path -" + newSheetPath);
		File file = new File(newSheetPath);
		System.out.println("Filepath testcases - : " + file.getAbsolutePath());
		try {

			if (file.exists()) {
				file.delete();
			}
			FileOutputStream fileOut = new FileOutputStream(newSheetPath);

			wb.write(fileOut);

			System.out.println("testcases path - " + file.getAbsolutePath());

			fileOut.close();

		} catch (Exception e) {

		}
		return wb;
	}

	public static void contentCreation(String fileToBeRead, String fileToBeWitten, String tabToBeModified,
			ArrayList<Object> masterHeaders, ArrayList<Object> respectiveRow, String sheetName,
			Workbook workbookToWrite) {

		try {
			masterHeaders.add("Headers");
			ArrayList<Object> tabs = new ArrayList<Object>();
			Sheet sheetFiled = null;
			int count = 0;
			int rowCountForCurrespondingRowAdding = 0;
			Workbook workbook = new HSSFWorkbook(new FileInputStream(new File(fileToBeRead)));
			Sheet sheetToWrite = workbookToWrite.getSheet(sheetName);
			Sheet sheet = workbook.getSheetAt(0);
			// InputStream fi = TestAutomationApp.class.getResourceAsStream(fileToBeRead);

			Object[][] bookData = getDataFromExcelSheet(new FileInputStream(new File(fileToBeRead)), 1);
			int numberOfTabs = workbook.getNumberOfSheets();
			String sheetName1 = null;

			for (int i = 0; i < bookData.length; i++) {
				masterHeaders.add(bookData[i][0]);
			}

			Row row = sheetToWrite.createRow(0);

			/* Short cell1 = row.getLastCellNum(); */

			// adding masterheaders
			Cell cell = row.createCell(0);
			for (Object field : masterHeaders) {
				cell = row.createCell(count++);
				if (field instanceof String) {
					cell.setCellValue((String) field);
				} else if (field instanceof Double) {
					cell.setCellValue((Double) field);
				}
			}

			count = 0;

			// adds corresponding rows from master file to testcase file tabs
			for (int i = 1; i < numberOfTabs; i++) {
				sheetName1 = workbook.getSheetName(i);
				tabs.add(workbook.getSheetName(i));

				Row row1 = sheetToWrite.createRow(++rowCountForCurrespondingRowAdding);

				/* Short cell1 = row.getLastCellNum(); */

				Cell cell1 = row1.createCell(0);
				for (Object field : respectiveRow) {

					cell1 = row1.createCell(count++);
					if (field instanceof String) {
						cell1.setCellValue((String) field);
					} else if (field instanceof Double) {
						cell1.setCellValue((Double) field);
					}
				}
				cell1 = row1.createCell(count++);
				cell1.setCellValue((String) tabs.get(i - 1));
				count = 0;

			}
			rowCountForCurrespondingRowAdding = 0;
			// adds all the "values" in all tabs accordingly from corresponding excel files
			for (int j = 1; j < workbook.getNumberOfSheets(); j++) {

				Object[][] bookData1 = getDataFromExcelSheet(new FileInputStream(new File(fileToBeRead)), j);

				Row row2 = sheetToWrite.getRow(j);

				Short cell1 = row2.getLastCellNum();
				int count1 = cell1;
				Cell cell2 = row2.createCell(cell1);
				for (int l = 0; l < bookData1.length; l++) {

					cell2 = row2.createCell(count1++);
					if (bookData1[l][1] instanceof String) {
						cell2.setCellValue((String) bookData1[l][1]);
					} else if (bookData1[l][1] instanceof Double) {
						cell2.setCellValue((Double) bookData1[l][1]);
					}
				}

			}

			FileOutputStream outputStream = new FileOutputStream(fileToBeWitten);
			workbookToWrite.write(outputStream);
			workbookToWrite.close();
			outputStream.close();

		} catch (Exception e) {

		}
	}

	public static void addNewSheets(String sheetName, String filePath, Workbook workbook) {
		try {
			workbook.createSheet(sheetName);

			FileOutputStream fileOut;

			fileOut = new FileOutputStream(filePath);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {

		}
	}

	public static Properties readPropertiesFile(String fileName) throws IOException {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fis.close();
		}
		return prop;
	}

}