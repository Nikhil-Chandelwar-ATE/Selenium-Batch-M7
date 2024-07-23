package com.learning_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Learning_Dependent_Independent_Xpath {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='14.1-inch Laptop']/../../..//input[@value='Add to cart']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("shopping cart")).click();
		
		WebElement element = driver.findElement(By.xpath("//a[@class='product-name']"));
		if (element.isDisplayed()) {
			System.out.println("Product is added to the cart");
		} else {
			System.out.println("Product is not added to the cart");
		}
	}

}
