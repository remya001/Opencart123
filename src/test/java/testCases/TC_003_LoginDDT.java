package testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.XLUtility;
public class TC_003_LoginDDT extends BaseClass{
	
	
	@Test(dataProvider="LoginData")
	public void test_LoginDDT(String email,String pwd,String exp)
	{
		logger.info("starting TC_003_LoginDDT");
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
			
			lp.setEmail(email);
			logger.info("Provided email"); 
			
			lp.setPassword(pwd);
			logger.info("provided password");
			
			lp.clickLogin();
			logger.info("clicked Login");
			
			boolean targetpage=lp.isMyaccountPageExists();
			
			if(exp.equals("Valid"))
				
			{
				if(targetpage==true)
				{
					logger.info("Login success");
					MyAccountPage myaccpage=new MyAccountPage(driver);
					myaccpage.clickLogout();
					Assert.assertTrue(true);
					
				}
				
				else
				{
					
					
					logger.info("Login failed");
					captureScreen(driver,"test_Login");  // capturing screenshot
					Assert.assertTrue(false);
					
				}
			}
			
			if(exp.equals("Invalid"))
			{
				if(targetpage==true)
				{
					MyAccountPage myaccpage=new MyAccountPage(driver);
					myaccpage.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{		
					logger.error("Login Failed ");
					Assert.assertTrue(true);
				}
			}
		}
			
		catch(Exception e)
		
		{
			
			Assert.fail();
		}
		
		logger.info(" Finished TC_003_LoginDDT ");
			
		}
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx";
		XLUtility xlutil=new XLUtility(path);
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++) 
			
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i,j);
				
			}
		}
		return logindata;
	}
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

			
			
			
			
			
			
			
			
			
			
			
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	


