package com.Vtiger.genericUtil;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public String readExcelData(String Sheet2, int row, int cell) throws Throwable {
		FileInputStream fis = new FileInputStream(LautoConstant.Excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		String excelValue = wb.getSheet(Sheet2).getRow(row).getCell(cell).getStringCellValue();
		return excelValue;
	}

	public String readExcelData(String path, String Sheet2, int row, int cell)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		String excelValue = wb.getSheet(Sheet2).getRow(row).getCell(cell).toString();
		return excelValue;
	}

	/**
	 * 
	 * @param key
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public int getLastRow(String Sheet2) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(LautoConstant.Excelfilepath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(Sheet2);
		return sheet.getLastRowNum();

	}

	public String ReaddatafromExcel(String Sheet2,int cell, String DDvalue)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(LautoConstant.Excelfilepath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(Sheet2);
		int lastrow = getLastRow(Sheet2);
		String value = "null";
		for (int i = 0; i <= lastrow; i++) {
			value = sheet.getRow(i).getCell(cell).getStringCellValue();
			if (value.equalsIgnoreCase(DDvalue)) {
				break;
			}
		}
		return value;

	}
}