package com.vtiger.genericlibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataStorage {
	static FileInputStream fis;
	static Properties pobj = new Properties();
	public String getDataFromProperty(String key) throws IOException
	{
		fis = new FileInputStream("./datacontainer/DataForVtigerLogin1.properties");//updated path
		pobj.load(fis);
		return pobj.getProperty(key);
	}
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws IOException
	{
		fis = new FileInputStream("D:\\Automation Files\\DDT\\TestScriptData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		return book.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	}
	
	
	public void updateCellDataValue(String sheetName, int rowNum, int cellNum, String newData) throws Exception
	{
		FileInputStream fis = new FileInputStream("D:\\Automation Files\\DDT\\TestScriptData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Cell cel = book.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		cel.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream("D:\\Automation Files\\DDT\\TestScriptData.xlsx");
		book.write(fos);
		fos.flush();
		}
	public void addNewDataInExcel(String sheetName, int rowNum, int cellNum, String newData) throws Exception, IOException
	{
		FileInputStream fis = new FileInputStream("D:\\Automation Files\\DDT\\TestScriptData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Cell cel = book.createSheet(sheetName).createRow(rowNum).createCell(cellNum);
		cel.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream("D:\\Automation Files\\DDT\\TestScriptData.xlsx");
		book.write(fos);
		fos.flush();
	}	
}
