package basic;

//import java.io.FileInputStream;
import java.io.IOException;
/*
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
*/
import commonUtils.ExcelUtil;

public class Vtiger1Test2 {

	public static void main(String[] args) throws IOException //, EncryptedDocumentException 
	{
		// TODO Auto-generated method stub
		
		//To read data from Excel file
		/*
		//Step1: Create object of FileInputStream class--- to fetch the data from external resource
		FileInputStream fis = new FileInputStream("src\\test\\resources\\Data.xlsx");
		
		//Step2: call create(inputStream)---- to read the data from excel
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step3: call getSheet(String name)----- getting the path from excel sheet
		Sheet sh = wb.getSheet("Organizations");
		
		//Step4: call a getRow(int rownum)------ to know from which row we are getting data
		Row rw = sh.getRow(0);
		
		//Step5: call a getCell(int cellnum)----- to know from which cell we are getting data
		Cell cl = rw.getCell(1);
		
		//Step6: call a getStringCellValue()----- it will give data from the excel sheet( only string data )
		String data = cl.getStringCellValue();
		
		System.out.println(data);
		*/
		
		ExcelUtil eutil = new ExcelUtil();
		String a = eutil.getDataFromExcelFile("Organizations", 1, 0);
		
		System.out.println(a);
	}

}
