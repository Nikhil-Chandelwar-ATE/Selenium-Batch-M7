package com.learning_TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Priority_Attribute {

	@Test(priority = 0)
	public void purchaseTest() {
		Reporter.log("Executing Purchase Test Case", true);
	}

	@Test(priority = 7)
	public void loginTest() {
		Reporter.log("Executing Login Test Case", true);
	}
	
	@Test(priority = -900)
	public void registerTest() {
		Reporter.log("Executing Register Test Case", true);
	}
}
