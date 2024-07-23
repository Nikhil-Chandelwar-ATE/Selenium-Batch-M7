package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart_Product_Details {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys("iphone 15", Keys.ENTER);
		Thread.sleep(2000);
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
		
		for (int i = 0; i < elements.size(); i++) {
			String name = elements.get(i).getText();
			System.out.println(name);
			WebElement element = driver.findElement(By.xpath("//div[text()='"+name+"']/../../..//div[@class='Nx9bqj _4b5DiR']"));
			String price = element.getText();
			System.out.println(price);
		}
		driver.quit();
	}
}