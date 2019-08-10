package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPOM {
	
	private WebDriver driver; 

	public CatalogPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//li[@id=\"catalog\"]/a")
	private WebElement cataLog;
	
	@FindBy(xpath="//li[@id=\"catalog\"]/ul/li[1]/a")
	private WebElement catagoryList;
	
	@FindBy(xpath="//*[@id=\"form-category\"]/div/table/tbody/tr[1]/td[4]/a/i")
	private WebElement editButton;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a/i")
	private WebElement cancelButton;
	
	@FindBy(xpath="//*[@id=\"form-category\"]/div/table/tbody/tr[1]/td[1]/input")
	private WebElement checkBox;
	
	@FindBy(xpath="//button[@data-original-title='Delete']")
	private WebElement deleteButton;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]")
	private WebElement successMessage;
	
	public void clickCatalog() {
		this.cataLog.click(); 
	}
	
	public void clickCatagory() {
		this.catagoryList.click(); 
	}
	
	public void clickEdit() {
		this.editButton.click(); 
	}
	public void clickCancel() {
		this.cancelButton.click(); 
	}
	public void clickCheckbox() {
		this.checkBox.click(); 
	}
	public void clickDeleteButton() {
		this.deleteButton.click(); 
	}
	public String getMessage() {
		return this.successMessage.getText();
	
	}
}