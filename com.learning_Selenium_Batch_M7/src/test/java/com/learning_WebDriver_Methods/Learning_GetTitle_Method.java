package com.learning_WebDriver_Methods;

import org.openqa.selenium.chrome.ChromeDriver;

public class Learning_GetTitle_Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://qspiders.com/");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		if (title.equals("Testing Training Institute | QSpiders")) {
			System.out.println("Qspiders website is opened....");
		}
		else {
			System.out.println("Invalid website opened....");
		}
	}

}
