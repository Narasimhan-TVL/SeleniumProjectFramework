package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ClickForgottemPwdPOM {
	private WebDriver driver; 
	
	public ClickForgottemPwdPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li/a[text()='My Account']")
	private WebElement myAccount;	
	
	@FindBy(linkText="Login")
	private WebElement loginBtnUnderMyAccount;
	
	@FindBy(id="input-email")
	private WebElement emailId;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtnInHomeScreen;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Password']")
	private WebElement clickPasswordInHomeScreen;
	
	@FindBy(id="input-password")
	private WebElement passwordInChangepwdScreen;
	
	@FindBy(id="input-confirm")
	private WebElement confirmpwdInChangepwdScreen;
	
	@FindBy(xpath="//div[@class='pull-right']//input[@value='Continue']")
	private WebElement continueInChngePwdScreen;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement ER;
		
	public void clickMyAccount() {
		this.myAccount.click();
		System.out.println("entered clickMyAccount method");
	}
	
	public void clickLoginButtonUnderMyAccount() {
		this.loginBtnUnderMyAccount.click();
		System.out.println("entered clickLoginBtn method");		
	}
	
	public void enterCredentials(String mailId,String pwd) {
		this.emailId.sendKeys(mailId);
		this.password.sendKeys(pwd);
		this.loginBtnInHomeScreen.click();
	}
	
	public void clickPwdInHomeScreen() {
		this.clickPasswordInHomeScreen.click();		
	}
	public String changePassword(String newPwd) {
		this.passwordInChangepwdScreen.sendKeys(newPwd);
		this.confirmpwdInChangepwdScreen.sendKeys(newPwd);
		this.continueInChngePwdScreen.click();
		return newPwd;
	}
	
		
}
