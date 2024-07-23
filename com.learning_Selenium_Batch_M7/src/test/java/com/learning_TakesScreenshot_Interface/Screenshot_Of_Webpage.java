package com.learning_TakesScreenshot_Interface;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot_Of_Webpage {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver(); 		//upcasting
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("laptop", Keys.ENTER);
		Thread.sleep(2000);
		
//		Type cast driver reference into TakesScreenshot type
		TakesScreenshot ts = (TakesScreenshot) driver;
		
//		Call the method of TakesScreenshot interface
		File source = ts.getScreenshotAs(OutputType.FILE);
		
//		Creating one file in main memory to store the screenshot
		File destination = new File("./screenshots/flipkart_SS2.jpeg");
		
//		this will copy the screenshot from RAM to Main Memory
		FileHandler.copy(source, destination);
		Thread.sleep(2000);
		driver.quit();
	}
}

