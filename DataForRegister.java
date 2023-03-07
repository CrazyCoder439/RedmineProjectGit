package dataDriven1;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataForRegister
{
	static String data;
	
	
	
	public static String readData(int rowNo, int cellNo) throws IOException 
{
	
		try{
			// To read the file in data mode use this Pre-define class FiledataStream
			// file is reference variable point to the excel sheet data
			FileInputStream file = new FileInputStream("/Users/rajusaru/Desktop/Selenium/DataDriven/data.xlsx");
			XSSFWorkbook excel = new XSSFWorkbook(file);// file is created under this workbook
			excel.setForceFormulaRecalculation(true); // different data formulated
			XSSFFormulaEvaluator.evaluateAllFormulaCells(excel);
			XSSFSheet sheet = excel.getSheet("RegisterData");//Providing my sheet name "RegisterData"
			
			XSSFCell cell = sheet.getRow(rowNo).getCell(cellNo);
			data = cell.getStringCellValue();
			file.close();
			excel.close();
		
			FileInputStream inputStream = new FileInputStream("/Users/rajusaru/Desktop/Selenium/DataDriven/LoginInput.xlsx");
	        XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(inputStream);
	        XSSFSheet newsheet = workbook.getSheetAt(0);
	        
	        XSSFCell newcell = newsheet.getRow(rowNo).createCell(cellNo);
	        newcell.setCellValue(data);
	        inputStream.close();
	        
            FileOutputStream outputStream = new FileOutputStream("/Users/rajusaru/Desktop/Selenium/DataDriven/LoginInput.xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            
            System.out.println("Data had been written");
			//System.out.println(data);
		}
		
		catch(Exception e)
			{
			System.out.println("I'm in read data catch block");
			}
		return data;
	
			
	
}
	
}
	/*public static void writeData(int cellNum, int rowNum, String data) 
	{
		
		try {
				
			
			
		catch(Exception e)
			{
			System.out.println("I'm in write Data catch block");
			}
		
		
		
		*/
		
		

	
	




