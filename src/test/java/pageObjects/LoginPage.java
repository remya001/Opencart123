package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)   //constructor
	{
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}

	
	//@FindBy(linkText="Login")
	//WebElement lnk_login;    //homepage
	
	@FindBy(id="input-email")
	WebElement txtemail;
	
	@FindBy(id="input-password")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
    @FindBy(xpath="//h2[normalize-space()='My Account']")
    WebElement msgHeading;
    
    public void setEmail(String email)
    {
    	txtemail.sendKeys(email);
    }
    
    public void setPassword(String pwd)
    {
    	txtPassword.sendKeys(pwd);
    }
    public void clickLogin()
    {
    	btnLogin.click();
    	
    }
    
    public boolean isMyaccountPageExists()
    {  
    	
    	try
    
    	{
    		return(msgHeading.isDisplayed());
    		
    	}
    	
    	catch(Exception e)
    	{
    		return(false);
    		
    	}
    	
    
    
    	
    }
    
    }
    
    

