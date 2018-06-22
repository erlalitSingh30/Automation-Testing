package testLoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageFactory.LoginPage;
import dataprovider.ConfigFileReader;;

public class LoginPageTest {
	WebDriver driver;
	LoginPage objLogin;
	ConfigFileReader cfg = new ConfigFileReader();
  @BeforeTest
  public void SetUpbrowser() {
	  if(cfg.getBrowserType().equals("Chrome")) 
	  {
	  System.setProperty("webdriver.chrome.driver",cfg.getDriverPath());
	  driver = new ChromeDriver();
	  driver.get(cfg.getApplicationUrl());
	  }
	  else if(cfg.getBrowserType().equals("MozillaFirefox")) 
	  {
		  System.setProperty("webdriver.firefox.driver",cfg.getDriverPathFirefox());
		  driver = new FirefoxDriver();
		  driver.get(cfg.getApplicationUrl());
	  }
	  
  }
  @Test
  public void LoginTest()
  {
	  objLogin = new LoginPage(driver);

	 objLogin.LoginToFlipkart();
	 
		//Verify login page title
	 String LoginPageTitle = objLogin.getLoginTitle();
	 //objLogin.getLoginTitle();
	 Assert.assertTrue(LoginPageTitle.toLowerCase().equals("lalit"));
	 
  }
}
