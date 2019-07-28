package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ChangePasswordElements {
	private WebDriver driver; 

	public ChangePasswordElements(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement drpAccount;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right myaccount-menu']//a[text()='Login']")
	private WebElement drpLogin;

	@FindBy(xpath="//input[@name='email']")
	private WebElement emailAddress;

	@FindBy(id="input-password")
	private WebElement password;

	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginBtn; 
	
	@FindBy(linkText="Change your password")
	private WebElement changeYourPassword;
	
	@FindBy(id="input-password")
	private WebElement changePassword;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirm;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement continueBtn; 
	

	public void sendEmailAddress(String emailAddress) {
		this.emailAddress.clear();
		this.emailAddress.sendKeys(emailAddress);
	}

	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}

	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickChangePassword() {
		this.changeYourPassword.click();
	}
	
	public void changePassword(String changePassword) {
		this.changePassword.clear(); 
		this.changePassword.sendKeys(changePassword); 
	}
	
	public void confirmPassword(String passwordConfirm) {
		this.passwordConfirm.clear(); 
		this.passwordConfirm.sendKeys(passwordConfirm); 
	}
	
	public void clickConfirmBtn() {
		this.continueBtn.click(); 
	}
	
	public void accountDropdown() {
		this.drpAccount.click();
		this.drpLogin.click();
		//Select account_dd= new Select(drpAccount);
		//account_dd.selectByVisibleText("Login");
		
	}
}





