package utilities;



	import java.io.FileInputStream;
	import java.io.IOException;

	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelUtility {
		static FileInputStream file;
		static XSSFWorkbook workbook;
		static XSSFSheet sh;
		public static String getStringData(int row,int col,String sheet) throws IOException
		{
			file=new FileInputStream("\"C:\\Users\\pooja\\git\\Seleniumbasics\\Seleniumbasics\\src\\test\\resources\\TestData1.xlsx\"");
			workbook= new XSSFWorkbook(file);
			sh=workbook.getSheet(sheet);
			XSSFRow r=sh.getRow(row);
			XSSFCell c=r.getCell(col);
			return c.getStringCellValue();
		}
		public static String getIntegerData(int row,int col,String sheet) throws IOException
		{
			file=new FileInputStream("\"C:\\Users\\pooja\\git\\Seleniumbasics\\Seleniumbasics\\src\\test\\resources\\TestData1.xlsx\"");
			workbook= new XSSFWorkbook(file);
			sh=workbook.getSheet(sheet);
			XSSFRow r=sh.getRow(row);
			XSSFCell c=r.getCell(col);
			int cellvalue=(int) c.getNumericCellValue();
			return String.valueOf(cellvalue);
		}

	}


