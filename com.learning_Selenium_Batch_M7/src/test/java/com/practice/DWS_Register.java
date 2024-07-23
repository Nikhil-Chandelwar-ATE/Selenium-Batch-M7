package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DWS_Register {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.name("FirstName")).sendKeys("kishore");
		driver.findElement(By.className("text-box")).sendKeys("kumar");
		driver.findElement(By.name("Email")).sendKeys("kishore@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("kishore123");
		driver.findElement(By.name("ConfirmPassword")).sendKeys("kishore123");
		driver.findElement(By.className("button-1")).click();	
	}
}