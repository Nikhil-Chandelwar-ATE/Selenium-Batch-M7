package com.learning_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Learning_Dynamic_Xpath {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys("samsung s24");
		driver.findElement(By.xpath("//button[@class='_2iLD__']")).click();
		
		String name = driver.findElement(By.xpath("//div[text()='SAMSUNG Galaxy S24 Ultra 5G (Titanium Violet, 256 GB)']")).getText();
		System.out.println(name);
		String price = driver.findElement(By.xpath("//div[text()='SAMSUNG Galaxy S24 Ultra 5G (Titanium Violet, 256 GB)']/../../..//div[@class='Nx9bqj _4b5DiR']")).getText();
		System.out.println(price);
		driver.quit();
	}

}
