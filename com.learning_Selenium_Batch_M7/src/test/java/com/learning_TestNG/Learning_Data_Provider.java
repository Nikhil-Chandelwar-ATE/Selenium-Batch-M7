package com.learning_TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Learning_Data_Provider {

	@DataProvider(name = "loginData")
	public String[][] loginDataProvider() {
		
		String [][] data = new String[5][2];
		
		data[0][0] = "varathan196@gmail.com";
		data[0][1] = "Varathan@7";
		
		data[1][0] = "murugan661999@gmail.com";
		data[1][1] = "B123456@m";
		
		data[2][0] = "keerthibala323@gmail.com";
		data[2][1] = "Keerthi@123";
		
		data[3][0] = "johnpraveen2617@gmail.com";
		data[3][1] = "Password@123";
		
		data[4][0] = "balamurugann017@gmail.com";
		data[4][1] = "Bala@123";
		
		return data;
	}
	
	@Test(dataProvider = "loginData")
	public void loginToDWSTest(String email, String password) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		if (driver.findElement(By.linkText(email)).isDisplayed()) {
			Reporter.log("User Logged in successfully....", true);
			driver.findElement(By.linkText("Log out")).click();
			driver.quit();
		}
	}
	
	
}
