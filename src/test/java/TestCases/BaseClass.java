package TestCases;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	//  we creat base class becuase of reusable in each class and we need to extends this in each test case
	
	public ResourceBundle rb;
	
	public static WebDriver driver;  //  we need to use public to access it every where
	
	
	public Logger logger; // for logging and we need to im
	@BeforeClass
	@Parameters({"browser"})
	public void setup(){
		
		
		rb=ResourceBundle.getBundle("config");  // this will used insted of url and we creating config.properties under resource to setup url
		
		
		/*if(br.equals("chrome")){
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			}
			else if(br.equals("edge")){
				
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
			else */
				
			
				
		
	      logger=LogManager.getLogger(this.getClass()); // this is for the cureent class 
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		
	}
	public String randomeString(){
		
		String generatedString=RandomStringUtils.randomAlphabetic(5); // we can change the number of string by change the number
		return (generatedString);
	}	
		
	public String randomNumber(){
		String generatedString2=RandomStringUtils.randomNumeric(10);
				
	 return (generatedString2);
	}
	
	public String randomAlphaNumeric(){
		
		String st = RandomStringUtils.randomAlphabetic(4); // we use this for the emaile 
		String num =RandomStringUtils.randomNumeric(3);
		return (st+"@"+num);
	}
	
	
	
	@AfterClass
	void teardown(){
		
		driver.quit();
		
	}	
		public String captureScreen(String tname)throws IOException{
			
			String timeStamp=new SimpleDateFormat("YYYYMMddhhmmss").format(new Date());
			
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir")+ "\\screenshots\\"+tname+"_"+ timeStamp + ".png";
					
					
					try {
						FileUtils.copyFile(source, new File(destination));
						
						
					}catch (Exception e){
					 e.getMessage();
					}
			          return destination ;
			
		
		
		
		
		
	}

}
