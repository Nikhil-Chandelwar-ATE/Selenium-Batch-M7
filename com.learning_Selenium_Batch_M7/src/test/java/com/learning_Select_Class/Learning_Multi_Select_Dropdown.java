package com.learning_Select_Class;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Learning_Multi_Select_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");
		
		WebElement dropDown = driver.findElement(By.name("Month"));
		Select sel = new Select(dropDown);
		Thread.sleep(2000);
		sel.selectByIndex(5);
		sel.selectByValue("Jan");
		sel.selectByVisibleText("April");
		Thread.sleep(2000);
		
		List<WebElement> selectedOptions = sel.getAllSelectedOptions();
		for (WebElement option : selectedOptions) {
			System.out.println(option.getText());
		}
		
//		Deselection Methods
//		if (sel.isMultiple()) {
//			sel.deselectByIndex(1);
//			Thread.sleep(2000);
//			sel.deselectByValue("May");
//			Thread.sleep(2000);
//			sel.deselectByVisibleText("April");
////			sel.deselectAll();
//		}
		Thread.sleep(2000);
		driver.quit();
	}
}
