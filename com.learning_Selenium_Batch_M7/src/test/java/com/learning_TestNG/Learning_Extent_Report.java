package com.learning_TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.generic_Utilities.File_Utility;
import com.generic_Utilities.Java_Utility;

public class Learning_Extent_Report {

	@Test
	public void loginToDWS() {
		
//		creating the file to store the report
		ExtentSparkReporter spark = new ExtentSparkReporter("./src/test/resources/reports/DWS_Report_"+Java_Utility.getCurrentDate()+".html");
		
//		Configure the report
		spark.config().setDocumentTitle("DWS REPORT");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Login Test Case Report");
		
//		creating a new report
		ExtentReports report = new ExtentReports();
		
//		attaching the report in that file
		report.attachReporter(spark);
		
//		Starting report for particular test case
		ExtentTest test = report.createTest("loginToDWS");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(File_Utility.getPropertiesData("url"));
		
//		We can attach the information/ status into the report
		test.log(Status.INFO, "Welcome Page Displayed....");
		
		driver.findElement(By.linkText("Log in")).click();
		test.log(Status.INFO, "Login Page Displayed....");
		
		driver.findElement(By.id("Email")).sendKeys(File_Utility.getPropertiesData("username"));
		driver.findElement(By.id("Password")).sendKeys(File_Utility.getPropertiesData("password"));
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		if (!(driver.findElement(By.linkText(File_Utility.getPropertiesData("username"))).isDisplayed())) {
			Reporter.log("User Logged in successfully....", true);
			test.log(Status.PASS, "User logged in successfully");
	
			driver.findElement(By.linkText("Log out")).click();
			driver.quit();
		}
		else {
			test.log(Status.FAIL, "Test Case is Fail....");
			TakesScreenshot ts = (TakesScreenshot) driver;
			String screenshotAs = ts.getScreenshotAs(OutputType.BASE64);
			test.addScreenCaptureFromBase64String(screenshotAs, "Login Failure");
		}
//		It will save the report
		report.flush();
	}
}
