package com.learning_TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Thread_Pool_Size_Attribute {

	@Test(invocationCount = 10, threadPoolSize = 2)
	public void loginToDWSTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("balamurugann017@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Bala@123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		if (driver.findElement(By.linkText("balamurugann017@gmail.com")).isDisplayed()) {
			Reporter.log("User Logged in successfully....", true);
			driver.findElement(By.linkText("Log out")).click();
			driver.quit();
		}
	}
}
