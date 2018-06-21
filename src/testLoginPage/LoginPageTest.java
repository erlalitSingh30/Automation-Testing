package testLoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageFactory.LoginPage;;

public class LoginPageTest {
	WebDriver driver;
	LoginPage objLogin;
  @BeforeTest
  public void SetUpbrowser() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\lalit.singh\\Downloads\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://flipkart.com");
  }
  @Test
  public void LoginTest()
  {
	  objLogin = new LoginPage(driver);

	 objLogin.LoginToFlipkart();
	 
		//Verify login page title
	 String LoginPageTitle = objLogin.getLoginTitle();
	 objLogin.getLoginTitle();
	 Assert.assertTrue(LoginPageTitle.toLowerCase().equals("lalit"));
	 
  }
}
