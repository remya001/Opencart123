package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass {
	
	@Test(groups={"sanity","master"})
	public void test_Login()
	{
		logger.info("started TC_002_Login ");
		
		
		try
		{
		driver.get(rb.getString("appURL"));
		logger.info("Home Page Displayed");
		
		driver.manage().window().maximize();
		
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		logger.info("clicked on Myaccount ");
		
		hp.clickLogin();
		logger.info(" clicked on Login");
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		logger.info("Provided email"); 
		
		lp.setPassword(rb.getString("password"));
		logger.info("provided password");
		
		lp.clickLogin();
		logger.info("clicked Login");
		
		boolean targetpage=lp.isMyaccountPageExists();
		
		if(targetpage)
		{
			Assert.assertTrue(true);
			logger.info("Login success");
			
		}
		
		else
		{
			
			
			logger.info("Login failed");
			captureScreen(driver,"test_Login");  // capturing screenshot
			Assert.assertTrue(false);
			
		}
		}
		
		catch(Exception e)
		{  
			logger.info("Login failed");
			Assert.fail();
		}
		
		logger.info("Finished TC_002_Login");
		
		
		
		
	}
	

}
