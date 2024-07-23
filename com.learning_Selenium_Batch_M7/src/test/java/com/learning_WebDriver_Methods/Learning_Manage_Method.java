package com.learning_WebDriver_Methods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class Learning_Manage_Method {

	public static void main(String[] args) throws InterruptedException  {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		//we will use as a pre condition in every script
//		maximize
//		driver.manage().window().maximize();
//		
////		fullscreen
//		driver.manage().window().fullscreen();
//		
////		minimize
//		driver.manage().window().minimize();
		
//		height
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
		
		int height = driver.manage().window().getSize().getHeight();
		System.out.println(height);
//		width
		int width = driver.manage().window().getSize().getWidth();
		System.out.println(width);
		
//		xaxis
		Point position = driver.manage().window().getPosition();
		System.out.println(position);
		System.out.println(position.getX());
		System.out.println(position.getY());
		Thread.sleep(2000);
//		Set the size of browser window
		driver.manage().window().setSize(new Dimension(1000, 400));
		
		Thread.sleep(2000);
//		set the position of browser window
		driver.manage().window().setPosition(new Point(100, 100));
	}

}
