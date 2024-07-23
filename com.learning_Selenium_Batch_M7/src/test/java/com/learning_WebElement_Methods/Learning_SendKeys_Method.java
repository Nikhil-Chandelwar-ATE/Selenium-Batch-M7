package com.learning_WebElement_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Learning_SendKeys_Method {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		
		WebElement element = driver.findElement(By.name("q"));
	 	System.out.println(element.getAttribute("id"));
	 	System.out.println(element.getAttribute("class"));
	 	System.out.println(element.getAttribute("type"));
	 	System.out.println(element.getAttribute("autocomplete"));
	 	System.out.println(element.getAttribute("value"));
	 	System.out.println(element.getAttribute("name"));
	 	
	 	System.out.println("===================================");
	 	System.out.println(element.getCssValue("border"));
	 	System.out.println(element.getCssValue("background"));
	 	System.out.println(element.getCssValue("width"));
	 	System.out.println(element.getCssValue("padding"));
	 	System.out.println(element.getCssValue("font-size"));
		
	 	System.out.println("===================================");
	 	System.out.println(element.getSize());
	 	System.out.println(element.getSize().getHeight());
	 	System.out.println(element.getSize().getWidth());
	 	
		System.out.println("===================================");
		System.out.println(element.getLocation());
		System.out.println(element.getLocation().getX());
		System.out.println(element.getLocation().getY());
		
		System.out.println("===================================");
		System.out.println(element.getRect());
		System.out.println(element.getRect().getHeight());
		System.out.println(element.getRect().getWidth());
		System.out.println(element.getRect().getX());
		System.out.println(element.getRect().getY());
		
		System.out.println("===================================");
		System.out.println(element.isEnabled());
	}

}
