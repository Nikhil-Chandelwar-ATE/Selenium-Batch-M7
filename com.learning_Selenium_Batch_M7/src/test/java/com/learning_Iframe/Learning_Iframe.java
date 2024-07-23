package com.learning_Iframe;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Learning_Iframe {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.zomato.com/");
		
		driver.findElement(By.linkText("Log in")).click();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//iframe[@id='auth-login-ui']"))));
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='auth-login-ui']")));
		driver.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//i[@class='sc-rbbb40-1 cLEXmC sc-re4bd0-1 bKymEa']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Add restaurant")).click();
	}

}
