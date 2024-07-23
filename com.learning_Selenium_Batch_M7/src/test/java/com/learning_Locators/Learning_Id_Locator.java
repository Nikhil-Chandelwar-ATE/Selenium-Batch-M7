package com.learning_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Learning_Id_Locator {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
//		By id = By.id("small-searchterms");
//		WebElement searchTF = driver.findElement(id);
//		searchTF.sendKeys("mobile");
		
		driver.findElement(By.id("small-searchterms")).sendKeys("laptop");
	}
}
