package com.testScripts;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.generic_Utilities.Base_Test;
import com.generic_Utilities.WebDriver_Utility;

public class AddressTest extends Base_Test {

	@Test(groups = "smokeTesting")
	public void addAddressTes() throws IOException {
		
		driver.findElement(By.linkText("nikhil26@gmail.com")).click();
		driver.findElement(By.linkText("Addresses")).click();
		WebElement addNewButton = driver.findElement(By.xpath("//input[@value='Add new']"));
		WebDriver_Utility.scrollToWebElement(driver, addNewButton);
		addNewButton.click();
		driver.findElement(By.id("Address_FirstName")).sendKeys("Nikhil");
		driver.findElement(By.id("Address_LastName")).sendKeys("S");
		driver.findElement(By.id("Address_Email")).sendKeys("nikhil26@gmail.com");
		driver.findElement(By.id("Address_Company")).sendKeys("Qspiders");
		Select sel = new Select(driver.findElement(By.id("Address_CountryId")));
		sel.selectByVisibleText("India");
		driver.findElement(By.id("Address_City")).sendKeys("Chennai");
		driver.findElement(By.id("Address_Address1")).sendKeys("Qspidders, Vadapalani");
		driver.findElement(By.id("Address_ZipPostalCode")).sendKeys("600026");
		driver.findElement(By.id("Address_PhoneNumber")).sendKeys("3265987410");
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		
		if (driver.findElement(By.xpath("//strong[text()='Nikhil S']")).isDisplayed()) {
			Reporter.log("Address added successfully.....", true);
		}
		
		WebDriver_Utility.getScreenshotOfWebpage(driver);
	}
	
	@Test(groups = "regressionTesting")
	public void removeAddressTest() throws IOException {
		
		driver.findElement(By.linkText("nikhil26@gmail.com")).click();
		driver.findElement(By.linkText("Addresses")).click();
		WebElement deleteButton = driver.findElement(By.xpath("//strong[text()='Nikhil S']/../..//input[@value='Delete']"));
		WebDriver_Utility.scrollToWebElement(driver, deleteButton);
		deleteButton.click();
		driver.switchTo().alert().accept();
		Reporter.log("Address deleted successfully.....", true);
		
		WebDriver_Utility.getScreenshotOfWebpage(driver);
	}
}
