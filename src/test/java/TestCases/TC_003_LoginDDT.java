package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import Utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class) // becuse the class is in other location we need to provide the location
	public void test_loginDDT(String email, String password, String exp){
		
	
	logger.info("*** Starting TC_003_LoginDDT **********");

	try{
	HomePage hp = new HomePage(driver);
	hp.ClickMyAccount();
	hp.ClickLogin();
	
	LoginPage lp = new LoginPage(driver);
	
	lp.setEmail(rb.getString("email"));
	lp.setPassword(rb.getString("password"));
	lp.clickLogin();
	
	logger.info("*****get report from login page******");
	
	MyAccountPage macc=new MyAccountPage (driver);
	
	boolean targetpage=macc.isMyAccountPageExists();

	
	if(exp.equals("valid")){
		
		if(targetpage==true){
			
			macc.ClickLogout();
			
			Assert.assertTrue(true);
		}
		else{
			
			//Assert.assertTrue(false); we can rwrite like this 
			Assert.fail();
		}
			
	}
	
     if(exp.equals("Invalid")){
		
		if(targetpage==true){
			
			macc.ClickLogout();
			Assert.assertTrue(false);
		}
		else{
			
			Assert.assertTrue(true);
		}
     }
		
     
     
		}catch (Exception e){
				
				
				
			
		
			
		
	
	}
	
		
		

}

		
		
}		
		
	


