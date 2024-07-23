package com.learning_WebDriver_Methods;

import org.openqa.selenium.chrome.ChromeDriver;

public class Learning_GetPageSource_Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://qspiders.com/");
		
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
	}
}
