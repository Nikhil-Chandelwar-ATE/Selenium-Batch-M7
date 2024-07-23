package com.practice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart_AddToCart {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(1000);
		driver.findElement(By.name("q")).sendKeys("iphone 15", Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='KzDlHZ'])[1]")).click();
//		a new window/tab will open, but our control is present in parent(1st) window
		Thread.sleep(1000);
		
//		this will fetch the handle of parent window/tab
		String parentWindowHandle = driver.getWindowHandle();
		
//		this will fetch the handle of all the windows/tabs
		Set<String> allWindowHandles = driver.getWindowHandles();
		
//		It will remove the parent window handle from all window handles
		allWindowHandles.remove(parentWindowHandle);
		
//		Printing the handles
		System.out.println(parentWindowHandle);
		System.out.println(allWindowHandles);
		
//		In this loop, we are switching to the child window/tab
		for (String windowHandle : allWindowHandles) {
			
//			will switch to the Child window
			driver.switchTo().window(windowHandle);
			driver.findElement(By.xpath("(//div[@class='XqNaEv'])[1]")).click();
			driver.close();
		}

//		Again we are switching back to parent window
		driver.switchTo().window(parentWindowHandle);
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}