package com.learning_Actions_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Double_Click_Operation {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium08.blogspot.com/2019/11/double-click.html");
		Thread.sleep(2000);
		
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//button[text()='Double-Click me to see Alert message']"));
		action.scrollToElement(element).perform();
		Thread.sleep(2000);
		action.doubleClick(element).perform();
	}

}
