package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	public HomePage(WebDriver driver){  // in the homepage finding the element and doing action methods
		super(driver);
	}
	
	//  finding elelements 
	
	
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement LnkMyaccount;
		
		
	@FindBy(linkText = "Register")
	WebElement LnkRegister;
	
	
	@FindBy(linkText="Login")
	WebElement linkLogin;
	
	//  Actions Methods
	
	public void ClickMyAccount(){
		LnkMyaccount.click();
	}
	
	public void ClickRegister(){
		LnkRegister.click();
	}
	
	public void ClickLogin(){
		
		linkLogin.click();
		
	}

}
