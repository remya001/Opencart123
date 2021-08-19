package testCases;

//import org.apache.commons.lang3.RandomStringUtils;
//import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistartion extends BaseClass {
	
	// WebDriver driver;   //moved to BaseClass
	
/*	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	} */   //moved to BaseClass
	
	@Test(groups={"regression","master"})
	public void test_account_Registartion()
	{
		
		logger.info("starting TC_001_AccountRegistartion");
		
		try
		{
		//driver.get("https://demo.opencart.com/");
			
		//replace hard coded values in Test cases
			
		driver.get(rb.getString("appURL"));	
		logger.info("home page displayed");
		driver.manage().window().maximize();
		
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		logger.info("clicked on Myaccount");
		hp.clickRegister();
		logger.info("clicked on Register");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName("Remya");
		logger.info("provided first name");
		
		regpage.setLastName("kad");
		logger.info("provided last name");
		
		regpage.setEmail(randomestring()+"@gmail.com");
		logger.info("provided email");
		
		regpage.setTelephone("6788904556");
		logger.info("Provided Telephone ");
		
		regpage.setPassword("pol123");
		logger.info("Provided Password ");
		
		regpage.setConfirmPassword("pol123");
		logger.info("Provided Confrmed Password ");
		
		
		regpage.setPrivacyPolicy();
		logger.info("Set Privacy Policy ");
		
		regpage.clickContinue();
		logger.info("Clicked on Continue ");
		
		String confmsg= regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		//if(confmsg.equals("Your Account Has Been Created!!!!!"))  // for testing
		
			
		{   logger.info("Account Registration Success ");
			Assert.assertTrue(true);
		}
		
		else
		{   
			captureScreen(driver,"test_account_Registartion");  //capture screen shot (5.2)
			logger.error("Account Registration Failed ");
			
			Assert.assertTrue(false);
			
		}
		
		}
		
		catch(Exception e)
		{
			logger.fatal("Account Registration Failed ");
			Assert.fail();
		}
		
		logger.info("Finished TC_001_AccountRegistartion");
		
	}
	
}


	
/*	@AfterClass
	public void tearDown()
	{
		driver.close();
		
	} */    // moved to baseclass
	
	
/*	public String randomestring()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return(generatedString);
	}
	
}
	public int randomeNumber()
	{
		String generatedString2=RandomStringUtils.randomNumeric(5);
		return(Integer.parseInt(generatedString2));
		
		
	}*/  //moved to baseclass


