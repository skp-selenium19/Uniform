package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ChangePasswordElements;
import com.training.pom.ProductsElements;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddtoCart {
	
	private WebDriver driver; 
	private String baseUrl; 
	private ProductsElements addtoCart; 
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
		addtoCart = new ProductsElements(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test(priority=1)	
	public void addtoCartTest() {
		
		addtoCart.clickTshirt();
		addtoCart.clickRdbButton();
		addtoCart.cartNewItem();
		String actualMsg=driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText().trim();
		System.out.println("actualMsg "+ actualMsg);
		String expectedMsg= "Success: You have added SPORTS T-SHIRTS to your shopping cart!";
		if (actualMsg.contains(expectedMsg)) {
			System.out.println("Test Case Passed");
		}else {
			System.out.println("Test Case Failed");
		}
		
		addtoCart.cartTotalDropdown();
		String actualFirstProductDetails=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/thead/tr/td[1]")).getText();
		String expectedFirstProductDetails="Image";
		if (actualFirstProductDetails.contains(expectedFirstProductDetails)) {
			System.out.println("Verification Successful - Image is displayed");
		}else {
			System.out.println("Verification Failed - Image is not displayed");
		}
		String actualSecondProductDetails=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/thead/tr/td[2]")).getText();
		String expectedSecondProductDetails="Product Name";
		if (actualSecondProductDetails.contains(expectedSecondProductDetails)) {
			System.out.println("Verification Successful - Product Name is displayed");
		}else {
			System.out.println("Verification Failed - Product Name is not displayed");	
		}
		
		String actualThirdProductDetails=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/thead/tr/td[3]")).getText();
		String expectedThirdProductDetails="Model";
		if (actualThirdProductDetails.contains(expectedThirdProductDetails)) {
			System.out.println("Verification Successful - Model is displayed");
		}else {
			System.out.println("Verification Failed - Model is not displayed");	
		}
		
		String actualFourthProductDetails=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/thead/tr/td[4]")).getText();
		String expectedFourthProductDetails="Quantity";
		if (actualFourthProductDetails.contains(expectedFourthProductDetails)) {
			System.out.println("Verification Successful - Quantity is displayed");
		}else {
			System.out.println("Verification Failed - Quantity is not displayed");	
		}
		
		String actualFifthProductDetails=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/thead/tr/td[5]")).getText();
		String expectedFifthProductDetails="Unit Price";
		if (actualFifthProductDetails.contains(expectedFifthProductDetails)) {
			System.out.println("Verification Successful - Unit Price is displayed");
		}else {
			System.out.println("Verification Failed - Unit Price is not displayed");	
		}
		
		String actualSixthProductDetails=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/thead/tr/td[6]")).getText();
		String expectedSixthProductDetails="Total";
		if (actualSixthProductDetails.contains(expectedSixthProductDetails)) {
			System.out.println("Verification Successful - Total	 is displayed");
		}else {
			System.out.println("Verification Failed - Total	 is not displayed");	
		}
		
		//System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/thead/tr/td[1]")).getText());
	}
}
	
