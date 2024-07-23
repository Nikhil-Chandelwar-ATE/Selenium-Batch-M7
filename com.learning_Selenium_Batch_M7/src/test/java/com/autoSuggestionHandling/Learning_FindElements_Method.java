package com.autoSuggestionHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Learning_FindElements_Method {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.id("APjFqb")).sendKeys("selenium");
		Thread.sleep(2000);
		List<WebElement> suggestions = driver.findElements(By.xpath("//div[@class='wM6W7d']"));
		System.out.println(suggestions);
		
//		for (WebElement suggestion : suggestions) {
//			System.out.println(suggestion.getText());
//			if (suggestion.getText().equals("selenium webdriver")) {
//				suggestion.click();
//				break;
//			}
//		}
		
		for (int i = 0; i < suggestions.size(); i++) {
			
			WebElement suggestion = suggestions.get(i);
			System.out.println(suggestion.getText());
			if (suggestion.getText().equals("selenium webdriver")) {
				suggestion.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//h3[text()='WebDriver']")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}