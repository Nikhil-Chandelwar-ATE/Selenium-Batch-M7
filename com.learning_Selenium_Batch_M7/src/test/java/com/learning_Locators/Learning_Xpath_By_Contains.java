package com.learning_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Learning_Xpath_By_Contains {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'Email')]")).sendKeys("7896541230");
		driver.findElement(By.xpath("//input[contains(@class,'_6luy _9npi')]")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[contains(text(),'Log')]")).click();
		
	}

}
