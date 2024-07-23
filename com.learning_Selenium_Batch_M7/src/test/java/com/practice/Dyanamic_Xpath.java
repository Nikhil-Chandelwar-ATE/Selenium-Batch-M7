package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dyanamic_Xpath {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		
		driver.findElement(By.name("q")).sendKeys("iphone 15");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		String name = driver.findElement(By.xpath("//div[text()='Apple iPhone 15 (Black, 128 GB)']")).getText();
		System.out.println(name);
		String price =  driver.findElement(By.xpath("//div[text()='Apple iPhone 15 (Black, 128 GB)']/../..//div[@class='Nx9bqj _4b5DiR']")).getText();
		System.out.println(price);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='✕']")).click();
		
		driver.findElement(By.name("q")).sendKeys("laptop");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		String name2 = driver.findElement(By.xpath("//div[text()='ASUS Vivobook 15 Intel Core i3 12th Gen 1215U - (8 GB/SSD/512 GB SSD/Windows 11 Home) X1502ZA-EJ953WS ...']")).getText();
		System.out.println(name2);
		String price2 =  driver.findElement(By.xpath("//div[text()='ASUS Vivobook 15 Intel Core i3 12th Gen 1215U - (8 GB/SSD/512 GB SSD/Windows 11 Home) X1502ZA-EJ953WS ...']/../..//div[@class='Nx9bqj _4b5DiR']")).getText();
		System.out.println(price2);
		driver.navigate().back();
		Thread.sleep(2000);
	}
}
