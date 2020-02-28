package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.common.WebDriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage {

	// WebElements
	@FindBy(id = "txtUsername")
	WebElement vUserName;
	@FindBy(id = "txtPassword")
	WebElement vPaswd;
	@FindBy(id = "btnLogin")
	WebElement vBtnLogin;

	// Explicit wait
	WebDriverWait objwait = new WebDriverWait(WebDriverFactory.getWebDriver(), 10);

	// Constructor to initialize webelement
	public LoginPage() {
		PageFactory.initElements(WebDriverFactory.getWebDriver(), this);
	}

	// page loaded method
	
	public LoginPage isLoginPageLoaded() {
		objwait.until(ExpectedConditions.elementToBeClickable(vBtnLogin));
		objwait.until(ExpectedConditions.elementToBeClickable(vPaswd));
		objwait.until(ExpectedConditions.elementToBeClickable(vUserName));
		return this;
	}

	// Generic methods
	//mapped to cucumber
	@When("uses enters user name as {string} and password as {string} and click on login button")
	public HomePageAfterLogin checkValidLogin(String user, String paswd) {
		vUserName.sendKeys(user);
		vPaswd.sendKeys(paswd);
		vBtnLogin.click();

		// on successful login it should go to homepage.
		return (new HomePageAfterLogin().isHomePageLoaded());
	}

	//cucumber BDD framework
	@Given("user navigate to orange hrm URL")
	public void user_navigate_to_loginpage() {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverFactory.getWebDriver().get("http://127.0.0.1/orangehrm-3.3.1/symfony/web/index.php/auth/login");
	    
	} 
}
