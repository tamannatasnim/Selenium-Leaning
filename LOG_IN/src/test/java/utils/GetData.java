package utils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetData {

	static String projectpath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public GetData(String excelPath, String sheetName) {
		try {

			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {	
		//getCellData(0, 0);
		//getCellDataNumber(1, 1);
	}

	public static void getCellData(int rowNum, int colNum) {
		try {
			String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println("Cell Data: " +cellData);

		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
	public static void getCellDataNumber(int rowNum, int colNum) {
		try {
			double cellData2 = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println("Cell Data: " +cellData2);

		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}
}

