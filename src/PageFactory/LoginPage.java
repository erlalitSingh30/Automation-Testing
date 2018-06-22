package PageFactory;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dataprovider.ConfigFileReader;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;;

public class LoginPage extends CommonVariables {
//CommonVariables C1 = new CommonVariables();
	ConfigFileReader cfg = new ConfigFileReader();
  WebDriver driver;
  @FindBy(xpath=".//*[@href='/account/login?ret=/']")
  WebElement LoginButton;
  @FindBy(xpath=".//*[@class='b5konl']")
  WebElement UserID;
  @FindBy(xpath=".//*[@type='password']")
  WebElement Password;
  @FindBy(xpath=".//*[@type='submit']")
  WebElement LoginBtn;
  @FindBy(xpath=".//*[@class='_2cyQi_']")
  WebElement titleText;
  
  public LoginPage(WebDriver driver) 
  {
	  this.driver = driver;
	  
	//This initElements method will create all WebElements
	  PageFactory.initElements(driver, this);
  }
  //Set user Name in the UserID textBox
  public void setUserID()
  {
	  //LoginButton.click();
	  new Actions(driver).click(LoginButton).build().perform();
	  new Actions(driver).sendKeys(UserID, super.userID).build().perform();
	  //UserID.click();
	  //UserID.sendKeys(C1.userID);
  }
  //Set Password
  public void setPassword()
  {
	  //UserID.sendKeys(C1.password);
	  new Actions(driver).click(Password).build().perform();
	  driver.manage().timeouts().implicitlyWait(cfg.getImplicitlyWait(), TimeUnit.SECONDS);
	  new Actions(driver).sendKeys(Password, super.password).build().perform();;
  }
  ////Click on login button
  public void ClickLoginBtn()
  {
	  //LoginBtn.click();
	  new Actions(driver).sendKeys(Keys.ENTER).build().perform();
	  new Actions(driver).click(LoginButton).build().perform();
  }
  public String getLoginTitle()
  {

	 return titleText.getText();

  }
  /**

   * This POM method will be exposed in test case to login in the application

   * @param strUserName

   * @param strPasword

   * @param LoginBtn

   */
  public void LoginToFlipkart()
  {
	  //Fill username
	  this.setUserID();
	  //Fill Password
	  this.setPassword();
	  //Click on LoginButton
	  this.ClickLoginBtn();
  }

}
