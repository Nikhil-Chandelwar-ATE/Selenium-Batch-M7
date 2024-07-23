package com.learning_WebDriver_Methods;

import org.openqa.selenium.chrome.ChromeDriver;

public class Learning_GetCurrentUrl_Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://qspiders.com/batches");
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		if (currentUrl.equals("https://qspiders.com/batches")) {
			System.out.println("Qspiders website is opened....");
		}
		else {
			System.out.println("Invalid website opened....");
		}
	}

}
