package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProdDetailIntoCartPOM {
	private WebDriver driver;
	
	public AddProdDetailIntoCartPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='image']//a//img")
	private WebElement regularTShirtsYellow; 

	@FindBy(xpath="//select[@name='option[382]']")
	private WebElement chestSize;
	
	@FindBy(xpath="//button[@type='button' and text()='Add to Cart' ]")
	private WebElement clickAddToCartBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement msgAfterAddToCart;

	@FindBy(xpath="//div[@class='btn-group btn-block']")
	private WebElement itemSelectedbtn;

	@FindBy(xpath="//p[@class='text-right']//strong[text()=' View Cart']")
	private WebElement viewcart;
	
	/*@FindBy(xpath="//div[@class='table-responsive']//table[@class='table table-bordered']//tbody//td[1]//img")
	private WebElement chkcartTableImg;*/
	
	@FindBy(linkText="REGULAR T-SHIRTS (YELLOW)")
	private WebElement tShirts;
	
	@FindBy(xpath="//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	private WebElement clickCartBtn;
	
	
	/*@FindBy(xpath="//div[@class='table-responsive']//table[@class='table table-bordered']//tbody//tr//td[2]")
	private WebElement ProductName;
	
	@FindBy(xpath="//div[@class='table-responsive']//table[@class='table table-bordered']//thead//tr//td[3]")
	private WebElement model;
	
	@FindBy(xpath="//div[@class='table-responsive']//table[@class='table table-bordered']//thead//tr//td[4]")
	private WebElement quantity;*/
	
	//@FindBy(xpath="//button[@title='Remove']")
	@FindBy(xpath="//i[@class='fa fa-times']")
	private WebElement remove;
	
	@FindBy(xpath="//div[@id='content']/p")
	private WebElement actualResp;
		
	public void clickregularTShirtsYellow() {
		this.regularTShirtsYellow.click();
	}
	
	public void selectChestSize(String chosenChestSize) {
		this.chestSize.click();
		//WebElement chestSize=driver.findElement(By.id("products-orderby"));
		Select sel=new Select(chestSize);
		//sel.selectByIndex(2);
		//sel.selectByValue("http://demowebshop.tricentis.com/books?orderby=6");
		sel.selectByVisibleText(chosenChestSize);
		System.out.println("Chosen Chest size is "+chosenChestSize);
	}
	
	public void clickAddToCartButton() {
		this.clickAddToCartBtn.click();
		String expResp=this.msgAfterAddToCart.getText();
		System.out.println("Msg after adding to cart is "+expResp);
		String actResp="Success: You have added REGULAR T-SHIRTS (YELLOW) to your shopping cart!\n" + 
				"×";
		Assert.assertEquals(actResp, expResp);
		System.out.println("chosen item is added to your cart");
	}
	
	public void veiwCart() {
		this.itemSelectedbtn.click();
		System.out.println("Entered Viewcart mtd");
	}
	
	public void viewCartItems() {
		this.viewcart.click();
	}
	public String validateCartItems() {
		String tShirt=this.tShirts.getText();
		System.out.println("tShirt text vakue is "+tShirt);
		//String pName=this.ProductName.getText();
		//String model=this.model.getText();
		System.out.println("Completed validating the added cart items!!");
		return tShirt;		
	}	
	public void removeFromcart() {
		Actions act = new Actions(driver);
		act.moveToElement(clickCartBtn).click().perform();
		act.moveToElement(remove).click().perform();
		System.out.println("Removed the cart items successfully !!");
	}
	public String validateRemovedOrNot() {
		if(actualResp.isDisplayed()) {
			System.out.println("text is displayed");
		}
		else {
			System.out.println("text is not displayed");
		}
		String aResp=this.actualResp.getText();
		System.out.println("ActualResp is: "+aResp);
		return aResp;
	}
	
}
