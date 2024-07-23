package com.learning_TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class First_TestNG_Class {
	
	@Test
	public void purchaseTest() {
		Reporter.log("Executing Purchase Test Case", true);
	}
	
//	this acts like a main method of java
	@Test
	public void loginTest() {	//This method acts like a Test Case
		Reporter.log("Executing Login Test Case", true);
	}
	
	@Test
	public void registerTest() {
		Reporter.log("Executing Register Test Case", true);
	}
	
	
}