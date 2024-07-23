package com.learning_Data_Driven_Testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generic_Utilities.WebDriver_Utility;

public class Fetching_Multiple_Data_From_Excel {

	@DataProvider(name = "flipkartSearch")
	public String[][] flipkartSearchData() throws Exception {

		FileInputStream fis = new FileInputStream("./src/test/resources/TestScripData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("searchData");
//		fetch the row count
		int rowCount = sheet.getPhysicalNumberOfRows();
//		fetch the cell count based on 1st row
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();

		String[][] data = new String[rowCount - 1][cellCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}

	@Test(dataProvider = "flipkartSearch")
	public void flipkartSearch(String data) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");

		driver.findElement(By.name("q")).sendKeys(data, Keys.ENTER);
		Thread.sleep(2000);
		WebDriver_Utility.getScreenshotOfWebpage(driver);
		driver.quit();
	}
}