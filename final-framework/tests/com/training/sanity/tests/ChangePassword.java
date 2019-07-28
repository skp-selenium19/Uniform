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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ChangePassword {
	private WebDriver driver; 
	private String baseUrl; 
	private ChangePasswordElements changePasswordElements; 
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
		changePasswordElements = new ChangePasswordElements(driver); 
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
	public void changePasswordTest() {
		changePasswordElements.accountDropdown();
		changePasswordElements.sendEmailAddress("surya.pradhan@gmail.com");
		changePasswordElements.sendPassword("Selenium2019");
		changePasswordElements.clickLoginBtn(); 
		changePasswordElements.clickChangePassword();
		changePasswordElements.changePassword("Selenium19");
		changePasswordElements.confirmPassword("Selenium1920");
		changePasswordElements.clickConfirmBtn();
		String actualMsg=driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
		String errorMsg= "Password confirmation does not match password!";
		if (actualMsg.equals(errorMsg)) {
			System.out.println("Test Case Passed");
		}else {
			System.out.println("Test Case Failed");
		}
		
		//System.out.println("Password confirmation does not match password!");
		screenShot.captureScreenShot("First");
	}
	
	//@Test(priority=2)	
	//public void changePasswordTest() {
		//changePasswordElements.changePassword("Selenium19");
		//changePasswordElements.confirmPassword("Selenium1920");
		//changePasswordElements.clickConfirmBtn();
		//screenShot.captureScreenShot("First");
	//}
}
