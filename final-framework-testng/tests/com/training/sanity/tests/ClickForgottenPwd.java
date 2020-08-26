package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.ClickForgottemPwdPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ClickForgottenPwd {

	private WebDriver driver;
	private String baseUrl;
	private ClickForgottemPwdPOM myloginPOM;
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
		myloginPOM = new ClickForgottemPwdPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void getForgottenPwd() {
		myloginPOM.clickMyAccount();
		myloginPOM.clickLoginButtonUnderMyAccount();
		myloginPOM.enterCredentials("tvlrocks1@gmail.com", "cnprasad1");
		myloginPOM.clickPwdInHomeScreen();
		String ExpRes=myloginPOM.changePassword("cnprasad1");
		System.out.println("ER value is: "+ExpRes);
		String ActRes="Success: Your password has been successfully updated.";
		System.out.println("AR value is: "+ActRes);
		Assert.assertEquals(ActRes, ExpRes);
		System.out.println("Testcase Pass !!");
		
	}	
	
}
