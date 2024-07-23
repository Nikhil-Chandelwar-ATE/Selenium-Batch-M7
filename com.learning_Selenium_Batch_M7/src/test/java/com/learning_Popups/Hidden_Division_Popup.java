package com.learning_Popups;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hidden_Division_Popup {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.name("q")).sendKeys("iphone 15", Keys.ENTER);
		driver.findElement(By.xpath("(//div[@class='KzDlHZ'])[1]")).click();
		
		String parent = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		
		allWindow.remove(parent);
		
		for (String window : allWindow) {
			driver.switchTo().window(window);
			Thread.sleep(1000);
			WebElement element = driver.findElement(By.xpath("//a[text()='All questions']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);
			driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
			
			WebElement element2 = driver.findElement(By.xpath("//div[@class='sBxzFz' and text()='Remove']"));
			js.executeScript("arguments[0].scrollIntoView(true)", element2);
			element2.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[text()='Remove' and @class='sBxzFz fF30ZI A0MXnh']")).click();
			Thread.sleep(2000);
			driver.close();
		}
		Thread.sleep(2000);
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//*[name()='svg' and @class='GAbRIN']")).click();
		driver.quit();
	}

}
