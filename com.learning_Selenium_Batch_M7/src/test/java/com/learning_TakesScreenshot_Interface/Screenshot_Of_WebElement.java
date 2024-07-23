package com.learning_TakesScreenshot_Interface;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot_Of_WebElement {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver(); 		//upcasting
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		
//		Find the WebElement, of which we want to take the screenshot
		WebElement element = driver.findElement(By.xpath("(//div[@class='_1yQHx8 _2UnIQ_ _3ak8Rd _2y8Yzt'])[1]"));
		
//		Call the method of TakesScreenshot interface using WebElement reference variable
		File source = element.getScreenshotAs(OutputType.FILE);
		
//		Creating one file in main memory to store the screenshot
		File destination = new File("./screenshots/AllTabs_SS.png");

//		this will copy the screenshot from RAM to Main Memory
		FileHandler.copy(source, destination);
		
		Thread.sleep(2000);
		driver.quit();
	}

}
