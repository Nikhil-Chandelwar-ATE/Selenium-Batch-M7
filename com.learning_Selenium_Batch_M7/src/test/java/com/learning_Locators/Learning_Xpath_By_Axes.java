package com.learning_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Learning_Xpath_By_Axes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys("samsung s24");
		driver.findElement(By.xpath("//button[@class='_2iLD__']")).click();
		
		String name = driver.findElement(By.xpath("//div[text()='SAMSUNG Galaxy S24 Ultra 5G (Titanium Violet, 256 GB)']")).getText();
		System.out.println(name);
		String price = driver.findElement(By.xpath("//div[text()='SAMSUNG Galaxy S24 Ultra 5G (Titanium Violet, 256 GB)']/ancestor::div[@class='yKfJKb row']/descendant::div[contains(@class,'Nx9bqj')]")).getText();
		System.out.println(price);
		driver.quit();
	}

}
