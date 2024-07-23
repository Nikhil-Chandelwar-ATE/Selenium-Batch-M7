package com.learning_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Learning_Xpath_By_Text {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		WebElement element = driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']"));
		String text = element.getText();
		System.out.println(text);
		
		if (text.contains("Sign In")) {
			System.out.println("Login Page displayed....");
		}
		else {
			System.out.println("Invalid page displayed...");
		}
		
	}

}
