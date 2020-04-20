package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	By username=By.xpath("//input[@id='username']");
	By password=By.xpath("//input[@id='password']");
	By sumbitButton=By.xpath("//input[@id='Login']");
	
	By home=By.xpath("//span[contains(text(),'Home')]");
	By Accounts=By.xpath("//span[@class='slds-truncate'][contains(text(),'Accounts')]");
	By Contacts=		By.xpath("//span[@class='slds-truncate'][contains(text(),'Contacts')]");
	By Cases=		By.xpath("//span[@class='slds-truncate'][contains(text(),'Cases')]");
	By Reports=		By.xpath("//span[@class='slds-truncate'][contains(text(),'Reports')]");
	By Dashboards=		By.xpath("//span[@class='slds-truncate'][contains(text(),'Dashboards')]");


	
	public LoginPage(WebDriver driver1) {
		this.driver=driver1;
		PageFactory.initElements(driver1, this);
	}
	public void userNameClick(String uid) {
		driver.findElement(username).sendKeys(uid);
	}
	public void passwordClick(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	public void submitButtonClick() {
		driver.findElement(sumbitButton).click();
	}
	
}
