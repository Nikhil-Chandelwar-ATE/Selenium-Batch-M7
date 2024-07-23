package com.generic_Utilities;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base_Test {

	public WebDriver driver;
	public static WebDriver sDriver;
	public ExtentReports report;
	public ExtentTest test;
	
	@BeforeSuite
	public void configureReport() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./src/test/resources/reports/DWS_Report_"+Java_Utility.getCurrentDate()+".html");
		spark.config().setDocumentTitle("DWS REPORT");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Login Test Case Report");
		report = new ExtentReports();
		report.attachReporter(spark);
	}
	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void openBrowser(@Optional("chrome") String browser) {
		
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		
		sDriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(File_Utility.getPropertiesData("url"));
	}
	
	@BeforeMethod(alwaysRun = true)
	public void loginToDWS(Method method) {
		test = report.createTest(method.getName());
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(File_Utility.getPropertiesData("username"));
		driver.findElement(By.id("Password")).sendKeys(File_Utility.getPropertiesData("password"));
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	
	@AfterMethod(alwaysRun = true)
	public void logoutFromDWS() {
		
		driver.findElement(By.linkText("Log out")).click();
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		
		driver.quit();
	}
	
	@AfterSuite
	public void flushReport() {
		report.flush();
	}
}
