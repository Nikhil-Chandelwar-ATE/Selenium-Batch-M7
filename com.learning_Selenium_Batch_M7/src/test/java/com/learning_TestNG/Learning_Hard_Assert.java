package com.learning_TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Learning_Hard_Assert {

	@Test
	public void loginTest() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop", "Validating Welcome Page");
		
		driver.findElement(By.linkText("Log in")).click();
		Assert.assertEquals(driver.getCurrentUrl().contains("signup"), true, "Validating Login Page");

		driver.findElement(By.id("Email")).sendKeys("nikhil26@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("nikhil123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		WebElement element = driver.findElement(By.linkText("nikhil26@gmail.com"));
		Assert.assertEquals(element.isDisplayed(), true, "Validating User Login");
		driver.findElement(By.linkText("Log out")).click();
		driver.quit();
	}
}
