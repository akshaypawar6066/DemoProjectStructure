package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Browser;
import pom.LoginPage;

public class LoginTest extends Browser {
	Browser browser;
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		driver = launchBrowser("edge");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void loginTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginSystem("Admin", "admin123");
		loginPage.verifyLoginSyystem("/index");
	}

	@Test
	public void logoutTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginSystem("Admin", "admin123");
		loginPage.logoutApplication();
		loginPage.verifyLogoutSuccesfully("/login");
	}

	@AfterMethod
	public void quitBrowser() {
		driver.close();
	}

}
