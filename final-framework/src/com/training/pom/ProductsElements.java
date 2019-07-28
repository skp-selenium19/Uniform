package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductsElements {
	private WebDriver driver; 

	public ProductsElements(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='http://uniform.upskills.in/image/cache/catalog/Products/SSN_6435-180x240.png']")
	private WebElement blueTshirt ;
	
	@FindBy(xpath="//input[@value='1041']")
	private WebElement rdbButtonSize;
	
	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement addingToCart;
	
	@FindBy(xpath="//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	private WebElement cartTotal;
	
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]")
	private WebElement viewCart;
	
	@FindBy(xpath="//button[@data-original-title='Remove']")
	private WebElement removeCart;
	
	public void clickTshirt() {
		this.blueTshirt.click();
	}
	
	public void clickRdbButton() {
		this.rdbButtonSize.click();
	}
	
	public void cartNewItem() {
		this.addingToCart.click();
	}
	
	public void cartTotalDropdown() {
		this.cartTotal.click();
		this.viewCart.click();	
	}
	
	public void cartRemove() {
		this.removeCart.click();
	}
}

