package com.learning_JavaScriptExecutor_Interface;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrolling_Scroll_Bar {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0, 200)");
//		
//		Thread.sleep(2000);
//		js.executeScript("window.scrollBy(0, 200)");
//		
//		Thread.sleep(2000);
//		js.executeScript("window.scrollBy(0, -300)");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 200)");
		
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, 200)");
	}
}
