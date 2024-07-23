package com.learning_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Learning_CssSelector_Locator {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		
		driver.findElement(By.cssSelector("[href='/login']")).click();
		driver.findElement(By.cssSelector("[autofocus='autofocus']")).sendKeys("varathan196@gmail.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Varathan@7");
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
	}
}