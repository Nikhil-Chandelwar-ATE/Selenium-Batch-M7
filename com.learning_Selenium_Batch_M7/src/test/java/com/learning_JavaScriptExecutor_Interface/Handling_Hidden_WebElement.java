package com.learning_JavaScriptExecutor_Interface;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Hidden_WebElement {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver(); 		//upcasting
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement element2 = driver.findElement(By.id("email"));
		js.executeScript("arguments[0].value='ram@gmail.com'", element2);
		Thread.sleep(2000);
		
		WebElement element3 = driver.findElement(By.linkText("Create new account"));
		js.executeScript("arguments[0].click()", element3);
		Thread.sleep(2000);
		
		WebElement element = driver.findElement(By.name("custom_gender"));
		js.executeScript("arguments[0].value='transgender'", element);
	}

}
