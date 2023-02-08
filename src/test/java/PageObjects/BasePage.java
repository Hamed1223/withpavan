package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	WebDriver driver;
	
	public BasePage(WebDriver driver){  //  we are going to import webdriver in our Basepage
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
