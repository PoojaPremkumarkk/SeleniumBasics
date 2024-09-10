package utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ExcelUtility {
	static FileInputStream file;
	static XSSFWorkbook workbook;
	static XSSFSheet sh;

	public static String getStringData(int row, int col, String sheet) {
		try {

			String path = Constants.HOME_DIRECTORY + Constants.TESTDATA_EXCELPATH;
			file = new FileInputStream(path);
			workbook = new XSSFWorkbook(file);
			sh = workbook.getSheet(sheet);
			XSSFRow r = sh.getRow(row);
			XSSFCell c = r.getCell(col);
			String cellValue = c.getStringCellValue();
			workbook.close();
			file.close();
			return cellValue;
		} catch (Exception e) {
			throw new RuntimeException("Excel Sheet not found");
		}
	}

	public static String getIntegerData(int row, int col, String sheet) {
		try {
			String path = Constants.HOME_DIRECTORY + Constants.TESTDATA_EXCELPATH;
			file = new FileInputStream(path);

			sh = workbook.getSheet(sheet);
			XSSFRow r = sh.getRow(row);
			XSSFCell c = r.getCell(col);
			int cellValue = (int) c.getNumericCellValue();
			workbook.close();
			file.close();
			return String.valueOf(cellValue);
		} catch (Exception e) {
			throw new RuntimeException("Excel Sheet not found");
		}

	}
}
