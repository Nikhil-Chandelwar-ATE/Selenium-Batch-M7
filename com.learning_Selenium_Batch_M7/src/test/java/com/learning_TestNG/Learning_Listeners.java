package com.learning_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.generic_Utilities.Base_Test;

@Listeners(com.generic_Utilities.Listener_Implementation_Class.class)
public class Learning_Listeners extends Base_Test{

	@Test
	public void loginTest() {

		driver.findElement(By.name("q")).sendKeys("laptop", Keys.ENTER);
		Assert.assertEquals(driver.getTitle().contains("Login"), true);
	}
}
