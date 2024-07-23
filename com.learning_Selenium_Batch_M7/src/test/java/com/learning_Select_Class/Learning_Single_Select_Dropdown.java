package com.learning_Select_Class;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Learning_Single_Select_Dropdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");
		WebElement dropDown = driver.findElement(By.name("country"));
		Select sel = new Select(dropDown);
		Thread.sleep(2000);
//		Selection Methods
		sel.selectByIndex(10);
		Thread.sleep(2000);
		sel.selectByValue("AT");
		Thread.sleep(2000);
		sel.selectByVisibleText("India");
		Thread.sleep(2000);
		List<WebElement> options = sel.getOptions();
		for (WebElement option : options) {
			System.out.println(option.getText());
		}
		for (int i = 1; i < options.size(); i++) {
			sel.selectByIndex(i);
			Thread.sleep(100);
		}
		driver.quit();
	}
}