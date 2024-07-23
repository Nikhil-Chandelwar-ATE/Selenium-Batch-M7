package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	public RegisterPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "gender-male")
	private WebElement maleRadioButton;
	
	@FindBy(id = "gender-female")
	private WebElement famaleRadioButton;
	
	@FindBy(id = "FirstName")
	private WebElement firstNameTF;
	
	@FindBy(id = "LastName")
	private WebElement lastNameTF;
	
	@FindBy(id = "Email")
	private WebElement emailNameTF;
	
	@FindBy(id = "Password")
	private WebElement passwordNameTF;
	
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordNameTF;
	
	@FindBy(id = "register-button")
	private WebElement registerButton;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getMaleRadioButton() {
		return maleRadioButton;
	}

	public WebElement getFamaleRadioButton() {
		return famaleRadioButton;
	}

	public WebElement getFirstNameTF() {
		return firstNameTF;
	}

	public WebElement getLastNameTF() {
		return lastNameTF;
	}

	public WebElement getEmailNameTF() {
		return emailNameTF;
	}

	public WebElement getPasswordNameTF() {
		return passwordNameTF;
	}

	public WebElement getConfirmPasswordNameTF() {
		return confirmPasswordNameTF;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}
}
