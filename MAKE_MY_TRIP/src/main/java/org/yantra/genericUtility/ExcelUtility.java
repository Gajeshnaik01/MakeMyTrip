package org.yantra.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class has reusalble methods
 * @author gajes
 *
 */
public final class ExcelUtility {
	/**
	 * this method is used o intailize excel
	 * @param excelPath
	 */
	private Workbook workbook;
	public void intializeExcel(String excelPath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * this method is used to get data from excel
	 * @param excelPath
	 * @return
	 */
	public String getExcelData(String sheetName,int rowNum,int cellNum) {

		DataFormatter dataFormat = new DataFormatter();
		String data= dataFormat.formatCellValue(workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		return data;
	}
	/**
	 * set excel data
	 * @param args
	 * 
	 */

	public void setExcelData(String sheetName,int rowNum,int cellNum,String result) {


		workbook.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(result);

	}


	/**
	 * this method is used to save the excel data.
	 * 
	 * 
	 */
	public void saveExceldata(String excelPath) {

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(excelPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * this method is used close the Workbook.
	 * 
	 */
	public void closeWorkbook() {
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * this method is used get last row value
	 * 
	 */
	public int getLastRowValue(String sheetName) {
		return workbook.getSheet(sheetName).getLastRowNum();
	}
}
