package com.learning_Actions_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouse_Hover_Action {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//span[text()='Fashion']"));
		action.moveToElement(element).perform();
		Thread.sleep(2000);
		WebElement element2 = driver.findElement(By.linkText("Watches and Accessories"));
		action.moveToElement(element2).perform();
		Thread.sleep(2000);
		WebElement element3 = driver.findElement(By.linkText("Men & Women Watches"));
		action.moveToElement(element3).click().perform();
	}

}
