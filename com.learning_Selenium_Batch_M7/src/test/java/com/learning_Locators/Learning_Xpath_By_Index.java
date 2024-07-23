package com.learning_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Learning_Xpath_By_Index {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/");
		
		driver.findElement(By.xpath("(//input[@autocapitalize='off'])[1]")).sendKeys("1236547890");
		driver.findElement(By.xpath("(//input[@autocapitalize='off'])[2]")).sendKeys("12345678");
	}

}
