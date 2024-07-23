package com.testScripts;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.generic_Utilities.File_Utility;
import com.generic_Utilities.Java_Utility;
import com.objectRepository.HomePage;
import com.objectRepository.RegisterPage;
import com.objectRepository.WelcompePage;

//@Listeners(com.generic_Utilities.Listener_Implementation_Class.class)
public class Register_Test {
	
	@Test
	public void registerTest(Method method) throws InterruptedException {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./src/test/resources/reports/DWS_"+Java_Utility.getCurrentDate()+".html");
		spark.config().setDocumentTitle("DWS_Register_Report");
		spark.config().setTheme(Theme.DARK);
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		ExtentTest test = report.createTest(method.getName());
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(File_Utility.getPropertiesData("url"));
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop");
		test.log(Status.INFO, "Welcome Page Displayed Successfully...");
		
		WelcompePage wp = new WelcompePage(driver);
		wp.getRegisterLink().click();
		Assert.assertEquals(driver.getCurrentUrl().contains("register"), true);
		test.log(Status.INFO, "Register Page Displayed Successfully...");
		
		RegisterPage rp = new RegisterPage(driver);
		
		if (File_Utility.getSingleDataFromExcel("RegisterData", 1, 0).equals("M")) {
			rp.getMaleRadioButton().click();
			Assert.assertEquals(rp.getMaleRadioButton().isSelected(), true);
		}else {
			rp.getFamaleRadioButton().click();
			Assert.assertEquals(rp.getFamaleRadioButton().isSelected(), true);
		}
		
		rp.getFirstNameTF().sendKeys(File_Utility.getSingleDataFromExcel("RegisterData", 1, 1));
		rp.getLastNameTF().sendKeys(File_Utility.getSingleDataFromExcel("RegisterData", 1, 2));
		rp.getEmailNameTF().sendKeys(File_Utility.getSingleDataFromExcel("RegisterData", 1, 3));
		rp.getPasswordNameTF().sendKeys(File_Utility.getSingleDataFromExcel("RegisterData", 1, 4));
		rp.getConfirmPasswordNameTF().sendKeys(File_Utility.getSingleDataFromExcel("RegisterData", 1, 5));
		rp.getRegisterButton().click();
		rp.getContinueButton().click();
		
		HomePage hp = new HomePage(driver);
		Assert.assertEquals(hp.getUserEmailID().getText().equals(File_Utility.getSingleDataFromExcel("RegisterData", 1, 3)), true);
		test.log(Status.INFO, "User Registered Successfully...");
		
		hp.getLogoutLink().click();
		driver.quit();
		report.flush();
	}
}
