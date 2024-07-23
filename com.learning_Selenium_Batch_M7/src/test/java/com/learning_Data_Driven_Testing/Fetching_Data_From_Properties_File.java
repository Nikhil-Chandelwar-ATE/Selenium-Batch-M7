package com.learning_Data_Driven_Testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Fetching_Data_From_Properties_File {

	@Test
	public void loginToDWS() throws IOException {

//		CREATE THE JAVA REPRESENTATION OBJECT OF EXTERNAL FILE
		FileInputStream fis = new FileInputStream("./src/main/resources/commonData.properties");
//		CREATE OBJECT OF PROPERTIES CLASS
		Properties prop = new Properties();
//		LOAD THE FILE FROM FileInputStream TO Properties CLASS OBJECT
		prop.load(fis);
//		IT WILL FETCH THE VALUE BASED ON KEY
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);

		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(USERNAME);
		driver.findElement(By.id("Password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		if (driver.findElement(By.linkText("balamurugann017@gmail.com")).isDisplayed()) {
			Reporter.log("User Logged in successfully....", true);
			driver.findElement(By.linkText("Log out")).click();
			driver.quit();
		}
	}
}