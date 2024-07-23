package com.learning_WebElement_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Learning_IsEnabled_Method {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.zomato.com/");
		
		driver.findElement(By.linkText("Sign up")).click();
		
		WebElement element = driver.findElement(By.xpath("//button[@class='sc-1kx5g6g-1 dlCvBh']"));
		System.out.println(element.isEnabled());
		driver.findElement(By.xpath("(//input[@class='sc-1yzxt5f-9 bbrwhB'])[2]")).sendKeys("aman", Keys.TAB, "aman@gmail.com");
		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//input[@class='sc-1yzxt5f-9 bbrwhB' and @width='100%'])[3]")).sendKeys("amana@gmail.com");
		WebElement element2 = driver.findElement(By.xpath("//input[@type='checkbox']"));
		System.out.println(element2.isSelected());
		element2.click();
		System.out.println(element2.isSelected());
		System.out.println(element.isEnabled());
		
		System.out.println(element.getTagName());
		System.out.println(element2.getTagName());
	}

}
