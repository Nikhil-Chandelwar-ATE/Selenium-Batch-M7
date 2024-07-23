package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_And_Drop {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html#google_vignette");
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.partialLinkText("Drag And Drop scripts"));
		action.scrollToElement(element).perform();
		Thread.sleep(2000);
		
		for (int i = 1; i <= 7; i++) {
			action.dragAndDrop(driver.findElement(By.id("box"+i)), driver.findElement(By.id("box10"+i))).perform();
			Thread.sleep(100);
		}
		
		for (int i = 1; i <= 7; i++) {
			action.dragAndDrop(driver.findElement(By.id("box"+i)), driver.findElement(By.id("capitals"))).perform();
			Thread.sleep(100);
		}
	}

}
