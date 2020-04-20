package com.testcases;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.UtilLib;

public class TestCase01 {
	
	final static Logger logger = Logger.getLogger(TestCase01.class);
	
	
	public static WebDriver driver;
	/*
	 * @Test public void login() { System.setProperty("webdriver.chrome.driver",
	 * "C:\\Users\\Shravan\\eclipse-workspace\\SeleniumPOC1\\Drivers\\chromedriver77.exe"
	 * ); driver= new ChromeDriver();
	 * driver.get("https://login.salesforce.com/?locale=in");
	 * driver.findElement(By.xpath("//input[@id='username']")).sendKeys(
	 * "shravanece061@gmail.com");
	 * driver.findElement(By.xpath("//input[@id='password']")).sendKeys(
	 * "Infosys1234$");
	 * 
	 * driver.findElement(By.xpath("//input[@id='Login']")).click();; }
	 */
	
	@BeforeTest
	public void setup() {
		BasicConfigurator.configure();
		logger.info("test case started");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shravan\\eclipse-workspace\\SeleniumPOC1\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		// handling SSL certificates in Chrome
		
		/*
		 * DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome();
		 * handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true); driver=
		 * new ChromeDriver(handlSSLErr);
		 */
		driver.get("https://login.salesforce.com/?locale=in");
		logger.info("browser opened started");
		logger.warn("logger warning message");
		logger.debug("logger debug message");
	}
	
	@Parameters({"username","password"})
	public void login(@Optional("credentials") String username,String password) {
		System.out.println("method with data provider is starting");
		LoginPage lp= new LoginPage(driver);
		UtilLib ul= new UtilLib(driver);
		lp.userNameClick(username);
		lp.passwordClick(password);
		lp.submitButtonClick();
		ul.ImplicitWait(10);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomePage Hp=new HomePage(driver);
		Hp.AppLauncherClick();
		Hp.ServiceOptionClick();
		ul.ImplicitWait(20);
		 //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Hp.AccountsClick();
		ul.ImplicitWait(10);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Hp.NewAccountCLick();
		Hp.EnterAccountName("Shravan11");
	}
	
	@Test
	public void Login() {
		System.out.println("method with data provider is starting");
		LoginPage lp= new LoginPage(driver);
		UtilLib ul= new UtilLib(driver);
		lp.userNameClick("shravanece062@gmail.com");
		logger.info("username entered");
		lp.passwordClick("shravan123$");
		logger.info("password entered");
		lp.submitButtonClick();
		ul.ImplicitWait(10);
		 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 HomePage Hp=new HomePage(driver);
			Hp.AppLauncherClick();
			logger.info("clicked on app launcher");
			Hp.ServiceOptionClick();
			logger.info("clicked on service option");
			ul.ImplicitWait(20);
			 //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(dataProvider="AccountCreation" )
	public void loginDataProvider( String SNo,String AccountName) {
		HomePage Hp=new HomePage(driver);
		UtilLib ul= new UtilLib(driver);
		Hp.AccountsClick();
		ul.ImplicitWait(10);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Hp.NewAccountCLick();
		Hp.EnterAccountName(AccountName);
		System.out.println("Account for"+SNo+"is created="+AccountName);
	}
	
@DataProvider(name="AccountCreation")
public Object[][] getDataFromDataProvider(){
	return new Object[][] {
		{"1","Shravan8April"},
		{"2","Shravan9April"},
		{"3","Shravan10April"}
	};
	
}



@DataProvider(name = "dp")
public Object[][] createData(Method m) {
  System.out.println(m.getName());  // print test method name
  return new Object[][] { new Object[] { "Cedric" }};
}
 
@Test(dataProvider = "dp")
public void test1(String s) {
	System.out.println(s);
}
 
@Test(dataProvider = "dp",dependsOnGroups= {"g.*"})
public void test2(String s) {
	System.out.println(s);
}

@Test(groups= {"g1"})
public void test3() {
	System.out.println("this is a test method 3");
}
@Test(groups= {"g2"})
public void test4() {
	System.out.println("this is a test method 4");
}

@Test(groups= {"g2"},threadPoolSize = 3, invocationCount = 10,  timeOut = 10000)
public void test5() {
	System.out.println("this is a test method 5");
}

@Test(groups= {"g2"})
public void test6() {
	System.out.println("this is a test method 6");
}

@Test(groups= {"g2"})
public void test7() {
	System.out.println("this is a test method 7");
}

@Test(groups= {"g2"})
public void test8() {
	System.out.println("this is a test method 8");
}

@Test(groups= {"g2"})
public void test9() {
	System.out.println("this is a test method 9");
}

@Test(groups= {"g2"})
public void test10() {
	System.out.println("this is a test method 10");
}



}
