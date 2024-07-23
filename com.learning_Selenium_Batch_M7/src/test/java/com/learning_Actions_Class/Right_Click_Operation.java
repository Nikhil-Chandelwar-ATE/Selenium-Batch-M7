package com.learning_Actions_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Right_Click_Operation {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		
		Actions action = new Actions(driver);
//		action.contextClick().perform();
		
		WebElement register = driver.findElement(By.linkText("Register"));
//		action.click(register).perform();
		
		WebElement addToCart = driver.findElement(By.xpath("(//input[@value='Add to cart'])[2]"));
		action.scrollToElement(addToCart).perform();
		action.click(addToCart).perform();
	}

}
