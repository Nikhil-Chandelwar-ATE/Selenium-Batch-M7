package com.learning_Data_Driven_Testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.generic_Utilities.File_Utility;
import com.generic_Utilities.WebDriver_Utility;

public class Fetching_Single_Data_From_Excel_File {

	@Test
	public void flipkartSearch() throws InterruptedException, EncryptedDocumentException, IOException {
		
//		CREATE JAVA REPRESENTATION OBJECT
		FileInputStream fis = new FileInputStream("./src/test/resources/TestScripData.xlsx");
		
//		TRAVERSE TO THE WORKBOOK(OPEN THE WORKBOOK IN READ MODE)
		Workbook book = WorkbookFactory.create(fis);
		
//		TRAVERSE TO SPECIFIC SHEET BY PROVIDING THE NAME
		Sheet sheet = book.getSheet("searchData");
		
//		TRAVERSE TO THE SPECIFIC ROW BY USING INDEX
		Row row = sheet.getRow(1);
		
//		TRAVERSE TO THE SPECIFIC CELL BY USING INDEX
		Cell cell = row.getCell(0);
		
//		FETCH THE DATA PRESENT IN THE CELL
		String value = cell.getStringCellValue();	//toString();
		
		String value2 = File_Utility.getSingleDataFromExcel("searchData", 4, 0);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.name("q")).sendKeys(value2, Keys.ENTER);
		Thread.sleep(2000);
		WebDriver_Utility.getScreenshotOfWebpage(driver);
		driver.quit();
	}
}
