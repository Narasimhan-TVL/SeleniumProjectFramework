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

import com.training.pom.AddProdDetailIntoCartPOM;
import com.training.pom.ClickForgottemPwdPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;



public class RemoveAddedItemsFromCart {
	private WebDriver driver;
	private String baseUrl;
	private AddProdDetailIntoCartPOM addProdDetailToCart;
	private static Properties properties;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		addProdDetailToCart = new AddProdDetailIntoCartPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	
	@Test
  public void AddProdDetail() {
	addProdDetailToCart.clickregularTShirtsYellow();
	addProdDetailToCart.selectChestSize("28");
	addProdDetailToCart.clickAddToCartButton();
	addProdDetailToCart.veiwCart();
	addProdDetailToCart.viewCartItems();	
	String actualResult=addProdDetailToCart.validateCartItems();
	String expResult="REGULAR T-SHIRTS (YELLOW)";
	Assert.assertEquals(actualResult, expResult);
	addProdDetailToCart.removeFromcart();
	String actResp=addProdDetailToCart.validateRemovedOrNot();
	//addProdDetailToCart.validateRemovedOrNot();
	String expResp="Your shopping cart is empty!";
	Assert.assertEquals(actResp, expResp);
	System.out.println("TC003 is Pass");
  }
	
}
