package com.learning_Actions_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_And_Drop_Operation {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html#google_vignette");
		Thread.sleep(2000);
		
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.partialLinkText("Drag And Drop scripts"));
		action.scrollToElement(element).perform();
		Thread.sleep(2000);
		WebElement source = driver.findElement(By.id("box3"));
		WebElement target = driver.findElement(By.id("box103"));
		action.dragAndDrop(source, target).perform();
		
		WebElement source2 = driver.findElement(By.id("box7"));
		WebElement target2 = driver.findElement(By.id("box107"));
		action.clickAndHold(source2).perform();
		action.release(target2).perform();
	}
}
