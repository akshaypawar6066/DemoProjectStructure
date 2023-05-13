package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
  public LoginPage(WebDriver driver)
  {
	  this.driver=driver;
	  PageFactory.initElements(driver,this);
  }
  
  @FindBy(how=How.XPATH,using="//input[@placeholder='Username']")
  protected WebElement userName;
  
  @FindBy(how =How.XPATH, using="//input[@placeholder='Password']")
  protected WebElement password;

  
  @FindBy(xpath="//div[@class='oxd-form-actions orangehrm-login-action']/button")
 protected WebElement signInButton;  
  
  @FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
 protected WebElement loggedUser;
  
  @FindBy(xpath="//a[normalize-space()='Logout']")
 protected WebElement logoutButton;
  
 
  public void loginSystem(String user, String pass)
  {
	  userName.sendKeys(user);
	  password.sendKeys(pass);
	  signInButton.click();
  }
  public void verifyLoginSyystem(String expectedUrlEndPoint)
  {
	 String url=driver.getCurrentUrl();
	 if(url.endsWith(expectedUrlEndPoint))
	 {
		 System.out.println("Able to login succesfully");
	 }
	 else
	 {
		 System.out.println("Application not able to login succeesfully");
		 Assert.assertTrue(false);
	 } 
	
  }
  public void logoutApplication()
  {
	  loggedUser.click();
	  logoutButton.click();
  }
  
  public void verifyLogoutSuccesfully(String expectedUrlEndPoint)
  {
	  String url=driver.getCurrentUrl();
	  if(url.endsWith(expectedUrlEndPoint))
	  {
		  System.out.println("Application is able to logout succesfully");
	  }
	  else
	  {
		  System.out.println("Application not able to logout succesfully");
	  }
  }
}
