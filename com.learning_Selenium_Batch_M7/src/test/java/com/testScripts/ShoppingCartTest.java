package com.testScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.generic_Utilities.Base_Test;
import com.generic_Utilities.WebDriver_Utility;

@Listeners(com.generic_Utilities.Listener_Implementation_Class.class)
public class ShoppingCartTest extends Base_Test {

	@Test(groups = "smokeTesting")
	public void addToCartTest() throws InterruptedException, IOException{
			
		Thread.sleep(2000);
		WebElement addToCartButton = driver.findElement(By.xpath("//a[text()='14.1-inch Laptop']/../../..//input[@value='Add to cart']"));
		WebDriver_Utility.scrollToWebElement(driver, addToCartButton);
		addToCartButton.click();
		WebElement shoppingCartLink = driver.findElement(By.partialLinkText("Shopping"));
		WebDriver_Utility.scrollToWebElement(driver, shoppingCartLink);
		shoppingCartLink.click();
		if (driver.findElement(By.xpath("(//a[text()='14.1-inch Laptop'])[2]")).isDisplayed()) {
			Reporter.log("Product added to cart successfully.....", true);
			test.log(Status.PASS, "Product added successfully");
		}
		
		WebDriver_Utility.getScreenshotOfWebpage(driver);
		Thread.sleep(2000);
	}
	
	@Test(groups = "regressionTesting")
	public void removeFromCartTest() throws IOException {
		
		driver.findElement(By.partialLinkText("Shopping")).click();
		WebElement element = driver.findElement(By.xpath("(//a[text()='14.1-inch Laptop'])[2]/../..//input[@name='removefromcart']"));
		element.click();
		driver.findElement(By.name("updatecart")).click();
		Assert.assertEquals(driver.findElement(By.xpath("(//a[text()='14.1-inch Laptop'])[2]/../..//input[@name='removefromcart']")).isDisplayed(), false);
		Reporter.log("Product aremove from the cart successfully.....", true);
		WebDriver_Utility.getScreenshotOfWebpage(driver);
	}
}
