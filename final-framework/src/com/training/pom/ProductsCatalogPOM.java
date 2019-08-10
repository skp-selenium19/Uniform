package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductsCatalogPOM {
	
	private WebDriver driver; 

	public ProductsCatalogPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//*[@id=\"catalog\"]/ul/li[2]/a")
	private WebElement productList;
    
	@FindBy(id="input-name")
	private WebElement productName; 
	
	@FindBy(id="input-price")
	private WebElement price;
	
	@FindBy(id="input-status")
	private WebElement statusDropdown;
	
	@FindBy(id="input-model")
	private WebElement model;
	
	@FindBy(id="input-quantity")
	private WebElement quantity;
	
	@FindBy(id="button-filter")
	private WebElement filterButton;
	
	public void clickProduct() {
		this.productList.click(); 
	}
	
	public void sendProductName(String productName) {
		this.productName.clear();
		this.productName.sendKeys(productName);
	}
	
	public void sendPrice(String price) {
		this.price.clear();
		this.price.sendKeys(price);
	}
	
	public void sendModel(String model) {
		this.model.clear();
		this.model.sendKeys(model);
	}
	
	public void sendQuantity(String quantity) {
		this.quantity.clear();
		this.quantity.sendKeys(quantity);
	}
	
	public void clickFilterButton() {
		this.filterButton.click(); 
	}
	
	public void statusDrpdown() {
		Select dropdown= new Select(statusDropdown);
		dropdown.selectByVisibleText("Enabled");
		//this.statusDropdown.click();
		
	}
}
