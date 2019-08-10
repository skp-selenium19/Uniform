package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CatalogPOM;
import com.training.pom.LoginAdminPOM;
import com.training.pom.ProductsCatalogPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CategoryAdd {
	private WebDriver driver; 
	private String adminURL; 
	private LoginAdminPOM loginAdminPOM;
	private CatalogPOM catalogPOM;
	private ProductsCatalogPOM productsCatalogPOM;
	private static Properties properties; 
	private ScreenShot screenShot; 
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginAdminPOM = new LoginAdminPOM(driver); 
		catalogPOM = new CatalogPOM(driver);
		productsCatalogPOM= new ProductsCatalogPOM(driver);
		adminURL = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		driver.get(adminURL);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void catagoryAddTest() {

		loginAdminPOM.sendUserName("admin");
		loginAdminPOM.sendPassword("admin@123");
		loginAdminPOM.clickLoginAdmin();
		catalogPOM.clickCatalog();
		catalogPOM.clickCatagory();
		catalogPOM.clickEdit();
		catalogPOM.clickCancel();
		catalogPOM.clickCheckbox();
		catalogPOM.clickDeleteButton();
		Alert alert = driver.switchTo().alert();
		String actualMessage= driver.switchTo().alert().getText();
		String expectedMessage="Are you sure?";
		Assert.assertEquals(actualMessage,expectedMessage);
		alert.accept();	
		String actualSuccessMessage= catalogPOM.getMessage();
		String expectedSuccessMessage= "Success: You have modified categories!";
		boolean verification = actualSuccessMessage.contains(expectedSuccessMessage);
		Assert.assertTrue(verification);
}
	@Test(enabled = false)	
	public void productsFilterTest() {

		loginAdminPOM.sendUserName("admin");
		loginAdminPOM.sendPassword("admin@123");
		loginAdminPOM.clickLoginAdmin();
		catalogPOM.clickCatalog();
		productsCatalogPOM.clickProduct();
		productsCatalogPOM.sendProductName("Blazer Girls(7-8)");
		productsCatalogPOM.clickFilterButton();
		productsCatalogPOM.sendPrice("3000");
		productsCatalogPOM.clickFilterButton();
		productsCatalogPOM.statusDrpdown();
		productsCatalogPOM.clickFilterButton();
		productsCatalogPOM.sendModel("BLG-112");
		productsCatalogPOM.clickFilterButton();
		productsCatalogPOM.sendQuantity("100");
		productsCatalogPOM.clickFilterButton();
	}		
	
}
