package TestCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountRegisterationPage;
import PageObjects.HomePage;

public class TC_001_automation_test_case extends BaseClass {
	
	//  in the test case now we have to make an opject of homepage and Account Registeration page
	 
	
	
	
	@Test
	   void test_account_Registration() throws InterruptedException{
		
		logger.info("**** TC_001_automation_test_case *****");
		
		HomePage hp = new HomePage(driver); //  becuase this homepage is located in other package we are going to imported 
		try{
		hp.ClickMyAccount();
		hp.ClickRegister();
		
		logger.info(" clikecd in my link");
		
		AccountRegisterationPage ar = new AccountRegisterationPage(driver);
		
		ar.setfirstname(randomeString().toUpperCase());
		//  we called this 
		ar.setlastname(randomeString().toUpperCase());
		
	   //ar.setemail(randomeString()+"@gmail.com");
		
		ar.setemail("rashidyhamed35@gmail.com");
	   
	   ar.settelphone("1234234890");
	  // String password=randomAlphaNumeric(); // this methods is to create random password for both 
	   ar.setpassword("1234hare");
	   
	   //ar.setconfrimpassword(password); // we can use randomestring in password to
	   ar.setconfrimpassword("1234hare");
	   ar.setprivacypolicy();
	   
	   ar.ClickContinue();
	   
	  String confmsg= ar.getConfirmationMsg();   //  we need to use assert to confirm the actual massage we are getting or not
	  logger.info("validating expected massaige");  // every where is importanted we use logger 
	  Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	} 
   
	catch(Exception e){
		
		Assert.fail();
		
		logger.info("test is failed");
		logger.debug("we can use debug as well");

	}		
	}	
}
