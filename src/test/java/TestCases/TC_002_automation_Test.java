package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;

public class TC_002_automation_Test extends BaseClass {
	
	@Test
	public void test_login(){
		
		logger.info("***** Strating TC_002_LoginTest*****");
		try {
		HomePage hp = new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("emailpassword"));
		lp.clickLogin();
		logger.info("*****get report from login page******");
		
		MyAccountPage macc=new MyAccountPage (driver);
		
		boolean targetpage=macc.isMyAccountPageExists();
		Assert.assertEquals(targetpage,true, "Invalid login data");
	}
		catch (Exception e){
			
			Assert.fail();
		}
		logger.info("***** Finished TC_002_LoginTest ******"
				+ "");
	}

}
