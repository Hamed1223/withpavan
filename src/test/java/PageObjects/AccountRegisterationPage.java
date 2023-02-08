package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterationPage extends BasePage{

	public AccountRegisterationPage(WebDriver driver) {   //  once we extends the base page we have creat a constractor of account registration to pass webdriver
		super(driver);
		
	}
	
	//  findelements
	
	@FindBy(name="firstname")
	 WebElement txtFirstname;
	
	@FindBy(name="lastname")
	WebElement txtlastname;
	
	@FindBy(name="email")
	 WebElement txtEmail;
	
	@FindBy(name="telephone")
	 WebElement txtTelephone;
	
	@FindBy(name="password")
	 WebElement txtPassword;
	
	@FindBy(name="confirm")
	 WebElement txtConfirmPassword;
	
	@FindBy(name="agree")
	 WebElement chkPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	 WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	 WebElement msgConfirmation;
	
	
	
	
	public void setfirstname(String fname){
		txtFirstname.sendKeys(fname);
		
	}
	public void setlastname(String lname){
		
		txtlastname.sendKeys(lname);
	}
	
    public void setemail(String email){   //  for email we need to use randomemile genrate class to .on runtime
    	
    	txtEmail.sendKeys(email);
    }
    
public void settelphone(String telephone){
    	
    	txtTelephone.sendKeys(telephone);
} 	
    	
public void setpassword(String password){
	
	txtPassword.sendKeys( password); 	
}
public void setconfrimpassword(String confrimpassword){
	
	txtConfirmPassword.sendKeys(confrimpassword);
	
}
public void setprivacypolicy(){
	
	 chkPolicy.click();
	 
}
public void ClickContinue(){
	
	btnContinue.click();
}

public String getConfirmationMsg(){   //  we need to use try catch blook to catch the exception
	
    try{
    	return (msgConfirmation.getText());
    }catch(Exception e)	{
    	
    	return (e.getMessage());
    }
    
	
			
		
	


	


	
	
}

	
	
	
	
	
	
	
}
